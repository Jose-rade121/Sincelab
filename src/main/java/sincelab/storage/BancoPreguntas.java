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
    
    public static List<Pregunta> fisica(){
        return List.of(
                new Pregunta("Un automovil parte del reposo y alcanza 25 m/s en 10 segundos ¿Cual es su aceleracion?",1,
                    "La aceleracion es de 2.5 m/s^2. Poruqe la velocidad aumenta 25 m/s en 10 segundos",
                    "1.5 m/s^2", "2.5 m/s^2", "3.5 m/s^2", "5 m/s^2"),
                
                new Pregunta("Una motocicleta viaja a 30 m/s y frena uniformemente hasta detenerse en 5 segundos. ¿Que distancia recorre durante el frenado?",
                    2,"Ocurre de forma progresiva cuando la aceleracion actua en direccion contraria al desplazamiento, provocando una disminucion progresica de la velocidad",  
                    "50 m", "60 m", "75 m", "90 m"),
                
                new Pregunta("Una pelota se deja caer desde el reposo durante 3 segundos. ¿Que velocidad alcanza?",2,
                    "Movimiento vertical de un objeto bajo acto de la gravedad, que desprecia la resistencia del aire",
                    "19.6 m/s", "24.5 m/s", "29.4 m/s", "32.4 m/s"),
                
                new Pregunta("Una pelota es lanzada verticalmente hacia arriba con una velocidad inicial de 19.6 m/s. ¿Cuanto tarda en alcanzar la altura maxima",1,
                    "Movimiento vertical del objeto lanzado desde arriba, cuya velocidad disminuye por efecto de la gravedad hasta llegar a 0 en su altura",
                    "1 s", "2 s", "3 s", "4 s"),
                
                new Pregunta("Un bloque de 12 kg recibe 60 N hacia la derecha y 24 N hacia la izquierda ¿Cual es su aceleracion?",1,
                    " Establece la aceleracion de un cuerpo que depende de la fuerza neta aplicada y su masa",
                    "2 m/s^2", "3 m/s^2", "4 m/s^2", "7 m/s^2"),
                
                new Pregunta("Un bloque de 20 kg tiene un coeficiente de friccion cinetica de 0.25. ¿Cual es la fueza de friccion en la superficie horizontal?",2,
                    "Fuerza opuesta al movimiento de un objeto el cual se desliza sobre una superficie",
                    "24.5 N", "39.2 N", "49 N", "98 N"),
                
                new Pregunta("Una masa de 8 kg asciende con una aceleracion de 2 m/s^2 ¿Cual es la tension de la cuerda?",2,
                    "Fuerza que le es transmitida a la cuerda en cuando esta se somete a traccion. Su valor depende de los valores de la aceleracion en todo el sistema",
                    "62.4 N", "78.4 N", "94.4 N", "98.4 N"),
                
                new Pregunta("Dos masas de 4 kg y 7kg estan conectadas mediante una polea ideal ¿Cual es la aceleracion del sistema?",1,
                    " Sistema de dos masas conectadas por una cuerda y una polea, cuyo movimiento depende de las diferencias de peso",
                    "1.8 m/s^2", "2.67 m/s^2", "3.5 m/s^2", "4.9 m/s^2"),
                
                new Pregunta("Un bloque de 10 kg baja por un pano de 30 grados. ¿Cual es la componente de su peso paralelo al plano?",2,
                    "Superficie inclinada donde el peso se descompone en componentes paralelas y perpendiculares a la superficie",
                    "24.5 N", "39.2 N", "49 N", "84.9 N"),
                
                new Pregunta("Un bloque de 10 kg sobre una mesa rugosa (coeficiente friccion = 0.15) esta conectado a una masa suspendida de 5 kg ¿Cual es la aceleracion del sistema?",0,
                    "sistema que integra varios principios de la dinamica, como tension, friccion y segunda ley de Newton, para determinar el movimiento de cuerpos conectados",
                    "2.29 m/s^2", "2.94 m/s^2", "3.27 m/s^2", "4.9 m/s^2")
        );
    }
    
    public static List<Pregunta> humanidades(){
        return List.of(
                new Pregunta("¿Cual es el objetivo principal de las humanidades?",1,
                    "Las humanidades estudian al ser humano desde prespectivas como la historia la filosofia, el arte y la cultura, permitiendo comprender su desarrollo y comportamiento",
                    "Estudiar exclusivamente los fenomenos naturales", "Comprender al ser humano, su pensamiento, cultural e historia", "Desarrollar unicamente conocimiento matematicos",
                    "Analizar solamente los avances tecnologicos"),
                
                new Pregunta("¿Que caracteriza al pensamiento critico?",
                    2,"El pensamiento critico permite examinar el argumento y evidencias antes de aceptar una afirmacion o tomar una decision",  
                    "Aceptar todo sin cuestionar", "Defender siempre las opiniones propias", "Analizar informacion, evaluar evidencias y formular juicios razonados",
                    "Rechazar cualquier opinion diferente"),
                
                new Pregunta("¿Que es una falacia argumentativa?",0,
                    "Una falacia es un error de razonamiento que puede hacer que un argumento parezca convincente aunque no tenga una estructura logica valida",
                    "Un razonamiento que parece valido, pero contiene un error logico", "Una conclusion respaldada por evidencias suficientes", "Una pregunta que no tiene respuesta", 
                    "Una explicacion cientifica comprobada"),
                
                new Pregunta("¿Que estrategia favorece la comprension lectora",3,
                    "La comprension lectora requiere interpretar la informacion, reconocer las ideas centrales y establecer relaciones entre diferentes partes del texto",
                    "Leer rapidamente sin prestar atencion", "Memorizar todas las palabras del texto", "Evitar Relacionar el texto con conocimientos previos", "Identificar ideas principales, inferir en significados y analizar el contexto"),
                
                new Pregunta("¿Cual es la mejor forma de evitar el plagio al usar las ideas de otro autor?", 2,
                    "El plagio es presentar ideas ajenas como propias. Se evita citando al autor, por ejemplo con las normas APA, y parafraseando con palabras propias.",
                    "Cambiar solo algunas palabras sin mencionar al autor",
                    "Copiar el texto exacto sin usar comillas",
                    "Citar la fuente y parafrasear con palabras propias",
                    "Mezclar varios textos sin indicar de donde vienen"),
                
                new Pregunta("¿Cual de estas es una fuente primaria?", 1,
                    "Las fuentes primarias se producen en la epoca que se estudia, como cartas, diarios y leyes. Los libros y documentales son fuentes secundarias porque interpretan esas fuentes despues.",
                    "Un libro de texto sobre una guerra",
                    "Una carta escrita por un soldado durante esa guerra",
                    "Un articulo que analiza las causas de esa guerra",
                    "Un documental sobre esa guerra"),
                
                new Pregunta("¿A que filosofo se le atribuye la frase \"pienso, luego existo\"?", 3,
                    "Descartes uso la duda metodica para buscar una certeza: si duda, esta pensando, y si piensa, existe.",
                    "Platon",
                    "Aristoteles",
                    "Kant",
                    "Descartes"),
                
                new Pregunta("Segun el utilitarismo, ¿cuando una accion es correcta?", 0,
                    "El utilitarismo (Bentham y Mill) juzga las acciones por sus consecuencias. La deontologia de Kant se centra en el deber, y la etica de las virtudes de Aristoteles, en el caracter.",
                    "Cuando produce el mayor bienestar para el mayor numero de personas",
                    "Cuando cumple el deber sin importar el resultado",
                    "Cuando ayuda a formar un buen caracter",
                    "Cuando beneficia solo a quien la realiza"),
                
                new Pregunta("¿Que es el etnocentrismo?", 2,
                    "El etnocentrismo toma la propia cultura como medida de las demas. Lo contrario es el relativismo cultural, que entiende cada cultura desde su propio contexto.",
                    "Entender cada cultura desde su propio contexto",
                    "El intercambio mundial de informacion e ideas",
                    "Juzgar a otras culturas con los valores de la propia",
                    "El conjunto de costumbres y creencias de un grupo"),
                
                new Pregunta("¿Cual es el rasgo principal del realismo magico?", 1,
                    "El realismo magico presenta hechos extraordinarios como algo normal en la vida cotidiana. Su figura mas conocida es Gabriel Garcia Marquez, con Cien anos de soledad (1967).",
                    "Describe solo hechos historicos comprobados",
                    "Presenta hechos extraordinarios como algo normal",
                    "Se escribe unicamente en verso",
                    "Rechaza a los personajes y la trama")
        );
    }
}
