package sistema_inventario.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sistema_inventario.model.Producto;
import sistema_inventario.service.ProductoService;

@RestController
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return service.listarProductos();
    }

    @GetMapping("/productos/{id}")
    public Producto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).orElse(null);
    }

    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        service.eliminarProducto(id);
    }

    @PutMapping("/productos/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return service.actualizarProducto(id, producto);
    }

    @PostMapping("/productos")
    public Producto registrarProducto(@RequestBody Producto producto) {
        return service.registrarProducto(producto);
    }

    // Endpoint de búsqueda corregido con service y la ruta completa /productos/buscar/{nombre}
    @GetMapping("/productos/buscar/{nombre}")
    public ResponseEntity<List<Producto>> buscarPorNombre(@PathVariable String nombre) {
        List<Producto> productos = service.buscarPorNombre(nombre);
        return ResponseEntity.ok(productos);
    }
}
