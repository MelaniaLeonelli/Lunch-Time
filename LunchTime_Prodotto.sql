USE LunchTime;
DROP TABLE IF EXISTS `prodotto`;
CREATE TABLE `prodotto` (
  `idprodotto` varchar(8) NOT NULL,
  `nome` varchar(90) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `prezzo` decimal(10,2) DEFAULT NULL,
  `immagine` varchar(45) DEFAULT NULL,
  `descrizione` varchar(250) DEFAULT NULL,
  `disponibile` bool,
  PRIMARY KEY (`idprodotto`),
  KEY `prezzo` (`prezzo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `prodotto` WRITE;

UNLOCK TABLES;