/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion_analisis_de_algoritmos;

import Algoritmo.bmh;
import Algoritmo.bmhs;
import Algoritmo.fuerzaBruta;
import Algoritmo.kmp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author NELSON
 */
public class Controlador implements ActionListener {
    private formulario_Leer_Archivo fla=null;
    private bmhs bms = null;
    private bmh bmh = null;
    private kmp kmp = null;
    private fuerzaBruta fuerzaBruta = null;
    String texto="";
    String linea="";
    BigDecimal bg1, bg2, bg3,bg4,bg5;
    long inicio;
    long fin;
    public Controlador(formulario_Leer_Archivo fla, bmhs bms, bmh bmh, kmp kmp, fuerzaBruta fuerzaBruta){
        super();
        this.fla=fla;
        this.bms=bms;
        this.bmh=bmh;
        this.kmp=kmp;
        this.fuerzaBruta=fuerzaBruta;
        actionListener(this);
    }  
    private void actionListener(ActionListener controlador){
    fla.btnSelect.addActionListener(controlador);
    fla.btnBMHS.addActionListener(controlador);
    fla.btnBMH.addActionListener(controlador);
    fla.btnKMP.addActionListener(controlador);
    fla.btnF_Bruta.addActionListener(controlador);
    }   
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==fla.btnSelect){
               JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
        jfc.setFileFilter(filtro);
        jfc.showOpenDialog(null);        
        File archivo = jfc.getSelectedFile();        
        try{
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            fla.txtArchivo.setText(archivo.getName());
            while(((linea=br.readLine())!=null)){
                texto+=linea;
            }
        }catch(Exception ev){
        } 
            }if(e.getSource()==fla.btnBMHS){
                int coincidencias=0;
                String patron = fla.txtPatron.getText();
                inicio = System.nanoTime();
               coincidencias = bms.bms(texto, texto.length(), patron, patron.length());
               fin = System.nanoTime();
             bg1 = new BigDecimal(inicio);
bg2 = new BigDecimal(fin);
bg4 = new BigDecimal(fin-inicio);
bg5 = new BigDecimal(1000000);
bg3 = bg4.divide(bg5, 4, RoundingMode.CEILING);
               fla.txtRes.setText("ALGORITMO BOYER MOORE HORSPOOL SUNDAY\n"+"Texto: "+texto+"\nPatrón: "+patron+"\n\nCantidad de Coincidencias: "+String.valueOf(coincidencias)+"\n\nTiempo de Ejecución: "+bg3+" milisegundos");            
            }
            if(e.getSource()==fla.btnBMH){
                int coincidencias=0;              
                String patron = fla.txtPatron.getText();
                 inicio = System.nanoTime();
                coincidencias = bmh.bmh(texto, texto.length(), patron, patron.length());
                fin = System.nanoTime();
             bg1 = new BigDecimal(inicio);
bg2 = new BigDecimal(fin);
bg4 = new BigDecimal(fin-inicio);
bg5 = new BigDecimal(1000000);
bg3 = bg4.divide(bg5, 4, RoundingMode.CEILING);
                fla.txtRes.setText("ALGORITMO BOYER MOORE HORSPOOL\n"+"Texto: "+texto+"\nPatrón: "+patron+"\n\nCantidad de Coincidencias: "+String.valueOf(coincidencias)+"\n\nTiempo de Ejecución: "+bg3+" milisegundos");            
            }
            if(e.getSource()==fla.btnKMP){
                int coincidencias=0;
                  String patron = fla.txtPatron.getText();
                  inicio = System.nanoTime();
                  coincidencias = kmp.kmp(texto, patron);
                  fin = System.nanoTime();
                  bg1 = new BigDecimal(inicio);
bg2 = new BigDecimal(fin);
bg4 = new BigDecimal(fin-inicio);
bg5 = new BigDecimal(1000000);
bg3 = bg4.divide(bg5, 4, RoundingMode.CEILING);
                fla.txtRes.setText("ALGORITMO KNUTH MOORE PRATT\n"+"Texto: "+texto+"\nPatrón: "+patron+"\n\nCantidad de Coincidencias: "+String.valueOf(coincidencias)+"\n\nTiempo de Ejecución: "+bg3+" milisegundos");
            }if(e.getSource()==fla.btnF_Bruta){
               int coincidencias=0;
                  String patron = fla.txtPatron.getText();
                  inicio = System.nanoTime();
                  coincidencias = fuerzaBruta.fBruta(texto, texto.length(), patron, patron.length());
                  fin = System.nanoTime();
                  bg1 = new BigDecimal(inicio);
bg2 = new BigDecimal(fin);
bg4 = new BigDecimal(fin-inicio);
bg5 = new BigDecimal(1000000);
bg3 = bg4.divide(bg5, 4, RoundingMode.CEILING);
                fla.txtRes.setText("ALGORITMO DE FUERZA BRUTA\n"+"Texto: "+texto+"\nPatrón: "+patron+"\n\nCantidad de Coincidencias: "+String.valueOf(coincidencias)+"\n\nTiempo de Ejecución: "+bg3+" milisegundos");         
            }
        }catch(Exception ev){
        }
    }
    
}
