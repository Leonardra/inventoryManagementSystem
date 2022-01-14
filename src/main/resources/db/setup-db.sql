create database inventoryDb;
create user 'inventory_user'@'localhost' identified by 'my123';
grant all privileges on inventoryDb.* to 'inventory_user'@'localhost';

flush privileges