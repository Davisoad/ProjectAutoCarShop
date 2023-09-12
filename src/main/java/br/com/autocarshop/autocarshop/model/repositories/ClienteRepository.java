package br.com.autocarshop.autocarshop.model.repositories;

import br.com.autocarshop.autocarshop.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
