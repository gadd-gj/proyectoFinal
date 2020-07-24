package conexiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaz.*;

public class ConexionDB {
    private static ConexionDB con = null;
    
    public  static ConexionDB getInstance(){
        if (con==null) 
            con = new ConexionDB();
        return con;
    }
    
    protected Connection conex;
    protected ResultSet rs;
    private final String jdbc_drive = "org.postgresql.Driver";
    private final String db_url = "jdbc:postgresql://127.0.0.1:5432/patrones";
    private final String user = "sonar";
    private final String pass = "123";
    
    private ConexionDB(){
        try {
            Class.forName(jdbc_drive);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try {
            conex = DriverManager.getConnection(db_url,user,pass);
            System.out.println("Conexion Exitosa :D");
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public boolean execute(String sql){
        boolean res = false;
        try {
            Statement st = conex.createStatement();
            st.execute(sql);
            res = true;
        } catch (Exception e) {
            
        }

        return res;
    }
    
    
}
