/**
 * 
 */
package com.nagarro.assignment5.product.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.nagarro.assignment5.constants.Constants;
import com.nagarro.assignment5.exception.CustomException;
import com.nagarro.assignment5.product.pojo.ProductDetails;
import com.nagarro.assignment5.utilities.HibernateUtil;

/**
 * @author hiteshgarg
 * 
 */
public class ProductDao {

	public List<ProductDetails> getProductList() throws CustomException {
		Session session = null;
		Transaction tx = null;
		List<ProductDetails> productList = null; 
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			productList = session.createCriteria(ProductDetails.class).list();
			tx.commit();
		} catch (HibernateException e) {
			throw new CustomException(Constants.ERROR_CONTACTING_SERVER);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return productList;
	}

	public ProductDetails getProductById(Integer itemId) throws CustomException {
		Session session = null;
		Transaction tx = null;
		List<ProductDetails> productList = null;
		ProductDetails product = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			productList = session.createCriteria(ProductDetails.class)
					.add(Restrictions.eq("itemId", itemId)).list();
			if (productList.size() == 1) {
				product = productList.get(0);
			} else {
				productList = null;
			}
			tx.commit();
		} catch (HibernateException e) {
			throw new CustomException(Constants.ERROR_CONTACTING_SERVER);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return product;
	}
}
