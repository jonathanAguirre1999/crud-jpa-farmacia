package ec.edu.ups.farmacia.model;

import jakarta.persistence.*;


@Entity
@Table(name = "suplemento")
public class Suplemento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "presentacion", nullable = false, length = 50)
    private String presentacion;

    @Column(name = "dosis", nullable = false, length = 50)
    private String dosis;

    @Column(name = "laboratorio", nullable = false, length = 50)
    private String laboratorio;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "precio", nullable = false)
    private Double precio;

    public Suplemento() {}

    public Suplemento(String nombre, String presentacion, String dosis, String laboratorio, Integer stock, Double precio) {
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.dosis = dosis;
        this.laboratorio = laboratorio;
        this.stock = stock;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public String getDosis() {
        return dosis;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public Integer getStock() {
        return stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Suplemento [id=" + id + ", nombre=" + nombre + ", presentacion=" + presentacion + ", dosis=" + dosis + ", laboratorio=" + laboratorio + ", stock=" + stock + ", precio=" + precio + "]";
    }
}
