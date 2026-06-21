package es.unican.rodrigo.mohamed.polafix.domain;

import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

import es.unican.rodrigo.mohamed.polafix.controllers.Views;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Usuario {
    
    @Id
    @JsonView({Views.InfoBasicaUsuario.class,
                Views.ListasUsuario.class,
                Views.FacturaYCargos.class})
    private String nombre;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String IBAN;
    @OneToMany //No hay cascada ya que facturas no se eliminan al eliminar un usuario, se mantienen para el histórico
    @JoinColumn(name = "usuario")
    @JsonView(Views.FacturaYCargos.class)
    private Set<FacturaMensual> facturasHistorico = new HashSet<FacturaMensual> ();
    @ManyToMany
    @JsonView(Views.ListasUsuario.class)
    private Set<Serie> empezadas = new HashSet<Serie> ();
    @ManyToMany
    @JsonView(Views.ListasUsuario.class)
    private Set<Serie> pendientes = new HashSet<Serie> ();
    @ManyToMany
    @JsonView(Views.ListasUsuario.class)
    private Set<Serie> terminadas = new HashSet<Serie> ();
    @ManyToMany
    @JsonIgnore // No se expone en la API, ya que es un conjunto interno de series agregadas por el usuario
    private Set<Serie> seriesAgregadas = new HashSet<Serie> ();
    @ElementCollection
    @JsonView(Views.ListaEpisodios.class)
    private Set<SeguimientoEpisodio> episodiosVistos = new HashSet<SeguimientoEpisodio> ();
    
    protected Usuario() {}

    public Usuario(String nombre, String password, String IBAN) {
    this.nombre = nombre;
    this.password = password;
    this.IBAN = IBAN;
    }
    
    
    public void verEpisodio(final Episodio episodio) {
        if (episodio == null) return;
        SeguimientoEpisodio seguimiento = new SeguimientoEpisodio(episodio);
        Serie serie = episodio.getSerie();
        if(getPendientes().contains(serie)){
            anadirEmpezada(serie);
        }

        if(serie.getUltimoEpisodio().equals(episodio)){
            anadirTerminada(serie);
        }

        episodiosVistos.add(seguimiento);
    }
    public void agregarSerie(final Serie serie) {
        if (serie == null) return;
        seriesAgregadas.add(serie);
        pendientes.add(serie);
    }

    // Métodos para añadir series a los conjuntos correspondientes
    public boolean anadirEmpezada(final Serie serie) {
        if (serie == null) return false;
        pendientes.remove(serie);
        return empezadas.add(serie);
    }

    public boolean anadirPendiente(final Serie serie) {
        if (serie == null) return false;
        return pendientes.add(serie);
    }

    public boolean anadirTerminada(final Serie serie) {
        if (serie == null) return false;
        //Solo se mira el último episodio para determinar si una serie esta terminada
        //Por relleno
        terminadas.remove(serie);
        empezadas.remove(serie);
        return terminadas.add(serie);
    }

    public boolean anadirSerieAgregada(final Serie serie) {
        if (serie == null) return false;
        return seriesAgregadas.add(serie);
    }

    // Métodos para quitar series de los conjuntos correspondientes
    public boolean quitarEmpezada(final Serie serie) {
        if (serie == null) return false;
        return empezadas.remove(serie);
    }

    public boolean quitarPendiente(final Serie serie) {
        if (serie == null) return false;
        return pendientes.remove(serie);
    }

    public boolean quitarTerminada(final Serie serie) {
        if (serie == null) return false;
        return terminadas.remove(serie);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public Set<FacturaMensual> getFacturasHistorico() {
        return facturasHistorico;
    }

    public void setFacturasHistorico(Set<FacturaMensual> facturasHistorico) {
        this.facturasHistorico = facturasHistorico;
    }

    public Set<Serie> getEmpezadas() {
        return empezadas;
    }

    public void setEmpezadas(Set<Serie> empezadas) {
        this.empezadas = empezadas;
    }

    public Set<Serie> getPendientes() {
        return pendientes;
    }

    public void setPendientes(Set<Serie> pendientes) {
        this.pendientes = pendientes;
    }

    public Set<Serie> getTerminadas() {
        return terminadas;
    }

    public void setTerminadas(Set<Serie> terminadas) {
        this.terminadas = terminadas;
    }

    public Set<Serie> getSeriesAgregadas() {
        return seriesAgregadas;
    }

    public void setSeriesAgregadas(Set<Serie> seriesAgregadas) {
        this.seriesAgregadas = seriesAgregadas;
    }

    public Set<SeguimientoEpisodio> getEpisodiosVistos() {
        return episodiosVistos;
    }

    public void setEpisodiosVistos(Set<SeguimientoEpisodio> episodiosVistos) {
        this.episodiosVistos = episodiosVistos;
    }

    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre);
    }

    public int hashCode() {
        return Objects.hash(nombre);
    }
    
}
