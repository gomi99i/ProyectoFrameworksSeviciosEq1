package cursoDAgil.service.ventas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
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
import cursoDAgil.bd.domain.Productos;
import cursoDAgil.bd.domain.Ventas;
import cursoDAgil.service.cliente.ClienteService;
import cursoDAgil.service.detalleventas.DetalleventasService;
import cursoDAgil.service.ganancias.GananciasService;
import cursoDAgil.service.productos.ProductosService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })

public class VentasServiceImplTest {
	@Inject
	VentasService ventasService;
	@Inject
	DetalleventasService detalleventasService;
	@Inject
	ProductosService productosService;
	@Inject
	GananciasService gananciasService;
	@Inject
	ClienteService clienteService;

	@Test
	public void consultarTodasVentas() {
		System.out.println("\n---------------- Test Consultar Todas las Ventas -----------------------");
		int reg;
		try {
			List<Ventas> lista = ventasService.consultarTodasVentas();
			for (Ventas c : lista) {
				System.out.println("\nId venta: " + c.getIdVenta());
				System.out.println("Cliente: " + c.getCliente().getNombre() + " " + c.getCliente().getApellido());
				System.out.println("Total Venta: " + c.getTotalVenta());
				System.out.println("Fecha: " + c.getFecha());
				System.out.println("Dirección calle: " + c.getCliente().getDireccion().getCalle());
				System.out.println("Dirección ciudad: " + c.getCliente().getDireccion().getCiudad());
			}
			reg = lista.size();
			assertEquals(lista.size(), reg);
			System.out.println("\n Registros de la tabla Ventas: " + reg);
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

	@Ignore
	public void consultarVentaPorCliente() {
		System.out.println("\n---------------- Test Consultar Ventas por Cliente -----------------------");
		Map<String, Integer> mapVentas = new HashMap<>();
		mapVentas.put("id", 1);
		try {
			List<Ventas> lista = ventasService.consultarVentaPorCliente(mapVentas);
			assertNotNull(lista);
			for (Ventas ventas : lista) {
				System.out.println("\nNombre: " + ventas.getCliente().getNombre());
				System.out.println("Apellido: " + ventas.getCliente().getApellido());
				System.out.println("Id Venta: " + ventas.getIdVenta());
				System.out.println("Total de Venta: " + ventas.getTotalVenta());
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Ignore
	public void nuevaVenta() {
		System.out.println("\n---------------- Test Nueva Venta -----------------------");
		Ventas venta = new Ventas();
		List<Productos> bolsa = new ArrayList<Productos>();
		Cliente cliente = new Cliente();
		Double totalvta = 0.0;
		try {
			Map<String, Integer> mapCliente = new HashMap<>();
			mapCliente.put("id", 4);
			cliente = clienteService.obtenerClientePorId(mapCliente);
			venta.setClienteId(cliente.getId());
			Productos producto = new Productos();
			Map<String, Integer> mapProducto = new HashMap<>();
			// Producto1
			mapProducto.put("idProducto", 1);
			producto = productosService.obtenerProductoPorId(mapProducto);
			assertNotNull(producto);
			producto.setCantidad(9);
			totalvta += producto.getPrecioVta() * producto.getCantidad();
			bolsa.add(producto);
			// Producto2
			mapProducto.put("idProducto", 2);
			producto = productosService.obtenerProductoPorId(mapProducto);
			assertNotNull(producto);
			producto.setCantidad(10);
			totalvta += producto.getPrecioVta() * producto.getCantidad();
			bolsa.add(producto);
			// Proucto3
			mapProducto.put("idProducto", 13);
			producto = productosService.obtenerProductoPorId(mapProducto);
			assertNotNull(producto);
			producto.setCantidad(5);
			totalvta += producto.getPrecioVta() * producto.getCantidad();
			bolsa.add(producto);

			venta.setTotalVenta(totalvta);
			venta.setProductos(bolsa);
			venta.setFecha("2021/05/07");
			ventasService.nuevaVenta(venta);
			System.out.println("Venta creada correctamente");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@Ignore
	public void actualizaVenta() {
		System.out.println("\n---------------- Test Actualizar Venta -----------------------");
		Ventas venta = new Ventas();
		try {
			venta.setIdVenta(4);
			venta.setTotalVenta(456.13);
			venta.setFecha("2021/04/29");
			ventasService.actualizaVenta(venta);
			System.out.println("Venta actualizada correctamente");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
