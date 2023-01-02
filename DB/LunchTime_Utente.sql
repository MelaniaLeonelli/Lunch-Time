USE LunchTime;
DROP TABLE IF EXISTS `utente`;
CREATE TABLE `utente` (
  `emailutente` varchar(45) NOT NULL,
  `Nomeutente` varchar(16) DEFAULT NULL,
  `Password` varchar(257) DEFAULT NULL,
  `ruolo` int DEFAULT '0',
  PRIMARY KEY (`emailutente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `utente` WRITE;
UNLOCK TABLES;
