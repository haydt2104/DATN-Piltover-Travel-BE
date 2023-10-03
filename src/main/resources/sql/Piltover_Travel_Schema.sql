USE mysql;

SET FOREIGN_KEY_CHECKS = 1;

-- Tạo user 'piltover' nếu chưa tồn tại
CREATE USER IF NOT EXISTS 'piltover'@'localhost' IDENTIFIED BY 'piltover123';

-- Cấp quyền cao nhất cho database 'piltover_travel' cho user 'piltover'
GRANT ALL PRIVILEGES ON piltover_travel.* TO 'piltover'@'localhost';

-- Làm mới các quyền
FLUSH PRIVILEGES;

-- Drop the database if it exists
DROP DATABASE IF EXISTS Piltover_Travel;

-- Create the database
CREATE DATABASE Piltover_Travel;

-- Use the newly created database
USE Piltover_Travel;

-- Create the Users table
CREATE TABLE Accounts (
    ID BIGINT PRIMARY KEY NOT NULL,
    Email VARCHAR(50) UNIQUE,
    Password VARCHAR(50),
    Phone VARCHAR(15) UNIQUE,
    Fullname VARCHAR(50),
    Birthday DATE,
    Gender BOOLEAN,
    Address VARCHAR(100),
    Create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    Update_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    Error_count INT DEFAULT 0,
    Banned_time DATETIME DEFAULT NULL,
    Active BOOLEAN DEFAULT TRUE
);

INSERT INTO Accounts (ID, Email, Password, Phone, Fullname, Birthday, Gender, Address)
VALUES(1234567890,'haycaibat123@gmail.com', 'hay123', '0868916170', 'Dư Trường Hây', '2003-04-21', TRUE, 'Cà Mau'),
(2345673452,'thinhnh123@gmail.com', 'thinh123', '0941599055', 'Nguyễn Hưng Thịnh', '2003-06-21', TRUE, 'Cà Mau');

-- Create the Roles table
CREATE TABLE Roles (
    Id VARCHAR(10) PRIMARY KEY NOT NULL,
    Name VARCHAR(50)
);

INSERT INTO Roles
VALUES('ADMIN', 'Administor'),
('USER', 'User default'),
('EMPLOYEE', 'Employee'),
( 'ADMIN_API', 'Admin API');

-- Create the Authorities table
CREATE TABLE Authorities (
    Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    AccountID BIGINT,
    RoleId VARCHAR(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(Id),
    FOREIGN KEY (RoleId) REFERENCES Roles(Id)
);

INSERT INTO Authorities (AccountID, RoleId)
VALUES(1234567890, 'ADMIN'),
(1234567890, 'USER'),
(1234567890, 'EMPLOYEE');

CREATE TABLE Posts(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    AccountID BIGINT,
    Title VARCHAR(50),
    Description TEXT,
    Content TEXT,
    Create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    Status BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (AccountID) REFERENCES Accounts(Id)
);

CREATE TABLE PostImages(
	Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	PostID BIGINT,
    Path VARCHAR(100),
    FOREIGN KEY (PostID) REFERENCES Posts(Id)
    
);

CREATE TABLE Comments(
	Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    AccountID BIGINT,
	PostID BIGINT,
    Content VARCHAR(100),
    FOREIGN KEY (AccountID) REFERENCES Accounts(Id),
    FOREIGN KEY (PostID) REFERENCES Posts(Id)
    
);

CREATE TABLE Likes(
	Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    AccountID BIGINT,
	PostID BIGINT,
    IsLike BOOLEAN,
    FOREIGN KEY (AccountID) REFERENCES Accounts(Id),
    FOREIGN KEY (PostID) REFERENCES Posts(Id)
    
);

INSERT INTO Posts (AccountID, Title, Description, Content)
VALUES(1234567890, 'Tiêu đề bài viết 1', 'Mô tả bài viết 1', 'Trạng thái bài viết 1');

CREATE TABLE Logs(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    AccountID BIGINT,
    Login_time DATETIME DEFAULT NULL,
    Logout_time DATETIME DEFAULT NULL,
    Ip_address VARCHAR(15) DEFAULT NULL,
    FOREIGN KEY (AccountID) REFERENCES Accounts(Id)
);

INSERT INTO Logs (AccountID)
VALUES(1234567890),
(2345673452);

CREATE TABLE Prices(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Adult_price INT,
    Children_price INT
);

CREATE TABLE Tours(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    PriceID BIGINT,
    CreateID BIGINT,
    Name VARCHAR(50),
    Description TEXT,
    Image VARCHAR(50),
    Destination_address TEXT,
    Available_spaces INT,
    Create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    Active BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (PriceID) REFERENCES Prices(Id),
    FOREIGN KEY (CreateID) REFERENCES Accounts(Id)
);

CREATE TABLE Tour_Dates(
	Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	TourID BIGINT,
    Initiate_date DATETIME,
    FOREIGN KEY (TourID) REFERENCES Tours(Id)
    
);

CREATE TABLE TourImages(
	Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	TourID BIGINT,
    Path VARCHAR(100),
    FOREIGN KEY (TourID) REFERENCES Tours(Id)
    
);

CREATE TABLE Status(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Name VARCHAR(50)
);

CREATE TABLE Transports(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Name VARCHAR(50),
    Price INT,
    Seating_capacity INT
);

CREATE TABLE TourPlan(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    TourID BIGINT,
    StatusID BIGINT,
    TransportID BIGINT,
    Start_name VARCHAR(50),
    Start_address TEXT,
    Start_time DATETIME,
    FOREIGN KEY (TourID) REFERENCES Tours(Id),
    FOREIGN KEY (StatusID) REFERENCES Status(Id)
);

CREATE TABLE TourPlanDetail(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Tour_Plan_ID BIGINT,
    Description TEXT,
    Start_time DATETIME,
    End_time DATETIME,
    FOREIGN KEY (Tour_Plan_ID) REFERENCES TourPlan(Id)
);

CREATE TABLE Hotels(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Name VARCHAR(50),
    Price INT,
    Star INT,
    Address TEXT
);

CREATE TABLE Discounts(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Name VARCHAR(50),
    Percentage FLOAT,
    Amount INT,
    Code VARCHAR(10)
);

CREATE TABLE Bookings(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    AccountID BIGINT,
    Tour_DateID BIGINT,
    HotelID BIGINT,
    DiscountID BIGINT,
    Total_price INT,
    Total_passengers INT,
    Status INT,
    FOREIGN KEY (AccountID) REFERENCES Accounts(Id),
    FOREIGN KEY (Tour_DateID) REFERENCES Tour_Dates(Id),
    FOREIGN KEY (HotelID) REFERENCES Hotels(Id),
    FOREIGN KEY (DiscountID) REFERENCES Discounts(Id)
);

CREATE TABLE Booking_Detail(
    Id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    BookingID BIGINT,
    Adult INT,
    Children INT,
    Surcharge INT,
    Booking_time DATETIME,
    FOREIGN KEY (BookingID) REFERENCES Bookings(Id)
);

