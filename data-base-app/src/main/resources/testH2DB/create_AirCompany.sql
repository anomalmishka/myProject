create table air_company (id bigint generated by default as identity, country_location varchar(255), name_company varchar(255), price_buisness_index integer, price_lowcost_index integer, primary key (id));
insert into air_company (id, country_location, name_company, price_buisness_index, price_lowcost_index)
values
(null, 'Minsk', 'Belavia', 2, 1),
(null, 'Moskva', 'Aeroflot', 3, 1),
(null, 'London', 'Boing', 4, 2);