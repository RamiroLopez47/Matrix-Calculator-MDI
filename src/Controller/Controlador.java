/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.VentanaAcerca;
import View.VentanaPrincipal;
import java.awt.Color;
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
        if (e.getActionCommand() == "nuevo") {
            nuevo();
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
        }

    }

    /**
     * Agrega los actionListenes a cada JMenuItem
     */
    private void agregarOyentes() {
        ventana.JIAbrir.addActionListener(this);
        ventana.JIAcercaDe.addActionListener(this);
        ventana.JIAyuda.addActionListener(this);
        ventana.JINuevo.addActionListener(this);
        ventana.JISalir.addActionListener(this);
        ventana.JMI_Binaria_Ana.addActionListener(this);
        ventana.JMI_Binaria_Op.addActionListener(this);
        ventana.JMI_Decimal_Ana.addActionListener(this);
        ventana.JMI_Decimal_Op.addActionListener(this);

        ActionListener actionDisminuirTamaño = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.tabla1.disminuirTamaño();
                ventana.tabla2.disminuirTamaño();
            }
        };

        ventana.btn_achicarTabla1.addActionListener(actionDisminuirTamaño);

        ActionListener actionAumentarTamaño = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.tabla1.aumentarTamaño();
                ventana.tabla2.aumentarTamaño();
            }
        };

        ventana.btn_agrandarTabla1.addActionListener(actionAumentarTamaño);
        ActionListener accionEjecutar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.tabla1.llenarAleatorio();
                ventana.tabla2.llenarAleatorio();
            }
        };

        ventana.btn_ejecutar.addActionListener(accionEjecutar);
        ActionListener actionObtener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.tabla1.mostrarMatriz();
                ventana.tabla2.mostrarMatriz();
            }
        };

        ventana.btn_obtener.addActionListener(actionObtener);
        ActionListener actionLimpiar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.tabla1.limpiarTabla();
                ventana.tabla2.limpiarTabla();
            }
        };

        ventana.btn_limpiar.addActionListener(actionLimpiar);
    }

    private void nuevo() {

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
