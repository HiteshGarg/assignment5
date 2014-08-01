/**
 * 
 */
package com.nagarro.assignment5.user;

import com.nagarro.assignment5.constants.Constants;
import com.nagarro.assignment5.user.pojo.AffiliateUser;
import com.nagarro.assignment5.user.pojo.Customer;
import com.nagarro.assignment5.user.pojo.Employee;
import com.nagarro.assignment5.user.pojo.User;

/**
 * @author hiteshgarg
 *
 */
public class UserFactory {

	User userRef=null;
	
	public User createUser(String userType){
		switch (userType.toLowerCase()) {
		case Constants.EMPLOYEE:
			userRef = new Employee();
			break;
		case Constants.CUSTOMER:
			userRef = new Customer();
			break;
		case Constants.AFFILIATE:
			userRef = new AffiliateUser();
			break;

		default:
			break;
		}
		return userRef;
	}
}
