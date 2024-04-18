package com.codigo.persistencia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "ventas ")
@Getter
@Setter
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "venta", cascade = {CascadeType.MERGE, CascadeType.REMOVE})//Configuracion para decir que nosotros vamos a configurar el detalle manualmente
    private Set<DetalleVenta> detalles;
}
