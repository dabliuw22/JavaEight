package com.leysoft.javaeight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.leysoft.javaeight.interf.Compra;
import com.leysoft.javaeight.logica.Producto;
import com.leysoft.javaeight.logica.Usuario;

public class App {
	
    public static void main( String[] args ) {
    	Usuario u1 = new Usuario("Juan", "Radu", "rady@email.com", 23, "ciudad1");
    	Usuario u2 = new Usuario("Julio", "Rada", "rada@email.com", 22, "ciudad1");
    	Usuario u3 = new Usuario("Jose", "Rado", "rado@email.com", 18, "ciudad2");
    	Usuario u4 = new Usuario("Joe", "Rade", "rade@email.com", 15, "ciudad1");
    	List<Usuario> usuarios = new ArrayList<>();
    	usuarios.add(u1);
    	usuarios.add(u2);
    	usuarios.add(u3);
    	usuarios.add(u4);
    	
    	Producto p1 = new Producto("Caja Negra", 2.00);
    	Producto p2 = new Producto("Caja Blanca", 3.00);
    	List<Producto> productos = new ArrayList<>();
    	productos.add(p1);
    	productos.add(p2);
    	
    	Compra c1 = (u, p) -> u.addProducto(p);
    	c1.comprar(u1, p1);
    	c1.comprar(u1, p2);
    	c1.comprar(u2, p1);
    	c1.comprar(u3, p2);
    	
    	//Mostrar el nombre de todos los productos que tiene asignado el usuario u1
    	u1.getProductos().stream().map(p -> p.getNombre()).forEach(System.out::println);
    	
    	//Mostrar el nombre de todos los productos que tienen asignados los usuarios
    	usuarios.stream().map(u -> u.getProductos()).flatMap(pts -> pts.stream()).forEach(p -> System.out.println(p));
    	
    	//Filtrar los productos que tengan un precio mayor a 1.00
    	productos.stream().filter(producto -> producto.getPrecio() > 1.00).forEach(p -> System.out.println(p));
    	//Mostrar los productos ordenados de menor a mayor
    	productos.stream().sorted().forEach(System.out::println);
    	
    	//Mostrar los usuarios ordenados de mayor a menor
    	usuarios.stream().sorted(Comparator.comparingDouble(Usuario::getEdad).reversed()).forEach(System.out::println);
    	
    	//Mostrar los productos sin repetir ordenados de menor a mayor por precio de los usuarios con edad mayor a 18
    	usuarios.stream().filter(u -> u.getEdad() > 18).sorted(Comparator.comparingDouble((Usuario u) -> u.getEdad()).reversed())
    		.map(u -> u.getProductos()).flatMap(pts -> pts.stream()).sorted().distinct().forEach(System.out::println);
    	
    	//Suma del total de productos adquiridos por todos los usuarios
    	Double suma = usuarios.stream().map(u -> u.getProductos()).flatMap(pts -> pts.stream())
    		.mapToDouble(Producto::getPrecio).sum();
    	System.out.println(suma);
    	
    	//Conteo de usuarios por ciudad
    	usuarios.stream().collect(Collectors.groupingBy(Usuario::getCiudad, Collectors.counting()))
    		.forEach((ciudad, cantidad) -> System.out.println(ciudad + ": " + cantidad));
    	
    	//Mostrar la suma de las edades de los usuarios con el uso de la función reduce
    	System.out.println(usuarios.stream().map(Usuario::getEdad).reduce(Integer::sum));
    	System.out.println(usuarios.stream().map(Usuario::getEdad).reduce(0, (x, y) -> x+y));
    	//(3+23)*(3+22)*(3+18)*(3+15)
    	System.out.println(usuarios.parallelStream().map(Usuario::getEdad).reduce(3, (x, y) -> x+y, (w, z) -> w*z));
    	
    }
}
