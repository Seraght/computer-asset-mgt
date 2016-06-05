-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: asset
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
  `asset_year` char(2) NOT NULL,
  `asset_get` int(11) NOT NULL,
  `asset_number` char(3) NOT NULL,
  `type_id` int(11) NOT NULL,
  `serial` varchar(45) NOT NULL,
  `model` varchar(45) DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `asset_status` varchar(30) NOT NULL DEFAULT 'Stock',
  `buy_date` date DEFAULT NULL,
  `has_owner` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`asset_year`,`asset_get`,`asset_number`,`type_id`),
  UNIQUE KEY `serial_UNIQUE` (`serial`),
  KEY `asset_get_idx` (`asset_get`),
  KEY `asset_type_idx` (`type_id`),
  CONSTRAINT `asset_get` FOREIGN KEY (`asset_get`) REFERENCES `asset_get` (`get_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `asset_type` FOREIGN KEY (`type_id`) REFERENCES `asset_type` (`type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset`
--

LOCK TABLES `asset` WRITE;
/*!40000 ALTER TABLE `asset` DISABLE KEYS */;
INSERT INTO `asset` VALUES ('51',1,'001',1,'L3D4713 ','Thinkcentre','Lenovo',20000,'','Donate','2008-01-01',0),('51',1,'002',1,'L3D4655 ','Thinkcentre','Lenovo',20000,'','Donate','2008-01-01',0),('52',1,'001',1,'92M212S ','Optiplex 760','DELL',40000,'','Donate','2009-01-01',0),('52',1,'002',1,'13M212S ','Optiplex 760','DELL',40000,'','Donate','2009-01-01',0),('57',1,'001',1,'6CL5F02','Optiplex 7010DT','DELL',20000,'Test','Stock','2015-01-01',0),('57',1,'001',2,'615997-01R4200444','LH532V','FUJITSU',20000,'','Stock','2015-01-01',0),('57',1,'001',4,'WCU012667','CP305d LED','DocuPrint',20000,'','Stock','2015-01-01',0),('57',1,'001',5,'A33A016768','Image Scanner FI-7160','FUJITSU',2000,'','Stock','2015-01-01',0),('57',1,'002',1,'C8L1F02','Optiplex 7010DT','DELL',20000,'test','Stock','2015-01-01',0),('57',1,'002',2,'615997-01R4200443','LH532V','FUJITSU',2000,'','Stock','2015-01-01',0),('57',1,'002',4,'WCU012668','CP305d LED','DocuPrint',20000,'','Stock','2015-01-01',0),('57',1,'002',5,'A33A016878','Image Scanner FI-7160','FUJITSU',2000,'','Stock','2015-01-01',0),('57',1,'003',1,'JGK3F02','Optiplex 7010DT','DELL',20000,NULL,'Stock','2015-01-01',0),('57',1,'003',4,'WCU012564','CP305d LED','DocuPrint',2000,'','Stock','2015-01-01',0),('57',1,'003',5,'A33A016034','Image Scanner FI-7160','FUJITSU',2000,'','Stock','2015-01-01',0),('57',1,'004',1,'B6L2F02','Optiplex 7010DT','DELL',20000,NULL,'Stock','2015-01-01',0),('57',1,'005',1,'88L1F02','Optiplex 7010DT','DELL',20000,'asdsad','Stock','2015-01-01',0),('57',1,'006',1,'9FG8F02','Optiplex 7010DT','DELL',20000,'','Stock','2015-01-01',0),('57',1,'007',1,'F1N2F02','Optiplex 7010DT','DELL',20000,'แค่ทดสอบดูเฉยๆ','Stock','2015-01-01',0);
/*!40000 ALTER TABLE `asset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asset_donate`
--

DROP TABLE IF EXISTS `asset_donate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asset_donate` (
  `donate_id` int(11) NOT NULL AUTO_INCREMENT,
  `donate_date` date DEFAULT NULL,
  `donate_status` varchar(45) DEFAULT NULL,
  `asset_year` char(2) NOT NULL,
  `asset_get` int(11) NOT NULL,
  `asset_number` char(3) NOT NULL,
  `asset_type` int(11) NOT NULL,
  PRIMARY KEY (`donate_id`),
  KEY `asset_pk` (`asset_year`,`asset_get`,`asset_number`,`asset_type`),
  CONSTRAINT `asset_pk` FOREIGN KEY (`asset_year`, `asset_get`, `asset_number`, `asset_type`) REFERENCES `asset` (`asset_year`, `asset_get`, `asset_number`, `type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset_donate`
--

LOCK TABLES `asset_donate` WRITE;
/*!40000 ALTER TABLE `asset_donate` DISABLE KEYS */;
INSERT INTO `asset_donate` VALUES (1,'2016-06-02',NULL,'51',1,'001',1),(2,'2016-06-02',NULL,'51',1,'002',1),(3,'2016-06-02',NULL,'52',1,'001',1);
/*!40000 ALTER TABLE `asset_donate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asset_get`
--

DROP TABLE IF EXISTS `asset_get`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asset_get` (
  `get_id` int(11) NOT NULL AUTO_INCREMENT,
  `get_name` varchar(45) NOT NULL,
  PRIMARY KEY (`get_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset_get`
--

LOCK TABLES `asset_get` WRITE;
/*!40000 ALTER TABLE `asset_get` DISABLE KEYS */;
INSERT INTO `asset_get` VALUES (1,'เงินงบประมาณ'),(2,'เงินโครงการ'),(3,'เงิน IC'),(4,'เงินสวัสดิการ'),(5,'บริจาค'),(6,'เงิน BOI FAIR'),(7,'ซื้อทดแทน');
/*!40000 ALTER TABLE `asset_get` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'DELL'),(2,'FUJITSU'),(3,'CISCO'),(4,'HP'),(5,'DocuPrint'),(6,'Lenovo');
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
  `deliver_status` varchar(20) NOT NULL,
  `deliver_date` datetime NOT NULL,
  `accept_date` datetime DEFAULT NULL,
  `person_id` int(11) NOT NULL,
  `asset_year` char(2) NOT NULL,
  `asset_get` int(11) NOT NULL,
  `asset_number` char(3) NOT NULL,
  `asset_type` int(11) NOT NULL,
  PRIMARY KEY (`deliver_id`),
  KEY `person_key_idx` (`person_id`),
  KEY `asset_key` (`asset_year`,`asset_get`,`asset_number`,`asset_type`),
  CONSTRAINT `asset_key` FOREIGN KEY (`asset_year`, `asset_get`, `asset_number`, `asset_type`) REFERENCES `asset` (`asset_year`, `asset_get`, `asset_number`, `type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `person_key` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliver_asset`
--

LOCK TABLES `deliver_asset` WRITE;
/*!40000 ALTER TABLE `deliver_asset` DISABLE KEYS */;
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
  `has_asset` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`person_id`),
  KEY `role_id_idx` (`role_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `person_role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (10,'8375','อำนาจ','จุลชาต','amnat','amnat',1,0),(11,'6132','ณิษาอร','มานะ','nisaon','nisaon',1,0),(12,'1','Admin','system','admin','admin',2,0),(13,'8415','ณัฐพงษ์','จัตุรเขษม','nuttapong','nuttapong',1,0),(14,'8170','ธันว์','ตังสุรัตน์','thun','thun',1,0),(15,'8357','สุรเชษฐ','สุวรรณไพบูลย์','surachet','surachet',1,0),(16,'8228','พงค์พัฒน์','ศรีทิพงศ์','pongpat','pongpat',1,0),(17,'8413','เฉลิมชัย','เพาะบุญ','chalermchai','chalermchai',1,0),(18,'8367','อานนท์','สานะ','arnon','arnon',1,0),(19,'8425','วรรณวิทย์','คล้ายบุญส่ง','wannawit','wannawit',1,0),(20,'8243','พิมลดา','อู่อ้น','pimlada','pimlada',1,0),(21,'8190','ปนัดดา','ชวจุมพล','panadda','panadda',1,0),(22,'6174','วัชรพงษ์','ไชยมงคล','watcharapong','watcharapong',1,0),(23,'8228','พงค์พัฒน์','ศรีทิพงศ์','pongpat','pongpat',1,0),(24,'8413','เฉลิมชัย','เพาะบุญ','chalermchai','chalermchai',1,0),(25,'8367','อานนท์','สานะ','arnon','arnon',1,0),(26,'8425','วรรณวิทย์','คล้ายบุญส่ง','wannawit','wannawit',1,0),(27,'8243','พิมลดา','อู่อ้น','pimlada','pimlada',1,0),(28,'8190','ปนัดดา','ชวจุมพล','panadda','panadda',1,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;
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
  KEY `ticketstatus_idx` (`ticket_status`),
  CONSTRAINT `personid` FOREIGN KEY (`person_report_id`) REFERENCES `person` (`person_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ticketstatus` FOREIGN KEY (`ticket_status`) REFERENCES `ticket_status` (`status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_status`
--

LOCK TABLES `ticket_status` WRITE;
/*!40000 ALTER TABLE `ticket_status` DISABLE KEYS */;
INSERT INTO `ticket_status` VALUES (1,'เปิดใหม่'),(2,'แก้ไขแล้ว');
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

-- Dump completed on 2016-06-05 10:07:19
