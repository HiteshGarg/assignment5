/**
 * 
 */
package com.nagarro.assignment5.user.pojo;

import java.util.Calendar;

/**
 * @author hiteshgarg
 *
 */
public class Customer extends User {

	/* (non-Javadoc)
	 * @see com.nagarro.assignment5.user.pojo.User#getDiscount(java.lang.Integer)
	 */
	
	public Integer getDiscount(Integer price) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -2);

		if(cal.getTime().after(getJoiningDate())){
			price = (int)(price * 0.95);
		}
		return price;
	}

}
