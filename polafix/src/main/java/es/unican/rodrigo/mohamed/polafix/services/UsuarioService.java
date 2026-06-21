package es.unican.rodrigo.mohamed.polafix.services;

import es.unican.rodrigo.mohamed.polafix.domain.*;
import es.unican.rodrigo.mohamed.polafix.repositories.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final SerieRepository serieRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, SerieRepository serieRepository) {
        this.usuarioRepository = usuarioRepository;
        this.serieRepository = serieRepository;
    }

    @Transactional
    public Usuario registrarUsuario(String nombre, String password, String iban) {
        if (usuarioRepository.existsById(nombre)) {
            throw new IllegalArgumentException("El usuario ya existe");
        }
        Usuario nuevoUsuario = new Usuario(nombre,password,iban);
        return usuarioRepository.save(nuevoUsuario);
    }

    @Transactional(readOnly = true)
    public Usuario loginUsuario(String nombre, String password) {
        Usuario usuario = usuarioRepository.findById(nombre)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        if (!usuario.getPassword().equals(password)) {
            throw new IllegalArgumentException("Contraseña incorrecta");
        }
        return usuario;
    }

    @Transactional
    public Usuario modificarListaSerie(String nombreUsuario, String nombreSerie, String estado){
        Usuario u = usuarioRepository.findById(nombreUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        Serie s = serieRepository.findById(nombreSerie)
                .orElseThrow(() -> new IllegalArgumentException("Serie no encontrada"));
        //Logica
        switch (estado.toUpperCase()){
            case "EMPEZADA":
                u.anadirEmpezada(s);
                u.quitarPendiente(s); //Idempotente
                break;
            case "PENDIENTE":
                u.anadirPendiente(s);
                break;
            case "TERMINADA":
                u.anadirTerminada(s);
                u.quitarEmpezada(s); //Idempotente
                break;
            default:
                throw new RuntimeException("Estado no válido");
        }
        return usuarioRepository.save(u);


    }

    @Transactional(readOnly = true)
    public Usuario obtenerSeriesUsuario(String nombreUsuario) {
        Usuario u = usuarioRepository.findById(nombreUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        return u;
    }


    @Transactional
    public Usuario verEpisodio(String nombreUsuario, String nombreSerie, String nombreEpisodio) {
        Usuario u = usuarioRepository.findById(nombreUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
                
        Serie s = serieRepository.findById(nombreSerie)
                .orElseThrow(() -> new IllegalArgumentException("Serie no encontrada"));
                
        Episodio episodioVisto = null;
        
        for (Temporada temporada : s.getTemporada()) {
            for (Episodio episodio : temporada.getEpisodio()) {
                if (episodio.getNombre().equals(nombreEpisodio)) {
                    episodioVisto = episodio;
                    break; 
                }
            }
            if (episodioVisto != null) {
                break; 
            }
        }
        
        if (episodioVisto == null) {
            throw new IllegalArgumentException("Episodio no encontrado en esta serie");
        }
                
        u.verEpisodio(episodioVisto);
        
        return usuarioRepository.save(u);

    }




}