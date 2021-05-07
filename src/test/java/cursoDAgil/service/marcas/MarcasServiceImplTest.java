package cursoDAgil.service.marcas;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Marcas;
import cursoDAgil.service.marcas.MarcasService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})


public class MarcasServiceImplTest {
	@Inject
	MarcasService marcasService;
	
	@Test
	public void pruebaListarTodasMarcas(){
		System.out.println("\n---------------- Test Listar Todas las Marcas -----------------------");
		int reg;
		try{
			List<Marcas> marcas = marcasService.listarTodasMarcas();
			for(Marcas aux : marcas){
				System.out.println("id: " + aux.getIdMarca() + "  nombre: " + aux.getNombreMarca());
			}
			reg = marcas.size();
			assertEquals(marcas.size(), reg);
			System.out.println("\nRegistros en la tabla: " + reg);
		} catch(Exception ex){
			System.out.println("Error: " + ex);
		}
	}
	
	@Ignore
	public void pruebaObtenerMarcaPorId(){
		System.out.println("\n---------------- Test Obtener Marca por Id -----------------------");
		Map <String,Integer> mapMarca = new HashMap<>();
		mapMarca.put("idMarca", 1);
		try{
			Marcas marca = marcasService.obtenerMarcaPorId(mapMarca);
			assertNotNull(marca);
			System.out.println("ID: " + marca.getIdMarca() + "   nombreMarca: " + marca.getNombreMarca());
		} catch(Exception ex){
			System.out.println("Error: " + ex);
		}
	}
	
	@Ignore
	public void pruebaNuevaMarca(){
		System.out.println("\n---------------- Test Nueva Marca -----------------------");
		Marcas marca = new Marcas();
		try{
			marca.setNombreMarca("La costeña");
			marcasService.nuevaMarca(marca);
			System.out.println("Marca creada correctamente");
		} catch(Exception ex) {
			System.out.println("Error: " + ex);
		}
	}
	
	@Ignore
	public void pruebaActualizarMarca(){
		System.out.println("\n---------------- Test Actualizar Marca -----------------------");
		Marcas marca = new Marcas();
		try{
			marca.setIdMarca(7);
			marca.setNombreMarca("Totis");
			marcasService.actualizarMarca(marca);
			System.out.println("Marca actualizada correctamente");
		} catch(Exception ex){
			System.out.println("Error: " + ex);
		}
	}
	
	@Ignore
	public void pruebaEliminarMarca(){
		System.out.println("\n---------------- Test Eliminar Marca -----------------------");
		Map<String,Integer> mapMarca = new HashMap<>();
		mapMarca.put("idMarca", 7);
		try{
			marcasService.eliminarMarca(mapMarca);
			System.out.println("Marca eliminada correctamente");
		} catch(Exception ex){
			System.out.println("Error: " + ex);
		}
	}	
}
