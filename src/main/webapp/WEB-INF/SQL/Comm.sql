 drop table comm cascade constraints purge;
 CREATE TABLE "HR"."COMM" 
   (	"BNO" NUMBER NOT NULL ENABLE, 
	"CID" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"CNO" NUMBER NOT NULL ENABLE, 
	"CTEXT" VARCHAR2(2000 BYTE) NOT NULL ENABLE, 
	"CDATE" DATE DEFAULT sysdate, 
	 PRIMARY KEY ("BNO", "CNO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "BNOFK" FOREIGN KEY ("BNO")
	  REFERENCES "HR"."SANGPUM" ("BNO") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
