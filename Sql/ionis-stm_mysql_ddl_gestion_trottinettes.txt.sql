CREATE TABLE utilisateurs (
  id                 bigint(19) NOT NULL AUTO_INCREMENT, 
  uuid               char(36), 
  id_document_type   varchar(255) NOT NULL, 
  id_document_number varchar(255) NOT NULL, 
  nom                varchar(100) NOT NULL, 
  prenom             varchar(100) NOT NULL, 
  email              varchar(100) NOT NULL UNIQUE, 
  telephone          varchar(20) NOT NULL UNIQUE, 
  date_enreg         timestamp NOT NULL, 
  PRIMARY KEY (id)) CHARACTER SET UTF8;
CREATE TABLE trottinettes (
  serial_number           varchar(100) NOT NULL, 
  ean                     varchar(255) NOT NULL, 
  sku                     varchar(255) NOT NULL, 
  couleur                 varchar(255), 
  version                 varchar(100), 
  latitude                double NOT NULL, 
  longitude               double NOT NULL, 
  details_complementaires varchar(2555), 
  date_enreg              timestamp NULL, 
  trottinettes_models_id  smallint(5) NOT NULL, 
  PRIMARY KEY (serial_number), 
  UNIQUE INDEX (ean), 
  UNIQUE INDEX (sku)) CHARACTER SET UTF8;
CREATE TABLE trottinettes_models (
  id                smallint(5) NOT NULL AUTO_INCREMENT, 
  model             varchar(100) NOT NULL, 
  marque            varchar(100) NOT NULL, 
  coloris           varchar(1000), 
  dimensions        varchar(100), 
  poids             double, 
  pliable           bit(1), 
  position_moteur   double, 
  puissance_moteur  int(10), 
  vitesse_max       int(10), 
  longueur          double, 
  largeur           double, 
  charge_max        double, 
  hauteur           double, 
  diametre_max_roue double, 
  autonomie_max     int(10), 
  PRIMARY KEY (id), 
  UNIQUE INDEX (model)) CHARACTER SET UTF8;
CREATE TABLE locations (
  id                         bigint(19) NOT NULL AUTO_INCREMENT, 
  ref                        varchar(10) NOT NULL, 
  date_enreg                 timestamp NOT NULL, 
  date_retour_prevu          timestamp NULL, 
  date_retour_effectif       timestamp NULL, 
  trottinettes_serial_number varchar(100) NOT NULL, 
  utilisateurs_id            bigint(19) NOT NULL, 
  PRIMARY KEY (id), 
  UNIQUE INDEX (ref)) CHARACTER SET UTF8;
CREATE TABLE trottinettes_custom_attributes (
  id                         int(10) NOT NULL AUTO_INCREMENT, 
  valeur                     varchar(100) NOT NULL, 
  value_type                 varchar(100) NOT NULL, 
  custom_attributes_id       smallint(5) NOT NULL, 
  trottinettes_serial_number varchar(100) NOT NULL, 
  PRIMARY KEY (id)) CHARACTER SET UTF8;
CREATE TABLE custom_attributes (
  id           smallint(5) NOT NULL AUTO_INCREMENT, 
  code         varchar(100) NOT NULL, 
  libelle      varchar(255) NOT NULL, 
  value_type   varchar(100), 
  values_enums varchar(255), 
  PRIMARY KEY (id), 
  UNIQUE INDEX (code)) CHARACTER SET UTF8;
CREATE TABLE locations_trackings (
  id                         bigint(19) NOT NULL AUTO_INCREMENT, 
  latitude                   double NOT NULL, 
  longitude                  double NOT NULL, 
  geo_point                  varchar(2555), 
  time                       timestamp NOT NULL, 
  trottinettes_serial_number varchar(100) NOT NULL, 
  utilisateurs_id            bigint(19) NOT NULL, 
  PRIMARY KEY (id)) CHARACTER SET UTF8;
CREATE TABLE factures (
  id               bigint(19) NOT NULL AUTO_INCREMENT, 
  ref              varchar(10) NOT NULL, 
  cout             decimal(10, 0) NOT NULL, 
  mode_paiement    varchar(255), 
  date_facturation timestamp NOT NULL, 
  date_paiement    timestamp NULL, 
  locations_id     bigint(19) NOT NULL, 
  PRIMARY KEY (id), 
  UNIQUE INDEX (ref)) CHARACTER SET UTF8;
ALTER TABLE locations ADD CONSTRAINT FKlocations793757 FOREIGN KEY (utilisateurs_id) REFERENCES utilisateurs (id);
ALTER TABLE locations ADD CONSTRAINT FKlocations884825 FOREIGN KEY (trottinettes_serial_number) REFERENCES trottinettes (serial_number);
ALTER TABLE trottinettes ADD CONSTRAINT FKtrottinett637072 FOREIGN KEY (trottinettes_models_id) REFERENCES trottinettes_models (id);
ALTER TABLE trottinettes_custom_attributes ADD CONSTRAINT FKtrottinett291612 FOREIGN KEY (custom_attributes_id) REFERENCES custom_attributes (id);
ALTER TABLE trottinettes_custom_attributes ADD CONSTRAINT FKtrottinett94753 FOREIGN KEY (trottinettes_serial_number) REFERENCES trottinettes (serial_number);
ALTER TABLE factures ADD CONSTRAINT FKfactures14491 FOREIGN KEY (locations_id) REFERENCES locations (id);
ALTER TABLE locations_trackings ADD CONSTRAINT FKlocations_102057 FOREIGN KEY (trottinettes_serial_number) REFERENCES trottinettes (serial_number);
ALTER TABLE locations_trackings ADD CONSTRAINT FKlocations_395064 FOREIGN KEY (utilisateurs_id) REFERENCES utilisateurs (id);
