package es.unican.rodrigo.mohamed.polafix.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Date;
import jakarta.persistence.*;

import es.unican.rodrigo.mohamed.polafix.controllers.Views;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
@Entity
public class FacturaMensual {
    @Id
    @JsonIgnore
    private String idFactura;
    @JsonView(Views.FacturaYCargos.class)
    private int anho;
    @JsonView(Views.FacturaYCargos.class)
    private String mes;
    @Embedded
    @JsonIgnore
    private PlanCuota plan; 
    @ElementCollection
    @JsonView(Views.FacturaYCargos.class)
    private Set<Cargo> cargos = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "facturasHistorico")
    private Usuario usuario;

    protected FacturaMensual() {}

    public FacturaMensual(String idFactura, int anho, String mes, PlanCuota plan) {
        this.idFactura = idFactura;
        this.anho = anho;
        this.mes = mes;
        this.plan = plan;
    }

    public void anhadirCargo(Episodio episodio) {
        if (episodio == null) return;
        Cargo nuevoCargo = new Cargo(new Date(), episodio);
        this.cargos.add(nuevoCargo);
    }

    public double calcularCoste() {

        
        return 0.0;
    }

    public String getIdFactura() { return idFactura; }
    public void setIdFactura(String idFactura) { this.idFactura = idFactura; }

    public int getAnho() { return anho; }
    public void setAnho(int anho) { this.anho = anho; }

    public String getMes() { return mes; }
    public void setMes(String mes) { this.mes = mes; }

    public PlanCuota getPlan() { return plan; }
    public void setPlan(PlanCuota plan) { this.plan = plan; }

    public Set<Cargo> getCargos() { return cargos; }
    public void setCargos(Set<Cargo> cargos) { this.cargos = cargos; }

    @Override
    public boolean equals(Object o) {
        if (this == o) 
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacturaMensual facturaMensual = (FacturaMensual) o;
        return Objects.equals(idFactura, facturaMensual.idFactura);
    }
}