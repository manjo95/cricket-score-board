CREATE DATABASE SCOREBOARD;

USE SCOREBOARD;

CREATE TABLE users (
                       user_id  	int NOT NULL AUTO_INCREMENT,
                       username 	varchar(45) NOT NULL unique,
                       email 	varchar(45) NOT NULL,
                       password 	varchar(64) NOT NULL,
                       enabled 	int DEFAULT NULL,
                       PRIMARY KEY (user_id),
                       UNIQUE KEY email_UNIQUE (email)
);

CREATE TABLE roles (
                       role_id 	int NOT NULL AUTO_INCREMENT,
                       name 		varchar(45) NOT NULL,
                       PRIMARY KEY (role_id)
);

CREATE TABLE users_roles (
                             user_id int NOT NULL,
                             role_id int NOT NULL,
                             KEY user_fk_idx (user_id),
                             KEY role_fk_idx (role_id),
                             CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES roles (role_id),
                             CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE teams (
                       id 		int NOT NULL AUTO_INCREMENT,
                       name 	varchar(32) NOT NULL UNIQUE,
                       PRIMARY KEY (id)
);

CREATE TABLE players(
                        id	 		int NOT NULL AUTO_INCREMENT,
                        Team_id 	int NOT NULL,
                        name 		varchar(32) NOT NULL,
                        Player_photo BLOB,
                        PRIMARY KEY (id),
                        CONSTRAINT playerteam_fk FOREIGN KEY (Team_id) REFERENCES teams (id)
);

CREATE TABLE matches (
                         id	 	int NOT NULL AUTO_INCREMENT,
                         name 	varchar(32) NOT NULL,
                         overs 	int NOT NULL,
                         venue 	varchar(32) NOT NULL,
                         winner 	int,
                         looser 	int,
                         PRIMARY KEY (id),
                         CONSTRAINT match_winner_fk FOREIGN KEY (winner) references teams (id),
                         CONSTRAINT match_looser_fk FOREIGN KEY (looser) references teams (id)
);

CREATE TABLE matchdetails(
                             id			int	NOT NULL AUTO_INCREMENT,
                             matchid		int NOT NULL,
                             playerid	int NOT NULL,
                             singles		int,
                             fours		int,
                             sixes		int,
                             PRIMARY KEY(id),
                             Constraint match_det_match_fk FOREIGN KEY (matchid) REFERENCES matches (id),
                             Constraint match_det_PLYR_fk FOREIGN KEY (playerid) REFERENCES players (id)
);

INSERT INTO users(username, email, password, enabled) VALUES ('admin','admin@gmail.com', '$2y$10$ckBLJmCTPkbsu.yTL/uvzux5NPenNECjdAIsv8z0Dk/7XDYpNF82S', 1);
INSERT INTO users(username, email, password, enabled) VALUES ('newuser','newuser@gmail.com', '$2y$10$ckBLJmCTPkbsu.yTL/uvzux5NPenNECjdAIsv8z0Dk/7XDYpNF82S', 1);
INSERT INTO users(username, email, password, enabled) VALUES ('manoj', 'manoj@gmail.com', '$2y$10$ckBLJmCTPkbsu.yTL/uvzux5NPenNECjdAIsv8z0Dk/7XDYpNF82S', 1);
INSERT INTO users(username, email, password, enabled) VALUES ('jonam', 'jonam@gmail.com', '$2y$10$ckBLJmCTPkbsu.yTL/uvzux5NPenNECjdAIsv8z0Dk/7XDYpNF82S', 1);

INSERT INTO roles (name) values ("ADMIN");
INSERT INTO roles (name) values ("USER");

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1); -- user admin has role ADMIN
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2); -- user newuser has role USER
INSERT INTO users_roles (user_id, role_id) VALUES (3, 1); -- user manoj has role ADMIN
INSERT INTO users_roles (user_id, role_id) VALUES (4, 2); -- jonam patrick has role USER