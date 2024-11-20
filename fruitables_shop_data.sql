use fruitables_shop_db;

insert into category(name) values ("Tropical Fruits");
insert into category(name) values ("Cirus Fruits");
insert into category(name) values ("Stone Fruits");
insert into category(name) values ("Berries");
insert into category(name) values ("Leafy Greens");
insert into category(name) values ("Root Vegetables");
insert into category(name) values ("Herbs");
insert into category(name) values ("Edible Leaves");

insert into product(category_id, name, qty_in_stock, price, description) values(1, "apple", 10, 10, "this is apple");

select * from category;