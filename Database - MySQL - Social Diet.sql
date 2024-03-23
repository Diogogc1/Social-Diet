CREATE DATABASE  IF NOT EXISTS `trabalhoparte2poo_diogo_e_matheus_ads` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `trabalhoparte2poo_diogo_e_matheus_ads`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: trabalhoparte2poo_diogo_e_matheus_ads
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alimento`
--

DROP TABLE IF EXISTS `alimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alimento` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `carboidrato` double NOT NULL,
  `proteina` double NOT NULL,
  `gordura` double NOT NULL,
  `caloria` double NOT NULL,
  `porcao` int NOT NULL,
  `idPessoa` bigint NOT NULL,
  `dataCriacao` date NOT NULL,
  `dataModificacao` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkIdPessoaAlimento_idx` (`idPessoa`),
  CONSTRAINT `fkIdPessoaAlimento` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alimento`
--

LOCK TABLES `alimento` WRITE;
/*!40000 ALTER TABLE `alimento` DISABLE KEYS */;
INSERT INTO `alimento` VALUES (2,'Ovo',1.2,15.6,18.6,141.60000000000002,1,3,'2023-12-11','2023-12-11'),(4,'Manteiga',0.1,0.4,82.4,331.6,1,3,'2023-12-13','2023-12-13'),(5,'Castanha-de-caju torrada',29.1,18.5,46.3,375.6,1,3,'2023-12-13','2023-12-13'),(6,'Arroz',28.1,2.5,0.2,123.2,1,3,'2023-12-13','2023-12-13'),(7,'Pao frances',49.9,9.4,3.7,252,1,3,'2023-12-13','2023-12-13'),(8,'Feijao',13.8,4.8,0.5,76.4,1,3,'2023-12-13','2023-12-13'),(9,'Carne (coxao mole)',0,32.4,8.9,165.2,1,3,'2023-12-13','2023-12-13'),(10,'Frango caipira (sem Pele)',0,29.6,7.7,149.20000000000002,1,3,'2023-12-13','2023-12-13'),(11,'Picanha assada (sem gordura)',0,21.3,4.7,104,1,3,'2023-12-13','2023-12-13');
/*!40000 ALTER TABLE `alimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alimentorefeicoes`
--

DROP TABLE IF EXISTS `alimentorefeicoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alimentorefeicoes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idRefeicao` bigint NOT NULL,
  `idAlimento` bigint NOT NULL,
  `porcao` int NOT NULL,
  `carboidrato` double NOT NULL,
  `proteina` double NOT NULL,
  `gordura` double NOT NULL,
  `caloria` double NOT NULL,
  `dataCriacao` date NOT NULL,
  `dataModificacao` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkIdRefeicaoAlimentoRefeicoes_idx` (`idRefeicao`),
  KEY `fkIdAlimentoAlimentoRefeicoes_idx` (`idAlimento`),
  CONSTRAINT `fkIdAlimentoAlimentoRefeicoes` FOREIGN KEY (`idAlimento`) REFERENCES `alimento` (`id`),
  CONSTRAINT `fkIdRefeicaoAlimentoRefeicoes` FOREIGN KEY (`idRefeicao`) REFERENCES `refeicao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=246 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alimentorefeicoes`
--

