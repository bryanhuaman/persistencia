package com.codigo.persistencia.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalleRequest {
    private Long productoId;
    private int cantidad;
}
