/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincelab.storage;

/**
 *
 * @author Admin
 */
public class Vector3D{

    private final double x,y,z;
    
    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public double getX(){return x;}
    public double getY(){return y;}
    public double getZ(){return z;}
    
    
    public double magnitud(){
        return Math.sqrt(x * x + y * y + z * z);
    }
    
    public double productoPunto(Vector3D o){
        return x * o.x + y * o.y + z * o.z;
    }
    
    public Vector3D productoCruz(Vector3D o){
        return new Vector3D(
                y * o.z - z * o.y,
                z * o.z - x *o.z,
                x * o.y - y * o.x
        );
    }
    
    private double calcularAngulo(Vector3D o){
        
        double magnitudes = this.magnitud() * o.magnitud();
        
        double cos = this.productoPunto(o) / magnitudes;
        cos = Math.max(-1.0, Math.min(1.0, cos));
        
        return Math.toDegrees(Math.acos(cos));
                  
    }
    
}
