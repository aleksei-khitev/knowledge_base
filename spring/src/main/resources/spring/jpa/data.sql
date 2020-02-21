insert into command_rank(name) values('Линейный капитан');
insert into command_rank(name) values('Контр-адмирал');

insert into space_state(id, name) values(1, 'Галактическая империя');

insert into ship(type, ship_class, link) values('Корвет', 'СР90', 'http://starforge.info/rebellion-ships/cr90-corellian-corvette/');
insert into ship(type, ship_class, link) values('Эскортный фрегат','Небулон-Б 2', 'http://starforge.info/galactic-empire-ships/nebulon-b2-escort-frigate/');
insert into ship(type, ship_class, link) values('Крейсер','Аккламатор II', 'http://starforge.info/old-republic-ships/acclamator-class-cruisers/');
insert into ship(type, ship_class, link) values('Звездный Разрушитель','Охотник', 'http://starforge.info/old-republic-ships/venator-star-destroyer/');
insert into ship(type, ship_class, link) values('Звездный Разрушитель','Победа II', 'http://starforge.info/galactic-empire-ships/victory-ii-class-star-destroyer/');

insert into fleet_unit(name, minimum_command_rank_id) values('Ударная линия', 1);
insert into fleet_unit_ship(fleet_unit_id, ship_id, ship_count) values(1, 5, 1);
insert into fleet_unit_ship(fleet_unit_id, ship_id, ship_count) values(1, 3, 1);
insert into fleet_unit_ship(fleet_unit_id, ship_id, ship_count) values(1, 2, 2);

insert into fleet_unit(name, minimum_command_rank_id) values('Разведывательная линия', 1);
insert into fleet_unit_ship(fleet_unit_id, ship_id, ship_count) values(2, 2, 8);

insert into fleet_unit(name, minimum_command_rank_id) values('Разведывательно-ударная линия', 1);
insert into fleet_unit_ship(fleet_unit_id, ship_id, ship_count) values(3, 4, 1);
insert into fleet_unit_ship(fleet_unit_id, ship_id, ship_count) values(3, 1, 10);
