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
public class bmhs {   
    public int bms(String texto, int m, String patron, int n){
    if(n==0||m==0) return 0;
    int maxChart=255;
    char[] arrayPatron = patron.toCharArray();
    char[] arrayTexto = texto.toCharArray();
    int [] alfabeto = new int[maxChart+1];
    for(int i=0; i<maxChart; i++){
    alfabeto[i]=n+1;
    }
    int c=n;
    for(int i=0; i<n; i++){
        alfabeto[(int)arrayPatron[i]]=c;
        c--;
    }
    int contCoincidencias=0;
    int i = n-1; 
    while(i<m){  
         try{
        if(arrayTexto[i]==arrayPatron[n-1]){
           int j=1;
            while(j<n && arrayTexto[i-j]==arrayPatron[(n-1)-j]){j++;}           
           if(j==n){
             contCoincidencias++;
             i++;
           }else{
            int tmp=alfabeto[(int)arrayTexto[i+1]];
            i+=tmp; 
           }
        }else{
            int tmp=alfabeto[(int)arrayTexto[i+1]];
           i+=tmp;
        }
        }catch(Exception e){            
           int tmp=alfabeto[(int)arrayTexto[i]];
           i+=tmp; 
        }
    }      
    return contCoincidencias;
    }
}
