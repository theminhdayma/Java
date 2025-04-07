CREATE DATABASE Management;
USE Management;

CREATE TABLE classrooms
(
    classroom_id   INT PRIMARY KEY AUTO_INCREMENT,
    classroom_name VARCHAR(255) NOT NULL,
    capacity       INT NOT NULL,
    status         BIT NOT NULL
);

CREATE TABLE Student
(
    student_id     INT PRIMARY KEY AUTO_INCREMENT,
    student_name   VARCHAR(200) NOT NULL,
    student_age    INT,
    student_status BIT,
    classroom_id   INT,
    FOREIGN KEY (classroom_id) REFERENCES classrooms(classroom_id) ON DELETE SET NULL
);

DELIMITER //
CREATE PROCEDURE find_all_student()
BEGIN
    SELECT * FROM Student;
END //

CREATE PROCEDURE create_student(
    IN name_in VARCHAR(200),
    IN age_in INT,
    IN status_in BIT,
    IN classroom_id_in INT
)
BEGIN
    INSERT INTO Student(student_name, student_age, student_status, classroom_id)
    VALUES (name_in, age_in, status_in, classroom_id_in);
END //

CREATE PROCEDURE update_student(
    IN id_in INT,
    IN name_in VARCHAR(200),
    IN age_in INT,
    IN status_in BIT,
    IN classroom_id_in INT
)
BEGIN
    UPDATE Student
    SET student_name   = name_in,
        student_age    = age_in,
        student_status = status_in,
        classroom_id   = classroom_id_in
    WHERE student_id = id_in;
END //

CREATE PROCEDURE delete_student(
    IN id_in INT
)
BEGIN
    DELETE FROM Student WHERE student_id = id_in;
END //

CREATE PROCEDURE get_count_student_by_status(
    IN status_in BIT,
    OUT cnt_student INT
)
BEGIN
    SELECT COUNT(student_id) INTO cnt_student FROM Student WHERE student_status = status_in;
END //

CREATE PROCEDURE get_student_by_id(
    IN id_in INT
)
BEGIN
    SELECT * FROM Student WHERE student_id = id_in;
END //

CREATE PROCEDURE find_all_classrooms()
BEGIN
    SELECT * FROM classrooms;
END //

CREATE PROCEDURE create_classroom(
    IN p_name VARCHAR(255),
    IN p_capacity INT,
    IN p_status BIT
)
BEGIN
    INSERT INTO classrooms (classroom_name, capacity, status)
    VALUES (p_name, p_capacity, p_status);
END //

CREATE PROCEDURE update_classroom(
    IN p_id INT,
    IN p_name VARCHAR(255),
    IN p_capacity INT,
    IN p_status BIT
)
BEGIN
    UPDATE classrooms
    SET classroom_name = p_name,
        capacity = p_capacity,
        status = p_status
    WHERE classroom_id = p_id;
END //

CREATE PROCEDURE delete_classroom(
    IN p_id INT
)
BEGIN
    DELETE FROM classrooms WHERE classroom_id = p_id;
END //

CREATE PROCEDURE get_classroom_by_id(
    IN p_id INT
)
BEGIN
    SELECT * FROM classrooms WHERE classroom_id = p_id;
END //

CREATE PROCEDURE get_students_in_classroom(
    IN p_classroom_id INT
)
BEGIN
    SELECT * FROM Student WHERE classroom_id = p_classroom_id;
END //

CREATE PROCEDURE count_students_by_age_range(
    IN p_classroom_id INT,
    IN p_min_age INT,
    IN p_max_age INT,
    OUT p_count INT
)
BEGIN
    SELECT COUNT(*) INTO p_count
    FROM Student
    WHERE classroom_id = p_classroom_id
      AND student_age BETWEEN p_min_age AND p_max_age;
END //

CREATE PROCEDURE count_students_by_status(
    IN p_classroom_id INT,
    IN p_status BIT,
    OUT p_count INT
)
BEGIN
    SELECT COUNT(*) INTO p_count
    FROM Student
    WHERE classroom_id = p_classroom_id
      AND student_status = p_status;
END //
DELIMITER ;