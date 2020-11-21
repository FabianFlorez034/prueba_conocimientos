package com.coomeva.facturacion.controller;

import com.coomeva.facturacion.commons.ResponseInvoice;
import com.coomeva.facturacion.model.dto.InvoiceDTO;
import com.coomeva.facturacion.service.impl.ServiceInvoiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api")
public class ControllerInvoice {

    @Autowired
    ServiceInvoiceImpl serviceInvoice;

    @PostMapping("/createInvoice")
    public ResponseEntity<?> createInvoice(@RequestBody InvoiceDTO invoiceDTO){
        try {
            Optional<ResponseInvoice> responseInvoice = serviceInvoice.createInvoice(invoiceDTO);
            return new ResponseEntity<>(responseInvoice, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
