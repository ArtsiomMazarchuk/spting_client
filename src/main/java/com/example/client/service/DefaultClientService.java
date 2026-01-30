package com.example.client.service;

import com.example.client.model.Client;
import com.example.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(String name) {
        return clientRepository.save(new Client(name));
    }
    // Получить все записи
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client updateClient(Long id, String newName) {
        Client client = clientRepository.findById(id).orElseThrow();
        client.setName(newName);
        return clientRepository.save(client);
    }

    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    public Optional<Client> getClientById(Long id)  {
        return clientRepository.findById(id);
    }

//    public Client getByIdOrThrow(Long id) {
//        return clientRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Клиент не найден с id: " + id));
//    }

}
