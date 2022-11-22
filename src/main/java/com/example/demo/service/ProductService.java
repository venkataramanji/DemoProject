package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productrepository;
	
	public Product saveProduct(Product product) {
		
		return productrepository.save(product);
	}
    
	public List<Product> saveProducts(List<Product> products){
		
		return productrepository.saveAll(products);
	}
	public List<Product> getProducts(){
		
		return productrepository.findAll();
	}
	public Product getProductByPid(int pid) {
		
		return productrepository.findById(pid).orElse(null);
	}
           public String deleteProduct(int pid) {
       		
  				productrepository.deleteById(pid);
       		return " product removed !! "+pid;
       	}
           public Product updateProduct(Product product) {
        	   
        	   Product existingProduct= productrepository.findById(product.getpId()).orElse(null);
        	   existingProduct.setpName(product.getpName());
        	   existingProduct.setpQuantity(product.getpQuantity());
        	   existingProduct.setpPrice(product.getpPrice());
        	   if( ObjectUtils.isEmpty(existingProduct)) {
        		   
        	   }else {
        		   
        	   }
        	   return productrepository.save(existingProduct);
           }
           

}
