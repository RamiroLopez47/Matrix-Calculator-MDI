/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AnalisisBinaria;
import Model.AnalisisDecimal;
import Model.CalculoBinario;
import Model.CalculoDecimal;
import Util.Datos;
import Util.Persistir;
import View.VentanaAcerca;
import View.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Util.Validations;

/**
 *
 * @author CATTANI, Marcelo Omar. Todos los codigos en esta clase son de mi
 * autoria https://github.com/marcelocattani
 * @version 2
 */
public class Controlador implements ActionListener {

    VentanaPrincipal ventana;
    VentanaAcerca acercaDe = new VentanaAcerca();

    //Instancias de objetos destinados al calculo
    AnalisisBinaria analisisBinario = new AnalisisBinaria();
    AnalisisDecimal analisiDecimal = new AnalisisDecimal();
    CalculoBinario calculoBinario = new CalculoBinario();
    CalculoDecimal calculoDecimal = new CalculoDecimal();

    //Instanciacion de Validaciones
    Validations validar = new Validations();

    //Datos a guardar o abir
    public static Datos dato;

    public Controlador(VentanaPrincipal ventana) {
        this.ventana = ventana;
        ventana.setBounds(0, 0, 200, 300);
        agregarOyentes();
        agregarOyentesBotones();
        analisis_decimal();
    }

    /**
     * Lanza la ventana haciendola visible para el usuario
     */
    public void lanzar() {
        ventana.setVisible(true);
    }

    /**
     * Escucha las acciones de cada JMenuItem y llama a los metodos
     * correspondientes
     *
     * @param e: evento ocurrido
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "guardar") {
            guardar();
        } else if (e.getActionCommand() == "abrir") {
            abrir();
        } else if (e.getActionCommand() == "salir") {
            System.exit(0);
        } else if (e.getActionCommand() == "operacion_decimal") {
            operacion_decimal();
        } else if (e.getActionCommand() == "analisis_decimal") {
            analisis_decimal();
        } else if (e.getActionCommand() == "operacion_binaria") {
            operacion_binaria();
        } else if (e.getActionCommand() == "analisis_binario") {
            analisis_binario();
        } else if (e.getActionCommand() == "acerca") {
            acerca();
        } else if (e.getActionCommand() == "ayuda") {
            ayuda();
        } else if (e.getActionCommand() == "llenarAleatorio") {
            ventana.tabla1.llenarAleatorio();
            ventana.tabla2.llenarAleatorio();
        }
    }

    /**
     * Agrega los actionListenes a cada JMenuItem
     */
    private void agregarOyentes() {
        ventana.JIAbrir.addActionListener(this);
        ventana.JIAcercaDe.addActionListener(this);
        ventana.JIAyuda.addActionListener(this);
        ventana.JIGuardar.addActionListener(this);
        ventana.JISalir.addActionListener(this);
        ventana.JMI_Binaria_Ana.addActionListener(this);
        ventana.JMI_Binaria_Op.addActionListener(this);
        ventana.JMI_Decimal_Ana.addActionListener(this);
        ventana.JMI_Decimal_Op.addActionListener(this);
        ventana.JILlenarAleatorio.addActionListener(this);
    }

    /**
     * Método que guarda objetos del tipo 'Datos'
     */
    public void guardar() {
        int estAux = VentanaPrincipal.estado;
        System.out.println("Controlador : Ventana Principal : Estado -> " + estAux);
        switch (estAux) {
            case 0:
                dato = new Datos(estAux, ventana.tabla1.getMatrizDecimal());
                Persistir.guardar(dato);
                System.out.println("Controlador : Guardar : Exito");
                break;
            case 1:
                dato = new Datos(estAux, ventana.tabla1.getMatrizBinaria());
                Persistir.guardar(dato);
                System.out.println("Controlador : Guardar : Exito");
                break;
            case 2:
                dato = new Datos(estAux, ventana.tabla1.getMatrizDecimal(), ventana.tabla2.getMatrizDecimal());
                Persistir.guardar(dato);
                System.out.println("Controlador : Guardar : Exito");
                break;
            case 3:
                dato = new Datos(estAux, ventana.tabla1.getMatrizBinaria(), ventana.tabla2.getMatrizBinaria());
                Persistir.guardar(dato);
                System.out.println("Controlador : Guardar : Exito");
                break;
            default:
                System.err.println("¡ Error !");
                System.out.println("Controlador : Guardar : Error");
        }
    }

    /**
     * Método que recupera objetos del tipo 'Datos' guardados previamente
     */
    public void abrir() {
        //se agrega un tryCatch por posible error
        try {
            dato = (Datos) Persistir.abrir();
            int estAux = dato.getESTADO();
            System.out.println("Controlador : Ventana Principal : Estado -> " + estAux);
            switch (estAux) {
                case 0:
                    ventana.cambiarEstado(estAux);
                    ventana.tabla1.llenar(dato.getMatrizUnoFloat());
                    System.out.println("Controlador : Abrir : Exito");
                    break;
                case 1:
                    ventana.cambiarEstado(estAux);
                    ventana.tabla1.llenar(dato.getMatrizUnoInt());
                    System.out.println("Controlador : Abrir : Exito");
                    break;
                case 2:
                    ventana.cambiarEstado(estAux);
                    ventana.tabla1.llenar(dato.getMatrizUnoFloat());
                    ventana.tabla2.llenar(dato.getMatrizDosFloat());
                    System.out.println("Controlador : Abrir : Exito");
                    break;
                case 3:
                    ventana.cambiarEstado(estAux);
                    ventana.tabla1.llenar(dato.getMatrizUnoInt());
                    ventana.tabla2.llenar(dato.getMatrizDosInt());
                    System.out.println("Controlador : Abrir : Exito");
                    break;
                default:
                    System.err.println("¡ Error !");
                    System.out.println("Controlador : Abrir : Error");
            }
        } catch (Exception e) {
            e.getMessage();
            System.err.println("¡ Error inesperado a la hora de abrir un archivo .mc");
        }
    }

