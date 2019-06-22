/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author
 */
public class CalculoBinario {

    /**
     * Función unión: Suma dos matrices binarias (int);
     *
     * @param arreglo: matriz 1.
     * @param arreglo2: matriz 2.
     * @return arreglo3: contiene la suma logica entre matriz 1 y matriz 2.
     */
    public int[][] union(int[][] arreglo, int[][] arreglo2) {
        int[][] arreglo3 = new int[arreglo.length][arreglo[0].length];
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                arreglo3[i][j] = arreglo[i][j] + arreglo2[i][j];
                if (arreglo3[i][j] == 2) {
                    arreglo3[i][j] = 1;
                }
            }
        }
        return (arreglo3);
    }

    /**
     * Esta funcion retorna la diferencia binaria entre dos matrices de igual
     * tamaño
     *
     * @param arreglo: matriz minuendo
     * @param arreglo2: matriz sustraendo
     * @return arreglo2: matriz resultado.
     */
    public int[][] diferencia(int[][] arreglo, int[][] arreglo2) {
        int[][] arreglo3 = new int[arreglo.length][arreglo[0].length];

        for (int i = 0; i < arreglo3.length; i++) {
            for (int j = 0; j < arreglo3[0].length; j++) {
                if (arreglo[i][j] == 1 && arreglo2[i][j] == 0) {
                    arreglo3[i][j] = 1;
                } else {
                    arreglo[i][j] = 0;
                }
            }
        }

        return arreglo3;
    }

    /**
     * Esta funcion retorna la matriz traspuesta binaria
     *
     * @param arreglo matriz binaria de entrada
     * @return arreglo2: matriz binaria traspuesta
     */
    public int[][] traspuesta(int[][] arreglo) {
        int[][] arreglo2 = new int[arreglo[0].length][arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                arreglo2[j][i] = arreglo[i][j];
            }
        }
        return arreglo2;
    }

    /**
     * Composicion Esta funcion devuelve la composicion entre una matriz a y una
     * matriz b
     *
     * @param arreglo matriz 1
     * @param arreglo2 matriz 2
     * @return arreglo3 matriz 3 (resultado de la composicion de la matriz 1 y
     * 2)
     */
    public int[][] composicion(int arreglo[][], int arreglo2[][]) {
        int[][] arreglo3 = new int[arreglo.length][arreglo2.length];
        if (arreglo[0].length != arreglo2.length) {//Si las columnas de la primer matriz no tienen el mismo largo que las filas de la segunda no se puede realizar esta operacion
            System.out.println("No puede hacerse composicion con estas matrices");
        } else {
            for (int x = 0; x < arreglo3.length; x++) {
                for (int y = 0; y < arreglo3[x].length; y++) {
                    for (int z = 0; z < arreglo[0].length; z++) {
                        arreglo3[x][y] += arreglo[x][z] * arreglo2[z][y];
                        if (arreglo3[x][y]>1){
                        arreglo3[x][y]=1;}
                    }
                }
            }
        }
        return arreglo3;
    }

    public int[][] complemento(int[][] arreglo) {
        int[][] complemento = new int[arreglo.length][arreglo[0].length];
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                complemento[i][j] = (1 - arreglo[i][j]);
                if (complemento[i][j] < 0) {
                    complemento[i][j] = 0;
                }

            }
        }

        return complemento;
    }

    /**
     * Interseccion Devuelve los elementos que tienen en común la matriz A y la
     * matriz B.
     *
     * @param arreglo matriz 1
     * @param arreglo2 matriz 2
     * @return arreglo3 matriz 3 (resultado de la intersección entre las
     * matrices 1 y 2)
     */
    public int[][] interseccion(int[][] arreglo, int[][] arreglo2) {
        int[][] arreglo3 = new int[arreglo.length][arreglo[0].length];
        for (int i = 0; i < arreglo3.length; i++) {
            for (int j = 0; j < arreglo3[0].length; j++) {
                if (arreglo[i][j] == 1 && arreglo2[i][j] == 1) {
                    arreglo3[i][j] = 1;
                } else {
                    arreglo3[i][j] = 0;
                }
            }
        }
        return arreglo3;
    }

}
