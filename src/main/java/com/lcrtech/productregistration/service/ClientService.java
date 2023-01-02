package com.lcrtech.productregistration.service;

import com.lcrtech.productregistration.model.Client;
import com.lcrtech.productregistration.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    private Client client;

    public Client saveClient(Client client) {

        return clientRepository.save(client);
    }

    public List<Client> listClients() {

        return clientRepository.findAll();
    }

    public Client findClientById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);

        return clientOptional.get();
    }

    public Client updateClient(Client client) {

        if(client.getId() != null) {
            Client old = this.findClientById(client.getId());
            client.setId(old.getId());
        }
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        Client client = this.findClientById(id);

        clientRepository.delete(client);
    }
}
