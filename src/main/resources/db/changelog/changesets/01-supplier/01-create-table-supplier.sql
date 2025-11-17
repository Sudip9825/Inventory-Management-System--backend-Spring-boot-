-- liquibase formatted sql
-- changeset sudip.dahal:suppler-create-v1     context:dev
-- preconditions onFail:CONTINUE onError:HALT
CREATE TABLE IF NOT EXISTS `supplier`
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(20),
    address VARCHAR(255),
    created_at TIMESTAMP  NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    unique_id VARCHAR(100) NOT null UNIQUE,
    is_deleted BOOLEAN DEFAULT FALSE
    );





