package com.coomeva.facturacion.service.impl;

import com.coomeva.facturacion.model.dto.ProductDTO;
import com.coomeva.facturacion.model.entities.Product;
import com.coomeva.facturacion.repository.IRepositoryProduct;
import com.coomeva.facturacion.service.interfaces.IServiceProduct;
import com.coomeva.facturacion.util.ValidateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("serviceProductImpl")
public class ServiceProductImpl implements IServiceProduct {

    @Autowired
    IRepositoryProduct iRepositoryProduct;

    @Override
    public void createProduct(ProductDTO productDTO) throws Exception {
        if (productDTO.getCode() == null || productDTO.getCode() == "") {
            throw new ValidateData("¡Por favor ingrese el código!");
        }
        if (productDTO.getName() == null || productDTO.getName() == "") {
            throw new ValidateData("¡Por favor ingrese el nombre del producto!");
        }
        if (productDTO.getUnitValue() == 0) {
            throw new ValidateData("¡Por favor ingrese el valor unitario!");
        }
        if (productDTO.getStock() == 0) {
            throw new ValidateData("¡Por favor cree un producto con stock!");
        }
        Product product = Product.builder()
                .code(productDTO.getCode())
                .name(productDTO.getName())
                .unitValue(productDTO.getUnitValue())
                .stock(productDTO.getStock())
                .build();

        iRepositoryProduct.save(product);

    }

    @Override
    public Product getProductByCode(String code) throws Exception {
        Product searchProduct = iRepositoryProduct.findByCode(code);
        if (searchProduct == null)
            throw new ValidateData("El código de producto no está registrado");
        return searchProduct;

    }

    @Override
    public Product getProductoByName(String name) throws Exception {
        Product searchProduct = iRepositoryProduct.findByName(name);
        if (searchProduct == null)
            throw new ValidateData("El nombre de producto no está registrado");
        return searchProduct;

    }

    @Override
    public List<ProductDTO> findAll() throws Exception {
        List<Product> allProduct = iRepositoryProduct.findAll();

        List<ProductDTO> listProductDto = new ArrayList<>();

        for (Product product : allProduct) {
            listProductDto.add(ProductDTO.builder()
                    .code(product.getCode())
                    .name(product.getName())
                    .unitValue(product.getUnitValue())
                    .stock(product.getStock())
                    .build());
        }
        return listProductDto;

    }

    @Override
    public void updateProduct(Integer idProduct, ProductDTO productDTO) throws Exception {
        Optional<Product> searchProductById = iRepositoryProduct.findById(idProduct);

        if(!searchProductById.isPresent())
            throw new ValidateData("El id del producto no existe");

        searchProductById.get().setCode(productDTO.getCode());
        searchProductById.get().setName(productDTO.getName());
        searchProductById.get().setUnitValue(productDTO.getUnitValue());
        searchProductById.get().setStock(productDTO.getStock());

        iRepositoryProduct.save(searchProductById.get());

    }
}
