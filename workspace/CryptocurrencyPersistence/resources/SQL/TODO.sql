---------------- DEV DB ------------------------------------------------
CREATE DATABASE cryptocurrency;
USE cryptocurrency;
CREATE USER 'cryptouser'@'%' IDENTIFIED BY 'cryptouser';
GRANT ALL PRIVILEGES ON cryptocurrency.* TO 'cryptouser'@'%';
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

INSERT INTO bitcoin(cambio_valore, data_valore, id_from, id_valuta) VALUES(10299.23, '2012-06-18 10:34:09', 1, 2);

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

INSERT INTO litecoin(cambio_valore, data_valore, id_from, id_valuta) VALUES(199.23, '2012-06-18 10:34:09', 1, 2);


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

INSERT INTO ethereum(cambio_valore, data_valore, id_from, id_valuta) VALUES(10299.23, '2012-06-18 10:34:09', 1, 2);

