package es.unican.rodrigo.mohamed.polafix.repositories;

import es.unican.rodrigo.mohamed.polafix.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}