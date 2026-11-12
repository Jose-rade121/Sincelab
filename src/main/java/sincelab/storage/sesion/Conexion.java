package sincelab.storage;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Una sola clase para abrir conexiones, leyendo los datos del .env. */
public final class Conexion {

    private Conexion() {
    }

    public static Connection obtener() throws SQLException {
        Dotenv env = Dotenv.load();
        return DriverManager.getConnection(
                env.get("DB_URL"), env.get("DB_USER"), env.get("DB_APP_PASSWORD"));
    }
}
