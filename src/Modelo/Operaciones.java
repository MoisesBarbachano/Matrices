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
    int PRIMERINDICE = 0;
    int SEGUNDOINDICE = 1;
    int DIVISOR_MODULO_PAR = 2;
        public double[][] transponerMatrices(double[][] matriz)
    {
        int numColumnasMatriz = matriz.length;
        double[][] matrizTranspuesta = new double[matriz[PRIMERINDICE].length][numColumnasMatriz];
        for (int columna = 0; columna < numColumnasMatriz; columna++) {
            int numFilasMatriz = matriz[columna].length;
            for (int fila = 0; fila <numFilasMatriz; fila++) {
                matrizTranspuesta[fila][columna] = matriz[columna][fila];
            }
        }
        
        
        return matrizTranspuesta;
    }
    
    public double obtenerDeterminante(double[][] matriz)
    {
        double determinante;
        int numColumnasMatriz = matriz.length;
        int numFilasMatriz = matriz[0].length;
        int numColumnasMatrizBasica = 2;
        if(numColumnasMatriz==numColumnasMatrizBasica)
        {
            determinante=(matriz[PRIMERINDICE][PRIMERINDICE]*matriz[SEGUNDOINDICE][SEGUNDOINDICE])-(matriz[SEGUNDOINDICE][PRIMERINDICE]*matriz[PRIMERINDICE][SEGUNDOINDICE]);
            return determinante;
        }
        double sumatoriaDeterminante=0;
        for(int columna=0; columna<numColumnasMatriz; columna++)
        {
            int ultimoIndice = numColumnasMatriz - 1;
            double[][] matrizReordenada = new double[ultimoIndice][ultimoIndice];
            for(int fila=0; fila<numFilasMatriz; fila++)
            {
                if(fila!=columna)
                {
                    for(int k=1; k<numColumnasMatriz; k++){
                        int indiceMatrizReordenada = 0;
                        if(fila<columna)
                        {
                            indiceMatrizReordenada=fila;
                        }else if(fila>columna)
                        {
                            indiceMatrizReordenada=fila-1;
                        }
                        matrizReordenada[indiceMatrizReordenada][k-1] = matriz[fila][k];
                    }
                }
            }
            if(columna%DIVISOR_MODULO_PAR==0)
            sumatoriaDeterminante+=matriz[columna][PRIMERINDICE] * obtenerDeterminante(matrizReordenada);
            else
            sumatoriaDeterminante-=matriz[columna][PRIMERINDICE] * obtenerDeterminante(matrizReordenada);
        }
        return sumatoriaDeterminante;
    }
    
    public double[][] sumarMatrices(double[][] primeraMatriz, double[][] segundaMatriz){
        int numFilasPrimeraMatriz = primeraMatriz[PRIMERINDICE].length;
        int numColumPrimeraMatriz = primeraMatriz.length;
        double[][] matrizResultante = new double [numFilasPrimeraMatriz][numColumPrimeraMatriz];
        for (int fila = 0; fila < primeraMatriz[0].length; fila++) {
            for (int columna = 0; columna < primeraMatriz.length; columna++) {
                matrizResultante [fila][columna] = primeraMatriz [fila][columna] + segundaMatriz [fila][columna];
            }
        }
        return matrizResultante;
    }
    
    public double[][] multiplicarEscalar(double[][] matriz, double escalar){
        int numFilasMatriz = matriz[PRIMERINDICE].length;
        for (int fila = 0; fila < numFilasMatriz; fila++) {
            int numColumMatriz = matriz.length;
            for (int columna = 0; columna < numColumMatriz; columna++) {
                matriz [fila][columna] = escalar * (matriz[fila][columna]);
            }
        }
        return matriz;
    }
    
    public double[][] multiplicarMatrices(double[][] primeraMatriz, double[][] segundaMatriz){
        double[][] matrizResultante = new double [primeraMatriz[0].length][segundaMatriz[0].length];
        int numFilasPrimeraMatriz = primeraMatriz[0].length;
        for (int filaPrimeraMatriz = 0; filaPrimeraMatriz < numFilasPrimeraMatriz; filaPrimeraMatriz++) {
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