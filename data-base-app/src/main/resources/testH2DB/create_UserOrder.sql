create table user_order (id bigint generated by default as identity, flight_route_id bigint, status_id bigint, passenger_profile_id bigint, primary key (id));
insert into user_order (id, flight_route_id, status_id, passenger_profile_id)
values
(null, 1, 1, 1);
