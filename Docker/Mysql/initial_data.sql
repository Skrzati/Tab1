DROP TABLE IF EXISTS user_table;
DROP TABLE IF EXISTS flower_table;

CREATE TABLE flower_table (
    flower_id INT AUTO_INCREMENT PRIMARY KEY, 
    flower_name VARCHAR(255)
);

CREATE TABLE user_table (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255),
    flower_id INT 
);

INSERT INTO flower_table (flower_name) VALUES ('Narcyz'), ('Roza'), ('Hiacynt'), ('Przebisnieg'), ('Tulipan');