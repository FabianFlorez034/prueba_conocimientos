package com.coomeva.facturacion.repository;

import com.coomeva.facturacion.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryClient extends JpaRepository<Client, Integer> {

    Client findClientByIdentification(int identificacion);
}
