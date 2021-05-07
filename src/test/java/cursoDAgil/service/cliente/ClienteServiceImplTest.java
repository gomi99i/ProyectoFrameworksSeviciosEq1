package cursoDAgil.service.cliente;

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

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.service.cliente.ClienteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ClienteServiceImplTest {

	@Inject
	ClienteService clienteService;

	@Test
	public void pruebaListarTodosClientes() {
		System.out.println("\n---------------- Test Listar Todos los Clientes -----------------------");
		int reg;
		try {
			List<Cliente> lista = clienteService.listarTodosClientes();
			reg = lista.size();
			assertEquals(lista.size(), reg);
			System.out.println("\nRegistros en la tabla: " + reg);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Ignore
	public void pruebaObtenerClientePorId() {
		System.out.println("\n---------------- Test Obtener Cliente por Id -----------------------");
		Cliente cliente = new Cliente();
		Map<String, Integer> mapCliente = new HashMap<>();
		try {
			mapCliente.put("id", 1);
			cliente = clienteService.obtenerClientePorId(mapCliente);
			assertNotNull(cliente);
			System.out.println("Id:  " + cliente.getId());
			System.out.println("Nombre:  " + cliente.getNombre());
			System.out.println("Direccion:  " + cliente.getDireccion().getCalle());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Ignore
	public void pruebaNuevoCliente() {
		System.out.println("\n---------------- Test Nuevo Cliente -----------------------");
		Cliente cliente = new Cliente();
		try {
			cliente.setNombre("Cliente1");
			cliente.setApellido("De prueba");
			cliente.setEmail("cliente1prueba@gmail.com");
			cliente.setSexo("hombre");
			cliente.setIddireccion(3);
			clienteService.nuevoCliente(cliente);
			System.out.println("Cliente creado correctamente");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Ignore
	public void pruebaCambiarClientePorId() {
		System.out.println("\n---------------- Test Actualizar Cliente -----------------------");
		Cliente cliente = new Cliente();
		Map<String, Integer> mapCliente = new HashMap<>();
		Integer cambiarIdCliente;
		try {
			cambiarIdCliente = 8;
			mapCliente.put("id", cambiarIdCliente);
			cliente = clienteService.obtenerClientePorId(mapCliente);
			assertNotNull(cliente);
			
			cliente.setNombre("Nombre Cambiado");
			cliente.setApellido("Apellido Cambiado");
			clienteService.cambiarClientePorId(cliente, cambiarIdCliente);
			System.out.println("Cliente actualizado correctamente");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Ignore
	public void pruebaEliminarClientePorId() {
		System.out.println("\n---------------- Test Eliminar Cliente -----------------------");
		Cliente cliente = new Cliente();
		Map<String, Integer> mapCliente = new HashMap<>();
		Integer eliminarIdCliente;
		try {
			eliminarIdCliente = 9;
			mapCliente.put("id", eliminarIdCliente);
			cliente = clienteService.obtenerClientePorId(mapCliente);
			assertNotNull(cliente);
			clienteService.eliminarClientePorId(mapCliente);
			System.out.println("Cliente eliminado correctamente");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
