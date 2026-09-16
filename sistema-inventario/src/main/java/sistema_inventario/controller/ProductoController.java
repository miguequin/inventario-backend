package sistema_inventario.controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sistema_inventario.model.Producto;
import sistema_inventario.service.ProductoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody; 
@RestController
@CrossOrigin(origins="*")
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
    return service.buscarPorId(id).orElse(null); } 
    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        service.eliminarProducto(id); } 
    @PutMapping("/productos/{id}")
    public Producto actualizarProducto( @PathVariable Long id, @RequestBody Producto producto) { 
        return service.actualizarProducto(id, producto); }   
    @PostMapping("/productos")
    public Producto registrarProducto(@RequestBody Producto producto) { 
    return service.registrarProducto(producto); }
        @PutMapping("/{id}") 
        public Producto modificarProducto(         
            @PathVariable Long id,
            @RequestBody Producto producto) { 
            return service.modificarProducto(id, producto); 
        } 
    } 
    
