package cursoDAgil.service.productos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Productos;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ProductosServiceImplTest {

	@Inject
	ProductosService productosService;

	@Test
	public void pruebaObtenerProductos() {
		System.out.println("\n----------------- Test Obtener Productos ---------------------");
		int reg;
		try {
			List<Productos> lista = productosService.obtenerProductos();
			reg = lista.size();
			assertEquals(lista.size(), reg);
			for (Productos productos : lista) {
				System.out.println("id:" + productos.getIdProducto());
				System.out.println("nombre del producto:" + productos.getNombre());
				System.out.println("Precio: $" + productos.getPrecio());
				System.out.println("PrecioVta: $" + productos.getPrecioVta());
				System.out.println("cantidad:" + productos.getCantidad());
				System.out.println("marca: " + productos.getMarcas().getNombreMarca());
				System.out.println();
			}
			System.out.println("\nRegistros en la tabla: " + reg);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void pruebaObtenerProductoPorId() {
		System.out.println("\n----------------- Test Obtener Producto por Id ---------------------");
		Productos productos = new Productos();
		Map<String, Integer> mapProducto = new HashMap<>();
		try {
			mapProducto.put("idProducto", 11);
			productos = productosService.obtenerProductoPorId(mapProducto);
			assertNotNull(productos);
			System.out.println("id:" + productos.getIdProducto());
			System.out.println("nombre del producto:" + productos.getNombre());
			System.out.println("Precio: $" + productos.getPrecio());
			System.out.println("PrecioVta: $" + productos.getPrecioVta());
			System.out.println("cantidad:" + productos.getCantidad());
			System.out.println("marca: " + productos.getMarcas().getNombreMarca());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Ignore
	public void pruebaNuevoProductoMarca() {
		System.out.println("\n----------------- Test Nuevo Producto ---------------------");
		Productos productos = new Productos();
		try {
			productos.setNombre("Cereal");
			productos.setPrecio(14.0);
			productos.setPrecioVta(16.0);
			productos.setCantidad(2);
			productos.setMarcaId(2);
			productosService.nuevoProductoMarca(productos);
			System.out.println("Producto creado correctamente");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Ignore
	public void pruebaCambiarProductoPorId() {
		System.out.println("\n----------------- Test Actualizar Producto ---------------------");
		Productos productos = new Productos();
		Map<String, Integer> mapProducto = new HashMap<>();
		Integer CambiarId;
		try {
			CambiarId = 16; // Id del producto que quieres cambiar
			mapProducto.put("idProducto", CambiarId);
			productos = productosService.obtenerProductoPorId(mapProducto);
			assertNotNull(productos);

			// datos que quieres cambiar al producto
			productos.setNombre("Cambio de nombre");
			productos.setPrecio(14.50);
			productos.setCantidad(3);

			productosService.cambiarProductoPorId(productos, CambiarId);
			System.out.println("Producto actualizado correctamente");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Ignore
	public void pruebaEliminarProductoPorId() {
		System.out.println("\n----------------- Test Eliminar Producto ---------------------");
		Productos productos = new Productos();
		Map<String, Integer> mapProducto = new HashMap<>();
		Integer eliminarIdProducto;
		try {
			eliminarIdProducto = 17;
			mapProducto.put("idProducto", eliminarIdProducto);
			productos = productosService.obtenerProductoPorId(mapProducto);
			assertNotNull(productos);
			productosService.eliminarProductoPorId(mapProducto);
			System.out.println("Producto eliminado correctamente");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
