DROP TABLE users;
DROP TABLE userlogintoken;
DROP TABLE questiontag;
drop table surveyquestion;
DROP TABLE questioncategory;
drop table question;
drop table survey;


CREATE TABLE users (
	id bigint not null AUTO_INCREMENT, 
	email VARCHAR(100) not null,
	password VARCHAR(100),
	firstname VARCHAR(50) not null,
	lastname VARCHAR(50) not null,
	dateofbirth date,
	regdate date not null,
	role int not null,
	imgpath VARCHAR(255),
	PRIMARY KEY(id),
	CONSTRAINT uniqueEmail UNIQUE (email)
);

CREATE TABLE userlogintoken (
	id int NOT NULL AUTO_INCREMENT, 
	email VARCHAR(50),
	generated_token VARCHAR(50),
	expiration_date VARCHAR(50),
	PRIMARY KEY(id),
	CONSTRAINT uniqueToken UNIQUE (generated_token)
);

create table question (
    id bigint primary key not null auto_increment,
    label varchar(50) not null,
    description varchar(255),
    ANSA VARCHAR(255) NOT NULL DEFAULT "",
	ANSB VARCHAR(255) NOT NULL DEFAULT "",
	ANSC VARCHAR(255) NOT NULL DEFAULT "",
	ANSD VARCHAR(255) NOT NULL DEFAULT "",
	ANSE VARCHAR(255) NOT NULL DEFAULT "",
	ANSF VARCHAR(255) NOT NULL DEFAULT "",
	CANSA BIT(1) DEFAULT 0,
	CANSB BIT(1) DEFAULT 0,
	CANSC BIT(1) DEFAULT 0,
	CANSD BIT(1) DEFAULT 0,
	CANSE BIT(1) DEFAULT 0,
	CANSF BIT(1) DEFAULT 0
);
insert into question(label) values('Java');
insert into question(label) values('Spring');
insert into question(label) values('Java EE');
insert into question(label) values('Hibernate');

CREATE TABLE questioncategory(
	id bigint primary key not null auto_increment,
	label VARCHAR(50) NOT NULL,
	description VARCHAR(100)
);
INSERT INTO questioncategory(label, description) 
VALUES('Java Capitolo 1', 'Questionario Certificazione Java Capitolo 1');
INSERT INTO questioncategory(label, description) 
VALUES('Java Capitolo 2', 'Questionario Certificazione Java Capitolo 2');


create table questiontag (
    question_tag_map_id bigint primary key auto_increment,
    question_id bigint not null,
    questioncategory_id bigint not null,
    foreign key (question_id) references question(id),
    foreign key (questioncategory_id) references questioncategory(id)
);


CREATE TABLE survey(
	id bigint primary key not null auto_increment,
	label VARCHAR(50) NOT NULL,
	description VARCHAR(100)
);

create table surveyquestion (
    survey_question_map_id bigint primary key auto_increment,
    survey_id bigint not null,
    question_id bigint not null,
    foreign key (survey_id) references survey(id),
    foreign key (question_id) references question(id)
);

