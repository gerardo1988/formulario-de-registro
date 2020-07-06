/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularioRegistro;

/**
 *
 * @author Comodore
 */
public class EjecutaFormulario {
    
    public static void main(String[] args) {
        
        FormularioModelo fm= new FormularioModelo();
        FormularioVista fv= new  FormularioVista();
        FormularioControlador fc= new FormularioControlador(fv,fm); 
        
        
        fv.setVisible(true);
        fc.iniciar();
    }
    
}
