package com.pieseauto.domain.entities;

public class Product {
	private int id;
	private String productName;
	private double productPrice;
	private String productDescription;
	private int productSale;
	private String productCategory;
	private String[] productImages;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getProductSale() {
		return productSale;
	}
	public void setProductSale(int productSale) {
		this.productSale = productSale;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String[] getProductImages() {
		return productImages;
	}
	public void setProductImages(String[] productImages) {
		this.productImages = productImages;
	}
}
