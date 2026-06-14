package es.unican.rodrigo.mohamed.polafix.controllers;

import es.unican.rodrigo.mohamed.polafix.domain.Serie;
import es.unican.rodrigo.mohamed.polafix.domain.Usuario;
import es.unican.rodrigo.mohamed.polafix.services.UsuarioService;
import es.unican.rodrigo.mohamed.polafix.api.dto.*;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registro")
    @JsonView(Views.InfoBasicaUsuario.class)
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody RegistroUsuarioRequest peticion) {
        ResponseEntity<Usuario> result = null;
        try {
            Usuario u = usuarioService.registrarUsuario(
                    peticion.getNombre(),
                    peticion.getPassword(),
                    peticion.getIban()
            );
            result = ResponseEntity.status(HttpStatus.CREATED).body(u);
        } catch(IllegalArgumentException e) {
            result = ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return result;
    }

    @PostMapping("/login")
    @JsonView(Views.InfoBasicaUsuario.class) 
    public ResponseEntity<Usuario> loginUsuario(@RequestBody LoginRequest peticion) { 
        ResponseEntity<Usuario> result = null;
        try {
            Usuario u = usuarioService.loginUsuario(
                    peticion.getNombre(), 
                    peticion.getPassword()
            );
            result = ResponseEntity.status(HttpStatus.OK).body(u);
        } catch(IllegalArgumentException e) {
            result = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return result;
    }

    @GetMapping("/{nombreUsuario}/series")
    @JsonView(Views.ListasUsuario.class)
    public ResponseEntity<Set<Serie>> obtenerSeriesUsuario(@PathVariable String nombreUsuario) {
        ResponseEntity<Set<Serie>> result = null;
        try {
            Set<Serie> series = usuarioService.obtenerSeriesUsuario(nombreUsuario);
            result = ResponseEntity.status(HttpStatus.OK).body(series);
        } catch(IllegalArgumentException e) {
            result = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return result;
    }

    @PostMapping("/{nombreUsuario}/series")
    @JsonView(Views.ListasUsuario.class)
    public ResponseEntity<Usuario> clasificarSerieUsuario(
            @PathVariable String nombreUsuario,
            @RequestBody ModificarListaSerieRequest peticion) {
        ResponseEntity<Usuario> result = null;
        try {
            Usuario u = usuarioService.modificarListaSerie(
                    nombreUsuario, 
                    peticion.getNombreSerie(), 
                    peticion.getEstado().name() 
            );
            result = ResponseEntity.ok(u);
        } catch(RuntimeException e) {
            result = ResponseEntity.notFound().build();
        }
        return result;
    }

    @PostMapping("/{nombreUsuario}/episodios-vistos")
    @JsonView(Views.ListaEpisodios.class)
    public ResponseEntity<Usuario> marcarEpisodioVisto(
            @PathVariable String nombreUsuario, 
            @RequestBody EpisodioVistoRequest peticion) {
        ResponseEntity<Usuario> result = null;
        try {
            Usuario u = usuarioService.verEpisodio(
                    nombreUsuario, 
                    peticion.getNombreSerie(), 
                    peticion.getNombreEpisodio()
            );
            result = ResponseEntity.ok(u);
        } catch(RuntimeException e) {
            result = ResponseEntity.notFound().build();
        }
        return result;
    }
}