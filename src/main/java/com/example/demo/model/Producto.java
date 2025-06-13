package com.example.demo.model;

import java.util.Date;

import javax.print.attribute.standard.MediaSize.ISO;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
		name="tbl_Producto"
		)
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id_producto")
	private Integer idProducto;
	@Column(name="nombre_producto")
	private String nombreProducto;
	private double cantidad;
	private double precio;
	private double total;
	@Column(name="nro_lote")
	private String nroLote;
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_venta")
	@DateTimeFormat(iso=org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
	private Date fechaVenta;
	
	
}
