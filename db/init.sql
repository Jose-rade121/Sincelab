-- SINCELAB: esquema de persistencia (MariaDB 10.5+ / 11)
-- Ruta en el repo: db/init.sql
-- La base "users" la crea Docker (MARIADB_DATABASE=users).
-- En una MariaDB local, creala antes (ver instrucciones) y luego corre este script.

USE users;

-- Cuentas de usuario. "usuario" es unico: un duplicado lanza el error 1062,
-- que UsuarioDAO.registrar() detecta. password_hash guarda "iteraciones:sal:hash".
CREATE TABLE IF NOT EXISTS usuarios (
  id            INT UNSIGNED NOT NULL AUTO_INCREMENT,
  usuario       VARCHAR(50)  NOT NULL,
  nombre        VARCHAR(100) NOT NULL,
  carrera       VARCHAR(100) NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  creado        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE KEY uq_usuarios_usuario (usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Un puntaje por persona y materia. La clave unica (usuario_id, materia) es la que
-- hace funcionar INSERT ... ON DUPLICATE KEY UPDATE puntos = GREATEST(...) y cubre
-- las consultas por usuario. El indice por materia acelera el ranking por materia.
CREATE TABLE IF NOT EXISTS puntajes (
  id         INT UNSIGNED NOT NULL AUTO_INCREMENT,
  usuario_id INT UNSIGNED NOT NULL,
  materia    VARCHAR(50)  NOT NULL,
  puntos     INT          NOT NULL,
  fecha      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE KEY uq_puntajes_usuario_materia (usuario_id, materia),
  KEY idx_puntajes_materia_puntos (materia, puntos),
  CONSTRAINT fk_puntajes_usuario FOREIGN KEY (usuario_id)
    REFERENCES usuarios (id) ON DELETE CASCADE,
  CONSTRAINT chk_puntajes_puntos CHECK (puntos >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
