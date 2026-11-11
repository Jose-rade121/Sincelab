/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincelab.storage;

import java.util.List;
 
/**
 * Banco de preguntas del quiz. Cada pregunta correcta vale PUNTOS_POR_PREGUNTA.
 * El tercer argumento de Pregunta es la explicacion que se muestra al responder;
 * el segundo es la posicion de la opcion correcta (0 = A, 1 = B, 2 = C, 3 = D).
 */
public final class BancoPreguntas {
 
    public static final int PUNTOS_POR_PREGUNTA = 10;
 
    private BancoPreguntas() {
    }
 
    public static List<Pregunta> matematicas2() {
        return List.of(
            new Pregunta("Cual es la derivada de f(x) = x^4 - 2x^2 + 7?", 1,
                "Con la regla de la potencia en cada termino: x^4 pasa a 4x^3, -2x^2 pasa a -4x y la constante 7 pasa a 0.",
                "4x^3 - 2x", "4x^3 - 4x", "x^3 - 4x", "4x^4 - 4x^2"),
 
            new Pregunta("Para f(x) = x^3 - 3x, cuanto vale f'(1)?", 2,
                "f'(x) = 3x^2 - 3, asi que f'(1) = 3 - 3 = 0. El valor -2 es f(1), la funcion sin derivar.",
                "-2", "3", "0", "6"),
 
            new Pregunta("Usando la regla del producto, cual es la derivada de x^2*sen(x)?", 0,
                "(f*g)' = f'*g + f*g'. Con f = x^2 y g = sen(x): 2x*sen(x) + x^2*cos(x).",
                "2x*sen(x) + x^2*cos(x)", "2x*cos(x)", "2x*sen(x) - x^2*cos(x)", "x^2*cos(x)"),
 
            new Pregunta("Cual es la derivada de e^(5x)?", 3,
                "Regla de la cadena: la derivada de e^u es e^u*u'. Aqui u = 5x y u' = 5.",
                "e^(5x)", "5x*e^(5x-1)", "e^5", "5*e^(5x)"),
 
            new Pregunta("En que punto tiene un minimo la funcion f(x) = x^2 - 4x + 3?", 1,
                "f'(x) = 2x - 4 = 0 da x = 2. Como f''(x) = 2 es positiva, es un minimo, y f(2) = -1.",
                "x = -2", "x = 2", "x = 4", "x = 3"),
 
            new Pregunta("Cual es la recta tangente a f(x) = x^2 en x = 3?", 2,
                "f(3) = 9 y f'(3) = 6. Con y - f(a) = f'(a)*(x - a): y - 9 = 6(x - 3), es decir y = 6x - 9.",
                "y = 6x + 9", "y = 3x", "y = 6x - 9", "y = 9x - 6"),
 
            new Pregunta("Cual es el resultado de la integral indefinida de 3x^2 + 4x - 1?", 0,
                "Cada termino sube un exponente y se divide entre el nuevo: 3x^2 pasa a x^3, 4x pasa a 2x^2 y -1 pasa a -x.",
                "x^3 + 2x^2 - x + C", "x^3 + 4x^2 - x + C", "6x + 4 + C", "x^3 + 2x^2 - 1 + C"),
 
            new Pregunta("Cuanto vale la integral de x^2 entre 0 y 3?", 3,
                "La primitiva es x^3/3. Entonces F(3) - F(0) = 9 - 0 = 9. El valor 27 aparece si se olvida dividir entre 3.",
                "27", "3", "6", "9"),
 
            new Pregunta("Cual es el area entre las curvas y = x y y = x^2, entre x = 0 y x = 1?", 1,
                "En [0, 1] se cumple x >= x^2, asi que el area es la integral de (x - x^2): 1/2 - 1/3 = 1/6.",
                "1/2", "1/6", "1/3", "5/6"),
 
            new Pregunta("En la calculadora de SINCELAB, que pasa si escribes la funcion 3y + 2?", 2,
                "El metodo parse no reconoce \"3y\" como numero ni como termino con x, lanza un IllegalArgumentException y la ventana lo atrapa para mostrar el aviso.",
                "Toma la y como si fuera x", "Calcula solo la derivada de 2",
                "Muestra el cuadro \"Dato Invalido\"", "Cierra el programa")
        );
    }
 
