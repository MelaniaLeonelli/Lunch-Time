USE LunchTime;
DROP TABLE IF EXISTS `contiene`;
CREATE TABLE `contiene` (
  `CodProdotto` varchar(8) DEFAULT NULL,
  `emailutente` char(45) DEFAULT NULL,
  `quantita` int DEFAULT NULL,
  `ImportoTotale` decimal(10,2) DEFAULT NULL,
  KEY `email` (`emailutente`),
  CONSTRAINT `email2` FOREIGN KEY (`emailutente`) REFERENCES `utente` (`emailutente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `contiene` WRITE;
UNLOCK TABLES;
