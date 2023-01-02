USE LunchTime;
DROP TABLE IF EXISTS `preferisce`;
CREATE TABLE `preferisce` (
  `IdProdotto` varchar(8) DEFAULT NULL,
  `emailutente` char(16) DEFAULT NULL,
  KEY `email` (`emailutente`),
  CONSTRAINT `emailpr` FOREIGN KEY (`emailutente`) REFERENCES `utente` (`emailutente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `preferisce` WRITE;
UNLOCK TABLES;