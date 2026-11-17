/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincelab.storage;

/**
 * Clase utilitaria encargada de realizar operaciones de cálculo diferencial
 * simbólico y numérico sobre funciones polinómicas mediante la regla de la potencia.
 *
 * @author Angel
 * @version 1.0
 * @since JDK 11
 */
public class derivada {
    
    public static polinomio derivar(polinomio p) { //este metodo cumple la funcion de hacer la derivada analitica de un polinomio aplicando la regla de las potencias //
        double[] c = p.getCoeficientes();
        if (c.length == 1) return new polinomio(new double[]{0});
 
        double[] d = new double[c.length - 1];
        for (int i = 1; i < c.length; i++) d[i - 1] = i * c[i]; // Multiplica el coeficiente actual c[i] por su exponente/grado i, y lo coloca en la posición correspondiente del nuevo arreglo reducido //
        return new polinomio(d);
    }
    
    public static double valorEn(polinomio p, double x){ // este metodo calcula la derivada evaluada en valor numerico puesto por el usuario //
        return derivar(p).evaluar(x);
    }
    
    
}
