package com.coomeva.facturacion.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "test_producto" )
@XmlRootElement
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProduct;

    @Basic(optional = false)
    @Column(name = "codigo")
    private String code;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String name;

    @Basic(optional = false)
    @Column(name = "valor_unidad")
    private double unitValue;

    @Basic(optional = false)
    @Column(name = "stock")
    private int stock;
}
