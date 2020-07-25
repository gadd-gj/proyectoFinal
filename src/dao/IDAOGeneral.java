package dao;


public interface IDAOGeneral<T> {

    public boolean guardar(T pojo);
    public boolean borrar(T pojo);

}
