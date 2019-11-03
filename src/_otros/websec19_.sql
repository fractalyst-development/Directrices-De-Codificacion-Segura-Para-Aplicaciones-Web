-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: websec19
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `a1_inyeccion`
--

DROP TABLE IF EXISTS `a1_inyeccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `a1_inyeccion` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombreusuario` varchar(45) DEFAULT NULL,
  `contrasenha` varchar(250) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido_paterno` varchar(45) DEFAULT NULL,
  `apellido_materno` varchar(45) DEFAULT NULL,
  `pregunta_secreta` varchar(300) DEFAULT NULL,
  `respuesta_secreta` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `nombreusuario` (`nombreusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a1_inyeccion`
--

LOCK TABLES `a1_inyeccion` WRITE;
/*!40000 ALTER TABLE `a1_inyeccion` DISABLE KEYS */;
INSERT INTO `a1_inyeccion` VALUES (1,'usuario1@testmail.com','pwd1','Usuario1','Apellido1','Materno1','¿Cuál es tu color favorito?','azul'),(2,'usuario2@testmail.com','pwd2','Usuario2','Apellido2','Materno2','¿Cuál es tu color favorito?','rojo'),(3,'usuario3@testmail.com','pwd3','Usuario3','Apellido3','Materno3','¿Cuál es tu color favorito?','verde');
/*!40000 ALTER TABLE `a1_inyeccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `a2_autenticacion`
--

DROP TABLE IF EXISTS `a2_autenticacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `a2_autenticacion` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombreusuario` varchar(45) DEFAULT NULL,
  `contrasenha` varchar(250) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido_paterno` varchar(45) DEFAULT NULL,
  `apellido_materno` varchar(45) DEFAULT NULL,
  `pregunta_secreta` varchar(300) DEFAULT NULL,
  `respuesta_secreta` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `nombreusuario` (`nombreusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a2_autenticacion`
--

LOCK TABLES `a2_autenticacion` WRITE;
/*!40000 ALTER TABLE `a2_autenticacion` DISABLE KEYS */;
INSERT INTO `a2_autenticacion` VALUES (1,'usuario1@testmail.com','pwd1','Usuario1','Apellido1','Materno1','¿Cuál es tu color favorito?','azul'),(2,'usuario2@testmail.com','pwd2','Usuario2','Apellido2','Materno2','¿Cuál es tu color favorito?','rojo'),(3,'usuario3@testmail.com','pwd3','Usuario3','Apellido3','Materno3','¿Cuál es tu color favorito?','verde');
/*!40000 ALTER TABLE `a2_autenticacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-20  1:46:01



CREATE TABLE `websec19`.`a3_datos` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombreusuario` varchar(45) DEFAULT NULL,
  `contrasenha` varchar(500) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido_paterno` varchar(45) DEFAULT NULL,
  `apellido_materno` varchar(45) DEFAULT NULL,
  `pregunta_secreta` varchar(300) DEFAULT NULL,
  `respuesta_secreta` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `nombreusuario` (`nombreusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

INSERT INTO `a3_datos` VALUES (1,'usuario1@testmail.com','pwd1','Usuario1','Apellido1','Materno1','¿Cuál es tu color favorito?','azul'),(2,'usuario2@testmail.com','pwd2','Usuario2','Apellido2','Materno2','¿Cuál es tu color favorito?','rojo'),(3,'usuario3@testmail.com','pwd3','Usuario3','Apellido3','Materno3','¿Cuál es tu color favorito?','verde');

