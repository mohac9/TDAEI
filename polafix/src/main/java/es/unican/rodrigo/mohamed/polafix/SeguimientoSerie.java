import com.modeliosoft.modelio.javadesigner.annotations.objid;

@embedabble
public class SeguimientoSerie {
    private int idSerie;
    private EstadosSerie estado;
    private int[] capitulosVistos;

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
