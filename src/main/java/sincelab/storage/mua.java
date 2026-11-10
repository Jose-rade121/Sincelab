package sincelab.storage;

/**
 *
 * @author alejo
 */
public class mua {

    public static double aceleracion(double v0, double vf, double t) { // este metodo despeja la aceleracion de v = v0 + a*t //
        return (vf - v0) / t;
    }

    public static double velocidad(double v0, double a, double t) { // este metodo calcula la velocidad en el instante t usando v = v0 + a*t //
        return v0 + a * t;
    }

    public static double posicion(double v0, double a, double t) { // este metodo calcula cuanto se movio desde el inicio usando x = v0*t + (a*t^2)/2 //
        return v0 * t + (a * t * t) / 2;
    }

    public static double distancia(double v0, double a, double t) { // este metodo calcula lo que recorrio de verdad, si el cuerpo se devuelve el camino de ida y el de vuelta se suman //
        double parada = a != 0 ? -v0 / a : 0; // instante en que la velocidad llega a 0 //
        if (parada <= 0 || parada >= t) return Math.abs(posicion(v0, a, t));
        double ida = posicion(v0, a, parada);
        return Math.abs(ida) + Math.abs(posicion(v0, a, t) - ida);
    }

    public static double tiempo(double v0, double a, double d) { // este metodo es el contrario de distancia: busca cuanto tarda en recorrer d //
        if (v0 < 0) { // si arranca hacia atras es el mismo problema visto en el espejo //
            v0 = -v0;
            a = -a;
        }
        double frenada = a < 0 ? v0 * v0 / (-2 * a) : Double.POSITIVE_INFINITY; // lo que alcanza a recorrer antes de detenerse //
        if (d <= frenada) { // formula general escrita de forma que tambien sirva cuando a = 0 //
            return 2 * d / (v0 + Math.sqrt(Math.max(0, v0 * v0 + 2 * a * d)));
        }
        return v0 / -a + Math.sqrt(2 * (d - frenada) / -a); // lo que tarda en frenar + lo que tarda de vuelta //
    }

}
