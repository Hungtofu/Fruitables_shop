drop database fruitables_shop_db;
create database fruitables_shop_db;
use fruitables_shop_db;	

create table user(
	id int auto_increment,
    email varchar(255),
    password varchar(255),
    user_name varchar(255),
    
    gender text,
    dob datetime,
    img text,
    refresh_token mediumtext,
    created_at datetime,
    update_at datetime,
    created_by text,
    update_by text,
    
    primary key (id)
);


create table delivery_information(
	id int auto_increment,
    user_id int,
    first_name varchar(65),
    last_name varchar(65),
    phone_numbers varchar(65),
    address1 varchar(65),
    address2 varchar(65),
	commune varchar(65),
    district varchar(65),
    province varchar(65),
    
	primary key(id)
);

create table category(
	id int auto_increment,
    name varchar(65),
    
    primary key(id)
);



create table product(
	id int auto_increment,
    category_id int,
    name varchar(65),
    qty_in_stock int,
    price decimal,
	description text,
    
    primary key(id)
);

create table image(
	id int auto_increment,
    product_id int,
    url text,

	primary key(id)
);

create table cart(
	id int auto_increment,
    user_id int,
    
    primary key(id)
);

create table cart_item(
	id int auto_increment,
    cart_id int,
    product_id int,
    qty int,
    
    primary key(id)
);

create table payment_type(
	id int auto_increment,
    name varchar(65),
    
    primary key(id)
);

create table user_payment_method(
	id int auto_increment,
    user_id int,
    payment_type_id int,
    provider varchar(65),
    account_number varchar(65),
    expiry_date timestamp,
    is_default boolean,
    
    primary key(id)
);

create table shipping_method(
	id int auto_increment,
    name varchar(65),
    price decimal,
    
    primary key(id)
);

create table order_status(
	id int auto_increment,
    status varchar(65),
    
    primary key(id)
);

create table shop_order(
	id int auto_increment,
    user_id int,
    order_date timestamp,
    payment_method int,
	shipping_address int,
    shipping_method int,
    order_total decimal,
    order_status int  ,
    
    primary key(id)
);

create table shop_order_item(
	id int auto_increment,
    product_id int,
    shop_order_id int,
    qty int,
    price decimal,
    
    primary key(id)
);

create table user_review(
	id int auto_increment,
    user_id int,
    ordered_product_id int,
    rating_value int,
	comment text,
    
    primary key(id)
);


alter table delivery_information add constraint fk_delivery_information_user_user_id foreign key (user_id) references user(id);
alter table product add constraint fk_product_category_category_id foreign key (category_id) references category(id);
alter table image add constraint fk_image_product_product_id foreign key (product_id) references product(id);
alter table cart add constraint fk_cart_user_user_id foreign key (user_id) references user(id);
alter table cart_item add constraint fk_cart_item_product_product_id foreign key (product_id) references product(id);
alter table cart_item add constraint fk_cart_item_cart_cart_id foreign key (cart_id) references cart(id);
alter table user_payment_method add constraint fk_user_payment_method_user_user_id foreign key (user_id) references user(id);
alter table user_payment_method add constraint fk_user_payment_method_payment_type_payment_type_id foreign key (payment_type_id) references payment_type(id);
alter table shop_order add constraint fk_shop_order_user_user_id foreign key (user_id) references user(id);
alter table shop_order add constraint fk_shop_order_user_payment_method_payment_method foreign key (payment_method) references user_payment_method(id);
alter table shop_order add constraint fk_shop_order_delivery_information_shipping_address foreign key (shipping_address) references delivery_information(id);
alter table shop_order add constraint fk_shop_order_shipping_method_shipping_method foreign key (shipping_method) references shipping_method(id);
alter table shop_order add constraint fk_shop_order_order_status_order_status foreign key (order_status) references order_status(id);

alter table shop_order_item add constraint fk_shop_order_item_product_item_product_id foreign key (product_id) references product(id);
alter table shop_order_item add constraint fk_shop_order_item_shop_order_shop_order_id foreign key (shop_order_id) references shop_order(id);
alter table user_review add constraint fk_user_review_user_user_id foreign key (user_id) references user(id);
alter table user_review add constraint fk_user_review_shop_order_item_ordered_product_id foreign key (ordered_product_id) references shop_order_item(id);

select * from user;
