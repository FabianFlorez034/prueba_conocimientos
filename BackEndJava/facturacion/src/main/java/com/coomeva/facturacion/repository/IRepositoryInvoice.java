package com.coomeva.facturacion.repository;

import com.coomeva.facturacion.model.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryInvoice extends JpaRepository<Invoice, Integer> {
}
