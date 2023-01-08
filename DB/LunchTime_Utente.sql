USE LunchTime;
DROP TABLE IF EXISTS `utente`;
CREATE TABLE `utente` (
  `emailutente` varchar(45) NOT NULL,
  `Nomeutente` varchar(16) DEFAULT NULL,
  `Password` varchar(257) DEFAULT NULL,
  `ruolo` int DEFAULT '0',
  PRIMARY KEY (`emailutente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `utente` VALUES
('m.leonelli3@studenti.unisa.it','melaperauva','57f42cb1e4898f55f8f8e4729c5a575f0484224ffa774e290a156e7a','0'),
('s.scafa1@tudenti.unisa.it','settismysenpai','57f42cb1e4898f55f8f8e4729c5a575f0484224ffa774e290a156e7a','0'),
('e.allocco1@studenti.unisa.it','zoso','57f42cb1e4898f55f8f8e4729c5a575f0484224ffa774e290a156e7a0','0'),
('signoradellamensa@gmail.it','signoramensa','57f42cb1e4898f55f8f8e4729c5a575f0484224ffa774e290a156e7a','0');
LOCK TABLES `utente` WRITE;
UNLOCK TABLES;
