/**
 * 
 */
package com.nagarro.assignment5.user.pojo;

import java.util.Date;

/**
 * @author hiteshgarg
 *
 */
public class AffiliateUser extends User {

	/* (non-Javadoc)
	 * @see com.nagarro.assignment5.user.pojo.User#getDiscount(java.lang.Integer)
	 */

	public Integer getDiscount(Integer price) {
		Date currentDate = new Date();
		System.out.println(currentDate);
		long diff = currentDate.getTime() - getJoiningDate().getTime();
		int days = (int)diff/(1000*60*60*24);
		System.out.println(days);
		return (int) (price * 0.9);
	}
}
