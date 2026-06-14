package es.unican.rodrigo.mohamed.polafix.services;

import es.unican.rodrigo.mohamed.polafix.domain.*;
import es.unican.rodrigo.mohamed.polafix.repositories.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacturaMensualService {

    private final FacturaMensualRepository facturaRepository;
    private final UsuarioRepository usuarioRepository;

    public FacturaMensualService(FacturaMensualRepository facturaRepository, UsuarioRepository usuarioRepository) {
        this.facturaRepository = facturaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public List<FacturaMensual> obtenerPorUsuario(String nombreUsuario) {
        Usuario u = usuarioRepository.findById(nombreUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
                
        return new java.util.ArrayList<>(u.getFacturasHistorico());
    }

    @Transactional(readOnly = true)
    public FacturaMensual obtenerPorId(String idFactura) {
        return facturaRepository.findById(idFactura)
                .orElseThrow(() -> new IllegalArgumentException("Factura no encontrada"));
    }
}