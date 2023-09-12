package br.com.autocarshop.autocarshop.controllers;

import br.com.autocarshop.autocarshop.dtos.TelefoneDTO;
import br.com.autocarshop.autocarshop.model.entities.Telefone;
import br.com.autocarshop.autocarshop.services.TelefoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/telefone")
public class TelefoneController {

    private final TelefoneService telefoneService;

    public TelefoneController(TelefoneService telefoneService) {
        this.telefoneService = telefoneService;
    }

    @GetMapping
    public Iterable<Telefone> getAllTelefones() {
        return telefoneService.getAllTelefone();
    }

    @PostMapping
    public ResponseEntity<Telefone> postTelefone(@RequestBody TelefoneDTO data) {
        return new ResponseEntity<>(telefoneService.createTelefone(data), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Telefone> putTelefone(@PathVariable(name = "id") Integer id,
                                                @RequestBody TelefoneDTO data) {
        return new ResponseEntity<>(telefoneService.actualizarTelefone(id, data), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTelefone(@PathVariable(name = "id") Integer id) {
        telefoneService.deleteTelefone(id);
    }

    @GetMapping(path = "/{id}")
    public Optional<Telefone> getTelefoneById(@PathVariable(name = "id") Integer id) {
        return Optional.ofNullable(telefoneService.findTelefoneById(id));
    }
}
