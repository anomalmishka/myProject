create table air_plane (id bigint generated by default as identity, is_active boolean, number_seat_buisness integer, number_seat_lowcost integer, status varchar(255), type varchar(255), air_company_id bigint, primary key (id));
insert into air_plane (id, is_active, number_seat_buisness, number_seat_lowcost, status, type, air_company_id)
values
(null, true, 1, 5, 'Ready to fly', 'Boing747', 1);

