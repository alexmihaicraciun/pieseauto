package com.pieseauto.dao;

import java.util.List;

import com.pieseauto.domain.entities.Product;

public interface ProductsDao {

		public List<Product> getOnSale();
}