LOCK TABLES `alimentorefeicoes` WRITE;
/*!40000 ALTER TABLE `alimentorefeicoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `alimentorefeicoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avaliacao`
--

DROP TABLE IF EXISTS `avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avaliacao` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idPessoa` bigint NOT NULL,
  `peso` double NOT NULL,
  `altura` double NOT NULL,
  `idade` int NOT NULL,
  `pescoco` double NOT NULL,
  `cintura` double NOT NULL,
  `quadril` double NOT NULL,
  `imc` double NOT NULL,
  `tmb` double NOT NULL,
  `bf` double NOT NULL,
  `estadoBf` varchar(45) NOT NULL,
  `massaGorda` double NOT NULL,
  `massaMagra` double NOT NULL,
  `dataCriacao` date NOT NULL,
  `dataModificacao` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkIdPessoaAvaliacao_idx` (`idPessoa`),
  CONSTRAINT `fkIdPessoaAvaliacao` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
INSERT INTO `avaliacao` VALUES (10,3,86,186,25,40.8,95.2,105.2,0.002485836512891664,3106.5099999999998,27.079905237073383,'Muito elevado',23.288718503883107,62.7112814961169,'2023-12-13','2023-12-13');
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dieta`
--

DROP TABLE IF EXISTS `dieta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dieta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idPessoa` bigint NOT NULL,
  `idAvaliacao` bigint NOT NULL,
  `idTipoDieta` bigint NOT NULL,
  `objetivo` varchar(50) NOT NULL,
  `caloria` double NOT NULL,
  `numeroRefeicoes` int NOT NULL,
  `dataCriacao` date NOT NULL,
  `dataModificacao` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkIdPessoaDieta_idx` (`idPessoa`),
  KEY `fkIdTipoDietaDieta_idx` (`idTipoDieta`),
  KEY `fkIdAvaliacaoDieta_idx` (`idAvaliacao`),
  CONSTRAINT `fkIdAvaliacaoDieta` FOREIGN KEY (`idAvaliacao`) REFERENCES `avaliacao` (`id`),
  CONSTRAINT `fkIdPessoaDieta` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `fkIdTipoDietaDieta` FOREIGN KEY (`idTipoDieta`) REFERENCES `tipodieta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dieta`
--

LOCK TABLES `dieta` WRITE;
/*!40000 ALTER TABLE `dieta` DISABLE KEYS */;
INSERT INTO `dieta` VALUES (3,3,10,1,'Manter o peso',3106.5099999999998,3,'2023-12-13','2023-12-13');
/*!40000 ALTER TABLE `dieta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensagem`
--

DROP TABLE IF EXISTS `mensagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensagem` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `pessoaOrigem` bigint NOT NULL,
  `pessoaDestino` bigint NOT NULL,
  `mensagem` varchar(200) NOT NULL,
  `dataCriacao` date NOT NULL,
  `dataModificacao` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkIdPessoaOrigemMensagem_idx` (`pessoaOrigem`),
  KEY `fkIdPessoaDestinoMensagem_idx` (`pessoaDestino`),
  CONSTRAINT `fkIdPessoaDestinoMensagem` FOREIGN KEY (`pessoaDestino`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `fkIdPessoaOrigemMensagem` FOREIGN KEY (`pessoaOrigem`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensagem`
--

LOCK TABLES `mensagem` WRITE;
/*!40000 ALTER TABLE `mensagem` DISABLE KEYS */;
/*!40000 ALTER TABLE `mensagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoa` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `sexo` varchar(20) NOT NULL,
  `dataNascimento` date NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `dataCriacao` date NOT NULL,
  `dataModificacao` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'diogo','Masculino','2003-10-10','diogo1','diogo1','2023-12-10','2023-12-10'),(2,'matheus','Masculino','2002-04-03','matheus','matheus','2023-12-10','2023-12-10'),(3,'Diogo','Masculino','2003-10-10','diogo','diogo','2023-12-13','2023-12-13');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idPessoa` bigint NOT NULL,
  `conteudoMensagem` varchar(200) NOT NULL,
  `dataCriacao` date NOT NULL,
  `dataModificacao` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkIdPessoaPost_idx` (`idPessoa`),
  CONSTRAINT `fkIdPessoaPost` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,3,'Boa noite','2023-12-13','2023-12-13');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preferencias`
--

DROP TABLE IF EXISTS `preferencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preferencias` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idPessoa` bigint NOT NULL,
  `dataCriacao` date NOT NULL,
  `dataModificacao` date NOT NULL,
  `idAlimento` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkIdPessoaPreferencia_idx` (`idPessoa`),
  KEY `fkIdAlimentoPreferencia_idx` (`idAlimento`),
  CONSTRAINT `fkIdAlimentoPreferencia` FOREIGN KEY (`idAlimento`) REFERENCES `alimento` (`id`),
  CONSTRAINT `fkIdPessoaPreferencia` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preferencias`
--

LOCK TABLES `preferencias` WRITE;
/*!40000 ALTER TABLE `preferencias` DISABLE KEYS */;
INSERT INTO `preferencias` VALUES (2,1,'2023-12-11','2023-12-11',2),(3,3,'2023-12-13','2023-12-13',11),(4,3,'2023-12-13','2023-12-13',10),(5,3,'2023-12-13','2023-12-13',2),(6,3,'2023-12-13','2023-12-13',6),(7,3,'2023-12-13','2023-12-13',8),(8,3,'2023-12-13','2023-12-13',4);
/*!40000 ALTER TABLE `preferencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refeicao`
--

DROP TABLE IF EXISTS `refeicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refeicao` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idDieta` bigint NOT NULL,
  `nome` varchar(45) NOT NULL,
  `carboidrato` double NOT NULL,
  `proteina` double NOT NULL,
  `gordura` double NOT NULL,
  `caloria` double DEFAULT NULL,
  `dataCriacao` date DEFAULT NULL,
  `dataModificacao` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkIdDietaRefeicao_idx` (`idDieta`),
  CONSTRAINT `fkIdDietaRefeicao` FOREIGN KEY (`idDieta`) REFERENCES `dieta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refeicao`
--

LOCK TABLES `refeicao` WRITE;
/*!40000 ALTER TABLE `refeicao` DISABLE KEYS */;
INSERT INTO `refeicao` VALUES (17,3,'cafe',100,100,100,300,'2023-12-13','2023-12-13'),(18,3,'cafe3',100,100,100,300,'2023-12-13','2023-12-13');
/*!40000 ALTER TABLE `refeicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguir`
--

DROP TABLE IF EXISTS `seguir`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seguir` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idPessoaOrigem` bigint NOT NULL,
  `idPessoaSeguindo` bigint NOT NULL,
  `dataCriacao` date NOT NULL,
  `dataModificacao` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkIdPessoaOrigemSeguir_idx` (`idPessoaOrigem`),
  KEY `fkIdPessoaSeguindoSeguir_idx` (`idPessoaSeguindo`),
  CONSTRAINT `fkIdPessoaOrigemSeguir` FOREIGN KEY (`idPessoaOrigem`) REFERENCES `pessoa` (`id`),
  CONSTRAINT `fkIdPessoaSeguindoSeguir` FOREIGN KEY (`idPessoaSeguindo`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguir`
--

LOCK TABLES `seguir` WRITE;
/*!40000 ALTER TABLE `seguir` DISABLE KEYS */;
INSERT INTO `seguir` VALUES (1,3,1,'2023-12-13','2023-12-13'),(2,3,2,'2023-12-13','2023-12-13');
/*!40000 ALTER TABLE `seguir` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipodieta`
--

DROP TABLE IF EXISTS `tipodieta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipodieta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `carboidrato` double NOT NULL,
  `proteina` double NOT NULL,
  `gordura` double NOT NULL,
  `dataCriacao` date NOT NULL,
  `dataModificacao` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodieta`
--

LOCK TABLES `tipodieta` WRITE;
/*!40000 ALTER TABLE `tipodieta` DISABLE KEYS */;
INSERT INTO `tipodieta` VALUES (1,'Equilibrada',0.4,0.3,0.3,'2023-12-11','2023-12-11'),(2,'Low Carb',0.3,0.5,0.2,'2023-12-11','2023-12-11'),(3,'Cetogenica',0.15,0.15,0.7,'2023-12-11','2023-12-11');
/*!40000 ALTER TABLE `tipodieta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-22 21:02:27
