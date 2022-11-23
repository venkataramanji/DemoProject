package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductService productService;

	@PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product addProduct(@RequestBody Product product) {
		logger.info("inserting a product");

		Product addProduct = productService.saveProduct(product);
		logger.info("product inserted");

		return addProduct;
	}

	@RequestMapping(value = "/addProducts", method = RequestMethod.POST)
	public List<Product> addProducts(@RequestBody List<Product> products) {

		return productService.saveProducts(products);
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {

		logger.info("");

		return productService.updateProduct(product);
	}

	@RequestMapping(value = "/findAllProduct", method = RequestMethod.GET)
	public List<Product> findAllProduct() {

		return productService.getProducts();
	}

	@RequestMapping(value = "/findProductById/{id}", method = RequestMethod.GET)
	public Product findProductById(@PathVariable int id) {

		return productService.getProductByPid(id);
	}

	@RequestMapping(value = "/deleteProductById", method = RequestMethod.DELETE)
	public String deleteProductById(@RequestParam int id) {

		return productService.deleteProduct(id);
	}

}
