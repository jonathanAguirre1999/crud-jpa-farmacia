package ec.edu.ups.farmacia.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "laboratorio")
public class Laboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "pais")
    private String pais;

    @OneToMany(mappedBy = "laboratorio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Suplemento> suplementos;

    public Laboratorio(Long id, String nombre, String pais, List<Suplemento> suplementos) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.suplementos = suplementos;
    }

    public Laboratorio() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Suplemento> getSuplementos() {
        return suplementos;
    }

    public void setSuplementos(List<Suplemento> suplementos) {
        this.suplementos = suplementos;
    }
}
