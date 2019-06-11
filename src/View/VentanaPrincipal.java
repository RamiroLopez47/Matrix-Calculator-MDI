/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author CATTANI, Marcelo Omar
 * https://github.com/marcelocattani
 * @version 2
 * 
 */
public class VentanaPrincipal extends JFrame {
    private JMenuBar JMBmenuBar;//Menu bar
    private JMenu JMarchivo, JMmatrizDecimal, JMmatriz_Binaria, JMAyuda;
    public JMenuItem JINuevo, JIAbrir, JISalir, JIAcercaDe, JIAyuda;//Menu Logo Items (Opcional)   
    public JMenuItem JMI_Decimal_Op, JMI_Decimal_Ana;//matrizDecimalOperacion, matrizDecimalAnalisis    
    public JMenuItem JMI_Binaria_Op, JMI_Binaria_Ana;//matrizBinariaOperacion, matrizBinariaAnalisis

    public JPanel panelPrincipal;

    //Botones de Tamaño
    public JButton btn_agrandarTabla1, btn_achicarTabla1, btn_ejecutar;
    public JButton btn_obtener, btn_limpiar;

    public Tabla tabla1;
    public Tabla tabla2;

    //Estado actual de la ventana;
    public static final int ANALISIS_DECIMAL = 0, ANALISIS_BINARIO = 1, OPERACION_DECIMAL = 2, OPERACION_BINARIA = 3;
    public static int estado = ANALISIS_DECIMAL;

    //Indicador de Estado Actual
    public JLabel indicadoDeEstado;

    public VentanaPrincipal() {
        super("MATRIX CALCULATOR");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Abrir ventana maximizada
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Finalizar Ejecucion al cerrarla

        //setLayout(null);        
        agregarPanel();
        crearBarraDeMenu();
        colocarIndicador();
        colocarBotones();
        colocarTablas();

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
        JINuevo = new JMenuItem("Nuevo");
        JIAbrir = new JMenuItem("Abrir...");
        JISalir = new JMenuItem("Salir");
        JMI_Decimal_Op = new JMenuItem("Operaciones");
        JMI_Decimal_Ana = new JMenuItem("Análisis");
        JMI_Binaria_Op = new JMenuItem("Operaciones");
        JMI_Binaria_Ana = new JMenuItem("Análisis");
        JIAcercaDe = new JMenuItem("Acerca de...");
        JIAyuda = new JMenuItem("Ayuda");

        //Agrega cada elemtno a 'ARCHIVO'
        JMarchivo.add(JINuevo);
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
        JINuevo.setActionCommand("nuevo");
        JIAbrir.setActionCommand("abrir");
        JISalir.setActionCommand("salir");
        JMI_Decimal_Op.setActionCommand("operacion_decimal");
        JMI_Decimal_Ana.setActionCommand("analisis_decimal");
        JMI_Binaria_Op.setActionCommand("operacion_binaria");
        JMI_Binaria_Ana.setActionCommand("analisis_binario");
        JIAcercaDe.setActionCommand("acerca");
        JIAyuda.setActionCommand("ayuda");
    }

    /**
     * Coloca cada uno de los botones de la Ventana
     */
    private void colocarBotones() {
        Dimension tamañoEstandar = new Dimension(100, 45);

        btn_achicarTabla1 = new JButton("-"); //CAMBIAR TEXTO POR ICONOS
        btn_agrandarTabla1 = new JButton("+");
        btn_ejecutar = new JButton("Aleatorio");
        btn_obtener = new JButton("Obtener");
        btn_limpiar = new JButton("Limpiar");

        btn_achicarTabla1.setSize(45, 45);
        btn_agrandarTabla1.setSize(45, 45);
        btn_ejecutar.setSize(tamañoEstandar);
        btn_obtener.setSize(tamañoEstandar);
        btn_limpiar.setSize(tamañoEstandar);

        btn_achicarTabla1.setLocation(50, 30);
        btn_agrandarTabla1.setLocation(100, 30);
        btn_ejecutar.setLocation(165, 30);
        btn_obtener.setLocation(280, 30);
        btn_limpiar.setLocation(400, 30);

        panelPrincipal.add(btn_achicarTabla1);
        panelPrincipal.add(btn_agrandarTabla1);
        panelPrincipal.add(btn_ejecutar);
        panelPrincipal.add(btn_obtener);
        panelPrincipal.add(btn_limpiar);
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
        indicadoDeEstado.setLocation(550, 40);
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
                this.indicadoDeEstado.setText("OPERACIÓN BINARIA");
                break;
            case OPERACION_DECIMAL:
                estado = OPERACION_DECIMAL;
                this.tabla2.setVisible(true);
                this.indicadoDeEstado.setText("OPERACIÓN DECIMAL");
                break;
            case ANALISIS_BINARIO:
                estado = ANALISIS_BINARIO;
                this.tabla2.setVisible(false);
                this.indicadoDeEstado.setText("ANÁLISIS BINARIO");
                break;
            case ANALISIS_DECIMAL:
                estado = ANALISIS_DECIMAL;
                this.tabla2.setVisible(false);
                this.indicadoDeEstado.setText("ANÁLISIS DECIMAL");
                break;
        }
    }

    /**
     * Crea dos tablas en la ventana y las coloca
     */
    private void colocarTablas() {
        tabla1 = new Tabla(new Point(50, 100));
        tabla2 = new Tabla(new Point(50, 330));

        panelPrincipal.add(tabla1);
        panelPrincipal.add(tabla2);

    }

}