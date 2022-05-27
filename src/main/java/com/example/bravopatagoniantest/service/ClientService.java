package com.example.bravopatagoniantest.service;

import com.example.bravopatagoniantest.model.Client;
import com.example.bravopatagoniantest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Optional<Client> getClientById(Long id) throws Exception{
        Optional<Client> client = clientRepository.findById(id);
        try {
            if (client.isPresent()) {
                return clientRepository.findById(id);
            }
        }catch (Exception e){
            System.out.println("El cliente no existe");
        }
        return client;
    }+

   /* @Transactional
    public void updateClientById(Long id, Client clientUpdate) throws Exception {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()) {
            throw new Exception("El cliente no existe");
        }else{
            if (client.get().equals(clientUpdate.getFullName())){
                client.get().setFullName(clientUpdate.getFullName());
            }else if (client.get().equals((clientUpdate.getIncome()))){
                client.get().setIncome(clientUpdate.getIncome());
            }clientRepository.save(client.get());
        }
    }*/
  /*  @Transactional
    public Client updateClientById(Integer id, Client cliente) throws Exception {
        try {
            Optional<Client> clientOptional = clientRepository.findById(id);
            Client clientUpdate = clientOptional.get();
            clientUpdate = clientRepository.save(cliente);
            return clientUpdate;
        }catch (Exception e){
            throw new Exception("El cliente no se encuentra");
        }
    }*/
}
