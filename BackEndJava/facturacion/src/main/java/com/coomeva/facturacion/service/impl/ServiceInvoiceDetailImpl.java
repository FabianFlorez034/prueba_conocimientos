package com.coomeva.facturacion.service.impl;

import com.coomeva.facturacion.model.dto.InvoiceDetailDTO;
import com.coomeva.facturacion.model.dto.ProductDTO;
import com.coomeva.facturacion.model.entities.Invoice;
import com.coomeva.facturacion.model.entities.InvoiceDetail;
import com.coomeva.facturacion.model.entities.Product;
import com.coomeva.facturacion.repository.IRepositoryInvoice;
import com.coomeva.facturacion.repository.IRepositoryInvoiceDetail;
import com.coomeva.facturacion.repository.IRepositoryProduct;
import com.coomeva.facturacion.repository.invoice.IInvoiceRepoFacade;
import com.coomeva.facturacion.repository.producto.IProductoRepoFacade;
import com.coomeva.facturacion.service.interfaces.IServiceInvoiceDetail;
import com.coomeva.facturacion.util.ValidateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("serviceInvoiceDetailImpl")
public class ServiceInvoiceDetailImpl implements IServiceInvoiceDetail {


    private final IInvoiceRepoFacade iInvoiceRepoFacade;

    private final IProductoRepoFacade iProductoRepoFacade;


    private final IRepositoryInvoiceDetail iRepositoryInvoiceDetail;

    @Autowired
    public ServiceInvoiceDetailImpl(IInvoiceRepoFacade iInvoiceRepoFacade, IProductoRepoFacade iProductoRepoFacade, IRepositoryInvoiceDetail iRepositoryInvoiceDetail) {
        this.iInvoiceRepoFacade = iInvoiceRepoFacade;
        this.iProductoRepoFacade = iProductoRepoFacade;
        this.iRepositoryInvoiceDetail = iRepositoryInvoiceDetail;
    }


    @Override
    public List<InvoiceDetailDTO> createInvoiceDetail(List<InvoiceDetailDTO> invoiceDetailDTO) throws Exception {

        try {


            List<InvoiceDetail> invoiceDetails = new ArrayList<>();
            List<InvoiceDetailDTO> invoiceDetailDTOS = new ArrayList<>();

            for (InvoiceDetailDTO detail : invoiceDetailDTO) {
                Optional<Invoice> searchInvoice = iInvoiceRepoFacade.searchInvoice(detail.getIdInvoice());
                Optional<Product> searchProduct = iProductoRepoFacade.searchProduct(detail.getIdProduct());
                invoiceDetails.add(InvoiceDetail.builder()
                        .cantidad(detail.getCantidad())
                        .unitValue(detail.getUnitValue())
                        .totalValue(detail.getTotalValue())
                        .idInvoice(searchInvoice.get())
                        .idProduct(searchProduct.get())
                        .build());
            }

            iRepositoryInvoiceDetail.saveAll(invoiceDetails);


            for (InvoiceDetail invoiceDetail:invoiceDetails) {


                invoiceDetailDTOS.add(InvoiceDetailDTO.builder()
                        .idInvoice(invoiceDetail.getIdInvoice().getIdFactura())
                        .idProduct(invoiceDetail.getIdProduct().getIdProduct())
                        .cantidad(invoiceDetail.getCantidad())
                        .unitValue(invoiceDetail.getUnitValue())
                        .totalValue(invoiceDetail.getTotalValue())
                        .build());
            }

            return invoiceDetailDTOS;
        } catch (Exception e) {
            throw new Exception(e.getMessage());


        }

    }
}
