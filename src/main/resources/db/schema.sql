create schema IoTBayDB;
set schema IoTBayDB;

create table "USER"
(
    User_ID INTEGER primary key,
    Email_Address VARCHAR(255),
    Password_Hash varchar(50),
    Password_Salt varchar(50),
    Name VARCHAR(255),
    Phone varchar(10),
    User_Type varchar(10)
);

create table PRODUCT
(
    Product_ID INTEGER primary key,
    Product_Name VARCHAR(255) not null,
    Product_Description VARCHAR(25565),
    Product_Price float,
    Product_Stock INTEGER
);

create table PAYMENTDETAILS
(
    Payment_ID INTEGER primary key,
    Payment_Amount FLOAT not null,
    Payment_Date DATE not null,
    Payment_Method VARCHAR(255) not null,
    Cardholder_Name varchar(255),
    Card_Number varchar(16),
    Expiration_Date date,
    Billing_Address varchar(255),
    Transaction_Status char
);

create table CITY
(
    City_ID INTEGER primary key,
    City_Name VARCHAR(255) not null,
    Postcode varchar(10),
    State varchar(3)
);

create table COLLECTIONPOINT
(
    Collection_ID INTEGER primary key,
    Collection_Name varchar(255),
    Collection_Address VARCHAR(255),
    City_ID INTEGER,
    CONSTRAINT COLLECTIONPOINT_CITYID foreign key (City_ID) references "CITY"(City_ID)
);

create table DELIVERYADDRESS
(
    Delivery_ID INTEGER primary key,
    Delivery_Address VARCHAR(255),
    City_ID INTEGER,
    CONSTRAINT DELIVERYADDRESS_CITYID foreign key (City_ID) references "CITY"(City_ID)
);

create table "ORDER"
(
    Order_ID INTEGER primary key,
    Name VARCHAR(255),
    Phone VARCHAR(10),
    Order_Status VARCHAR(20),
    Order_Date date,
    Order_Method VARCHAR(10),
    User_ID INTEGER,
    Payment_ID INTEGER,
    Collection_ID INTEGER,
    Delivery_ID INTEGER,
    constraint PRODUCT_USERID foreign key (User_ID) references "USER"(User_ID),
    constraint PRODUCT_PAYMENTID foreign key (Payment_ID) references "PAYMENTDETAILS"(Payment_ID),
    constraint PRODUCT_COLLECTIONID foreign key (Collection_ID) references "COLLECTIONPOINT"(Collection_ID),
    constraint PRODUCT_DELIVERYID foreign key (Delivery_ID) references "DELIVERYADDRESS"(Delivery_ID)
);

-- associative entities --

create table SAVEDPAYMENTDETAILS
(
    User_ID INTEGER,
    Payment_ID INTEGER,
    PRIMARY KEY (User_ID, Payment_ID),
    CONSTRAINT SAVEDPAYMENTDETAILS_CUSTOMERID foreign key (User_ID) references "USER"(User_ID),
    CONSTRAINT SAVEDPAYMENTDETAILS_PAYMENTID foreign key (Payment_ID) references "PAYMENTDETAILS"(Payment_ID)
);

create table SAVEDDELIVERYADDRESS
(
    User_ID INTEGER,
    Delivery_ID INTEGER,
    PRIMARY KEY (User_ID, Delivery_ID),
    CONSTRAINT SAVEDDELIVERYADDRESS_USERID foreign key (User_ID) references "USER"(User_ID),
    CONSTRAINT SAVEDDELIVERYADDRESS_DELIVERYID foreign key (Delivery_ID) references "DELIVERYADDRESS"(Delivery_ID)
);

create table ORDERLINE
(
    Product_Quantity INTEGER,
    Order_ID INTEGER,
    Product_ID INTEGER,
    PRIMARY KEY (Order_ID, Product_ID),
    CONSTRAINT ORDERLINE_ORDERID foreign key (Order_ID) references "ORDER"(Order_ID),
    CONSTRAINT ORDERLINE_PRODUCTID foreign key (Product_ID) references "PRODUCT"(Product_ID)
);
