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
@Table(name = "test_cliente" )
@XmlRootElement
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idClient;

    @Basic(optional = false)
    @Column(name = "identificacion")
    private int identification;

    @Basic(optional = false)
    @Column(name = "nombres")
    private String name;

    @Basic(optional = false)
    @Column(name = "apellidos")
    private String lastName;

    @Basic(optional = false)
    @Column(name = "direccion")
    private String address;

    @Column(name = "telefono")
    private String telephone;

    @Column(name = "email")
    private String email;
}
