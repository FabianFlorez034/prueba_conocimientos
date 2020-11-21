package com.coomeva.facturacion.service.interfaces;

import com.coomeva.facturacion.model.dto.InvoiceDetailDTO;

import java.util.List;

public interface IServiceInvoiceDetail {
    List<InvoiceDetailDTO> createInvoiceDetail(List<InvoiceDetailDTO> invoiceDetailDTO) throws Exception;
}
