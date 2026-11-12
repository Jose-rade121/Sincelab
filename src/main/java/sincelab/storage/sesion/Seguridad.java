package sincelab.storage;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Guarda y verifica contrasenas con PBKDF2 (viene con Java, sin dependencias).
 * En la base de datos solo se guarda el hash, nunca la contrasena.
 * Usa JPasswordField.getPassword(), que devuelve char[].
 */
public final class Seguridad {

    private static final int ITERACIONES = 600_000;

    private Seguridad() {
    }

    /** Devuelve "iteraciones:sal:hash", listo para guardar en password_hash. */
    public static String hashear(char[] clave) {
        byte[] sal = new byte[16];
        new SecureRandom().nextBytes(sal);
        byte[] hash = pbkdf2(clave, sal, ITERACIONES);
        return ITERACIONES + ":" + Base64.getEncoder().encodeToString(sal)
                + ":" + Base64.getEncoder().encodeToString(hash);
    }

    /** Compara la clave escrita con el hash guardado. */
    public static boolean verificar(char[] clave, String guardado) {
        try {
            String[] partes = guardado.split(":");
            int iter = Integer.parseInt(partes[0]);
            byte[] sal = Base64.getDecoder().decode(partes[1]);
            byte[] esperado = Base64.getDecoder().decode(partes[2]);
            return MessageDigest.isEqual(pbkdf2(clave, sal, iter), esperado);
        } catch (RuntimeException e) {
            return false;
        }
    }

    private static byte[] pbkdf2(char[] clave, byte[] sal, int iter) {
        try {
            PBEKeySpec spec = new PBEKeySpec(clave, sal, iter, 256);
            return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
                    .generateSecret(spec).getEncoded();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
