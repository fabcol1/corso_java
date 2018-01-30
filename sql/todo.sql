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