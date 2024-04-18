package com.codigo.persistencia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor //Da un construcctor vacio
public class EmpleadoProyectoId implements Serializable {//Serializable: Objetos y atributos se pueden convertir en flujo de bytes para que pueda enterder a que hacer referencia los atributos
    @Column(name = "empleado_id")
    private Long empleadoId;

    @Column(name = "proyecto_id")
    private Long proyectoId;
}
