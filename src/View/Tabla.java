/*
 * 
 * 
 */
package View;

import java.awt.Point;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * Esta clase contiene todos los metodos necesarios para obtener datos de las
 * tablas y modificar propiedades y valores de ser necesario
 *
 * @author CATTANI, Marcelo Omar.
 * Todos los codigos en esta clase son de mi autoria
 * https://github.com/marcelocattani
 * @version 2
 */
public class Tabla extends JTable {

    public DefaultTableModel modelo;
    private TableColumnModel modeloColumna;

    /**
     * Construye una tabla con el tamaño especificado en una posicion
     *
     * @param tamaño: cantidad de filas y columnas (cuadrada)
     * @param localizacion: punto de localizacion
     */
    public Tabla(int tamaño, Point localizacion) {
        super(tamaño, tamaño);
        modelo = (DefaultTableModel) this.getModel();
        cambiarDimensiones(tamaño);
        this.setLocation(localizacion);
    }

    /**
     * Contruye una tabla de 3x3 en un punto especificado
     *
     * @param localizacion
     */
    public Tabla(Point localizacion) {
        this(3, localizacion);
    }

    /**
     * Muestra la matriz por consola, dedicada a debug
     */
    public void mostrarMatriz() {
        String dato, valorPorDefecto;
        float aux1Float;
        
        if (VentanaPrincipal.estado == VentanaPrincipal.OPERACION_DECIMAL || VentanaPrincipal.estado == VentanaPrincipal.ANALISIS_DECIMAL) {
            valorPorDefecto = "0.0";
        } else {
            valorPorDefecto = "0";
        }
        try {
            for (int i = 0; i < this.getAlto(); i++) {

                for (int j = 0; j < this.getAncho(); j++) {
                    
                    dato = (String) modelo.getValueAt(i, j);
                    if (dato == null || dato.isEmpty()) { //Si la celda esta vacia el valor se considera 0
                        aux1Float = 0.0f;
                        modelo.setValueAt(valorPorDefecto, i, j);
                    } else {
                        aux1Float = Float.parseFloat(dato);
                    }
                    
                    System.out.print(aux1Float + "\t");
                }
                System.out.print("|\n");
            }
            for (int i = 0; i < this.getAncho(); i++) {
                System.out.print("--------");
            }
            System.out.println("");
        } catch (Exception e) {
            System.out.println("ERROR DE TIPO" + e);
        }

    }

