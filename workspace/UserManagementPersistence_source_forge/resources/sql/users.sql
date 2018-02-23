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
	imgpath Varchar(50) null,
	PRIMARY KEY(id),
	CONSTRAINT uniqueEmail UNIQUE (email)
);
insert into users (email, password, firstname, lastname, borndate, regdate, role, imgpath) values ("pippo", "pluto", "Filippo", "Plutoni", "1987-12-08", "2018-02-08", 10, "./default_img.jpg") ;
select * from users ;