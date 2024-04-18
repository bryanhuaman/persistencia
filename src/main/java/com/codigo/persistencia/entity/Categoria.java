package com.codigo.persistencia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "categorias")
@Getter
@Setter
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")//Column : define el nombre de la columna en BD
    private String nombre;

    @JsonIgnore //Al hacer una lista de categorias no toma en cuenta este atributo
    @ManyToMany(mappedBy = "categorias")
    private Set<Producto> productos;
}
