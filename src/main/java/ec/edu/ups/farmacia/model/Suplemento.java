package ec.edu.ups.farmacia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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

    public Suplemento(String nombre, String presentacion, String dosis, String laboratorio, Integer stock, Double precio) {
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.dosis = dosis;
        this.laboratorio = laboratorio;
        this.stock = stock;
        this.precio = precio;
    }

}
