package es.unican.rodrigo.mohamed.polafix.domain;
import es.unican.rodrigo.mohamed.polafix.controllers.Views;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class SeguimientoEpisodio {
    @OneToOne
    private Episodio episodio;
    private Date fechaVisto;

    protected SeguimientoEpisodio() {}

    public SeguimientoEpisodio(Episodio episodio) {
        this.episodio = episodio;
        this.fechaVisto = new Date(); 
    }

    
    public Episodio getEpisodio() {
        return episodio;
    }

    public void setEpisodio(Episodio episodio) {
        this.episodio = episodio;
    }

    public Date getFechaVisto() {
        return fechaVisto;
    }

    public void setFechaVisto(Date fechaVisto) {
        this.fechaVisto = fechaVisto;
    }

  
}
