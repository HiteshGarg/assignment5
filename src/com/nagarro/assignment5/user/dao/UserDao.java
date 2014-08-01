/**
 * 
 */
package com.nagarro.assignment5.user.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.nagarro.assignment5.constants.Constants;
import com.nagarro.assignment5.exception.CustomException;
import com.nagarro.assignment5.user.pojo.User;
import com.nagarro.assignment5.utilities.HibernateUtil;

/**
 * @author hiteshgarg
 * 
 */
public class UserDao {

	public static Integer validateUser(String uname, String pwd)
			throws CustomException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = null;
		Integer userId = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("userName", uname));
			criteria.add(Restrictions.eq("password", pwd));
			List<User> user = criteria.list();
			if (0 != user.size()) {
				userId = user.get(0).getUserId();
			}
			session.getTransaction().commit();
		} catch (HibernateException exception) {
			exception.printStackTrace();
			throw new CustomException(Constants.ERROR_CONTACTING_SERVER);
		}
		return userId;
	}

	public static User getUserById(Integer userId) throws CustomException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = null;
		User user = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("userId", userId));
			List<User> userList = criteria.list();
			if (0 != userList.size()) {
				user = userList.get(0);
			}
			session.getTransaction().commit();
		} catch (HibernateException exception) {
			exception.printStackTrace();
			throw new CustomException(Constants.ERROR_CONTACTING_SERVER);
		}
		return user;

	}

}
