package es.unican.rodrigo.mohamed.polafix.domain;
import es.unican.rodrigo.mohamed.polafix.controllers.Views;

import java.util.Date;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;


@Embeddable
public class Cargo {
    @JsonView(Views.FacturaYCargos.class)
    private Date fecha;
    @JsonView(Views.FacturaYCargos.class)
    private double importe;
    @ManyToOne
    @JsonView(Views.FacturaYCargos.class)
    private Episodio episodio; 

    protected Cargo() {}

    public Cargo(Date fecha,Episodio episodio) {
        this.fecha = fecha;
        this.importe = calcularImporte();
        this.episodio = episodio;
    }

    public double calcularImporte() {
        // Lógica no implementada. 
        return 0.0;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Episodio getEpisodio() {
        return episodio;
    }

    public void setEpisodio(Episodio episodio) {
        this.episodio = episodio;
    }
}