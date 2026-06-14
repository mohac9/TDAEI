package es.unican.rodrigo.mohamed.polafix;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.unican.rodrigo.mohamed.polafix.domain.Categoria;
import es.unican.rodrigo.mohamed.polafix.domain.CategoriaSerie;
import es.unican.rodrigo.mohamed.polafix.domain.Serie;
import es.unican.rodrigo.mohamed.polafix.domain.Usuario;
import es.unican.rodrigo.mohamed.polafix.repositories.SerieRepository;
import es.unican.rodrigo.mohamed.polafix.repositories.UsuarioRepository;

@Component
public class AppFeeder implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final SerieRepository serieRepository;

    public AppFeeder(UsuarioRepository usuarioRepository, SerieRepository serieRepository) {
        this.usuarioRepository = usuarioRepository;
        this.serieRepository = serieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Iniciando AppFeeder: Cargando datos de prueba ---");

        // 1. Crear  usuarios
        Usuario user1 = new Usuario("rdr1", "000", "1");
        Usuario user2 = new Usuario("rms2", "111", "2");
        
        // Guardarlos en la BD
        usuarioRepository.save(user1);
        usuarioRepository.save(user2);
        System.out.println("Usuarios cargados exitosamente.");

        // 2. Crear  series
        Categoria catSilver = new Categoria(CategoriaSerie.SILVER, "2.50");
        Serie serie1 = new Serie("Breaking Bad", "Un profesor de química cambia de vida...", catSilver);
        
        Categoria catGold = new Categoria(CategoriaSerie.GOLD, "4.00");
        Serie serie2 = new Serie("The Sopranos", "La vida de un mafioso de Nueva Jersey...", catGold);

        // Guardar  en la BD
        serieRepository.save(serie1);
        serieRepository.save(serie2);
        System.out.println("Series cargadas exitosamente.");

        System.out.println("--- AppFeeder finalizado ---");
    }
}