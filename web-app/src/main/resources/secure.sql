insert into authorities (id, authorities_name)
values
(1, 'USER'),
(2, 'MANAGER'),
(3, 'ADMIN');
insert into user_login (id, account_non_expired, account_non_locked, credentials_non_expired, enabled, userpassword, username)
values
(1, true, true, true, true, '$2a$12$bOVEohs92cz4EaRUWsiBJOzsLL4emLEkEEkQGw6UrMcFbsd8OJyHW', 'user'),
(2, true, true, true, true, '$2a$12$Xyy7tAjJWLIb3rf9j9uc4OfDsf5dsLKZjF/awksri1IzOZbha7cHi', 'manager'),
(3, true, true, true, true, '$2a$12$1Vjdo9ygapFpLjCvfCqHZeIGAkVhdlCaKpZnWK0ksrzQd4f01aR.q', 'admin');
insert into user_login_authorities (user_login_id, authorities_id)
values
(1,1),
(2,2),
(3,3);

