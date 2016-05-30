-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: asset
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `asset`
--

DROP TABLE IF EXISTS `asset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asset` (
  `asset_id` int(11) NOT NULL AUTO_INCREMENT,
  `asset_number` char(20) NOT NULL,
  `model` varchar(45) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `price` double DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `type_id` int(11) NOT NULL,
  `has_owner` binary(1) DEFAULT '0',
  `serial` varchar(45) NOT NULL,
  PRIMARY KEY (`asset_id`),
  UNIQUE KEY `asset_id_UNIQUE` (`asset_id`),
  UNIQUE KEY `asset_number_UNIQUE` (`asset_number`),
  KEY `type_id_idx` (`type_id`),
  CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `asset_type` (`type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COMMENT='d';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset`
--

LOCK TABLES `asset` WRITE;
/*!40000 ALTER TABLE `asset` DISABLE KEYS */;
INSERT INTO `asset` VALUES (1,'57-1-010-01','Optiplex 7010DT','DELL',20000,NULL,1,'1',''),(2,'57-1-007-01','Optiplex 7010DT','DELL',20000,NULL,1,'1',''),(3,'57-1-009-01','Optiplex 7010DT','DELL',20000,NULL,1,'1',''),(4,'57-1-008-01','Optiplex 7010DT','DELL',20000,NULL,1,'1',''),(5,'58-1-003-02','Catalyst 4500','CISCO',40000,NULL,6,'1',''),(6,'58-1-001-02','Catalyst 4500','CISCO',40000,'Network Switch',6,'0',''),(7,'57-1-002-01','Optiplex 7010DT','DELL',40000,'ทดสอบการทำงาน',1,'0',''),(8,'57-1-003-01','Optiplex 7010DT','DELL',40000,NULL,1,'0',''),(9,'57-1-004-01','Optiplex 7010DT','DELL',40000,NULL,1,'0',''),(10,'57-1-005-01','Optiplex 7010DT','DELL',400005,NULL,1,'0',''),(11,'57-1-001-06','Image Scanner FI-7160 ','FUJITSU',6000,'A33A016034 ',5,'0',''),(12,'57-1-002-06','Image Scanner FI-7160 ','FUJITSU',6000,'A33A016571 ',5,'0',''),(13,'57-1-003-06','Image Scanner FI-7160 ','FUJITSU',6000,'A33A016768 ',5,'0',''),(14,'57-1-004-06','Image Scanner FI-7160 ','FUJITSU',6000,'A33A016878 ',5,'0',''),(15,'58-1-002-02','Catalyst 4500','CISCO',40000,NULL,6,'0',''),(19,'57-1-006-01','Optiplex 7010DT','DELL',20000,NULL,1,'0',''),(23,'57-1-011-01','Optiplex 7010DT','DELL',20000,NULL,1,'1',''),(24,'57-1-077-01','Optiplex 7010DT','DELL',20000,'ทดสอบ',1,'0','27J8F02'),(25,'57-1-078-01','Optiplex 7010DT','DELL',20000,NULL,1,'0','28M3F02');
/*!40000 ALTER TABLE `asset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asset_type`
--

DROP TABLE IF EXISTS `asset_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asset_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(45) NOT NULL,
  PRIMARY KEY (`type_id`),
  UNIQUE KEY `type_id_UNIQUE` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset_type`
--

LOCK TABLES `asset_type` WRITE;
/*!40000 ALTER TABLE `asset_type` DISABLE KEYS */;
INSERT INTO `asset_type` VALUES (1,'คอมพิวเตอร์'),(2,'โน๊ตบุ้ค'),(3,'แท็ปเล็ต, โทรศัพท์เคลื่อนที่'),(4,'ปริ้นเตอร์'),(5,'สแกนเนอร์'),(6,'เนตเวิร์ค'),(10,'เซิฟเวอร์');
/*!40000 ALTER TABLE `asset_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brand` (
  `brand_id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(45) NOT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'DELL'),(2,'FUJITSU'),(3,'CISCO'),(4,'HP');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deliver_asset`
--

DROP TABLE IF EXISTS `deliver_asset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deliver_asset` (
  `deliver_id` int(11) NOT NULL AUTO_INCREMENT,
  `deliver_status` varchar(20) NOT NULL DEFAULT 'WAITING',
  `deliver_date` datetime NOT NULL,
  `accept_date` datetime DEFAULT NULL,
  `person_id` int(11) DEFAULT NULL,
  `computer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`deliver_id`),
  UNIQUE KEY `computer_id_UNIQUE` (`computer_id`),
  UNIQUE KEY `person_id_UNIQUE` (`person_id`),
  KEY `person_id_idx` (`person_id`),
  KEY `computer_id_idx` (`computer_id`),
  CONSTRAINT `computer_id` FOREIGN KEY (`computer_id`) REFERENCES `asset` (`asset_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `person_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliver_asset`
--

LOCK TABLES `deliver_asset` WRITE;
/*!40000 ALTER TABLE `deliver_asset` DISABLE KEYS */;
INSERT INTO `deliver_asset` VALUES (9,'ACCEPT','2016-05-21 13:08:37','2016-05-21 13:44:51',10,3),(10,'ACCEPT','2016-05-21 17:42:44','2016-05-21 17:43:46',11,1),(11,'WAITING','2016-05-21 17:43:20',NULL,13,2),(12,'WAITING','2016-05-21 17:43:26',NULL,18,5),(13,'WAITING','2016-05-21 17:50:19',NULL,17,4),(14,'ACCEPT','2016-05-22 11:21:26','2016-05-22 11:26:23',14,23);
/*!40000 ALTER TABLE `deliver_asset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `person_number` varchar(13) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `has_asset` binary(1) DEFAULT '0',
  PRIMARY KEY (`person_id`),
  KEY `role_id_idx` (`role_id`),
  KEY `deliver_id_idx` (`has_asset`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `person_role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (10,'8375','อำนาจ','จุลชาต','amnat','amnat',1,'1'),(11,'6132','ณิษาอร','มานะ','nisaon','nisaon',1,'1'),(12,'1','Admin','system','admin','admin',2,'0'),(13,'8415','ณัฐพงษ์','จัตุรเขษม','nuttapong','nuttapong',1,'1'),(14,'8170','ธันว์','ตังสุรัตน์','thun','thun',1,'1'),(15,'8357','สุรเชษฐ','สุวรรณไพบูลย์','surachet','surachet',1,'0'),(16,'8228','พงค์พัฒน์','ศรีทิพงศ์','pongpat','pongpat',1,'0'),(17,'8413','เฉลิมชัย','เพาะบุญ','chalermchai','chalermchai',1,'1'),(18,'8367','อานนท์','สานะ','arnon','arnon',1,'1'),(19,'8425','วรรณวิทย์','คล้ายบุญส่ง','wannawit','wannawit',1,'0'),(20,'8243','พิมลดา','อู่อ้น','pimlada','pimlada',1,'0'),(21,'8190','ปนัดดา','ชวจุมพล','panadda','panadda',1,'0'),(22,'6174','วัชรพงษ์','ไชยมงคล','watcharapong','watcharapong',1,'0');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_role`
--

DROP TABLE IF EXISTS `person_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_name_UNIQUE` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_role`
--

LOCK TABLES `person_role` WRITE;
/*!40000 ALTER TABLE `person_role` DISABLE KEYS */;
INSERT INTO `person_role` VALUES (2,'Admin'),(4,'Director'),(3,'Support'),(1,'User');
/*!40000 ALTER TABLE `person_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `ticket_id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_title` varchar(45) NOT NULL,
  `ticket_date` datetime DEFAULT NULL,
  `ticket_description` varchar(45) DEFAULT NULL,
  `ticket_status` int(11) NOT NULL,
  `ticket_solve` varchar(45) DEFAULT NULL,
  `ticket_solve_date` datetime DEFAULT NULL,
  `person_report_id` int(11) DEFAULT NULL,
  `asset_report_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ticket_id`),
  KEY `personid_idx` (`person_report_id`),
  KEY `assetid_idx` (`asset_report_id`),
  KEY `ticketstatus_idx` (`ticket_status`),
  CONSTRAINT `assetid` FOREIGN KEY (`asset_report_id`) REFERENCES `asset` (`asset_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `personid` FOREIGN KEY (`person_report_id`) REFERENCES `person` (`person_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ticketstatus` FOREIGN KEY (`ticket_status`) REFERENCES `ticket_status` (`status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,'คอมพิวเตอร์','2016-05-06 14:21:04','เปิดคอมไม่ได้',1,NULL,'2016-05-06 14:31:37',11,2),(2,'อินเทอร์เน็ต','2016-05-06 14:24:32','เข้า Facebook ไม่ได้',2,'Change RAM','2016-05-22 09:25:55',11,2),(3,'คอมพิวเตอร์','2016-05-21 16:11:08','sadhiu12hi3',1,NULL,NULL,10,2),(4,'อินเทอร์เน็ต','2016-05-21 16:11:18','เปิดคอมไม่ได้3',2,NULL,'2016-05-21 17:54:47',10,2),(5,'ไม่ได้ทำอะไรเลย','2016-05-21 21:17:32','ลองทดสอบดูเฉยๆ',1,NULL,NULL,10,1),(6,'ไม่ได้ทำอะไรเลย','2016-05-21 21:17:45','ลองทดสอบดูเฉยๆ',2,'ลงเครื่องใหม่','2016-05-22 09:26:12',10,1),(7,'อินเทอร์เน็ต','2016-05-22 11:29:19','ไม่สามารถใช้งานได้',1,NULL,NULL,14,23);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_status`
--

DROP TABLE IF EXISTS `ticket_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket_status` (
  `status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status_name` char(20) NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_status`
--

LOCK TABLES `ticket_status` WRITE;
/*!40000 ALTER TABLE `ticket_status` DISABLE KEYS */;
INSERT INTO `ticket_status` VALUES (1,'เปิดใหม่'),(2,'แก้ไขแล้ว'),(3,'เปิดใหม่'),(4,'แก้ไขแล้ว');
/*!40000 ALTER TABLE `ticket_status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-28 16:59:32
