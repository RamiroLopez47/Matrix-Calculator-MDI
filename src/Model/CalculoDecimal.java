/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author francomorales
 */
public class CalculoDecimal {

    /**
     * Función multiplicar: multiplica dos matrices de tipo float;
     *
     *
     * @param arreglo: matriz 1
     * @param arreglo2: matriz 2
     * @return arreglo3: matriz 3 contiene la multiplicacion de matriz 1 y
     * matriz 2
     */
    public float[][] multiplicarporM(float arreglo[][], float arreglo2[][]) {
        float arreglo3[][] = new float[arreglo.length][arreglo2[0].length];
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo2[i].length; j++) {
                for (int k = 0; k < arreglo2.length; k++) {
                    arreglo3[i][j] += arreglo[i][k] * arreglo2[k][j];
                }
            }
        }
        return (arreglo3);
    }

    /**
     * Funcion multiplicar por numero real: multiplica una matriz por un numero
     * real.
     *
     *
     * @param arreglo: matriz
     * @param num: numero por el que se multiplica
     * @return arreglo2: matriz multiplicada por el numero real
     */
    public float[][] multiplicarPorN(float arreglo[][], float num) {
        float arreglo2[][] = new float[arreglo.length][arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                arreglo2[i][j] = arreglo[i][j] * num;
            }
        }
        return (arreglo2);
    }

    /**
     * Función sumar: suma dos matrices de tipo float.
     *
     *
     * @param arreglo: matriz 1
     * @param arreglo2: matriz 2
     * @return arreglo3: matriz 3, contiene la suma de matriz 1 y matriz 2
     */
    public float[][] sumar(float[][] arreglo, float[][] arreglo2) {
        float[][] arreglo3 = new float[arreglo.length][arreglo[0].length];
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                arreglo3[i][j] = arreglo[i][j] + arreglo2[i][j];
            }
        }
        return (arreglo3);
    }

    /**
     * Función restar: resta dos matrices de tipo float.
     *
     *
     * @param arreglo: matriz 1.
     * @param arreglo2: matriz 2.
     * @return arreglo3: matriz 3, contiene la resta de matriz 1 y matriz 2.
     */
    public float[][] restar(float[][] arreglo, float[][] arreglo2) {
        float[][] arreglo3 = new float[arreglo.length][arreglo[0].length];
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                arreglo3[i][j] = arreglo[i][j] - arreglo2[i][j];
            }
        }
        return (arreglo3);
    }

    /**
     * Función elevar: Calcula el resultado de elevar la matriz a un exponente
     * "n" que es la matriz multiplicada por si misma un numero de "n" veces.
     * Cuando el exponente sea 0 la matriz es igual a la matriz identidad y
     * Cuando sea 1 es la misma matriz.
     *
     *
     * @param arreglo: matriz 1
     * @param exponente: número al cual se eleva la matriz
     * @return arregloaux
     */
    public float[][] elevar(float[][] arreglo, int exponente) {

        float arregloaux[][] = new float[arreglo.length][arreglo[0].length];
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                arregloaux[i][j] += arreglo[i][j];
            }
        }
        //exponente = 0, la matiz es igual a matriz identidad
        if (exponente == 0) {
            arregloaux = matrizIdentidad(arreglo);
        }

        //exponente = 1 es la misma matriz
        if (exponente == 1) {
            arregloaux = arreglo;
        }
        //cuando el exponente sea de 1 en adelante va a realizar la multiplicación
        if (exponente > 1) {
            for (int i = 2; i <= exponente; i++) {
                arregloaux = (multiplicarMatriz(arreglo, arregloaux));
            }
        }
        return (arregloaux);
    }

    //solo para la funcion 'elevar'
    private float[][] matrizIdentidad(float[][] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                if (i == j) {
                    arreglo[i][j] = 1;
                } else {
                    arreglo[i][j] = 0;
                }
            }
        }
        return (arreglo);
    }

    //Solo para la función 'elevar'
    private float[][] multiplicarMatriz(float[][] arreglo, float[][] arreglo2) {
        float arreglo3[][] = new float[arreglo.length][arreglo[0].length];
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo2[i].length; j++) {
                for (int k = 0; k < arreglo2.length; k++) {
                    arreglo3[i][j] += arreglo[i][k] * arreglo2[k][j];
                
                }
            }
        }
       /* for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                arreglo3[i][j] += arreglo[i][j]*arreglo[i][j];
            }
        }*/

        return (arreglo3);
    }
    /**
     * Método para encontrar el rango de una matriz.
     * FUENTE: https://www.geeksforgeeks.org/program-for-rank-of-matrix/
     */
    public static int rangoMatriz(float matriz[][]) {

        int rango = matriz[0].length;

        for (int fila = 0; fila < rango; fila++) {

            if (matriz[fila][fila] != 0) {
                for (int col = 0; col < matriz.length; col++) {
                    if (col != fila) {

                        double mult
                                = (double) matriz[col][fila]
                                / matriz[fila][fila];

                        for (int i = 0; i < rango; i++) {
                            matriz[col][i] -= mult
                                    * matriz[fila][i];
                        }
                    }
                }
            } else {
                boolean reduce = true;

                // Encuentra los elementos que no son cero 
                // en la columna actual 
                for (int i = fila + 1; i < matriz.length; i++) {

                    //Intercambia la fila con un elemento distinto de cero con esta fila
                    if (matriz[i][fila] != 0) {
                        intercambiar(matriz, fila, i, rango);
                        reduce = false;
                        break;
                    }
                }

                //Si no encontramos ninguna fila con elementos distintos de cero,
                //entonces todos los valores en esta columna son 0.
                if (reduce) {
                    // Reduce el numero de columnas 
                    rango--;

                    // Copia la ultima columna 
                    for (int i = 0; i < matriz.length; i++) {
                        matriz[i][fila] = matriz[i][rango];
                    }
                }

                // Procesa esta fila de nuevo
                fila--;
            }

        }

        return rango;
    }

    /**
     * Método auxiliar de rangoMatriz
     */
    static void intercambiar(float matriz[][],
            int fila1, int fila2, int columna) {
        for (int i = 0; i < columna; i++) {
            float temp = matriz[fila1][i];
            matriz[fila1][i] = matriz[fila2][i];
            matriz[fila2][i] = temp;
        }
    }
}
