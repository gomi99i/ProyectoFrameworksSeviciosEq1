package cursoDAgil.service.cliente;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.dao.cliente.ClienteDao;

@Named
public class ClienteServiceImpl implements ClienteService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	ClienteDao clienteDao;
	
	@Override
	public List<Cliente> listarTodosClientes() {
		return clienteDao.listarTodosClientes();
	}

	@Override
	public Integer nuevoCliente(Cliente cliente) {
		return clienteDao.nuevoCliente(cliente);
	}

	@Override
	public Cliente obtenerClientePorId(Map<String, Integer> mapCliente) {
		return clienteDao.obtenerClientePorId(mapCliente);
	}

	@Override
	public Integer eliminarClientePorId(Map<String, Integer> mapCliente) {
		return clienteDao.eliminarClientePorId(mapCliente);
	}

	@Override
	public Integer cambiarClientePorId(Cliente cliente, Integer id) {
		return clienteDao.cambiarClientePorId(cliente, id);
	}
}
