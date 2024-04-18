package com.codigo.persistencia.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class VentaRequest {
    private Long clienteId;
    private Set<DetalleRequest> detalles;
}
