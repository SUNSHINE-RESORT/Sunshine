CREATE DATABASE  IF NOT EXISTS `sunshine_resort` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sunshine_resort`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sunshine_resort
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `cottage`
--

DROP TABLE IF EXISTS `cottage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cottage` (
  `cottageNo` int(11) NOT NULL,
  `noOfBed` int(11) NOT NULL,
  `typeOfCottage` varchar(45) NOT NULL,
  PRIMARY KEY (`cottageNo`),
  KEY `cottageType_idx` (`typeOfCottage`,`noOfBed`),
  CONSTRAINT `cottage_type_fk` FOREIGN KEY (`typeOfCottage`, `noOfBed`) REFERENCES `cottage_type` (`typeOfCottage`, `noOfBed`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage`
--

LOCK TABLES `cottage` WRITE;
/*!40000 ALTER TABLE `cottage` DISABLE KEYS */;
INSERT INTO `cottage` VALUES (5,4,'Luxury'),(6,4,'Luxury'),(7,4,'Luxury'),(8,4,'Luxury'),(17,6,'Luxury'),(18,6,'Luxury'),(19,6,'Luxury'),(20,6,'Luxury'),(27,8,'Luxury'),(28,8,'Luxury'),(29,8,'Luxury'),(30,8,'Luxury'),(1,4,'Standard'),(2,4,'Standard'),(3,4,'Standard'),(4,4,'Standard'),(9,6,'Standard'),(10,6,'Standard'),(11,6,'Standard'),(12,6,'Standard'),(13,6,'Standard'),(14,6,'Standard'),(15,6,'Standard'),(16,6,'Standard'),(21,8,'Standard'),(22,8,'Standard'),(23,8,'Standard'),(24,8,'Standard'),(25,8,'Standard'),(26,8,'Standard'),(31,12,'Standard'),(32,12,'Standard');
/*!40000 ALTER TABLE `cottage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-23 18:31:53
