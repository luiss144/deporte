/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import MODELO.HORARIO;
import MODELO.HORARIODao;
import MODELO.canchas;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author ENLACE
 */
public class HORARIOController {
     HORARIODao ld=new HORARIODao();
    HORARIO us=new HORARIO();
   
  public int  CrearHorario(String id_h,String Nombre_prestador, String cedula, String tefo, int id,String nombrec ,java.sql.Date dia,java.sql.Time incio ,java.sql.Time fin,String estado){
      
     us.setId_horario(id_h);
     us.setNombre_prestador(Nombre_prestador);
     us.setCedula_prestador(cedula);
     us.setTelefono_prestador(tefo);
     us.setId_cancha(id);
     us.setNombre_cancha(nombrec);
     us.setDia_prestamo(dia);
     us.setInicio_horario(incio);
     us.setFinal_horario(fin);
     us.setEstado(estado);
    return ld.addUsuarios(us);
  } 
    public ArrayList<HORARIO>  ListarHorario(){
     ArrayList<String> liCad = new ArrayList(); 
       
     ArrayList<HORARIO>usuarios = ld.listhorario();
     
        
     return usuarios;
  }
      public ArrayList <HORARIO> Buscarprestadorcedula(String cedula){
      ArrayList<HORARIO> usu = this.ld.listhorario();
      ArrayList <HORARIO> liCad = new ArrayList();
     for(int i=0;i<usu.size();i++){
        
        if(usu.get(i).getCedula_prestador().equalsIgnoreCase(cedula)){
             
            liCad.add(usu.get(i));
        }
       }
     return liCad;
          
      
  }
      public int ModificarUsuario(String th,String Nombre_prestador, String cedula, String tefo, int id,String nombrec ,java.sql.Date dia,java.sql.Time incio ,java.sql.Time fin,String estado){
     
    return ld.modificar(th,Nombre_prestador,cedula,tefo, id,nombrec ,dia, incio ,fin,estado);
      
  }
public int Modificarestado(String th,String estado){
     
    return ld.modificarestado(th,estado);
      
  }
    public ArrayList<HORARIO> Buscarhorarionombre(String nombre) {
         ArrayList<HORARIO> usu = this.ld.listhorario();
      ArrayList <HORARIO> liCad = new ArrayList();
     for(int i=0;i<usu.size();i++){
        
        if(usu.get(i).getNombre_cancha().equalsIgnoreCase(nombre)){
             
            liCad.add(usu.get(i));
        }
       }
     return liCad; 
          
      
        
    }
   public ArrayList<HORARIO> Buscarhorariofecha(java.sql.Date date) {
         ArrayList<HORARIO> usu = this.ld.listhorario();
      ArrayList <HORARIO> liCad = new ArrayList();
     for(int i=0;i<usu.size();i++){
        
        if(usu.get(i).getDia_prestamo()==date){
             
            liCad.add(usu.get(i));
        }
       }
     return liCad; 
          
      
        
    }

    public ArrayList<HORARIO> Buscarhorario(String Nombre_prestador, String cedula,String nombrec ,java.sql.Date dia) {
       
       
     ArrayList<HORARIO>hora = ld.listhorario();
     ArrayList<HORARIO> liCad = new ArrayList(); 
     for(int i=0;i<hora.size();i++){
        
         if(hora.get(i).getCedula_prestador().equalsIgnoreCase(cedula)&&hora.get(i).getNombre_cancha().equalsIgnoreCase(Nombre_prestador)&&hora.get(i).getNombre_cancha().equalsIgnoreCase(nombrec)&&hora.get(i).getDia_prestamo()==dia){
             
            liCad.add(hora.get(i));
                 
        }
         
         
     }
     
     
     
        
     return liCad; 
    }

    public ArrayList<HORARIO> Buscarhorariocancha(String op1) {
          
     ArrayList<HORARIO>usuarios = ld.listhorario();
     ArrayList<HORARIO> liCad = new ArrayList(); 
     for(int i=0;i<usuarios.size();i++){
        
        if(usuarios.get(i).getNombre_cancha().equalsIgnoreCase(op1)){
             
            liCad.add(usuarios.get(i));
        }
       }
     return liCad; 
    }

    public int eliminar(String fila) {
        int t;
        t=ld.devolver(fila);
        
        return t;
}
    
        
}