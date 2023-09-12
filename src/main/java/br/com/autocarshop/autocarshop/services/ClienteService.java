package br.com.autocarshop.autocarshop.services;

import br.com.autocarshop.autocarshop.dtos.ClienteDTO;
import br.com.autocarshop.autocarshop.model.entities.Cliente;
import br.com.autocarshop.autocarshop.model.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente findClienteById(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente not found with id: " + id));
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente createCliente(ClienteDTO data) {
        return saveCliente(new Cliente(data));
    }

    public Cliente actualizarCliente(Integer id, ClienteDTO data) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente not found with id: " + id));

        cliente.setCnh(data.cnh());
        cliente.setEndereco(data.endereco());
        cliente.setNome(data.nome());

        return saveCliente(cliente);
    }

    public void deleteCliente(Integer id) {
        clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente not found with id: " + id));
        clienteRepository.deleteById(id);
    }

    public Iterable<Cliente> getAllCliente() {
        return clienteRepository.findAll();
    }
}
