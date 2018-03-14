drop table bitcoinhistorical;
drop table cryptoexchangevaluesprovider;
drop table currencyregistry;

CREATE TABLE cryptoexchangevaluesprovider (
	id bigint NOT NULL AUTO_INCREMENT,
	label VARCHAR(255),
	site VARCHAR(255),
	imgpath VARCHAR(255),
	PRIMARY KEY (id)
);
INSERT INTO cryptoexchangevaluesprovider(label, site) VALUES ('Okex', 'https://www.okex.com/');
INSERT INTO cryptoexchangevaluesprovider(label, site) VALUES ('Yogit', 'https://www.yobit.net/');

CREATE TABLE currencyregistry (
	id bigint NOT NULL AUTO_INCREMENT,
	label VARCHAR(255),
	symbol CHAR(1),
	PRIMARY KEY (id)
);
INSERT INTO currencyregistry(label, symbol) VALUES ('Euro', '€');
INSERT INTO currencyregistry(label, symbol) VALUES ('USD', '$');


CREATE TABLE bitcoinhistorical ( 
	id bigint NOT NULL AUTO_INCREMENT,
	exchangevalue DEC(20,2) NOT NULL,
	exchangetime DATETIME NOT NULL,
	cryptoexchangevaluesproviderid bigint NOT NULL,
	currencyregistryid bigint NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (cryptoexchangevaluesproviderid) REFERENCES cryptoexchangevaluesprovider(id),
    FOREIGN KEY (currencyregistryid) REFERENCES currencyregistry(id)
);

CREATE TABLE litecoinhistorical ( 
	id bigint NOT NULL AUTO_INCREMENT,
	exchangevalue DEC(20,2) NOT NULL,
	exchangetime DATETIME NOT NULL,
	cryptoexchangevaluesproviderid bigint NOT NULL,
	currencyregistryid bigint NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (cryptoexchangevaluesproviderid) REFERENCES cryptoexchangevaluesprovider(id),
    FOREIGN KEY (currencyregistryid) REFERENCES currencyregistry(id)
);

CREATE TABLE ethereumhistorical ( 
	id bigint NOT NULL AUTO_INCREMENT,
	exchangevalue DEC(20,2) NOT NULL,
	exchangetime DATETIME NOT NULL,
	cryptoexchangevaluesproviderid bigint NOT NULL,
	currencyregistryid bigint NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (cryptoexchangevaluesproviderid) REFERENCES cryptoexchangevaluesprovider(id),
    FOREIGN KEY (currencyregistryid) REFERENCES currencyregistry(id)
);