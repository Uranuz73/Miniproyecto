SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS Actor_film;
DROP TABLE IF EXISTS Actor;
DROP TABLE IF EXISTS company_pelicula;
DROP TABLE IF EXISTS Company;
DROP TABLE IF EXISTS director_pelicula;
DROP TABLE IF EXISTS Director;
DROP TABLE IF EXISTS genre_film;
DROP TABLE IF EXISTS Genres;
DROP TABLE IF EXISTS usuario_pelicula;
DROP TABLE IF EXISTS Pelicula;
DROP TABLE IF EXISTS usuario;




/* Create Tables */

CREATE TABLE Actor
(
	idactor char(10) NOT NULL,
	name char(60),
	bio char(300),
	born date,
	country char(30),
	PRIMARY KEY (idactor)
);


CREATE TABLE Actor_film
(
	id char(10) NOT NULL,
	idactor char(10) NOT NULL,
	actor_name char(60),
	film_name char(60),
	PRIMARY KEY (id, idactor)
);


CREATE TABLE Company
(
	idcompany char(10) NOT NULL,
	name char(80),
	creation_date date,
	PRIMARY KEY (idcompany)
);


CREATE TABLE company_pelicula
(
	idcompany char(10) NOT NULL,
	id char(10) NOT NULL,
	PRIMARY KEY (idcompany, id)
);


CREATE TABLE Director
(
	iddirector char(10) NOT NULL,
	name char(60),
	born date,
	PRIMARY KEY (iddirector)
);


CREATE TABLE director_pelicula
(
	id char(10) NOT NULL,
	iddirector char(10) NOT NULL,
	PRIMARY KEY (id, iddirector)
);


CREATE TABLE Genres
(
	idgenre char(10) NOT NULL,
	name char(30),
	PRIMARY KEY (idgenre)
);


CREATE TABLE genre_film
(
	id char(10) NOT NULL,
	idgenre char(10) NOT NULL,
	genre_name char(30),
	PRIMARY KEY (id, idgenre)
);


CREATE TABLE Pelicula
(
	id char(10) NOT NULL,
	title char(30),
	year year(4),
	duration int,
	description char(255),
	poster char(255),
	valoration float,
	director char(60),
	full_title char(255),
	image longblob,
	type char(255),
	release_date date,
	PRIMARY KEY (id)
);


CREATE TABLE usuario
(
	idusuario int NOT NULL AUTO_INCREMENT,
	name char(30),
	password char(30),
	email char(150),
	PRIMARY KEY (idusuario)
);


CREATE TABLE usuario_pelicula
(
	idusuario int NOT NULL,
	id char(10) NOT NULL,
	PRIMARY KEY (idusuario, id)
);



/* Create Foreign Keys */

ALTER TABLE Actor_film
	ADD FOREIGN KEY (idactor)
	REFERENCES Actor (idactor)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE company_pelicula
	ADD FOREIGN KEY (idcompany)
	REFERENCES Company (idcompany)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE director_pelicula
	ADD FOREIGN KEY (iddirector)
	REFERENCES Director (iddirector)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE genre_film
	ADD FOREIGN KEY (idgenre)
	REFERENCES Genres (idgenre)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Actor_film
	ADD FOREIGN KEY (id)
	REFERENCES Pelicula (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE company_pelicula
	ADD FOREIGN KEY (id)
	REFERENCES Pelicula (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE director_pelicula
	ADD FOREIGN KEY (id)
	REFERENCES Pelicula (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE genre_film
	ADD FOREIGN KEY (id)
	REFERENCES Pelicula (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE usuario_pelicula
	ADD FOREIGN KEY (id)
	REFERENCES Pelicula (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE usuario_pelicula
	ADD FOREIGN KEY (idusuario)
	REFERENCES usuario (idusuario)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



