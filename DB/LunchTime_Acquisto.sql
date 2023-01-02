USE LunchTime;
DROP TABLE IF EXISTS `acquisto`;
CREATE TABLE `acquisto` (
  `CodOrdine` int NOT NULL,
  `CodProdotto` varchar(8) NOT NULL,
  `Costo` decimal(10,2) DEFAULT NULL,
  KEY `pcode_idx` (`CodProdotto`),
  KEY `ocode_idx` (`CodOrdine`),
  CONSTRAINT `ocode` FOREIGN KEY (`CodOrdine`) REFERENCES `ordine` (`CodOrdine`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pcode` FOREIGN KEY (`CodProdotto`) REFERENCES `prodotto` (`idprodotto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `acquisto` WRITE;
UNLOCK TABLES;
