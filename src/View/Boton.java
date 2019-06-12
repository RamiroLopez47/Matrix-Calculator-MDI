/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JButton;

/**
 *
 * @author Anonimo
 */
public class Boton extends JButton{
    
    public static final int CUADRADO = 0, ESTANDAR = 1;
    private int grupo;
    
    public Boton(){
        super();
    }
    
    public Boton(String texto, int tipo, int grupo){
        super(texto);
        setTipo(tipo);
        this.grupo = grupo;
    }

    private void setTipo(int tipo) {
        switch (tipo){
            case ESTANDAR: setearEstandar();
            break;
            case CUADRADO: setterarCuadrado();
            break;
        }
    }

    private void setearEstandar() {
        this.setSize(100,45);
    }

    private void setterarCuadrado() {
        this.setSize(44,45);
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }
    
    
    
}
