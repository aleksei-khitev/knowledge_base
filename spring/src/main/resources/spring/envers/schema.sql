CREATE TABLE space_state (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(100) NOT NULL UNIQUE,
 version INT NOT NULL DEFAULT 0,
 PRIMARY KEY(id)
);
CREATE TABLE command_rank (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(50) NOT NULL UNIQUE,
 version INT NOT NULL DEFAULT 0,
 PRIMARY KEY(id)
);
CREATE TABLE fleet_unit (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(50) NOT NULL UNIQUE,
 minimum_command_rank_id VARCHAR(50),
 version INT NOT NULL DEFAULT 0,
 PRIMARY KEY(id),
 CONSTRAINT fk_command_rank FOREIGN KEY(minimum_command_rank_id) REFERENCES command_rank(id)
);
CREATE TABLE ship (
 id INT NOT NULL AUTO_INCREMENT,
 type VARCHAR(50) NOT NULL,
 ship_class VARCHAR(50) NOT NULL,
 link VARCHAR(200) NOT NULL,
 version INT NOT NULL DEFAULT 0,
 UNIQUE uq_ship_1 (type, ship_class),
 PRIMARY KEY(id),
);
CREATE TABLE fleet_unit_composition_by_ships (
 id INT NOT NULL AUTO_INCREMENT,
 fleet_unit_id INT NOT NULL,
 ship_id INT NOT NULL,
 ship_count INT NOT NULL,
 version INT NOT NULL DEFAULT 0,
 PRIMARY KEY(id),
 CONSTRAINT fk_fleet_unit FOREIGN KEY(fleet_unit_id) REFERENCES fleet_unit(id),
 CONSTRAINT fk_ship FOREIGN KEY(ship_id) REFERENCES ship(id)
);
CREATE TABLE fleet_unit_composition_by_fleet_units (
 id INT NOT NULL AUTO_INCREMENT,
 parent_fleet_unit_id INT NOT NULL,
 child_fleet_unit_id INT NOT NULL,
 fleet_unit_count INT NOT NULL,
 version INT NOT NULL DEFAULT 0,
 PRIMARY KEY(id),
 CONSTRAINT fk_parent_fleet_unit FOREIGN KEY(parent_fleet_unit_id) REFERENCES fleet_unit(id),
 CONSTRAINT fk_child_fleet_unit FOREIGN KEY(child_fleet_unit_id) REFERENCES fleet_unit(id)
);