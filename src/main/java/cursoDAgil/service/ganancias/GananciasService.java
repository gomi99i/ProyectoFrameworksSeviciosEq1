package cursoDAgil.service.ganancias;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Ganancias;

public interface GananciasService {
	List<Ganancias> obtenerGanancias();
	List<Ganancias> obtenerGananciaPorFecha(Map<String,String> mapGanancias);
	Integer nuevaGanancia(Ganancias ganancias);
}
