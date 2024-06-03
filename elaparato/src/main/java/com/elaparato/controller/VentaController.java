package com.elaparato.controller;

import com.elaparato.model.Producto;
import com.elaparato.model.Venta;
import com.elaparato.service.IProductoService;
import com.elaparato.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    private IVentaService ventServ;

    //crear una nueva venta
    @PostMapping("/create")
    public String createVenta(@RequestBody Venta vent) {
        ventServ.saveVenta(vent);
        return "Venta creada correctamente";
    }

    //obtener todas las ventas
    @GetMapping("/getall")
    public List<Venta> getVentas () {
        return ventServ.getVentas();
    }
    @GetMapping("/getone/{id}")
    public Venta getVenta(@PathVariable Integer id){
        return ventServ.findVenta(id);
    }
    @GetMapping
    public String yes(){
        return "seccion venta";
    }
    //Modificar los datos de una venta
    @PutMapping("/edit")
    public String editVenta(@RequestBody Venta vent) {
        ventServ.editVenta(vent);
        return "Venta editada correctamente";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteVenta(@PathVariable Integer id){
        ventServ.deleteVenta(id);
        return "Venta eliminada";
    }
}
