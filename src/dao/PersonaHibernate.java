package dao;

import interfaz.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import pojo.Persona;


public class PersonaHibernate implements IDAOGeneral<Persona> {

    private Session session;
    private Transaction transaction;

    public PersonaHibernate() {
        session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("--- Conectado ---");
    }

    public Session getSession() {
        return session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    @Override
    public boolean guardar(Persona pojo) {

        boolean res = false;

        try {
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

}