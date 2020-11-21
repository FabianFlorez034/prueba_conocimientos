package com.coomeva.facturacion.service.interfaces;

import com.coomeva.facturacion.model.dto.ClientDTO;
import com.coomeva.facturacion.model.entities.Client;

public interface IServiceClient {

    void createClient(ClientDTO clientDTO) throws Exception;

    Client getClient(int identificacion)throws Exception;

    Client getClientById(Integer idClient)throws Exception;

}
