create table Users(
id int,
name varchar(255),
username varchar(255),
password varchar(10),
primary key (id)
);

create table Notes(
id int,
userid int,
title varchar(255),
description varchar(255),
primary key (id)
);