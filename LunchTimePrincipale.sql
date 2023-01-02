DROP DATABASE IF EXISTS LunchTime;
CREATE DATABASE LunchTime;
DROP USER IF EXISTS 'sisi'@'localhost';
CREATE USER'sisi'@'localhost'IDENTIFIED BY'password';
GRANT ALL ON GameMoving.* TO 'sisi'@'localhost';