DROP TABLE IF EXISTS users_address;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS participant;
DROP TABLE IF EXISTS race;
DROP TABLE IF EXISTS race_event;

CREATE TABLE users
(
    id serial PRIMARY KEY,
	first_name varchar (100),
    last_name varchar (100),
    email varchar (100),
    phone varchar (100),
    club varchar (100),
    age integer,
    gender varchar (100)
);

INSERT INTO public.users(first_name, last_name, email, phone, club, age, gender)
	VALUES ('John', 'doe', 'john.doe@missing.com', '0', 'klubben', 42, 'male'),
	('Jane', 'doe', 'mary.doe@missing.com', '0', 'klubben', 41, 'female');;

CREATE TABLE address
(
		id serial PRIMARY KEY,
		address_id integer,
        streetAddress CHARACTER VARYING (40),
        city CHARACTER VARYING (40) ,
        postcode CHARACTER VARYING (40)
);

INSERT INTO public.address(id, streetaddress, city, postcode)
	VALUES (0, 'gatan 1', 'staden', '42');

CREATE TABLE participant
(
 id serial PRIMARY KEY,
 user_id integer,
 start_number integer,
 Status CHARACTER VARYING (40)
);

INSERT INTO participant(id, user_id, start_number, status)
values(0, 0, 0, 'not_started');

CREATE TABLE race
(
 id serial PRIMARY KEY,
 name varchar(100),
 description varchar (100),
 distance varchar (100),
 fee integer
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