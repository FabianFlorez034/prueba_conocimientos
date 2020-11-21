package com.coomeva.facturacion.repository.producto.impl;

import com.coomeva.facturacion.model.entities.Product;
import com.coomeva.facturacion.repository.IRepositoryInvoice;
import com.coomeva.facturacion.repository.IRepositoryProduct;
import com.coomeva.facturacion.repository.producto.IProductoRepoFacade;
import com.coomeva.facturacion.util.ValidateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductRepoFacade implements IProductoRepoFacade {

    @Autowired
    IRepositoryProduct iRepositoryProduct;

    @Override
    public Optional<Product> searchProduct(Integer idProduct) throws Exception {

        Optional<Product> searchProduct = iRepositoryProduct.findById(idProduct);

        if (!searchProduct.isPresent()) {
            throw new ValidateData("El id del producto no existe");
        }

        return Optional.of(searchProduct.get());
    }
}
