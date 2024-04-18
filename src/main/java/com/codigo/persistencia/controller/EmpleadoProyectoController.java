package com.codigo.persistencia.controller;

import com.codigo.persistencia.entity.Empleado;
import com.codigo.persistencia.entity.EmpleadoProyecto;
import com.codigo.persistencia.service.EmpleadoProyectoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/empleadoProyecto/")
@AllArgsConstructor
@Tag(
        name = "Api de EmpleadoProyecto",
        description = "Esta api te permite registrar, buscar o eliminar un EmpleadoProyecto"
)
public class EmpleadoProyectoController {

    private final EmpleadoProyectoService empleadoProyectoService;

    @PostMapping("/crearEmpleadoProyecto")
    @Operation(
            summary = "Guardar una EmpleadoProyecto en la base de datos",
            description = "Para usar enPoint debes enviar un objeto EmpleadoProyecto, lo cual se va a guardar en base de datos previa validacion"
    )
    @ApiResponses(value = {
            @ApiResponse(//Que es lo que responde este endPoint  //Puede ir uno solo
                    responseCode = "200",
                    description = "HTTP STATUS 200 significa registro exitoso",
                    content = @Content(mediaType = "application/json")
            )

    })
    public ResponseEntity<EmpleadoProyecto> agregarEmpleadoAProyecto(@RequestBody EmpleadoProyecto empleadoProyecto) {
        EmpleadoProyecto nuevoEmpleadoProyecto = empleadoProyectoService.guardar(empleadoProyecto);
        return ResponseEntity.ok(nuevoEmpleadoProyecto);
    }

    @GetMapping("/{empleadoId}/{proyectoId}")
    @Operation(
            summary = "Obtener un EmpleadoProyecto en base de datos",
            description = "Para usar enPoint debes enviar un empleadoId y proyectoId, lo cual se va a guardar en base de datos previa validacion",
            parameters = {
                    @Parameter(name = "empleadoId"),
                    @Parameter(name = "proyectoId")

            }
    )
    @ApiResponses(value = {
            @ApiResponse(//Que es lo que responde este endPoint  //Puede ir uno solo
                    responseCode = "200",
                    description = "HTTP STATUS 200 significa registro exitoso",
                    content = @Content(mediaType = "application/json")
            )

    })
    public ResponseEntity<EmpleadoProyecto> obtenerEmpleadoProyecto(@PathVariable Long empleadoId, @PathVariable Long proyectoId) {
        EmpleadoProyecto empleadoProyecto = empleadoProyectoService.buscarPorId(empleadoId, proyectoId);
        if (empleadoProyecto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empleadoProyecto);
    }

    @DeleteMapping("/{empleadoId}/{proyectoId}")
    @Operation(
            summary = "Eliminar un EmpleadoProyecto en base de datos",
            description = "Para usar enPoint debes enviar un empleadoId y proyectoId, lo cual se va a guardar en base de datos previa validacion",
            parameters = {
                    @Parameter(name = "empleadoId"),
                    @Parameter(name = "proyectoId")
                    
            }
    )
    @ApiResponses(value = {
            @ApiResponse(//Que es lo que responde este endPoint  //Puede ir uno solo
                    responseCode = "200",
                    description = "HTTP STATUS 200 significa registro exitoso",
                    content = @Content(mediaType = "application/json")
            )

    })
    public ResponseEntity<Void> eliminarEmpleadoProyecto(@PathVariable Long empleadoId, @PathVariable Long proyectoId) {
        empleadoProyectoService.eliminar(empleadoId, proyectoId);
        return ResponseEntity.ok().build();
    }
}