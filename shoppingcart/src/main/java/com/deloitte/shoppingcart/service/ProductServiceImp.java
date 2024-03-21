package com.deloitte.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.shoppingcart.exception.ProductNotFoundException;
import com.deloitte.shoppingcart.model.Product;
import com.deloitte.shoppingcart.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService{
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product newProduct(Product product) {
		Product newProduct = productRepository.findByName(product.getName());
		if (newProduct != null) {
			newProduct.setTotalProductsInventory(newProduct.getTotalProductsInventory() + 1);
			return productRepository.save(newProduct);
		} else {
			product.setTotalProductsInventory(1);
			return productRepository.save(product);
		}

	}

	@Override
	public Optional<Product> getProductById(int productId) {
		Optional<Product> product =  productRepository.findById(productId);
		 if (product.isEmpty()) {
			 throw new ProductNotFoundException("Product with id: " + productId + " not found");
		 }
		 
		 return product;
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		Product updateProduct = productRepository.findById(productId).get();
		updateProduct.setPrice(product.getPrice());
		updateProduct.setImage(product.getImage());
		updateProduct.setDescription(product.getDescription());
		updateProduct.setTotalProductsInventory(product.getTotalProductsInventory());

		return productRepository.save(updateProduct);
	}

	@Override
	public Product findProductByName(String name) {
		Product productName = productRepository.findByName(name);
		return productName;
	}

	@Override
	public List<Product> findProductByPrice(double price) {
		List<Product> productPrice = productRepository.findByPrice(price);
		return productPrice;
	}

	@Override
	public void deleteProduct(int productId, Product product) {
		Product productDelete = productRepository.findById(productId).orElse(null);
		productDelete.setStatus(false);
		productRepository.save(productDelete);
		
	}


}
