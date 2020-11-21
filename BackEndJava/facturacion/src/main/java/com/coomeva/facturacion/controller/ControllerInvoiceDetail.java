package com.coomeva.facturacion.controller;

import com.coomeva.facturacion.model.dto.InvoiceDTO;
import com.coomeva.facturacion.model.dto.InvoiceDetailDTO;
import com.coomeva.facturacion.service.impl.ServiceInvoiceDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api")
public class ControllerInvoiceDetail {

    @Autowired
    ServiceInvoiceDetailImpl serviceInvoiceDetail;


    @PostMapping("/createInvoiceDetail")
    public ResponseEntity<?> createInvoiceDetail(@RequestBody List<InvoiceDetailDTO> invoiceDetailDTOS){
        try {
            List<InvoiceDetailDTO> list= serviceInvoiceDetail.createInvoiceDetail(invoiceDetailDTOS);
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
