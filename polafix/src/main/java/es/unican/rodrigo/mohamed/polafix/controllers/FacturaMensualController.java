package es.unican.rodrigo.mohamed.polafix.controllers;

import es.unican.rodrigo.mohamed.polafix.domain.FacturaMensual;
import es.unican.rodrigo.mohamed.polafix.services.FacturaMensualService;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FacturaMensualController {

    private final FacturaMensualService facturaService;

    public FacturaMensualController(FacturaMensualService facturaService) {
        this.facturaService = facturaService;
    }

    // Obtener el historial de facturas de un usuario
    @GetMapping("/usuarios/{nombreUsuario}/facturas")
    @JsonView(Views.FacturaYCargos.class)
    public ResponseEntity<List<FacturaMensual>> obtenerFacturasUsuario(@PathVariable String nombreUsuario) {
        ResponseEntity<List<FacturaMensual>> result = null;
        
        try {
            List<FacturaMensual> facturas = facturaService.obtenerPorUsuario(nombreUsuario);
            result = ResponseEntity.status(HttpStatus.OK).body(facturas);
        } catch (IllegalArgumentException e) {
            // Si el usuario no existe
            result = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        return result;
    }

    // Obtener el detalle de una factura concreta por su ID
    @GetMapping("/facturas/{idFactura}")
    @JsonView(Views.FacturaYCargos.class)
    public ResponseEntity<FacturaMensual> obtenerDetalleFactura(@PathVariable String idFactura) {
        ResponseEntity<FacturaMensual> result = null;
        
        try {
            FacturaMensual factura = facturaService.obtenerPorId(idFactura);
            result = ResponseEntity.status(HttpStatus.OK).body(factura);
        } catch (IllegalArgumentException e) {
            // Si la factura no existe
            result = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        return result;
    }
}