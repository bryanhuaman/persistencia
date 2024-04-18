package com.codigo.persistencia.dao;

import com.codigo.persistencia.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository  extends JpaRepository<Proyecto,Long> {
}
