drop table invite;
drop table person;
drop table roles;
drop table requestInvite;
drop table users;
drop table groups;

CREATE TABLE roles
(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(50),
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE person
(
id INT NOT NULL AUTO_INCREMENT,
version INT,
username VARCHAR(50) UNIQUE,
password VARCHAR(50),
role INT,
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE users
(
userid INT NOT NULL AUTO_INCREMENT,
version INT,
groupid INT NOT NULL,
firstname VARCHAR(50),
lastname VARCHAR(50),
person INT,
PRIMARY KEY (userid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE groups
(
groupid INT NOT NULL AUTO_INCREMENT,
version INT,
name VARCHAR(50),
description VARCHAR(200),
PRIMARY KEY (groupid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE invite
(
id INT NOT NULL AUTO_INCREMENT,
version INT,
userid INT,
groupid INT,
PRIMARY KEY (id),
UNIQUE(userid, groupid),
FOREIGN KEY (userid) REFERENCES users(userid),
FOREIGN KEY (groupid) REFERENCES groups(groupid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE requestInvite
(
id INT NOT NULL AUTO_INCREMENT,
version INT,
userid INT,
groupid INT,
PRIMARY KEY (id),
UNIQUE(userid, groupid),
FOREIGN KEY (userid) REFERENCES users(userid),
FOREIGN KEY (groupid) REFERENCES groups(groupid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into roles(name) values("Guest");
insert into roles(name) values("Student");
insert into roles(name) values("Admin");

insert into groups(version,name,description) values(1,"Team Captains", "blah blah");
insert into groups(version,name,description) values(1,"Team Blah", "jada jada");

insert into person(version,username,password,role) values(1,"shaun1","29f491121c63af2a883378c50e1f8d9f",3);
insert into person(version,username,password,role) values(1,"captkirk","29f491121c63af2a883378c50e1f8d9f",2);
insert into person(version,username,password,role) values(1,"captpicard","29f491121c63af2a883378c50e1f8d9f",2);
insert into person(version,username,password,role) values(1,"captjaneway","29f491121c63af2a883378c50e1f8d9f",2);
insert into person(version,username,password,role) values(1,"captKev","29f491121c63af2a883378c50e1f8d9f",3);
insert into person(version,username,password,role) values(1,"captAli","29f491121c63af2a883378c50e1f8d9f",2);
insert into person(version,username,password,role) values(1,"paquito","29f491121c63af2a883378c50e1f8d9f",3);

insert into users(version,groupid,firstname,lastname,person) values(1,1,"Shaun","McDaddy",1);
insert into users(version,groupid,firstname,lastname,person) values(1,1,"Captain","Kirk",2);
insert into users(version,groupid,firstname,lastname,person) values(1,1,"Captain","Picard",3);
insert into users(version,groupid,firstname,lastname,person) values(1,2,"Captain","Janeway",4);
insert into users(version,groupid,firstname,lastname,person) values(1,0,"General","Kevin",5);
insert into users(version,groupid,firstname,lastname,person) values(1,0,"Major","Ali",6);
insert into users(version,groupid,firstname,lastname,person) values(1,2,"VP","Paquito",7);



insert into invite(version, userid,groupid) values(1,5,1);
insert into invite(version, userid,groupid) values(1,6,1);

insert into requestInvite(version,userid,groupid) values(1,5,1);
insert into requestInvite(version,userid,groupid) values(1,5,2);
