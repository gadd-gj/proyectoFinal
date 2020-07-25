/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexiondb.ConexionDB;
import interfaz.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import pojo.Departamento;

/**
 *
 * @author gaddiel
 */
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

            session.getTransaction().rollback();
            System.out.println("No se ha podido finalizar la transacción");
            return res;

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
}
