/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularioRegistro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Comodore
 */
public class FormularioModelo {
    
    protected String nombres;
    protected String apellido;
    protected int edad;
    protected String correo;
    protected String usuario;
    protected String contrasena;
    protected String sexo;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
       

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        
        
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String validar(){
        
        if(nombres.equals("")){
            
            return "el campo nombre no puede estar vacio"; 
        }
        
        if(apellido.equals("")){
            
            return "el campo apellido no puede estar vacio";
        
        }
        
        if(usuario.equals("")){
            
            return "usario requerido";      
        }
        
        if(edad <18){
            
            return "debe tener mas de 18 años";       
        
        }
        
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        if(mather.find() == false){
            
            return "correo incorrecto";
       
        }
        
        int contador=0;
        for(int i=0; i<contrasena.length(); i++){
             
            contador++;
            
        }
        
        if (contador<=6){
            
            return "la contraseña debe tener mas de 6 caracteres";
        
        }
        
        return null;     
        
    }
    
    
    
    
    
    
}
