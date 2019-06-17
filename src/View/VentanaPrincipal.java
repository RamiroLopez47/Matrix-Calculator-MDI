/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author CATTANI, Marcelo Omar https://github.com/marcelocattani
 * @version 2
 *
 */
public class VentanaPrincipal extends JFrame {

    private JMenuBar JMBmenuBar;//Menu bar
    private JMenu JMarchivo, JMmatrizDecimal, JMmatriz_Binaria, JMAyuda;
    public JMenuItem JIGuardar, JIAbrir, JISalir, JIAcercaDe, JIAyuda, JILlenarAleatorio;//Menu Logo Items (Opcional)   
    public JMenuItem JMI_Decimal_Op, JMI_Decimal_Ana;//matrizDecimalOperacion, matrizDecimalAnalisis    
    public JMenuItem JMI_Binaria_Op, JMI_Binaria_Ana;//matrizBinariaOperacion, matrizBinariaAnalisis

    public JPanel panelPrincipal;

    //Botones de Tamaño
    public Boton btn_agrandarTabla1, btn_achicarTabla1, btn_ejecutar;
    public Boton btn_obtener, btn_limpiar;

    public Tabla tabla1;
    public Tabla tabla2;
    public Tabla tablaResultado;

    //Estado actual de la ventana;
    public static final int ANALISIS_DECIMAL = 0, ANALISIS_BINARIO = 1, OPERACION_DECIMAL = 2, OPERACION_BINARIA = 3;
    public static int estado = ANALISIS_DECIMAL;

    //Indicador de Estado Actual
    public JLabel indicadoDeEstado, JLresultado;
    public Etiqueta limpiarTabla1, limpiarTabla2;
    
    //MAPA DE BOTONES
    public HashMap<String, Boton> listaBotones = new HashMap<>();
    
    //Estado de los visualizadores de resultado
    public final int NINGUNO = 0, LABEL = 1, TABLA = 2;

    public VentanaPrincipal() {
        super("MATRIX CALCULATOR");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Abrir ventana maximizada
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Finalizar Ejecucion al cerrarla

        //setLayout(null);        
        agregarPanel();
        crearBarraDeMenu();
        colocarIndicador();        
        generarBotones();
        colocarTablas();
        colocarJLabel();

        this.cambiarEstado(this.ANALISIS_DECIMAL);

    }

    /**
     * Crea la barra de menus superior Izquierda
     */
    private void crearBarraDeMenu() {
        JMBmenuBar = new JMenuBar(); //Instancia la barra de menu
        this.setJMenuBar(JMBmenuBar);
        agregarJMenus();
    }

    /**
     * Agrega cada elemtno JMENU al Menu bar superior izquierdo
     */
    private void agregarJMenus() {
        //Crear cada elemento del menu
        JMarchivo = new JMenu("Archivo");
        JMmatrizDecimal = new JMenu("Matriz Decimal");
        JMmatriz_Binaria = new JMenu("Matriz Binaria");
        JMAyuda = new JMenu("Ayuda");

        //Agregar cada elemento al MenuBar
        JMBmenuBar.add(JMarchivo);
        JMBmenuBar.add(JMmatriz_Binaria);
        JMBmenuBar.add(JMmatrizDecimal);
        JMBmenuBar.add(JMAyuda);

        agregarMenusItems();
        agregarActionCommand();
    }

    /**
     * Agrega cada Item a los JMENU'S
     */
    private void agregarMenusItems() {
        //CREAR TODOS LOS ITEMS
        JIGuardar = new JMenuItem("Guardar");
        JIAbrir = new JMenuItem("Abrir");
        JISalir = new JMenuItem("Salir");
        JMI_Decimal_Op = new JMenuItem("Operaciones");
        JMI_Decimal_Ana = new JMenuItem("Análisis");
        JMI_Binaria_Op = new JMenuItem("Operaciones");
        JMI_Binaria_Ana = new JMenuItem("Análisis");
        JIAcercaDe = new JMenuItem("Acerca de...");
        JIAyuda = new JMenuItem("Ayuda");
        JILlenarAleatorio = new JMenuItem("Llenar Aleatorio");

        //Agrega cada elemtno a 'ARCHIVO'
        JMarchivo.add(JIGuardar);
        JMarchivo.add(JIAbrir);
        JMarchivo.addSeparator();
        JMarchivo.add(JISalir);
        //Agrega cada elemento a 'Matriz Decimal'
        JMmatrizDecimal.add(JMI_Decimal_Op);
        JMmatrizDecimal.add(JMI_Decimal_Ana);
        //Agrega Cada Elemtno a 'Matriz Binaria'
        JMmatriz_Binaria.add(JMI_Binaria_Op);
        JMmatriz_Binaria.add(JMI_Binaria_Ana);
        //Agrega Cada elemtno a 'Ayuda'
        JMAyuda.add(JIAyuda);
        JMAyuda.add(JIAcercaDe);
        JMAyuda.add(JILlenarAleatorio);
    }

