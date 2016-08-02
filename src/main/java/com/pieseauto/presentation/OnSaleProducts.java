package com.pieseauto.presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pieseauto.domain.entities.Product;
import com.pieseauto.domain.services.ProductService;

@WebServlet(urlPatterns = { "/products/onsale" })
public class OnSaleProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService ps = new ProductService();

	public OnSaleProducts() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> onsale = ps.getOnSale();

		JsonArrayBuilder onSaleJson = Json.createArrayBuilder();
//		JsonObject oneProduct = null;
//		String onSaleJson = "";
		
		for (Product p : onsale) {
			JsonObjectBuilder oneProduct = Json.createObjectBuilder()
					.add("id", p.getId())
					.add("product_name", p.getProductName())
					.add("product_price", p.getProductPrice())
					.add("product_description", p.getProductDescription())
					.add("product_sale", p.getProductSale())
					.add("category_name", p.getProductCategory());
			onSaleJson.add(oneProduct);
//			onSaleJson = onSaleJson + "{id :" + p.getId() + ",product_name :" + p.getProductName() + "},";
		}
		System.out.println();
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.print(onSaleJson.build());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
