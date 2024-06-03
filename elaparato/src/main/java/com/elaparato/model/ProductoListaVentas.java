package com.elaparato.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "producto_lista_ventas") // Nombre de la tabla intermedia
public class ProductoListaVentas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_venta") // Clave foránea hacia la tabla Venta
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_producto") // Clave foránea hacia la tabla Producto
    private Producto producto;

    // Constructores, getters y setters
    public ProductoListaVentas() {}

    public ProductoListaVentas(Venta venta, Producto producto) {
        this.venta = venta;
        this.producto = producto;
    }
}

