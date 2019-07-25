create database employees;
use employees;
CREATE TABLE employee ( id int unsigned not null auto_increment, full_name varchar(128) not null, id_number varchar(8) not null, constraint pk_example primary key (id) );
INSERT INTO employee ( id, full_name, id_number ) VALUES ( null, 'Sample Name', 'EX000000' );
