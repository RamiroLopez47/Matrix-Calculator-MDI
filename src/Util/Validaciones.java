/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author francomorales
 */
public interface Validaciones {

    public boolean esCuadrada(float[][] matriz);

    public boolean esCuadrada(float[][] matriz, float[][] matriz2);

    public boolean esCuadrada(int[][] matriz);

    public boolean esCuadrada(int[][] matriz, int[][] matriz2);

    public boolean potencia(float[][] matriz, int exponente);

    public boolean columnaIgualFila(float[][] matriz, float[][] matriz2);

    public boolean mismoTamanio(float[][] matriz, float[][] matriz2);

    public boolean mismoTamanio(int[][] matriz, int[][] matriz2);
    

}
