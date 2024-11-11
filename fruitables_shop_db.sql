drop database fruitables_shop_db;
create database fruitables_shop_db;
use fruitables_shop_db;	

create table user(
	id int auto_increment not null,
    email varchar(255) not null,
    password varchar(255) not null,
    user_name varchar(255),
    
    primary key (id)
);

create table delivery_information(
	id int auto_increment not null,
    user_id int not null,
    first_name varchar(65) not null,
    last_name varchar(65) not null,
    phone_numbers varchar(65) not null,
    address1 varchar(65) not null,
    address2 varchar(65) not null,
	commune varchar(65) not null,
    district varchar(65) not null,
    province varchar(65) not null,
    
	primary key(id)
);

create table category(
	id int auto_increment not null,
    name varchar(65) not null,
    
    primary key(id)
);

create table product(
	id int auto_increment not null,
    category_id int not null,
    name varchar(65) not null,
	description text not null,
    
    primary key(id)
);

create table product_item(
	id int auto_increment not null,
    product_id int not null,
	qty_in_stock int not null,
    price decimal not null,
	
    primary key(id)
);

create table cart(
	id int auto_increment not null,
    user_id int not null,
    
    primary key(id)
);

create table cart_item(
	id int auto_increment not null,
    cart_id int not null,
    product_item_id int not null,
    qty int not null,
    
    primary key(id)
);

create table payment_type(
	id int auto_increment not null,
    name varchar(65),
    
    primary key(id)
);

create table user_payment_method(
	id int auto_increment not null,
    user_id int not null,
    payment_type_id int not null,
    provider varchar(65),
    account_number varchar(65),
    expiry_date timestamp,
    is_default boolean not null,
    
    primary key(id)
);

create table shipping_method(
	id int auto_increment not null,
    name varchar(65) not null,
    price decimal not null,
    
    primary key(id)
);

create table order_status(
	id int auto_increment not null,
    status varchar(65),
    
    primary key(id)
);

create table shop_order(
	id int auto_increment not null,
    user_id int not null,
    order_date timestamp,
    payment_method int not null,
	shipping_address int not null,
    shipping_method int not null,
    order_total decimal,
    order_status int not null,
    
    primary key(id)
);

create table shop_order_item(
	id int auto_increment not null,
    product_item_id int not null,
    shop_order_id int not null,
    qty int not null,
    price decimal,
    
    primary key(id)
);

create table user_review(
	id int auto_increment not null,
    user_id int not null,
    ordered_product_id int not null,
    rating_value int not null,
	comment text,
    
    primary key(id)
);



alter table delivery_information add constraint fk_delivery_information_user_user_id foreign key (user_id) references user(id);
alter table product add constraint fk_product_category_category_id foreign key (category_id) references category(id);
alter table product_item add constraint fk_product_item_product_product_id foreign key (product_id) references product(id);
alter table cart add constraint fk_cart_user_user_id foreign key (user_id) references user(id);
alter table cart_item add constraint fk_cart_item_product_item_product_item_id foreign key (product_item_id) references product_item(id);
alter table cart_item add constraint fk_cart_item_cart_cart_id foreign key (cart_id) references cart(id);
alter table user_payment_method add constraint fk_user_payment_method_user_user_id foreign key (user_id) references user(id);
alter table user_payment_method add constraint fk_user_payment_method_payment_type_payment_type_id foreign key (payment_type_id) references payment_type(id);
alter table shop_order add constraint fk_shop_order_user_user_id foreign key (user_id) references user(id);
alter table shop_order add constraint fk_shop_order_user_payment_method_payment_method foreign key (payment_method) references user_payment_method(id);
alter table shop_order add constraint fk_shop_order_delivery_information_shipping_address foreign key (shipping_address) references delivery_information(id);
alter table shop_order add constraint fk_shop_order_shipping_method_shipping_method foreign key (shipping_method) references shipping_method(id);
alter table shop_order add constraint fk_shop_order_order_status_order_status foreign key (order_status) references order_status(id);

alter table shop_order_item add constraint fk_shop_order_item_product_item_product_item_id foreign key (product_item_id) references product_item(id);
alter table shop_order_item add constraint fk_shop_order_item_shop_order_shop_order_id foreign key (shop_order_id) references shop_order(id);
alter table user_review add constraint fk_user_review_user_user_id foreign key (user_id) references user(id);
alter table user_review add constraint fk_user_review_shop_order_item_ordered_product_id foreign key (ordered_product_id) references shop_order_item(id);


