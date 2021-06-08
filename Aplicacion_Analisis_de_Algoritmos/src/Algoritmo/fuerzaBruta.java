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
public class fuerzaBruta {   
    public int fBruta(String texto, int m, String patron, int n){
      if(n==0||m==0) return 0;
    char[] arrayPatron = patron.toCharArray();
    char[] arrayTexto = texto.toCharArray();  
    int coincidencias=0;
    int i=0;
    int j=0;
    try{
    while (i < m){     
     if (arrayTexto[i] == arrayPatron[0]) {
         j=1;
     i++;
         while(j<n && arrayTexto[i]==arrayPatron[j]){j++;i++;}
         if(j==n){
             coincidencias++;
             i = (i-j)+1;
         }else{
         i = (i-j)+1;
         }
     }else{
     i++;
     }
    }
    }catch(Exception e){
           return coincidencias;
    }  
   return coincidencias;
    }
}
