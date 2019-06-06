/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author AlexMarceloCastillo
 */
public class AnalisisBinaria {
      /**
     * Funcion Reflexiva: Analiza si una matriz binaria es o no reflexiva
     * 
     * @param arreglo entero
     * @return boolean
     */
    public boolean reflexiva(int [][]arreglo){
        boolean resp=false; //respuesta,
        int [][]arregloAux=new int [arreglo.length][arreglo.length];
        matrizIdentidad(arregloAux);
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                if(arregloAux[i][j]<= arreglo[i][j])
                    resp=true;
                else{
                    resp=false;
                    break;
                }
            }
        }
        return resp;
    }

    /**
     * Funcion Simétrica: Analiza si una matriz binaria es o no simétrica
     * 
     * @param arreglo entero
     * @return boolean
     */
    public boolean simetrica(int [][]arreglo){
        boolean resp=false; //respuesta,
        int [][]arregloAux=new int [arreglo.length][arreglo.length];
        copiarMatriz(arregloAux, arreglo);
        matrizTraspuesta(arregloAux);
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                if (arreglo[i][j]==arregloAux[i][j])
                    resp=true;
                else{
                    resp=false;
                    break;
                }
            }
        }
        return resp;
    }

    /**
     * Funcion Antisimétrica: Analisa si una matriz binaria es o no antisimétrica
     * 
     * @param arreglo entero
     * @return boolean
     */    
    public boolean antiSimetrica(int [][]arreglo){
        boolean resp=false; //respuesta,
        //arreglo para la traspuesta
        int [][]arregloAux=new int [arreglo.length][arreglo.length];
        //arreglo para conjuncion
        int [][]arregloAuxC=new int [arreglo.length][arreglo.length];
        copiarMatriz(arregloAux, arreglo);
        matrizTraspuesta(arregloAux);
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                arregloAuxC[i][j]=arreglo[i][j]*arregloAux[i][j];
            }
        }
        resp=comparar(arregloAuxC,'a');
        return resp;
        }

    /**
     * Funcion Transitiva: Analiza si una matriz binaria es o no transitiva
     * 
     * @param arreglo entero
     * @return boolean
     */    
    public boolean transitiva(int [][]arreglo){
        boolean resp=false;
        //Arreglo para copiar elementos
        int [][]arregloAux=new int [arreglo.length][arreglo.length];
        copiarMatriz(arregloAux, arreglo);
        //Arreglo para almacenar el valor de la multiplicacion binaria
        int [][]arregloAuxC=new int [arreglo.length][arreglo.length];
        multplicacionBinaria(arreglo,arregloAux,arregloAuxC);
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                if (arregloAuxC[i][j]<=arreglo[i][j])
                    resp=true;
                else{
                    resp=false;
                    break;
                }
            }
        }
        return resp;
    }

    /**
     * Funcion Total: Analiza si una matriz binaria es o no total.
     * 
     * @param arreglo entero 
     * @return boolean
     */   
    public boolean total(int [][]arreglo){
        boolean resp; //respuesta,
        //arreglo para la traspuesta
        int [][]arregloAux=new int [arreglo.length][arreglo.length];
        //arreglo para disyunción
        int [][]arregloAuxC=new int [arreglo.length][arreglo.length];
        copiarMatriz(arregloAux, arreglo);
        matrizTraspuesta(arregloAux);
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                arregloAuxC[i][j]=arreglo[i][j]+arregloAux[i][j];
            }
        }
        controlMat(arregloAuxC);
        resp=comparar(arregloAuxC,'t');
        return resp;
    }

/*                  Funciones Auxiliares para esta Clase en específico                  */

    /*
     * Solo para Función 'reflexiva'.
     * Función Matriz Identidad
     */
    private void matrizIdentidad(int [][]arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                if (i==j)
                    arreglo[i][j]=1;
                else
                    arreglo[i][j]=0;
            }  
        }
    }

    /*
     * Solo para Función 'total'.
     */
    private int[][] matrizTotal(int [][]arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                arreglo[i][j]=1;
            }  
        }
        return arreglo;
    }

    /*
     * Solo para funciones 'simetrica','antiSimetrica' y 'total'.
     */
    private void matrizTraspuesta(int [][]arreglo){
        //Arreglo Traspuesto
        int [][]arregloAux=new int [arreglo.length][arreglo.length];
    //copiar elementos recividos como parámetros para el arreglo auxiliar
        copiarMatriz(arregloAux, arreglo);

        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                arreglo[i][j]=arregloAux[j][i];
            }
        }
    }

    /*
     * Solo para funciones que lo requieran.
     * (Copia elementos de una matriz a otra)
     */
    private void copiarMatriz(int [][]argNew,int [][]argCopy){
        //Parámetros nuevo arreglo (vacio),arreglo con los datos a copiar
        for (int i = 0; i < argCopy.length; i++) {
            for (int j = 0; j < argCopy.length; j++) {
                argNew[i][j]=argCopy[i][j];
            }
        }

    }

    /*
     * Solo para funciones 'antiSimetrica' y 'total'.
     */
    private boolean comparar(int [][]argResul,char resp){
    //parametros(arrreglo Resultado, char para elegir opción);
        boolean respAux=false;
        //arreglo para matriz identidad
        int [][]arregloAux=new int [argResul.length][argResul.length];
        if (resp=='a') { //'a' <-> 'antiSimetrica'
            matrizIdentidad(arregloAux);
            for (int i = 0; i < argResul.length; i++) {
                for (int j = 0; j < argResul.length; j++) {
                    if(argResul[i][j]<= arregloAux[i][j])
                        respAux=true;
                    else{
                        respAux=false;
                        break;
                    }
                } 
            }
        }else{
            if (resp=='t') { //'t' <-> 'total'
                matrizTotal(arregloAux);
                for (int i = 0; i < argResul.length; i++) {
                    for (int j = 0; j < argResul.length; j++) {
                        if(argResul[i][j]==arregloAux[i][j])
                            respAux=true;
                        else{
                            respAux=false;
                            break;
                        }
                    } 
                }
            }
        }
        return respAux;
    }

    /*
     * Solo para funciones que lo requieran.
     * (Correción de errores de suma lógica)
     */
    private void controlMat(int [][]arg){//parametro arreglo 
        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg.length; j++) {
                if(arg[i][j]>1)
                    arg[i][j]=1;
            }
        }
    }

    /*
     * Función multiplicación binaria, solo para funcion 'transitiva'.
     */
    private void multplicacionBinaria(int [][]a,int [][]b,int [][]c){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    c[i][j]+=a[i][k]*a[k][j];
                }
            }
        }
        controlMat(c);
    }
}
