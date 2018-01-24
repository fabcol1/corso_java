-------TO DO SQL--------------

CREATE USER 'fab'@'%' IDENTIFIED BY 'fab';
GRANT ALL ON *.* TO 'newuser'@'%';
FLUSH PRIVILEGES;

CREATE DATABASE mydb;

USE mydb;

CREATE TABLE myTable ( nome CHAR(30), password CHAR(30) );

INSERT INTO myTable (nome,password) VALUES('fab','fab');