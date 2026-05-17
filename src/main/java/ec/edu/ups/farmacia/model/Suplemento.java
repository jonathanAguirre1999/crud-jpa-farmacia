package ec.edu.ups.farmacia.model;

import jakarta.persistence.*;
import java.util.List;

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

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "laboratorio_id")
    private Laboratorio laboratorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detalle_id", referencedColumnName = "id")
    private DetalleNutricional detalleNutricional;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "suplemento_ingrediente",
            joinColumns = @JoinColumn(name = "suplemento_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    private List<Ingrediente> ingredientes;

    public Suplemento() {}

    public Suplemento(Long id, String nombre, String presentacion, String dosis, Integer stock,
                      Double precio, Laboratorio laboratorio, Categoria categoria,
                      DetalleNutricional detalleNutricional, List<Ingrediente> ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.dosis = dosis;
        this.stock = stock;
        this.precio = precio;
        this.laboratorio = laboratorio;
        this.categoria = categoria;
        this.detalleNutricional = detalleNutricional;
        this.ingredientes = ingredientes;
    }

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

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public DetalleNutricional getDetalleNutricional() {
        return detalleNutricional;
    }

    public void setDetalleNutricional(DetalleNutricional detalleNutricional) {
        this.detalleNutricional = detalleNutricional;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        String labNombre = (laboratorio != null) ? laboratorio.getNombre() : "N/A";
        String catNombre = (categoria != null) ? categoria.getTipoSuplemento() : "N/A";

        return "Suplemento [" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", laboratorio=" + labNombre +
                ", categoria=" + catNombre +
                ']';
    }
}