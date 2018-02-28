

DROP TABLE spendtime;
CREATE TABLE spendtime(
id int not null auto_increment,
userID int not null,
data VARCHAR(30) not null,
ora int,
tipoOre int,
UNIQUE(id,data),
primary key(id),
FOREIGN KEY (tipoOre) REFERENCES spendtimetips (id)
);

INSERT INTO spendtime (id, userID, data, ora, tipoOre) VALUES (1 , 1, '20-02-2018', 6, 1 );

SELECT * FROM spendtime;
