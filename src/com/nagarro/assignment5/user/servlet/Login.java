package com.nagarro.assignment5.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.assignment5.constants.Constants;
import com.nagarro.assignment5.exception.CustomException;
import com.nagarro.assignment5.user.services.LoginValidator;

/**
 * Servlet implementation class LoginValidator
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6847180625891135357L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		
		try {
			Boolean validated = new LoginValidator().validateLogin(request);
			if (validated) {
				request.getRequestDispatcher("ProductRetriever")
						.forward(request, response);
			} else {
				request.setAttribute(Constants.INVALID_ATTEMPT,
						"Login Credentials are wrong ... Please try again..");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (CustomException exception) {
			request.setAttribute(Constants.INVALID_ATTEMPT, Constants.UNEXPECTED_ERROR);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
