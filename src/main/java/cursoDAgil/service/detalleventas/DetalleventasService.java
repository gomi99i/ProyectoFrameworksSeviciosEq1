package cursoDAgil.service.detalleventas;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Detalleventas;

public interface DetalleventasService {

	List<Detalleventas> mostrarDetallesVenta(Map<String, Integer> mapDetalleVentas);

	Integer nuevoDetalleVenta(Detalleventas detalleventas);

}