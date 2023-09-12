package br.com.autocarshop.autocarshop.controllers;

import br.com.autocarshop.autocarshop.dtos.AlugaDTO;
import br.com.autocarshop.autocarshop.model.entities.Aluga;
import br.com.autocarshop.autocarshop.services.AlugaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/aluga")
public class AlugaController {

    private final AlugaService alugaService;

    public AlugaController(AlugaService alugaService) {
        this.alugaService = alugaService;
    }

    @GetMapping
    public Iterable<Aluga> getAllAlugas() {
        return alugaService.getAllAlugas();
    }

    @PostMapping
    public ResponseEntity<Aluga> postAluga(@RequestBody AlugaDTO data) {
        return new ResponseEntity<>(alugaService.createAluga(data), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Aluga> putAluga(@PathVariable(name = "id") Integer id,
                                          @RequestBody AlugaDTO data) {
        return new ResponseEntity<>(alugaService.actualizarAluga(id, data), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAluga(@PathVariable(name = "id") Integer id) {
        alugaService.deleteAluga(id);
    }

    @GetMapping(path = "/{id}")
    public Optional<Aluga> getAlugaById(@PathVariable(name = "id") Integer id) {
        return Optional.ofNullable(alugaService.findTelefoneById(id));
    }
}
