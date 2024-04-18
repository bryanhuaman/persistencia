package com.codigo.persistencia.service;

import com.codigo.persistencia.dao.ClienteRepository;
import com.codigo.persistencia.dao.DetalleVentaRepository;
import com.codigo.persistencia.dao.VentaRepository;
import com.codigo.persistencia.entity.Cliente;
import com.codigo.persistencia.entity.DetalleVenta;
import com.codigo.persistencia.entity.Venta;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class VentaService {
    private final VentaRepository ventaRepository;
    private final DetalleVentaRepository detalleVentaRepository;
    private final ClienteRepository clienteRepository;

    @Transactional
    public Venta registrarVenta(Venta venta, Set<DetalleVenta> detalles) {
        Cliente cliente = clienteRepository.findById(venta.getCliente().getId()).orElse(null);

        venta.setCliente(cliente);
        venta = ventaRepository.save(venta);

        for (DetalleVenta detalle : detalles) {
            detalle.setVenta(venta);
            detalleVentaRepository.save(detalle);
        }
        venta.setDetalles(detalles);
        return venta;
    }
}