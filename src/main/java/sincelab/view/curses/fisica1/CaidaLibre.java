package sincelab.view.curses.fisica1;

import sincelab.storage.caidalibre;

/**
 *
 * @author alejo
 */
public class CaidaLibre extends CalcFisica {

    // el orden es el mismo de los botones //
    private static final int VELOCIDAD_FINAL = 0, ALTURA = 1, TIEMPO = 2;

    public CaidaLibre() {
        super("CAIDA LIBRE",
                "Caida libre",
                "Elige arriba que quieres calcular y llena sus datos.\n\n"
                + "Calcular velocidad final: velocidad inicial y tiempo o altura,\n"
                + "llena solo uno de los dos y deja el otro vacio.\n"
                + "Calcular altura: velocidad inicial y tiempo que tarda en llegar al suelo.\n"
                + "Calcular tiempo: velocidad inicial y altura.\n\n"
                + "Velocidad inicial: 0 si se suelta, positiva si se lanza\n"
                + "hacia arriba y negativa si se lanza hacia abajo.\n"
                + "Gravedad: 9.8 en la Tierra, se puede cambiar.\n\n"
                + "Hacia arriba es positivo, por eso la velocidad final sale negativa al caer.\n"
                + "En Resultados quedan los ultimos 5 calculos.",
                new String[]{"Calcular velocidad final", "Calcular altura", "Calcular tiempo"},
                new String[][]{
                    {"Velocidad inicial (m/s):", "Tiempo (s):", "Altura (m):", "Gravedad (m/s^2):"},
                    {"Velocidad inicial (m/s):", "Tiempo (s):", "Gravedad (m/s^2):"},
                    {"Velocidad inicial (m/s):", "Altura (m):", "Gravedad (m/s^2):"}
                });

        valorInicial("Gravedad (m/s^2):", "9.8");
    }

    /* En velocidad final se puede dejar vacio el tiempo o la altura */
    @Override
    protected boolean opcional(int modo, int campo) {
        return modo == VELOCIDAD_FINAL && (campo == 1 || campo == 2);
    }

    /* Busca cuanto tarda en caer desde h, sin altura ni impulso hacia arriba no hay caida */
    private double tiempoDesde(double h, double v0, double g) {
        if (h < 0) throw new IllegalArgumentException("La altura no puede ser negativa.");
        double tiempo = caidalibre.tiempoCaida(h, v0, g);
        if (tiempo <= 0) throw new IllegalArgumentException("El cuerpo ya esta en el suelo, no hay caida.");
        return tiempo;
    }

    @Override
    protected void calcular(int modo, double[] datos) {
        double v0 = datos[0];
        double g = datos[datos.length - 1];

        if (g <= 0) throw new IllegalArgumentException("La gravedad debe ser mayor que 0.");

        if (modo == VELOCIDAD_FINAL) {
            double tiempo = datos[1], h = datos[2];
            boolean sinTiempo = Double.isNaN(tiempo), sinAltura = Double.isNaN(h);
            if (sinTiempo == sinAltura) throw new IllegalArgumentException("Llena solo el tiempo o solo la altura.");

            if (sinTiempo) {
                double caida = tiempoDesde(h, v0, g);
                mostrar("Velocidad final = " + dato(caidalibre.velocidad(v0, g, caida)) + " m/s\n"
                        + "Tiempo de caida = " + dato(caida) + " s");
            } else {
                revisarTiempo(tiempo);
                mostrar("Velocidad final = " + dato(caidalibre.velocidad(v0, g, tiempo)) + " m/s");
            }

        } else if (modo == ALTURA) {
            double tiempo = datos[1];
            revisarTiempo(tiempo);
            double h = caidalibre.alturaInicial(v0, g, tiempo);
            if (h < -1e-9) throw new IllegalArgumentException("En ese tiempo el cuerpo aun no baja de donde salio.");
            mostrar("Altura = " + dato(Math.max(0, h)) + " m\n"
                    + "Velocidad final = " + dato(caidalibre.velocidad(v0, g, tiempo)) + " m/s");

        } else if (modo == TIEMPO) {
            double h = datos[1];
            double tiempo = tiempoDesde(h, v0, g);
            mostrar("Tiempo de caida = " + dato(tiempo) + " s\n"
                    + "Velocidad final = " + dato(caidalibre.velocidad(v0, g, tiempo)) + " m/s");
        }
    }
}
