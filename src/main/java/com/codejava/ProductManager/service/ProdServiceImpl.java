package com.codejava.ProductManager.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejava.ProductManager.model.domain.Product;
import com.codejava.ProductManager.repository.ProductRepositery;

@Service
public class ProdServiceImpl implements ProductService{
	@Autowired
	public ProductRepositery repo;
	
	public List<Product>listAll(){
		System.out.println("listing all product");
		return repo.findAll();
	}
	public void save(Product product) {
		repo.save(product);
	}
	public Product get(Long id) {
		return repo.findById(id).get();
	}
	public void delete(Long id) {
		repo.deleteById(id);
	}
}