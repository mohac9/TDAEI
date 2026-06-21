package es.unican.rodrigo.mohamed.polafix.domain;
import es.unican.rodrigo.mohamed.polafix.controllers.Views;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.*;
@Entity
public class Episodio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @JsonView(Views.ListaEpisodios.class)
    private String nombre;
    @JsonView(Views.ListaEpisodios.class)
    private String sinopsis;
    @ManyToOne
    @JsonIgnore
    private Serie serie;
    @ManyToOne
    @JsonIgnore
    private Temporada temporada;

    protected Episodio() {}

    public Episodio(String nombre, String sinopsis, Serie serie, Temporada temporada) {
        this.nombre = nombre;
        this.sinopsis = sinopsis;
        this.serie = serie;
        this.temporada = temporada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public long getId(){
        return this.id;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

}
