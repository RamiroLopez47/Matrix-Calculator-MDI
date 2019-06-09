/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.VentanaPrincipal;

/**
 *
 * @author CATTANI, Marcelo Omar.
 * Todos los codigos en esta clase son de mi autoria
 * https://github.com/marcelocattani
 * @version 2
 */
public class Controlador {

   VentanaPrincipal ventana;
    
    public Controlador(VentanaPrincipal ventana) {
        this.ventana = ventana;
        ventana.setBounds(0, 0, 200, 300);        
        
    }
    /**
     * Lanza la ventana haciendola visible para el usuario
     */
    public void lanzar(){
        ventana.setVisible(true);
    }
    
}
