package practica.arboles.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import practica.arboles.domain.Arbol;

public interface ArbolDao extends JpaRepository<Arbol, Long> {
}
