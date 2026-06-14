package es.unican.rodrigo.mohamed.polafix.domain;
import es.unican.rodrigo.mohamed.polafix.controllers.Views;
import jakarta.persistence.*;
@Embeddable
public class Categoria {
    private CategoriaSerie tier;
    private String precio;

    protected Categoria() {}

    public Categoria(CategoriaSerie tier, String precio) {
        this.tier = tier;
        this.precio = precio;
    }
    public CategoriaSerie getTier() {
        return tier;
    }

    public void setTier(CategoriaSerie tier) {
        this.tier = tier;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }


}
