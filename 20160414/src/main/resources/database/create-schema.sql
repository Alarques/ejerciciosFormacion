--  Create Tables

CREATE TABLE EMPLOYEE
(
	PRIMARY KEY (ID) ,
	ID                BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	NAME              VARCHAR(50) NOT NULL,
	DATE_OF_BIRTH     DATE NOT NULL,
	SURNAME           VARCHAR(50),
	START_DATE		  DATE NOT NULL,
	PERCENT_CUSTOMER  DOUBLE,
	PERCENT_DATE      TIMESTAMP
);


CREATE TABLE CUSTOMER
(
	PRIMARY KEY (ID) ,
	ID               BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	NAME             VARCHAR(50) NOT NULL,
	EMPLOYEE_ID      BIGINT NOT NULL,
	SURNAME          VARCHAR(50),
	PERCENT_PRODUCT  DOUBLE,
	PERCENT_DATE     TIMESTAMP,
	FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE (ID)
);





CREATE TABLE PRODUCT
(
	PRIMARY KEY (ID),
	ID           BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	NAME         VARCHAR(50) NOT NULL,
	DESCRIPTION  VARCHAR(500)
);


CREATE TABLE PRODUCT_CUSTOMER
(
	PRIMARY KEY (PRODUCT_ID, CUSTOMER_ID, BUY_DATE),
	PRODUCT_ID     BIGINT NOT NULL,
	CUSTOMER_ID    BIGINT NOT NULL,
	BUY_DATE  TIMESTAMP NOT NULL,
	CANTIDAD 	INTEGER,
	FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER (ID),
	FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (ID)
);