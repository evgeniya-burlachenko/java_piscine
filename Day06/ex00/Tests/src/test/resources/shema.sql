DROP TABLE IF EXISTS product ;
CREATE TABLE IF NOT EXISTS  product (
    id      INT PRIMARY KEY IDENTITY ,
    name    VARCHAR(50) NOT NULL ,
    price   INT NOT NULL
);
-- CREATE SCHEMA IF NOT EXISTS product;

-- create table if not exists product (
--                                        identifier  INT PRIMARY KEY IDENTITY ,
--                                        name        VARCHAR(50) NOT NULL ,
--                                        price       INT NOT NULL
-- );