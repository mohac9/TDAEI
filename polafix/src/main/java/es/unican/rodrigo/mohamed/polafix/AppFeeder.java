package es.unican.rodrigo.mohamed.polafix;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional; 

import es.unican.rodrigo.mohamed.polafix.domain.Categoria;
import es.unican.rodrigo.mohamed.polafix.domain.CategoriaSerie;
import es.unican.rodrigo.mohamed.polafix.domain.Serie;
import es.unican.rodrigo.mohamed.polafix.domain.Usuario;
import es.unican.rodrigo.mohamed.polafix.domain.Temporada;
import es.unican.rodrigo.mohamed.polafix.domain.Episodio;
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
    @Transactional 
    public void run(String... args) throws Exception {

        usuarioRepository.deleteAll();
        serieRepository.deleteAll();

        System.out.println("--- Iniciando AppFeeder: Cargando datos de prueba ---");
        
        Categoria catStandart = new Categoria(CategoriaSerie.ESTANDAR,"0.50");
        Categoria catSilver = new Categoria(CategoriaSerie.SILVER, "0.75");
        Categoria catGold = new Categoria(CategoriaSerie.GOLD, "1.50");
        
        Serie serie1 = new Serie("Breaking Bad", "Un profesor de química cambia de vida...", catSilver);
        Serie serie2 = new Serie("The Sopranos", "La vida de un mafioso de Nueva Jersey...", catGold);
        Serie serie3 = new Serie("Padre de Familia", "Las aventuras de Petter Griffin y su familia disfuncional", catSilver);
        Serie serie4 = new Serie("Young Sheldon", "La vida de un niño prodigio de 9 años...", catGold);

        Temporada bbT1 = new Temporada(1);
        bbT1.getEpisodio().add(new Episodio("Piloto", "Walter descubre su enfermedad", serie1, bbT1));
        bbT1.getEpisodio().add(new Episodio("El gato en el saco", "Lidiando con Krazy-8", serie1, bbT1));
        bbT1.getEpisodio().add(new Episodio("Y la bolsa está en el río", "Limpiando el desastre", serie1, bbT1));

        Temporada bbT2 = new Temporada(2);
        bbT2.getEpisodio().add(new Episodio("Siete treinta y siete", "El trato con Tuco", serie1, bbT2));
        bbT2.getEpisodio().add(new Episodio("Asado", "La búsqueda comienza", serie1, bbT2));
        bbT2.getEpisodio().add(new Episodio("Mordedura", "Una nueva tapadera", serie1, bbT2));

        serie1.getTemporada().add(bbT1);
        serie1.getTemporada().add(bbT2);

        Temporada tsT1 = new Temporada(1);
        tsT1.getEpisodio().add(new Episodio("Piloto", "Tony comienza terapia", serie2, tsT1));
        tsT1.getEpisodio().add(new Episodio("46 Largo", "Problemas con camiones", serie2, tsT1));
        tsT1.getEpisodio().add(new Episodio("Negación", "Problemas familiares", serie2, tsT1));

        Temporada tsT2 = new Temporada(2);
        tsT2.getEpisodio().add(new Episodio("El tipo que camina", "Pussy regresa", serie2, tsT2));
        tsT2.getEpisodio().add(new Episodio("No reanimar", "Livia en el hospital", serie2, tsT2));
        tsT2.getEpisodio().add(new Episodio("Tonterías", "Nuevo jefe en escena", serie2, tsT2));

        serie2.getTemporada().add(tsT1);
        serie2.getTemporada().add(tsT2);

        Temporada pfT1 = new Temporada(1);
        pfT1.getEpisodio().add(new Episodio("La muerte tiene una sombra", "Peter pierde su trabajo", serie3, pfT1));
        pfT1.getEpisodio().add(new Episodio("Yo nunca conocí a los muertos", "Enseñando a conducir", serie3, pfT1));
        pfT1.getEpisodio().add(new Episodio("Cachivache mental", "Máquina del tiempo", serie3, pfT1));

        Temporada pfT2 = new Temporada(2);
        pfT2.getEpisodio().add(new Episodio("Peter rico", "Una herencia inesperada", serie3, pfT2));
        pfT2.getEpisodio().add(new Episodio("Dios, qué idiota", "El fin del mundo", serie3, pfT2));
        pfT2.getEpisodio().add(new Episodio("La historia de Brian", "Terapia canina", serie3, pfT2));

        serie3.getTemporada().add(pfT1);
        serie3.getTemporada().add(pfT2);

        serieRepository.save(serie1);
        serieRepository.save(serie2);
        serieRepository.save(serie3);
        serieRepository.save(serie4);
        
        System.out.println("Series, temporadas y episodios cargados exitosamente.");

        Usuario user1 = new Usuario("rdr1", "000", "ES1234567890");
        Usuario user2 = new Usuario("rms2", "111", "ES0987654321");
        Usuario userIris = new Usuario("Iris", "1234", "ES1122334455");

        userIris.anadirEmpezada(serie1);
        userIris.anadirTerminada(serie2);
        userIris.anadirPendiente(serie3);

        usuarioRepository.save(user1);
        usuarioRepository.save(user2);
        usuarioRepository.save(userIris);
        
        System.out.println("Usuarios cargados exitosamente.");
        System.out.println("--- AppFeeder finalizado ---");
    }
}