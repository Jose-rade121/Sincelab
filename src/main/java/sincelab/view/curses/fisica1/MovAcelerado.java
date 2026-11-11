package sincelab.view.curses.fisica1;

import sincelab.storage.mua;


/**
 *
 * @author alejo
 */
public class MovAcelerado extends CalcFisica {

    // el orden es el mismo de los botones //
    private static final int ACELERACION = 0, VELOCIDAD_FINAL = 1, DISTANCIA = 2, TIEMPO = 3;

    public MovAcelerado() {
        super("MOVIMIENTO UNIFORMEMENTE ACELERADO",
                "Movimiento uniformemente acelerado",
                "Elige arriba que quieres calcular y llena sus datos.\n\n"
                + "Calcular aceleracion: velocidad inicial, velocidad final y tiempo.\n"
                + "Calcular velocidad final: velocidad inicial, aceleracion y tiempo.\n"
                + "Calcular distancia: velocidad inicial, aceleracion y tiempo.\n"
                + "Calcular tiempo: velocidad inicial, aceleracion y distancia.\n\n"
                + "La aceleracion puede ser negativa si va frenando.\n"
                + "Si el cuerpo se devuelve, la distancia suma la ida y la vuelta\n"
                + "y el desplazamiento solo mira donde termino.\n\n"
                + "Pulsa Iniciar para calcular.\n"
                + "En Resultados quedan los ultimos 5 calculos.",
                new String[]{"Calcular aceleracion", "Calcular velocidad final", "Calcular distancia", "Calcular tiempo"},
                new String[][]{
                    {"Velocidad inicial (m/s):", "Velocidad final (m/s):", "Tiempo (s):"},
                    {"Velocidad inicial (m/s):", "Aceleracion (m/s^2):", "Tiempo (s):"},
                    {"Velocidad inicial (m/s):", "Aceleracion (m/s^2):", "Tiempo (s):"},
                    {"Velocidad inicial (m/s):", "Aceleracion (m/s^2):", "Distancia (m):"}
                });
         
    }

    @Override
    protected void calcular(int modo, double[] datos) {
        double v0 = datos[0];

        if (modo == ACELERACION) {
            double vf = datos[1], tiempo = datos[2];
            revisarTiempo(tiempo);
            double a = mua.aceleracion(v0, vf, tiempo);
            mostrar("Aceleracion = " + dato(a) + " m/s^2\n"
                    + "Distancia = " + dato(mua.distancia(v0, a, tiempo)) + " m");

        } else if (modo == VELOCIDAD_FINAL) {
            double a = datos[1], tiempo = datos[2];
            revisarTiempo(tiempo);
            mostrar("Velocidad final = " + dato(mua.velocidad(v0, a, tiempo)) + " m/s");

        } else if (modo == DISTANCIA) {
            double a = datos[1], tiempo = datos[2];
            revisarTiempo(tiempo);
            mostrar("Distancia = " + dato(mua.distancia(v0, a, tiempo)) + " m\n"
                    + "Desplazamiento = " + dato(mua.posicion(v0, a, tiempo)) + " m");

        } else if (modo == TIEMPO) {
            double a = datos[1], distancia = datos[2];
            if (distancia <= 0) throw new IllegalArgumentException("La distancia debe ser mayor que 0.");
            if (v0 == 0 && a == 0) throw new IllegalArgumentException("Sin velocidad ni aceleracion el cuerpo no se mueve.");
            double tiempo = mua.tiempo(v0, a, distancia);
            mostrar("Tiempo = " + dato(tiempo) + " s\n"
                    + "Velocidad final = " + dato(mua.velocidad(v0, a, tiempo)) + " m/s");
        }
    }
}
