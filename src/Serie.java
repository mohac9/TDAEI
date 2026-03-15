import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("1231f127-06db-4766-a022-d61ea6b5ce4f")
public class Serie {
    @objid ("5d0b232e-cf5c-4c17-ba80-f8d526e8914f")
    public String tier;

    @objid ("b03d04f6-70a5-434e-b00e-da8dd561a636")
    public int idSerie;

    @objid ("3c366d87-4124-410a-b82d-f856e7977762")
    public String sinopsis;

    @objid ("ce93f342-dab2-43ed-873e-18acde93da40")
    public String nombre;

    @objid ("221973a0-3c53-414f-abea-b80048bd8a61")
    public String creadores;

    @objid ("40689d9b-b128-4e75-97b7-5e6699707203")
    public String actores;

    @objid ("4f8aaf1c-ddb9-4532-abe9-096238a79331")
    public TipoSerie Categoria;

    @objid ("98bef6b2-c136-4c0c-8b5f-51450a510d9e")
    public List<Episodio> episodios = new ArrayList<Episodio> ();

}
