grant all on mydb.* to 'root'@'localhost'; -- Gives all the privileges to the new user on the newly created database
USE mydb
CREATE TABLE USER (
    id INTEGER NOT NULL,
    name VARCHAR(255),
    email VARCHAR(255),
    PRIMARY KEY (id)
);
INSERT INTO USER VALUES 
( 1, 'Deepika', 'deepika@email.com');
