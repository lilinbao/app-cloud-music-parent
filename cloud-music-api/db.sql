-- MySQL dump 10.13  Distrib 5.5.47, for Win64 (x86)
--
-- Host: localhost    Database: cloudmusic
-- ------------------------------------------------------
-- Server version	5.5.47

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
-- Table structure for table `tb_art`
--

DROP TABLE IF EXISTS `tb_art`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_art` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `birthday` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_art`
--

LOCK TABLES `tb_art` WRITE;
/*!40000 ALTER TABLE `tb_art` DISABLE KEYS */;
INSERT INTO `tb_art` VALUES (1,'2015-12-19','Rock Company','Linbao','m','Popular'),(2,'2015-12-19','HuaYi Brother Company','Lishen','m','Classical'),(3,'2015-12-19','LL Company','Eason','m','General');
/*!40000 ALTER TABLE `tb_art` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_credit`
--

DROP TABLE IF EXISTS `tb_credit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_credit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `creditAmount` decimal(19,2) DEFAULT NULL,
  `effectedTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5u2n86ga0nad8s5w9ny8d83jl` (`user_id`),
  CONSTRAINT `FK_5u2n86ga0nad8s5w9ny8d83jl` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_credit`
--

LOCK TABLES `tb_credit` WRITE;
/*!40000 ALTER TABLE `tb_credit` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_credit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_floder`
--

DROP TABLE IF EXISTS `tb_floder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_floder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `displayName` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pat4vbje3e9u77ym06y0fesio` (`user_id`),
  CONSTRAINT `FK_pat4vbje3e9u77ym06y0fesio` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_floder`
--

LOCK TABLES `tb_floder` WRITE;
/*!40000 ALTER TABLE `tb_floder` DISABLE KEYS */;
INSERT INTO `tb_floder` VALUES (1,'Favorite','local/music',1);
/*!40000 ALTER TABLE `tb_floder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_music`
--

DROP TABLE IF EXISTS `tb_music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_music` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `musics` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_id8lbo3g8q02xuqyo89sgfp8i` (`musics`),
  CONSTRAINT `FK_id8lbo3g8q02xuqyo89sgfp8i` FOREIGN KEY (`musics`) REFERENCES `tb_art` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_music`
--

LOCK TABLES `tb_music` WRITE;
/*!40000 ALTER TABLE `tb_music` DISABLE KEYS */;
INSERT INTO `tb_music` VALUES (1,'Main Land',100,'My Love - 0','2015',1),(2,'Main Land',100,'Season In The Sun - 0','2015',1),(3,'Main Land',100,'Huan Huan - 0','2015',1),(4,'Main Land',100,'My Love - 1','2015',2),(5,'Main Land',100,'Season In The Sun - 1','2015',2),(6,'Main Land',100,'Huan Huan - 1','2015',2),(7,'Main Land',100,'My Love - 2','2015',3),(8,'Main Land',100,'Season In The Sun - 2','2015',3),(9,'Main Land',100,'Huan Huan - 2','2015',3),(10,'Master Land',2,'一次就好','2015',1);
/*!40000 ALTER TABLE `tb_music` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `level` double DEFAULT NULL,
  `nickName` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'Linbaolee@gmail.com',1,'linbao',NULL,'linbao');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-11  1:52:02
