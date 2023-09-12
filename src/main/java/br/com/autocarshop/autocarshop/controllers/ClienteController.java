package br.com.autocarshop.autocarshop.controllers;

import br.com.autocarshop.autocarshop.dtos.ClienteDTO;
import br.com.autocarshop.autocarshop.model.entities.Cliente;
import br.com.autocarshop.autocarshop.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public Iterable<Cliente> getAllClientes() {
        return clienteService.getAllCliente();
    }

    @PostMapping
    public ResponseEntity<Cliente> postCliente(@RequestBody ClienteDTO data) {
        return new ResponseEntity<>(clienteService.createCliente(data), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Cliente> putCliente(@PathVariable(name = "id") Integer id,
                                              @RequestBody ClienteDTO data) {
        return new ResponseEntity<>(clienteService.actualizarCliente(id, data), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCliente(@PathVariable(name = "id") Integer id) {
        clienteService.deleteCliente(id);
    }

    @GetMapping(path = "/{id}")
    public Optional<Cliente> getClienteById(@PathVariable(name = "id") Integer id) {
        return Optional.ofNullable(clienteService.findClienteById(id));
    }
}
