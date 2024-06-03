package com.elaparato.controller;
import com.elaparato.model.Producto;
import com.elaparato.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService prodServ;
@GetMapping
public String yes(){
    return "seccion producto";
}
    //crear un nuevo producto
    @PostMapping("/create")
    public String createProducto(@RequestBody Producto prod) {
        prodServ.saveProducto(prod);
        return "Producto creado correctamente";
    }

    //obtener todos los productos
    @GetMapping("/getall")
    public List<Producto> getProductos () {
        return prodServ.getProductos();
    }
@GetMapping("/getone/{id}")
public Producto getProducto(@PathVariable Integer id){
    return prodServ.findProducto(id);
}
@DeleteMapping("delete/{id}")
public String deleteProducto(@PathVariable Integer id){
    prodServ.deleteProducto(id);
    return "producto eliminado";
}
   //Modificar los datos de un producto
    @PutMapping("/edit")
    public String editProducto(@RequestBody Producto prod) {
        prodServ.editProducto(prod);
        return "Producto editado correctamente";
    }
}
