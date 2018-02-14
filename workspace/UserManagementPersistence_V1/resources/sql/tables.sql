DROP TABLE users;
CREATE TABLE users (
     id INT(5) NOT NULL AUTO_INCREMENT,	
	email VARCHAR(60) NOT NULL,
	password VARCHAR(20) NOT NULL,		
    PRIMARY KEY(id),
    UNIQUE (email)
);
insert into users (email, password) values ("pippo", "pluto") ;
select * from users ;