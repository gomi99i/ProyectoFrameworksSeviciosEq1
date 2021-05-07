package cursoDAgil.service.ventas;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Ventas;
import cursoDAgil.dao.ventas.VentasDao;

@Named
public class VentasServiceImpl implements VentasService{
	
	@Inject 
	VentasDao ventasDao;
	
	
	public List<Ventas> consultarTodasVentas() {
		return ventasDao.consultarTodasVentas();
	}


	@Override
	public List<Ventas> consultarVentaPorCliente(Map<String, Integer> mapVentas) {
		return ventasDao.consultarVentaPorCliente(mapVentas);
	}


	@Override
	public Integer nuevaVenta(Ventas venta) {
		return ventasDao.nuevaVenta(venta);
	}


	@Override
	public Integer actualizaVenta(Ventas venta) {
		return ventasDao.actualizaVenta(venta);
	} 

}
