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
