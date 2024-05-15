set schema APP;

-- records of Users --
INSERT INTO "USER" VALUES (1000, 'johnshep@email.com', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'John Sheppard', '0412345678', 'Customer');
INSERT INTO "USER" VALUES (1001, 'drrmckay@zmail.com', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Rodney McKay', '0411144777', 'Customer');
INSERT INTO "USER" VALUES (1002, 'lizweir@email.com', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Elizabeth Weir', '0413366999', 'Customer');
INSERT INTO "USER" VALUES (1003, 'drsamanthacarter@zmail.com', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Sam Carter', '0412255888', 'Customer');
INSERT INTO "USER" VALUES (1004, 'jackoneill@sgc.gov', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Jack O''Neill', '0437373737', 'Customer');
INSERT INTO "USER" VALUES (1005, 'danieljackson@zmail.com', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Daniel Jackson', '0488811000', 'Customer');
INSERT INTO "USER" VALUES (1006, 'janet@sgc.gov', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Janet Frasier', '0434343434', 'Customer');
INSERT INTO "USER" VALUES (1007, 'jonasquinn@sgc.gov', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Jonas Quinn', '0477420177', 'Customer');
INSERT INTO "USER" VALUES (1008, 'sarahjane@sjs.com', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Sarah Jane Smith', '0478520000', 'Customer');
INSERT INTO "USER" VALUES (1009, 'jlpicard@sf.gov', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Jean-Luc Picard', '0479620000', 'Customer');
INSERT INTO "USER" VALUES (1010, 'sam@cheers.com', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Sam Malone', '0469696969', 'Customer');
INSERT INTO "USER" VALUES (1011, 'diane@harvard.edu', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Diane Chambers', '0435353535', 'Customer');
INSERT INTO "USER" VALUES (1012, 'carla@cheers.com', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Carla Tortelli', '0471422077', 'Customer');
INSERT INTO "USER" VALUES (1013, 'norm@email.com', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Norm Peterson', '0472522088', 'Customer');
INSERT INTO "USER" VALUES (1014, 'cliffclavin@post.com', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Cliff Clavin', '0436363636', 'Customer');
INSERT INTO "USER" VALUES (1015, 'drfrasiercrane@harvard.edu', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Frasier Crane', '0474721843', 'Customer');
INSERT INTO "USER" VALUES (1016, 'woodyboyd@email.com', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Woody Boyd', '0432323232', 'Customer');
INSERT INTO "USER" VALUES (1017, 'drlilithsternin@psych.net', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Lilith Sternin', '0475821144', 'Customer');
INSERT INTO "USER" VALUES (1018, 'rebeccahowe@bmail.com', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Rebecca Howe', '0421212121', 'Customer');
INSERT INTO "USER" VALUES (1019, 'coach@email.com', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Ernie Pantusso', '0473620902', 'Customer');
INSERT INTO "USER" VALUES (1020, 'misskelly@aol.com', '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Kelly Gaines', '0476320233', 'Customer');
INSERT INTO "USER" VALUES (1021, 'staff@iotbay.com',  '34Ldl7d5XXfYb3Rk+FTS4A==', 'pZWJoK7SzUM2BGq7jCddhw==', 'Stu Affmember', '0412312344', 'Staff');
INSERT INTO "USER" VALUES (1022, 'admin@iotbay.com',  '', '', 'IoT Admin', '0444444444', 'Admin');

-- records of Products --
INSERT INTO "PRODUCT" VALUES (1000, 'Dingtek Smart Waste Bin Sensor DF703', 'Home Automation', 'A sensor for your bin', 110.00, 1000);
INSERT INTO "PRODUCT" VALUES (1001, 'Smart Home Security Camera (Model SC200)', 'Home Security', 'Keep an eye on your home remotely', 149.99, 500);
INSERT INTO "PRODUCT" VALUES (1002, 'Temperature and Humidity Sensor (THS-500)', 'Environmental Monitoring', 'Monitor indoor climate conditions', 29.99, 800);
INSERT INTO "PRODUCT" VALUES (1003, 'Smart Door Lock DL900', 'Home Security', 'Secure your home with keyless entry', 199.00, 300);
INSERT INTO "PRODUCT" VALUES (1004, 'Wireless Smart Plug WP100', 'Home Automation', 'Control your devices remotely', 24.99, 1000);
INSERT INTO "PRODUCT" VALUES (1005, 'EcoSmart Thermostat (Model ECO-T200)', 'Home Automation', 'A smart thermostat that optimizes energy usage', 89.95, 500);
INSERT INTO "PRODUCT" VALUES (1006, 'Motion Sensor Light (MSL-700)', 'Home Automation', 'Automatically lights up when motion is detected', 39.99, 1200);
INSERT INTO "PRODUCT" VALUES (1007, 'Smart Water Leak Detector WL200', 'Home Safety', 'Receive alerts for water leaks', 49.95, 600);
INSERT INTO "PRODUCT" VALUES (1008, 'Outdoor Smart Plug (OSP-450)', 'Outdoor and Garden', 'Control outdoor devices remotely', 34.99, 400);
INSERT INTO "PRODUCT" VALUES (1009, 'Smart Garage Door Opener (GDO-800)', 'Outdoor and Garden', 'Open and close your garage remotely', 179.00, 250);
INSERT INTO "PRODUCT" VALUES (1010, 'Wireless Soil Moisture Sensor (SMS-300)', 'Environmental Monitoring', 'Monitor soil moisture for your garden', 19.99, 900);
INSERT INTO "PRODUCT" VALUES (1011, 'Smart Smoke Detector (SDX-100)', 'Home Safety', 'Get instant alerts in case of smoke or fire', 59.95, 700);
INSERT INTO "PRODUCT" VALUES (1012, 'Indoor Air Quality Monitor (IAQ-600)', 'Environmental Monitoring', 'Track air pollutants and improve your environment', 89.00, 550);
INSERT INTO "PRODUCT" VALUES (1013, 'Smart Pet Feeder (PF-200)', 'Pet Care', 'Feed your pets remotely with scheduled meals', 79.99, 800);
INSERT INTO "PRODUCT" VALUES (1014, 'Smart Plant Watering System (PWS-400)', 'Outdoor and Garden', 'Automatically water your plants based on soil moisture', 69.95, 650);
INSERT INTO "PRODUCT" VALUES (1015, 'Wireless Door/Window Sensor (DWS-150)', 'Home Security', 'Receive alerts when doors or windows are opened', 29.99, 1100);
INSERT INTO "PRODUCT" VALUES (1016, 'Smart Energy Meter (SEM-700)', 'Home Automation', 'Monitor electricity usage and save energy', 109.00, 400);
INSERT INTO "PRODUCT" VALUES (1017, 'Smart Outdoor Lighting Kit (OLK-800)', 'Outdoor and Garden', 'Illuminate your outdoor spaces with smart lights', 149.00, 300);
INSERT INTO "PRODUCT" VALUES (1018, 'HealthGuard Wearable Fitness Tracker (Model HG-FIT01)', 'Health and Fitness', 'Tracks steps, heart rate, and sleep patterns', 79.99, 900);
INSERT INTO "PRODUCT" VALUES (1019, 'WeatherStation Pro (Model WS-500)', 'Environmental Monitoring', 'Monitors temperature, humidity, and barometric pressure', 69.50, 800);
INSERT INTO "PRODUCT" VALUES (1020, 'Industrial Temperature Sensor (Model ITS-800)', 'Environmental Monitoring', 'Designed for factory automation', 199.00, 300);
INSERT INTO "PRODUCT" VALUES (1021, 'Vehicle GPS Tracker (1AF-700)', 'Outdoor and Garden', 'Real-time tracking for fleet management', 149.00, 200);
INSERT INTO "PRODUCT" VALUES (1022, 'Smart Pet Feeder (MPF-200)', 'Pet Care', 'Schedule feedings for your furry friends', 59.99, 1900);
INSERT INTO "PRODUCT" VALUES (1023, 'Smart Smoke Detector (Model SSD-250)', 'Home Automation', 'Sends alerts to your phone during emergencies', 79.95, 100);
INSERT INTO "PRODUCT" VALUES (1024, 'Smart Refrigerator (SRF-700)', 'Home Automation', 'Monitors food freshness and suggests recipes', 1299.00, 1350);
INSERT INTO "PRODUCT" VALUES (1025, 'Pet GPS Tracker Model PGT-100', 'Pet Care', 'Keep tabs on your furry companions', 70.00, 5000);
INSERT INTO "PRODUCT" VALUES (1026, 'Smart Water Bottle (Model SWB-300)', 'Health and Fitness', 'Reminds you to stay hydrated throughout the day', 39.99, 1000);
INSERT INTO "PRODUCT" VALUES (1027, 'Smart Air Purifier AP-500', 'Home Automation', 'Filters out pollutants for cleaner air', 199.00, 800);
INSERT INTO "PRODUCT" VALUES (1028, 'Smart Light Bulb JHB-4600', 'Home Automation', 'Adjust brightness and color from your phone', 24.99, 1200);
INSERT INTO "PRODUCT" VALUES (1029, 'Smart Doorbell Camera (SDC-900)', 'Home Security', 'See and speak to visitors from your phone', 199.00, 300);
INSERT INTO "PRODUCT" VALUES (1030, 'Smart Lock (Model SL-200)', 'Home Security', 'Unlock your door with a touch or voice command', 149.99, 600);

-- records of Payment Details --
INSERT INTO "PAYMENTDETAILS" VALUES (1, 150.00, '2024-04-26', 'Credit Card', 'John Sheppard', '1234567890123456', '2026-12-31', '17 Jones St, North Sydney', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (2, 300.00, '2024-04-29', 'Credit Card', 'Rodney McKay', '3456789012345678', '2025-09-20', '101 Gate St, Launceston', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (3, 75.20, '2024-04-28', 'Credit Card', 'Elizabeth Weir', '5678901234567890', '2025-10-15', '789 Atlantis Dr, Townsville', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (4, 180.25, '2024-05-02', 'Credit Card', 'Sam Carter', '3456123456789012', '2025-06-15', '44 Birch Blvd, Maroubra', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (5, 50.75, '2024-04-30', 'Credit Card', 'Daniel Jackson', '4567890123456789', '2025-08-10', '22 Abydos Ave, Alice Springs', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (6, 100.80, '2024-05-01', 'Credit Card', 'Janet Frasier', '2345678901234567', '2025-07-05', '333 Cassie Street, Geelong', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (7, 90.30, '2024-05-03', 'Credit Card', 'Jonas Quinn', '4567234567890123', '2025-05-25', '555 Oakwood Dr, Kellyville', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (8, 200.50, '2024-04-27', 'Credit Card', 'Sarah Jane Smith', '9876543210987654', '2025-11-30', '45 Doctor Dr, Ballarat', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (9, 99.95, '2024-04-27', 'Credit Card', 'Sam Malone', '9876543210987654', '2025-11-30', '239 Sheridan St, Cairns', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (10, 199.50, '2024-04-28', 'Credit Card', 'Diane Chambers', '5432109876543210', '2025-10-15', '789 Ivy Lane, Melbourne', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (11, 49.99, '2024-04-29', 'Credit Card', 'Carla Tortelli', '1111222233334444', '2025-09-01', '32 Wallaby Way, Adelaide', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (12, 79.00, '2024-04-30', 'Credit Card', 'Norm Peterson', '4444333322221111', '2025-08-20', '567 Hay St, Perth', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (13, 129.95, '2024-05-01', 'Credit Card', 'Cliff Clavin', '6666555577778888', '2026-07-05', '789 Trivia Rd, Hobart', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (14, 199.99, '2024-05-02', 'Credit Card', 'Frasier Crane', '2222111133334444', '2025-06-10', '123 Psychology Blvd, Canberra', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (15, 59.50, '2024-05-03', 'Credit Card', 'Woody Boyd', '8888777766665555', '2027-05-25', '890 Constitution Ave, Canberra', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (16, 149.00, '2024-05-04', 'Credit Card', 'Lilith Sternin', '5555444433332222', '2025-04-12', '788 Queen St, Brisbane', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (17, 69.95, '2024-05-05', 'Credit Card', 'Rebecca Howe', '9999888877776666', '2027-03-18', '324 Surfers Paradise Blvd, Gold Coast', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (18, 89.00, '2024-05-06', 'Credit Card', 'Ernie Pantusso', '3333222211114444', '2025-02-22', '677 Coach St, Newcastle', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (19, 119.99, '2024-05-07', 'Credit Card', 'Kelly Gaines', '7777666655554444', '2026-01-05', '71 Crown St, Wollongong', 'S');
INSERT INTO "PAYMENTDETAILS" VALUES (20, 79.50, '2024-05-08', 'Credit Card', 'Robin Colcord', '2222333344445555', '2024-12-10', '12 Flinder St, Townsville', 'S');

-- records of Cities --
INSERT INTO "CITY" VALUES (1, 'Sydney', '2000', 'NSW');
INSERT INTO "CITY" VALUES (2, 'Melbourne', '3000', 'VIC');
INSERT INTO "CITY" VALUES (3, 'Brisbane', '4000', 'QLD');
INSERT INTO "CITY" VALUES (4, 'Adelaide', '5000', 'SA');
INSERT INTO "CITY" VALUES (5, 'Perth', '6000', 'WA');
INSERT INTO "CITY" VALUES (6, 'Hobart', '7000', 'TAS');
INSERT INTO "CITY" VALUES (7, 'Darwin', '8000', 'NT');
INSERT INTO "CITY" VALUES (8, 'Canberra', '2601', 'ACT');
INSERT INTO "CITY" VALUES (9, 'Gold Coast', '4217', 'QLD');
INSERT INTO "CITY" VALUES (10, 'Newcastle', '2300', 'NSW');
INSERT INTO "CITY" VALUES (11, 'Geelong', '3220', 'VIC');
INSERT INTO "CITY" VALUES (12, 'Wollongong', '2500', 'NSW');
INSERT INTO "CITY" VALUES (13, 'Townsville', '4810', 'QLD');
INSERT INTO "CITY" VALUES (14, 'Ballarat', '3350', 'VIC');
INSERT INTO "CITY" VALUES (15, 'Launceston', '7250', 'TAS');
INSERT INTO "CITY" VALUES (16, 'Alice Springs', '0870', 'NT');
INSERT INTO "CITY" VALUES (17, 'Cairns', '4870', 'QLD');
INSERT INTO "CITY" VALUES (18, 'Toowoomba', '4350', 'QLD');
INSERT INTO "CITY" VALUES (19, 'Albury', '2640', 'NSW');
INSERT INTO "CITY" VALUES (20, 'Geraldton', '6530', 'WA');
INSERT INTO "CITY" VALUES (21, 'Epping', '3076', 'VIC');
INSERT INTO "CITY" VALUES (22, 'Kellyville', '2155', 'NSW');
INSERT INTO "CITY" VALUES (23, 'Hornsby', '2077', 'NSW');
INSERT INTO "CITY" VALUES (24, 'Parramatta', '2150', 'NSW');
INSERT INTO "CITY" VALUES (25, 'Thirroul', '2515', 'NSW');

-- records of Collection Points --
INSERT INTO "COLLECTIONPOINT" VALUES (1, 'Westfield Sydney', '188 Pitt St', 1);
INSERT INTO "COLLECTIONPOINT" VALUES (2, 'Chadstone Shopping Centre', '1341 Dandenong Rd', 2);
INSERT INTO "COLLECTIONPOINT" VALUES (3, 'Westfield Chermside', '395 Hamilton Rd', 3);
INSERT INTO "COLLECTIONPOINT" VALUES (4, 'Rundle Mall', 'Rundle Mall', 4);
INSERT INTO "COLLECTIONPOINT" VALUES (5, 'Westfield Carousel', '1382 Albany Hwy', 5);
INSERT INTO "COLLECTIONPOINT" VALUES (6, 'Eastlands Shopping Centre', '26 Bligh St', 6);
INSERT INTO "COLLECTIONPOINT" VALUES (7, 'Casuarina Square', '247 Trower Rd', 7);
INSERT INTO "COLLECTIONPOINT" VALUES (8, 'Westfield Belconnen', '18 Benjamin Way', 8);
INSERT INTO "COLLECTIONPOINT" VALUES (9, 'Pacific Fair Shopping Centre', 'Hooker Blvd', 9);
INSERT INTO "COLLECTIONPOINT" VALUES (10, 'Charlestown Square', '30 Pearson St', 10);
INSERT INTO "COLLECTIONPOINT" VALUES (11, 'Westfield Geelong', '95 Malop St', 11);
INSERT INTO "COLLECTIONPOINT" VALUES (12, 'Wollongong Central', '200 Crown St', 12);
INSERT INTO "COLLECTIONPOINT" VALUES (13, 'Stockland Townsville', '310 Ross River Rd', 13);
INSERT INTO "COLLECTIONPOINT" VALUES (14, 'Central Square Ballarat', '18 Armstrong St', 14);
INSERT INTO "COLLECTIONPOINT" VALUES (15, 'Kingsway City', '168 Wanneroo Rd', 15);
INSERT INTO "COLLECTIONPOINT" VALUES (16, 'Alice Plaza', '36 Todd Mall', 16);
INSERT INTO "COLLECTIONPOINT" VALUES (17, 'Cairns Central', '1-21 McLeod St', 17);
INSERT INTO "COLLECTIONPOINT" VALUES (18, 'Grand Central Toowoomba', 'Dent St', 18);
INSERT INTO "COLLECTIONPOINT" VALUES (19, 'Lavington Square', '351 Griffith Rd', 19);
INSERT INTO "COLLECTIONPOINT" VALUES (20, 'Northgate Shopping Centre', 'Cnr Chapman Rd & Durlacher St', 20);

-- records of Delivery Addresses --
INSERT INTO "DELIVERYADDRESS" VALUES (1, '17 Jones St', 1);
INSERT INTO "DELIVERYADDRESS" VALUES (2, '101 Gate St', 15);
INSERT INTO "DELIVERYADDRESS" VALUES (3, '789 Atlantis Dr', 13);
INSERT INTO "DELIVERYADDRESS" VALUES (4, '44 Birch Blvd', 16);
INSERT INTO "DELIVERYADDRESS" VALUES (5, '22 Abydos Ave', 16);
INSERT INTO "DELIVERYADDRESS" VALUES (6, '333 Cassie Street', 11);
INSERT INTO "DELIVERYADDRESS" VALUES (7, '555 Oakwood Dr', 22);
INSERT INTO "DELIVERYADDRESS" VALUES (8, '45 Doctor Dr', 14);
INSERT INTO "DELIVERYADDRESS" VALUES (9, '239 Sheridan St', 17);
INSERT INTO "DELIVERYADDRESS" VALUES (10, '789 Ivy Lane', 2);
INSERT INTO "DELIVERYADDRESS" VALUES (11, '32 Wallaby Way', 4);
INSERT INTO "DELIVERYADDRESS" VALUES (12, '567 Hay St', 5);
INSERT INTO "DELIVERYADDRESS" VALUES (13, '789 Trivia Rd', 6);
INSERT INTO "DELIVERYADDRESS" VALUES (14, '123 Psychology Blvd', 8);
INSERT INTO "DELIVERYADDRESS" VALUES (15, '890 Constitution Ave', 8);
INSERT INTO "DELIVERYADDRESS" VALUES (16, '788 Queen St', 3);
INSERT INTO "DELIVERYADDRESS" VALUES (17, '324 Surfers Paradise Blvd', 9);
INSERT INTO "DELIVERYADDRESS" VALUES (18, '677 Coach St', 10);
INSERT INTO "DELIVERYADDRESS" VALUES (19, '71 Crown St', 12);
INSERT INTO "DELIVERYADDRESS" VALUES (20, '12 Flinder St', 13);
INSERT INTO "DELIVERYADDRESS" VALUES (21, 'Unit 9, 11 Epping Rd', 21);
INSERT INTO "DELIVERYADDRESS" VALUES (22, '8 Kellyville Rd', 22);
INSERT INTO "DELIVERYADDRESS" VALUES (23, '12 Hornsby St', 23);
INSERT INTO "DELIVERYADDRESS" VALUES (24, '15 Parramatta Rd', 24);
INSERT INTO "DELIVERYADDRESS" VALUES (25, '20 Thirroul St', 25);

-- records of Orders --
INSERT INTO "ORDER" VALUES (1, 'John Sheppard', '0412345678', 'Shipped', '2024-04-26', 'Delivery', 1000, 1, Null, 1);
INSERT INTO "ORDER" VALUES (2, 'Sam Malone', '0469696969', 'Processing', '2024-04-26', 'Delivery', 1004, 2, Null, 2);
INSERT INTO "ORDER" VALUES (3, 'Diane Chambers', '0435353535', 'Ready to Collect', '2024-04-26', 'Collection', 1008, 3, 2, Null);
INSERT INTO "ORDER" VALUES (4, 'Carla Tortelli', '0471422077', 'Shipped', '2024-04-26', 'Delivery', 1012, 4, Null, 4);
INSERT INTO "ORDER" VALUES (5, 'Norm Peterson', '0472522088', 'Processing', '2024-04-26', 'Delivery', 1013, 5, Null, 5);
INSERT INTO "ORDER" VALUES (6, 'Cliff Clavin', '0436363636', 'Collected', '2024-04-26', 'Collection', 1009, 6, 3, Null);
INSERT INTO "ORDER" VALUES (7, 'Frasier Crane', '0474721843', 'Shipped', '2024-04-26', 'Delivery', 1015, 7, Null, 7);
INSERT INTO "ORDER" VALUES (8, 'Woody Boyd', '0432323232', 'Processing', '2024-04-26', 'Delivery', 1016, 8, Null, 8);
INSERT INTO "ORDER" VALUES (9, 'Lilith Sternin', '0475821144', 'Ready to Collect', '2024-04-26', 'Collection', 1017, 9, 4, Null);
INSERT INTO "ORDER" VALUES (10, 'Rebecca Howe', '0421212121', 'Shipped', '2024-04-26', 'Delivery', 1005, 10, Null, 10);
INSERT INTO "ORDER" VALUES (11, 'Ernie Pantusso', '0473620902', 'Processing', '2024-04-26', 'Delivery', 1014, 11, Null, 11);
INSERT INTO "ORDER" VALUES (12, 'Kelly Gaines', '0476320233', 'Collected', '2024-04-26', 'Collection', 1018, 12, 5, Null);
INSERT INTO "ORDER" VALUES (13, 'Robin Colcord', '0434343434', 'Shipped', '2024-04-26', 'Delivery', 1017, 13, Null, 13);
INSERT INTO "ORDER" VALUES (14, 'Sarah Jane Smith', '0478520000', 'Processing', '2024-04-26', 'Delivery', 1019, 14, Null, 14);
INSERT INTO "ORDER" VALUES (15, 'Elizabeth Weir', '0413366999', 'Ready to Collect', '2024-04-26', 'Collection', 1002, 15, 6, Null);
INSERT INTO "ORDER" VALUES (16, 'Rodney McKay', '0411144777', 'Shipped', '2024-04-26', 'Delivery', 1001, 16, Null, 16);
INSERT INTO "ORDER" VALUES (17, 'Daniel Jackson', '0488811000', 'Processing', '2024-04-26', 'Delivery', 1011, 17, Null, 17);
INSERT INTO "ORDER" VALUES (18, 'Janet Frasier', '0437373737', 'Collected', '2024-04-26', 'Collection', 1007, 18, 7, Null);
INSERT INTO "ORDER" VALUES (19, 'Sam Carter', '0412255888', 'Shipped', '2024-04-26', 'Delivery', 1003, 19, Null, 19);
INSERT INTO "ORDER" VALUES (20, 'Jonas Quinn', '0477420177', 'Processing', '2024-04-26', 'Delivery', 1018, 20, Null, 20);

-- associative entities --

-- records of Saved Payment Details --
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1000, 1);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1001, 2);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1002, 3);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1003, 4);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1004, 5);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1005, 6);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1006, 7);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1007, 8);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1008, 9);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1009, 10);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1010, 11);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1011, 12);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1012, 13);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1013, 14);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1014, 15);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1015, 16);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1016, 17);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1017, 18);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1018, 19);
INSERT INTO "SAVEDPAYMENTDETAILS" VALUES (1019, 20);

-- records of Saved Delivery Addresses --
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1000, 1);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1001, 2);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1002, 3);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1003, 4);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1004, 5);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1005, 6);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1006, 7);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1007, 8);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1008, 9);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1009, 10);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1010, 11);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1011, 12);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1012, 13);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1013, 14);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1014, 15);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1015, 16);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1016, 17);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1017, 18);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1018, 19);
INSERT INTO "SAVEDDELIVERYADDRESS" VALUES (1019, 20);

