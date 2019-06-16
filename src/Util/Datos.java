/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.Serializable;

/**
 *
 * @author francomorales
 */
public class Datos implements Serializable{
    //Atributos
    //Indica el ESTADO de la VentanaPrincipal para que esta sea modificada
    private final int ESTADO; 
    private float[][] matrizUnoFloat;
    private float[][] matrizDosFloat;
    private int[][] matrizUnoInt;
    private int[][] matrizDosInt;
    
    //Constructores
    public Datos(int estado, float[][] matriz) {
        this.ESTADO = estado;
        this.matrizUnoFloat = matriz;
    }
    public Datos(int estado, float[][] matriz, float[][] matrizDos) {
        this.ESTADO = estado;
        this.matrizUnoFloat = matriz;
        this.matrizDosFloat = matrizDos;
    }
    public Datos(int estado, int[][] matriz) {
        this.ESTADO = estado;
        this.matrizUnoInt = matriz;
    }
    public Datos(int estado, int[][] matriz, int[][] matrizDos) {
        this.ESTADO = estado;
        this.matrizUnoInt = matriz;
        this.matrizDosInt = matriz;
    }
    
    //Getters
    public int getESTADO() {
        return ESTADO;
    }
    public float[][] getMatrizUnoFloat() {
        return matrizUnoFloat;
    }
    public float[][] getMatrizDosFloat() {
        return matrizDosFloat;
    }
    public int[][] getMatrizUnoInt() {
        return matrizUnoInt;
    }
    public int[][] getMatrizDosInt() {
        return matrizDosInt;
    }
}
