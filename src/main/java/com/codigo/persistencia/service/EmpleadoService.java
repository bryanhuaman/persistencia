package com.codigo.persistencia.service;

import com.codigo.persistencia.dao.EmpleadoRepository;
import com.codigo.persistencia.entity.Empleado;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
}