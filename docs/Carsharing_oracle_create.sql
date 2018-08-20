CREATE TABLE user_data (
	id number(15),
	surname varchar2(50),
	name varchar2(50),
	middle_name varchar2(50),
	pass_ser_and_num varchar2(25),
	pass_issued_by_whom varchar2(200),
	pass_issued_when DATE,
	date_of_birth DATE,
	place_of_birth varchar2(200),
	driv_lic_ser_and_num varchar2(25),
	driv_lic_issued_by_whom varchar2(200),
	driv_lic_issued_when DATE,
	driv_lic_valid_until DATE,
	driv_lic_category varchar2(20),
	photo varchar2(500),
	email varchar2(100),
	password varchar2(2000),
	phone number(20),
	role varchar2(50),
	date_create DATE,
    date_update DATE,
	constraint USER_PK PRIMARY KEY (id)
);
CREATE sequence "USER_DATA_SEQ";

CREATE TABLE car (
	id number(15),
	id_user number(15),
	brand varchar2(50),
	model varchar2(50),
	year_of_issue DATE,
	gov_number varchar2(50),
	run number(10),
	seats number(3),
	car_location varchar2(500),
	gearbox_type number(15),
	body_type number(15),
	drive_unit number(15),
	engine_type number(15),
	fuel_type number(15),
	fuel_consumption varchar2(50),
	car_condition varchar2(500),
	optional_accessories varchar2(300),
	insurance_info varchar2(300),
	price_per_day number(20,2),
	text varchar2(2000),
	avallability_begin DATE,
	avallability_end DATE,
	verified number(1),
	constraint CAR_PK PRIMARY KEY (id)
);
CREATE sequence "CAR_SEQ";

CREATE TABLE car_catalog (
	id number(15),
	catalog_type number(2),
	catalog_name_type varchar2(100),
	name varchar2(100),
	constraint CAR_CATALOG_PK PRIMARY KEY (id)
);
CREATE sequence "CAR_CATALOG_SEQ";

CREATE TABLE car_photo (
	id number(15),
	id_car number(15),
	photo_path varchar2(500),
	constraint CAR_PHOTO_PK PRIMARY KEY (id)
);
CREATE sequence "CAR_PHOTO_SEQ";

CREATE TABLE car_reservation (
	id number(15),
	id_user number(15),
	id_car number(15),
	reservation_begin DATE,
	reservation_end DATE,
	approved number(1),
	cancellation number(1),
	constraint CAR_RESERVATION_PK PRIMARY KEY (id)
);
CREATE sequence "CAR_RESERVATION_SEQ";

CREATE TABLE car_favorites (
	id number(15),
	id_user number(15),
	id_car number(15),
	constraint CAR_FAVORITES_PK PRIMARY KEY (id)
);
CREATE sequence "CAR_FAVORITES_SEQ";


ALTER TABLE car ADD CONSTRAINT car_fk0 FOREIGN KEY (id_user) REFERENCES user_data(id);
ALTER TABLE car ADD CONSTRAINT car_fk1 FOREIGN KEY (gearbox_type) REFERENCES car_catalog(id);
ALTER TABLE car ADD CONSTRAINT car_fk2 FOREIGN KEY (body_type) REFERENCES car_catalog(id);
ALTER TABLE car ADD CONSTRAINT car_fk3 FOREIGN KEY (drive_unit) REFERENCES car_catalog(id);
ALTER TABLE car ADD CONSTRAINT car_fk4 FOREIGN KEY (engine_type) REFERENCES car_catalog(id);
ALTER TABLE car ADD CONSTRAINT car_fk5 FOREIGN KEY (fuel_type) REFERENCES car_catalog(id);


ALTER TABLE car_photo ADD CONSTRAINT car_photo_fk0 FOREIGN KEY (id_car) REFERENCES car(id);

ALTER TABLE car_reservation ADD CONSTRAINT car_reservation_fk0 FOREIGN KEY (id_user) REFERENCES user_data(id);
ALTER TABLE car_reservation ADD CONSTRAINT car_reservation_fk1 FOREIGN KEY (id_car) REFERENCES car(id);

ALTER TABLE car_favorites ADD CONSTRAINT car_favorites_fk0 FOREIGN KEY (id_user) REFERENCES user_data(id);
ALTER TABLE car_favorites ADD CONSTRAINT car_favorites_fk1 FOREIGN KEY (id_car) REFERENCES car(id);


