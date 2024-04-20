-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: localhost    Database: ptitexam
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `classid` varchar(255) DEFAULT NULL,
                           `dob` date DEFAULT NULL,
                           `fullname` varchar(255) DEFAULT NULL,
                           `gender` varchar(5) DEFAULT NULL,
                           `phone_number` varchar(255) DEFAULT NULL,
                           `created_at` time(6) DEFAULT NULL,
                           `email` varchar(255) NOT NULL,
                           `is_active` bit(1) DEFAULT NULL,
                           `last_login` time(6) DEFAULT NULL,
                           `password` varchar(255) NOT NULL,
                           `username` varchar(255) NOT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `UK_q0uja26qgu1atulenwup9rxyr` (`email`),
                           UNIQUE KEY `UK_gex1lmaqpg0ir5g1f5eftyaa1` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'D21CQCN03','2003-04-10','Huy','Nam','09373783','19:01:17.000000','abc@123',_binary '','18:37:30.000000','123','huyhuy'),(2,'D21CQCN04','2003-05-08','Dang','Nam','09838777','19:02:00.000000','asjsh@asdfasdf',_binary '','19:02:10.000000','123','dangdang'),(3,'D21CQCN04','2003-06-10','Trung','Nam','0384884','19:04:15.000000','sdfasjh@kjdsakf',_binary '','19:04:27.000000','123','trungtrung');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `lastlogintime` time(6) DEFAULT NULL,
                         `password` varchar(255) DEFAULT NULL,
                         `username` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'19:04:47.000000','admin','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
                          `ansid` bigint NOT NULL AUTO_INCREMENT,
                          `content` varchar(255) DEFAULT NULL,
                          `is_correct` bit(1) DEFAULT NULL,
                          `questionid` bigint NOT NULL,
                          PRIMARY KEY (`ansid`),
                          KEY `FKqn39wgjyomdptxxkrfc79pjs1` (`questionid`),
                          CONSTRAINT `FKqn39wgjyomdptxxkrfc79pjs1` FOREIGN KEY (`questionid`) REFERENCES `question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,'A.16-4-2024',_binary '',1),(2,'B. 16-5-2023',_binary '\0',1),(3,'C. 13-2-2022',_binary '\0',1),(4,'A. Lap trinh web',_binary '',2),(5,'B. Mang may tinh',_binary '\0',2),(6,'C. Co so du lieu',_binary '\0',2),(7,'D. Nhap mon AI',_binary '\0',2),(8,'A. Huy',_binary '',3),(9,'B. Dang',_binary '\0',3),(10,'C. Trung',_binary '\0',3),(11,'E. Duy',_binary '\0',3);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_publication`
--

DROP TABLE IF EXISTS `event_publication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_publication` (
                                     `id` binary(16) NOT NULL,
                                     `completion_date` datetime(6) DEFAULT NULL,
                                     `event_type` varchar(255) DEFAULT NULL,
                                     `listener_id` varchar(255) DEFAULT NULL,
                                     `publication_date` datetime(6) DEFAULT NULL,
                                     `serialized_event` varchar(255) DEFAULT NULL,
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_publication`
--

LOCK TABLES `event_publication` WRITE;
/*!40000 ALTER TABLE `event_publication` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_publication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `created_at` time(6) DEFAULT NULL,
                        `description` varchar(255) DEFAULT NULL,
                        `is_active` bit(1) DEFAULT NULL,
                        `subject` varchar(255) DEFAULT NULL,
                        `time_amt` int NOT NULL,
                        `title` varchar(255) DEFAULT NULL,
                        `created_by` bigint DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        KEY `FKsf6m94d2sbkxsyen7298thu3h` (`created_by`),
                        CONSTRAINT `FKsf6m94d2sbkxsyen7298thu3h` FOREIGN KEY (`created_by`) REFERENCES `admin` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (1,'19:05:19.000000','Thi giua ki I 2022',_binary '','Mang May Tinh',45,'MMT-Ky I 2022',1),(2,'19:06:45.000000','Thi giua ki II 2022',_binary '','Lap Trinh Web',120,'LTW-Ky II 2022',1);
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_result`
--

DROP TABLE IF EXISTS `exam_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam_result` (
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `end_time` time(6) DEFAULT NULL,
                               `point` int DEFAULT NULL,
                               `start_time` time(6) DEFAULT NULL,
                               `account_id` bigint NOT NULL,
                               `exam_id` bigint NOT NULL,
                               PRIMARY KEY (`id`),
                               KEY `FKavqclgs5ls3v5jr2ja3hnf0rm` (`account_id`),
                               KEY `FKmblvyjlk9x7rrm7mvqtbedycc` (`exam_id`),
                               CONSTRAINT `FKavqclgs5ls3v5jr2ja3hnf0rm` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
                               CONSTRAINT `FKmblvyjlk9x7rrm7mvqtbedycc` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_result`
--

LOCK TABLES `exam_result` WRITE;
/*!40000 ALTER TABLE `exam_result` DISABLE KEYS */;
INSERT INTO `exam_result` VALUES (1,'19:13:21.000000',5,'18:13:13.000000',1,1);
/*!40000 ALTER TABLE `exam_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `content` varchar(255) DEFAULT NULL,
                            `last_modified` time(6) DEFAULT NULL,
                            `type` varchar(255) DEFAULT NULL,
                            `exam_id` bigint NOT NULL,
                            PRIMARY KEY (`id`),
                            KEY `FKhupso6ldavcx993tfnrjsdl1p` (`exam_id`),
                            CONSTRAINT `FKhupso6ldavcx993tfnrjsdl1p` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'Hom nay la ngay bao nhieu','19:08:44.000000','Single-choice',1),(2,'Mon hoc nay la mon gi','19:09:58.000000','Single-choice',1),(3,'Ban ten la gi','19:10:24.000000','Sigle-choice',1);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `selected_answer`
--

DROP TABLE IF EXISTS `selected_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `selected_answer` (
                                   `id` bigint NOT NULL AUTO_INCREMENT,
                                   `answer_id` bigint DEFAULT NULL,
                                   `result_id` bigint DEFAULT NULL,
                                   `question_id` bigint DEFAULT NULL,
                                   PRIMARY KEY (`id`),
                                   KEY `FKekvxn39ai6od1i39vgtpko96j` (`answer_id`),
                                   KEY `FK1ffqrg1yy1jtqq8yxygrtcs4m` (`result_id`),
                                   KEY `FKea6hfnjiyb8i53gftayfbv6y5` (`question_id`),
                                   CONSTRAINT `FK1ffqrg1yy1jtqq8yxygrtcs4m` FOREIGN KEY (`result_id`) REFERENCES `exam_result` (`id`),
                                   CONSTRAINT `FKea6hfnjiyb8i53gftayfbv6y5` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
                                   CONSTRAINT `FKekvxn39ai6od1i39vgtpko96j` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`ansid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `selected_answer`
--

LOCK TABLES `selected_answer` WRITE;
/*!40000 ALTER TABLE `selected_answer` DISABLE KEYS */;
INSERT INTO `selected_answer` VALUES (1,1,1,1),(2,4,1,2),(3,8,1,3);
/*!40000 ALTER TABLE `selected_answer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-16 12:20:12
