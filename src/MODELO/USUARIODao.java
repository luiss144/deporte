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
public class USUARIODao {
    
    Connection con;
    Scanner cs = new Scanner(System.in);

    public USUARIODao() {
        conectar conectar = new conectar("jdbc:mysql://localhost/deporte",
                "kikeMiranda",
                "12345");
        this.con = conectar.getConexion();
    }

    public int addUsuario( USUARIO us) {
        int rest = 0;
        try {
            String query = "INSERT INTO usuarios (CEDULA,NOMBRE,CONTRASEÑA,TELEFONO) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
           ps.setInt(1, us.getCedula());
           ps.setString(2, us.getNombre_usuario()); 
           ps.setString(3, us.getContraseña());
           ps.setString(4, us.getTelefono());
            rest = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return rest;
    }

    public ArrayList<USUARIO> listUSUARIOS() {
        ArrayList<USUARIO> USUARIO = new ArrayList();
        try {

            String query = "SELECT * FROM usuarios";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rest = ps.executeQuery();
            while (rest.next()) {
                USUARIO usu = new USUARIO();
                usu.setCedula(rest.getInt("CEDULA"));
                usu.setContraseña(rest.getString("CONTRASEÑA"));
                
                USUARIO.add(usu);

            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return USUARIO;
    }

    public USUARIO buscar(String cedula) {
        USUARIO usu = new USUARIO();
        try {

            String query = "SELECT * FROM usuarios where CEDULA = ? ";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cedula);
            ResultSet rest = ps.executeQuery();
            if (rest.next()) {

                usu.setNombre_usuario(rest.getString("NOMBRE"));
                usu.setTelefono(rest.getString("TELEFONO"));
                usu.setContraseña(rest.getString("CONTRASEÑA"));
                usu.setCedula(rest.getInt("CEDULA"));
                
            } else {
                usu = null;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return usu;
    }
//
//    public int modificar(String nombre, String fecha, String cedula, String sexo, String tipo) {
//        int result = 0;
//        try {
//
//            String query = "UPDATE usuario SET nombre = ?, fecha = ?, sexo = ?, tipo= ? WHERE cedula = ?";
//            PreparedStatement ps = con.prepareStatement(query);
//            ps.setString(1, nombre);
//            ps.setString(2, fecha);
//            ps.setString(3, sexo);
//            ps.setString(4, tipo);
//            ps.setString(5, cedula);
//            System.out.println();
//            result = ps.executeUpdate();
//            ps.close();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e.toString());
//        }
//        return result;
//    }

}
