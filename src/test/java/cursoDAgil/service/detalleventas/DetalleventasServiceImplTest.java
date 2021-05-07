package cursoDAgil.service.detalleventas;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Detalleventas;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"/applicationContext.xml"})

public class DetalleventasServiceImplTest {
	
	@Inject
	DetalleventasService detalleventasService;
	
	@Test
	public void mostrarDetallesVenta(){
		System.out.println("\n---------------- Test Mostrar Detalles de la Venta -----------------------");
		Map<String, Integer> mapDetalleVentas = new HashMap<>();
		int reg;
		try{
			mapDetalleVentas.put("ventaId", 2);
			List<Detalleventas> lista = detalleventasService.mostrarDetallesVenta(mapDetalleVentas);
			reg=lista.size();
			assertEquals(lista.size(), reg);
			for(Detalleventas detalleventas:lista){
				System.out.println("\n# de venta: " + detalleventas.getVentaId());
				System.out.println("Nombre del producto: " + detalleventas.getProductos().getNombre());
				System.out.println("Cantidad:  " + detalleventas.getCantidad());
			}	
			System.out.println("\n Registros de los productos de la consulta: " + reg);
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void nuevoDetalleVenta(){
		System.out.println("\n---------------- Test Nuevo DetalleVenta -----------------------");
		Detalleventas detalleventas = new Detalleventas();
		try{
			detalleventas.setVentaId(3);
			detalleventas.setProductoId(4);
			detalleventas.setCantidad(3);
			detalleventasService.nuevoDetalleVenta(detalleventas);
			System.out.println("DetalleVenta creada correctamente");
		}catch(Exception e){
			System.out.println("Error: " + e);			
		}
	}
}
