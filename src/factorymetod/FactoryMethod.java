/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorymetod;

import dao.DepartamentoDAO;
import dao.IDAOGeneral;
import dao.PersonaHibernate;
import pojo.Persona;

/**
 *
 * @author gaddiel
 */
public class FactoryMethod {

    public enum TypeDAO {
        PERSONA, DEPARTAMENTO
    }

    public static IDAOGeneral create(TypeDAO t) {
        IDAOGeneral dao = null;

        switch (t) {

            case PERSONA:
                dao = new PersonaHibernate();
                break;
            case DEPARTAMENTO:
                dao = new DepartamentoDAO();
                break;

        }
        return dao;

    }

}
