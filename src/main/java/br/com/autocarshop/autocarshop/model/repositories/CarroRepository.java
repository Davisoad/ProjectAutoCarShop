package br.com.autocarshop.autocarshop.model.repositories;

import br.com.autocarshop.autocarshop.model.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Integer> {
}
