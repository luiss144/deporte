/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import CONTROL.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import MODELO.HORARIO;
import java.sql.Date;

/**
 *
 * @author ENLACE
 */
public class HORARIODao {
     
    Connection con;
    Scanner cs = new Scanner(System.in);

    public HORARIODao() {
        conectar conectar = new conectar("jdbc:mysql://localhost/deporte",
                "kikeMiranda",
                "12345");
        this.con = conectar.getConexion();
    }

    public int addUsuarios( HORARIO us) {
        
        int rest = 0;
        try {
            String query = "INSERT INTO horarios(ID_HORARIO,NOMBRE_PRESTADOR,CEDULA_PRESTADOR,TELEFONO_PRESTADOR,ID_CANCHA,NOMBRE_CANCHA,DIA_PRESTAMO,INICIO_HORARIO,FINAL_HORARIO,ESTADO_PRESTAMO) VALUES (?,?,?,?,?,?,?,?,?,?)";
           
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, us.getId_horario());
            ps.setString(2, us.getNombre_prestador());
            ps.setString(3, us.getCedula_prestador());
            ps.setString(4, us.getTelefono_prestador());
            ps.setInt(5, us.getId_cancha());
            ps.setString(6, us.getNombre_cancha());
            ps.setDate(7, us.getDia_prestamo());
            ps.setTime(8,  us.getInicio_horario());
            ps.setTime(9, us.getFinal_horario());
            ps.setString(10, us.getEstado());
            rest = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return rest;
    }

    public ArrayList<HORARIO> listhorario() {
        ArrayList<HORARIO> horario = new ArrayList();
        try {

            String query = "SELECT * FROM horarios";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rest = ps.executeQuery();
            while (rest.next()) {
                HORARIO usu = new HORARIO();
                usu.setId_horario(rest.getString("ID_HORARIO"));
                usu.setNombre_prestador(rest.getString("NOMBRE_PRESTADOR"));
                usu.setCedula_prestador(rest.getString("CEDULA_PRESTADOR"));
                usu.setTelefono_prestador(rest.getString("TELEFONO_PRESTADOR"));
                usu.setId_cancha(rest.getInt("ID_CANCHA"));
                usu.setNombre_cancha(rest.getString("NOMBRE_CANCHA"));
                usu.setDia_prestamo(rest.getDate("DIA_PRESTAMO"));
                usu.setInicio_horario(rest.getTime("INICIO_HORARIO"));
                usu.setFinal_horario(rest.getTime("FINAL_HORARIO"));
                usu.setEstado(rest.getString("ESTADO_PRESTAMO"));
                horario.add(usu);

            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return horario;
    }


    public int modificar(String t,String Nombre_prestador, String cedula, String tefo, int id,String nombrec ,java.sql.Date dia,java.sql.Time incio ,java.sql.Time fin,String estado) {
        int result = 0;
        try {

            String query = "UPDATE horarios SET  NOMBRE_PRESTADOR = ?,CEDULA_PRESTADOR = ?,TELEFONO_PRESTADOR = ?,ID_CANCHA = ?,NOMBRE_CANCHA = ?, DIA_PRESTAMO = ?, INICIO_HORARIO = ?, FINAL_HORARIO= ?, ESTADO_PRESTAMO= ?  WHERE ID_HORARIO = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Nombre_prestador);
            ps.setString(2, cedula);
            ps.setString(3,tefo);
            ps.setInt(4,id);
            ps.setString(5, nombrec);
            ps.setDate(6,dia);
            ps.setTime(7, incio);
            ps.setTime(8, fin);
            ps.setString(9,estado);
            ps.setString(10,t);
            System.out.println();
            result = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return result;
    }
     public int modificarestado(String t,String estado) {
        int result = 0;
        try {

            String query = "UPDATE horarios SET  ESTADO_PRESTAMO= ?  WHERE ID_HORARIO = ?";
            PreparedStatement ps = con.prepareStatement(query);
           
            ps.setString(1,estado);
            ps.setString(2,t);
            
            result = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return result;
    }
public int devolver(String id){
        int rest =0;
        try{
        
            String query = "DELETE FROM horarios WHERE ID_HORARIO = ?"; 
            PreparedStatement ps =con.prepareStatement(query);
            ps.setString(1, id);
            rest = ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }   
        return rest;
          }

}
