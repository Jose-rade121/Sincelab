
package sincelab.storage;

/**
 *
 * @author josee
 */
public class MatrizCuadrada {
    
    private static final double EPS = 1e-10;
    private final double[][] datos;
    private final int orden;

    public MatrizCuadrada(double[][] datos){
        
        if(datos == null || datos.length == 0){
            throw new IllegalArgumentException("La matriz no puede estar vacia");
        }
        
        int n = datos.length;
        this.orden = n;
        this.datos = new double[n][n];
        
        for(int i = 0; i < n; i++){
            if(datos[i] == null || datos[i].length != n){
                throw new IllegalArgumentException("La matriz cuadrada debe ser nXn");
            }
            
            //Esto de por aqui es pa que si el arreglo original cambia
            //no se altere la matriz (Buscar mas profundamente)
            System.arraycopy(datos[i], 0 , this.datos[i], 0,n);
        }   
    } 
    
    public int getOrden(){
        return orden;
    }
    
    public double get(int fila, int columna){
        return datos[fila][columna];
    }
    
    private double[][] copiarDatos(){
        double[][] copia = new double[orden][orden];
        
        for(int i = 0; i < orden;i++){
            System.arraycopy(datos[i], 0 , copia[i], 0 , orden);
        }
        return copia;
    }
    
    private static void intercambiarFilas(double[][] m, int f1, int f2){
        double [] temporal = m[f1];
        m[f1] = m[f2];
        m[f2] = temporal;
    }
    
    public double determinante(){
        double [][] a = copiarDatos();
        double det = 1.0;
        
        for(int col = 0; col < orden; col++){
            
            int piv = col;
            
            for(int i = col + 1; i < orden; i++){
                if(Math.abs(a[i][col]) > Math.abs(a[piv][col])){
                    piv = i;
                }
            }
            
            if(Math.abs(a[piv][col]) < EPS){
                return 0.0;
            }
            
            if(piv != col){
                intercambiarFilas(a,piv,col);
                det = -det;
            }
            
            det *= a[col][col];
            
            for(int i = col + 1; i < orden; i++){
                double f = a[i][col] / a[col][col];
                for(int j = col; j < orden; j++){
                    a[i][j] -= f * a[col][j];
                }
            }
        }
        return det;
    }
    
    public MatrizCuadrada inversa(){
        
        double[][] a = copiarDatos();
        double [][] inv = new double[orden][orden];
        for(int i = 0; i < orden; i++){
            inv[i][i] = 1.0;
        }
        
        for(int col = 0; col < orden; col++){
            
            int piv = col;
            for(int i = col + 1; i < orden; i++){
                if(Math.abs(a[i][col]) > Math.abs(a[piv][col])){
                    piv = i;
                }
            }
            
            if(Math.abs(a[piv][col]) < EPS){
                throw new ArithmeticException("La matriz es singular: no tiene inversa.");
            }
            
            if(piv != col){
                intercambiarFilas(a,piv,col);
                intercambiarFilas(inv,piv,col);
            }
            
            double p = a[col][col];
            for(int j = 0; j < orden; j++){
                a[col][j] /= p;
                inv[col][j] /= p;
            }
            
            for(int i = 0; i < orden; i++){
                if(i == col){
                    continue;
                }
                double f = a[i][col];
                if(f == 0){
                    continue;
                }
                for(int j = 0; j < orden;j++){
                    a[i][j] -= f * a[col][j];
                    inv[i][j] -= f * inv[col][j];
                }
            }
            
        }
        
        return new MatrizCuadrada(inv);
        
    }
    
    public static String formato(double valor){
        if(Math.abs(valor) < 0.005){
            valor = 0.0;
        }
        return String.format("%.2f", valor);
    }
    
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < orden; i++){
            for(int j = 0; j < orden;j++){
                sb.append(String.format("%.2f", datos[i][j]));
                if(j < orden - 1){
                    sb.append("   ");
                }
            }
            
            if(i < orden - 1){
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    
}
