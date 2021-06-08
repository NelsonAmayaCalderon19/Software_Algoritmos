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
public class bmh {
    public int bmh(String texto, int m, String patron, int n){
         if(n==0||m==0) return 0;
    int maxChart=255;
    char[] arrayPatron = patron.toCharArray();
    char[] arrayTexto = texto.toCharArray();
    int [] alfabeto = new int[maxChart+1];
    for(int i=0; i<maxChart; i++){
    alfabeto[i]=n;
    }
    for(int i=0; i<n-1; i++){
        alfabeto[(int)arrayPatron[i]]=n-i-1;
    }
    int contCoincidencias=0;
      int i = 0;
    int j = 0;   
    while (j <= m - n) {  
        try{
        i = n - 1;
        while (i >= 0 && arrayPatron[i] == arrayTexto[i + j]) {
            i--;
        }
        if (i < 0) {
          contCoincidencias++;
          j++;
      } else {
          j = j + alfabeto[arrayTexto[j + n - 1]];
      }
  }catch(Exception e){
             j++;           
        }
    }  
    return contCoincidencias;
    }   
}
