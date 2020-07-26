package dao;

import conexiondb.ConexionDB;
import interfaz.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

}
