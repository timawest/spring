--liquibase formatted sql
--changeset fillt:filltable

insert into customer(name) values ('Kirill'), ('Artur'), ('Timur');