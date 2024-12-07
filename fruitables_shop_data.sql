use fruitables_shop_db;

insert into user(email, password, user_name) values("admin1@gmail.com", "$2a$12$DYtDBdlwz4qxLkz7EOPiMup37uzU.a6Y3bImO8h3CvDAnMPhCrwUa", "admin1");
insert into user(email, password, user_name) values("admin2@gmail.com", "$2a$12$DYtDBdlwz4qxLkz7EOPiMup37uzU.a6Y3bImO8h3CvDAnMPhCrwUa", "admin2");
insert into user(email, password, user_name) values("admin3@gmail.com", "$2a$12$DYtDBdlwz4qxLkz7EOPiMup37uzU.a6Y3bImO8h3CvDAnMPhCrwUa", "admin3");

insert into category(name) values ("Tropical Fruits");
insert into category(name) values ("Cirus Fruits");
insert into category(name) values ("Stone Fruits");
insert into category(name) values ("Berries");
insert into category(name) values ("Leafy Greens");
insert into category(name) values ("Root Vegetables");
insert into category(name) values ("Herbs");
insert into category(name) values ("Edible Leaves");

insert into product(category_id, name, qty_in_stock, price, description) values(1, "apple", 10, 10, "this is apple");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "america apple", 10, 12, "this is apple");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "vietname apple", 10, 15, "this is apple");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "japan apple", 10, 8, "this is apple");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "grape", 10, 15, "this is grape");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "america grape", 10, 20, "this is grape");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "vietname grape", 10, 25, "this is grape");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "japan grape", 10, 22, "this is grape");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "durian", 10, 30, "this is durian");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "america durian", 10, 33, "this is durian");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "vietname durian", 10, 32, "this is durian");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "japan durian", 10, 38, "this is durian");

insert into cart(user_id) values(1);

insert into cart_item(cart_id, product_id, qty) values(1, 1, 2);

insert into image(product_id, url) values(1, "apple.jpg");
insert into image(product_id, url) values(1, "apple_1.jpg");

use fruitables_shop_db;

select * from user;

select * from category;

select * from product;

select * from image;

select * from cart;

select * from cart_item;

