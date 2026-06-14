package es.unican.rodrigo.mohamed.polafix.services;

import es.unican.rodrigo.mohamed.polafix.domain.*;
import es.unican.rodrigo.mohamed.polafix.repositories.*;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class SerieService {
    private final SerieRepository serieRepository;

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Transactional(readOnly = true)
    public List<Serie> obtenerTodas() {
        return serieRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Set<Temporada> obtenerEpisodios(String nombreSerie) {
        Serie serie = serieRepository.findById(nombreSerie)
                .orElseThrow(() -> new IllegalArgumentException("Serie no encontrada"));
            
        return serie.getTemporada();
    }
}