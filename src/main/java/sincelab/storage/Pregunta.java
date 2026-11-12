/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincelab.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 


/**
 * autor @Angel
 * Una pregunta de opcion multiple con 4 opciones y una sola correcta.
 */
public class Pregunta {
 
    private final String enunciado;
    private final String[] opciones;
    private final int correcta;        // posicion (0 a 3) de la opcion correcta
    private final String explicacion;
 
    public Pregunta(String enunciado, int correcta, String explicacion, String... opciones) {
        if (opciones == null || opciones.length != 4) {
            throw new IllegalArgumentException("Cada pregunta debe tener 4 opciones");
        }
        if (correcta < 0 || correcta > 3) {
            throw new IllegalArgumentException("La opcion correcta debe estar entre 0 y 3");
        }
        this.enunciado = enunciado;
        this.correcta = correcta;
        this.explicacion = explicacion;
        this.opciones = opciones.clone();
    }
 
    public String getEnunciado() {
        return enunciado;
    }
 
    public String getOpcion(int i) {
        return opciones[i];
    }
 
    public int getCorrecta() {
        return correcta;
    }
 
    public String getExplicacion() {
        return explicacion;
    }
 
    /**
     * Devuelve el orden en que se muestran las opciones en este intento.
     * orden[k] es la opcion original que va en la posicion k de la pantalla.
     */
    public int[] ordenMezclado() {
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < opciones.length; i++) {
            lista.add(i);
        }
        Collections.shuffle(lista);
 
        int[] orden = new int[lista.size()];
        for (int i = 0; i < orden.length; i++) {
            orden[i] = lista.get(i);
        }
        return orden;
    }
}
 