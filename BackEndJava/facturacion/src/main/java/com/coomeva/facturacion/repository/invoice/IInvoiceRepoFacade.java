package com.coomeva.facturacion.repository.invoice;

import com.coomeva.facturacion.model.entities.Invoice;

import java.util.Optional;

public interface IInvoiceRepoFacade {


    Optional<Invoice> searchInvoice( Integer idFactura)throws Exception;
}
