
package sistema_inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistema_inventario.model.Producto;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Busca productos cuyo nombre contenga el texto ingresado ignorando mayúsculas/minúsculas
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}