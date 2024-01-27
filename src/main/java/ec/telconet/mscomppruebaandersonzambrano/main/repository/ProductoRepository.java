package ec.telconet.mscomppruebaandersonzambrano.main.repository;

import ec.telconet.mscomppruebaandersonzambrano.main.entity.models.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity,Long> {
}
