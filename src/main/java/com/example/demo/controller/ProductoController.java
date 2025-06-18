package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@GetMapping("/registrarProducto")
	public String agregarProducto(Model modelo) {
		modelo.addAttribute("producto", new Producto());
		return "/vistas/RegistrarProducto";
	}
	@PostMapping("/registrarProducto")
	public String agregarProductoPost(@ModelAttribute Producto producto) {
		if(producto != null) {
			producto.setTotal(producto.getCantidad() * producto.getPrecio());
			productoServicio.registrarProducto(producto);
		}
		return "redirect:/vistas/listarProductos";
	}
	@GetMapping("/editarProducto/{id}")
	public String editarProducto(@RequestParam int id, Model modelo) {
		Producto productoBuscado = productoServicio.buscarProducto(id);
		modelo.addAttribute("productoEditar",productoBuscado);
		return "vistas/EditarProducto";
	}
}
