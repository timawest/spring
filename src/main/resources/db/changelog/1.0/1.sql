--liquibase formatted sql
--changeset techgeeknext:create-tables

CREATE TABLE customer(
   id bigserial PRIMARY KEY,
   name VARCHAR(40)
);
