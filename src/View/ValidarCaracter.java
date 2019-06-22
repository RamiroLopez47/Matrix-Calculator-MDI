/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Anonimo
 */
public class ValidarCaracter implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {        
        e.consume();
        System.out.println("sucede 1");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        e.consume();
        System.out.println("sucede 2");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        e.consume();
        System.out.println(" sucede 3");
    }

}
