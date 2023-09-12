package br.com.autocarshop.autocarshop.services;

import br.com.autocarshop.autocarshop.dtos.TelefoneDTO;
import br.com.autocarshop.autocarshop.model.entities.Telefone;
import br.com.autocarshop.autocarshop.model.repositories.TelefoneRepository;
import org.springframework.stereotype.Service;

@Service
public class TelefoneService {

    private final TelefoneRepository telefoneRepository;

    public TelefoneService(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    public Telefone findTelefoneById(Integer id) {
        return telefoneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Telefone not found with id: " + id));
    }

    public Telefone saveTelefone(Telefone telefone) {
        return telefoneRepository.save(telefone);
    }

    public Telefone createTelefone(TelefoneDTO data) {
        return saveTelefone(new Telefone(data));
    }

    public Telefone actualizarTelefone(Integer id, TelefoneDTO data) {
        Telefone telefone = telefoneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Telefone not found with id: " + id));

        telefone.setCodCli(data.codCli());
        telefone.setTelefone(data.telefone());

        return saveTelefone(telefone);
    }

    public void deleteTelefone(Integer id) {
        telefoneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Telefone not found with id: " + id));
        telefoneRepository.deleteById(id);
    }

    public Iterable<Telefone> getAllTelefone() {
        return telefoneRepository.findAll();
    }
}
