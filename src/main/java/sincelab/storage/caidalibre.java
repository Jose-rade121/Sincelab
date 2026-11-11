package sincelab.storage;

/**
 *
 * @author alejo
 */
public class caidalibre {

    // Aqui hacia arriba es positivo, por eso la caida libre es un mua con a = -g //

    public static double velocidad(double v0, double g, double t) {
        return mua.velocidad(v0, -g, t);
    }

    public static double alturaInicial(double v0, double g, double t) { // este metodo busca desde que altura sale si tarda t en llegar al suelo //
        return -mua.posicion(v0, -g, t);
    }

    public static double tiempoCaida(double h, double v0, double g) { // este metodo busca cuando la altura llega a 0 con la formula general, la otra raiz da negativa y no sirve //
        return (v0 + Math.sqrt(v0 * v0 + 2 * g * h)) / g;
    }

}
