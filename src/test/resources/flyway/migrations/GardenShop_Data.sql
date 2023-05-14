-- Customers
INSERT INTO customers (first_name, last_name, address, payment) VALUES('Paris', 'Hilton', '123 Main St, Hollywood CA 90210', 'VISA');
INSERT INTO customers (first_name, last_name, address, payment) VALUES('Doja', 'Cat', '420 High St, Tampa FL 33601', 'BITCOIN');
INSERT INTO customers (first_name, last_name, address, payment) VALUES('Tom', 'Hardy', '101 State St, New York NY 10009', 'AMEX');
INSERT INTO customers (first_name, last_name, address, payment) VALUES('Tim', 'Cook', '600 Apply Way, Silcone Valley CA 90054', 'CASH');

-- Plants
INSERT INTO plants (plant_name, plant_height) VALUES('Periwinkle Clematis', 36);
INSERT INTO plants (plant_name, plant_height) VALUES('Magenta Clematis', 30);
INSERT INTO plants (plant_name, plant_height, pot_size) VALUES('Monstera', 42, 18);
INSERT INTO plants (plant_name, plant_height) VALUES('Peony', 24);
INSERT INTO plants (plant_name, plant_height, pot_size) VALUES('Petunia', 1, 2);

-- Plant Details
INSERT INTO plant_details (plant_fk, comes_back, flowering_type, amount_of_sun, hardy_zone) VALUES (1, 'Perennial', 'Blooms spring to fall', 6, '4-8');
INSERT INTO plant_details (plant_fk, comes_back, flowering_type, amount_of_sun, hardy_zone) VALUES (2, 'Perennial', 'Blooms spring to fall', 6, '4-8');
INSERT INTO plant_details (plant_fk, comes_back, flowering_type, amount_of_sun, hardy_zone) VALUES (3, 'Potted', 'Foliage', 6, '10-12');
INSERT INTO plant_details (plant_fk, comes_back, flowering_type, amount_of_sun, hardy_zone) VALUES (4, 'Perennial', 'Blooms in spring', 6, '3-8');
INSERT INTO plant_details (plant_fk, comes_back, flowering_type, amount_of_sun, hardy_zone) VALUES (5, 'Annual in zones <9', 'Blooms spring to fall', 5, '9-11');

-- Plant Log
INSERT INTO plant_log (plant_fk, planted_date, sprouted_date, pruned_date) VALUES (1, '2019-05-01', '2019-06-10', '2019-10-30');
INSERT INTO plant_log (plant_fk, planted_date, sprouted_date, pruned_date) VALUES (2, '2019-05-01', '2019-06-10', '2019-10-30');
INSERT INTO plant_log (plant_fk, planted_date, sprouted_date) VALUES (3, '2019-04-1', '2019-03-11');
INSERT INTO plant_log (plant_fk, planted_date, sprouted_date, pruned_date) VALUES (5, '2019-06-22', '2020-03-12', '2020-10-30');
INSERT INTO plant_log (plant_fk, planted_date, sprouted_date, pruned_date) VALUES (6, '2019-05-01', '2019-06-10', '2019-10-30');


