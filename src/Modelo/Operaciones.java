<<<<<<< HEAD

=======
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
        public double[][] transponer(double[][] matriz)
    {
        double[][] matrizTranspuesta = new double[matriz[0].length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <matriz[i].length; j++) {
                matrizTranspuesta[j][i] = matriz[i][j];
            }
        }
        
        
        return matrizTranspuesta;
    }
    
    public double determinante(double[][] matriz)
{
    double det;
    if(matriz.length==2)
    {
        det=(matriz[0][0]*matriz[1][1])-(matriz[1][0]*matriz[0][1]);
        return det;
    }
    double suma=0;
    for(int i=0; i<matriz.length; i++)
    {
        double[][] nm=new double[matriz.length-1][matriz.length-1];
        for(int j=0; j<matriz.length; j++)
        {
            if(j!=i)
            {
                for(int k=1; k<matriz.length; k++){
                int indice=-1;
                if(j<i)
                indice=j;
                else if(j>i)
                indice=j-1;
                nm[indice][k-1]=matriz[j][k];
                }
            }
        }
        if(i%2==0)
        suma+=matriz[i][0] * determinante(nm);
        else
        suma-=matriz[i][0] * determinante(nm);
    }
    return suma;
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
>>>>>>> fa55cc435faca80f4a5b6ed7f46651bab27188f0
