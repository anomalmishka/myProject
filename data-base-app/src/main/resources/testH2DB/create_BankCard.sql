create table bank_card (id bigint generated by default as identity, bank ENUM('BELARUSBANK', 'BELINVESTBANK', 'PRIORBANK'),card_number bigint, card_type ENUM('VISA', 'MASTERCARD'), holder_lastname varchar(255), holder_name varchar(255), service_end_date timestamp, user_id bigint, primary key (id));
insert into bank_card (id, bank,card_number, card_type, holder_lastname, holder_name, service_end_date, user_id)
values
(null, 'BELARUSBANK', 1111222233334444, 'VISA', 'Yazvinski', 'Maksim', '2024-07-01 00:00:00', 1),
(null, 'BELINVESTBANK', 4444333322221111, 'MASTERCARD', 'Yazvinski', 'Maksim', '2024-07-01 00:00:00', 1),
(null, 'PRIORBANK', 1111222211112222, 'VISA', 'Admin', 'Admin', '2024-07-01 00:00:00', 2),
(null, 'BELINVESTBANK', 3333444433334444, 'MASTERCARD', 'Admin', 'Admin', '2024-07-01 00:00:00', 2);