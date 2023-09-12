package br.com.autocarshop.autocarshop.controllers;

import br.com.autocarshop.autocarshop.dtos.EsportivoDTO;
import br.com.autocarshop.autocarshop.model.entities.Esportivo;
import br.com.autocarshop.autocarshop.services.EsportivoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/esportivo")
public class EsportivoController {

    private final EsportivoService esportivoService;

    public EsportivoController(EsportivoService esportivoService) {
        this.esportivoService = esportivoService;
    }

    @GetMapping
    public Iterable<Esportivo> getAllEsportivos() {
        return esportivoService.getAllEsportivo();
    }

    @PostMapping
    public ResponseEntity<Esportivo> postEsportivo(@RequestBody EsportivoDTO data) {
        return new ResponseEntity<>(esportivoService.createEsportivo(data), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Esportivo> putEsportivo(@PathVariable(name = "id") Integer id,
                                                  @RequestBody EsportivoDTO data) {
        return new ResponseEntity<>(esportivoService.actualizarEsportivo(id, data), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteEsportivo(@PathVariable(name = "id") Integer id) {
        esportivoService.deleteEsportivo(id);
    }

    @GetMapping(path = "/{id}")
    public Optional<Esportivo> getEsportivoById(@PathVariable(name = "id") Integer id) {
        return Optional.ofNullable(esportivoService.findEsportivoById(id));
    }
}
