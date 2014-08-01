/**
 * 
 */
package com.nagarro.assignment5.product.services;

import java.util.List;

import com.nagarro.assignment5.exception.CustomException;
import com.nagarro.assignment5.product.dao.ProductDao;
import com.nagarro.assignment5.product.pojo.ProductDetails;

/**
 * @author hiteshgarg
 * 
 */
public class ProductRetrieverService {

	public List<ProductDetails> retrieveProductList() throws CustomException {

		List<ProductDetails> prodList = null;
		prodList = new ProductDao().getProductList();
		return prodList;
	}

}
