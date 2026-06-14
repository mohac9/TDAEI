package es.unican.rodrigo.mohamed.polafix.domain;
import es.unican.rodrigo.mohamed.polafix.controllers.Views;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.*;
@Entity
public class Persona {
    @JsonView(Views.CatalogoSeries.class)
    public String nombreCompleto;
    @Id
    @JsonIgnore
    public String NIE;

    protected Persona() {}

    public Persona(String nombreCompleto, String NIE) {
        this.nombreCompleto = nombreCompleto;
        this.NIE = NIE;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNIE() {
        return NIE;
    }

    public void setNIE(String NIE) {
        this.NIE = NIE;
    }
}
