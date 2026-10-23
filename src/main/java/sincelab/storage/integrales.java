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
    
    public static polinomio primitiva(polinomio p) {
        double[] c = p.getCoeficientes();
        double[] f = new double[c.length + 1];
        for (int i = 0; i < c.length; i++) f[i + 1] = c[i] / (i + 1);
        return new polinomio(f);
    }
    
    public static double definida(polinomio p, double a, double b) {
        polinomio F = primitiva(p);
        return F.evaluar(b) - F.evaluar(a);
    }    
       
}
