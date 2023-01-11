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
INSERT INTO `prodotto` VALUES
('00000001','pasta e patate','primopiatto','1.00','Pastaepatate.jpg','ingredienti:pasta mista, patate, sedano, carote, cipolle bianche,lardo,concentrato di pomodoro.rosmarino,parmigiano reggiano, olio, sale, pepe nero','0'),
('00000002','riso e patate','primopiatto','1.0','risoepatate.jpg','ingredienti:riso,cipolla bianca, sedano, patate, olio extravergine, sale, parmigiano grattugiato','0'),
('00000003','pasta al sugo','primopiatto', '1.0','pastasugo.jpg','ingredienti:pasta, olio extravergine, cipolla, passata di pomodoro, basilico fresco', '0'),
('00000004','wurstel','secondopiatto','1.0','wrustel.jpg','ingredienti: suino','0'),
('00000005','polpette','secondopiatto','1.0','polpette.jpg','ingredienti: manzo, maiale, pane, parmigiano reggiano, uova, sale, pepe, prezzemolo','0'),
('00000006','pollo al forno','secondopiatto','1.0','pollo.jpg','ingredienti:pollo, olio extravergine, sale','0'),
('00000007','salsiccia','secondopiatto','1.0','salsiccia.jpg', 'ingredienti: salsiccia di tacchino','0'),
('00000008','costoletta','secondopiatto','1.0','costoletta.jpg', 'ingredienti: costoletta di maiale','0'),
('00000010','pasta e lenticchie','primopiatto','1.0','pastalenticchie.jpg','ingredienti: pasta, lenticchie, pomodorini ciliegia, aglio, olio extravergine, prezzemolo','0'),
('00000011','pasta e fagioli','primopiatto','1.0','pastafagioli.jpg','ingredienti: pasta, fagioli, passata di pomodori, lardo, prosciutto crudo, cipolle, sedano, carote, rosmarino, olio extravergine, sale','0'),
('00000012','pasta e ceci','primopiatto','1.0','pastaceci.jpg','ingredienti: pasta, ceci secchi,aglio, olio extravergine, prezzemolo','0'),
('00000013','cannelloni','primopiatto','1.0','cannelloni.jpg','ingredienti: farina, uova, latte, burro, sale, carne bovina, parmigiano reggiano, sedano, passata di pomodoro, pepe nero','0'),
('00000014','lasagna','primopiatto','1.0','lasagna.jpg','ingredienti: farina, uova, latte, burro, sale, carne bovina, parmigiano reggiano, sedano, passata di pomodoro, pepe nero','0'),
('00000015','bastoncini','secondopiatto','1.0','bastoncini.jpg','ingredienti: merluzzo, farina, sale, prezzemolo, uova, pangrattato, olio di semi','0'),
('00000016','insalata di mare','secondopiatto','1.0','insalatamare.jpg','ingredienti: polpi, totano, seppie, patate, limone', '0'),
('00000017','pesce spada', 'secondopiatto', '1.0', 'pescespada.jpg', 'ingredienti: pesce spada, pomodori datterini, olive nere, aglio, olio extravergine d\oliva, sale','0'),
('00000018','hamburger','secondopiatto','1.0','hamburger,jpg','ingredienti: hamburger di maiale','0'),
('00000019','patate al forno', 'contorno', '1.0','patate.jpg','ingredienti: patate, olio extravergine, rosmarino, sale','0'),
('00000020','insalata','contorno','1.0','insalata.jpg','ingredienti: insalata, sale, olio extravergine, limone','0'),
('00000021','broccoli','contorno','1.0','broccoli.jpg','ingredienti: broccoli, sale, limone','0'),
('00000022','pomodori','contorno','1.0','pomodori.jpg','ingredienti: pomodori, sale, olio extravergine','0');


UNLOCK TABLES;