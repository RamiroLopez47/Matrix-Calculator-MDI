/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.*;
/**
 *
 * @author Castillo Alexander Marcelo
 * @version 2
 */
public class VentanaAcerca extends JFrame {
    JPanel panelPrincipal=new JPanel();
    JLabel titulo=new JLabel();
    JLabel version=new JLabel();
    ImageIcon acercade=new ImageIcon("acercade.png");
    JLabel informacion=new JLabel(acercade);
    ImageIcon logopng=new ImageIcon("icono.png");
    JLabel imagenlogo=new JLabel(logopng);
    ImageIcon gitlogo=new ImageIcon("iconogit.png");
    JLabel imagengit=new JLabel(gitlogo);
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
        panelPrincipal.add(imagenlogo);
        panelPrincipal.add(imagengit);
    }
    public void texto(){
        titulo.setText("Matrix Calculator");
        titulo.setBounds(150,20, 400, 100);//establecer ubicacion x y z , ancho alto de la letra
        titulo.setForeground(Color.black);//color del texto
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        //texto1.setOpaque(true);//activar para cambiar el fondo del texto
        //texto1.setBackground(Color.white);//color del fondo
        version.setText("VERSION 0.01");
        version.setBounds(10,510,100,100);
        version.setForeground(Color.blue);
        informacion.setBounds(10,80,1000,500);
        informacion.setIcon(new ImageIcon(acercade.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH)));
        imagenlogo.setBounds(10,10,100,100);
        imagenlogo.setIcon(new ImageIcon(logopng.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));//Achicar imagen para que entre en la etiqueta
        imagengit.setBounds(500,80,900,900);
        imagengit.setIcon(new ImageIcon(gitlogo.getImage().getScaledInstance(60,60, Image.SCALE_SMOOTH)));
    }
 }
    

