package Util;

import javax.swing.JOptionPane;

/**
 *
 * @author Ramiro Lopez
 */
public class Validations implements Validaciones {

    @Override
    public boolean esCuadrada(float[][] matriz) {
        boolean flag = false;
        if (matriz.length == matriz[0].length) {
            flag = true;
        } else {
            JOptionPane.showMessageDialog(null, "La dimensión de filas y columnas no coinciden.");
        }

        return flag;
    }

    @Override
    public boolean esCuadrada(float[][] matriz, float[][] matriz2) {
        boolean flag = false;

        if ((matriz.length == matriz[0].length) && (matriz2.length == matriz2[0].length)) {
            flag = true;
        } else {
            JOptionPane.showMessageDialog(null, "Las matrices deben ser cuadradas.");
        }

        return flag;

    }

    @Override
    public boolean esCuadrada(int[][] matriz) {
        boolean flag = false;

        if (matriz.length == matriz[0].length) {
            flag = true;
        } else {
            JOptionPane.showMessageDialog(null, "La dimensión de filas y columnas no coinciden.");
        }

        return flag;
    }

    @Override
    public boolean esCuadrada(int[][] matriz, int[][] matriz2) {
        boolean flag = false;
        if ((matriz.length == matriz[0].length) && (matriz2.length == matriz2[0].length)) {
            flag = true;
        } else {
            JOptionPane.showMessageDialog(null, "Las matrices deben ser cuadradas.");
        }
        return flag;

    }

    @Override
    public boolean potencia(float[][] matriz, int exponente) {
        boolean flag = false;
        if (exponente > 0) {
            flag = true;
        } else {
            JOptionPane.showMessageDialog(null, "El exponente debe ser positivo.");
        }
        return flag;

    }

    @Override
    public boolean columnaIgualFila(float[][] matriz, float[][] matriz2) {
        boolean flag = false;

        if (matriz[0].length == matriz2.length) {
            flag = true;
        } else {
            JOptionPane.showMessageDialog(null, "La dimensión de filas de la primer matriz no coincide con la dimensión de columnas de la segunda.");
        }

        return flag;

    }

    @Override
    public boolean mismoTamanio(float[][] matriz, float[][] matriz2) {
        boolean flag = false;

        if ((matriz.length == matriz2.length) && (matriz[0].length == matriz2[0].length)) {
            flag = true;
        } else {
            JOptionPane.showMessageDialog(null, "La dimensión de las matrices no coincide.");
        }

        return flag;
    }

    @Override
    public boolean mismoTamanio(int[][] matriz, int[][] matriz2) {
        boolean flag = false;

        if ((matriz.length == matriz2.length) && (matriz[0].length == matriz2[0].length)) {
            flag = true;
        } else {
            JOptionPane.showMessageDialog(null, "La dimensión de las matrices no coincide.");
        }

        return flag;

    }

}
