package com.example.demo.service;

import java.util.List;


import com.example.demo.model.Producto;

public interface IProductoService {
	List<Producto>listarProductos();
	Producto buscarProducto(Integer id);
	void registrarProducto(Producto producto);
	void eliminarProducto(Integer id);
}
