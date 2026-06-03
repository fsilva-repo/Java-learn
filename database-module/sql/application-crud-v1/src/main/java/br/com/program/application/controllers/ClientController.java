package br.com.program.application.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.program.application.entities.Client;
import br.com.program.application.services.ClientService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/clientes")
public class ClientController {
  private final ClientService service;

  public ClientController(ClientService service) {
    this.service = service;
  }

  @GetMapping // busca por todos os cliente
  public List<Client> list() {
      return service.findAll();
  }

  @GetMapping("/{id}") // busca por um cliente
  public Client findById(@PathVariable Long id) {
      return service.findById(id);
  }

  @PutMapping("/{id}") // atualiza um cliente
  public Client update(
          @PathVariable Long id,
          @RequestBody Client client) {
      return service.update(id, client);
  }

  @DeleteMapping("/{id}") // deleta um cliente
  public void delete(@PathVariable Long id) {
      service.delete(id);
  }

  
  @PostMapping// cria novo cliente
  public ResponseEntity<Client> create(@RequestBody Client client) {
    Client clientSalvad = service.save(client);
    return ResponseEntity.status(HttpStatus.CREATED).body(clientSalvad);
  }
}
