SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `test`;

CREATE TABLE IF NOT EXISTS `wenanceChallenges` (
   `id_wenance_challenge` INT NOT NULL AUTO_INCREMENT,
   `lprice` DOUBLE NULL,
   `curr1` VARCHAR(45) NULL,
   `curr2` VARCHAR(45) NULL,
   `date` DATETIME NULL,
   PRIMARY KEY (`id_wenance_challenge`));


COMMIT;