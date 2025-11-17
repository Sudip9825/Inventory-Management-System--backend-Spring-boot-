-- liquibase formatted sql
-- changeset sudip.dahal:product-create-v1     context:dev
-- preconditions onFail:CONTINUE onError:HALT
CREATE TABLE IF NOT EXISTS `product` (
 id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    price DECIMAL(10,2) NOT NULL,
    quantity INT DEFAULT 0,
    supplier_id INT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (supplier_id) REFERENCES Supplier(id)
    );

-- changeset sudip.dahal:product-create-v2     context:dev
-- preconditions onFail:CONTINUE onError:HALT
ALTER TABLE product
    ADD COLUMN unique_id VARCHAR(255);








