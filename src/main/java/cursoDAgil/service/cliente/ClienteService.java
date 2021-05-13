package cursoDAgil.service.cliente;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Cliente;

public interface ClienteService {
	List<Cliente> listarTodosClientes();
	Cliente obtenerClientePorId(Map<String, Integer> mapCliente);
	Integer nuevoCliente(Cliente cliente);
	Integer cambiarClientePorId(Cliente cliente, Integer id); 
	Integer eliminarClientePorId(Map<String, Integer> mapCliente);    
}