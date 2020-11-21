package com.coomeva.facturacion.repository.invoice.impl;

import com.coomeva.facturacion.model.entities.Invoice;
import com.coomeva.facturacion.repository.IRepositoryInvoice;
import com.coomeva.facturacion.repository.invoice.IInvoiceRepoFacade;
import com.coomeva.facturacion.util.ValidateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InvoiceRepoFacade implements IInvoiceRepoFacade {

    @Autowired
    IRepositoryInvoice iRepositoryInvoice;


    @Override
    public Optional<Invoice> searchInvoice(Integer idFactura) throws Exception {

        Optional<Invoice> searchInvoice = iRepositoryInvoice.findById(idFactura);

        if (!searchInvoice.isPresent()) {
            throw new ValidateData("El id de la factura no existe");
        }

        return searchInvoice;

    }
}