    private void operacion_decimal() {
        ventana.cambiarEstado(VentanaPrincipal.OPERACION_DECIMAL);
    }

    private void analisis_decimal() {
        ventana.cambiarEstado(VentanaPrincipal.ANALISIS_DECIMAL);
    }

    private void operacion_binaria() {
        ventana.cambiarEstado(VentanaPrincipal.OPERACION_BINARIA);
    }

    private void analisis_binario() {
        ventana.cambiarEstado(VentanaPrincipal.ANALISIS_BINARIO);
    }

    private void acerca() {
        acercaDe.setVisible(true);
    }

    private void ayuda() {
    }

    private void agregarOyentesBotones() {
        //Analisis Decimal

        ActionListener determinante = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validar.esCuadrada(ventana.tabla1.getMatrizDecimal())) {
                    ventana.resetearVisualizadores(ventana.LABEL);
                    ventana.JLresultado.setText("El determinante es: " + String.valueOf(analisiDecimal.determinante(ventana.tabla1.getMatrizDecimal())));
                }
            }
        };
        ventana.listaBotones.get("determinante").addActionListener(determinante);

        ActionListener inversa = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validar.esCuadrada(ventana.tabla1.getMatrizDecimal())) {
                    ventana.resetearVisualizadores(ventana.TABLA);
                    ventana.tablaResultado.llenar(analisiDecimal.matrizIdentidad(ventana.tabla1.getMatrizDecimal()));
                }
            }
        };
        ventana.listaBotones.get("inversa").addActionListener(inversa);

        ActionListener transpuesta = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.resetearVisualizadores(ventana.TABLA); //No necesita validacion
                ventana.tablaResultado.llenar(analisiDecimal.transpuesta(ventana.tabla1.getMatrizDecimal()));
            }
        };
        ventana.listaBotones.get("traspuesta_decimal").addActionListener(transpuesta);

        ActionListener rangoMatriz = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validar.esCuadrada(ventana.tabla1.getMatrizDecimal())) {
                    ventana.resetearVisualizadores(ventana.LABEL);
                    ventana.JLresultado.setText("El rango es: " + String.valueOf(calculoDecimal.rangoMatriz(ventana.tabla1.getMatrizDecimal())));
                }
            }
        };
        ventana.listaBotones.get("rango").addActionListener(rangoMatriz);

        /**
         *---------------- 
         *Analisis Binaria
         *----------------
         */
        ActionListener antiSimetrica = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validar.esBinaria(ventana.tabla1.getMatrizBinaria())) {
                    if (validar.esCuadrada(ventana.tabla1.getMatrizBinaria())) {
                        ventana.resetearVisualizadores(ventana.LABEL);
                        ventana.JLresultado.setText("Es Anti-Simetrica");
                    }
                }
            }
        };
        ventana.listaBotones.get("analizar").addActionListener(antiSimetrica);

        ActionListener simetrica = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validar.esBinaria(ventana.tabla1.getMatrizBinaria())) {
                    if (validar.esCuadrada(ventana.tabla1.getMatrizBinaria())) {
                        ventana.resetearVisualizadores(ventana.LABEL);
                        ventana.JLresultado.setText("Es Simetrica");
                    }
                }
            }
        };
        ventana.listaBotones.get("analizar").addActionListener(simetrica);

        ActionListener reflexiva = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validar.esBinaria(ventana.tabla1.getMatrizBinaria())) {
                    if (validar.esCuadrada(ventana.tabla1.getMatrizBinaria())) {
                        ventana.resetearVisualizadores(ventana.LABEL);
                        ventana.JLresultado.setText("Es Reflexiva");
                    }
                }
            }
        };
        ventana.listaBotones.get("analizar").addActionListener(reflexiva);

        ActionListener total = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validar.esBinaria(ventana.tabla1.getMatrizBinaria())) {
                    if (validar.esCuadrada(ventana.tabla1.getMatrizBinaria())) {
                        ventana.resetearVisualizadores(ventana.LABEL);
                        ventana.JLresultado.setText("Es Total");
                    }
                }
            }
        };
        ventana.listaBotones.get("analizar").addActionListener(total);

        ActionListener transitiva = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validar.esBinaria(ventana.tabla1.getMatrizBinaria())) {
                    if (validar.esCuadrada(ventana.tabla1.getMatrizBinaria())) {
                        ventana.resetearVisualizadores(ventana.LABEL);
                        ventana.JLresultado.setText("Es Transitiva");
                    }
                }
            }
        };
        ventana.listaBotones.get("analizar").addActionListener(transitiva);
        //HICE PULL ANTES DE HACER PUSH Y YA NO INDICA LAS LINEAS QUE AGREGUE (aproximadamente desde la linea 230 hasta 315)@valeguizamon 
    }
}
