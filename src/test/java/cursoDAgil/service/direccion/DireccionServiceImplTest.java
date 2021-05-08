package cursoDAgil.service.direccion;

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

import cursoDAgil.bd.domain.Direccion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class DireccionServiceImplTest {
	@Inject
	DireccionService direccionService;
	
	@Test
	public void pruebaConsultarTodo() {
		int reg;
		System.out.println("\n---------------- Test Listar Todas las Direcciones -----------------------");
		try {
			List<Direccion> lista = direccionService.obtenerDirecciones();
			reg = lista.size();
			assertEquals(lista.size(), reg);
			System.out.println("\nRegistros en la tabla: " + reg);
			for(Direccion direccion : lista){
				System.out.println("id:" + direccion.getIdDireccion());
				System.out.println("calle:" + direccion.getCalle());
				System.out.println("Numero:" + direccion.getNumero());
				System.out.println("Colonia:" + direccion.getColonia());
				System.out.println("Ciudad:" + direccion.getCiudad());
				System.out.println("Estado:" + direccion.getEstado());
				System.out.println("Pais:" + direccion.getPais());
				System.out.println("Codigo Postal:" + direccion.getCodigoPostal());
				System.out.println();
			}
		} catch (Exception ex) {
			System.out.println("error" + ex);
		}
	}
	
	@Ignore
	public void pruebaConsultarDireccionPorId() {
		Direccion direccion = new Direccion();
		System.out.println("\n---------------- Test Obtener Direccion por Id -----------------------");
		Map<String, Integer> mapDireccion = new HashMap<>(); 
		mapDireccion.put("idDireccion", 3);
		try {
			direccion = direccionService.obtenerDireccionPorId(mapDireccion);
			assertNotNull(direccion);
			System.out.println("id:" + direccion.getIdDireccion());
			System.out.println("calle:" + direccion.getCalle());
			System.out.println("Numero:" + direccion.getNumero());
			System.out.println("Colonia:" + direccion.getColonia());
			System.out.println("Ciudad:" + direccion.getCiudad());
			System.out.println("Estado:" + direccion.getEstado());
			System.out.println("Pais:" + direccion.getPais());
			System.out.println("Codigo Postal:" + direccion.getCodigoPostal());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void pruebaNuevoRegistro() {
		Direccion direccion = new Direccion();
		System.out.println("\n---------------- Test Nueva Direccion -----------------------");
		try {
			direccion.setCalle("Trujano");
			direccion.setNumero(49);
			direccion.setColonia("Centro");
			direccion.setCiudad("Huajuapan");
			direccion.setEstado("Oaxaca");
			direccion.setPais("Mexico");
			direccion.setCodigoPostal(69000);
			direccionService.nuevaDireccionCliente(direccion);
			System.out.println("Direccion creada correctamente");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
		
	@Ignore
	public void pruebaCambiarDireccion(){
		System.out.println("\n---------------- Test Actualizar Direccion -----------------------");
		Direccion direccion = new Direccion();
		Map<String, Integer> mapDireccion = new HashMap<>();
		Integer CambiarId = 14; 
		try{
			mapDireccion.put("idDireccion",CambiarId);
			direccion=direccionService.obtenerDireccionPorId(mapDireccion);
			assertNotNull(direccion);
			direccion.setCalle("Avenida siempre viva");
			direccion.setCiudad("Guajolotitlan");
			direccionService.cambiarDireccion(direccion, CambiarId);
			System.out.println("Direccion actualizada correctamente");
		}catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void pruebaEliminarDireccion(){
		System.out.println("\n---------------- Test Eliminar Direccion -----------------------");
		Direccion direccion = new Direccion();
		Map<String, Integer> mapDireccion = new HashMap<>();
		mapDireccion.put("idDireccion", 14);
		try{
			direccion = direccionService.obtenerDireccionPorId(mapDireccion);
			assertNotNull(direccion); 
			direccionService.eliminarDireccion(mapDireccion);
			System.out.println("Direccion eliminada correctamente");
		}catch (Exception e){
			System.out.println("Error:" + e);
		}
	}
}

