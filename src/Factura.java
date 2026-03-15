import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("ec0de2bc-b48c-419c-82bd-ae91d05858c2")
public class Factura {
    @objid ("5a2d6479-92e2-45f2-9b15-fd8c8d737389")
    public int idFactura;

    @objid ("5b6e1924-50bf-4acd-9331-5c5e43bebc8b")
    public String usuarioNombre;

    @objid ("69a835f1-198f-4fba-82e1-5371a6852fa1")
    public int mes;

    @objid ("51560193-2dd0-49c1-98ba-da2e0e0cc298")
    public int año;

    @objid ("da444558-4110-4f8c-92d7-1a0576e90a9d")
    public List<EntradaFactura> entradas = new ArrayList<EntradaFactura> ();

    @objid ("b4a2764c-e317-4e33-9dc9-f094b9af61ee")
    public double calcularCoste() {
        // TODO Auto-generated return
        return 0;
    }

}
