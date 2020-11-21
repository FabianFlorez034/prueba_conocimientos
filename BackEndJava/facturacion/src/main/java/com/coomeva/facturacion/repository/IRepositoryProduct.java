package com.coomeva.facturacion.repository;

import com.coomeva.facturacion.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryProduct extends JpaRepository<Product, Integer> {

    Product findByCode(String code);

    Product findByName(String name);
}
