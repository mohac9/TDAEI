package es.unican.rodrigo.mohamed.polafix;
import jakarta.persistence.*;

@Entity
public class Episodio {
    private int numEpisodio;
    private int temporada;
    private String sinopsis;
    @Id
    private int id;
    private String nombre;

    public Episodio() {
    }


    public Episodio(int numEpisodio, int temporada, String nombre, String sinopsis) {
    this.numEpisodio = numEpisodio;
    this.temporada = temporada;
    this.nombre = nombre;
    this.sinopsis = sinopsis;
}


    public int getNumEpisodio() {
        return numEpisodio;
    }

    public void setNumEpisodio(int numEpisodio) {
        this.numEpisodio = numEpisodio;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
