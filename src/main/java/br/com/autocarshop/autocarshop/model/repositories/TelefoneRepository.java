package br.com.autocarshop.autocarshop.model.repositories;

import br.com.autocarshop.autocarshop.model.entities.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {
}
