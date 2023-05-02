drop database cogent_do_connect;
create database cogent_do_connect;
use cogent_do_connect;
create table User(id int, name varchar(40), username varchar(40), password varchar(40), email varchar(40), userType varchar(40), PRIMARY KEY (ID));
create table Question(id int, description_question varchar(40), image_src varchar(40), datetime varchar(40), status varchar(40), topic varchar(40), title varchar(40), PRIMARY KEY (ID));
create table Answer(id int, description_question varchar(40), image_src varchar(40), datetime varchar(40), status varchar(40), PRIMARY KEY (ID));
create table Chat(id int, fromuser varchar(40), touser varchar(40), message varchar(40), datetime varchar(40), PRIMARY KEY (ID));

ALTER TABLE Question ADD CONSTRAINT qcreated_id FOREIGN KEY (id) REFERENCES User (id);
ALTER TABLE Question ADD CONSTRAINT qapproved_by FOREIGN KEY (id) REFERENCES User (id);

ALTER TABLE Answer ADD CONSTRAINT acreated_id FOREIGN KEY (id) REFERENCES User (id);
ALTER TABLE Answer ADD CONSTRAINT aapproved_by FOREIGN KEY (id) REFERENCES User (id);

ALTER TABLE Answer ADD CONSTRAINT aapproved_by FOREIGN KEY (id) REFERENCES User (id);

ALTER TABLE Question ADD CONSTRAINT question FOREIGN KEY (id) REFERENCES Answer (id);
ALTER TABLE Answer ADD CONSTRAINT answer FOREIGN KEY (id) REFERENCES Question (id);

INSERT INTO Chat VALUES (2, "name1", "name2", "message1", "dt1");

select * from user;
select * from chat;