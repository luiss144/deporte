-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-09-2021 a las 23:26:45
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `deporte`
--
CREATE DATABASE IF NOT EXISTS `deporte` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `deporte`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `canchas`
--

CREATE TABLE `canchas` (
  `ID_CANCHA` int(4) NOT NULL,
  `NOMBRE_CANCHA` text CHARACTER SET latin1 NOT NULL,
  `DIRECCION` text CHARACTER SET latin1 NOT NULL,
  `ESTADO` text CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `canchas`
--

INSERT INTO `canchas` (`ID_CANCHA`, `NOMBRE_CANCHA`, `DIRECCION`, `ESTADO`) VALUES
(1, 'CANCHA JOSE TOMAS ARTETA(VILLA ESTADIO)', 'CARRERA 2 CALLE 4', 'DISPONIBLE'),
(2, 'PARQUE ANGEL ALFONSO MOLINA', 'CALLE 7 CARRERA 8', 'DISPONIBLE'),
(3, 'CANCHA PITAL DE SACO', 'SACO', 'DISPONIBLE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `ID_HORARIO` text CHARACTER SET latin1 NOT NULL,
  `NOMBRE_PRESTADOR` text CHARACTER SET latin1 NOT NULL,
  `CEDULA_PRESTADOR` text CHARACTER SET latin1 NOT NULL,
  `TELEFONO_PRESTADOR` text CHARACTER SET latin1 NOT NULL,
  `ID_CANCHA` int(4) NOT NULL,
  `NOMBRE_CANCHA` text CHARACTER SET latin1 NOT NULL,
  `DIA_PRESTAMO` date NOT NULL,
  `INICIO_HORARIO` time NOT NULL,
  `FINAL_HORARIO` time NOT NULL,
  `ESTADO_PRESTAMO` text CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `CEDULA` int(11) NOT NULL,
  `NOMBRE` text CHARACTER SET latin1 NOT NULL,
  `CONTRASEÑA` text CHARACTER SET latin1 NOT NULL,
  `TELEFONO` text CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`CEDULA`, `NOMBRE`, `CONTRASEÑA`, `TELEFONO`) VALUES
(48446841, 'kike miranda', '123456', '64866188'),
(72122984, 'LUIS	', 'LUIS', '3147149603'),
(1002011496, 'LUIS SEBASTIAN', 'LUIS123456', '3147149603');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `canchas`
--
ALTER TABLE `canchas`
  ADD PRIMARY KEY (`ID_CANCHA`);

--
-- Indices de la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD KEY `ID_CANCHA` (`ID_CANCHA`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`CEDULA`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD CONSTRAINT `horarios_ibfk_1` FOREIGN KEY (`ID_CANCHA`) REFERENCES `canchas` (`ID_CANCHA`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
