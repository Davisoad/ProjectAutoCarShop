package br.com.autocarshop.autocarshop.model.repositories;

import br.com.autocarshop.autocarshop.model.entities.Esportivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EsportivoRepository extends JpaRepository<Esportivo, Integer> {
}
