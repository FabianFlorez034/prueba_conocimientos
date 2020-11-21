package com.coomeva.facturacion.repository.producto;

import com.coomeva.facturacion.model.entities.Product;

import java.util.Optional;

public interface IProductoRepoFacade {

    Optional<Product> searchProduct(Integer  idProduct) throws Exception;
}
