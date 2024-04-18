package com.codigo.persistencia.service;

import com.codigo.persistencia.dao.CategoriaRepository;
import com.codigo.persistencia.entity.Categoria;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

//LOGICA DE NEGOCIO
@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Transactional //Si ocurrio un error en una tabla intermedia desase los que se hizo anteriormente y devuelve un error
    public Categoria registrarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
}
