package br.com.autocarshop.autocarshop.controllers;

import br.com.autocarshop.autocarshop.dtos.CarroDTO;
import br.com.autocarshop.autocarshop.model.entities.Carro;
import br.com.autocarshop.autocarshop.services.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/carro")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public Iterable<Carro> getAllCarro() {
        return carroService.getAllCarro();
    }

    @PostMapping
    public ResponseEntity<Carro> postCarro(@RequestBody CarroDTO data) {
        return new ResponseEntity<>(carroService.createCarro(data), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Carro> putCarro(@PathVariable(name = "id") Integer id,
                                          @RequestBody CarroDTO data) {
        return new ResponseEntity<>(carroService.actualizarCarro(id, data), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCarro(@PathVariable(name = "id") Integer id) {
        carroService.deleteCarro(id);
    }

    @GetMapping(path = "/{id}")
    public Optional<Carro> getCarroById(@PathVariable(name = "id") Integer id) {
        return Optional.ofNullable(this.carroService.findCarroById(id));
    }
}
