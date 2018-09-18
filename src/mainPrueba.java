
import Modelo.Operaciones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sulak
 */
public class mainPrueba {
    public static void main(String[] args) {
        double[][] matriz = {{3.0,2.0,1.0},{0.0,2.0,-5.0},{-2.0,1.0,4.0}};
        Operaciones operaciones = new Operaciones();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
            System.out.print(matriz[i][j] + " ");
            }
            System.out.println("\n");
        }
        
        System.out.println("--------------------------");
        
        System.out.println(
        operaciones.determinante(matriz));
    }
    
}
