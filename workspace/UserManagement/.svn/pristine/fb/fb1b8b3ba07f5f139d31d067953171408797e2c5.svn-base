DROP TABLE users;
CREATE TABLE users (
	id int NOT NULL AUTO_INCREMENT, 
	email VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	borndate date,
	regdate date,
	role int not null,
	PRIMARY KEY(id),
	CONSTRAINT uniqueEmail UNIQUE (email)
);
insert into users (email, password, role) values ("pippo", "pluto", 10) ;
select * from users ;