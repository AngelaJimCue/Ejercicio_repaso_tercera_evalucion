package ejercicio_repaso_tercera_evaluacion.ejercicio_producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Almacen {
	/*Si tengo un almacen es static, pero si hay más de uno NO.*/
	private static List<Producto> inventario = cargaInventario();	
	
	private static List<Producto> cargaInventario(){
		List<Producto> lista = new ArrayList<>();
		lista.add(new Producto(1, "Libro1", 10));
		lista.add(new Producto(2, "Libro2", 3));
		lista.add(new Producto(3, "Libro3", 23));
		lista.add(new Producto(4, "Libro4", 0));
		
		return lista;
	}
	
	public static Optional<Producto> buscaProducto(int id) throws ProductoNoEncontradoException{
		Optional<Producto> optProducto = inventario.stream()
												.filter(p-> p.getId() == id/*COMPARA EL ID(getId) DE PRODUCTO CON EL ID(id) DEL OPTIONAL*/)
												.findFirst/*PARA QUE SE QUEDE CON EL 1º*/(); //ESTO ME DA UN SOLO PRODUCTO EN UN OPTIONAL.
		
		
		if (optProducto.get().getId() <= 0|| optProducto.isEmpty()) throw new ProductoNoEncontradoException("No hay producto."); //SI NO HAY EN EL OPTIONAL DE INVENTARIO PRODUCTO, DA ESA EXCEPCIÓN.
		
		
		
		return optProducto;
	}
	
	public Optional<Producto> disminuirCantidad(int id, int cantidad) throws ProductoNoEncontradoException, InventarioInsuficienteException {
		 Optional<Producto> optProducto = buscaProducto(id);
	        
	        if (optProducto.get().getCantidad() <= 0) {
	            throw new ProductoNoEncontradoException("No hay producto.");
	        }
	        
	        if (optProducto.get().getCantidad() >= 1) {
	            cantidad--;
	        } else {
	            throw new InventarioInsuficienteException("No hay suficiente cantidad en el almacén.");
	        }
	        
	        return optProducto;
	}
	
	public static void main(String[] args) {

        Producto producto1 = new Producto(1, "Libro1", 10);
        System.out.println(producto1.toString());

        System.out.println("------------------------------------------------");
        System.out.println("PROBAR MÉTODOS:");
       
	    for (Producto producto : inventario) {
	    	System.out.println(producto.toString());
	    }
	    
	    
	    System.out.println("------------------------------------------------");
        System.out.println("PROBAR MÉTODOS CON CANTIDAD ALEATORIA:");

        
        
    }
	
}
