CREATE TABLE authorities (
    id                  bigserial         PRIMARY KEY,
    authorities_name    varchar(255)
);
CREATE TABLE user_login (
    id                  bigserial       PRIMARY KEY,
    enabled             boolean,
    userpassword        varchar(255),
    username            varchar(255)
);
CREATE TABLE user_login_authorities (
    user_login_id       integer         NOT NULL,
    authorities_id      integer         NOT NULL
);
INSERT INTO authorities (authorities_name)
VALUES
('USER'),
('MANAGER'),
('ADMIN');
INSERT INTO user_login (enabled, userpassword, username)
VALUES
(true, '$2a$12$bOVEohs92cz4EaRUWsiBJOzsLL4emLEkEEkQGw6UrMcFbsd8OJyHW', 'userLogin'),
(true, '$2a$12$Xyy7tAjJWLIb3rf9j9uc4OfDsf5dsLKZjF/awksri1IzOZbha7cHi', 'manager'),
(true, '$2a$12$1Vjdo9ygapFpLjCvfCqHZeIGAkVhdlCaKpZnWK0ksrzQd4f01aR.q', 'admin');
INSERT INTO user_login_authorities (user_login_id, authorities_id)
VALUES
(1,1),
(2,2),
(3,3);