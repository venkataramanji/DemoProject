package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) {

		return productService.saveProduct(product);
	}

	@RequestMapping(value = "/addProducts", method = RequestMethod.POST)
	public List<Product> addProducts(@RequestBody List<Product> products) {

		return productService.saveProducts(products);
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
