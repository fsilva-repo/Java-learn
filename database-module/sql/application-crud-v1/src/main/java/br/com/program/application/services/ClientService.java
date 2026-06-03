package br.com.program.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.program.application.entities.Client;
import br.com.program.application.repositories.ClientRepository;

@Service
public class ClientService {

  private final ClientRepository repository;

  public ClientService(ClientRepository repository) {
    this.repository = repository;
  }

  public Client save(Client c) {
    c.setId(null);
    return repository.save(c);
  }

  public List<Client> findAll() {
    return repository.findAll();
  }

  public Client findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("client não encontrado"));
  }

  public Client update(Long id, Client client) {
    // lança uma exception se o id não existir
    Client existing = findById(id);

    existing.setName(client.getName());
    existing.setEmail(client.getEmail());
    existing.setPhone(client.getPhone());

    return repository.save(existing);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }

}
