package com.nagarro.assignment5.product.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.assignment5.constants.Constants;
import com.nagarro.assignment5.exception.CustomException;
import com.nagarro.assignment5.product.pojo.ProductDetails;
import com.nagarro.assignment5.product.services.ProductRetrieverService;

/**
 * Servlet implementation class ProductRetriever
 */
@WebServlet("/ProductRetriever")
public class ProductRetriever extends HttpServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6934173440913782991L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductRetriever() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute(Constants.SESSION_USER_ID)== null){
			request.setAttribute(Constants.INVALID_ATTEMPT, Constants.LOGIN_TO_ACCESS);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		try {
			List<ProductDetails> productList = new ProductRetrieverService()
					.retrieveProductList();
			if(productList!=null){
			request.setAttribute("productList", productList);
			}else{
				request.setAttribute(Constants.ERRORS, Constants.PRODUCTS_UNAVAILABLE);
			}
		} catch (CustomException exception) {
			request.setAttribute(Constants.ERRORS, Constants.UNEXPECTED_ERROR);
		} finally {
			request.getRequestDispatcher("userHome.jsp").forward(
					request, response);
		}
	}

}
