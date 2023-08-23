insert into command_rank(id, name) values(1, 'Линейный капитан');
insert into command_rank(id, name) values(2, 'Контр-адмирал');
insert into command_rank(id, name) values(3, 'Адмирал');
insert into command_rank(id, name) values(4, 'Адмирал флота');

insert into space_state(id, name) values(1, 'Галактическая империя');

insert into ship(id, type, ship_class, link) values(1, 'Корвет', 'СР90', 'http://starforge.info/rebellion-ships/cr90-corellian-corvette/');
insert into ship(id, type, ship_class, link) values(2, 'Эскортный фрегат','Небулон-Б 2', 'http://starforge.info/galactic-empire-ships/nebulon-b2-escort-frigate/');
insert into ship(id, type, ship_class, link) values(3, 'Крейсер','Аккламатор II', 'http://starforge.info/old-republic-ships/acclamator-class-cruisers/');
insert into ship(id, type, ship_class, link) values(4, 'Звездный Разрушитель','Охотник', 'http://starforge.info/old-republic-ships/venator-star-destroyer/');
insert into ship(id, type, ship_class, link) values(5, 'Звездный Разрушитель','Победа II', 'http://starforge.info/galactic-empire-ships/victory-ii-class-star-destroyer/');
insert into ship(id, type, ship_class, link) values(6, 'Звездный Разрушитель','Империал I', 'http://starforge.info/galactic-empire-ships/imperator-i-class-star-destroyer/');

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