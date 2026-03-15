import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3778d3a8-f423-43f8-b181-e32a998c1095")
public class Usuario {
    @objid ("a50667fc-0aef-4045-b6b4-3a3c69c136fa")
    public String nombre;

    @objid ("9db1fb56-3d8b-4a9c-bf80-7268adab2b67")
    public String password;

    @objid ("5f2d251c-1ac2-411e-88e9-5732c623fb59")
    public String IBAN;

    @objid ("56d88608-503a-48c2-8707-d187428cdf7c")
    public boolean cuotaMensual;

    @objid ("deeaf716-5b47-4d31-86f7-fede55336119")
    public SeguimientoSerie seguimientoSerie;

    @objid ("a7061273-43f6-4e69-9c2f-5539dd23e85c")
    public List<Factura> facturas = new ArrayList<Factura> ();

    @objid ("f32f6f85-8d03-43b8-889a-0f67badfcd6f")
    public void agregarSerie(final int serie, final EstadosSerie p2) {
    }

    @objid ("8861bfb0-65f9-4316-9a9d-8570523883cf")
    public void verEpisodio(final int idEpisodio, final int idSerie) {
    }

}
