package com.nagarro.assignment5.product.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.assignment5.constants.Constants;
import com.nagarro.assignment5.exception.CustomException;
import com.nagarro.assignment5.product.dto.ProductDto;
import com.nagarro.assignment5.product.services.UserProductService;

/**
 * Servlet implementation class UserSelectedProducts
 */
@WebServlet("/UserSelectedProducts")
public class UserSelectedProducts extends HttpServlet {
       
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7542617728528915649L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public UserSelectedProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute(Constants.SESSION_USER_ID)== null){
			request.setAttribute(Constants.INVALID_ATTEMPT, Constants.LOGIN_TO_ACCESS);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		ProductDto dto = null;
		try{
			dto = new UserProductService().getFinalPriceWithList(request);
			request.setAttribute("dto", dto);
			request.getRequestDispatcher("UserProduct.jsp").forward(request, response);
		}catch (CustomException exception) {
			request.setAttribute(Constants.ERRORS, exception.getErrorMessage());
			request.getRequestDispatcher("ProductRetriever").forward(request, response);
		}
	}

}
