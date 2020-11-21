package com.coomeva.facturacion.controller;

import com.coomeva.facturacion.model.dto.ProductDTO;
import com.coomeva.facturacion.model.entities.Product;
import com.coomeva.facturacion.service.impl.ServiceProductImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ControllerProduct {

    @Autowired
    ServiceProductImpl serviceProduct;


    @PostMapping("/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) {
        try {
            serviceProduct.createProduct(productDTO);
            return new ResponseEntity<>(productDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }


    @GetMapping("/productByCode/{code}")
    public ResponseEntity<?> findClientByCode(@PathVariable String code) {
        try {
            Product product = serviceProduct.getProductByCode(code);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/productByName/{name}")
    public ResponseEntity<?> findClientByName(@PathVariable String name) {
        try {
            Product product = serviceProduct.getProductoByName(name);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/products")
    public ResponseEntity<?> findAll() {
        try {
            List<ProductDTO> listProducts = serviceProduct.findAll();
            return new ResponseEntity<>(listProducts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/updateProduct/{id_product}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id_product, @RequestBody ProductDTO productDTO){
        try {
            serviceProduct.updateProduct(id_product, productDTO);
            return new ResponseEntity<>(productDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }


}
