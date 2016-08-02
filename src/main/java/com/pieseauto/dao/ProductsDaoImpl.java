package com.pieseauto.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pieseauto.domain.entities.Product;

public class ProductsDaoImpl implements ProductsDao{
	
	/**
	 * Return List<Product>
	 * TOP 5 BIGGEST SALES
	 */
	public List<Product> getOnSale() {
		
		List<Product> productsOnSale = new ArrayList<Product>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pieseauto","root","root");
			String query = "SELECT * FROM `products` "
					+ "JOIN `products_categories` ON products_categories.id = products.product_category "
					+ "WHERE `product_sale` > 0 "
					+ "ORDER BY `product_sale` "
					+ "DESC LIMIT 5";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product prod = new Product();
				prod.setId(rs.getInt("id"));
				prod.setProductName(rs.getString("product_name"));
				prod.setProductPrice(rs.getDouble("product_price"));
				prod.setProductDescription(rs.getString("product_description"));
				prod.setProductSale(rs.getInt("product_sale"));
				prod.setProductCategory(rs.getString("category_name"));
				productsOnSale.add(prod);
			}
			return productsOnSale;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
