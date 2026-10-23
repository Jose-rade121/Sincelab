/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincelab.storage;

/**
 *
 * @author Angel
 */
public class derivada {
    
    public static polinomio derivar(polinomio p) {
        double[] c = p.getCoeficientes();
        if (c.length == 1) return new polinomio(new double[]{0});
 
        double[] d = new double[c.length - 1];
        for (int i = 1; i < c.length; i++) d[i - 1] = i * c[i];
        return new polinomio(d);
    }
    
    public static double valorEn(polinomio p, double x){
        return derivar(p).evaluar(x);
    }
    
    
}
