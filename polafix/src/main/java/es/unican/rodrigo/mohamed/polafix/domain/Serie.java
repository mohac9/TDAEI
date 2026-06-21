package es.unican.rodrigo.mohamed.polafix.domain;
import es.unican.rodrigo.mohamed.polafix.controllers.Views;

import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
@Entity
public class Serie {
    @Id
    @JsonView({Views.CatalogoSeries.class,
                Views.ListasUsuario.class,
                Views.ListaEpisodios.class})
    private String nombre;
    @JsonView(Views.CatalogoSeries.class)
    private String sinopsis;
    @Embedded
    @JsonView({Views.CatalogoSeries.class,
                Views.ListaEpisodios.class})
    private Categoria categoria;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonView(Views.ListaEpisodios.class)
    private Set<Temporada> temporada = new HashSet<Temporada>();
    @ManyToMany
    @JsonView(Views.CatalogoSeries.class)
    private Set<Persona> creadores = new HashSet<Persona>();
    @ManyToMany
    @JsonView(Views.CatalogoSeries.class)
    private Set<Persona> actores = new HashSet<Persona>();

    protected Serie() {}
    
    public Serie(String nombre, String sinopsis, Categoria categoria) {
        this.nombre = nombre;
        this.sinopsis = sinopsis;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Set<Temporada> getTemporada() {
        return temporada;
    }

    public void setTemporada(Set<Temporada> temporada) {
        this.temporada = temporada;
    }

    public Set<Persona> getCreadores() {
        return creadores;
    }

    public void setCreadores(Set<Persona> creadores) {
        this.creadores = creadores;
    }

    public Set<Persona> getActores() {
        return actores;
    }

    public void setActores(Set<Persona> actores) {
        this.actores = actores;
    }

    //Este método es auxiliar, ya se que es poco eficiente
    public Episodio getUltimoEpisodio() {
        Temporada ultimaTemporada = null;
        for (Temporada t : getTemporada()) { 
            if (ultimaTemporada == null || t.getNumTemporada() > ultimaTemporada.getNumTemporada()) {
                ultimaTemporada = t;
            }
        }

        if (ultimaTemporada == null) {
            return null;
        }

        //Soy consciente que aunque ID este generado por secuencia no garantiza el orden real
        //Esto es para no cambiar el appfeeder y hacer que la app mantenga el modelo de dominio
        //La solución ideal seria si episodio tuviese un atrib numEpisodio y hacer el get por aqui
        Episodio ultimoEpisodio = null;
        for (Episodio e : ultimaTemporada.getEpisodio()) {
            if (ultimoEpisodio == null || e.getId() > ultimoEpisodio.getId()) {
                ultimoEpisodio = e;
            }
        }
        return ultimoEpisodio;
    }
    

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Serie other = (Serie) obj;
        return Objects.equals(nombre, other.nombre);
    }
}