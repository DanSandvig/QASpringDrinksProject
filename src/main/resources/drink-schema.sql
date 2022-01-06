DROP TABLE IF EXISTS drink CASCADE;
CREATE TABLE `drink` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `volume_ml` int(4) NOT NULL,
  `carbonated` bool NOT NULL,
  `stock` int(4) NOT NULL,
  PRIMARY KEY (`id`)
);