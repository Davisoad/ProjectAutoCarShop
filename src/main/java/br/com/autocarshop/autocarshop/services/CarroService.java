package br.com.autocarshop.autocarshop.services;

import br.com.autocarshop.autocarshop.dtos.CarroDTO;
import br.com.autocarshop.autocarshop.model.entities.Carro;
import br.com.autocarshop.autocarshop.model.repositories.CarroRepository;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public Carro findCarroById(Integer id) {
        return carroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Carro not found with id: " + id));
    }

    public Carro saveCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public Carro createCarro(CarroDTO data) {
        Carro carro = new Carro(data);
        return saveCarro(carro);
    }

    public Carro actualizarCarro(Integer id, CarroDTO data) {
        Carro carro = carroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Carro not found with id: " + id));

        carro.setAno(data.ano());
        carro.setCor(data.cor());
        carro.setDiaria(data.diaria());
        carro.setModelo(data.modelo());
        carro.setPlaca(data.placa());

        return saveCarro(carro);
    }

    public void deleteCarro(Integer id) {
        Carro carro = carroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Carro not found with id: " + id));
        carroRepository.deleteById(id);
    }

    public Iterable<Carro> getAllCarro() {
        return carroRepository.findAll();
    }
}
