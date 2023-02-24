/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;
import MODELO.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ENLACE
 */
public class USUARIOController {
 private USUARIODao usuDAO = new USUARIODao();

    public USUARIOController() {
        
    }
    
  
  public int  CrearUsuario(int  CEDULA,String NOMBRE,String CONTRASEÑA,String TELEFONO){
      USUARIO us = new USUARIO();
      us.setCedula(CEDULA);
      us.setNombre_usuario(NOMBRE);
      us.setContraseña(CONTRASEÑA);
      us.setTelefono(TELEFONO);
     
      return usuDAO.addUsuario(us);
  } 
    public int  ListarUsuarios(int cedula,String contraseña){
     ArrayList<USUARIO> usuCad = new ArrayList(); 
       int t=0;
     ArrayList<USUARIO>usuarios = usuDAO.listUSUARIOS();
     Iterator it = usuarios.iterator();
     while(it.hasNext()){
         USUARIO usu = (USUARIO)it.next();
         if(usu.getCedula()==cedula&&usu.getContraseña().equalsIgnoreCase(contraseña)){
            t=1; 
        
         
        }
     }
        
     return t;
  }


}
