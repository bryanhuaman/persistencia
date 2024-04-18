package com.codigo.persistencia.service;

import com.codigo.persistencia.dao.ClienteRepository;
import com.codigo.persistencia.entity.Cliente;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente registrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
