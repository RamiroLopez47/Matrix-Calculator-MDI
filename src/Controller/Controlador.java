/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.VentanaAcerca;
import View.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author CATTANI, Marcelo Omar. Todos los codigos en esta clase son de mi
 * autoria https://github.com/marcelocattani
 * @version 2
 */
public class Controlador implements ActionListener {
    
    VentanaPrincipal ventana;
    VentanaAcerca acercaDe=new VentanaAcerca();
    public Controlador(VentanaPrincipal ventana) {
        this.ventana = ventana;
        ventana.setBounds(0, 0, 200, 300);
        agregarOyentes();
        analisis_decimal();

    }

    /**
     * Lanza la ventana haciendola visible para el usuario
     */
    public void lanzar() {
        ventana.setVisible(true);
    }

    /**
     * Escucha las acciones de cada JMenuItem y llama a los metodos
     * correspondientes
     *
     * @param e: evento ocurrido
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "guardar") {
            guardar();
        } else if (e.getActionCommand() == "abrir") {
            abrir();
        } else if (e.getActionCommand() == "salir") {
            System.exit(0);
        } else if (e.getActionCommand() == "operacion_decimal") {
            operacion_decimal();
        } else if (e.getActionCommand() == "analisis_decimal") {
            analisis_decimal();
        } else if (e.getActionCommand() == "operacion_binaria") {
            operacion_binaria();
        } else if (e.getActionCommand() == "analisis_binario") {
            analisis_binario();
        } else if (e.getActionCommand() == "acerca") {
            acerca();
        } else if (e.getActionCommand() == "ayuda") {
            ayuda();
        } else if (e.getActionCommand() == "llenarAleatorio"){
            ventana.tabla1.llenarAleatorio();
            ventana.tabla2.llenarAleatorio();
        }

    }

    /**
     * Agrega los actionListenes a cada JMenuItem
     */
    private void agregarOyentes() {
        ventana.JIAbrir.addActionListener(this);
        ventana.JIAcercaDe.addActionListener(this);
        ventana.JIAyuda.addActionListener(this);
        ventana.JIGuardar.addActionListener(this);
        ventana.JISalir.addActionListener(this);
        ventana.JMI_Binaria_Ana.addActionListener(this);
        ventana.JMI_Binaria_Op.addActionListener(this);
        ventana.JMI_Decimal_Ana.addActionListener(this);
        ventana.JMI_Decimal_Op.addActionListener(this);
        ventana.JILlenarAleatorio.addActionListener(this);
    }

    private void guardar() {

    }

    private void abrir() {

    }

    private void operacion_decimal() {
        ventana.cambiarEstado(VentanaPrincipal.OPERACION_DECIMAL);

    }

    private void analisis_decimal() {
        ventana.cambiarEstado(VentanaPrincipal.ANALISIS_DECIMAL);
    }

    private void operacion_binaria() {
        ventana.cambiarEstado(VentanaPrincipal.OPERACION_BINARIA);
    }

    private void analisis_binario() {
        ventana.cambiarEstado(VentanaPrincipal.ANALISIS_BINARIO);
    }

    private void acerca() {
        acercaDe.setVisible(true);
    }

    private void ayuda() {
    }
    
}
