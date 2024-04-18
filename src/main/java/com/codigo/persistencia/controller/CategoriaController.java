package com.codigo.persistencia.controller;


import com.codigo.persistencia.entity.Categoria;
import com.codigo.persistencia.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.ContentType;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/categoria")
@AllArgsConstructor
@Tag(//Anotacion de swager que sirve para la documentacion  //A nivel de controlador
        name = "Api de categorias",
        description = "Esta api te permite registrar una categoria"
)
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping("/crearCategoria")
    @Operation(//A nivel de metodo
            summary = "Guardar una categoria en base de datos",
            description = "Para usar enPoint debes enviar un objeto categoria, lo cual se va a guardar en base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro",description = "Filtro de categorias")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(//Que es lo que responde este endPoint  //Puede ir uno solo
                    responseCode = "200",
                    description = "HTTP STATUS 200 significa registro exitoso",
                    content = @Content(mediaType = "application/json")
            ),

            @ApiResponse(//Que es lo que responde este endPoint  //Puede ir uno solo
                    responseCode = "201",
                    description = "HTTP STATUS 201 significa que se creo de manera exitosa",
                    content = @Content(mediaType = "application/json")
            ),

            @ApiResponse(//Que es lo que responde este endPoint  //Puede ir uno solo
                    responseCode = "400",
                    description = "HTTP STATUS 400 significa request esta mal",
                    content = @Content(mediaType = "application/json")
            )

    })
    /*@ApiResponse(//Que es lo que responde este endPoint  //Puede ir uno solo
            responseCode = "200",
            description = "HTTP STATUS 200 significa registro exitoso"
    )*/

    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria){
        com.codigo.persistencia.entity.Categoria registrarCategoria;
        registrarCategoria = categoriaService.registrarCategoria(categoria);
        return ResponseEntity.ok(registrarCategoria);
    }
}
