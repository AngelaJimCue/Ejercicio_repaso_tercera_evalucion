package ejercicio_repaso_tercera_evaluacion.ejercicio_producto;

import java.util.Optional;
import java.util.function.Supplier; 

public class Producto {
	private int id;
	private String nombre;
	private int cantidad;
	
		
	public Producto(int id) {
		this.id = id;
	}

	public Producto(int id, String nombre, int cantidad) { 
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}



	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public int getCantidad() {
		return cantidad;
	}



	public static Optional<Producto> buscaDisminuir (Optional<Producto> optCoche) 
			throws ProductoNoEncontradoException, InventarioInsuficienteException {
		
		return null;
	}



	@Override
	public String toString() {
		return String.format("Id: %d, nombre:%s y cantidad:%s.", id,nombre,cantidad);
	}

	
	
	
}
