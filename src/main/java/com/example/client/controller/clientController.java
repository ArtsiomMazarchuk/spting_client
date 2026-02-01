package com.example.client.controller;

import com.example.client.model.Client;
import com.example.client.service.ClientService;
import com.example.client.service.DefaultClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class clientController {

    @Autowired
    private DefaultClientService clientService;

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client.getName());
    }

    // Получить всех
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

   // Получить по ID
   @GetMapping("/{id}")
   public ResponseEntity<Client> getClientById(@PathVariable Long id) {
       try {
           Client client = clientService.getClientById(id).get();
           return ResponseEntity.ok(client);
       } catch (RuntimeException e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
   }

    // Обновить существующего
    @PutMapping("/{id}")
    public ResponseEntity<Client> updatePerson(@PathVariable Long id, @RequestBody Client client) {
        try {
            Client updatedClient = clientService.updateClient(id, client.getName());
            return ResponseEntity.ok(updatedClient);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Удалить по ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        try {
            clientService.deleteClientById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
