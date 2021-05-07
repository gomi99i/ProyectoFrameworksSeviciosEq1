package cursoDAgil.service.ganancias;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Ganancias;
import cursoDAgil.dao.ganancias.GananciasDao;

@Named
public class GananciasServiceImpl implements GananciasService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject 
	GananciasDao gananciasDao;
	
	@Override
	public List<Ganancias> obtenerGanancias() {
		return gananciasDao.obtenerGanancias();
	}

	@Override
	public Integer nuevaGanancia(Ganancias ganancias) {
		return gananciasDao.nuevaGanancia(ganancias);
	}

	@Override
	public List<Ganancias> obtenerGananciaPorFecha(Map<String, String> mapGanancias) {
		return gananciasDao.obtenerGananciaPorFecha(mapGanancias);
	}	

}
