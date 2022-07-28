alter table air_plane add constraint FKor6b30umeovr2tltbp3mo17c7 foreign key (air_company_id) references air_company;
alter table air_plane_flight_route_list add constraint FKln02mbhbnhda2weblrlvfu58d foreign key (flight_route_list_id) references flight_route;
alter table air_plane_flight_route_list add constraint FKppoend9ldbn4g3edsodd673sk foreign key (air_plane_id) references air_plane;
alter table bank_card add constraint FKg03auw65t3fm5x8s9orbncj1x foreign key (user_profile_id) references user_profile;
alter table flight_route_air_plane_list add constraint FKl1r639ni2mfwjwe5ljg9ms289 foreign key (air_plane_list_id) references air_plane;
alter table flight_route_air_plane_list add constraint FKh1oos2k4sds9m75iilbkgnmeu foreign key (flight_route_id) references flight_route;
alter table passenger_profile add constraint FK5pogumd4gnx81yhtjfc5xhw78 foreign key (user_profile_id) references user_profile;
alter table seat add constraint FKbedpgiibtqurewoxbermx41i5 foreign key (air_plane_id) references air_plane;
alter table user_order add constraint FKmnkfw5ay2hght5xqp51a7oe94 foreign key (flight_route_id) references flight_route;
alter table user_order add constraint FKt2kyveq81viy16pe1o8xp8edd foreign key (passenger_profile_id) references passenger_profile;
alter table user_order add constraint FKahaarjxatrv2hlawivwilgkad foreign key (status_id) references status;