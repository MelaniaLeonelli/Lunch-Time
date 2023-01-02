USE LunchTime;
DROP TABLE IF EXISTS `ordine`;

CREATE TABLE `ordine` (
  `CodOrdine` int NOT NULL,
  `Data` varchar(45) DEFAULT NULL,
  `ImportoTotale` decimal(10,2) DEFAULT NULL,
  `emailutente` char(16) DEFAULT NULL,
  PRIMARY KEY (`CodOrdine`),
  KEY `email` (`emailutente`),
  CONSTRAINT `emailor` FOREIGN KEY (`emailutente`) REFERENCES `utente` (`emailutente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `ordine` WRITE;
UNLOCK TABLES;