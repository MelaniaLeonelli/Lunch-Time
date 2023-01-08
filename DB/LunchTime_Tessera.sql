USE LunchTime;
DROP TABLE IF EXISTS `tessera`;
CREATE TABLE `tessera` (
  `codicetessera` int(16) NOT NULL,
  `categoria` int(1) DEFAULT '0',
  `saldo` decimal(10,2) DEFAULT '0',
  `emailutente` varchar(45) NOT NULL,
  PRIMARY KEY (`codicetessera`)
)
 ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `tessera` VALUES
('0000000001234567','1','10.00','m.leonelli3@studenti.unisa.it'),
('0000000008764321','2','7.00','s.scafaa1@studenti.unisa.it'),
('0000000090987654','3', '8.00','e.allocco1@studenti.unisa.it');
LOCK TABLES `tessera` WRITE;
UNLOCK TABLES;
