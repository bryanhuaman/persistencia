package com.codigo.persistencia.dao;

import com.codigo.persistencia.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Long> {
}
