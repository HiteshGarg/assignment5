/**
 * 
 */
package com.nagarro.assignment5.user.pojo;

/**
 * @author hiteshgarg
 *
 */
public class Employee extends User {

	/* (non-Javadoc)
	 * @see com.nagarro.assignment5.user.pojo.User#getDiscount(java.lang.Integer)
	 */

	public Integer getDiscount(Integer price) {
		return (int) (price * 0.7);
	}

}
