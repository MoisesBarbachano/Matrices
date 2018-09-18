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
public class Matriz {
    final int PRIMERINDICE = 0;
    final int SEGUNDOINDICE = 1;
    final int DIVISOR_MODULO_PAR = 2;
        
    public double[][] transponerMatrices(double[][] matriz)
    {
        int numColumnasMatriz = matriz.length;
        double[][] matrizTranspuesta = new double[matriz[PRIMERINDICE].length][numColumnasMatriz];   //put initialization code directly before the loop
        for (int columna = 0; columna < numColumnasMatriz; columna++) {      //Un loop con una sola funcion (Este loop solo recorre la matriz)
            int numFilasMatriz = matriz[columna].length;                        //Usar nombres significativos de variables para hacer loops más fáciles de leer
            for (int fila = 0; fila <numFilasMatriz; fila++) {
                matrizTranspuesta[fila][columna] = matriz[columna][fila];
            }
        }                                                                  
                                                                    
        
        return matrizTranspuesta;
    }
    
     public double[][] sumarMatrices(double[][] primeraMatriz, double[][] segundaMatriz){
        int numFilasPrimeraMatriz = primeraMatriz[PRIMERINDICE].length;
        int numColumPrimeraMatriz = primeraMatriz.length;
        double[][] matrizResultante = new double [numFilasPrimeraMatriz][numColumPrimeraMatriz];
        for (int fila = 0; fila < primeraMatriz[0].length; fila++) {                //Limitar el alcance de los indices de loop para si mismos
            for (int columna = 0; columna < primeraMatriz.length; columna++) {      //Declarar variables indices dentro de cada loop
                matrizResultante [fila][columna] = primeraMatriz [fila][columna] + segundaMatriz [fila][columna];
            }
        }
        return matrizResultante;
    }
     
     public double[][] multiplicarMatrices(double[][] primeraMatriz, double[][] segundaMatriz){
        double[][] matrizResultante = new double [primeraMatriz[0].length][segundaMatriz[0].length];
        int numFilasPrimeraMatriz = primeraMatriz[0].length;                                                        //Colocar la declaración de variables inmediatamente afuera de los loop
        for (int filaPrimeraMatriz = 0; filaPrimeraMatriz < numFilasPrimeraMatriz; filaPrimeraMatriz++) {           //Limitar el numero de niveles de loop a 3
            int numColumPrimeraMatriz = primeraMatriz.length;
            for (int columnaPrimeraMatriz = 0; columnaPrimeraMatriz < numColumPrimeraMatriz; columnaPrimeraMatriz++) {
                int numColumSegundaMatriz = segundaMatriz.length;
                for (int columnaSegundaMatriz = 0; columnaSegundaMatriz < numColumSegundaMatriz; columnaSegundaMatriz++) {
                    matrizResultante[filaPrimeraMatriz][columnaSegundaMatriz] += primeraMatriz[filaPrimeraMatriz][columnaPrimeraMatriz] * segundaMatriz[columnaPrimeraMatriz][columnaSegundaMatriz];
                }
            }
        }
        return matrizResultante;
    }
}
