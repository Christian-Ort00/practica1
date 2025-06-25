package practica.arboles.service;

import java.util.List;
import practica.arboles.domain.Arbol;

public interface ArbolService {
    public List<Arbol> getArboles();
    public void save(Arbol arbol);
    public void delete(Arbol arbol);
    public Arbol getArbol(Arbol arbol);
}
