CREATE table "LAB3_EP_USERROLE" (
                                    "ROLEID"     NUMBER NOT NULL,
                                    "ROLENAME"   VARCHAR2(20) NOT NULL,
                                    constraint  "LAB3_EP_USERROLE_PK" primary key ("ROLEID")
)
/

CREATE sequence "LAB3_EP_USERROLE_SEQ"
/

CREATE trigger "BI_LAB3_EP_USERROLE"
    before insert on "LAB3_EP_USERROLE"
    for each row
begin
    if :NEW."ROLEID" is null then
        select "LAB3_EP_USERROLE_SEQ".nextval into :NEW."ROLEID" from dual;
    end if;
end;
/

CREATE table "LAB3_EP_HOTEL" (
                                 "HOTELID"    NUMBER NOT NULL,
                                 "HOTELNAME"  VARCHAR2(50),
                                 "ADDRESS"    VARCHAR2(100),
                                 constraint  "LAB3_EP_HOTEL_PK" primary key ("HOTELID")
)
/

CREATE sequence "LAB3_EP_HOTEL_SEQ"
/

CREATE trigger "BI_LAB3_EP_HOTEL"
    before insert on "LAB3_EP_HOTEL"
    for each row
begin
    if :NEW."HOTELID" is null then
        select "LAB3_EP_HOTEL_SEQ".nextval into :NEW."HOTELID" from dual;
    end if;
end;
/

CREATE table "LAB3_EP_CUSTOMER" (
                                    "CUSTOMERID"   NUMBER,
                                    "CUSTOMERNAME" VARCHAR2(20),
                                    "PHONENUMBER"  VARCHAR2(13),
                                    constraint  "LAB3_EP_CUSTOMER_PK" primary key ("CUSTOMERID")
)
/

CREATE sequence "LAB3_EP_CUSTOMER_SEQ"
/

CREATE trigger "BI_LAB3_EP_CUSTOMER"
    before insert on "LAB3_EP_CUSTOMER"
    for each row
begin
    if :NEW."CUSTOMERID" is null then
        select "LAB3_EP_CUSTOMER_SEQ".nextval into :NEW."CUSTOMERID" from dual;
    end if;
end;
/

CREATE table "LAB3_EP_ORDER" (
                                 "ORDERID"    NUMBER,
                                 "CUSTOMERID" NUMBER,
                                 constraint  "LAB3_EP_ORDER_PK" primary key ("ORDERID")
)
/

CREATE sequence "LAB3_EP_ORDER_SEQ"
/

CREATE trigger "BI_LAB3_EP_ORDER"
    before insert on "LAB3_EP_ORDER"
    for each row
begin
    if :NEW."ORDERID" is null then
        select "LAB3_EP_ORDER_SEQ".nextval into :NEW."ORDERID" from dual;
    end if;
end;
/

ALTER TABLE "LAB3_EP_ORDER" ADD CONSTRAINT "LAB3_EP_ORDER_FK"
    FOREIGN KEY ("CUSTOMERID")
        REFERENCES "LAB3_EP_CUSTOMER" ("CUSTOMERID")

/

CREATE table "LAB3_EP_USER" (
                                "USERNAME"    VARCHAR2(20),
                                "PHONENUMBER" VARCHAR2(13),
                                "USERID"      NUMBER,
                                "HOTELID"     NUMBER,
                                "ROLEID"      NUMBER,
                                "MANAGERID"   NUMBER,
                                constraint  "LAB3_EP_USER_PK" primary key ("USERID")
)
/

CREATE sequence "LAB3_EP_USER_SEQ"
/

CREATE trigger "BI_LAB3_EP_USER"
    before insert on "LAB3_EP_USER"
    for each row
begin
    if :NEW."USERID" is null then
        select "LAB3_EP_USER_SEQ".nextval into :NEW."USERID" from dual;
    end if;
end;
/

ALTER TABLE "LAB3_EP_USER" ADD CONSTRAINT "LAB3_EP_USER_FK"
    FOREIGN KEY ("HOTELID")
        REFERENCES "LAB3_EP_HOTEL" ("HOTELID")

/
ALTER TABLE "LAB3_EP_USER" ADD CONSTRAINT "LAB3_EP_USER_FK2"
    FOREIGN KEY ("ROLEID")
        REFERENCES "LAB3_EP_USERROLE" ("ROLEID")

/

CREATE table "LAB3_EP_ROOM" (
                                "ROOMNUMBER" NUMBER,
                                "ROOMTYPE"   VARCHAR2(10),
                                "CAPACITY"   NUMBER,
                                "PRICE"      NUMBER,
                                "CUSTOMERID" NUMBER,
                                "HOTELID"    NUMBER,
                                constraint  "LAB3_EP_ROOM_PK" primary key ("ROOMNUMBER")
)
/

CREATE sequence "LAB3_EP_ROOM_SEQ"
/

CREATE trigger "BI_LAB3_EP_ROOM"
    before insert on "LAB3_EP_ROOM"
    for each row
begin
    if :NEW."ROOMNUMBER" is null then
        select "LAB3_EP_ROOM_SEQ".nextval into :NEW."ROOMNUMBER" from dual;
    end if;
end;
/

ALTER TABLE "LAB3_EP_ROOM" ADD CONSTRAINT "LAB3_EP_ROOM_FK"
    FOREIGN KEY ("CUSTOMERID")
        REFERENCES "LAB3_EP_CUSTOMER" ("CUSTOMERID")

/
ALTER TABLE "LAB3_EP_ROOM" ADD CONSTRAINT "LAB3_EP_ROOM_FK2"
    FOREIGN KEY ("HOTELID")
        REFERENCES "LAB3_EP_HOTEL" ("HOTELID")
            ON DELETE CASCADE

/
