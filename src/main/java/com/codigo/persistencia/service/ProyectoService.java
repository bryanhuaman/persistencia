package com.codigo.persistencia.service;

import com.codigo.persistencia.dao.ProyectoRepository;
import com.codigo.persistencia.entity.Proyecto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProyectoService {
    private final ProyectoRepository proyectoRepository;

    public Proyecto guardarProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }
}