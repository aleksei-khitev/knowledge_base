insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(1, 'Ударная линия v1', 1, '3-6 судов. если крейсеры или тяж крейсеры - не более 3. Задачи: открытое противостояние вражеским корабельным соединениям аналогичного уровня; нападение на ранее обнаруженные базы; обеспечением безопасности судоходства');
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(1, 9, 1);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(1, 7, 2);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(12, 'Ударная линия v2', 1, '3-6 судов. если легкие крейсеры и фрегаты - 6. Задачи: открытое противостояние вражеским корабельным соединениям аналогичного уровня; нападение на ранее обнаруженные базы; обеспечением безопасности судоходства');
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(12, 3, 3);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(12, 5, 3);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(2, 'Разведывательная линия', 1, '4-8 кораблей. Легкие крейсеры, фрегаты, сец. модификации. Задачи: обнаружение кораблей или баз противника и наведении на них УЛ или ТУЛ; Если же противник начинал атаку РЛ, отходить, не вступая в бой');
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(2, 3, 2);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(2, 18, 6);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(3, 'Разведывательно-ударная линия', 1, '4-20 корветов. Задачи: преследование, перехват и уничтожение легких вражеских кораблей и судов, а также групп МЛА (истребителей и бомбардировщиков) в различных тактических ситуациях');
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(3, 1, 20);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(4, 'Линия преследования', 1, '4-10 кораблей. как правило легкие крейсеры. Задачи: преследования отступающего противника; не удалось перехватить цель, просчитать вектор гиперпрыжка и последовать за отступающим противником; перехват вражеских эскадр на этапах промежуточных гиперпространственных переходов и связывание их боем до подхода УЛ или ТУЛ');
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(4, 5, 5);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(4, 1, 5);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(5, 'Тяжелая ударная линия v1', 1, 'Победа или Империал мог считаться ТУЛом');
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(5, 15, 1);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(5, 2, 2);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(13, 'Тяжелая ударная линия v2', 1, '4-8 кораблей не ниже легкого крейсера');
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(13, 9, 1);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(13, 10, 1);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(13, 7, 2);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(13, 5, 4);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(20, 'Тяжелая ударная линия v3', 1, 'Победа или Империал мог считаться ТУЛом');
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(20, 14, 1);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(20, 2, 2);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(14, 'Торпедная линия', 1, 'Задачи: уничтожения планетарных генераторов защитного поля; проведения орбитальной бомбардировки');
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(14, 17, 2);

