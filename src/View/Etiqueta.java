/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Anonimo
 */
public class Etiqueta extends JLabel{
    
    public Tabla tabla;
    
    public Etiqueta(View.Tabla tabla, int x, int y){
         super("",SwingConstants.CENTER);
        this.tabla = tabla;
        this.setLocation(x, y);
        this.setSize(100, 27);
       
        
        darFormato();
        agregarOyentes();
        
    }

    private void darFormato() {
        this.setForeground(Color.WHITE);
        this.setText("Limpiar Tabla");
        this.setVisible(true);
        this.setOpaque(true);
        this.setBackground(Color.BLACK);
    }

    private void agregarOyentes() {
        
        
        MouseListener l = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tabla.limpiarTabla();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(Color.white);
            }
        };
        this.addMouseListener(l);
    }
    
    
}
