CREATE TABLE user_profile (
    id                  bigserial         PRIMARY KEY,
    email               varchar(255),
    is_blocket_profile  boolean,
    lastname            varchar(255),
    username            varchar(255),
    phone               integer,
    user_id             integer
);
create table bank_card (
    id                  bigserial         primary key,
    card_number         BIGINT,
    user_profile_id     integer
);
create table passenger_profile (
    id                  bigserial         primary key,
    lastname            varchar(255),
    username            varchar(255),
    passport_number     varchar(255),
    user_profile_id     integer
);
create table status (
    id                  bigserial         primary key,
    status              varchar(255)
);
create table air_company (
    id                  bigserial         primary key,
    country_location    varchar(255),
    name_company        varchar(255)
);
create table air_plane (
    id                      bigserial         primary key,
    is_active               boolean,
    number_seat_buisness    integer,
    number_seat_lowcost     integer,
    status                  varchar(255),
    type                    varchar(255),
    air_company_id          integer
);
create table seat (
    id                  bigserial         primary key,
    is_ordered          boolean,
    place               varchar(255),
    type                varchar(255),
    air_plane_id        integer
);
create table flight_route (
    id                  bigserial         primary key,
    distance            integer,
    flight_date_end     timestamp,
    flight_date_start   timestamp,
    is_active           boolean,
    price               integer,
    route_end           varchar(255),
    route_start         varchar(255)
);
create table air_plane_flight_route (
    id                  bigserial         primary key,
    air_plane_id        integer,
    flight_route_id     integer
);
create table user_order (
    id                      bigserial         primary key,
    flight_route_id         integer,
    status_id               integer,
    passenger_profile_id    integer
);
INSERT INTO user_profile (email, is_blocket_profile, lastname, username, phone, user_id)
VALUES
('abrakadabra@gmail.com', false, 'Yazvinski', 'Maksim', 998877, 1),
('admin@gmail.com', false, 'Admin', 'Admin', 999999, 2);
insert into bank_card (card_number, user_profile_id)
values
(1111222233334444, 1),
(4444333322221111, 1),
(1111222211112222, 2),
(3333444433334444, 2);
insert into passenger_profile (lastname, username, passport_number, user_profile_id)
values
('Yazvinski', 'Maksim', 'KK1100110', 1),
('Admin', 'Admin', 'KK1111111', 2);
insert into status (status)
values
('PAID_FOR'),
('ORDERED'),
('CANCELLED');
insert into air_company (country_location, name_company)
values
('Minsk', 'Belavia'),
('Moskva', 'Aeroflot'),
('London', 'Boing');
insert into air_plane (is_active, number_seat_buisness, number_seat_lowcost, status, type, air_company_id)
values
(true, 1, 5, 'Ready to fly', 'Boing747', 1),
(true, 1, 5, 'Ready to fly', 'Boing747', 2),
(true, 1, 5, 'Ready to fly', 'Boing747', 2),
(true, 1, 5, 'Ready to fly', 'Boing747', 2),
(true, 1, 6, 'Ready to fly', 'Sukhoi Superjet 100', 2),
(true, 1, 6, 'Ready to fly', 'Sukhoi Superjet 100', 2),
(true, 1, 6, 'Ready to fly', 'Sukhoi Superjet 100', 2),
(true, 1, 7, 'Ready to fly', 'Airbus A320', 3),
(true, 1, 7, 'Ready to fly', 'Airbus A320', 3),
(true, 1, 7, 'Ready to fly', 'Airbus A320', 3),
(true, 1, 7, 'Ready to fly', 'Airbus A320', 3),
(true, 1, 7, 'Ready to fly', 'Airbus A320', 3),
(true, 1, 7, 'Ready to fly', 'Airbus A320', 3);
insert into seat (is_ordered, place, type, air_plane_id)
values
(true, '1A','Lowcost', 1),
(true, '1A','Lowcost', 2),
(true, '1B','Lowcost', 2),
(false, '1C','Lowcost', 2),
(false, '1D','Lowcost', 2),
(false, '1E','Lowcost', 2),
(false, '1A','Lowcost', 2);
insert into flight_route (distance, flight_date_end, flight_date_start, is_active, price, route_end, route_start)
values
(1000, '2022-07-03 13:00:00','2022-07-03 12:00:00', true, 200, 'Moskva', 'Minsk'),
(1000, '2022-07-03 17:00:00','2022-07-03 16:00:00', true, 200, 'Minsk', 'Moskva'),
(2000, '2022-07-03 23:00:00','2022-07-03 20:00:00', true, 600, 'London', 'Minsk'),
(2000, '2022-07-04 15:00:00','2022-07-04 12:00:00', true, 600, 'Minsk', 'London'),
(2000, '2022-07-04 19:00:00','2022-07-04 16:00:00', true, 200, 'Paris', 'Minsk'),
(2000, '2022-07-04 23:00:00','2022-07-04 20:00:00', true, 500, 'Minsk', 'Paris'),
(2000, '2022-07-05 15:00:00','2022-07-05 12:00:00', true, 500, 'Paris', 'Minsk'),
(3000, '2022-07-05 21:00:00','2022-07-05 16:00:00', true, 700, 'Moskva', 'Paris'),
(3000, '2022-07-06 01:00:00','2022-07-05 20:00:00', true, 800, 'London', 'Moskva'),
(3000, '2022-07-05 17:00:00','2022-07-05 12:00:00', true, 800, 'Moskva', 'London'),
(3000, '2022-07-05 21:00:00','2022-07-05 16:00:00', true, 700, 'Paris', 'Moskva'),
(1000, '2022-07-05 22:00:00','2022-07-05 20:00:00', true, 300, 'London', 'Paris');
insert into air_plane_flight_route (air_plane_id, flight_route_id)
values
(1, 1),
(2, 2),
(3, 2),
(4, 3),
(5, 3),
(6, 3),
(4, 4),
(5, 4),
(6, 4),
(7, 5),
(8, 5),
(9, 5),
(7, 6),
(8, 6),
(9, 6),
(10, 7),
(11, 7),
(12, 7),
(10, 8),
(11, 8),
(12, 8),
(3, 9),
(5, 9),
(2, 10),
(4, 10),
(6, 10),
(7, 11),
(9, 11),
(11, 11),
(8, 12),
(10, 12),
(12, 12);
insert into user_order (flight_route_id, status_id, passenger_profile_id)
values
(1, 1, 1),
(2, 1, 2);
