/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.*;
/**
 *
 * @author Castillo Alexander Marcelo
 * @version 1
 */
public class VentanaAcerca extends JFrame {
    public VentanaAcerca(){
        super("Acerca de MATRIX CALCULATOR");
        iniciarComponentes();
        texto();
    }
        
    public void iniciarComponentes(){
    this.setBackground(Color.DARK_GRAY);
    this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Abrir ventana maximizada
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Finalizar Ejecucion al cerrarla
    
     }
    public void texto(){
    JLabel textoAcerca=new JLabel();
    textoAcerca.setFont(new Font("Arial", Font.BOLD, 30));
    textoAcerca.setText("HOLA como estas");
    textoAcerca.setSize(350,30);
    textoAcerca.setLocation(550,40);
        }
    }
    

