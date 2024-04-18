package com.codigo.persistencia.dao;

import com.codigo.persistencia.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
