package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Producto;

public interface IProductoRepositorio extends CrudRepository<Producto, Integer> {
	
}
