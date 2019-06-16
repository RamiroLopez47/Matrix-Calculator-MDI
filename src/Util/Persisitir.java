/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author francomorales
 */
public class Persisitir implements Serializable{
    /**
     * Método que guarda objetos del tipo 'Datos' con la extención'.mc' mediante
     * la clase JFileChooser.
     *
     * @param dato : Datos
     */
    public static void guardar(Datos dato) {
        String path = obtenerRutaO();
        try {
            ObjectOutputStream guardarDato = new ObjectOutputStream(new FileOutputStream(path + ".mc"));
            guardarDato.writeObject(dato);
            guardarDato.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /**
     * Función devuelve un objeto del tipo 'Datos' mediante la clase
     * JFileChooser.
     *
     * @return Dato : Datos
     */
    public static Datos abrir() {
        System.out.println("Al inicio de abrir");
        String path = obtenerRutaI();
        Datos datoAux = null;
        try {
            System.out.println("Antes de abrir");
            ObjectInputStream abrirDato = new ObjectInputStream(new FileInputStream(path));
            datoAux = (Datos) abrirDato.readObject();
            System.out.println(datoAux.getESTADO());
            abrirDato.close();
            System.out.println("despues de abrir");
        } catch (IOException e) {
            System.out.println("Hola excepcion 1");
        } catch (ClassNotFoundException e) {
            System.out.println("Hola excepcion 2");
        }
        System.out.println("despues de abrir 2");
        return datoAux;
    }

    /**
     * Función auxiliar que devuelve la ruta del archivo seleccionado para
     * guardarlo.
     *
     * @return
     */
    private static String obtenerRutaO() {//Obtener ruta para guardar un objeto
        String aux = null;
        try {
            JFileChooser seleccion = new JFileChooser();
            seleccion.setFileSelectionMode(JFileChooser.FILES_ONLY);
            seleccion.setFileFilter(new FileNameExtensionFilter("Archivo de Matrix Calculator", "MC"));
            int opcion = seleccion.showSaveDialog(null);
            if (opcion == JFileChooser.APPROVE_OPTION) {
                aux = seleccion.getSelectedFile().getAbsolutePath();
            } else {
                if (opcion == JFileChooser.CANCEL_OPTION) {
                    System.out.println("Operación Cancelada");
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return aux;
    }

    /**
     * Función auxiliar que devuelve la ruta del archivo seleccionado para
     * abrirlo.
     *
     * @return
     */
    private static String obtenerRutaI() {//obtener ruta para abrir un objeto
        String aux = null;
        try {
            JFileChooser seleccion = new JFileChooser();
            seleccion.setFileSelectionMode(JFileChooser.FILES_ONLY);
            seleccion.setFileFilter(new FileNameExtensionFilter("Archivo de Matrix Calculator", "MC"));
            int opcion = seleccion.showOpenDialog(null);
            if (opcion == JFileChooser.APPROVE_OPTION) {
                aux = seleccion.getSelectedFile().getAbsolutePath();
            } else {
                if (opcion == JFileChooser.CANCEL_OPTION) {
                    System.out.println("Operación Cancelada");
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return aux;
    }
}
