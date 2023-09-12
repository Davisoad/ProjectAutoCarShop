package br.com.autocarshop.autocarshop.services;

import br.com.autocarshop.autocarshop.dtos.EsportivoDTO;
import br.com.autocarshop.autocarshop.model.entities.Carro;
import br.com.autocarshop.autocarshop.model.entities.Esportivo;
import br.com.autocarshop.autocarshop.model.entities.EsportivoId;
import br.com.autocarshop.autocarshop.model.repositories.CarroRepository;
import br.com.autocarshop.autocarshop.model.repositories.EsportivoRepository;
import org.springframework.stereotype.Service;

@Service
public class EsportivoService {

    private final CarroRepository carroRepository;
    private final EsportivoRepository esportivoRepository;

    public EsportivoService(CarroRepository carroRepository, EsportivoRepository esportivoRepository) {
        this.carroRepository = carroRepository;
        this.esportivoRepository = esportivoRepository;
    }

    public Esportivo findEsportivoById(Integer id) {
        return esportivoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Esportivo not found with id: " + id));
    }

    public Esportivo saveEsportivo(Esportivo esportivo) {
        Integer idCarro = esportivo.getEsportivoId().getCodCar();

        carroRepository.findById(idCarro)
                .orElseThrow(() -> new IllegalArgumentException("Carro not found!"));

        EsportivoId newId = new EsportivoId(idCarro);

        esportivo.setEsportivoId(newId);

        return esportivoRepository.save(esportivo);
    }

    public Esportivo createEsportivo(EsportivoDTO data) {
        return saveEsportivo(new Esportivo(data));
    }

    public Esportivo actualizarEsportivo(Integer id, EsportivoDTO data) {
        Esportivo esportivo = esportivoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Esportivo not found!"));

        esportivo.getEsportivoId().setVelocidade(data.velocidade());

        return saveEsportivo(esportivo);
    }

    public void deleteEsportivo(Integer id) {
        esportivoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Esportivo not found!"));
        esportivoRepository.deleteById(id);
    }

    public Iterable<Esportivo> getAllEsportivo() {
        return esportivoRepository.findAll();
    }
}
