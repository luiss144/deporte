/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ENLACE
 */
public class conectar {
     private String cadena;
    private String usuario;
    private String password;
    public conectar(String cadena, String usuario, String password) {
        this.cadena=cadena;
        this.password=password;
        this.usuario=usuario;
    }
    
    public Connection getConexion (){
        Connection con = null;
        try{
              Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection(this.cadena,this.usuario,this.password);
              
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"CONEXION NO ESTABLECIDA");
            System.out.println(e.toString());
        }
        return con;
    }
}