    /**
     * Agrega un panel a la ventana
     */
    private void agregarPanel() {
        panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.darkGray);
        panelPrincipal.setLayout(null);
        this.getContentPane().add(panelPrincipal);
    }

    /**
     * Agrega las referencias de ActionCommand a los JMenuItems
     */
    private void agregarActionCommand() {
        JIGuardar.setActionCommand("guardar");
        JIAbrir.setActionCommand("abrir");
        JISalir.setActionCommand("salir");
        JMI_Decimal_Op.setActionCommand("operacion_decimal");
        JMI_Decimal_Ana.setActionCommand("analisis_decimal");
        JMI_Binaria_Op.setActionCommand("operacion_binaria");
        JMI_Binaria_Ana.setActionCommand("analisis_binario");
        JIAcercaDe.setActionCommand("acerca");
        JIAyuda.setActionCommand("ayuda");
        JILlenarAleatorio.setActionCommand("llenarAleatorio");
    }

    /**
     * Coloca un indicador superior derecho que lleva el nombre del estado
     * actual de la ventana
     */
    private void colocarIndicador() {
        indicadoDeEstado = new JLabel();
        indicadoDeEstado.setFont(new Font("Arial", Font.BOLD, 30));
        indicadoDeEstado.setForeground(Color.red);
        indicadoDeEstado.setSize(350, 30);
        indicadoDeEstado.setLocation(800, 40);
        panelPrincipal.add(indicadoDeEstado);
    }

    /**
     * modifica el estado de la ventana
     *
     * @param nuevoEstado: Utilice valores Estaticos de 'Ventana Principal'
     */
    public void cambiarEstado(int nuevoEstado) {
        switch (nuevoEstado) {
            case OPERACION_BINARIA:
                estado = OPERACION_BINARIA;
                this.tabla2.setVisible(true);
                this.limpiarTabla2.setVisible(true);
                this.indicadoDeEstado.setText("OPERACIÓN BINARIA");
                break;
            case OPERACION_DECIMAL:
                estado = OPERACION_DECIMAL;
                this.tabla2.setVisible(true);
                this.limpiarTabla2.setVisible(true);
                this.indicadoDeEstado.setText("OPERACIÓN DECIMAL");
                break;
            case ANALISIS_BINARIO:
                estado = ANALISIS_BINARIO;
                this.tabla2.setVisible(false);
                this.limpiarTabla2.setVisible(false);
                this.indicadoDeEstado.setText("ANÁLISIS BINARIO");
                break;
            case ANALISIS_DECIMAL:
                estado = ANALISIS_DECIMAL;
                this.tabla2.setVisible(false);
                this.limpiarTabla2.setVisible(false);
                this.indicadoDeEstado.setText("ANÁLISIS DECIMAL");
                break;
        }
        evaluarVisibilidadesBotones();
    }

    /**
     * Crea dos tablas en la ventana y las coloca
     */
    private void colocarTablas() {
        tabla1 = new Tabla(new Point(50, 100));
        tabla2 = new Tabla(new Point(50, 330));
        tablaResultado = new Tabla  (new Point(700, 100));
        
        tabla1.addKeyListener(new ValidarCaracter());
        tabla2.addKeyListener(new ValidarCaracter());

        panelPrincipal.add(tabla1);
        panelPrincipal.add(tabla2);
        panelPrincipal.add(tablaResultado);
        
        tablaResultado.setVisible(false);
        


    }

    private void generarBotones() {
        int desplazamientoX = 50;
        
        listaBotones.put("determinante", new Boton("Determinante", Boton.ESTANDAR, ANALISIS_DECIMAL));
        listaBotones.put("inversa", new Boton("Inversa", Boton.ESTANDAR, ANALISIS_DECIMAL));
        listaBotones.put("traspuesta_decimal", new Boton("Traspuesta", Boton.ESTANDAR, ANALISIS_DECIMAL));
        listaBotones.put("rango", new Boton("Rango", Boton.ESTANDAR, ANALISIS_DECIMAL));
        listaBotones.put("multiplicaf", new Boton("Multiplicar", Boton.ESTANDAR, OPERACION_DECIMAL));
        listaBotones.put("multiplicam", new Boton("Multiplicar", Boton.ESTANDAR, OPERACION_DECIMAL));
        listaBotones.put("elevar", new Boton("Elevar", Boton.ESTANDAR, OPERACION_DECIMAL));
        listaBotones.put("sumar", new Boton("Sumar", Boton.ESTANDAR, OPERACION_DECIMAL));
        listaBotones.put("restar", new Boton("Restar", Boton.ESTANDAR, OPERACION_DECIMAL));
        listaBotones.put("interseccion", new Boton("Determinante", Boton.ESTANDAR, OPERACION_BINARIA));
        listaBotones.put("diferencia", new Boton("Diferencia", Boton.ESTANDAR, OPERACION_BINARIA));
        listaBotones.put("complemento", new Boton("Complemento", Boton.ESTANDAR, OPERACION_BINARIA));
        listaBotones.put("traspuesta_binaria", new Boton("Traspuesta", Boton.ESTANDAR, OPERACION_BINARIA));
        listaBotones.put("union", new Boton("Union", Boton.ESTANDAR, OPERACION_BINARIA));
        listaBotones.put("composicion", new Boton("Composicion", Boton.ESTANDAR, OPERACION_BINARIA));
        listaBotones.put("analizar", new Boton("Analizar", Boton.ESTANDAR, ANALISIS_BINARIO));

        for (Map.Entry<String, Boton> b : listaBotones.entrySet()) {
            panelPrincipal.add(b.getValue());
        }

        //GRRUPO 1
        listaBotones.get("determinante").setLocation(0 + desplazamientoX, 30);
        listaBotones.get("inversa").setLocation(120 + desplazamientoX, 30);
        listaBotones.get("traspuesta_decimal").setLocation(240 + desplazamientoX, 30);
        listaBotones.get("rango").setLocation(360 + desplazamientoX, 30);

        //GRUPO 2
        listaBotones.get("multiplicaf").setLocation(0 + desplazamientoX, 30);
        listaBotones.get("multiplicam").setLocation(120 + desplazamientoX, 30);
        listaBotones.get("elevar").setLocation(240 + desplazamientoX, 30);
        listaBotones.get("sumar").setLocation(360 + desplazamientoX, 30);
        listaBotones.get("restar").setLocation(480 + desplazamientoX, 30);

        //GRUPO 3
        listaBotones.get("interseccion").setLocation(0 + desplazamientoX, 30);
        listaBotones.get("diferencia").setLocation(120 + desplazamientoX, 30);
        listaBotones.get("complemento").setLocation(240 + desplazamientoX, 30);
        listaBotones.get("traspuesta_binaria").setLocation(360 + desplazamientoX, 30);
        listaBotones.get("union").setLocation(480 + desplazamientoX, 30);
        listaBotones.get("composicion").setLocation(600 + desplazamientoX, 30);

        //GRUPO 4 
        listaBotones.get("analizar").setLocation(50 + desplazamientoX, 30);
        evaluarVisibilidadesBotones();

    }

    private void evaluarVisibilidadesBotones() {
        for (Map.Entry<String, Boton> b : listaBotones.entrySet()) {
            if (b.getValue().getGrupo() != VentanaPrincipal.estado) {
                b.getValue().setVisible(false);
            } else {
                b.getValue().setVisible(true);
            }
        }
    }

    private void colocarJLabel() {
        JLresultado = new JLabel("", SwingConstants.CENTER);
        JLresultado.setForeground(Color.WHITE);
        JLresultado.setFont(new Font("Arial", Font.BOLD, 15));
        JLresultado.setSize(600, 200);
        JLresultado.setLocation(700, 100);
        JLresultado.setOpaque(true);
        JLresultado.setAlignmentX(JLabel.LEFT);
        JLresultado.setBackground(Color.BLACK);
        
        JLresultado.setVisible(false);
        panelPrincipal.add(JLresultado);
        
        limpiarTabla1 = new Etiqueta(tabla1, 551,73);
        limpiarTabla2 = new Etiqueta(tabla2,551,300);
        
        panelPrincipal.add(limpiarTabla1);
        panelPrincipal.add(limpiarTabla2);
    }

    public void resetearVisualizadores(int tipo){
        switch (tipo) {
            case NINGUNO:
                JLresultado.setVisible(false);
                tablaResultado.setVisible(false);
                break;
            case LABEL:
                JLresultado.setVisible(true);
                tablaResultado.setVisible(false);
                break;
            case TABLA:  
                JLresultado.setVisible(false);
                tablaResultado.setVisible(true);
                default: System.err.println("argumento invalido en VentanaPrincipal-> resetearVisualizadores");
        }
    }
}
