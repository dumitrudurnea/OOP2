DROP TABLE user_order IF EXISTS;
DROP TABLE user_access IF EXISTS;
DROP TABLE food_choice IF EXISTS;
DROP TABLE food_category IF EXISTS;

CREATE TABLE user_access (
    id                  IDENTITY NOT NULL PRIMARY KEY,
    name                VARCHAR(30),
    access_time         DATETIME
);

CREATE TABLE food_category (
    id                  IDENTITY NOT NULL PRIMARY KEY,
    name                VARCHAR(50)
);

CREATE TABLE food_choice (
    id                  IDENTITY NOT NULL PRIMARY KEY,
    name                VARCHAR(50),
    price               DECIMAL(10,2),
    category_id         INTEGER
);

ALTER TABLE food_choice ADD CONSTRAINT fk_food_choice_category FOREIGN KEY (category_id) REFERENCES food_category (id);

CREATE TABLE user_order (
  id                  IDENTITY NOT NULL PRIMARY KEY,
  user_access_id      INTEGER,
  food_choice_id      INTEGER
);

ALTER TABLE user_order ADD CONSTRAINT fk_user_order_user_access FOREIGN KEY (user_access_id) REFERENCES user_access (id);
ALTER TABLE user_order ADD CONSTRAINT fk_user_order_food_choice FOREIGN KEY (food_choice_id) REFERENCES food_choice (id);
