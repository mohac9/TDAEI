package es.unican.rodrigo.mohamed.polafix.domain;
import es.unican.rodrigo.mohamed.polafix.controllers.Views;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.*;
@Embeddable
public class PlanCuota {
    public TipoCuota cuotaTipo;
    public double precio;

    protected PlanCuota() {}

    public PlanCuota(TipoCuota cuotaTipo, double precio) {
        this.cuotaTipo = cuotaTipo;
        this.precio = precio;
    }
    public TipoCuota getCuotaTipo() {
        return cuotaTipo;
    }

    public void setCuotaTipo(TipoCuota cuotaTipo) {
        this.cuotaTipo = cuotaTipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}