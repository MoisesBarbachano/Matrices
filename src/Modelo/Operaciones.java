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
    

    
    
    
    



