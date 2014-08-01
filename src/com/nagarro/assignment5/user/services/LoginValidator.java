/**
 * 
 */
package com.nagarro.assignment5.user.services;

import javax.servlet.http.HttpServletRequest;

import com.nagarro.assignment5.constants.Constants;
import com.nagarro.assignment5.exception.CustomException;
import com.nagarro.assignment5.user.dao.UserDao;

/**
 * @author hiteshgarg
 * 
 */
public class LoginValidator {

	public boolean validateLogin(HttpServletRequest request)
			throws CustomException {
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		Boolean validated = false;
		try {
			Integer userId = UserDao.validateUser(uname, pwd);
			if (null != userId) {
				validated = true;
				request.getSession().setAttribute(Constants.SESSION_USER_ID,
						userId);
			}
		} catch (CustomException exception) {
			throw exception;
		}
		return validated;
	}
}