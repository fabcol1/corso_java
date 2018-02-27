DROP TABLE userlogintoken;

CREATE TABLE userlogintoken (
	id int NOT NULL AUTO_INCREMENT, 
	email VARCHAR(50),
	generated_token VARCHAR(50),
	expiration_date VARCHAR(50),
	PRIMARY KEY(id),
	CONSTRAINT uniqueToken UNIQUE (generated_token)
);

insert into userLoginToken (email, generated_token, expiration_date) values ("emaildiprova@prova.com", "t0k3n!=23334292", "20/02/2018 12:48:25") ;

select * from userLoginToken;