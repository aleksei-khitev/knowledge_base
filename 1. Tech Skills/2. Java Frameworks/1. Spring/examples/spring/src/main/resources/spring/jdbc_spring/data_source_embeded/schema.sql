CREATE TABLE fleet_unit (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(50) NOT NULL UNIQUE,
 PRIMARY KEY(id)
);
CREATE TABLE ship (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(50) NOT NULL,
 type VARCHAR(50) NOT NULL,
 ship_class VARCHAR(50) NOT NULL,
 fleet_unit_id INT NOT NULL,
 UNIQUE uq_ship_1 (name, ship_class, fleet_unit_id),
 PRIMARY KEY(id),
 CONSTRAINT fk_fleet_unit FOREIGN KEY(fleet_unit_id) REFERENCES fleet_unit(id)
);
