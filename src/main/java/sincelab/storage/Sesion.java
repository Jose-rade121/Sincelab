/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincelab.storage;

/**
 *
 * @author Angel
 */
public class Sesion {
    
    private static Users actual;
 
    private Sesion() {
    }
 
    public static void iniciar(Users usuario) {
        actual = usuario;
    }
 
    public static Users actual() {
        return actual;
    }
}
