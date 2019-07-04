/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.Controlador;
import View.VentanaPrincipal;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        // TODO code application logic here
        VentanaPrincipal ventana = new VentanaPrincipal();
        Controlador controlador = new Controlador(ventana);
        controlador.lanzar();
    }
}
