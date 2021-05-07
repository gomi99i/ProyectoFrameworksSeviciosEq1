package cursoDAgil.service.ventas;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Ventas;

public interface VentasService {
	List<Ventas> consultarTodasVentas();
	List<Ventas> consultarVentaPorCliente(Map<String, Integer> mapVentas);
	Integer nuevaVenta(Ventas venta);
	Integer actualizaVenta(Ventas venta);
}
