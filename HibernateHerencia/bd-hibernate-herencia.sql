CREATE DATABASE  IF NOT EXISTS `bd-hibernate-herencia` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bd-hibernate-herencia`;
-- MySQL dump 10.13 Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost Database: bd-hibernate-herencia
-- ------------------------------------------------------
-- Server version 5.7.18-0ubuntu0.16.04.1
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
--
-- Table structure for table `cliente`
--
DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
`idCliente` int(11) NOT NULL AUTO_INCREMENT,
`nroCliente` varchar(10) NOT NULL,
PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `cliente`
--
LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'11111111'),(2,'22222222');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `personafisica`
--
DROP TABLE IF EXISTS `personafisica`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personafisica` (
`idPersonaFisica` int(11) NOT NULL,
`apellido` varchar(30) NOT NULL,
`nombre` varchar(45) NOT NULL,
`dni` int(11) NOT NULL,
PRIMARY KEY (`idPersonaFisica`),
CONSTRAINT `fk_personafisica_1` FOREIGN KEY (`idPersonaFisica`) REFERENCES `cliente` (`idCliente`) ON
DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `personafisica`
--
LOCK TABLES `personafisica` WRITE;
/*!40000 ALTER TABLE `personafisica` DISABLE KEYS */;
INSERT INTO `personafisica` VALUES (1,'Lopez','Juan',1111111);
/*!40000 ALTER TABLE `personafisica` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `personajuridica`
--
DROP TABLE IF EXISTS `personajuridica`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personajuridica` (
`idPersonaJuridica` int(11) NOT NULL,
`razonSocial` varchar(25) NOT NULL,
`cuit` varchar(11) NOT NULL,
PRIMARY KEY (`idPersonaJuridica`),
CONSTRAINT `fk_personajuridica_1` FOREIGN KEY (`idPersonaJuridica`) REFERENCES `cliente` (`idCliente`) ON
DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
--

-- Dumping data for table `personajuridica`
--
LOCK TABLES `personajuridica` WRITE;
/*!40000 ALTER TABLE `personajuridica` DISABLE KEYS */;
INSERT INTO `personajuridica` VALUES (2,'UNLa','300000001');
/*!40000 ALTER TABLE `personajuridica` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
-- Dump completed
