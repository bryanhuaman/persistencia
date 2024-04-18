package com.codigo.persistencia.dao;

import com.codigo.persistencia.entity.EmpleadoProyecto;
import com.codigo.persistencia.entity.EmpleadoProyectoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoProyectoRepository extends JpaRepository<EmpleadoProyecto, EmpleadoProyectoId>{
}
