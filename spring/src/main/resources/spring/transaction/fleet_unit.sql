insert into fleet_unit(id, name, minimum_command_rank_id) values(1, 'Ударная линия', 1);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(1, 5, 1);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(1, 3, 1);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(1, 2, 2);

insert into fleet_unit(id, name, minimum_command_rank_id) values(2, 'Разведывательная линия', 1);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(2, 2, 8);

insert into fleet_unit(id, name, minimum_command_rank_id) values(3, 'Разведывательно-ударная линия', 1);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(3, 4, 1);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(3, 1, 10);

insert into fleet_unit(id, name, minimum_command_rank_id) values(4, 'Линия преследования', 1);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(4, 5, 2);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(4, 3, 6);

insert into fleet_unit(id, name, minimum_command_rank_id) values(5, 'Тяжелая ударная линия', 1);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(5, 6, 1);

insert into fleet_unit(id, name, minimum_command_rank_id) values(6, 'Тяжелая эскадра (Вариация 1)', 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(6, 5, 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(6, 1, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(6, 2, 1);

insert into fleet_unit(id, name, minimum_command_rank_id) values(7, 'Тяжелая эскадра (Вариация 2)', 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(7, 5, 3);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(7, 3, 1);

insert into fleet_unit(id, name, minimum_command_rank_id) values(8, 'Легкая эскадра (Вариация 1)', 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(8, 1, 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(8, 2, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(8, 3, 1);

insert into fleet_unit(id, name, minimum_command_rank_id) values(9, 'Легкая эскадра (Вариация 2)', 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(9, 4, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(9, 2, 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(9, 3, 1);

insert into fleet_unit(id, name, minimum_command_rank_id) values(10, 'Эскортная флотская группировка', 3);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(10, 6, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(10, 7, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(10, 8, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(10, 9, 1);

insert into fleet_unit(id, name, minimum_command_rank_id) values(11, 'Штурмовой флот', 4);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(11, 10, 2);