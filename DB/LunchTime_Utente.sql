USE LunchTime;
DROP TABLE IF EXISTS `utente`;
CREATE TABLE `utente` (
  `emailutente` varchar(45) NOT NULL,
  `nomeutente` varchar(16) DEFAULT NULL,
  `password` varchar(257) DEFAULT NULL,
  `ruolo` int DEFAULT '0',
  PRIMARY KEY (`emailutente`),
  UNIQUE KEY `emailutente_UNIQUE`(`emailutente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `utente` VALUES
('m.leonelli3@studenti.unisa.it','melaperauva','b940cd2603df7229fe62f28562868ee727c0e0723131403bc0ef7cc2','0'),
('s.scafa1@tudenti.unisa.it','settismysenpai','b940cd2603df7229fe62f28562868ee727c0e0723131403bc0ef7cc2','0'),
('e.allocco1@studenti.unisa.it','zoso','b940cd2603df7229fe62f28562868ee727c0e0723131403bc0ef7cc2','0'),
('signoradellamensa@gmail.it','signoramensa','b940cd2603df7229fe62f28562868ee727c0e0723131403bc0ef7cc2','1');
LOCK TABLES `utente` WRITE;
UNLOCK TABLES;
