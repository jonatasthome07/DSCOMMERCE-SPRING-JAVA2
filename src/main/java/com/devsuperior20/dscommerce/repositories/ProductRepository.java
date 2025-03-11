package com.devsuperior20.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior20.dscommerce.entities.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {

}
