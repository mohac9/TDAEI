import jakarta.persistence.*;
import java.util.List;

@Embeddable
public class SeguimientoSerie {
    private int idSerie;
    @Enumerated(EnumType.STRING)
    private EstadosSerie estado;
    @ElementCollection
    private List<Integer> capitulosVistos;

    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }

    public EstadosSerie getEstado() {
        return estado;
    }

    public void setEstado(EstadosSerie estado) {
        this.estado = estado;
    }

    public int[] getCapitulosVistos() {
        return capitulosVistos;
    }

    public void setCapitulosVistos(int[] capitulosVistos) {
        this.capitulosVistos = capitulosVistos;
    }

}
