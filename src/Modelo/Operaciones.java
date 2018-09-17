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
public class Operaciones {
    public void transponer(){
        
        
        
        
    }
    
    public double[][] sumar(double[][] primeraMatriz, double[][] segundaMatriz){
       
        double terceraMatriz[][] = new double [primeraMatriz[0].length][primeraMatriz.length];
        for (int fila = 0; fila < primeraMatriz[0].length; fila++) {
            for (int columna = 0; columna < primeraMatriz.length; columna++) {
                terceraMatriz [fila][columna] = primeraMatriz [fila][columna] + segundaMatriz [fila][columna];
            }
        }
        return terceraMatriz;
    }
    
    public double[][] multiplicacionEscalar(double[][] matriz, double escalar){
        
        for (int fila = 0; fila < matriz[0].length; fila++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                matriz [fila][columna] = escalar * (matriz[fila][columna]);
            }
        }
        return matriz;
    }
    
    public double[][] multiplicar(double[][] primeraMatriz, double[][] segundaMatriz){
        double terceraMatriz[][] = new double [primeraMatriz[0].length][segundaMatriz[0].length];
        
        for (int filaPrimeraMatriz = 0; filaPrimeraMatriz < primeraMatriz[0].length; filaPrimeraMatriz++) {
            for (int columna = 0; columna < primeraMatriz.length; columna++) {
                for (int columnaSegundaMatriz = 0; columnaSegundaMatriz < segundaMatriz.length; columnaSegundaMatriz++) {
                    terceraMatriz[filaPrimeraMatriz][columnaSegundaMatriz] += primeraMatriz[filaPrimeraMatriz][columna] * segundaMatriz[columna][columnaSegundaMatriz];
                }
            }
        }
        return terceraMatriz;
    }
    
}
