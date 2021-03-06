---------------------------------------------------------- tables -----------------------------------------------------------------------------------------
------------------------------------------------------------------------------------ACTIVITY_ID------------------------------------------------------------------------------------
CREATE TABLE ACTIVITYID(

ACTIVITY_ID INT ,

NAME VARCHAR(20) NOT NULL, -- donor/receiver/both

CONSTRAINT ACTIVITY_ID_PK PRIMARY KEY (ACTIVITY_ID)

);




------------------------------------MEMBER------------------------------------------------------------------------------------


CREATE TABLE MEMBER(

MEMBER_ID VARCHAR(5) ,

Email VARCHAR(255) NOT NULL UNIQUE,

PASSWORD VARCHAR(20) NOT NULL ,

PHONE_NUMBER VARCHAR(20) UNIQUE NOT NULL,

ADDRESS VARCHAR(255),

CITY VARCHAR(20) NOT NULL ,

COUNTRY VARCHAR(20) NOT NULL ,

MEMBER_TYPE CHAR, -- o for org/i for ind

ACTIVITY_ID INT NOT NULL,	

CONSTRAINT MEMBER_ID_PK PRIMARY KEY (MEMBER_ID) ,

CONSTRAINT ACTIVITY_ID_FK FOREIGN KEY (ACTIVITY_ID) REFERENCES ACTIVITYID(ACTIVITY_ID)

);

------------------------------------ HEALTH_ORGANIZATION------------------------------------

CREATE TABLE HEALTH_ORGANIZATION(

HEALTH_ORG_ID VARCHAR(5) ,

ORG_NAME VARCHAR(255) NOT NULL,

LISENCE_KEY VARCHAR(255) UNIQUE NOT NULL,

CONSTRAINT HEALTH_ORG_PK PRIMARY KEY (HEALTH_ORG_ID),

CONSTRAINT HEALTH_ORG_ID_FK FOREIGN KEY (HEALTH_ORG_ID) REFERENCES MEMBER(MEMBER_ID)



);

------------------------------------ INDIVIDUAL------------------------------------

CREATE TABLE INDIVIDUAL(

INDIVIDUAL_ID VARCHAR(5),

FIRST_NAME VARCHAR(20) NOT NULL,

LAST_NAME VARCHAR(20) NOT NULL,

BIRTHDAY DATE,

HEIGHT_CM INTEGER NOT NULL,

WEIGHT_KG INTEGER NOT NULL,

GENDER CHAR NOT NULL, -- f for female / m for male

APPLIED_LICENSE_KEY VARCHAR(255) NOT NULL,



CONSTRAINT INDIVIDUAL_PK PRIMARY KEY (INDIVIDUAL_ID),

CONSTRAINT INDIVIDUAL_ID_FK FOREIGN KEY (INDIVIDUAL_ID) REFERENCES MEMBER(MEMBER_ID),

CONSTRAINT APPLIED_LICENSE_KEY_FK FOREIGN KEY (APPLIED_LICENSE_KEY) REFERENCES HEALTH_ORGANIZATION(LISENCE_KEY)



);

------------------------------------MAP_ORG_PARTNER

CREATE TABLE MAP_ORG_PARTNER(

HEALTH_ORG_ID1 VARCHAR(5),

HEALTH_ORG_ID2 VARCHAR(5) ,



CONSTRAINT HEALTH_ORG_PA_PK PRIMARY KEY (HEALTH_ORG_ID1 , HEALTH_ORG_ID2),

CONSTRAINT HEALTH_ORG_ID1_FK FOREIGN KEY (HEALTH_ORG_ID1) REFERENCES HEALTH   _ORGANIZATION(HEALTH_ORG_ID),   

CONSTRAINT HEALTH_ORG_ID2_FK FOREIGN KEY (HEALTH_ORG_ID2) REFERENCES HEALTH_ORGANIZATION(HEALTH_ORG_ID) 



);

------------------------------------STATE------------------------------------



CREATE TABLE STATE(

STATE_ID INT   ,

NAME  VARCHAR(20) NOT NULL, 

CONSTRAINT STATE_PK PRIMARY KEY (STATE_ID)

);

------------------------------------ ENTITY_TYPE------------------------------------

CREATE TABLE ENTITY_TYPE(

ENTITY_TYPE_ID INT ,

ENTITY_TYPE_NAME VARCHAR(20) NOT NULL,

CONSTRAINT ENTITY_TYPE_PK PRIMARY KEY (ENTITY_TYPE_ID)

);


------------------------------------BLOOD_TYPE------------------------------------


