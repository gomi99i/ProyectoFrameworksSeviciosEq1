package cursoDAgil.service.direccion;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.dao.direccion.DireccionDao;

@Named
public class DireccionServiceImpl implements DireccionService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7085954793356420319L;

	@Inject
	DireccionDao direccionDao;
	
	@Override
	public List<Direccion> obtenerDirecciones() {
		return direccionDao.obtenerDirecciones();
	}

	@Override
	public Integer nuevaDireccionCliente(Direccion direccion) {
		// TODO Auto-generated method stub
		return direccionDao.nuevaDireccionCliente(direccion);
	}

	@Override
	public Direccion obtenerDireccionPorId(Map<String, Integer> mapDireccion) {
		// TODO Auto-generated method stub
		return direccionDao.obtenerDireccionPorId(mapDireccion);
	}

	@Override
	public Integer eliminarDireccion(Map<String, Integer> mapDireccion) {
		// TODO Auto-generated method stub
		return direccionDao.eliminarDireccion(mapDireccion);
	}

	@Override
	public Integer cambiarDireccion(Direccion direccion, Integer id) {
		// TODO Auto-generated method stub
		direccion.setIdDireccion(id);
		return direccionDao.cambiarDireccion(direccion, id);
	}

}
