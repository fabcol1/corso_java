DROP TABLE survey;
DROP TABLE users;
DROP TABLE userlogintoken;
DROP TABLE spendtime;
DROP TABLE spendtimetips;

CREATE TABLE users (
	id int NOT NULL AUTO_INCREMENT, 
	email VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	dateOfBirth date,
	regdate date,
	role int not null,
	imgpath VARCHAR(255) null,
	PRIMARY KEY(id),
	CONSTRAINT uniqueEmail UNIQUE (email)
);

CREATE TABLE survey(
	ID INT NOT NULL AUTO_INCREMENT,
	QUESTION VARCHAR(255),
	ANSA VARCHAR(255) NOT NULL DEFAULT "",
	ANSB VARCHAR(255) NOT NULL DEFAULT "",
	ANSC VARCHAR(255) NOT NULL DEFAULT "",
	ANSD VARCHAR(255) NOT NULL DEFAULT "",
	ANSE VARCHAR(255) NOT NULL DEFAULT "",
	ANSF VARCHAR(255) NOT NULL DEFAULT "",
	CANSA BIT(1) DEFAULT 0,
	CANSB BIT(1) DEFAULT 0,
	CANSC BIT(1) DEFAULT 0,
	CANSD BIT(1) DEFAULT 0,
	CANSE BIT(1) DEFAULT 0,
	CANSF BIT(1) DEFAULT 0,
	PRIMARY KEY(ID)
);
CREATE TABLE userlogintoken (
	id int NOT NULL AUTO_INCREMENT, 
	email VARCHAR(50),
	generated_token VARCHAR(50),
	expiration_date VARCHAR(50),
	PRIMARY KEY(id),
	CONSTRAINT uniqueToken UNIQUE (generated_token)
);
CREATE TABLE spendtimetips(
id int auto_increment not null,
label varchar(50),
descrizione varchar(50),
primary key(id)
);
CREATE TABLE spendtime(
id int not null auto_increment,
userID int not null,
data VARCHAR(30) not null,
ora int,
tipoOre int,
UNIQUE(id,data),
primary key(id),
FOREIGN KEY (tipoOre) REFERENCES spendtimetips (id));
