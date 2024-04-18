package com.codigo.persistencia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "empleado_proyecto")
@Getter
@Setter
public class EmpleadoProyecto {
    @EmbeddedId
    private EmpleadoProyectoId id;

    @Column(name = "rol")
    private String rol;
}