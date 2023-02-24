/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.sql.*;
import java.util.Date;
import java.time.*;

/**
 *
 * @author ENLACE
 */
public class HORARIO {
   private String id_horario;
   private String Nombre_prestador; 
   private String cedula_prestador;
   private String telefono_prestador;
   private int id_cancha;
   private String nombre_cancha;
   private java.sql.Date dia_prestamo;
   private  java.sql.Time inicio_horario ;
   private  java.sql.Time final_horario ;
   private String estado;

    public HORARIO() {
    }

    public String getTelefono_prestador() {
        return telefono_prestador;
    }

    public void setTelefono_prestador(String telefono_prestador) {
        this.telefono_prestador = telefono_prestador;
    }
   
 
    public String getId_horario() {
        return id_horario;
    }

    public void setId_horario(String id_horario) {
        this.id_horario = id_horario;
    }

    public String getNombre_prestador() {
        return Nombre_prestador;
    }

    public void setNombre_prestador(String Nombre_prestador) {
        this.Nombre_prestador = Nombre_prestador;
    }

    public String getCedula_prestador() {
        return cedula_prestador;
    }

    public void setCedula_prestador(String cedula_prestador) {
        this.cedula_prestador = cedula_prestador;
    }

    public int getId_cancha() {
        return id_cancha;
    }

    public void setId_cancha(int id_cancha) {
        this.id_cancha = id_cancha;
    }

    public String getNombre_cancha() {
        return nombre_cancha;
    }

    public void setNombre_cancha(String nombre_cancha) {
        this.nombre_cancha = nombre_cancha;
    }

    public java.sql.Date getDia_prestamo() {
        return dia_prestamo;
    }

    public void setDia_prestamo(java.sql.Date dia_prestamo) {
        this.dia_prestamo = dia_prestamo;
    }

    public Time getInicio_horario() {
        return inicio_horario;
    }

    public void setInicio_horario(Time inicio_horario) {
        this.inicio_horario = inicio_horario;
    }

    public Time getFinal_horario() {
        return final_horario;
    }

    public void setFinal_horario(Time final_horario) {
        this.final_horario = final_horario;
    }

 

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    
}