insert into fleet_unit(id, name, minimum_command_rank_id) values(15, 'Десантная линия', 1);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(15, 8, 2);
insert into fleet_unit_composition_by_ships(fleet_unit_id, ship_id, ship_count) values(15, 12, 2);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(6, 'Тяжелая эскадра v1', 2, 'Задачи: доразведку и основной удар по кораблям противника или охраняемому ими объекту; охраны стратегически важного объекта в открытом космосе; обеспечение блокады или охраны орбитального пространства вокруг планеты');
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(6, 5, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(6, 13, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(6, 1, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(6, 2, 1);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(7, 'Тяжелая эскадра v2', 2, 'Задачи: доразведку и основной удар по кораблям противника или охраняемому ими объекту; охраны стратегически важного объекта в открытом космосе; обеспечение блокады или охраны орбитального пространства вокруг планеты');
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(7, 5, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(7, 13, 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(7, 3, 1);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(21, 'Тяжелая эскадра v3', 2, 'Задачи: доразведку и основной удар по кораблям противника или охраняемому ими объекту; охраны стратегически важного объекта в открытом космосе; обеспечение блокады или охраны орбитального пространства вокруг планеты');
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(21, 20, 1);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(8, 'Легкая эскадра v1', 2, 'Задачи: действовать в регионах где, как считается, нет крупных сил противника обладающих тяжелыми крейсерами или линкорами; патрулированием проблемных регионов; разведывательные операции; сопровождения конвоев; рейдовые операции; если ЛЭ встречает сильное сопротивление - отступить и призвать на помощь крупные соединения имеющие корабли более тяжелого класса');
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(8, 1, 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(8, 12, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(8, 2, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(8, 3, 1);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(9, 'Легкая эскадра v2', 2, 'Задачи: действовать в регионах где, как считается, нет крупных сил противника обладающих тяжелыми крейсерами или линкорами; патрулированием проблемных регионов; разведывательные операции; сопровождения конвоев; рейдовые операции; если ЛЭ встречает сильное сопротивление - отступить и призвать на помощь крупные соединения имеющие корабли более тяжелого класса');
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(9, 4, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(9, 2, 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(9, 3, 1);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(16, 'Линейная эскадра', 2, 'Основной тип соединений имперского флота для боя с эскадрами противника обладающих тяжелыми крейсерами или линкорами');
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(16, 5, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(16, 1, 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(16, 4, 1);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(17, 'Десантная эскадра', 2, 'Выполнения крупных десантных операций имперской армии и, изредка, штурмового корпуса. Легионы штурмовиков редко пользуются услугами ДЭ из-за того, что чаще всего высаживаются с борта Звездного Разрушителя, прибывая на театр военных действий (ТВД) раньше армейской группировки');
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(17, 15, 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(17, 12, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(17, 3, 1);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(18, 'Бомбардировочная эскадра', 2, 'Для произведения разрушительных орбитальных бомбардировок и оказания огневой поддержки наземным подразделениям');
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(18, 14, 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(18, 3, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(18, 4, 1);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(10, 'Эскортная флотская группировка', 3, 'Защита судоходства в важных системах, обеспечение безопасности станций и орбитального пространства крупных планет, таможенный досмотр судов прибывающих и покидающих систему и борьба с пиратами.');
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(10, 6, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(10, 7, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(10, 8, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(10, 9, 1);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(19, 'Ударная флотская группировка', 3, 'Задача: обеспечение полного отсутствия враждебных кораблей в орбитальном пространстве контролируемых миров и прекращение их деятельности во всей системе');
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(19, 16, 3);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(19, 8, 2);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(22, 'Транспортная флотская группировка', 3, 'Осуществление стратегической десантной операции против хорошо вооруженного и многочисленного противника окопавшегося на поверхности планеты');
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(22, 21, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(22, 8, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(22, 17, 2);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(23, 'Бомбардировочная флотская группировка', 3, 'База-Дельта-Ноль');
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(23, 18, 3);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(23, 8, 1);

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(24, 'Корабельное соединение технической поддержки', 3, 'КСТП можно по праву назвать подвижной ремонтной мастерской и одновременно эвакуационной службой. В состав соединения входят восемь судов, часто являющихся Evakmar-KDY или переоборудованными тяжелыми транспортниками. На борту этих судов находится множество технических специалистов, небольших ремонтных ботов и запас запчастей, двигателей, гипердвигателей и отдельных элементов корабельных силовых установок');

insert into fleet_unit(id, name, minimum_command_rank_id, comments) values(25, 'Военно-транспортное корабельное соединение', 3, 'Типичное ВТКС полного состава включало более 100 судов всех размеров и классов. Помимо транспортников в состав соединения входили госпитальные (медицинские) корабли. Экипажи комплектовались квалифицированным техническим и медицинским персоналом, имели специализированные дроиды (в том числе дроиды-грузчики) и небольшие боты. Возможности ВТКС позволяли осуществлять доставку на корабли припасов прямо в космосе.');

insert into fleet_unit(id, name, minimum_command_rank_id) values(11, 'Штурмовой флот', 4);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(11, 10, 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(11, 22, 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(11, 24, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(11, 25, 1);

insert into fleet_unit(id, name, minimum_command_rank_id) values(26, 'Ударный флот', 4);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(26, 19, 3);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(26, 10, 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(26, 24, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(26, 25, 1);

insert into fleet_unit(id, name, minimum_command_rank_id) values(27, 'Бомбардировочный флот', 4);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(27, 23, 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(27, 10, 2);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(27, 24, 1);
insert into fleet_unit_composition_by_fleet_units(parent_fleet_unit_id, child_fleet_unit_id, fleet_unit_count) values(27, 25, 1);