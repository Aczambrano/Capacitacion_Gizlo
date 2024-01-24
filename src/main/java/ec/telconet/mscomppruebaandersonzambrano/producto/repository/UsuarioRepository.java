package ec.telconet.mscomppruebaandersonzambrano.producto.repository;

import ec.telconet.mscomppruebaandersonzambrano.producto.entity.models.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {
}
