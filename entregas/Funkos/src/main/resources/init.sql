-- Cuidado que cada SGDB tiene su forma de crear tablas y datos
DROP TABLE IF EXISTS FUNKOS;
CREATE TABLE IF NOT EXISTS FUNKOS (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    uuid UUID NOT NULL DEFAULT RANDOM_UUID(),
    nombre VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    precio DOUBLE PRECISION NOT NULL ,
    fecha_lanzamiento DATE  NOT NULL,
    create_at DATE  NOT NULL,
    update_at DATE  NOT NULL
);