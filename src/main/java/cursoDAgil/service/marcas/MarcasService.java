package cursoDAgil.service.marcas;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Marcas;

public interface MarcasService {
	List <Marcas> listarTodasMarcas();
	Marcas obtenerMarcaPorId(Map<String, Integer> mapMarca);
	Integer nuevaMarca(Marcas marca);
	Integer actualizarMarca(Marcas marca);
	Integer eliminarMarca(Map<String, Integer> mapMarca);
}
