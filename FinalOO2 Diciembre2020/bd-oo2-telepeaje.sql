CREATE DATABASE  IF NOT EXISTS `bd-oo2-telepeaje` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bd-oo2-telepeaje`;

-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd-oo2-telepeaje
-- ------------------------------------------------------
-- Server version	5.5.39

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
-- Table structure for table `abonado`
--

DROP TABLE IF EXISTS `abonado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `abonado` (
  `idAbonado` int(11) NOT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `nombres` varchar(45) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAbonado`),
  CONSTRAINT `fk_abonado_persona` FOREIGN KEY (`idAbonado`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abonado`
--

LOCK TABLES `abonado` WRITE;
/*!40000 ALTER TABLE `abonado` DISABLE KEYS */;
INSERT INTO `abonado` VALUES (3,'Lopez','Juan',33333333),(4,'Rodriguez','Lara',44444444),(5,'Kafca','Dario',55555555),(6,'Gonzalez','Mariana',66666666);
/*!40000 ALTER TABLE `abonado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `idEmpresa` int(11) NOT NULL,
  `razonSocial` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEmpresa`),
  CONSTRAINT `fk_empresa_persona` FOREIGN KEY (`idEmpresa`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'Universidad Nacional de Lanus'),(2,'Universidad Nacional de Avellaneda');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL,
  `nroCuenta` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'827391'),(2,'174927'),(3,'364728'),(4,'462823'),(5,'947562'),(6,'382746');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rodado`
--

DROP TABLE IF EXISTS `rodado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rodado` (
  `idRodado` int(11) NOT NULL,
  `idPersona` int(11) DEFAULT NULL,
  `dominio` varchar(45) DEFAULT NULL,
  `categoria` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRodado`),
  KEY `fk_rod_pers_idx` (`idPersona`),
  CONSTRAINT `fk_rod_pers` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rodado`
--

LOCK TABLES `rodado` WRITE;
/*!40000 ALTER TABLE `rodado` DISABLE KEYS */;
INSERT INTO `rodado` VALUES (1,1,'AAA111',2),(2,3,'BBB222',3),(3,3,'CCC333',2),(4,4,'DDD444',3),(5,6,'EEE555',1);
/*!40000 ALTER TABLE `rodado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telepeaje`
--

DROP TABLE IF EXISTS `telepeaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telepeaje` (
  `idTelepeaje` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `idRodado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTelepeaje`),
  KEY `fk_telepeaje_rodado_idx` (`idRodado`),
  CONSTRAINT `fk_telepeaje_rodado` FOREIGN KEY (`idRodado`) REFERENCES `rodado` (`idRodado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telepeaje`
--

LOCK TABLES `telepeaje` WRITE;
/*!40000 ALTER TABLE `telepeaje` DISABLE KEYS */;
INSERT INTO `telepeaje` VALUES (1,'2020-11-01','10:20:10',120,1),(2,'2020-11-01','10:20:15',80,2),(3,'2020-11-01','10:20:15',180,3),(4,'2020-11-01','19:20:18',120,4),(5,'2020-11-01','20:40:12',80,5),(6,'2020-11-01','21:20:15',180,1),(7,'2020-11-03','07:30:10',120,2),(8,'2020-11-03','11:25:15',80,3),(9,'2020-11-03','06:31:12',180,3),(10,'2020-11-03','20:32:15',120,4),(11,'2020-11-03','19:21:17',80,5),(12,'2020-11-03','22:32:11',180,5);
/*!40000 ALTER TABLE `telepeaje` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-02 21:45:00
