package es.unican.rodrigo.mohamed.polafix.domain;
import es.unican.rodrigo.mohamed.polafix.controllers.Views;

import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

import es.unican.rodrigo.mohamed.polafix.controllers.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.*;
@Entity
public class Temporada {
    
    @JsonView(Views.ListaEpisodios.class)
    private int numTemporada;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnore
    private Long idTemporada;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonView(Views.ListaEpisodios.class)
    private Set<Episodio> episodio = new HashSet<Episodio>();

    protected Temporada() {}

    public Temporada(int numTemporada) {
        this.numTemporada = numTemporada;
        this.idTemporada = idTemporada;
    }

    public int getNumTemporada() {
        return numTemporada;
    }

    public void setNumTemporada(int numTemporada) {
        this.numTemporada = numTemporada;
    }

    public Long getIdTemporada() {
        return idTemporada;
    }

    public void setIdTemporada(Long idTemporada) {
        this.idTemporada = idTemporada;
    }

    public Set<Episodio> getEpisodio() {
        return episodio;
    }

    public void setEpisodio(Set<Episodio> episodio) {
        this.episodio = episodio;
    }


    @Override
    public boolean equals(Object o) { //Soy consciente que solo comparar la temporada para el equals es problematico
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Temporada temporada = (Temporada) o;
        
        return numTemporada == temporada.numTemporada;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numTemporada);
    }
}