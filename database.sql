-- MySQL dump 10.13  Distrib 5.5.38, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: socgenhackathon
-- ------------------------------------------------------
-- Server version	5.5.38-0ubuntu0.12.04.1

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
-- Table structure for table `hdfcbank`
--

DROP TABLE IF EXISTS `hdfcbank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hdfcbank` (
  `CustomerID` varchar(45) NOT NULL,
  `AccountNo` varchar(45) DEFAULT NULL,
  `Balance` int(50) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hdfcbank`
--

LOCK TABLES `hdfcbank` WRITE;
/*!40000 ALTER TABLE `hdfcbank` DISABLE KEYS */;
INSERT INTO `hdfcbank` VALUES ('12345','1234567890',4000,'75844940'),('23456','9876543210',10000,'2126784135');
/*!40000 ALTER TABLE `hdfcbank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hdfctoken`
--

DROP TABLE IF EXISTS `hdfctoken`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hdfctoken` (
  `TokenID` varchar(200) DEFAULT NULL,
  `CustomerID` varchar(45) NOT NULL,
  `AccountNo` varchar(45) DEFAULT NULL,
  `IssuedUsedDate` date DEFAULT NULL,
  `ExpiryDate` date DEFAULT NULL,
  `ActiveInactive` varchar(45) DEFAULT NULL,
  `GeneratedUsed` varchar(45) DEFAULT NULL,
  `TokenType` varchar(45) DEFAULT NULL,
  `Amount` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hdfctoken`
--

LOCK TABLES `hdfctoken` WRITE;
/*!40000 ALTER TABLE `hdfctoken` DISABLE KEYS */;
INSERT INTO `hdfctoken` VALUES ('123','Anish','123','2014-11-09',NULL,'A','G','General',12),('123','Anish','123','2014-11-09',NULL,'A','G','General',12),('7BwJO1gvhg+KfffuqrP7NWGw5ZLf8OiTM4NWTL1ksmUfPMDncHoH8Q==','1234567890','1234567890','2014-11-09',NULL,'A','G','General',10000),('7BwJO1gvhg9QJgyKbGmmgxx7t3dob6ifE1kPyruSCG2YL2NJib2mUA==','1234567890','1234567890','2014-11-09',NULL,'A','G','General',1000),('7BwJO1gvhg+KfffuqrP7NWGw5ZLf8OiTsV/jHZjXLS+gpPIeZFuHgA==','1234567890','1234567890','2014-11-09',NULL,'A','G','General',10000),('7BwJO1gvhg/BmP3I/utqDMhnjhi08zdJ54mweXq/igijrs6TR6fHFg==','1234567890','1234567890','2014-11-09',NULL,'A','G','General',100),('7BwJO1gvhg9QJgyKbGmmgxx7t3dob6ifE1kPyruSCG1VVZbWmmBLpg==','1234567890','1234567890','2014-11-09',NULL,'A','G','General',1000),('7BwJO1gvhg9x4AzNBO1tgIlZlfLUKDHGYBqFKds/yz5pQRsWsGZs/w==','1234567890','1234567890','2014-11-09',NULL,'A','G','General',900),('7BwJO1gvhg/BmP3I/utqDMhnjhi08zdJBsaWy0gwE5myEPEoSDg8NQ==','1234567890','1234567890','2014-11-09',NULL,'A','G','General',100),('7BwJO1gvhg9QJgyKbGmmgxx7t3dob6ifE1kPyruSCG2yTGG3NjxmFQ==','1234567890','1234567890','2014-11-09',NULL,'A','G','General',1000),('7BwJO1gvhg9QJgyKbGmmgxx7t3dob6ifjRSeseJSyN7HbfkUo5Xo9Q==','1234567890','1234567890','2014-11-09',NULL,'A','G','General',1000),('7BwJO1gvhg9QJgyKbGmmgxx7t3dob6ifjRSeseJSyN4bRm9KsQ3EGA==','1234567890','1234567890','2014-11-09',NULL,'A','G','General',1000),('7BwJO1gvhg9QJgyKbGmmgxx7t3dob6ifjRSeseJSyN6osiuhK+RlsA==','1234567890','1234567890','2014-11-09',NULL,'A','G','General',1000),('7BwJO1gvhg9QJgyKbGmmgxx7t3dob6ifjRSeseJSyN7f37UoHcLYXg==','1234567890','1234567890','2014-11-09',NULL,'A','G','General',1000),('7BwJO1gvhg9QJgyKbGmmgxx7t3dob6ifjRSeseJSyN5s4Af/Nscu4Q==','1234567890','1234567890','2014-11-09',NULL,'A','G','General',1000),('7BwJO1gvhg9QJgyKbGmmgxx7t3dob6ifjRSeseJSyN5alscUiLeBFQ==','1234567890','1234567890','2014-11-09',NULL,'A','G','General',1000);
/*!40000 ALTER TABLE `hdfctoken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `icicibank`
--

DROP TABLE IF EXISTS `icicibank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `icicibank` (
  `CustomerID` varchar(45) NOT NULL,
  `AccountNo` varchar(45) DEFAULT NULL,
  `Balance` int(50) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `icicibank`
--

LOCK TABLES `icicibank` WRITE;
/*!40000 ALTER TABLE `icicibank` DISABLE KEYS */;
INSERT INTO `icicibank` VALUES ('87654','3243243234',30000,'1453071411'),('98765','1213323210',40000,'1853303991');
/*!40000 ALTER TABLE `icicibank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `icicitoken`
--

DROP TABLE IF EXISTS `icicitoken`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `icicitoken` (
  `TokenID` varchar(45) NOT NULL,
  `CustomerID` varchar(45) DEFAULT NULL,
  `AccountNo` int(50) DEFAULT NULL,
  `IssuedUsedDate` date DEFAULT NULL,
  `ExpiryDate` date DEFAULT NULL,
  `ActiveInactive` varchar(45) DEFAULT NULL,
  `GeneratedUsed` varchar(45) DEFAULT NULL,
  `TokenType` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `icicitoken`
--

LOCK TABLES `icicitoken` WRITE;
/*!40000 ALTER TABLE `icicitoken` DISABLE KEYS */;
/*!40000 ALTER TABLE `icicitoken` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-09  5:40:17
