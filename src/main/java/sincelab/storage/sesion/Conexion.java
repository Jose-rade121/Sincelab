package sincelab.storage;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Abre conexiones a MariaDB con los datos del .env (DB_URL, DB_USER, DB_APP_PASSWORD).
 * - Busca el .env en el directorio desde donde se ejecuta (la raiz del proyecto).
 * - Si no hay .env, usa las variables de entorno del sistema.
 * - Si falta alguna variable, falla con un mensaje claro.
 */
public final class Conexion {

    private static Dotenv env;

    private Conexion() {
    }

    public static Connection obtener() throws SQLException {
        return DriverManager.getConnection(
                valor("DB_URL"), valor("DB_USER"), valor("DB_APP_PASSWORD"));
    }

    private static synchronized String valor(String clave) {
        if (env == null) {
            env = Dotenv.configure().ignoreIfMissing().load();
        }
        String v = env.get(clave);
        if (v == null || v.isBlank()) {
            throw new IllegalStateException("Falta " + clave
                    + ". Copia .env.example a .env en la raiz del proyecto y completa los valores.");
        }
        return v;
    }
}
