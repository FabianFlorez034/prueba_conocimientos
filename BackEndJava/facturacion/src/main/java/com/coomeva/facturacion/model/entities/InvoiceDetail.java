package com.coomeva.facturacion.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "test_factura_detalle" )
@XmlRootElement
public class InvoiceDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura_detalle")
    private Integer idInvoiceDetail;

    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;

    @Basic(optional = false)
    @Column(name = "valor_unidad")
    private double unitValue;

    @Basic(optional = false)
    @Column(name = "valor_total")
    private double totalValue;

    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura")
    @ManyToOne(optional = false)
    private Invoice idInvoice;

    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Product idProduct;



}
