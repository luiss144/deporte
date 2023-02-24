/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

/**
 *
 * @author ENLACE
 */
public class canchas {
    
   private int id_cancha;
   private String Nombre_cancha; 
   private String direccion;
   private String estado;

    public canchas() {
    }

    public int getId_cancha() {
        return id_cancha;
    }

    public void setId_cancha(int id_cancha) {
        this.id_cancha = id_cancha;
    }

   
   

    public String getNombre_cancha() {
        return Nombre_cancha;
    }

    public void setNombre_cancha(String Nombre_cancha) {
        this.Nombre_cancha = Nombre_cancha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   
   
    
    
    
}
