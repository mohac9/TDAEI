import java.util.ArrayList;
import java.util.List;

@entity
public class Factura {
    @Id
    private int idFactura;
    private String usuarioNombre;
    private int mes;
    private int año;
    private List<EntradaFactura> entradas = new ArrayList<EntradaFactura> ();

    public double calcularCoste() {
        return 0;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public List<EntradaFactura> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<EntradaFactura> entradas) {
        this.entradas = entradas;
    }

}
