package br.com.autocarshop.autocarshop.model.repositories;

import br.com.autocarshop.autocarshop.model.entities.Aluga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlugaRepository extends JpaRepository<Aluga, Integer> {
}
