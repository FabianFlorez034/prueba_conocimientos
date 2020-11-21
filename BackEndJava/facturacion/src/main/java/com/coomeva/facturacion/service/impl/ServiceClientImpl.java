package com.coomeva.facturacion.service.impl;

import com.coomeva.facturacion.model.dto.ClientDTO;
import com.coomeva.facturacion.model.entities.Client;
import com.coomeva.facturacion.repository.IRepositoryClient;
import com.coomeva.facturacion.service.interfaces.IServiceClient;
import com.coomeva.facturacion.util.ValidateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("serviceClientImpl")
public class ServiceClientImpl implements IServiceClient {

    @Autowired
    IRepositoryClient repository;

    @Override
    public void createClient(ClientDTO clientDTO) throws Exception {
        if(clientDTO.getIdentification()==0){
            throw new ValidateData("¡Por favor ingrese el número de identificación!");
        }
        if(clientDTO.getName() == null || clientDTO.getName()==""){
            throw new ValidateData("¡Por favor ingrese el nombre!");
        }
        if(clientDTO.getLastName() == null || clientDTO.getLastName()==""){
            throw new ValidateData("¡Por favor ingrese el apellido!");
        }
        if(clientDTO.getAddress() == null || clientDTO.getAddress()==""){
            throw new ValidateData("¡Por favor ingrese la dirección!");
        }
        Client client = Client.builder()
                .identification(clientDTO.getIdentification())
                .name(clientDTO.getName())
                .lastName(clientDTO.getLastName())
                .address(clientDTO.getAddress())
                .build();

        repository.save(client);

    }

    @Override
    public Client getClient(int identificacion) throws Exception {
        Client searchClient = repository.findClientByIdentification(identificacion);
        if(searchClient == null)
            throw new ValidateData("El número de cédula no está registrado");
        return searchClient;
    }

    @Override
    public Client getClientById(Integer idClient) throws Exception {
        Optional<Client> searchPersonaById = repository.findById(idClient);
        if (!searchPersonaById.isPresent())

            throw new ValidateData("El id no está registrado");

        return searchPersonaById.get();
    }
}