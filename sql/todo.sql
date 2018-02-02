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
INSERT INTO quest (domanda, risposte, corrette) VALUES ('Which of the following are valid Java identifiers? (Choose all that apply)', 'A$B;_helloWorld;true;java.lang;Publi;1980_s', '0;1;4');
INSERT INTO quest (domanda, risposte, corrette) VALUES ('Which of the following are legal entry point methods that can be run from the command line? (Choose alla that apply)', 'private static void main(String[] args);public static final main(String[] args); public void main(String[] args)', '0');
INSERT INTO quest (domanda, risposte, corrette) VALUES ('Which of the following lines of code compile? (Choose all that apply)', 'int i1 = 1_234;double d1 = 1_234_.0;double d2 = 1_234._0', '0');
INSERT INTO quest (domanda, risposte, corrette) VALUES ('Cosa ha mangiato oggi Luca?', 'Panino;Pasta;Nulla;Pizza', '2');

------------------------------------- RICREO TABELLA CON CORRETTE DIVERSO-------------------------------

DROP TABLE quest;

CREATE TABLE quest ( 
	id INT NOT NULL AUTO_INCREMENT,
	domanda VARCHAR(255),
	risposte VARCHAR(255),
	corrette VARCHAR(255),
	PRIMARY KEY (id) );

INSERT INTO quest (domanda, risposte, corrette) VALUES ('Quali animali hanno 4 zampe?', 'Gatto;Cane;Scimmia;Uccellino', 'Gatto;Cane');
INSERT INTO quest (domanda, risposte, corrette) VALUES ('Which of the following are valid Java identifiers? (Choose all that apply)', 'A$B;_helloWorld;true;java.lang;Public;1980_s', 'A$B;_helloWorld;Public');
INSERT INTO quest (domanda, risposte, corrette) VALUES ('Which of the following are legal entry point methods that can be run from the command line? (Choose alla that apply)', 'public static void main(String[] args);public static final main(String[] args); public void main(String[] args)', 'public static void main(String[] args)');
INSERT INTO quest (domanda, risposte, corrette) VALUES ('Which of the following lines of code compile? (Choose all that apply)', 'int i1 = 1_234;double d1 = 1_234_.0;double d2 = 1_234._0', 'int i1 = 1_234');
INSERT INTO quest (domanda, risposte, corrette) VALUES ('Cosa ha mangiato ieri Luca?', 'Panino;Pasta;Nulla;Pizza', 'Nulla');
INSERT INTO quest (domanda, risposte, corrette) VALUES ('Cosa ha mangiato oggi Luca?', 'Nulla;Cinese;Carciofi;Pizza', 'Cinese');

