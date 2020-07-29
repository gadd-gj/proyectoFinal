package dao;

import conexiondb.ConexionDB;
import interfaz.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import pojo.Persona;

public class PersonaHibernate implements IDAOGeneral<Persona> {

    private Session session;
    private ConexionDB con;

    public PersonaHibernate() {
//        session = HibernateUtil.getSessionFactory().openSession();
//        System.out.println("--- Conectado ---");
    }

    @Override
    public boolean borrar(Persona pojo) {
        boolean centinela = false;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            System.out.println("--- Conectado ---");

            session.beginTransaction();

            System.out.println("--- Eliminando ---");

            session.delete(pojo);

            session.getTransaction().commit();

            centinela = true;
            session.close();

            System.out.println("--- Eliminado ---");
        } catch (Exception e) {
            System.out.println("La puta madre, no funciono, we" + e.getMessage());
        }

        return centinela;
    }

    @Override
    public boolean guardar(Persona pojo) {

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

            session.getTransaction().rollback();
            System.out.println("No se ha podido finalizar la transacción");
            return res;

        }

        return res;
    }

    @Override
    public boolean actualizar(Persona pojo) {
        boolean res = false;

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            System.out.println("--- Conectado ---");

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
        List<Persona> list = null;
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM pojo.Persona WHERE clave = :id");
            query.setParameter("id", clave);
            list = query.list();

            session.close();

        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }
        
        return list;
    }

}
