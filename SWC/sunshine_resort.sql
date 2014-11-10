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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking` (
  `bookingNo` int(11) NOT NULL,
  `cottageNo` int(11) NOT NULL,
  `customerNo` int(11) DEFAULT NULL,
  `typeOfBooking` varchar(45) NOT NULL,
  `rentalPrice` varchar(45) NOT NULL,
  `weekFrom` varchar(45) NOT NULL,
  `weekTo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`bookingNo`),
  KEY `cottage_fk_idx` (`cottageNo`),
  KEY `customer_fk_idx` (`customerNo`),
  CONSTRAINT `booking_customer_fk` FOREIGN KEY (`customerNo`) REFERENCES `customer` (`customerNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cottage_fk` FOREIGN KEY (`cottageNo`) REFERENCES `cottage` (`cottageNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `customerNo` int(11) NOT NULL,
  `companyName` varchar(45) NOT NULL,
  `contactPersonFname` varchar(45) NOT NULL,
  `contactPerrsonLname` varchar(45) NOT NULL,
  PRIMARY KEY (`customerNo`),
  CONSTRAINT `customerC_fk` FOREIGN KEY (`customerNo`) REFERENCES `customer` (`customerNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage`
--

DROP TABLE IF EXISTS `cottage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cottage` (
  `cottageNo` int(11) NOT NULL AUTO_INCREMENT,
  `noOfBed` int(11) NOT NULL,
  `typeOfCottage` varchar(45) NOT NULL,
  PRIMARY KEY (`cottageNo`),
  KEY `cottageType_idx` (`typeOfCottage`,`noOfBed`),
  CONSTRAINT `cottage_type_fk` FOREIGN KEY (`typeOfCottage`, `noOfBed`) REFERENCES `cottage_type` (`typeOfCottage`, `noOfBed`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage`
--

LOCK TABLES `cottage` WRITE;
/*!40000 ALTER TABLE `cottage` DISABLE KEYS */;
INSERT INTO `cottage` VALUES (5,4,'Luxury'),(6,4,'Luxury'),(7,4,'Luxury'),(8,4,'Luxury'),(17,6,'Luxury'),(18,6,'Luxury'),(19,6,'Luxury'),(20,6,'Luxury'),(27,8,'Luxury'),(28,8,'Luxury'),(29,8,'Luxury'),(30,8,'Luxury'),(1,4,'Standard'),(2,4,'Standard'),(3,4,'Standard'),(4,4,'Standard'),(9,6,'Standard'),(10,6,'Standard'),(11,6,'Standard'),(12,6,'Standard'),(13,6,'Standard'),(14,6,'Standard'),(15,6,'Standard'),(16,6,'Standard'),(21,8,'Standard'),(22,8,'Standard'),(23,8,'Standard'),(24,8,'Standard'),(25,8,'Standard'),(26,8,'Standard'),(51,8,'Standard'),(52,8,'Standard'),(31,12,'Standard'),(32,12,'Standard');
/*!40000 ALTER TABLE `cottage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage_type`
--

DROP TABLE IF EXISTS `cottage_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cottage_type` (
  `noOfBed` int(11) NOT NULL,
  `typeOfCottage` varchar(45) NOT NULL,
  `cottagePrice` decimal(20,0) NOT NULL,
  PRIMARY KEY (`typeOfCottage`,`noOfBed`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage_type`
--

LOCK TABLES `cottage_type` WRITE;
/*!40000 ALTER TABLE `cottage_type` DISABLE KEYS */;
INSERT INTO `cottage_type` VALUES (1,'economy',23),(4,'Luxury',1000),(6,'Luxury',1200),(8,'Luxury',1400),(4,'Standard',700),(6,'Standard',900),(8,'Standard',1100),(12,'Standard',1500),(1,'test',2);
/*!40000 ALTER TABLE `cottage_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customerNo` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `zip` int(11) NOT NULL,
  `customerType` varchar(45) NOT NULL,
  `street` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customerNo`),
  KEY `postal_fk_idx` (`zip`),
  CONSTRAINT `pastal_fk` FOREIGN KEY (`zip`) REFERENCES `postal` (`zip`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `bookingNo` int(11) NOT NULL,
  `typeOfPayment` varchar(45) DEFAULT NULL,
  `paid` bit(1) DEFAULT NULL,
  KEY `booking_fk_idx` (`bookingNo`),
  CONSTRAINT `booking_fk` FOREIGN KEY (`bookingNo`) REFERENCES `booking` (`bookingNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postal`
--

DROP TABLE IF EXISTS `postal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postal` (
  `zip` int(11) NOT NULL,
  `city` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`zip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postal`
--

LOCK TABLES `postal` WRITE;
/*!40000 ALTER TABLE `postal` DISABLE KEYS */;
/*!40000 ALTER TABLE `postal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tourist`
--

DROP TABLE IF EXISTS `tourist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tourist` (
  `customerNo` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  PRIMARY KEY (`customerNo`),
  CONSTRAINT `tourist_customer_fk` FOREIGN KEY (`customerNo`) REFERENCES `customer` (`customerNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tourist`
--

LOCK TABLES `tourist` WRITE;
/*!40000 ALTER TABLE `tourist` DISABLE KEYS */;
/*!40000 ALTER TABLE `tourist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-09 15:24:49
