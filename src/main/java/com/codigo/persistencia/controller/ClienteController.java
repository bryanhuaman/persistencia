package com.codigo.persistencia.controller;

import com.codigo.persistencia.entity.Categoria;
import com.codigo.persistencia.entity.Cliente;
import com.codigo.persistencia.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cliente")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/crearCliente")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente registrarCliente = clienteService.registrarCliente(cliente);
        return ResponseEntity.ok(registrarCliente);
    }
}