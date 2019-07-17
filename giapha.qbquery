create database genealogy_management;

USE genealogy_management;

-- Table Account
CREATE TABLE account(
	account_name varchar(50) PRIMARY KEY,
    password varchar(20) NOT NULL,
    role int NOT NULL
);

insert into account values ('admin1','12345',1),
('admin','12345',1),
('member','12345',0),
('systemadmin','123456',2);

-- Table Parentage
CREATE TABLE parentage(
	parentage_id int PRIMARY KEY AUTO_INCREMENT,
    parentage_name varchar(50) NOT NULL,
    head_of_parentage_name varchar(30) NOT NULL,
    address varchar(100) NOT NULL,
    cultural_spring_day date,
    cultural_autumn_day date,
    head_of_parentage_number varchar(11),
    head_of_parentage_email varchar(50),
    head_of_parentage_address varchar(100),
    ancestor text,
    history_of_parentage text,
    convention_of_parentage text,
    cult_portion_land text,
    account_name varchar(50),

    FOREIGN KEY (account_name) REFERENCES account(account_name)
    ON DELETE CASCADE ON UPDATE CASCADE
);

insert into parentage(parentage_name,head_of_parentage_name,address
,cultural_spring_day, cultural_autumn_day, head_of_parentage_number,
head_of_parentage_email, head_of_parentage_address, ancestor,
history_of_parentage, convention_of_parentage, cult_portion_land,
account_name) values
('Jaime','Jame Lannister','London','1300-6-4','1300/10/14', '0965930913','phamvanhieu300198@gmail.com'
,'Lodon','Twin Lannister','once upon ago', 'No Mercy', 'Surray','admin');

-- Table Individual
CREATE TABLE individual(
	individual_id int PRIMARY KEY AUTO_INCREMENT,
    fullname varchar(30) NOT NULL,
    gender bit NOT NULL,
    date_of_birth date,
    date_of_death date,
    father int,
    branch varchar(30),
    parentage_id int,
    avatar varchar(100),
    FOREIGN KEY (parentage_id) REFERENCES parentage(parentage_id)
    ON DELETE CASCADE  ON UPDATE CASCADE
);

insert into individual(fullname,gender,date_of_birth,date_of_death
,father,branch,parentage_id,avatar) values
('Tywin Lannister',1,'1985-6-5','1985-6-5',0,'1',1,''),
('Sersei Lannister',0,'1985-6-5','1985-6-5',1,'1-2',1,''),
('Jaime Lannister',1,'1985-6-5','1985-6-5',1,'1-3',1,''),
('Tyrion Lannister',1,'1985-6-5','1985-6-5',3,'1-3-4',1,''),
('Samwell Lannister',1,'1985-6-5','1985-6-5',3,'1-3-5',1,''),
('Stannis Lannister',1,'1985-6-5','1985-6-5',4,'1-3-4-6',1,'');


-- Table Image
CREATE TABLE image(
	id int primary key auto_increment,
    image_name varchar(50),
    url varchar(255),
    parentage_id int ,
    FOREIGN KEY (parentage_id) REFERENCES parentage(parentage_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);