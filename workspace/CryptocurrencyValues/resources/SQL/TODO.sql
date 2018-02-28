CREATE DATABASE testdb;
USE testdb;
CREATE USER 'test3'@'%' IDENTIFIED BY 'test3';
GRANT ALL PRIVILEGES ON testdb.* TO 'test3'@'%';
FLUSH PRIVILEGES;

CREATE TABLE crypto_from (
	id INT NOT NULL AUTO_INCREMENT,
	from_where VARCHAR(255),
	PRIMARY KEY (id),
	UNIQUE (from_where)
);

INSERT INTO crypto_from (from_where) VALUES ('https://www.okex.com');

CREATE TABLE crypto_valute (
	id INT NOT NULL AUTO_INCREMENT,
	tipologia VARCHAR(255),
	valore DEC(10,2),
	from_where VARCHAR(255),
	data_when DATE,
	PRIMARY KEY (id),
	FOREIGN KEY (from_where) REFERENCES crypto_from(from_where),
	CONSTRAINT uniqueCombo UNIQUE (tipologia, from_where, data_when)
);
INSERT INTO crypto_valute (tipologia, valore, from_where, data_when) VALUES ('Bitcoin BTC', 10000,'https://www.okex.com' ,'2012-06-18 10:34:09');

