-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb_cinema
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `halls`
--

DROP TABLE IF EXISTS `halls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `halls` (
  `idhalls` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `num_rows` int(11) NOT NULL,
  `num_col` int(11) NOT NULL,
  PRIMARY KEY (`idhalls`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `halls`
--

LOCK TABLES `halls` WRITE;
/*!40000 ALTER TABLE `halls` DISABLE KEYS */;
/*!40000 ALTER TABLE `halls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies` (
  `idmovies` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `duration` time(4) NOT NULL,
  `start_data` date NOT NULL,
  `end_data` date NOT NULL,
  `idtheatre` int(11) NOT NULL,
  `poster` longblob,
  PRIMARY KEY (`idmovies`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seats`
--

DROP TABLE IF EXISTS `seats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seats` (
  `idseats` int(11) NOT NULL AUTO_INCREMENT,
  `idhall` int(11) NOT NULL,
  `num_row` int(11) NOT NULL,
  `num_seat` int(11) NOT NULL,
  PRIMARY KEY (`idseats`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seats`
--

LOCK TABLES `seats` WRITE;
/*!40000 ALTER TABLE `seats` DISABLE KEYS */;
/*!40000 ALTER TABLE `seats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sessions` (
  `idsessions` int(11) NOT NULL AUTO_INCREMENT,
  `idhall` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `idmovies` int(11) NOT NULL,
  `ticket_price` double DEFAULT NULL,
  PRIMARY KEY (`idsessions`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theaters`
--

DROP TABLE IF EXISTS `theaters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theaters` (
  `idtheater` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(64) NOT NULL,
  PRIMARY KEY (`idtheater`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theaters`
--

LOCK TABLES `theaters` WRITE;
/*!40000 ALTER TABLE `theaters` DISABLE KEYS */;
INSERT INTO `theaters` VALUES (1,'Муви1','ул. Дмитрия Ульянова, 16'),(2,'Муви2','Яузская ул., 11/6 строение 11'),(3,'Муви3','Подкопаевский пер., 2/6'),(4,'Муви4','ул. Пречистенка, 22/2'),(5,'Муви5','Рогожский Вал ул., 7'),(6,'Муви6','ул. Маленковская, 7');
/*!40000 ALTER TABLE `theaters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tickets` (
  `idtickets` int(11) NOT NULL AUTO_INCREMENT,
  `date_release` datetime NOT NULL,
  `idsessions` int(11) NOT NULL,
  `idseats` int(11) NOT NULL,
  `ispayed` binary(2) NOT NULL,
  `isbooked` binary(2) NOT NULL,
  PRIMARY KEY (`idtickets`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-19  0:57:52
