package ec.edu.ups.farmacia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_nutricional")
public class DetalleNutricional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tamanio_porcion", length = 50)
    private String tamanioPorcion;

    @Column(name = "calorias")
    private Integer calorias;

    @OneToOne(mappedBy = "detalleNutricional")
    private Suplemento suplemento;

    public DetalleNutricional(Long id, String tamanioPorcion, Integer calorias, Suplemento suplemento) {
        this.id = id;
        this.tamanioPorcion = tamanioPorcion;
        this.calorias = calorias;
        this.suplemento = suplemento;
    }

    public DetalleNutricional(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTamanioPorcion() {
        return tamanioPorcion;
    }

    public void setTamanioPorcion(String tamanioPorcion) {
        this.tamanioPorcion = tamanioPorcion;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public Suplemento getSuplemento() {
        return suplemento;
    }

    public void setSuplemento(Suplemento suplemento) {
        this.suplemento = suplemento;
    }
}