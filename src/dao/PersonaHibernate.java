package dao;

import interfaz.HibernateUtil;
import javax.swing.JOptionPane;
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
    public boolean borrar(Persona pojo){
        boolean centinela = false;
        
        try{
            session.beginTransaction();
            session.delete(pojo);
            session.getTransaction().commit();
            centinela = true;
        }catch(Exception e){
            System.out.println("La puta madre, no funciono, we"+e.getMessage());
        }
        
        return centinela ;
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
