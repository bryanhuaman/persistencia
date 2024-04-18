package com.codigo.persistencia.dao;

import com.codigo.persistencia.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
