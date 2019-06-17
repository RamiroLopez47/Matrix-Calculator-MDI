package View;


import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexander Castillo
 */
public class BotonGit extends JLabel{
    private String link;
    private boolean dentro;
    public BotonGit(){
    
            addMouseListener(new MouseAdapter(){
             @Override
             public void mousePressed(MouseEvent me){
                 abrirLink();
             }

                @Override
                public void mouseEntered(MouseEvent e) {
                    dentro = true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    dentro = false;
                    repaint();
                }
             
           
            });
    }
    private void abrirLink(){
        
    try{
        Desktop.getDesktop().browse(new URI(link));
    }catch(Exception e){}
    }
    @Override
    public void paint(Graphics g){
    Graphics2D gd= (Graphics2D)g;
    if(dentro){
    gd.rotate(Math.toRadians(30),getWidth()/2,getHeight()/2);
    }
    super.paint(gd);
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
