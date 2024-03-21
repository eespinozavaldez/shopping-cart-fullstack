package com.deloitte.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import com.deloitte.shoppingcart.model.Product;

public interface ProductService {
	
	
	public Product newProduct(Product product);

	public List<Product> getAllProducts();
	
	public Optional<Product> getProductById(int productId);
	
	public Product updateProduct(int productId, Product product);
	
	public Product findProductByName(String name);
	
	public List<Product> findProductByPrice(double price);
	
	public void deleteProduct(int productId, Product product);
}
