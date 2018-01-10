package com.leysoft.javaeight.logica;

public class Producto implements Comparable<Producto> {
	
	private String nombre;
	
	private Double precio;

	public Producto() {}

	public Producto(String nombre, Double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public int compareTo(Producto producto) {
		if(this.precio < producto.getPrecio()) {
			return -1;
		} else if(this.precio > producto.getPrecio()) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return nombre;
	}
}