CREATE TABLE BLOOD_TYPE ( 

BlOOD_TYPE_ID INTEGER, 

BLOOD_TYPE_NAME  VARCHAR(3) NOT NULL UNIQUE, 

CONSTRAINT BLOOD_TYPE_PK PRIMARY KEY(BlOOD_TYPE_ID) 

  );


------------------------------------ TEST------------------------------------ 

CREATE TABLE TEST ( 

TEST_ID INTEGER, 

MEMBER_ID VARCHAR(5) UNIQUE ,

BLOOD INTEGER, -- 1 if pass , 0 if fail

Urine INTEGER  ,

Gyencological  INTEGER,

Colonscopy INTEGER,

Chest INTEGER,

Country INTEGER,

Cancer INTEGER,

Antibody INTEGER,

CT INTEGER,

EKG INTEGER,

Physical INTEGER,

Electrocardiogram INTEGER,

Echocardiogram INTEGER,

Pulmonary INTEGER,

Doppler INTEGER,

PET INTEGER,

HTIV INTEGER,

HIV INTEGER,

Syphilis INTEGER,

BoneMarrow INTEGER,

HepatitisB INTEGER,

 HepatitisC INTEGER,

Crossmatch INTEGER,

HLA INTEGER, 

CONSTRAINT TEST_PK PRIMARY KEY(TEST_ID),

CONSTRAINT TEST_FK FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER(MEMBER_ID) 

);

------------------------------------ DONATION_ENTITY------------------------------------

CREATE TABLE DONATION_ENTITY(

DONATION_ENTITY_ID INTEGER ,

STATE_ID INTEGER NOT NULL, -- state of the entity - 

MEMBER_ID VARCHAR(5) NOT NULL, -- the donor of this entity- can be  donor or org(donor/both)

ENTITY_TYPE_ID INTEGER NOT NULL,



CONSTRAINT DONATION_ENTITY_PK PRIMARY KEY (DONATION_ENTITY_ID),

CONSTRAINT DONATION_ENTITY_STATE_FK FOREIGN KEY (STATE_ID) REFERENCES STATE(STATE_ID),

CONSTRAINT DONATION_ENTITY_MEMBER_ID_FK FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER(MEMBER_ID),

CONSTRAINT DONATION_ENTITY_TYPE_FK FOREIGN KEY (ENTITY_TYPE_ID) REFERENCES ENTITY_TYPE(ENTITY_TYPE_ID)

);

------------------------------------ COMPLETED_DONATION_LOG------------------------------------


CREATE TABLE COMPLETED_DONATION_LOG (

CD_ID INTEGER  , 

RECEPIENT_ID VARCHAR(5)NOT NULL , -- member id should be org and activity id should be receiver/both

DONATION_DATE Date NOT NULL ,

DONATION_ENTITY_ID INTEGER UNIQUE NOT NULL,



CONSTRAINT CDL_PK PRIMARY KEY(CD_ID) , 

CONSTRAINT CDL_FK1 FOREIGN KEY (RECEPIENT_ID) REFERENCES MEMBER(MEMBER_ID) , 

CONSTRAINT CDL_FK2 FOREIGN KEY (DONATION_ENTITY_ID) REFERENCES DONATION_ENTITY(DONATION_ENTITY_ID) );


------------------------------------BLOOD------------------------------------

CREATE TABLE BLOOD ( 



BlOOD_ID INTEGER , 

BLOOD_TYPE_ID INTEGER NOT NULL, 

BLOOD_UNITS INTEGER NOT NULL , 

MEMBER_ID VARCHAR(5) NOT NULL , 



CONSTRAINT BLOOD_PK PRIMARY KEY(BlOOD_ID) ,

CONSTRAINT BLOOD_FK1 FOREIGN KEY (BLOOD_TYPE_ID) REFERENCES BLOOD_TYPE(BLOOD_TYPE_ID) , 

CONSTRAINT BLOOD_FK2 FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER(MEMBER_ID) --must be donor 



);


------------------------------------ ELIGIBILITY_TO_DONATE------------------------------------

CREATE TABLE ELIGIBILITY_TO_DONATE(

ID INTEGER , 

TEST_ID INT UNIQUE,

BLOOD INT ,

KIDNEY INT,

LIVER INT,

EYES INT,

BONE_MARROW INT,

HEART INT,



CONSTRAINT ELIGIBILITY_PK PRIMARY KEY (ID),

CONSTRAINT ELIGIBILITY_TEST_FK FOREIGN KEY (TEST_ID) REFERENCES 

TEST(TEST_ID)

);


