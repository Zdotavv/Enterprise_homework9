package com.zdotavv.enterprise_homework9.repository;

import com.zdotavv.enterprise_homework9.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}