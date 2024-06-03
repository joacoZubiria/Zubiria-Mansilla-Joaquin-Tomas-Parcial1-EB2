package com.elaparato.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
@Entity
@SequenceGenerator(name="venta_seq", sequenceName = "venta_seq", allocationSize=1)
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venta_seq")
    private int id_venta;
    private Date fecha;
    //@OneToMany(mappedBy="venta")
    @ManyToMany //(mappedBy = "listaVentas")
    @JoinTable(
            name = "producto_lista_ventas",
            joinColumns = @JoinColumn(name = "id_venta"),
            inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    private List<Producto> listaProductos;

}
