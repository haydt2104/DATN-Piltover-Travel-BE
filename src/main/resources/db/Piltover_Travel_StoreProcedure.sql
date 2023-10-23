USE piltover_travel;

-- Sử dụng DELIMITER để chạy một khối lệnh tránh MySQL hiểu lầm dấu chấm phẩy
DELIMITER //
-- Kiểm tra xem stored procedure đã tồn tại chưa
DROP PROCEDURE IF EXISTS CalculateStatistics;
CREATE PROCEDURE CalculateStatistics(IN number1 INT, IN number2 INT, IN number3 INT)
BEGIN
    -- Tạo biến cho các kết quả
    DECLARE average DECIMAL(10, 2);
    DECLARE total INT;
    DECLARE max_number INT;
    DECLARE min_number INT;
    
    -- Tính trung bình
    SET average = (number1 + number2 + number3) / 3;
    
    -- Tính tổng
    SET total = number1 + number2 + number3;
    
    -- Tìm số lớn nhất
    IF number1 >= number2 AND number1 >= number3 THEN
        SET max_number = number1;
    ELSEIF number2 >= number1 AND number2 >= number3 THEN
        SET max_number = number2;
    ELSE
        SET max_number = number3;
    END IF;
    
    -- Tìm số bé nhất
    IF number1 <= number2 AND number1 <= number3 THEN
        SET min_number = number1;
    ELSEIF number2 <= number1 AND number2 <= number3 THEN
        SET min_number = number2;
    ELSE
        SET min_number = number3;
    END IF;
    
    -- Trả về kết quả
    SELECT average AS Average, total AS Total, max_number AS Max, min_number AS Min;
END//
DELIMITER ;
-- Test CalculateStatistics: CALL CalculateStatistics(9, 10, 3);


-- -------------Thinh-------------------------

-- Lấy doanh thu theo tháng 
DELIMITER //
DROP PROCEDURE IF EXISTS CallMonthTotalRevenue;
CREATE PROCEDURE CallMonthTotalRevenue(IN startDate DATE, IN endDate DATE)
BEGIN
    -- Truy vấn SQL để tính tổng doanh thu
   SELECT
    DATE_FORMAT(BD.Booking_time, '%Y-%m') AS month,
    SUM(BD.Adult * P.Adult_price + BD.Children * P.Children_price) AS total_tour_revenue,
    SUM(IFNULL(H.Price, 0)) AS total_hotel_revenue,
    SUM(IFNULL(TP.Price, 0)) AS total_transport_revenue
FROM
    Booking_Detail AS BD
    JOIN Bookings AS B ON BD.BookingID = B.Id
    JOIN Tour_Dates AS TD1 ON B.Tour_DateID = TD1.Id
    JOIN Tours AS T ON TD1.TourID = T.Id
    JOIN Prices AS P ON T.PriceID = P.Id
    LEFT JOIN Hotels AS H ON B.HotelID = H.Id
    LEFT JOIN Accounts AS A ON B.Create_User = A.ID
    LEFT JOIN Tour_Plan AS TPT ON TD1.TourID = TPT.ID
    LEFT JOIN Transports AS TP ON TPT.TransportID = TP.Id
WHERE
    B.Status = 1
    AND BD.Booking_time BETWEEN startDate AND endDate
GROUP BY
    month
ORDER BY
    month;
END;
//DELIMITER ;
-- CALL CallMonthTotalRevenue('2023-01-01', '2023-12-31');
--------------------------

-- Lấy tổng tất cả doanh thu 
DELIMITER //

DROP PROCEDURE IF EXISTS CallTotalRevenue;
CREATE PROCEDURE CallTotalRevenue(IN startDate DATE, IN endDate DATE)
BEGIN
    -- Truy vấn SQL để tính tổng doanh thu
SELECT
    SUM(BD.Adult * P.Adult_price + BD.Children * P.Children_price) AS total_tour_revenue,
    SUM(H.Price) AS total_hotel_revenue,
    SUM(TP.Price) AS total_transport_revenue,
    SUM(BD.Adult * P.Adult_price + BD.Children * P.Children_price + H.Price + TP.Price) AS total_revenue
FROM
    Booking_Detail AS BD
    JOIN Bookings AS B ON BD.BookingID = B.Id
    JOIN Tour_Dates AS TD1 ON B.Tour_DateID = TD1.Id
    JOIN Tours AS T ON TD1.TourID = T.Id
    JOIN Prices AS P ON T.PriceID = P.Id
    JOIN Hotels AS H ON B.HotelID = H.Id
    JOIN Accounts AS A ON B.Create_User = A.ID
    JOIN Tour_Plan AS TPT ON TD1.TourID = TPT.ID
    JOIN Transports AS TP ON TPT.TransportID = TP.Id
WHERE
    B.Status = 1
    AND BD.Booking_time BETWEEN startDate AND endDate;

