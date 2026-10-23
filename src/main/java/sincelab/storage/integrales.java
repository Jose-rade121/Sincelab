/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincelab.storage;

/**
 *
 * @author Angel
 */
public class integrales {
    
    public static polinomio primitiva(polinomio p) { //la funcion primitiva calcula la integral indefinida (antiderivada) de un polinomio aplicanco la reglas basica como la regla de la potencia //
        double[] c = p.getCoeficientes();
        double[] f = new double[c.length + 1];
        for (int i = 0; i < c.length; i++) f[i + 1] = c[i] / (i + 1); //Divide cada coeficiente actual entre su nuevo exponente (i + 1) y lo coloca en la posición superior del nuevo arreglo. (Por ejemplo, un término de grado 1 se convierte en grado 2
        return new polinomio(f);
    }
    
    public static double definida(polinomio p, double a, double b) { // aca el metodo calcula el valor de la integral entre dos limites, utilizando la regla de barrow//
        polinomio F = primitiva(p);
        return F.evaluar(b) - F.evaluar(a);
    }    
       
}
