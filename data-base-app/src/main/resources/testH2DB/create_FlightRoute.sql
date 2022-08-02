create table flight_route (id bigint generated by default as identity, distance integer, flight_date_end timestamp, flight_date_start timestamp, is_active boolean, price integer, route_end varchar(255), route_start varchar(255), primary key (id));
insert into flight_route (id, distance, flight_date_end, flight_date_start, is_active, price, route_end, route_start)
values
(null, 1000, '2022-07-03 13:00:00','2022-07-03 12:00:00', true, 200, 'Moskva', 'Minsk'),
(null, 2000, '2022-07-03 23:00:00','2022-07-03 20:00:00', true, 600, 'London', 'Minsk'),
(null, 3000, '2022-07-05 17:00:00','2022-07-05 12:00:00', true, 800, 'Moskva', 'London');
