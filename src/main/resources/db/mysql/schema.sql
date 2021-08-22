CREATE TABLE IF NOT EXISTS `wenance_challenge` (
   `id_wenance_challenge` bigint NOT NULL AUTO_INCREMENT,
   `curr1` varchar(255) DEFAULT NULL,
    `curr2` varchar(255) DEFAULT NULL,
    `date` datetime(6) DEFAULT NULL,
    `lprice` double DEFAULT NULL,
    PRIMARY KEY (`id_wenance_challenge`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

