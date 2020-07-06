/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularioRegistro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Comodore
 */
public class FormularioControlador implements ActionListener {
    
    protected Conexion conexion= new Conexion();
    protected FormularioVista vista;
    protected FormularioModelo modelo;
    
   

    public FormularioControlador(FormularioVista vista, FormularioModelo modelo) {
        
        this.vista = vista;
        this.modelo = modelo;
        this.vista.enviar.addActionListener(this);
        
    }

    public void iniciar() {
        
        vista.setTitle("Formulario de registro");
        vista.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        modelo.setNombres(vista.nombres.getText());
        modelo.setApellido(vista.apellido.getText());
        
        if(vista.masculino.isSelected()){
            
            modelo.setSexo("masculino");
        
        }else if(vista.femenino.isSelected()){
            
            modelo.setSexo("femenino");
        }
        
        modelo.setEdad(Integer.parseInt(vista.edad.getText()));
        modelo.setCorreo(vista.correo.getText());
        modelo.setUsuario(vista.usuario.getText());
        modelo.setContrasena(vista.contrasena.getText());

        String nombres = modelo.getNombres();
        String apellido = modelo.getApellido();
        String sexo= modelo.getSexo();
        int edad = modelo.getEdad();
        String correo= modelo.getCorreo();
        String usuario = modelo.getUsuario();
        String contraseña = modelo.getContrasena();
        
        if(modelo.validar()==null){
            
            conexion.llenaDatos(nombres, apellido,sexo, edad,correo, usuario, contraseña);
            vista.mensaje.setText("");
            
        }else{
            
           vista.mensaje.setText(modelo.validar());
        }   

    }
    

}