-- records of Order Lines --
INSERT INTO "ORDERLINE" VALUES (1, 1, 1000);
INSERT INTO "ORDERLINE" VALUES (3, 2, 1004);
INSERT INTO "ORDERLINE" VALUES (2, 2, 1008);
INSERT INTO "ORDERLINE" VALUES (1, 3, 1012);
INSERT INTO "ORDERLINE" VALUES (4, 4, 1013);
INSERT INTO "ORDERLINE" VALUES (2, 5, 1013);
INSERT INTO "ORDERLINE" VALUES (1, 5, 1009);
INSERT INTO "ORDERLINE" VALUES (3, 5, 1015);
INSERT INTO "ORDERLINE" VALUES (1, 6, 1017);
INSERT INTO "ORDERLINE" VALUES (2, 6, 1018);
INSERT INTO "ORDERLINE" VALUES (1, 7, 1005);
INSERT INTO "ORDERLINE" VALUES (3, 8, 1016);
INSERT INTO "ORDERLINE" VALUES (2, 8, 1018);
INSERT INTO "ORDERLINE" VALUES (1, 9, 1017);
INSERT INTO "ORDERLINE" VALUES (4, 9, 1018);
INSERT INTO "ORDERLINE" VALUES (2, 10, 1005);
INSERT INTO "ORDERLINE" VALUES (1, 10, 1019);
INSERT INTO "ORDERLINE" VALUES (3, 11, 1014);
INSERT INTO "ORDERLINE" VALUES (2, 11, 1015);
INSERT INTO "ORDERLINE" VALUES (1, 12, 1018);
INSERT INTO "ORDERLINE" VALUES (4, 12, 1019);
INSERT INTO "ORDERLINE" VALUES (2, 13, 1017);
INSERT INTO "ORDERLINE" VALUES (1, 13, 1018);
