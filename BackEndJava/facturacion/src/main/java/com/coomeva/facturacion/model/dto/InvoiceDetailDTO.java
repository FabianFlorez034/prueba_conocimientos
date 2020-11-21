package com.coomeva.facturacion.model.dto;

import com.coomeva.facturacion.model.entities.Invoice;
import com.coomeva.facturacion.model.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class InvoiceDetailDTO {



    private int cantidad;
    private double unitValue;
    private double totalValue;
    private Integer idInvoice;
    private Integer idProduct;
}
