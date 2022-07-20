create table passenger_profile (id bigint generated by default as identity, lastname varchar(255), name varchar(255), passport_number varchar(255), ticket_id bigint, user_profile_id bigint, primary key (id));
insert into passenger_profile (id, lastname, name, passport_number, ticket_id, user_profile_id)
values
(null, 'Yazvinski', 'Maksim', 'KK1100110',1, 1),
(null, 'Admin', 'Admin', 'KK1111111', 2, 2);