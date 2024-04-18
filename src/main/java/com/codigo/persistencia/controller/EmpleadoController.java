package com.codigo.persistencia.controller;


import com.codigo.persistencia.entity.Empleado;
import com.codigo.persistencia.entity.Proyecto;
import com.codigo.persistencia.service.EmpleadoService;
import com.codigo.persistencia.service.ProyectoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/empleado")
@AllArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;
    private final ProyectoService proyectoService;

    @PostMapping("/crearEmpleado")
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
        Empleado registrarEmpleado = empleadoService.guardarEmpleado(empleado);
        return ResponseEntity.ok(registrarEmpleado);
    }

    @PostMapping("/crearProyecto")
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto) {
        Proyecto registrarProyecto = proyectoService.guardarProyecto(proyecto);
        return ResponseEntity.ok(registrarProyecto);
    }

}