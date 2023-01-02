USE LunchTime;
DROP TABLE IF EXISTS `carrello`;
CREATE TABLE `carrello` (
  `emailutente` char(45) NOT NULL,
  PRIMARY KEY (`emailutente`),
  CONSTRAINT `email` FOREIGN KEY (`emailutente`) REFERENCES `utente` (`emailutente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `carrello` WRITE;

UNLOCK TABLES;

