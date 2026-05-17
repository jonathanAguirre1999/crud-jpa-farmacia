package ec.edu.ups.farmacia.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ingrediente")
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @ManyToMany(mappedBy = "ingredientes")
    private List<Suplemento> suplementos;

    public Ingrediente(Long id, String nombre, List<Suplemento> suplementos) {
        this.id = id;
        this.nombre = nombre;
        this.suplementos = suplementos;
    }

    public Ingrediente() {}

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

    public List<Suplemento> getSuplementos() {
        return suplementos;
    }

    public void setSuplementos(List<Suplemento> suplementos) {
        this.suplementos = suplementos;
    }
}