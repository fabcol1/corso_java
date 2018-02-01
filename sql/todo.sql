-------TO DO SQL--------------

CREATE USER 'fab'@'%' IDENTIFIED BY 'fab';
GRANT ALL ON *.* TO 'newuser'@'%';
FLUSH PRIVILEGES;
CREATE DATABASE mydb;
USE mydb;
CREATE TABLE myTable ( nome CHAR(30), password CHAR(30) );
INSERT INTO myTable (nome,password) VALUES('fab','fab');

------------ inizio con JDBC -----------------
CREATE DATABASE testDB;
USE testDB;
CREATE USER 'test2'@'%' IDENTIFIED BY 'test2';
GRANT ALL PRIVILEGES ON testDB.* TO 'test2'@'%';
FLUSH PRIVILEGES;
CREATE TABLE testDBTable ( nome CHAR(30), password CHAR(30) );

INSERT INTO testDBTable (nome,password) VALUES('fab','fab');

----------------- QUERY SEMPLICI ---------------------
DELETE FROM testDBTable WHERE nome='LUCA';
UPDATE testDBTable SET nome='LUCA' WHERE nome='LUCAKIZ';
INSERT INTO testDBTable (nome,password) VALUES('CIAO','CIAO');
DROP TABLE testDBTable;
ALTER TABLE testDBTable UNIQUE (email);

SELECT COUNT(*) AS ids from quest;

SELECT * FROM quest ORDER BY RAND() LIMIT 1;

--------------------------------------------------------


---------------------- ESERCIZIO USER DB JAVA EE ----------------------------
USE testDB;
CREATE TABLE users ( 
	id INT NOT NULL AUTO_INCREMENT,
	email VARCHAR(255),
	password VARCHAR(30),
	PRIMARY KEY (id) );

INSERT INTO users (email, password) VALUES ('cicciokiz@luca.com', 'fab');
INSERT INTO users (email, password) VALUES ('abc@luca.com', 'fab');
INSERT INTO users (email, password) VALUES ('wer@luca.com', 'fab');
INSERT INTO users (email, password) VALUES ('qwerty@luca.com', 'fab');

ALTER TABLE users ADD UNIQUE(email);
-------------------------------- RIFACCIO LA TABELLA ----------------------------
DROP TABLE users;

CREATE TABLE users ( 
	id INT NOT NULL AUTO_INCREMENT,
	email VARCHAR(255) NOT NULL,
	password VARCHAR(30),
	PRIMARY KEY (id),
	UNIQUE (email));

INSERT INTO users (email, password) VALUES ('cicciokiz@luca.com', 'fab');
INSERT INTO users (email, password) VALUES ('abc@luca.com', 'fab');
INSERT INTO users (email, password) VALUES ('wer@luca.com', 'fab');
INSERT INTO users (email, password) VALUES ('qwerty@luca.com', 'fab');


---------------------- CREO TABELLA PER DOMANDE -----------------------------
CREATE TABLE quest ( 
	id INT NOT NULL AUTO_INCREMENT,
	domanda VARCHAR(255),
	risposte VARCHAR(255),
	corrette VARCHAR(255),
	PRIMARY KEY (id) );

INSERT INTO quest (domanda, risposte, corrette) VALUES ('Quali animali hanno 4 zampe?', 'Gatto;Cane;Scimmia;Uccellino', '0;1');
