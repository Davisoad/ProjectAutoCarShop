package br.com.autocarshop.autocarshop.controllers;

import br.com.autocarshop.autocarshop.dtos.SedaDTO;
import br.com.autocarshop.autocarshop.model.entities.Seda;
import br.com.autocarshop.autocarshop.services.SedaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/seda")
public class SedaController {

    private final SedaService sedaService;

    public SedaController(SedaService sedaService) {
        this.sedaService = sedaService;
    }

    @GetMapping
    public Iterable<Seda> getAllSedas() {
        return sedaService.getAllSeda();
    }

    @PostMapping
    public ResponseEntity<Seda> postSeda(@RequestBody SedaDTO data) {
        return new ResponseEntity<>(sedaService.actualizarSeda(data), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Seda> putSeda(@PathVariable(name = "id") Integer id,
                                        @RequestBody SedaDTO data) {
        return new ResponseEntity<>(sedaService.createSeda(id, data), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSeda(@PathVariable(name = "id") Integer id) {
        sedaService.deleteSeda(id);
    }

    @GetMapping(path = "/{id}")
    public Optional<Seda> getSedaById(@PathVariable(name = "id") Integer id) {
        return Optional.ofNullable(sedaService.findSedaById(id));
    }
}
