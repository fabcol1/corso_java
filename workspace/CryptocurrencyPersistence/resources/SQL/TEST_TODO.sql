----------------------- TEST DB -----------------------------------
CREATE DATABASE cryptocurrencytest;
USE cryptocurrencytest;
CREATE USER 'cryptousertest'@'%' IDENTIFIED BY 'cryptousertest';
GRANT ALL PRIVILEGES ON cryptocurrencytest.* TO 'cryptousertest'@'%';
FLUSH PRIVILEGES;

-- DROP TABLE bitcoin;
-- DROP TABLE tipo_valuta;
-- DROP TABLE from_where;

CREATE TABLE from_where (
	id INT NOT NULL AUTO_INCREMENT,
	label VARCHAR(255),
	weburl VARCHAR(255),
	imgpath VARCHAR(255),
	PRIMARY KEY (id)
);
INSERT INTO from_where(label, weburl) VALUES ('Okex', 'https://www.okex.com/');


CREATE TABLE tipo_valuta (
	id INT NOT NULL AUTO_INCREMENT,
	label VARCHAR(255),
	simbolo CHAR(1),
	PRIMARY KEY (id)
);
INSERT INTO tipo_valuta(label, simbolo) VALUES ('Euro', '€');
INSERT INTO tipo_valuta(label, simbolo) VALUES ('USD', '$');

CREATE TABLE bitcoin ( 
	id INT NOT NULL AUTO_INCREMENT,
	cambio_valore DEC(20,2) NOT NULL,
	data_valore DATETIME NOT NULL,
	id_from INT NOT NULL,
	id_valuta INT NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (id_from) REFERENCES from_where(id),
    FOREIGN KEY (id_valuta) REFERENCES tipo_valuta(id)
);

CREATE TABLE litecoin ( 
	id INT NOT NULL AUTO_INCREMENT,
	cambio_valore DEC(20,2) NOT NULL,
	data_valore DATETIME NOT NULL,
	id_from INT NOT NULL,
	id_valuta INT NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (id_from) REFERENCES from_where(id),
    FOREIGN KEY (id_valuta) REFERENCES tipo_valuta(id)
);

CREATE TABLE ethereum ( 
	id INT NOT NULL AUTO_INCREMENT,
	cambio_valore DEC(20,2) NOT NULL,
	data_valore DATETIME NOT NULL,
	id_from INT NOT NULL,
	id_valuta INT NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (id_from) REFERENCES from_where(id),
    FOREIGN KEY (id_valuta) REFERENCES tipo_valuta(id)
);
