package com.codigo.persistencia.service;


import com.codigo.persistencia.dao.EmpleadoProyectoRepository;
import com.codigo.persistencia.entity.EmpleadoProyecto;
import com.codigo.persistencia.entity.EmpleadoProyectoId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmpleadoProyectoService {

    private final EmpleadoProyectoRepository empleadoProyectoRespository;

    public EmpleadoProyecto guardar(EmpleadoProyecto empleadoProyecto) {
        return empleadoProyectoRespository.save(empleadoProyecto);
    }
    public EmpleadoProyecto buscarPorId(Long empleadoId, Long proyectoId) {
        EmpleadoProyectoId id = new EmpleadoProyectoId(empleadoId, proyectoId);
        return empleadoProyectoRespository.findById(id).orElse(null);
    }
    public void eliminar(Long empleadoId, Long proyectoId) {
        EmpleadoProyectoId id = new EmpleadoProyectoId(empleadoId, proyectoId);
        empleadoProyectoRespository.deleteById(id);
    }
}