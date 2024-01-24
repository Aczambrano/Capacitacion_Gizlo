package ec.telconet.mscomppruebaandersonzambrano.producto.repository;

import ec.telconet.mscomppruebaandersonzambrano.producto.entity.models.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity,Long> {
}
