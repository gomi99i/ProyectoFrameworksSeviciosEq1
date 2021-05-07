package cursoDAgil.service.productos;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Productos;

public interface ProductosService {
	List<Productos> obtenerProductos(); //imprime todos los productos
	Productos obtenerProductoPorId(Map<String, Integer> mapProducto); //imprime un producto
	Integer nuevoProductoMarca(Productos producto); //crea un producto
	Integer cambiarProductoPorId(Productos producto, Integer id); //actualiza el producto
	Integer eliminarProductoPorId(Map<String, Integer> mapProducto); //elimina un producto
}
