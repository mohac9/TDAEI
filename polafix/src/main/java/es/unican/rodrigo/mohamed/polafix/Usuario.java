import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    private String nombre;
    private String password;
    private String IBAN;
    private boolean cuotaMensual;
    @Embedded
    private SeguimientoSerie seguimientoSerie;
    private List<Factura> facturas = new ArrayList<Factura> ();

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

    public boolean isCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(boolean cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public SeguimientoSerie getSeguimientoSerie() {
        return seguimientoSerie;
    }

    public void setSeguimientoSerie(SeguimientoSerie seguimientoSerie) {
        this.seguimientoSerie = seguimientoSerie;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public void agregarSerie(final int serie, final EstadosSerie p2) {
    }

    public void verEpisodio(final int idEpisodio, final int idSerie) {
    }

}
