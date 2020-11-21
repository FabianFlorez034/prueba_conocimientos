package com.coomeva.facturacion.repository;

import com.coomeva.facturacion.model.entities.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryInvoiceDetail extends JpaRepository<InvoiceDetail, Integer> {
}
