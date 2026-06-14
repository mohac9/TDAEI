package es.unican.rodrigo.mohamed.polafix.controllers;

import es.unican.rodrigo.mohamed.polafix.domain.Episodio;
import es.unican.rodrigo.mohamed.polafix.domain.Serie;
import es.unican.rodrigo.mohamed.polafix.services.SerieService;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import es.unican.rodrigo.mohamed.polafix.domain.Temporada;

import java.util.List;

@RestController
@RequestMapping("/api/series")
public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    // Obtener el catálogo completo de series
    @GetMapping
    @JsonView(Views.CatalogoSeries.class)
    public ResponseEntity<List<Serie>> obtenerCatalogoSeries() {
        ResponseEntity<List<Serie>> result = null;
        
        try {
            List<Serie> catalogo = serieService.obtenerTodas();
            result = ResponseEntity.status(HttpStatus.OK).body(catalogo);
        } catch (RuntimeException e) {
            // Si hay un error interno en el servicio
            result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
        return result;
    }

    // Obtener los episodios de una serie concreta
    @GetMapping("/{nombreSerie}/episodios")
    @JsonView(Views.ListaEpisodios.class)
    public ResponseEntity<Set<Temporada>> obtenerEpisodiosPorSerie(@PathVariable String nombreSerie) {
        ResponseEntity<Set<Temporada>> result = null;
        
        try {
            Set<Temporada> temporadas = serieService.obtenerEpisodios(nombreSerie);
            result = ResponseEntity.status(HttpStatus.OK).body(temporadas);
        } catch (IllegalArgumentException e) {
            // Si la serie no existe, el servicio debe lanzar IllegalArgumentException
            result = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        return result;
    }
}