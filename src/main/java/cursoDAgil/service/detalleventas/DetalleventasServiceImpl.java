package cursoDAgil.service.detalleventas;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Detalleventas;
import cursoDAgil.dao.detalleventas.DetalleventasDao;

@Named
public class DetalleventasServiceImpl implements DetalleventasService {
	
	@Inject
	DetalleventasDao detalleventasDao;

	@Override
	public List<Detalleventas> mostrarDetallesVenta(Map<String, Integer> mapDetalleVentas){
		return detalleventasDao.mostrarDetallesVenta(mapDetalleVentas);
	}
	
	@Override
	public Integer nuevoDetalleVenta(Detalleventas detalleventas){
		return detalleventasDao.nuevoDetalleVenta(detalleventas);
	}
}