package cursoDAgil.service.marcas;

import java.io.Serializable;  
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Marcas;
import cursoDAgil.dao.marcas.MarcasDao;
import cursoDAgil.service.marcas.MarcasService;

@Named
public class MarcasServiceImpl implements MarcasService, Serializable {
	
	private static final long serialVersionUID = -1395305282711791357L;
	
	@Inject
	MarcasDao marcasDao;
	
	@Override
	public List<Marcas> listarTodasMarcas(){
		return marcasDao.listarTodasMarcas();
	}

	@Override
	public Marcas obtenerMarcaPorId(Map<String, Integer> mapMarca) {
		return marcasDao.obtenerMarcaPorId(mapMarca);
	}

	@Override
	public Integer nuevaMarca(Marcas marca) {
		return marcasDao.nuevaMarca(marca);
	}

	@Override
	public Integer actualizarMarca(Marcas marca) {
		return marcasDao.actualizarMarca(marca);
	}

	@Override
	public Integer eliminarMarca(Map<String, Integer> mapMarca) {
		return marcasDao.eliminarMarca(mapMarca);
	}
}