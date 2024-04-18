package com.codigo.persistencia.controller;

import com.codigo.persistencia.dao.ClienteRepository;
import com.codigo.persistencia.dao.ProductoRepository;
import com.codigo.persistencia.entity.Cliente;
import com.codigo.persistencia.entity.DetalleVenta;
import com.codigo.persistencia.entity.Producto;
import com.codigo.persistencia.entity.Venta;
import com.codigo.persistencia.request.DetalleRequest;
import com.codigo.persistencia.request.VentaRequest;
import com.codigo.persistencia.service.VentaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/ventas")
@AllArgsConstructor
public class VentaController {


    private final VentaService ventaService;
    private final ClienteRepository clienteRepository;
    private  final ProductoRepository productoRepository;

    @PostMapping("/crearVenta")
    public ResponseEntity<Venta> crearVenta(@RequestBody VentaRequest ventaRequest) {
        Cliente cliente = clienteRepository.findById(ventaRequest.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Venta nuevaVenta = new Venta();
        nuevaVenta.setCliente(cliente);

        Set<DetalleVenta> detalles = new HashSet<>();
        for (DetalleRequest detalleDto : ventaRequest.getDetalles()) {
            Producto producto = productoRepository.findById(detalleDto.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setProducto(producto);
            detalleVenta.setCantidad(detalleDto.getCantidad());
            detalles.add(detalleVenta);
        }

        nuevaVenta.setDetalles(detalles);
        Venta ventaGuardada = ventaService.registrarVenta(nuevaVenta, detalles);
        return ResponseEntity.ok(ventaGuardada);
    }
}