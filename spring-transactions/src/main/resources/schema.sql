CREATE TABLE purchase (
    id IDENTITY PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    purchase_date TIMESTAMP NOT NULL,
    item VARCHAR(255) NOT NULL
);