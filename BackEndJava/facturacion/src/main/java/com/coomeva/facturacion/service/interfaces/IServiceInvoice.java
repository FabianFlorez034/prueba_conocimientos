package com.coomeva.facturacion.service.interfaces;

import com.coomeva.facturacion.commons.ResponseInvoice;
import com.coomeva.facturacion.model.dto.InvoiceDTO;

import java.util.Optional;

public interface IServiceInvoice {

    Optional<ResponseInvoice> createInvoice(InvoiceDTO invoiceDTO) throws Exception;
}
