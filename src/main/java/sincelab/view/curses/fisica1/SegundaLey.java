package sincelab.view.curses.fisica1;

import sincelab.storage.segundaley;

/**
 *
 * @author alejo
 */
public class SegundaLey extends CalcFisica {

    // el orden es el mismo de los botones //
    private static final int FUERZA = 0, MASA = 1, ACELERACION = 2;

    public SegundaLey() {
        super("SEGUNDA LEY DE NEWTON",
                "Segunda ley de Newton",
                "Elige arriba que quieres calcular y llena sus datos.\n\n"
                + "Calcular fuerza: masa y aceleracion.\n"
                + "Calcular masa: fuerza y aceleracion.\n"
                + "Calcular aceleracion: fuerza y masa.\n\n"
                + "Todo sale de F = m * a.\n"
                + "La fuerza y la aceleracion son negativas si van en contra.\n"
                + "La masa siempre es mayor que 0.\n\n"
                + "Pulsa Iniciar para calcular.\n"
                + "En Resultados quedan los ultimos 5 calculos.",
                new String[]{"Calcular fuerza", "Calcular masa", "Calcular aceleracion"},
                new String[][]{
                    {"Masa (kg):", "Aceleracion (m/s^2):"},
                    {"Fuerza (N):", "Aceleracion (m/s^2):"},
                    {"Fuerza (N):", "Masa (kg):"}
                });
    }

    private void revisarMasa(double masa) {
        if (masa <= 0) throw new IllegalArgumentException("La masa debe ser mayor que 0.");
    }

    @Override
    protected void calcular(int modo, double[] datos) {
        if (modo == FUERZA) {
            double masa = datos[0], a = datos[1];
            revisarMasa(masa);
            mostrar("Fuerza = " + dato(segundaley.fuerza(masa, a)) + " N");

        } else if (modo == MASA) {
            double fuerza = datos[0], a = datos[1];
            if (a == 0) throw new IllegalArgumentException("La aceleracion no puede ser 0.");
            double masa = segundaley.masa(fuerza, a);
            if (masa <= 0) throw new IllegalArgumentException("La fuerza y la aceleracion deben ir en el mismo sentido.");
            mostrar("Masa = " + dato(masa) + " kg");

        } else if (modo == ACELERACION) {
            double fuerza = datos[0], masa = datos[1];
            revisarMasa(masa);
            mostrar("Aceleracion = " + dato(segundaley.aceleracion(fuerza, masa)) + " m/s^2");
        }
    }
}
