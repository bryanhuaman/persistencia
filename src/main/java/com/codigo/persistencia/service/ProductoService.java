package com.codigo.persistencia.service;

import com.codigo.persistencia.dao.CategoriaRepository;
import com.codigo.persistencia.dao.ProductoRepository;
import com.codigo.persistencia.entity.Categoria;
import com.codigo.persistencia.entity.Producto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProductoService {

    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    @Transactional
    public Producto agregarProductoConCategorias(Producto producto, Set<Long> categoriaIds){
        List<Categoria> categoriaList = categoriaRepository.findAllById(categoriaIds);
        Set<Categoria> categorias = new HashSet<>(categoriaList);
        producto.setCategorias(categorias);
        return productoRepository.save(producto);

    }
}
