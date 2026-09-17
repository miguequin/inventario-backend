package sistema_inventario.service;
import java.util.List;
import org.springframework.stereotype.Service;
import sistema_inventario.model.Producto;
import sistema_inventario.repository.ProductoRepository;
import java.util.Optional;






@Service 

public class ProductoService { 
    private final ProductoRepository repository;
public ProductoService(ProductoRepository repository) {
this.repository = repository; 
    
    } 
    public List<Producto> listarProductos() {
    return repository.findAll();
} 
    public Producto guardarProducto(Producto producto) {
    return repository.save(producto); 
        } 
        public Optional<Producto> buscarPorId(Long id) {
return repository.findById(id); } 
public void eliminarProducto(Long id) { 
    repository.deleteById(id); } 
    public Producto actualizarProducto(Long id, Producto productoActualizado) { 
        return repository.findById(id) .map(producto -> {
            producto.setCodigo(productoActualizado.getCodigo());
            producto.setNombre(productoActualizado.getNombre());
            producto.setCategoria(productoActualizado.getCategoria());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setCantidad(productoActualizado.getCantidad());
            return repository.save(producto);
        }).orElse(null);
    }
    public Producto registrarProducto(Producto producto) {
        return repository.save(producto); 
    } 
    public Producto modificarProducto(Long id, Producto producto) { 
            Producto productoExistente = repository.findById(id)
                        .orElseThrow();
                            productoExistente.setCodigo(producto.getCodigo());
                            productoExistente.setNombre(producto.getNombre()); 
                            productoExistente.setCategoria(producto.getCategoria());
                            productoExistente.setPrecio(producto.getPrecio());
                            productoExistente.setCantidad(producto.getCantidad());
                            return repository.save(productoExistente); } 
    public List<Producto> buscarPorNombre(String nombre) {
    return repository.findByNombreContainingIgnoreCase(nombre);
}
}
