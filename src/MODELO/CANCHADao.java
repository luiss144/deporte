/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;
 import CONTROL.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author ENLACE
 */
public class CANCHADao {
    
    Connection con;
    Scanner cs = new Scanner(System.in);

    public CANCHADao() {
        conectar conectar = new conectar("jdbc:mysql://localhost/deporte",
                "kikeMiranda",
                "12345");
        this.con = conectar.getConexion();
    }


    public  ArrayList<canchas> listcachas(String nombreCacha) {
        
        ArrayList<canchas> cachan = new ArrayList();
        try {

            String query = "SELECT * FROM canchas";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rest = ps.executeQuery();
            while (rest.next()) {
                canchas usu = new canchas();
                usu.setId_cancha(rest.getInt("ID_CANCHA"));
                usu.setNombre_cancha(rest.getString("NOMBRE_CANCHA"));
                usu.setDireccion(rest.getString("DIRECCION"));
                usu.setEstado(rest.getString("ESTADO"));
                cachan.add(usu);

            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return cachan;
    }


    public int modificar(String nombre,String estado) {
        int result = 0;
        try {

            String query = "UPDATE canchas SET ESTADO= ? WHERE 	NOMBRE_CANCHA = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, estado);
            ps.setString(2, nombre);
           
            System.out.println();
            result = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return result;
    }

}
