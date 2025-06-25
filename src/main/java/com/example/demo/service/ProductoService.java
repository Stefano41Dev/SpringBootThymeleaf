package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;
import com.example.demo.repository.IProductoRepositorio;
 @Service
public class ProductoService implements IProductoService {
	@Autowired
	private IProductoRepositorio productoRepositorio;
	@Override
	public List<Producto> listarProductos() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoRepositorio.findAll();
	}

	@Override
	public Producto buscarProducto(Integer id) {
		// TODO Auto-generated method stub
		return productoRepositorio.findById(id).orElse(null);
	}

	@Override
	public void registrarProducto(Producto producto) {
		// TODO Auto-generated method stub
		productoRepositorio.save(producto);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		Producto productoBuscado = productoRepositorio.findById(id).orElse(null);
		if(productoBuscado != null) {
			productoRepositorio.delete(productoBuscado);		
		}
	}

	


}
