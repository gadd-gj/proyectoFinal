package dao;

import conexiondb.ConexionDB;
import interfaz.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import pojo.Departamento;
import pojo.Persona;

public class DepartamentoDAO implements IDAOGeneral<Departamento> {

    private Session session;
    private ConexionDB con;

    public DepartamentoDAO() {
//        session = HibernateUtil.getSessionFactory().openSession();
//        System.out.println("--- Conectado ---");
    }

    @Override
    public boolean guardar(Departamento pojo) {
        boolean res = false;

        try {
            
            session = HibernateUtil.getSessionFactory().openSession();
            System.out.println("--- Conectado ---");

            session.beginTransaction();

            System.out.println("--- Transacción iniciada ---");

            session.save(pojo);

            session.getTransaction().commit();

            res = true;

       } catch (ConstraintViolationException cve) {
//
            session.getTransaction().rollback();
            System.out.println("No se ha podido finalizar la transacción");
            return res;
//
       }
        return res;
        
    }

    @Override
    public boolean borrar(Departamento pojo) {

        boolean centinela = false;

        session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("--- Conectado ---");

        try {

            session.beginTransaction();
            System.out.println("--- Eliminando ---");

            session.delete(pojo);
            session.getTransaction().commit();

            centinela = true;
            System.out.println("Eliminado");

        } catch (Exception e) {

            System.out.println("Algo salió mal: " + e.getMessage());

        }

        return centinela;
    }

    @Override
    public boolean actualizar(Departamento pojo) {

        boolean res = false;

        session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("--- Conectado ---");

        try {
            session.beginTransaction();

            System.out.println("--- Actualizando ---");

            session.update(pojo);
            session.getTransaction().commit();

            res = true;

            System.out.println("--- Actualizado ---");
        } catch (ConstraintViolationException cve) {

            session.getTransaction().rollback();
            System.out.println("No se ha podido finalizar la transacción");
            return res;

        }
        return res;
        
    }

    @Override
    public List mostrar(String clave) {
        List<Departamento> list = null;
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM pojo.Departamento WHERE clave = :id");
            query.setParameter("id", clave);
            list = query.list();

            session.close();

        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }
        
        return list;
    }

   
}
