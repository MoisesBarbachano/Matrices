
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
        for(int columna=0; columna<numColumnasMatriz; columna++)                         //Mantener como máximo 3 niveles de LOOPS
        {                                                                                 //Hacer loops largos especialmente claros
            int ultimoIndice = numColumnasMatriz - 1;
            double[][] matrizReordenada = new double[ultimoIndice][ultimoIndice];
            for(int fila=0; fila<numFilasMatriz; fila++)                            //Hacer los loops tan cortos como se pueda ver dentro de tu pantalla
            {
                if(fila!=columna)              //Poner los casos más comunes primeros
                {
                    for(int ColumMatrizReOrdenada=1; ColumMatrizReOrdenada<numColumnasMatriz; ColumMatrizReOrdenada++){                 
                        int indiceMatrizReordenada = 0;
                        if(fila <= (columna-1))              //Sigue la clausula if con una sentencia significativa(no colocar null en la sentencia if, y hacerlo dentro del else)
                        {
                            indiceMatrizReordenada=fila;
                        }else if((fila-1) >= columna)
                        {
                            indiceMatrizReordenada=fila-1;
                        }
                        matrizReordenada[indiceMatrizReordenada][ColumMatrizReOrdenada-1] = matriz[fila][ColumMatrizReOrdenada];
                    }
                }
            }                                                                                   
            if(columna%DIVISOR_MODULO_PAR==0)
            sumatoriaDeterminante+=matriz[columna][PRIMERINDICE] * obtenerDeterminante(matrizReordenada);
            else                                                                                                            //Considera la clausula else
            sumatoriaDeterminante-=matriz[columna][PRIMERINDICE] * obtenerDeterminante(matrizReordenada);
        }                                                                                                                   //Se evita usar código que dependa de los valores de los indices finales de los loop
        return sumatoriaDeterminante;
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
    
    public void gaussJordan(double[][] matriz){
          int pivote = 0;
          double auxiliarDivision = 0;
          int longitud = matriz.length;
          final int ajusteLongitud=longitud+1;
           // Lineamientos general: No hay ningun loop vacio || cada loop solo tiene una funcion || Cada loop termina || Se usan variables con nombres claros
           for (int contador = 0; contador < longitud; contador++) { // Se usa for ya que se requiere que se ejecute un numero especifico de veces || Los contadores son  enteros 
             auxiliarDivision = matriz[pivote][pivote]; 
            
                for (int contadorOperacion = 0; contadorOperacion < ajusteLongitud; contadorOperacion++) { // hacer los loops cortos || Limitar los Loops anidados a maximo 3 niveles
                    matriz[pivote][contadorOperacion] =( matriz[pivote][contadorOperacion] )/ (auxiliarDivision); 
                 }
           
          
           for (int contadorNoPivote = 0; contadorNoPivote < longitud; contadorNoPivote++) { // entra en un loop de una manera || incializar  variables en el loop || Los lopps evitan crosstalk
            if (contadorNoPivote != pivote) { // Escribir primero los casos normales 
                double valorTemporal = matriz[contadorNoPivote][pivote];
                for (int contadorAjuste = 0; contadorAjuste < ajusteLongitud; contadorAjuste++) {
                    matriz[contadorNoPivote][contadorAjuste] = ( matriz[pivote][contadorAjuste])*(valorTemporal * -1) + matriz[contadorNoPivote][contadorAjuste];
                }
            }
        }

          
            pivote++; // Cuidar los loop-housekeeping
        }
           for (int x = 0; x < longitud; x++) {
            System.out.println("La variable X" + (x + 1) + " es: " + matriz[x][longitud]);
        }
    }
    
    public static void main(String[] args) {
      double matriz[][] = new double [3][4];
      matriz[0][0]= 3.0;
      matriz[0][1]=-0.1;
      matriz[0][2]=-0.2;
      matriz[0][3]=7.8500;
      matriz[1][0]=0.1;
      matriz[1][1]=7.0;
      matriz[1][2]=-0.3;
      matriz[1][3]=-19.3;
      matriz[2][0]=0.3;
      matriz[2][1]=0.2;
      matriz[2][2]=10;
      matriz[2][3]=71.4000;
      
      Operaciones op= new Operaciones();
      op.gaussJordan(matriz);
    }
    
}
