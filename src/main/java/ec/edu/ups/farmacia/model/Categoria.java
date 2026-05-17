package ec.edu.ups.farmacia.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_suplemento")
    private String tipoSuplemento;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Suplemento> suplementos;

    public Categoria(Long id, String tipoSuplemento, List<Suplemento> suplementos) {
        this.id = id;
        this.tipoSuplemento = tipoSuplemento;
        this.suplementos = suplementos;
    }

    public Categoria() {}

    public String getTipoSuplemento() {
        return tipoSuplemento;
    }

    public void setTipoSuplemento(String tipoSuplemento) {
        this.tipoSuplemento = tipoSuplemento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Suplemento> getSuplementos() {
        return suplementos;
    }

    public void setSuplementos(List<Suplemento> suplementos) {
        this.suplementos = suplementos;
    }

}
