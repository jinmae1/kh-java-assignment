
CREATE TABLE TODAY(
	ID VARCHAR2(15)
	CHECK (LENGTH(ID) >= 6),
	PASSWORD VARCHAR2(15)
	CHECK (LENGTH(PASSWORD) >= 8), 
	NAME VARCHAR2(15),
	PHONE VARCHAR2(11),
	SSN VARCHAR2(13)
	check (LENGTH(SSN) = 13),
	MILEAGE NUMBER,
	REG_DATE DATE 
);