-- MySQL dump 10.16  Distrib 10.1.21-MariaDB, for Win32 (AMD64)
-- Host: localhost    Database: localhost
-- Server version	10.1.21-MariaDB
-- ------------------------------------------------------

DROP DATABASE vdata IF EXISTS;
CREATE DATABASE vdata;
Use vdata;

--------------------------------------------------------
-- Table structure for table `client`
--------------------------------------------------------
DROP TABLE IF EXISTS client;

CREATE TABLE client (
  `id_client` int(11) NOT NULL,
  `type` enum('NATURAL','LEGAL') NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `building` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE KEY `id_client_UNIQUE` (`id_client`),
  CONSTRAINT `fk_client` FOREIGN KEY (`id_client`) REFERENCES `contract` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=cp1251;

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'NATURAL','Evstahyi',' Evstahyevich',' Sas','Kharkiv','Nauky','221-b'),(3,'NATURAL','dsaf','sdaf','asdf','asdf','asfd','4'),(4,'NATURAL','Vasilyev','Vasilyi','Vasilyevich','Kyiv','Poetry','35');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;


--------------------------------------------------------
-- Table structure for table `client`
--------------------------------------------------------
DROP TABLE IF EXISTS client;

CREATE TABLE client (
  `id_client` int(11) NOT NULL,
  `type` enum('NATURAL','LEGAL') NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `building` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE KEY `id_client_UNIQUE` (`id_client`),
  CONSTRAINT `fk_client` FOREIGN KEY (`id_client`) REFERENCES `contract` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=cp1251;

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'NATURAL','Evstahyi',' Evstahyevich',' Sas','Kharkiv','Nauky','221-b'),(3,'NATURAL','dsaf','sdaf','asdf','asdf','asfd','4'),(4,'NATURAL','Vasilyev','Vasilyi','Vasilyevich','Kyiv','Poetry','35');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--------------------------------------------------------
-- Table structure for table `client`
--------------------------------------------------------
DROP TABLE IF EXISTS client;

CREATE TABLE client (
  `id_client` int(11) NOT NULL,
  `type` enum('NATURAL','LEGAL') NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `building` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE KEY `id_client_UNIQUE` (`id_client`),
  CONSTRAINT `fk_client` FOREIGN KEY (`id_client`) REFERENCES `contract` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=cp1251;

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'NATURAL','Evstahyi',' Evstahyevich',' Sas','Kharkiv','Nauky','221-b'),(3,'NATURAL','dsaf','sdaf','asdf','asdf','asfd','4'),(4,'NATURAL','Vasilyev','Vasilyi','Vasilyevich','Kyiv','Poetry','35');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--------------------------------------------------------
-- Table structure for table `contract`
--------------------------------------------------------

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract` (
  `id_contract` int(11) NOT NULL,
  `accept_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `persons_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_contract`),
  UNIQUE KEY `id` (`id_contract`),
  KEY `fk_client_idx` (`client_id`),
  KEY `fk_persons_idx` (`persons_id`)
) ENGINE=InnoDB DEFAULT CHARSET=cp1251;


LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,'1997-12-12','2017-08-23','2018-08-23',1,8),(3,'2013-01-01','2013-01-01','2013-01-01',3,3),(10,'2018-09-01','2018-10-01','2028-12-31',4,4);
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--------------------------------------------------------
-- Table structure for table `insured_person`
--------------------------------------------------------

DROP TABLE IF EXISTS `insured_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insured_person` (
  `id_person` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `bth_date` date DEFAULT NULL,
  `insurance_cost` double NOT NULL DEFAULT '0',
  `person_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_person`),
  UNIQUE KEY `id_person_UNIQUE` (`id_person`),
  KEY `fk_persons` (`person_number`),
  CONSTRAINT `fk_persons` FOREIGN KEY (`person_number`) REFERENCES `contract` (`persons_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=cp1251;


--------------------------------------------------------

LOCK TABLES `insured_person` WRITE;
/*!40000 ALTER TABLE `insured_person` DISABLE KEYS */;
INSERT INTO `insured_person` VALUES (2,'Basilyi','Bsilevich','Basilyev','2018-12-01',22.8,8),(28,'Aasilyi','Aasilevich','Aasilyev','2018-09-01',223.5,4),(29,'Basilyi','Bsilevich','Basilyev','2018-12-01',22.8,4),(30,'Aasilyi','Aasilevich','Aasilyev','2018-09-01',223.5,4),(31,'Basilyi','Bsilevich','Basilyev','2018-12-01',22.8,4);
/*!40000 ALTER TABLE `insured_person` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


------------------------------------------------------
