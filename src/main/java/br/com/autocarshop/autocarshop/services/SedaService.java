package br.com.autocarshop.autocarshop.services;

import br.com.autocarshop.autocarshop.dtos.SedaDTO;
import br.com.autocarshop.autocarshop.model.entities.Seda;
import br.com.autocarshop.autocarshop.model.entities.SedaId;
import br.com.autocarshop.autocarshop.model.repositories.CarroRepository;
import br.com.autocarshop.autocarshop.model.repositories.SedaRepository;
import org.springframework.stereotype.Service;

@Service
public class SedaService {

    private final SedaRepository sedaRepository;
    private final CarroRepository carroRepository;

    public SedaService(SedaRepository sedaRepository, CarroRepository carroRepository) {
        this.sedaRepository = sedaRepository;
        this.carroRepository = carroRepository;
    }

    public Seda findSedaById(Integer id) {
        return sedaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Seda not found with id: " + id));
    }

    public Seda saveSeda(Seda seda) {
        Integer idCarro = seda.getSedaId().getCodCar();

        carroRepository.findById(idCarro)
                .orElseThrow(() -> new IllegalArgumentException("Carro not found!"));

        SedaId newId = new SedaId(idCarro);

        seda.setSedaId(newId);

        return sedaRepository.save(seda);
    }

    public Seda actualizarSeda(SedaDTO data) {
        return saveSeda(new Seda(data));
    }

    public Seda createSeda(Integer id, SedaDTO data) {
        Seda seda = sedaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Seda not found with id: " + id));

        seda.getSedaId().setPassageiros(data.passageiros());

        return saveSeda(new Seda(data));
    }

    public void deleteSeda(Integer id) {
        sedaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Seda not found with id: " + id));
        sedaRepository.deleteById(id);
    }

    public Iterable<Seda> getAllSeda() {
        return sedaRepository.findAll();
    }
}
