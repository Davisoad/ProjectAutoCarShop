package br.com.autocarshop.autocarshop.services;

import br.com.autocarshop.autocarshop.dtos.AlugaDTO;
import br.com.autocarshop.autocarshop.model.entities.Aluga;
import br.com.autocarshop.autocarshop.model.repositories.AlugaRepository;
import org.springframework.stereotype.Service;

@Service
public class AlugaService {

    private final AlugaRepository alugaRepository;

    public AlugaService(AlugaRepository alugaRepository) {
        this.alugaRepository = alugaRepository;
    }

    public Aluga findTelefoneById(Integer id) {
        return alugaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluga not found"));
    }

    public Aluga saveAluga(Aluga aluga) {
        return alugaRepository.save(aluga);
    }

    public Aluga createAluga(AlugaDTO data) {
        Aluga aluga = new Aluga(data);
        return saveAluga(aluga);
    }

    public Aluga actualizarAluga(Integer id, AlugaDTO data) {
        Aluga aluga = alugaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluga not found with id: " + id));

        aluga.setDateFin(data.dateFin());
        aluga.setDateIni(data.dateIni());

        return saveAluga(aluga);
    }

    public void deleteAluga(Integer id) {
        alugaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluga not found! "));
        alugaRepository.deleteById(id);
    }

    public Iterable<Aluga> getAllAlugas() {
        return this.alugaRepository.findAll();
    }
 }
