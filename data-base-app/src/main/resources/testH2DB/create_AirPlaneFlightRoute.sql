create table air_plane_flight_route (air_plane_id bigint not null, flight_route_id bigint not null);
insert into air_plane_flight_route (air_plane_id, flight_route_id)
values
( 1, 1),
( 1, 2),
( 1, 3),
( 2, 1),
( 2, 2),
( 2, 3),
( 3, 1),
( 3, 2),
( 3, 3);