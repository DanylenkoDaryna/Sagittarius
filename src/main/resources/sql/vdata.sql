-- MySQL dump 10.16  Distrib 10.1.21-MariaDB, for Win32 (AMD64)
-- Host: localhost    Database: localhost
-- Server version	10.1.21-MariaDB
-- ------------------------------------------------------
SET NAMES utf8;
DROP DATABASE IF EXISTS sagittarius;


CREATE DATABASE sagittarius CHARACTER SET utf8 COLLATE utf8_bin;
USE sagittarius;

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

--LOCK TABLES client WRITE;

INSERT INTO client VALUES (DEFAULT, 'PHYSICAL', 'Kharkiv', 'Sumska St. 45a'),
                            (DEFAULT, 'PHYSICAL', 'Kharkiv', 'Klochkivska St. 97b'),
                            (DEFAULT, 'JURIDICAL', 'Detroit', 'Lincoln St. 2/3 ave');

--UNLOCK TABLES;
--------------------------------------------------------
-- Table structure for table `client`
--------------------------------------------------------
DROP TABLE IF EXISTS physical_client;

CREATE TABLE physical_client (
  id INTEGER NOT NULL auto_increment UNIQUE PRIMARY KEY,
  first_name VARCHAR(15) DEFAULT NULL,
  mid_name VARCHAR(15) DEFAULT NULL,
  surname VARCHAR(15) DEFAULT NULL,
  id_client INT NOT NULL,
  CONSTRAINT 'fk_id_client'
    FOREIGN KEY (id_client) REFERENCES client (id)
    ON DELETE CASCADE
    ON UPDATE RESTRICT
) ENGINE=InnoDB;


--LOCK TABLES physical_client WRITE;

INSERT INTO physical_client VALUES (DEFAULT, 'Serhiy', 'Feliksovych', 'Semenets', 1),
                                    (DEFAULT, 'Ganna', 'Oleksiivna', 'Burko', 2);

--UNLOCK TABLES;
--------------------------------------------------------
-- Table structure for table `client`
--------------------------------------------------------
DROP TABLE IF EXISTS juridical_client;

CREATE TABLE juridical_client (
  id INTEGER NOT NULL auto_increment UNIQUE PRIMARY KEY,
  company_name VARCHAR(45) DEFAULT NULL,
  id_client INT NOT NULL,
  FOREIGN KEY (id_client) REFERENCES client (id) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=cp1251;

--LOCK TABLES juridical_client WRITE;

INSERT INTO juridical_client VALUES (DEFAULT, 'Cyberlife LTD', 3);

--UNLOCK TABLES;

--------------------------------------------------------
-- Table structure for table `contract`
--------------------------------------------------------

DROP TABLE IF EXISTS contract;

CREATE TABLE contract (
  id INTEGER NOT NULL auto_increment UNIQUE PRIMARY KEY,
  accept_date date DEFAULT NULL,
  start_date date DEFAULT NULL,
  end_date date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=cp1251;


--LOCK TABLES contract WRITE;

INSERT INTO contract VALUES (DEFAULT,'1997-12-12','2017-08-23','2018-08-23');

--UNLOCK TABLES;

--------------------------------------------------------
-- Table structure for table `insured_person`
--------------------------------------------------------

DROP TABLE IF EXISTS insured_person;


USE sagittarius;


CREATE TABLE insured_person (
  id INT NOT NULL auto_increment PRIMARY KEY,
  --  не може бути більше одного поля із автоінкрементом, тому унікальний номер на мені
  unique_num INT UNIQUE NOT NULL,
  personal_cost double NOT NULL,
  client_id INT NOT NULL,
  contract_id INT NOT NULL,
--  мають бути унікальні імена обмежень в рамках усієї бд
  CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT fk_contract FOREIGN KEY (contract_id) REFERENCES contract (contract_id) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=cp1251;


--------------------------------------------------------

--LOCK TABLES insured_person WRITE;
/*!40000 ALTER TABLE `insured_person` DISABLE KEYS */;
INSERT INTO insured_person VALUES (DEFAULT, 34, 422.8, 1, 1),
                                    (DEFAULT, 85, 223.5, 2, 1);
/*!40000 ALTER TABLE `insured_person` ENABLE KEYS */;
--UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


------------------------------------------------------

SELECT * FROM client;

SELECT * FROM juridical_client;

SELECT * FROM physical_client;

SELECT * FROM contract;

SELECT * FROM insured_person;