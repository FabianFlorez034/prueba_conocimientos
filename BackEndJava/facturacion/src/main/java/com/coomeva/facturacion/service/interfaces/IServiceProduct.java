package com.coomeva.facturacion.service.interfaces;

import com.coomeva.facturacion.model.dto.ProductDTO;
import com.coomeva.facturacion.model.entities.Product;

import java.util.List;

public interface IServiceProduct {

    void createProduct(ProductDTO productDTO) throws Exception;

    Product getProductByCode(String code)throws Exception;

    Product getProductoByName(String name)throws Exception;

    List<ProductDTO> findAll()throws Exception;

    void updateProduct(Integer idProduct, ProductDTO productDTO)throws Exception;
}
