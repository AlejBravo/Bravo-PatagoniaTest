package com.example.bravopatagoniantest.controller;

import com.example.bravopatagoniantest.model.Client;
import com.example.bravopatagoniantest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }

    @GetMapping("/client/{id}")
    public Optional<Client> getClientById(@PathVariable Long id) throws Exception {
        return clientService.getClientById(id);
    }

 /*   @PutMapping("/updateClient/{id}")
    public void updateClientById(@PathVariable Long id, @RequestBody Client client) throws Exception {
        //return clientService.updateClientById(id,client);
     *//*   try {
            return ResponseEntity.status(HttpStatus.OK).body(clientService.updateClientById(id, client));
        } catch (Exception e) {
            return ResponseEntity.status();
        }*//*
    }*/
}
