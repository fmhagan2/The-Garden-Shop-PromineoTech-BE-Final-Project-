DROP TABLE IF EXISTS customer_cart;
drop table if exists plant_log;
DROP TABLE IF EXISTS plant_details;
DROP TABLE IF EXISTS plants;
DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
  customer_pk int unsigned NOT NULL AUTO_INCREMENT,
  first_name varchar(45) NOT NULL, 
  last_name varchar(45) NOT NULL,
  address varchar(120),
  payment varchar(45),
  PRIMARY KEY (customer_pk)
  );

 CREATE TABLE plants (
  plant_pk int unsigned NOT NULL AUTO_INCREMENT,
  plant_name varchar(45) NOT NULL,
  plant_height int NOT NULL,
  pot_size int,
  PRIMARY KEY (plant_pk)
);

CREATE TABLE plant_details (
	details_pk int unsigned NOT NULL AUTO_INCREMENT,
	plant_fk int unsigned not null, 
    comes_back varchar(45) NOT NULL,
    flowering_type varchar(45) NOT NULL,
	amount_of_sun int unsigned NOT NULL,
    hardy_zone varchar(45) NOT NULL,
    PRIMARY KEY (details_pk),
    FOREIGN KEY (plant_fk) REFERENCES plants (plant_pk) on delete CASCADE
);

CREATE TABLE plant_log (
	log_pk int unsigned NOT NULL AUTO_INCREMENT,
	plant_fk int unsigned not null, 
    planted_date date NOT NULL,
    sprouted_date date,
    pruned_date date,
    PRIMARY KEY (log_pk),
    FOREIGN KEY (plant_fk) REFERENCES plants (plant_pk) on delete CASCADE
);

CREATE TABLE customer_cart (
  customer_pk int unsigned NOT NULL,
  plant_pk int unsigned NOT NULL,
  FOREIGN KEY (customer_pk) REFERENCES customers (customer_pk) ON DELETE CASCADE,
  FOREIGN KEY (plant_pk) REFERENCES plants (plant_pk) ON DELETE cascade,
  unique key (customer_pk, plant_pk)
  );
 
