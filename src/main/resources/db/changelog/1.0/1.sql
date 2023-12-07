--liquibase formatted sql
--changeset techgeeknext:create-tables

CREATE TABLE customer(
   id bigserial PRIMARY KEY,
   last_name VARCHAR(40),
   first_name VARCHAR(40),
   age INTEGER
);
