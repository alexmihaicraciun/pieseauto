package com.pieseauto.domain.services;

import java.util.List;

import com.pieseauto.dao.ProductsDao;
import com.pieseauto.dao.ProductsDaoImpl;
import com.pieseauto.domain.entities.Product;

public class ProductService {
	ProductsDao pd = new ProductsDaoImpl();
	
	public List<Product> getOnSale() {
		List<Product> onSaleProds = pd.getOnSale();
		
		if(onSaleProds.isEmpty()) {
			return null;
		}
		return onSaleProds;
	}
}
