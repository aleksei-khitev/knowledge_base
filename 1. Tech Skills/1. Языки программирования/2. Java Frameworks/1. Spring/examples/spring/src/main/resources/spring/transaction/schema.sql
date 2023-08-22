CREATE TABLE space_state (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(100) NOT NULL UNIQUE,
 version INT NOT NULL DEFAULT 0,
 PRIMARY KEY(id)
);

CREATE TABLE ship (
 id INT NOT NULL AUTO_INCREMENT,
 type VARCHAR(50) NOT NULL,
 ship_class VARCHAR(50) NOT NULL,
 producer VARCHAR(50) NOT NULL,
 cost INT,
 autonomy INT,
 link VARCHAR(200) NOT NULL,
 version INT NOT NULL DEFAULT 0,
 comment VARCHAR(200),
 UNIQUE uq_ship_1 (type, ship_class),
 PRIMARY KEY(id),
);
CREATE TABLE ship_size (
 ship_id INT NOT NULL,
 ship_length INT,
 ship_width INT,
 ship_height INT,
 version INT NOT NULL DEFAULT 0,
 PRIMARY KEY(ship_id),
);
CREATE TABLE ship_crew (
 ship_id INT NOT NULL,
 minimal INT,
 normal INT,
 version INT NOT NULL DEFAULT 0,
 PRIMARY KEY(ship_id),
);
CREATE TABLE ship_speed (
 ship_id INT NOT NULL,
 space_speed INT,
 atmosphere_speed INT,
 main_hyper_drive_class INT,
 backup_hyper_drive_class INT,
 version INT NOT NULL DEFAULT 0,
 PRIMARY KEY(ship_id),
);
CREATE TABLE ship_defence (
 ship_id INT NOT NULL,
 shields INT,
 hp INT,
 dr INT,
 damage_threshold INT,
 version INT NOT NULL DEFAULT 0,
 PRIMARY KEY(ship_id),
);
CREATE TABLE weapon (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(250) NOT NULL,
 version INT NOT NULL DEFAULT 0,
 PRIMARY KEY(id),
);
CREATE TABLE ship_weapon (
 id INT NOT NULL AUTO_INCREMENT,
 ship_id INT NOT NULL,
 weapon_id INT NOT NULL,
 weapon_count INT NOT NULL,
 version INT NOT NULL DEFAULT 0,
 PRIMARY KEY(id),
 CONSTRAINT fk_weapon FOREIGN KEY(weapon_id) REFERENCES weapon(id),
 CONSTRAINT fk_ship_1 FOREIGN KEY(ship_id) REFERENCES ship(id)
);
CREATE TABLE small_aircraft (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(50) NOT NULL,
 crew INT,
 link VARCHAR(250),
 version INT NOT NULL DEFAULT 0,
 PRIMARY KEY(id),
);
CREATE TABLE ship_hanger (
 id INT NOT NULL AUTO_INCREMENT,
 ship_id INT NOT NULL,
 small_aircraft_id INT NOT NULL,
 small_aircraft_count INT NOT NULL,
 version INT NOT NULL DEFAULT 0,
 PRIMARY KEY(id),
 CONSTRAINT fk_small_aircraft FOREIGN KEY(small_aircraft_id) REFERENCES small_aircraft(id),
 CONSTRAINT fk_ship_2 FOREIGN KEY(ship_id) REFERENCES ship(id)
);
CREATE TABLE land_force (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(50) NOT NULL,
 crew INT,
 link VARCHAR(250),
 version INT NOT NULL DEFAULT 0,
 PRIMARY KEY(id),
);
CREATE TABLE ship_landing_deck (
 id INT NOT NULL AUTO_INCREMENT,
 ship_id INT NOT NULL,
 land_force_id INT NOT NULL,
 landing_deck_count INT NOT NULL,
 version INT NOT NULL DEFAULT 0,
 PRIMARY KEY(id),
 CONSTRAINT fk_landing_deck FOREIGN KEY(land_force_id) REFERENCES land_force(id),
 CONSTRAINT fk_ship_3 FOREIGN KEY(ship_id) REFERENCES ship(id)
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
 comments VARCHAR,
 PRIMARY KEY(id),
 CONSTRAINT fk_command_rank FOREIGN KEY(minimum_command_rank_id) REFERENCES command_rank(id)
);
CREATE TABLE fleet_unit_composition_by_ships (
 id INT NOT NULL AUTO_INCREMENT,
 fleet_unit_id INT NOT NULL,
 ship_id INT NOT NULL,
 ship_count INT NOT NULL,
 version INT NOT NULL DEFAULT 0,
 PRIMARY KEY(id),
 CONSTRAINT fk_fleet_unit FOREIGN KEY(fleet_unit_id) REFERENCES fleet_unit(id),
 CONSTRAINT fk_ship_4 FOREIGN KEY(ship_id) REFERENCES ship(id)
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