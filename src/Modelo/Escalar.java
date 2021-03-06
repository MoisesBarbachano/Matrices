/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author sulak
 */
public class Escalar {
    final int PRIMERINDICE = 0;
    final int SEGUNDOINDICE = 1;
    final int DIVISOR_MODULO_PAR = 2;
    
    public double[][] multiplicarEscalar(double[][] matriz, double escalar){
        int numFilasMatriz = matriz[PRIMERINDICE].length;
        for (int fila = 0; fila < numFilasMatriz; fila++) {    //Limitar el numero de niveles de loop a 3
            int numColumMatriz = matriz.length;
            for (int columna = 0; columna < numColumMatriz; columna++) {
                matriz [fila][columna] = escalar * (matriz[fila][columna]);
            }
        }
        return matriz;
    }
}
