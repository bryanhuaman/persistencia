package com.codigo.persistencia.controller;

import com.codigo.persistencia.entity.Categoria;
import com.codigo.persistencia.entity.Producto;
import com.codigo.persistencia.request.ProductoRequest;
import com.codigo.persistencia.service.CategoriaService;
import com.codigo.persistencia.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/productos")
@AllArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping("/crearProducto")
    public ResponseEntity<Producto> crearProductoConCategoria(@RequestBody ProductoRequest request){
        Producto nuevoproducto = new Producto();
        nuevoproducto.setNombre(request.getNombre());
        nuevoproducto.setPrecio(request.getPrecio());
        Producto productoGuardado = productoService.agregarProductoConCategorias(nuevoproducto,request.getCategoriaIds());
        return ResponseEntity.ok(productoGuardado);
    }
}
