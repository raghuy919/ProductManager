package com.codejava.ProductManager.service;

import java.util.List;

import com.codejava.ProductManager.model.domain.Product;

public interface ProductService {
	public List<Product> listAll();

	public void save(Product product);

	public Product get(Long id);

	public void delete(Long id);
}
