DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS participant;
DROP TABLE IF EXISTS race;
DROP TABLE IF EXISTS race_event;

CREATE TABLE users
(
	id serial PRIMARY KEY,
	name CHARACTER VARYING (40),
	birthday date
);

INSERT INTO public.users(id, name, birthday)
	VALUES (0, 'John' ,'1967-11-20');

CREATE TABLE address
(
		id serial PRIMARY KEY,
        streetAddress CHARACTER VARYING (40),
        city CHARACTER VARYING (40) ,
        postcode CHARACTER VARYING (40)
);

INSERT INTO public.address(id, streetaddress, city, postcode)
	VALUES (0, 'gatan 1', 'staden', '42');

CREATE TABLE participant
(
 id serial PRIMARY KEY,
 name varchar(100),
 addressId INT,
 Email CHARACTER VARYING (40),
 Phone CHARACTER VARYING (40),
 Club CHARACTER VARYING (40),
 Age CHARACTER VARYING (40),
 Gender CHARACTER VARYING (40)
);

INSERT INTO participant(id, addressId, name, email, phone, club, age, gender)
values(0, 0, 'John', 'john.doe@missing.com', '0', 'klubben', '42', 'male');

CREATE TABLE race
(
 id serial PRIMARY KEY,
 name varchar(100),
 description varchar (100),
 distance varchar (100),
 fee varchar (100)
);

INSERT INTO race(id, name, description, distance, fee)
VALUES (0, 'Loppet', 'Beskrivning av loppet', '42 km', '400');

CREATE TABLE race_event
(
 id serial PRIMARY KEY,
 name varchar (100),
 description varchar (100),
 event_date date,
 event_location varchar (100)
);

INSERT INTO race_event(id, name, description, event_date, event_location)
VALUES (0, 'Naturloppet', 'Ett lopp i naturen', '2025-01-01', 'hemma' )