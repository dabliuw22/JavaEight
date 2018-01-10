package com.leysoft.javaeight.logica;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String nombre;
	
	private String apellidos;
	
	private String email;
	
	private Integer edad;
	
	private String ciudad;
	
	private List<Producto> productos;

	public Usuario() {}

	public Usuario(String nombre, String apellidos, String email, Integer edad, String ciudad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.edad = edad;
		this.ciudad = ciudad; 
		this.productos = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void addProducto(Producto producto) {
		if(!productos.contains(producto)) {
			productos.add(producto);
		}
	}

	@Override
	public String toString() {
		return nombre + " " + apellidos;
	}
}