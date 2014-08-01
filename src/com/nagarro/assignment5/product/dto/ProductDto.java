package com.nagarro.assignment5.product.dto;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.assignment5.product.pojo.ProductDetails;

public class ProductDto {

	private List<ProductDetails> userProductList;
	private List<Integer> finalPriceList;
	private List<Integer> itemQuantity;
	Integer finalCost;
	
	public ProductDto() {
		userProductList = new ArrayList<>();
		finalPriceList = new ArrayList<>();
		itemQuantity = new ArrayList<>();
		finalCost = 0;
	}
	
	/**
	 * @return the finalCost
	 */
	public Integer getFinalCost() {
		return finalCost;
	}


	/**
	 * @param finalCost the finalCost to set
	 */
	public void setFinalCost(Integer finalCost) {
		this.finalCost = finalCost;
	}
	
	/**
	 * @return the itemQuantity
	 */
	public List<Integer> getItemQuantity() {
		return itemQuantity;
	}
	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public void setItemQuantity(List<Integer> itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	/**
	 * @return the userProductList
	 */
	public List<ProductDetails> getUserProductList() {
		return userProductList;
	}
	/**
	 * @param userProductList the userProductList to set
	 */
	public void setUserProductList(List<ProductDetails> userProductList) {
		this.userProductList = userProductList;
	}
	/**
	 * @return the finalPriceList
	 */
	public List<Integer> getFinalPriceList() {
		return finalPriceList;
	}
	/**
	 * @param finalPriceList the finalPriceList to set
	 */
	public void setFinalPriceList(List<Integer> finalPriceList) {
		this.finalPriceList = finalPriceList;
	}
	
}
