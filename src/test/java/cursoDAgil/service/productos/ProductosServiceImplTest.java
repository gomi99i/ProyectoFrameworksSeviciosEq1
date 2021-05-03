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
	
	@Ignore
	public void PruebaObtenerProductos(){
		System.out.println("-----------------Prueba Obetener productos---------------------");
		try{
			List<Productos> lista = productosService.obtenerProductos();
			assertEquals(lista.size(),lista.size());
			for(Productos productos : lista){
				System.out.println("id:" + productos.getIdProducto());
				System.out.println("nombre del producto:" + productos.getNombre());
				System.out.println("Precio: $" + productos.getPrecio());
				System.out.println("PrecioVta: $" + productos.getPrecioVta());
				System.out.println("cantidad:" + productos.getCantidad());
				System.out.println("marca: " + productos.getMarcas().getNombreMarca());
				System.out.println();
			}
		} catch(Exception e){
			System.out.println("Error: " + e);
		}
	}

	@Ignore
	public void PruebaNuevoProductoMarca() {
		System.out.println("-----------------Prueba Nuevo Producto---------------------");
		try{
			Productos productos= new Productos();
			productos.setNombre("Cereal");
			productos.setPrecio(14.0);
			productos.setPrecioVta(16.0);
			productos.setCantidad(2);
			productos.setMarcaId(2);
			productosService.nuevoProductoMarca(productos);
		} catch(Exception e){
			System.out.println("Error: " + e);
		}
	}

	@Test
	public void PruebaEliminarProductoPorId() {
		System.out.println("-----------------Prueba Eliminar productos---------------------");
		try{
			Productos productos = new Productos();
			Map<String, Integer> mapProducto = new HashMap<>();
			mapProducto.put("idProducto",11);
			productos=productosService.obtenerProductoPorId(mapProducto);
			assertNotNull(productos);
			productosService.eliminarProductoPorId(mapProducto);
			System.out.println("Producto eliminado correctamente");
		} catch(Exception e){
			System.out.println("Error: " + e);
		}
	}

	@Ignore
	public void PruebaCambiarProductoPorId() {
		System.out.println("-----------------Prueba Cambiar producto por ID---------------------");
		try{
			Productos productos= new Productos();
			Map<String, Integer> mapProducto = new HashMap<>();
			Integer CambiarId = 11; //Id del producto que quieres cambiar
			mapProducto.put("idProducto",CambiarId);
			productos=productosService.obtenerProductoPorId(mapProducto);
			assertNotNull(productos);
			
			//datos que quieres cambiar al producto
			productos.setPrecio(14.50);
			productos.setCantidad(3);
			
			productosService.cambiarProductoPorId(productos, CambiarId);
		} catch(Exception e){
			System.out.println("Error: " + e);
		}
	}

	@Ignore
	public void PruebaObtenerProductoPorId() {
		System.out.println("-----------------Prueba Obetener producto por ID---------------------");
		try{
			Productos productos = new Productos();
			Map<String, Integer> mapProducto = new HashMap<>();
			mapProducto.put("idProducto",11);
			productos=productosService.obtenerProductoPorId(mapProducto);
			assertNotNull(productos);
			System.out.println("id:" + productos.getIdProducto());
			System.out.println("nombre del producto:" + productos.getNombre());
			System.out.println("Precio: $" + productos.getPrecio());
			System.out.println("PrecioVta: $" + productos.getPrecioVta());
			System.out.println("cantidad:" + productos.getCantidad());
			System.out.println("marca: " + productos.getMarcas().getNombreMarca());
		} catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
}
