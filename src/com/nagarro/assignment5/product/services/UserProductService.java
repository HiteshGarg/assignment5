/**
 * 
 */
package com.nagarro.assignment5.product.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.nagarro.assignment5.constants.Constants;
import com.nagarro.assignment5.exception.CustomException;
import com.nagarro.assignment5.product.dao.ProductDao;
import com.nagarro.assignment5.product.dto.ProductDto;
import com.nagarro.assignment5.product.pojo.ProductDetails;
import com.nagarro.assignment5.user.UserFactory;
import com.nagarro.assignment5.user.dao.UserDao;
import com.nagarro.assignment5.user.pojo.User;

/**
 * @author hiteshgarg
 * 
 */
public class UserProductService {
	/**
	 * 
	 * @param request
	 * @return
	 * @throws CustomException
	 */
	public ProductDto getFinalPriceWithList(HttpServletRequest request)
			throws CustomException {
		ProductDto prodDto = new ProductDto();
		String[] itemIdList = request.getParameterValues("items");
		if (null == itemIdList) {
			throw new CustomException(Constants.SELECT_SOME_PRODUCT);
		}
		getSelectedProductList(prodDto, itemIdList);

		try {
			for (ProductDetails product : prodDto.getUserProductList()) {
				Integer quantity = Integer.parseInt(request
						.getParameter(product.getItemId().toString()));
				if (quantity < 1) {
					throw new CustomException(Constants.INAPPROPRIATE_QUANTITY);
				}
				prodDto.getItemQuantity().add(quantity);
			}
		} catch (NumberFormatException exception) {
			throw new CustomException(Constants.INAPPROPRIATE_QUANTITY);
		}

		calculateDiscountOnProducts(request, prodDto);

		return prodDto;
	}

	/**
	 * 
	 * @param request
	 * @param prodDto
	 * @throws CustomException
	 */
	private void calculateDiscountOnProducts(HttpServletRequest request,
			ProductDto prodDto) throws CustomException {

		Integer userId = (Integer) request.getSession().getAttribute(
				Constants.SESSION_USER_ID);
		User user = UserDao.getUserById(userId);
		String userType = user.getType();
		UserFactory factory = new UserFactory();
		user = factory.createUser(userType);
		if (null == user) {
			throw new CustomException(Constants.UNEXPECTED_ERROR);
		}
		user.setJoiningDate(user.getJoiningDate());

		for (int i = 0; i < prodDto.getUserProductList().size(); i++) {

			int price = prodDto.getUserProductList().get(i).getPrice()
					* prodDto.getItemQuantity().get(i);

			if (!prodDto.getUserProductList().get(i).getCategory()
					.equalsIgnoreCase(Constants.GROCERY)) {
				price = user.getDiscount(price);
			}

			prodDto.setFinalCost(prodDto.getFinalCost() + price);
			prodDto.getFinalPriceList().add(price);
		}

		prodDto.setFinalCost(prodDto.getFinalCost()
				- ((int) (prodDto.getFinalCost() / 100) * 5));
	}

	/**
	 * 
	 * @param dto
	 * @param itemIdList
	 * @throws NumberFormatException
	 * @throws CustomException
	 */
	private void getSelectedProductList(ProductDto dto, String[] itemIdList)
			throws CustomException {

		List<ProductDetails> productList = dto.getUserProductList();
		ProductDao dao = new ProductDao();
		try {
			for (String str : itemIdList) {
				ProductDetails product = dao.getProductById(Integer
						.parseInt(str));
				productList.add(product);
			}
		} catch (NumberFormatException exception) {
			throw new CustomException(Constants.UNEXPECTED_ERROR);
		} catch (CustomException exception) {
			throw new CustomException(Constants.ERROR_CONTACTING_SERVER);
		}
	}

}