END;
//DELIMITER ;

-- CALL CallTotalRevenue('2023-01-01', '2023-10-30');
-- CALL CallTotalRevenue('2023-01-01', '2023-12-31');

---------------------------------------------

-- ---Lấy dữ liệu doanh thu tour ---
DELIMITER //

DROP PROCEDURE IF EXISTS CallTourRevenue;
CREATE PROCEDURE CallTourRevenue(IN startDate DATE, IN endDate DATE)
BEGIN
    -- Truy vấn SQL để tính tổng doanh thu
SELECT
    T.Name AS total_name,
    P.Adult_price AS adult_price,
    P.Children_price AS children_price,
    SUM(BD.Adult) AS adult_bookings,
    SUM(BD.Children) AS children_bookings,
    SUM(BD.Adult * P.Adult_price + BD.Children * P.Children_price) AS total_revenue
FROM
    Bookings AS B
    JOIN Booking_Detail AS BD ON B.Id = BD.BookingID
    JOIN Tour_Dates AS TD ON B.Tour_DateID = TD.Id
    JOIN Tours AS T ON TD.TourID = T.Id
    JOIN Prices AS P ON T.PriceID = P.Id
WHERE
    B.status = 1 AND BD.Booking_time BETWEEN startDate AND endDate
GROUP BY
    T.Name, P.Adult_price, P.Children_price
ORDER BY
	total_revenue DESC
LIMIT 10;
END;
//DELIMITER ;
-- CALL CallTourRevenue('2023-01-01', '2023-09-30');
-- CALL CallTourRevenue('2023-01-01', '2023-12-31');


------------------------------------------------

-- ---Lấy dữ liệu doanh thu hotel ---
DELIMITER //
DROP PROCEDURE IF EXISTS CallHotelRevenue;
CREATE PROCEDURE CallHotelRevenue(IN startDate DATE, IN endDate DATE)
BEGIN
    -- Truy vấn SQL để tính tổng doanh thu
SELECT
    H.Name AS hotel_name,
    H.Price AS hotel_price,
    SUM(H.Price) AS total_hotel_revenue,
    COUNT(*) AS total_hotel_booking
FROM
    Hotels AS H
    JOIN Bookings AS B ON H.Id = B.HotelID
    JOIN Booking_Detail AS BD ON B.Id = BD.BookingID
    JOIN Tour_Dates AS TD ON B.Tour_DateID = TD.Id
    JOIN Tours AS T ON TD.TourID = T.Id
    JOIN Prices AS P ON T.PriceID = P.Id
WHERE
    B.Status = 1 and BD.Booking_time BETWEEN startDate AND endDate
GROUP BY
    hotel_name, hotel_price
ORDER BY
    total_hotel_revenue DESC
LIMIT 10;
END;
//DELIMITER ;
CALL CallHotelRevenue('2023-01-01', '2023-12-31');
 
------------------------------------------------

-- ---Lấy dữ liệu doanh thu phuong tien ---
DELIMITER //
DROP PROCEDURE IF EXISTS CallTransportRevenue;
CREATE PROCEDURE CallTransportRevenue(IN startDate DATE, IN endDate DATE)
BEGIN
    -- Truy vấn SQL để tính tổng doanh thu
SELECT
    T.Name AS transport_name,
    T.Price AS transport_price,
    COUNT(BD.Id) AS total_transport_booking,
    SUM(T.Price) AS total_transport_revenue
FROM
    Transports AS T
    JOIN Tour_Plan AS TP ON T.Id = TP.TransportID
    JOIN Tour_Dates AS TD ON TP.ID = TD.TourID
    JOIN Bookings AS B ON TD.Id = B.Tour_DateID
    JOIN Booking_Detail AS BD ON B.Id = BD.BookingID
WHERE
    B.Status = 1 and BD.Booking_time BETWEEN startDate AND endDate
GROUP BY
    T.Name, T.Price
ORDER BY
    total_transport_revenue DESC
LIMIT 10; 
END;
//DELIMITER ;
CALL CallTransportRevenue('2023-01-01', '2023-12-31');

-- -----------------------------------------------------


-- Trọng 
-- Đếm số lượt Like của bài viết
DELIMITER //
DROP PROCEDURE IF EXISTS CountLikePost;
CREATE PROCEDURE CountLikePost(IN id INT)
BEGIN
	SELECT COUNT(*)
	FROM likes
	WHERE Is_Like = 1 AND PostID = id;
END//
DELIMITER ;
-- Test CountLikePost: CALL CountLikePost(2);

-- Lấy bái viết có is_delete = false
DELIMITER //
DROP PROCEDURE IF EXISTS GetAllPosts;
CREATE PROCEDURE GetAllPosts()
BEGIN
	SELECT *
	FROM Posts
	WHERE Is_Delete = 0;
END//
DELIMITER ;
-- Test GetAllPosts: CALL GetAllPosts();