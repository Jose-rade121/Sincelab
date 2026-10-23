/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincelab.storage;

import java.util.Arrays;
/**
 *
 * @author Angel
 */

public class polinomio {
    
    private final double[] c; // en este caso se utiliza el "final" para que el polinomio no cambie una vez creado//
    
    public polinomio(double[] coef){
        int n = coef.length;
        while (n > 1 && coef [n - 1] == 0 )n --;
        c = Arrays.copyOf(coef, Math.max(n, 1));
    }
    
    public static polinomio parse(String texto) { // Este metodo hace que cualquier texto como 3x^2 - 5x + 2 en un objeto polinomico//
        if (texto == null || texto.isBlank())
            throw new IllegalArgumentException("Escribe una funcion.");
        
        String s = texto.toLowerCase().replace(" ","").replace("*", ".");
        s = s.replaceAll("(?<!^)(?<!\\^)-", "+-");   // "a-b" -> "a+-b" // es decir esto tiene la funcion de un "filtro" para que la PC busque los +- y separarlos asi no dañando la funcion//
        
         double[] coef = new double[1];
        for (String t : s.split("\\+")) { // el split tiene como funcion agarrar toda la cadena de texto del polinomio y "cortarlas" en terminos como "3x", "-5x" "2"
            if (t.isEmpty()) continue;
            double a;
            int e;
            int i = t.indexOf("x");
            if (i < 0)  { // Aqui el codigo cumple la funcion de buscar el termino independiente (como por ejemplo el "5"//
                a = Double.parseDouble(t);
                e = 0;
            } else { // este en un punto hace casi lo mismo que el anterior pero busca el Término con 'x' (como por ejemplo: "3x^2" o "-x") //
                String cs = t.substring(0, i);
                a = cs.isEmpty() ? 1 : cs.equals("-") ? -1 : Double.parseDouble(cs); // este es el encargado en extraer el coeficiente de x//
                String resto = t.substring(i + 1);
                if (resto.isEmpty()) e = 1;
                else if (resto.startsWith("^")) e = Integer.parseInt(resto.substring(1));
                else throw new IllegalArgumentException("Termino no valido: " + t);
                if (e < 0) throw new IllegalArgumentException("Solo exponentes enteros >= 0."); // esta parte del codigo separa el exponente de la x
            }
            if (e >= coef.length)coef = Arrays.copyOf(coef, e + 1);
            coef[e] += a;
        }
        return new polinomio(coef);
    }
    
    public double evaluar(double x) { //esta parte del codigo utiliza el metodo horner para lograr una evaluacion mas eficiente
        double r = 0;
        for (int i = c.length - 1; i>= 0;) r = r * x + c[i--];// Aqui se Aplica la regla de Horner: multiplica el acumulador por x y suma el coeficiente actual,
            // decrementando el índice 'i' en la misma instrucción (i--) 
        return r;
    }
    
     public double[] getCoeficientes() {
        return c.clone();
    }
 
    public static String fmt(double d) {
        if (Math.abs(d - Math.rint(d)) < 1e-9) return String.valueOf((long) Math.rint(d));
        return String.format("%.4f", d).replaceAll("0+$", "").replaceAll("\\.$", ""); // esta funcion solo hacer redondear los numeros con decimales grandisimos//
    }
    
    @Override
    public String toString() { // este override reescribe el polinomio haciendolo mas bonito a la vida 
        StringBuilder sb = new StringBuilder(); 
        for (int i = c.length - 1; i >= 0; i--) { // aqui esto se convierte en bucle haciendo que ordene de Mayor a menor grado cada termino independiente
            double a = c[i];
            if (a == 0 && c.length > 1) continue; // Si el coeficiente es cero y el polinomio tiene más de un término, omite este término (ej. no imprime + 0x)
            double abs = Math.abs(a);
            String cuerpo = (i == 0) // Define la estructura del término (número, variable x y exponente si aplica)
                    ? fmt(abs)
                    : (abs == 1 ? "" : fmt(abs)) + "x" + (i > 1 ? "^" + i : "");
            if (sb.length() == 0) sb.append(a < 0 ? "-" : "").append(cuerpo);
            else sb.append(a < 0 ? " - " : " + ").append(cuerpo);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
    
}
