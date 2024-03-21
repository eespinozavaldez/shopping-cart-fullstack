package com.deloitte.shoppingcart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.shoppingcart.model.Product;
import com.deloitte.shoppingcart.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;

	// Create new product, if product already exist add + 1.
	@PostMapping("/add")
	public Product newProduct(@RequestBody Product product) {
		return productService.newProduct(product);

	}

	// get list of all products
	@GetMapping("/all")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();

	}
	// get product by id
	@GetMapping("/{productId}")
	public Optional<Product> getProductById(@PathVariable int productId) {
		return productService.getProductById(productId);
	}

	// update product, but only the price,image, description and total products
	// inventory.
	@PutMapping("/{productId}")
	public Product updateProduct(@PathVariable int productId, @RequestBody Product product) {
		return productService.updateProduct(productId, product);
	}

	// get a product by name
	@GetMapping("/productsname/{name}")
	public Product findProductByName(@PathVariable String name) {
		return productService.findProductByName(name);
	}

	// get a list of product by price
	@GetMapping("/productsprice/{price}")
	public List<Product> findProductByPrice(@PathVariable double price) {

return productService.findProductByPrice(price);
	}

	// delete a product by id
	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable int productId, @RequestBody Product product) {
		 productService.deleteProduct(productId, product);
	}

}
