package com.coomeva.facturacion.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class InvoiceDTO {


    private Integer idFactura;
    private Date saleDate;
    private double totalValue;
    private Integer idClient;
}
