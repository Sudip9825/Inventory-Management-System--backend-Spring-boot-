-- liquibase formatted sql
-- changeset sudip.dahal:product-create-v1     context:dev
-- preconditions onFail:CONTINUE onError:HALT
CREATE TABLE IF NOT EXISTS `products` (
 id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    price DECIMAL(10,2) NOT NULL,
    quantity INT DEFAULT 0,
    supplier_id INT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    unique_id VARCHAR(255),
    product_picture VARCHAR(255) NOT NULL,
    FOREIGN KEY (supplier_id) REFERENCES suppliers(id)
);










