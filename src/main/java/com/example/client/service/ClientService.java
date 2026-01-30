package com.example.client.service;

import com.example.client.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client createClient(String name);
    List<Client> getAllClients();
    Client getClientById(Long id);
    void deleteClientById(Long id);
    Client updateClient(Long id, String name);
    //public Optional<Client> getClientById(Long id);
}
