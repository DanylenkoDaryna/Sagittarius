-- MySQL dump 10.16  Distrib 10.1.21-MariaDB, for Win32 (AMD64)
-- Host: localhost    Database: localhost
-- Server version	10.1.21-MariaDB
-- ------------------------------------------------------

DROP DATABASE vdata IF EXISTS;
CREATE DATABASE vdata;
USE vdata;

--------------------------------------------------------
-- Table structure for table `client`
--------------------------------------------------------
--DROP TABLE IF EXISTS client;
--
--CREATE TABLE client (
--  `id_client` int(11) NOT NULL,
--  `type` enum('NATURAL','LEGAL') NOT NULL,
--  `name` varchar(45) DEFAULT NULL,
--  `middle_name` varchar(45) DEFAULT NULL,
--  `surname` varchar(45) DEFAULT NULL,
--  `city` varchar(45) DEFAULT NULL,
--  `street` varchar(45) DEFAULT NULL,
--  `building` varchar(45) DEFAULT NULL,
--  PRIMARY KEY (`id_client`),
--  UNIQUE KEY `id_client_UNIQUE` (`id_client`),
--  CONSTRAINT `fk_client` FOREIGN KEY (`id_client`) REFERENCES `contract` (`client_id`) ON DELETE CASCADE ON UPDATE CASCADE
--) ENGINE=InnoDB DEFAULT CHARSET=cp1251;
--
--LOCK TABLES `client` WRITE;
--/*!40000 ALTER TABLE `client` DISABLE KEYS */;
--INSERT INTO `client` VALUES (1,'NATURAL','Evstahyi',' Evstahyevich',' Sas','Kharkiv','Nauky','221-b'),(3,'NATURAL','dsaf','sdaf','asdf','asdf','asfd','4'),(4,'NATURAL','Vasilyev','Vasilyi','Vasilyevich','Kyiv','Poetry','35');
--/*!40000 ALTER TABLE `client` ENABLE KEYS */;
--UNLOCK TABLES;

--------------------------------------------------------
-- Table structure for table `client`
--------------------------------------------------------
DROP TABLE IF EXISTS client;

CREATE TABLE client (
  id INTEGER NOT NULL auto_increment UNIQUE PRIMARY KEY,
  client_state ENUM('PHYSICAL', 'JURIDICAL'),
  city VARCHAR(15) DEFAULT NULL,
  street VARCHAR(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=cp1251;

LOCK TABLES client WRITE;

INSERT INTO client VALUES (DEFAULT,'PHYSICAL','Kharkiv', 'Sumska St. 45a', 1),
                            (DEFAULT,'PHYSICAL','Kharkiv', 'Klochkivska St. 97b', 2),
                            (DEFAULT,'JURIDICAL','Detroit', 'Lincoln St. 2/3 ave',1);

UNLOCK TABLES;
--------------------------------------------------------
-- Table structure for table `client`
--------------------------------------------------------
DROP TABLE IF EXISTS physical_client;

CREATE TABLE physical_client (
  id INTEGER NOT NULL auto_increment UNIQUE PRIMARY KEY,
  first_name VARCHAR(20) DEFAULT NULL,
  mid_name VARCHAR(20) DEFAULT NULL,
  surname VARCHAR(20) DEFAULT NULL,
  id_client INT NOT NULL,
  CONSTRAINT fk_id_client FOREIGN KEY (id_client) REFERENCES client (id) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=cp1251;

LOCK TABLES physical_client WRITE;

INSERT INTO physical_client VALUES (DEFAULT,'Serhiy','Feliksovych','Semenets'),
                                    (DEFAULT,'Ganna','Oleksiivna','Burko');

UNLOCK TABLES;
--------------------------------------------------------
-- Table structure for table `client`
--------------------------------------------------------
DROP TABLE IF EXISTS juridical_client;

CREATE TABLE juridical_client (
  id INTEGER NOT NULL auto_increment UNIQUE PRIMARY KEY,
  company_name VARCHAR(45) DEFAULT NULL,
  id_client INT NOT NULL,
  CONSTRAINT fk_id_client FOREIGN KEY (id_client) REFERENCES client (id) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=cp1251;

LOCK TABLES juridical_client WRITE;

INSERT INTO juridical_client VALUES (DEFAULT,'Cyberlife LTD');

UNLOCK TABLES;

--------------------------------------------------------
-- Table structure for table `contract`
--------------------------------------------------------

DROP TABLE IF EXISTS contract;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

CREATE TABLE contract (
  id INTEGER NOT NULL auto_increment UNIQUE PRIMARY KEY,
  accept_date date DEFAULT NULL,
  start_date date DEFAULT NULL,
  end_date date DEFAULT NULL,
) ENGINE=InnoDB DEFAULT CHARSET=cp1251;


LOCK TABLES contract WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO contract VALUES (DEFAULT,'1997-12-12','2017-08-23','2018-08-23');
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--------------------------------------------------------
-- Table structure for table `insured_person`
--------------------------------------------------------

DROP TABLE IF EXISTS insured_person;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE insured_person (
  id INTEGER NOT NULL auto_increment UNIQUE PRIMARY KEY,
  unique_num INTEGER auto_increment UNIQUE NOT NULL,
  personal_cost double NOT NULL DEFAULT 0.0,
  client_id INTEGER NOT NULL,
  contract_id INTEGER NOT NULL,
  CONSTRAINT fk_id_client FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE ON UPDATE RESTRICT
  CONSTRAINT fk_id_contract FOREIGN KEY (contract_id) REFERENCES contract (id) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=cp1251;


--------------------------------------------------------

LOCK TABLES insured_person WRITE;
/*!40000 ALTER TABLE `insured_person` DISABLE KEYS */;
INSERT INTO insured_person VALUES (DEFAULT, DEFAULT, 422.8, 1, 1),
                                    (DEFAULT, DEFAULT, 223.5, 2, 1);
/*!40000 ALTER TABLE `insured_person` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


------------------------------------------------------

SELECT * FROM client;

SELECT * FROM contract;

SELECT * FROM insured_person;