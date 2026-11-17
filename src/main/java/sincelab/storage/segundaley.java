package sincelab.storage;

/**
 * Clase utilitaria encargada de resolver operaciones fundamentales de dinámica
 * basadas en la Segunda Ley de Newton ($F = m \cdot a$), permitiendo despejar
 * fuerza neta, masa o aceleración.
 *
 * @author alejo
 * @version 1.0
 * @since JDK 11
 */
public class segundaley {

    public static double fuerza(double masa, double aceleracion) { // este metodo aplica directo F = m*a //
        return masa * aceleracion;
    }

    public static double masa(double fuerza, double aceleracion) { // este metodo despeja la masa de F = m*a //
        return fuerza / aceleracion;
    }

    public static double aceleracion(double fuerza, double masa) { // este metodo despeja la aceleracion de F = m*a //
        return fuerza / masa;
    }

}
