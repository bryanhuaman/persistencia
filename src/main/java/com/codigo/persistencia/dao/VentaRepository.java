package com.codigo.persistencia.dao;

import com.codigo.persistencia.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta,Long> {
}
