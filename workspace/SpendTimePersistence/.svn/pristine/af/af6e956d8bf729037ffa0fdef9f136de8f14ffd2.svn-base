CREATE TABLE spendTime(
id int not null,
data VARCHAR(30) not null,
UNIQUE(id,data),
ora int,
tipoOre int,
primary key(id),
FOREIGN KEY (tipoOre) REFERENCES spendTimeTips (id)
);