    /**
     * Retorna todos los valores de la tabla en un arreglo de float
     *
     * @return Matriz flotante
     */
    public float[][] getMatrizDecimal() {
        int ultimaColumna, ultimaFila;
        float[][] arreglo = new float[modelo.getColumnCount()][modelo.getRowCount()];
        String dato;
        float aux1Float;

        try {
            for (int i = 0; i < modelo.getColumnCount(); i++) {

                for (int j = 0; j < modelo.getRowCount(); j++) {
                    dato = (String) modelo.getValueAt(i, j);
                    if (dato == null) { //Si la celda esta vacia el valor se considera 0
                        aux1Float = 0.0f;
                    } else {
                        aux1Float = Float.parseFloat(dato);
                    }
                    arreglo[i][j] = aux1Float;
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR DE TIPO" + e);
        }
        return arreglo;
    }

    /**
     * Retorna todos los valores de la tabla en formato de enteros
     *
     * @return Matriz entera
     */
    public int[][] getMatrizBinaria() {
        int[][] arreglo = new int[this.getAlto()][this.getAncho()];
        String dato;
        int auxInt;

        try {
            for (int i = 0; i < this.getAlto(); i++) {

                for (int j = 0; j < this.getAncho(); j++) {
                    dato = (String) modelo.getValueAt(i, j);
                    if (dato == null) {
                        auxInt = 0;
                    } else {
                        auxInt = Integer.parseInt(dato);
                    }
                    arreglo[i][j] = auxInt;
                }
            }

        } catch (Exception e) {
            System.err.println("ERROR DE TIPO" + e);
        }
        return arreglo;
    }

    /**
     * Especifica un nuevo tamaño para la matriz
     *
     * @param nuevoTamaño cantidad de filas y columnas (cuadrada)
     */
    private void cambiarDimensiones(int nuevoTamaño) {
        modelo.setColumnCount(nuevoTamaño);
        modelo.setRowCount(nuevoTamaño);

        modeloColumna = this.getColumnModel();
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            modeloColumna.getColumn(i).setPreferredWidth(25);
        }

        this.setRowHeight(25);
        this.setSize(75 * nuevoTamaño, 25 * nuevoTamaño);

    }

    /**
     * Disminuye en 1 la cantidad de filas y columnas, nunca menor a 3
     */
    public void disminuirTamaño() {
        if (modelo.getColumnCount() > 2) {
            cambiarDimensiones(modelo.getRowCount() - 1);
        } else {
            JOptionPane.showMessageDialog(null, "Ha alcanzado el tamaño mínimo");
        }
    }

    /**
     * Aumenta en 1 la cantidad de filas y columnas, nunca mayor a 8
     */
    public void aumentarTamaño() {
        if (modelo.getColumnCount() < 8) {
            cambiarDimensiones(modelo.getColumnCount() + 1);
        } else {
            JOptionPane.showMessageDialog(null, "Ha alcanzado el tamaño máximo");
        }
    }

    /**
     * Llena la tabla de datos numericos aleatorios,
     *
     */
    public void llenarAleatorio() {
        //Formateo de float
        DecimalFormat df = new DecimalFormat("##.##");
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        df.setRoundingMode(RoundingMode.DOWN);
        df.setDecimalFormatSymbols(simbolos);
        Random numero = new Random();

        if (VentanaPrincipal.estado == VentanaPrincipal.ANALISIS_BINARIO || VentanaPrincipal.estado == VentanaPrincipal.OPERACION_BINARIA) {
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    //ventana.tabla.setValueAt(numero.nextInt(limite), i, j); 
                    modelo.setValueAt(df.format((float) numero.nextInt(2)), i, j);
                }
            }
        } else if (VentanaPrincipal.estado == VentanaPrincipal.ANALISIS_DECIMAL || VentanaPrincipal.estado == VentanaPrincipal.OPERACION_DECIMAL) {
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    //ventana.tabla.setValueAt(numero.nextInt(limite), i, j); 
                    modelo.setValueAt(df.format(numero.nextFloat() * 100), i, j);
                }
            }
        } else {
            System.err.println("View.Tabla.llenarAleatorio -> Parametro mal especificado");
        }

    }
    /**
     * Borra los datos de la tabla remplazando el valor de cada celda por null
     */
    public void limpiarTabla() {
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            for (int j = 0; j < modelo.getRowCount(); j++) {
                modelo.setValueAt(null, i, j);
            }
        }
    }
/**
 * evalua si el modelo se encuentr totalmente vacio
 * @return true si el modelo no contiene datos
 */
    private boolean isEmpty() {
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            for (int j = 0; j < modelo.getRowCount(); j++) {
                if (modelo.getValueAt(i, j) != null) {
                    return false;
                }
            }
        }
        return true;
    }
/**
 * evalua si la tabla contiene al menos un valor
 * @return true si se encuentra almenos un valor
 */
    private boolean isFull() {
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            for (int j = 0; j < modelo.getRowCount(); j++) {
                if (modelo.getValueAt(i, j) == null) {
                    return false;
                }
            }
        }
        return true;
    }
/**
 * obtiene la posicion de la ultima columna donde se encuentra un valor hacia la 
 * derecha
 * @return int ancho columna 
 */
    private int getAncho() {
        int anchoMaximo=0;
        String dato;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            for (int j = 0; j < modelo.getColumnCount(); j++) { 
                dato = (String) modelo.getValueAt(i, j);
                if (dato != null && !dato.isEmpty()) {
                    if (anchoMaximo < j) {
                       anchoMaximo = j;
                    }
                }
            }
        }
        return anchoMaximo+1;
    }
/**
 * obtiene la posicion de la ultima fila donde se encuentra un valor hacia abajo
 * @return int alto columna 
 */
    private int getAlto() {
        int altoMaximo=0;
        String dato;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            for (int j = 0; j < modelo.getColumnCount(); j++) { 
                dato = (String) modelo.getValueAt(i, j);
                if (dato != null && !dato.isEmpty()) {
                    if (altoMaximo < i) {
                       altoMaximo = i;
                    }
                }
            }
        }
        return altoMaximo+1;
    }

}
