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
    JPanel panelPrincipal=new JPanel();
    JLabel titulo=new JLabel();
    JLabel version=new JLabel();
    JLabel informacion=new JLabel();
    public VentanaAcerca(){
        setTitle("Acerca de MATRIX CALCULATOR");
        iniciarComponentes();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Abrir ventana maximizada
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Finalizar Ejecucion al cerrarla
        
    }
    public  void iniciarComponentes() {
        this.getContentPane().add(panelPrincipal);
        panelPrincipal.setLayout(null);
        texto();
        panelPrincipal.add(titulo);
        panelPrincipal.add(version);
        panelPrincipal.add(informacion);
    }
    public void texto(){
        titulo.setText("Matrix Calculator");
        titulo.setBounds(150,60, 400, 100);//establecer ubicacion x y z , ancho alto de la letra
        titulo.setForeground(Color.black);//color del texto
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        //texto1.setOpaque(true);//activar para cambiar el fondo del texto
        //texto1.setBackground(Color.white);//color del fondo
        version.setText("VERSION 0.01");
        version.setBounds(10,510,100,100);
        version.setForeground(Color.blue);
        informacion.setText("Matrix Calculator es una red mundial de ingenieros de software "+
                ",artistas, escritores ");
        informacion.setBounds(250,250,800, 20);
        informacion.setOpaque(true);
        informacion.setBackground(Color.white);
    }
 }
    

