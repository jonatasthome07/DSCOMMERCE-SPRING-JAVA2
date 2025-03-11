package com.devsuperior20.dscommerce.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior20.dscommerce.dto.ProductDTO;
import com.devsuperior20.dscommerce.entities.Product;
import com.devsuperior20.dscommerce.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Optional <Product> result = repository.findById(id);
		Product p = result.get();
		ProductDTO dto = new ProductDTO(p);
		return dto;
	}
	
	public Page <ProductDTO> findAll (Pageable pageable) {
		Page <Product> result = repository.findAll(pageable);
		return result.map(x -> new ProductDTO(x));
	}
}