    public static List<Pregunta> algebraLineal() {
        return List.of(
            new Pregunta("Cual es la determinante de la matriz [3 1; 2 4]?", 3,
                "Para una matriz 2 x 2, det = a*d - b*c = 3*4 - 1*2 = 10. El valor 14 sale de sumar los productos en vez de restarlos.",
                "14", "2", "12", "10"),
 
            new Pregunta("Cual es la transpuesta de la matriz [1 2 3; 4 5 6]?", 0,
                "Las filas pasan a ser columnas, asi que la matriz de 2 x 3 se convierte en una de 3 x 2.",
                "[1 4; 2 5; 3 6]", "[4 5 6; 1 2 3]", "[1 2 3; 4 5 6]", "[3 2 1; 6 5 4]"),
 
            new Pregunta("Si A es de tamano 2 x 3 y B es de tamano 3 x 4, de que tamano es A * B?", 2,
                "Se puede multiplicar porque las columnas de A (3) son iguales a las filas de B (3). Si A es m x n y B es n x p, el resultado es m x p, es decir, 2 x 4.",
                "3 x 3", "3 x 4", "2 x 4", "2 x 3"),
 
            new Pregunta("Cual es la inversa de la matriz [2 0; 0 4]?", 1,
                "En una matriz diagonal se invierte cada elemento de la diagonal: 1/2 = 0.5 y 1/4 = 0.25. Se comprueba con la determinante (8), que no es cero.",
                "[2 0; 0 4]", "[0.5 0; 0 0.25]", "[-2 0; 0 -4]", "[0.25 0; 0 0.5]"),
 
            new Pregunta("Cual es la determinante de [2 5 1; 0 3 7; 0 0 4]?", 0,
                "En una matriz triangular, la determinante es el producto de la diagonal: 2*3*4 = 24. El valor 9 aparece si se suma la diagonal.",
                "24", "9", "0", "6"),
 
            new Pregunta("Si se intercambian dos filas de una matriz, que le pasa a su determinante?", 3,
                "Por ejemplo, [1 2; 3 4] tiene determinante -2 y al intercambiar sus filas, [3 4; 1 2], da 2.",
                "Se duplica", "No cambia", "Se vuelve 0", "Cambia de signo"),
 
            new Pregunta("Si u = (1, 2, -1) y v = (3, -1, 1), que se concluye?", 1,
                "u.v = 1*3 + 2*(-1) + (-1)*1 = 3 - 2 - 1 = 0. Un producto punto igual a 0 indica vectores ortogonales.",
                "Son paralelos", "Son perpendiculares", "Forman un angulo de 45 grados", "v es el doble de u"),
 
            new Pregunta("Cual es el vector unitario de v = (3, 4, 0)?", 2,
                "|v| = raiz(9 + 16) = 5. El vector unitario es v / |v| = (3/5, 4/5, 0) = (0.6, 0.8, 0).",
                "(0.3, 0.4, 0)", "(3/7, 4/7, 0)", "(0.6, 0.8, 0)", "(3, 4, 0)"),
 
            new Pregunta("Si u x v = (-3, 6, -3), cuanto es v x u?", 0,
                "El producto cruz no es conmutativo: u x v = -(v x u), asi que cambia de signo cada componente.",
                "(3, -6, 3)", "(-3, 6, -3)", "(0, 0, 0)", "(3, 6, 3)"),
 
            new Pregunta("En la ventana Vectores de SINCELAB, si V1 = (1, 0, 0) y V2 = (0, 1, 0), que resultados muestra?", 3,
                "Los vectores son perpendiculares, asi que el angulo es 90 grados. Su producto cruz es (0, 0, 1) y la ventana lo escribe con un decimal.",
                "\"Angulo entre vectores: 45.00 grados\" y \"Producto cruz: (1.0,1.0,0.0)\"",
                "\"Angulo entre vectores: 0.00 grados\" y \"Producto cruz: (0.0,0.0,0.0)\"",
                "\"Angulo entre vectores: 90.00 grados\" y \"Producto cruz: (1.0,0.0,0.0)\"",
                "\"Angulo entre vectores: 90.00 grados\" y \"Producto cruz: (0.0,0.0,1.0)\"")
        );
    }
}
 