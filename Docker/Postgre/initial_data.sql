DROP TABLE IF EXISTS user_table;
DROP TABLE IF EXISTS flower_table;

CREATE TABLE flower_table (
    flower_id SERIAL PRIMARY KEY, 
    flower_name VARCHAR(255)
);

CREATE TABLE user_table (
    user_id SERIAL PRIMARY KEY,
    user_name VARCHAR(255),
    flower_id INT 
);

INSERT INTO flower_table (flower_name) VALUES ('Narcyz');
INSERT INTO flower_table (flower_name) VALUES ('Roza');
INSERT INTO flower_table (flower_name) VALUES ('Hiacynt');
INSERT INTO flower_table (flower_name) VALUES ('Przebisnieg');
INSERT INTO flower_table (flower_name) VALUES ('Tulipan');