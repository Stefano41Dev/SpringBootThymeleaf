package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Producto;
import com.example.demo.service.IProductoService;

@Controller
@RequestMapping("/vistas")
public class ProductoController {
	@Autowired
	public IProductoService productoServicio;
	@GetMapping("/listarProductos")
	public String listarProductos(Model modelo){
		List<Producto> listadoProducto = productoServicio.listarProductos();
		modelo.addAttribute("listadoProducto",listadoProducto);
		
		return "/vistas/ListadoProductos";
	}
	
	
}
