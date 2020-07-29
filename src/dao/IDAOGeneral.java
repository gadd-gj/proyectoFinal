package dao;

import java.util.List;

public interface IDAOGeneral<T> {

    public boolean guardar(T pojo);

    public boolean borrar(T pojo);

    public boolean actualizar(T pojo);
    
    public List mostrar(String clave);
    
}
