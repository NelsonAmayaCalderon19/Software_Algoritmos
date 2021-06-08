/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmo;

/**
 *
 * @author NELSON
 */
public class kmp {
    public int[] calcularLps(String patron){
        int lps[] = new int[patron.length()];
        char[] arrayPatron = patron.toCharArray();
        lps[0]=0;
        int j=0;
        int i=1;      
        while(i<patron.length()){
            if(arrayPatron[j] == arrayPatron[i]){
                lps[i] = j+1;
                j++;
                i++;
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }           
        }
        return lps;
    }  
    public int kmp(String texto, String patron){
        int[] lps = calcularLps(patron); 
        char[] arrayPatron = patron.toCharArray();
    char[] arrayTexto = texto.toCharArray();
        int i=0;
        int j=0;
        int coincidencias =0;
        while(i<texto.length()){
            if(arrayTexto[i] == arrayPatron[j]){
                i++;
                j++;
            }
            if(j==patron.length()){
                coincidencias++;
                j = lps[j-1];
            }else if(i<texto.length() && arrayPatron[j]!=arrayTexto[i]){
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return coincidencias;
    }
}
