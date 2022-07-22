create table seat (id bigint generated by default as identity, is_ordered boolean, place varchar(255), type varchar(255), air_plane_id bigint, primary key (id));
insert into seat (id, is_ordered, place, type, air_plane_id)
values
(null, true, '1A','Lowcost', 1),
(null, true, '1B','Lowcost', 1),
(null, false, '1C','Lowcost', 1),
(null, false, '1D','Lowcost', 1),
(null, false, '1E','Lowcost', 1),
(null, false, '1A','Lowcost', 1);