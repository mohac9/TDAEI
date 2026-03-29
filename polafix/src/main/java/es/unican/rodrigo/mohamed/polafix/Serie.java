import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;


@entity
public class Serie {
    private String tier;
    @Id
    private int idSerie;
    private String sinopsis;
    private String nombre;
    private String creadores;
    private String actores;
    @Enumerated(EnumType.STRING)
    private TipoSerie Categoria;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_serie")
    private List<Episodio> episodios = new ArrayList<Episodio> ();

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreadores() {
        return creadores;
    }

    public void setCreadores(String creadores) {
        this.creadores = creadores;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public TipoSerie getCategoria() {
        return Categoria;
    }

    public void setCategoria(TipoSerie categoria) {
        Categoria = categoria;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }
}
