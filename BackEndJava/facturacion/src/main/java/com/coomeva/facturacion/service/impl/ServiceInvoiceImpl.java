package com.coomeva.facturacion.service.impl;

import com.coomeva.facturacion.commons.ResponseInvoice;
import com.coomeva.facturacion.model.dto.InvoiceDTO;
import com.coomeva.facturacion.model.entities.Client;
import com.coomeva.facturacion.model.entities.Invoice;
import com.coomeva.facturacion.repository.IRepositoryClient;
import com.coomeva.facturacion.repository.IRepositoryInvoice;
import com.coomeva.facturacion.service.interfaces.IServiceInvoice;
import com.coomeva.facturacion.util.ValidateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service("serviceInvoiceImpl")
public class ServiceInvoiceImpl implements IServiceInvoice {

    @Autowired
    IRepositoryInvoice iRepositoryInvoice;

    @Autowired
    IRepositoryClient iRepositoryClient;

    @Override
    public Optional<ResponseInvoice> createInvoice(InvoiceDTO invoiceDTO) throws Exception {

        Optional<Client> searchClient = iRepositoryClient.findById(invoiceDTO.getIdClient());
        Date currentDate = new Date();

        if (!searchClient.isPresent()){
            throw new ValidateData("El id del cliente no existe");
        }
        Invoice invoice = Invoice.builder()
                .saleDate(currentDate)
                .totalValue(invoiceDTO.getTotalValue())
                .idClient(searchClient.get())
                .build();


        iRepositoryInvoice.save(invoice);

        ResponseInvoice responseInvoice = ResponseInvoice.builder()
                .responseInvoiceDTO(InvoiceDTO.builder()
                        .idFactura(invoice.getIdFactura())
                        .saleDate(invoice.getSaleDate())
                        .totalValue(invoice.getTotalValue())
                        .idClient(invoice.getIdClient().getIdClient())
                        .build())
                .build();
    return Optional.of(responseInvoice);


    }
}
