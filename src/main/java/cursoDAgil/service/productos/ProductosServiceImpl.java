package cursoDAgil.service.productos;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import cursoDAgil.bd.domain.Productos;
import cursoDAgil.dao.productos.ProductosDao;

@Named
public class ProductosServiceImpl implements ProductosService, Serializable {

	
	private static final long serialVersionUID = -6591933548138985119L;
	@Inject
	ProductosDao productosDao;
	
	@Override
	public List<Productos> obtenerProductos(){
		return productosDao.obtenerProductos();		
	}

	@Override
	public Integer nuevoProductoMarca(Productos producto) {
		// TODO Auto-generated method stub
		return productosDao.nuevoProductoMarca(producto);
	}

	@Override
	public Integer eliminarProductoPorId(Map<String, Integer> mapProducto) {
		// TODO Auto-generated method stub
		return productosDao.eliminarProductoPorId(mapProducto);
	}

	@Override
	public Integer cambiarProductoPorId(Productos producto, Integer id) {
		// TODO Auto-generated method stub
		return productosDao.cambiarProductoPorId(producto, id);
	}

	@Override
	public Productos obtenerProductoPorId(Map<String, Integer> mapProducto) {
		// TODO Auto-generated method stub
		return productosDao.obtenerProductoPorId(mapProducto);
	}
}
