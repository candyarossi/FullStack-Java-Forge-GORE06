-- Crear base de datos
CREATE DATABASE gore06;
USE gore06;

-- Crear tablas
CREATE TABLE ciudades (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) UNIQUE NOT NULL
);
CREATE TABLE personas (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(15) NOT NULL,
    apellido VARCHAR(15) NOT NULL,
    edad INT, 
    altura FLOAT,
    fecha_nacimiento DATE, -- yyyy-mm-dd
    ciudad INT,
    FOREIGN KEY(ciudad) REFERENCES ciudades(id)
);

-- Agregar datos
INSERT INTO ciudades (nombre) VALUES ('Tucuman');
INSERT INTO ciudades (nombre) VALUES ('Buenos Aires');
INSERT INTO ciudades (nombre) VALUES ('Santiago');
INSERT INTO ciudades (nombre) VALUES ('Caracas');
INSERT INTO ciudades (nombre) VALUES ('Mar del Plata');
INSERT INTO ciudades (nombre) VALUES ('Medellin');
INSERT INTO personas (nombre, apellido, edad, altura, fecha_nacimiento, ciudad) 
VALUES ('Lucas', 'Álvarez', 35, 1.72, '1985-03-29', 1),
	   ('Leo', 'Sierras', 24, 1.57, '1996-06-10', 1),
       ('Romina', 'Moyano', 56, 1.80, '1972-03-23', null),
       ('Antonio', 'López', 47, 1.65, '1981-09-15', 2),
       ('Cecilia', 'Gutiérrez', 44, 1.67, '1983-12-08', 4),
       ('Luis', 'Pinki', 22, 1.58, '1999-08-05', 5),
       ('Antonio', 'López', 38, 1.64, '1989-10-31', null),
       ('Luis', 'Barboza', 53, 1.72, '1973-11-09', null),
       ('Carmen', 'Solano', 75, 1.56, '1945-09-02', 1),
       ('Diego', 'Palacios', 35, 1.76, '1990-01-26', 2);

-- Mostrar datos
SELECT * FROM ciudades;
SELECT * FROM personas;
SELECT nombre, apellido FROM personas;

-- WHERE
SELECT * FROM personas WHERE id = 3;
SELECT * FROM personas WHERE nombre = 'Antonio' AND apellido = 'López';
SELECT * FROM personas WHERE edad > 40;
SELECT * FROM personas WHERE NOT ciudad = 1;

-- ORDER BY
SELECT * FROM personas ORDER BY nombre ASC;
SELECT * FROM personas ORDER BY fecha_nacimiento DESC;
SELECT * FROM personas WHERE edad > 40 ORDER BY apellido DESC;

-- GROUP BY 
SELECT ciudad, count(*) AS cantidad_de_personas FROM personas GROUP BY ciudad;

-- LIMIT / OFFSET
SELECT * FROM personas LIMIT 5 OFFSET 2;

-- LIKE / ILIKE / NOT LIKE
SELECT * FROM personas WHERE nombre LIKE '%toni%';
SELECT * FROM personas WHERE nombre NOT LIKE '%toni%';

-- Actualizar datos
UPDATE personas SET edad = 45, ciudad = 5 WHERE id = 5;
SELECT * FROM personas;

-- Eliminar datos
DELETE FROM personas WHERE id = 8;
SELECT * FROM personas;

-- Funciones Integradas
-- Manipulación de Strings
SELECT concat(apellido, ', ', nombre) AS nombre_completo, edad, altura, fecha_nacimiento FROM personas;
SELECT nombre, length(nombre) AS length_nombre FROM personas;
SELECT lower(nombre) AS nombre, upper(apellido) AS apellido FROM personas;
-- Funciones numéricas
SELECT sum(edad) AS suma_edades FROM personas;
SELECT avg(edad) AS promedio_edades FROM personas;
SELECT min(altura) AS min_altura, max(altura) AS max_altura FROM personas;
SELECT nombre, apellido, round(altura, 1) AS altura FROM personas;
SELECT count(*) AS cantidad_de_antonios FROM personas WHERE nombre = "Antonio";
-- Funciones Fecha y Hora
-- yyyy-mm-dd
SELECT nombre, date_format(fecha_nacimiento, '%d-%m-%Y') AS nacimiento FROM personas;
SELECT nombre, day(fecha_nacimiento) AS dia, month(fecha_nacimiento) AS mes, year(fecha_nacimiento) AS año FROM personas;
-- Control de Flujos
SELECT nombre, apellido, edad, fecha_nacimiento, if(ciudad, ciudad, 'N/A') AS ciudad FROM personas;

-- JOINS
SELECT p.nombre, p.apellido, p.edad, p.altura, p.fecha_nacimiento, c.nombre 
FROM personas p INNER JOIN ciudades c ON c.id = p.ciudad;
-- Equivalente a:
SELECT p.nombre, p.apellido, p.edad, p.altura, p.fecha_nacimiento, c.nombre 
FROM personas p JOIN ciudades c ON p.ciudad = c.id;

SELECT p.nombre, p.apellido, p.edad, p.altura, p.fecha_nacimiento, c.nombre 
FROM personas p LEFT JOIN ciudades c ON p.ciudad = c.id;

SELECT p.nombre, p.apellido, p.edad, p.altura, p.fecha_nacimiento, c.nombre 
FROM personas p RIGHT JOIN ciudades c ON p.ciudad = c.id;

SELECT p.nombre, p.apellido, p.edad, p.altura, p.fecha_nacimiento, c.nombre 
FROM personas p FULL JOIN ciudades c;
-- Equivalente a:
SELECT p.nombre, p.apellido, p.edad, p.altura, p.fecha_nacimiento, c.nombre 
FROM personas p CROSS JOIN ciudades c;
