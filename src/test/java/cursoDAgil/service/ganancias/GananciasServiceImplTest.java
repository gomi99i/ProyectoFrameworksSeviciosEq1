package cursoDAgil.service.ganancias;

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

import cursoDAgil.bd.domain.Ganancias;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class GananciasServiceImplTest {
	
	@Inject 
	GananciasService gananciasService;
	
	@Test
	public void pruebaObtenerGanancias() {
		System.out.println("---------------- Test Obtener Todas las Ganancias -----------------------");
		int reg;
		try {
			List<Ganancias> lista = gananciasService.obtenerGanancias();
			reg = lista.size();
			assertEquals(lista.size(), reg);
			System.out.println("\nRegistros en la tabla: " + reg + "\n");
		} catch (Exception ex) {
			System.out.println("error" + ex);
		}
	}
	
	@Ignore
	public void pruebaObtenerGananciaPorFecha() {
		System.out.println("---------------- Test Obtener Ganancias por Fecha -----------------------");
		int reg;		
		Map<String, String> mapGanancias = new HashMap<>();
		mapGanancias.put("fecha","2021-04-15");		
		try {
			List<Ganancias> lista = gananciasService.obtenerGananciaPorFecha(mapGanancias);
			reg = lista.size();
			assertEquals(lista.size(), reg);
			System.out.println("\nRegistros de la fecha: " + reg + "\n");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Ignore
	public void pruebaNuevaGanancia() {
		System.out.println("---------------- Test Nueva Ganancia ----------------");
		Ganancias ganancias = new Ganancias();
		try {
			ganancias.setTotalGanancia(234.8);
			ganancias.setVentaId(1);
			ganancias.setFecha("2021-05-08");
			gananciasService.nuevaGanancia(ganancias);
			System.out.println("Ganancia creada correctamente");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
}
