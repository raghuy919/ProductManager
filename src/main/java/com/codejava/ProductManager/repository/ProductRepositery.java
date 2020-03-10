package com.codejava.ProductManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codejava.ProductManager.model.domain.Product;


@Repository
public interface ProductRepositery extends JpaRepository<Product, Long> {

}
