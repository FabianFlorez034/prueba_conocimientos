package com.coomeva.facturacion.controller;

import com.coomeva.facturacion.model.dto.ClientDTO;
import com.coomeva.facturacion.model.entities.Client;
import com.coomeva.facturacion.service.impl.ServiceClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api")
public class ControllerClient {

    @Autowired
    ServiceClientImpl serviceClient;


    @PostMapping("/createClient")
    public ResponseEntity<?> createClient(@RequestBody ClientDTO clientDTO) {
        try {
            serviceClient.createClient(clientDTO);
            return new ResponseEntity<>(clientDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( e.getMessage(), HttpStatus.CONFLICT);
        }

    }


    @GetMapping("/client/{identificacion}")
    public ResponseEntity<?> findClientByCedula(@PathVariable int identificacion){
        try {
            Client client = serviceClient.getClient(identificacion);
            return new ResponseEntity<>(client, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/clientById/{idClient}")
    public ResponseEntity<?> findClientByCedula(@PathVariable Integer idClient){
        try {
            Client client = serviceClient.getClientById(idClient);
            return new ResponseEntity<>(client, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
