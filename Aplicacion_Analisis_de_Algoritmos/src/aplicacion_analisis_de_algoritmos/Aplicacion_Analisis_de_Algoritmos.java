
package aplicacion_analisis_de_algoritmos;

import Algoritmo.bmh;
import Algoritmo.bmhs;
import Algoritmo.fuerzaBruta;
import Algoritmo.kmp;

/**
 *
 * @author NELSON
 */
public class Aplicacion_Analisis_de_Algoritmos {
  
    public static void main(String[] args) {
        formulario_Leer_Archivo fla = new formulario_Leer_Archivo();
        bmhs bms = new bmhs();
        bmh bmh = new bmh();
        kmp kmp = new kmp();
        fuerzaBruta fb = new fuerzaBruta();
        Controlador control = new Controlador(fla,bms,bmh,kmp,fb);
    }
    
}
