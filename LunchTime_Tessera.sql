USE LunchTime;
DROP TABLE IF EXISTS `tessera`;
CREATE TABLE `tessera` (
  `codicetessera` int(16) NOT NULL,
  `categoria` int(1) DEFAULT '0',
  `saldo` int(5) DEFAULT '0',
  `emailutente` varchar(45) NOT NULL,
  PRIMARY KEY (`codicetessera`)
)
 ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `tessera` WRITE;
UNLOCK TABLES;
