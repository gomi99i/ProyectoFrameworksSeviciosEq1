package cursoDAgil.service.direccion;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Direccion;

public interface DireccionService {
	List<Direccion> obtenerDirecciones(); //listar las direcciones
	Direccion obtenerDireccionPorId(Map<String, Integer> mapDireccion); //obtiene una direccion por id
	Integer nuevaDireccionCliente(Direccion direccion); //crea una direccion
	Integer cambiarDireccion(Direccion direccion, Integer id);//Cambiar direccion
	Integer eliminarDireccion(Map<String, Integer> mapDireccion); // Eliminar una direccion
}
