/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author valentin
 */
public class AnalisisDecimal {
    
    /**
     * Obtiene la matriz que resulta de eliminar la primera fila y la columna
     * que se pasa como parámetro.
     *
     * @param matriz Matriz original
     * @param filas Numero de filas de la matriz original
     * @param columnas Numero de columnas de la matriz original
     * @param columna Columna que se quiere eliminar, junto con la fila=0
     * @return Una matriz de N-1 x N-1 elementos
     */
    private float[][] getSubmatriz(float [][]matriz, int filas, int columnas, int columna) { //SI TIRA ERROR PONER STATIC
        float[][] submatriz = new float[filas - 1][columnas - 1];
        int contador = 0;
        for (int j = 0; j < columnas; j++) {
            if (j == columna) {
                continue;
            }
            for (int i = 1; i < filas; i++) {
                submatriz[i - 1][contador] = matriz[i][j];
            }
            contador++;
        }
        return submatriz;
    }
    
    /**
     * NOTA: Tuve problemas al crear esta funcion, asique la tome de :  
     * http://chuwiki.chuidiang.org/index.php?title=Determinante_de_una_matriz
     * 
     * Calcula el determinante de la matriz. Para ello toma la primera fila y se
     * va multiplicando cada coeficiente por el determinante de la matriz de
     * orden n-1 que resulta de suprimir la fila y columna del coeficiente. Hay
     * que ir alternando los signos.
     *
     *
     * @param arreglo
     * @return determinante
     */
    public float determinante(float [][]arreglo) { //SI TIRA ERROR PONER Static
        assert arreglo != null;
        assert arreglo.length > 0;
        assert arreglo.length == arreglo[0].length;

        float determinante = 0.0f;

        int filas = arreglo.length;
        int columnas = arreglo[0].length;

        // Si la matriz es 1x1, el determinante es el elemento de la matriz
        if ((filas == 1) && (columnas == 1)) {
            return arreglo[0][0];
        }
        
        int signo = 1;

        for (int columna = 0; columna < columnas; columna++) {
            // Obtiene el adjunto de fila=0, columna=columna, pero sin el signo.
            float[][] submatriz = getSubmatriz(arreglo, filas, columnas,
                    columna);
            determinante = determinante + signo * arreglo[0][columna] * determinante(submatriz);
            signo *= -1;
        }

        return determinante;
    }
    
    /**
     * Calcula el resultado de la matriz elevada a "n", que es lo mismo que 
     * multiplicar la matriz por si misma n veces
     * @param arreglo
     * @param exponente
     * @return arregloaux
     */
    public float [][] elevar(float [][]arreglo,int exponente){
        
        float arregloaux[][] = new float[arreglo.length][arreglo[0].length];
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                arregloaux[i][j]=arreglo[i][j];
            }
        }
        //Si el exponente es 0 es la matriz identidad
        if(exponente==0)
            arregloaux=matrizIdentidad(arreglo);
        
        //Si el exponente es 1 es la misma matriz
        if(exponente==1)
            arregloaux=arreglo;
        
        //Cuando el exponente es 1 o mayor se realiza la multiplicacion
        if(exponente>1){
            for (int i = 2; i <= exponente; i++) {
                arregloaux=(multiplicarMatriz(arreglo, arregloaux));
            }
        }
        return(arregloaux);
    }
    //Solo por el uso de la funcion elevar
    private float[][] matrizIdentidad(float [][]arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                if(i == j)
                    arreglo[i][j]=1;
                else
                    arreglo[i][j]=0; 
            }
        }
        return(arreglo);
    }
    //Solo para uso de la funcion elevar
    private float[][] multiplicarMatriz(float [][]arreglo,float [][]arreglo2){
      float arreglo3[][] = new float[arreglo.length][arreglo[0].length];
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo2[i].length; j++) {
                for (int k = 0; k < arreglo2.length; k++) {
                    arreglo3[i][j] += arreglo[i][k] * arreglo2[k][j];
                }
            }
        }
        return (arreglo3);
    }


    public  void RangoMatriz(float[][] matriz){    
    int dimension = matriz.length; //Variable asignada para editar fácilmente
    int rango;                     //Cantidad de Filas linealmente independientes
    double det;                    //Determinante
    
    
    switch (dimension){
        case 0:
            rango=0;
            System.out.println("Rango: "+rango);
        break;
        
        case 1:
            if (matriz[0][0]!=0){
                rango=1;
            System.out.println("Rango: "+rango);}
            else{
                rango=0;
                System.out.println("Rango: "+rango);}
        break;
        
        case 2:
            det=(matriz[0][0]*matriz[1][1])-(matriz[1][0]*matriz[0][1]);
        if (det!=0){           
        rango=2;
        System.out.println("Rango: "+rango);}
        else{dimension--;
                RangoMatriz(matriz);
                }
        break;
        
        case 3:
            det = determinante(matriz);
            if (det!=0){           
             rango=dimension;
            System.out.println("Rango: "+rango);}
            else{dimension--;
            RangoMatriz(matriz);
                }
        break;
        
        case 4:
            det = determinante(matriz);
            if (det!=0){           
             rango=dimension;
            System.out.println("Rango: "+rango);}
            else{dimension--;
            RangoMatriz(matriz);
                }
        break;
        
        case 5:
            det = determinante(matriz);
            if (det!=0){           
             rango=dimension;
            System.out.println("Rango: "+rango);}
            else{dimension--;
            RangoMatriz(matriz);
                }
        break;
        
        case 6:
            det = determinante(matriz);
            if (det!=0){           
             rango=dimension;
            System.out.println("Rango: "+rango);}
            else{dimension--;
            RangoMatriz(matriz);
                }
        break;
        
        default:
            System.out.println("Dimension Invalida.");                       
        break;
   
        }
    }
}


