-- --------------------------------------------------------
-- Hôte:                         127.0.0.1
-- Version du serveur:           5.7.39 - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Listage de la structure de la base pour trottinettes-db
CREATE DATABASE IF NOT EXISTS `trottinettes-db` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `trottinettes-db`;

-- Listage de la structure de table trottinettes-db. custom_attributes
CREATE TABLE IF NOT EXISTS `custom_attributes` (
  `id` smallint(5) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `value_type` varchar(100) DEFAULT NULL,
  `values_enums` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Listage des données de la table trottinettes-db.custom_attributes : ~3 rows (environ)
REPLACE INTO `custom_attributes` (`id`, `code`, `libelle`, `value_type`, `values_enums`) VALUES
	(1, 'siteWeb', 'Site WEB', 'string', NULL),
	(2, 'image1', 'Image Principale', 'string', NULL),
	(3, 'imageBrand', 'Logo de marque', 'string', NULL);

-- Listage de la structure de table trottinettes-db. factures
CREATE TABLE IF NOT EXISTS `factures` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `ref` varchar(10) NOT NULL,
  `cout` decimal(10,0) NOT NULL,
  `mode_paiement` varchar(255) DEFAULT NULL,
  `date_facturation` timestamp NOT NULL,
  `date_paiement` timestamp NULL DEFAULT NULL,
  `locations_id` bigint(19) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ref` (`ref`),
  KEY `FKfactures14491` (`locations_id`),
  CONSTRAINT `FKfactures14491` FOREIGN KEY (`locations_id`) REFERENCES `locations` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Listage des données de la table trottinettes-db.factures : ~5 rows (environ)
REPLACE INTO `factures` (`id`, `ref`, `cout`, `mode_paiement`, `date_facturation`, `date_paiement`, `locations_id`) VALUES
	(1, 'F12022022', 1000, 'cash', '2022-02-12 11:03:25', '2022-02-12 11:03:25', 1),
	(2, 'F13022022', 1000, 'card', '2022-02-13 11:03:25', '2022-02-13 11:03:25', 2),
	(3, 'F11112022', 1000, 'card', '2022-11-11 11:03:25', '2022-11-11 11:03:25', 3),
	(4, 'F13052022', 1000, 'cash', '2022-05-13 10:03:25', '2022-05-13 10:03:25', 4),
	(5, 'F11052022', 1000, 'cash', '2022-05-11 10:03:25', '2022-05-11 10:03:25', 5);

-- Listage de la structure de table trottinettes-db. locations
CREATE TABLE IF NOT EXISTS `locations` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `ref` varchar(10) NOT NULL,
  `date_enreg` timestamp NOT NULL,
  `date_retour_prevu` timestamp NULL DEFAULT NULL,
  `date_retour_effectif` timestamp NULL DEFAULT NULL,
  `trottinettes_serial_number` varchar(100) NOT NULL,
  `utilisateurs_id` bigint(19) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ref` (`ref`),
  KEY `FKlocations793757` (`utilisateurs_id`),
  KEY `FKlocations884825` (`trottinettes_serial_number`),
  CONSTRAINT `FKlocations793757` FOREIGN KEY (`utilisateurs_id`) REFERENCES `utilisateurs` (`id`),
  CONSTRAINT `FKlocations884825` FOREIGN KEY (`trottinettes_serial_number`) REFERENCES `trottinettes` (`serial_number`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Listage des données de la table trottinettes-db.locations : ~5 rows (environ)
REPLACE INTO `locations` (`id`, `ref`, `date_enreg`, `date_retour_prevu`, `date_retour_effectif`, `trottinettes_serial_number`, `utilisateurs_id`) VALUES
	(1, 'AA12022022', '2022-02-12 11:03:25', NULL, NULL, '012022', 2),
	(2, 'AA13022022', '2022-02-13 11:03:25', NULL, NULL, '022022', 1),
	(3, 'AA11112022', '2022-11-11 11:03:25', NULL, NULL, '012022', 3),
	(4, 'AA13052022', '2022-05-13 10:03:25', NULL, NULL, '022022', 1),
	(5, 'AA11052022', '2022-05-11 10:03:25', NULL, NULL, '022022', 3);

-- Listage de la structure de table trottinettes-db. locations_trackings
CREATE TABLE IF NOT EXISTS `locations_trackings` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `geo_point` varchar(2555) DEFAULT NULL,
  `time` timestamp NOT NULL,
  `trottinettes_serial_number` varchar(100) NOT NULL,
  `utilisateurs_id` bigint(19) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlocations_102057` (`trottinettes_serial_number`),
  KEY `FKlocations_395064` (`utilisateurs_id`),
  CONSTRAINT `FKlocations_102057` FOREIGN KEY (`trottinettes_serial_number`) REFERENCES `trottinettes` (`serial_number`),
  CONSTRAINT `FKlocations_395064` FOREIGN KEY (`utilisateurs_id`) REFERENCES `utilisateurs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table trottinettes-db.locations_trackings : ~0 rows (environ)

-- Listage de la structure de table trottinettes-db. trottinettes
CREATE TABLE IF NOT EXISTS `trottinettes` (
  `serial_number` varchar(100) NOT NULL,
  `ean` varchar(255) NOT NULL,
  `sku` varchar(255) NOT NULL,
  `couleur` varchar(255) DEFAULT NULL,
  `version` varchar(100) DEFAULT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `details_complementaires` varchar(2555) DEFAULT NULL,
  `date_enreg` timestamp NULL DEFAULT NULL,
  `trottinettes_models_id` smallint(5) NOT NULL,
  PRIMARY KEY (`serial_number`),
  UNIQUE KEY `ean` (`ean`),
  UNIQUE KEY `sku` (`sku`),
  KEY `FKtrottinett637072` (`trottinettes_models_id`),
  CONSTRAINT `FKtrottinett637072` FOREIGN KEY (`trottinettes_models_id`) REFERENCES `trottinettes_models` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table trottinettes-db.trottinettes : ~2 rows (environ)
REPLACE INTO `trottinettes` (`serial_number`, `ean`, `sku`, `couleur`, `version`, `latitude`, `longitude`, `details_complementaires`, `date_enreg`, `trottinettes_models_id`) VALUES
	('012022', '2000', 'st-2000', 'rouge', '1', 0, 0, 'LIVRAISON GRATUITE Commandes', '2022-01-07 10:45:38', 1),
	('022022', '3000', 'st-3000', 'noir', '1', 0, 0, 'LIVRAISON GRATUITE Commandes', '2022-01-30 10:45:39', 2);

-- Listage de la structure de table trottinettes-db. trottinettes_custom_attributes
CREATE TABLE IF NOT EXISTS `trottinettes_custom_attributes` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `valeur` varchar(100) NOT NULL,
  `value_type` varchar(100) NOT NULL,
  `custom_attributes_id` smallint(5) NOT NULL,
  `trottinettes_serial_number` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtrottinett291612` (`custom_attributes_id`),
  KEY `FKtrottinett94753` (`trottinettes_serial_number`),
  CONSTRAINT `FKtrottinett291612` FOREIGN KEY (`custom_attributes_id`) REFERENCES `custom_attributes` (`id`),
  CONSTRAINT `FKtrottinett94753` FOREIGN KEY (`trottinettes_serial_number`) REFERENCES `trottinettes` (`serial_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Listage des données de la table trottinettes-db.trottinettes_custom_attributes : ~0 rows (environ)

-- Listage de la structure de table trottinettes-db. trottinettes_models
CREATE TABLE IF NOT EXISTS `trottinettes_models` (
  `id` smallint(5) NOT NULL AUTO_INCREMENT,
  `model` varchar(100) NOT NULL,
  `marque` varchar(100) NOT NULL,
  `coloris` varchar(1000) DEFAULT NULL,
  `dimensions` varchar(100) DEFAULT NULL,
  `poids` double DEFAULT NULL,
  `pliable` bit(1) DEFAULT NULL,
  `position_moteur` double DEFAULT NULL,
  `puissance_moteur` int(10) DEFAULT NULL,
  `vitesse_max` int(10) DEFAULT NULL,
  `longueur` double DEFAULT NULL,
  `largeur` double DEFAULT NULL,
  `charge_max` double DEFAULT NULL,
  `hauteur` double DEFAULT NULL,
  `diametre_max_roue` double DEFAULT NULL,
  `autonomie_max` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `model` (`model`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Listage des données de la table trottinettes-db.trottinettes_models : ~3 rows (environ)
REPLACE INTO `trottinettes_models` (`id`, `model`, `marque`, `coloris`, `dimensions`, `poids`, `pliable`, `position_moteur`, `puissance_moteur`, `vitesse_max`, `longueur`, `largeur`, `charge_max`, `hauteur`, `diametre_max_roue`, `autonomie_max`) VALUES
	(1, 'ES80', 'STOCKAOVOPRO', NULL, NULL, NULL, NULL, NULL, 350, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '365GO ', 'STOCKAOVOPRO', NULL, NULL, NULL, NULL, NULL, 350, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3, 'M365 Pro', 'STOCKAOVOPRO', NULL, NULL, NULL, NULL, NULL, 350, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- Listage de la structure de table trottinettes-db. utilisateurs
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `uuid` char(36) DEFAULT NULL,
  `id_document_type` varchar(255) NOT NULL,
  `id_document_number` varchar(255) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `date_enreg` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `telephone` (`telephone`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Listage des données de la table trottinettes-db.utilisateurs : ~3 rows (environ)
REPLACE INTO `utilisateurs` (`id`, `uuid`, `id_document_type`, `id_document_number`, `nom`, `prenom`, `email`, `telephone`, `date_enreg`) VALUES
	(1, '7b6cff45-13df-4cd2-a9ce-9dced9fd25a2', 'passport', 'AA502022', 'nkumbe', 'aurelien', 'nkaurelien@gmail.com', '0677889944', '2022-11-07 10:36:16'),
	(2, '3d65b370-1d93-47da-94e3-0eda8c045a6c', 'passport', 'AA132022', 'tamo', 'kevin', 'tamo@gmail.com', '0655689944', '2022-11-07 10:36:16'),
	(3, 'faf92b9b-d5b6-4191-8423-bc7d0ebf2227', 'passport', 'AA732022', 'sima bella', 'ludovic', 'ludo@gmail.com', '0655684455', '2022-11-07 10:36:16');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
