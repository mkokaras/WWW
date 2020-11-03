create database productdb;
use productdb;
create table products(
barcode varchar(100) not null,
color varchar(100) not null,
name varchar(100) not null,
description varchar(1000) not null,
primary key(barcode));  