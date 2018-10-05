-- Create Actors table
CREATE TABLE Actors(
name VARCHAR(40),
movie VARCHAR(80),
year INT,
role VARCHAR(40));

--- Load Data from CSV file
LOAD DATA LOCAL INFILE 'actors.csv'
INTO TABLE Actors FIELDS TERMINATED BY ','
OPTIONALLY ENCLOSED BY '"';

-- Select name of actors in the movie "Die Another Day"
SELECT name from Actors WHERE movie = "Die Another Day";

-- Drop Actors table
DROP TABLE Actors
