CREATE TABLE authorities (
    id                  bigserial         PRIMARY KEY,
    authorities_name    varchar(255)
);
CREATE TABLE user_login (
    id                       bigserial       PRIMARY KEY,
    account_non_expired      boolean,
    account_non_locked       boolean,
    credentials_non_expired  boolean,
    enabled                  boolean,
    userpassword             varchar(255),
    username                 varchar(255)
);
CREATE TABLE user_login_authorities (
    user_login_id       integer         NOT NULL,
    authorities_id      integer         NOT NULL
);
insert into authorities (authorities_name)
values
('USER'),
('MANAGER'),
('ADMIN');
insert into user_login (account_non_expired, account_non_locked, credentials_non_expired, enabled, userpassword, username)
values
(true, true, true, true, '$2a$12$bOVEohs92cz4EaRUWsiBJOzsLL4emLEkEEkQGw6UrMcFbsd8OJyHW', 'user'),
(true, true, true, true, '$2a$12$Xyy7tAjJWLIb3rf9j9uc4OfDsf5dsLKZjF/awksri1IzOZbha7cHi', 'manager'),
(true, true, true, true, '$2a$12$1Vjdo9ygapFpLjCvfCqHZeIGAkVhdlCaKpZnWK0ksrzQd4f01aR.q', 'admin');
insert into user_login_authorities (user_login_id, authorities_id)
values
(1,1),
(2,2),
(3,3);

