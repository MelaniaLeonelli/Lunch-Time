DROP DATABASE IF EXISTS LunchTime;
CREATE DATABASE LunchTime;
DROP USER IF EXISTS 'sisisi'@'localhost';
CREATE USER'sisisi'@'localhost'IDENTIFIED BY 'password.8';
GRANT ALL ON LunchTime.* TO 'sisisi'@'localhost';