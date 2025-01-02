use fruitables_shop_db;

insert into user(email, password, user_name) values
("admin1@gmail.com", "$2a$12$DYtDBdlwz4qxLkz7EOPiMup37uzU.a6Y3bImO8h3CvDAnMPhCrwUa", "admin1"),
("admin2@gmail.com", "$2a$12$DYtDBdlwz4qxLkz7EOPiMup37uzU.a6Y3bImO8h3CvDAnMPhCrwUa", "admin2"),
("admin3@gmail.com", "$2a$12$DYtDBdlwz4qxLkz7EOPiMup37uzU.a6Y3bImO8h3CvDAnMPhCrwUa", "admin3"),
("user1@gmail.com", "$2a$12$DYtDBdlwz4qxLkz7EOPiMup37uzU.a6Y3bImO8h3CvDAnMPhCrwUa", "user1"),
("user2@gmail.com", "$2a$12$DYtDBdlwz4qxLkz7EOPiMup37uzU.a6Y3bImO8h3CvDAnMPhCrwUa", "user2");

insert into delivery_information(user_id, first_name, last_name, phone_numbers, address1, address2, commune, district, province) values 
(4, "A", "Nguyen Van", "0123456789", "KTX khu B", "Đg Mạc Đĩnh Chi", "Đông Hòa", "Dĩ An", "Bình Dương"),
(4, "B", "Nguyen Van", "0123456789", "Tổ 1", "Đg ABCD", "Hòa Hiệp", "Xuyên Mộc", "Bà Rịa - Vũng Tàu");

insert into category(name) values 
("Tropical Fruits"),
("Stone Fruits"),
("Leafy Greens"),
("Root Vegetables"),
("Herbs");

insert into payment_type(name) values
("Cash on delivery"),
("Onine payment");

insert into shipping_method(name, price) values
("Normal", 2),
("Fast", 4);

insert into order_status(status) values
("Shipped"),
("Delivered"),
("Canceled"),
("Pending");

-- Trái cây nhiệt đới (Tropical Fruits)
-- Mango
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Xoài cát Hòa Lộc", 100, 3.2, "");
  insert into image(product_id, url) values (1, "Xoài cát Hòa Lộc.jpg"),
  (1, "Xoài cát Hòa Lộc_1.jpg"),
  (1, "Xoài cát Hòa Lộc_2.jpg"),
  (1, "Xoài cát Hòa Lộc_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Xoài cát chu xanh", 100, 2.5, "");
  insert into image(product_id, url) values(2, "Xoài cát chu xanh.jpg"),
  (2, "Xoài cát chu xanh.jpg"),
  (2, "Xoài cát chu xanh.jpg"),
  (2, "Xoài cát chu xanh.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Xoài cát chu vàng", 100, 3.2, "");
  insert into image(product_id, url) values (3, "Xoài cát chu vàng.jpg"),
  (3, "Xoài cát chu vàng_1.jpg"),
  (3, "Xoài cát chu vàng_2.jpg"),
  (3, "Xoài cát chu vàng_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Xoài tứ quý da xanh", 100, 1.2, "");
  insert into image(product_id, url) values(4, "Xoài tứ quý da xanh.jpg"),
  (4, "Xoài tứ quý da xanh_1.jpg"),
  (4, "Xoài tứ quý da xanh_2.jpg"),
  (4, "Xoài tứ quý da xanh_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Xoài tứ quý da vàng", 100, 1.5, "");
  insert into image(product_id, url) values (5, "Xoài tứ quý da vàng.jpg"),
  (5, "Xoài tứ quý da vàng_1.jpg"),
  (5, "Xoài tứ quý da vàng_2.jpg"),
  (5, "Xoài tứ quý da vàng_3.jpg");

-- pineapple data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Dứa queen", 100, 0.5, "");
  insert into image(product_id, url) values (6, "Dứa queen.jpg"),
  (6, "Dứa queen_1.jpg"),
  (6, "Dứa queen_2.jpg"),
  (6, "Dứa queen_3.jpg");

-- banana data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Chuối tiêu", 100, 2.5, "");
  insert into image(product_id, url) values (7, "Chuối tiêu.jpg"),
  (7, "Chuối tiêu_1.jpg"),
  (7, "Chuối tiêu_2.jpg"),
  (7, "Chuối tiêu_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Chuối sứ", 100, 2, "");
  insert into image(product_id, url) values (8, "Chuối sứ.jpg"),
  (8, "Chuối sứ_1.jpg"),
  (8, "Chuối sứ_2.jpg"),
  (8, "Chuối sứ_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Chuối cau", 100, 2.5, "");
  insert into image(product_id, url) values (9, "Chuối cau.jpg"),
  (9, "Chuối cau_1.jpg"),
  (9, "Chuối cau_2.jpg"),
  (9, "Chuối cau_3.jpg");

-- coconut data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Dừa xiêm xanh", 100, 1.4, "");
  insert into image(product_id, url) values (10, "Dừa xiêm xanh.jpg"),
  (10, "Dừa xiêm xanh_1.jpg"),
  (10, "Dừa xiêm xanh_2.jpg"),
  (10, "Dừa xiêm xanh_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Dừa dứa", 100, 1.2, "");
  insert into image(product_id, url) values (11, "Dừa dứa.jpg"),
  (11, "Dừa dứa_1.jpg"),
  (11, "Dừa dứa_2.jpg"),
  (11, "Dừa dứa_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Dừa sáp", 100, 2, "");
  insert into image(product_id, url) values (12, "Dừa sáp.jpg"),
  (12, "Dừa sáp_1.jpg"),
  (12, "Dừa sáp_2.jpg"),
  (12, "Dừa sáp_3.jpg");

-- dragon fruit data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Thanh long ruột đỏ", 100, 2.2, "");
  insert into image(product_id, url) values (13, "Thanh long ruột đỏ.jpg"),
  (13, "Thanh long ruột đỏ_1.jpg"),
  (13, "Thanh long ruột đỏ_2.jpg"),
  (13, "Thanh long ruột đỏ_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Thanh long ruột trắng", 100, 2.5, "");
  insert into image(product_id, url) values (14, "Thanh long ruột trắng.jpg"),
  (14, "Thanh long ruột trắng_1.jpg"),
  (14, "Thanh long ruột trắng_2.jpg"),
  (14, "Thanh long ruột trắng_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Thanh long ruột vàng", 100, 3, "");
  insert into image(product_id, url) values (15, "Thanh long ruột vàng.jpg"),
  (15, "Thanh long ruột vàng_1.jpg"),
  (15, "Thanh long ruột vàng_2.jpg"),
  (15, "Thanh long ruột vàng_3.jpg");

-- durian data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Sầu riêng Monthong (Thái)", 100, 5, "");
  insert into image(product_id, url) values (16, "Sầu riêng Monthong (Thái).jpg"),
  (16, "Sầu riêng Monthong (Thái)_1.jpg"),
  (16, "Sầu riêng Monthong (Thái)_2.jpg"),
  (16, "Sầu riêng Monthong (Thái)_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Sầu riêng chuồng bò", 100, 4.5, "");
  insert into image(product_id, url) values (17, "Sầu riêng chuồng bò.jpg"),
  (17, "Sầu riêng chuồng bò_1.jpg"),
  (17, "Sầu riêng chuồng bò_2.jpg"),
  (17, "Sầu riêng chuồng bò_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Sầu riêng Dona", 100, 5.2, "");
  insert into image(product_id, url) values (18, "Sầu riêng Dona.jpg"),
  (18, "Sầu riêng Dona_1.jpg"),
  (18, "Sầu riêng Dona_2.jpg"),
  (18, "Sầu riêng Dona_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Sầu riêng Ri6", 100, 5.8, "");
  insert into image(product_id, url) values (19, "Sầu riêng Ri6.jpg"),
  (19, "Sầu riêng Ri6_1.jpg"),
  (19, "Sầu riêng Ri6_2.jpg"),
  (19, "Sầu riêng Ri6_3.jpg");

-- pomelo data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Bưởi da xanh", 100, 2.5, "");
  insert into image(product_id, url) values (20, "Bưởi da xanh.jpg"),
  (20, "Bưởi da xanh_1.jpg"),
  (20, "Bưởi da xanh_2.jpg"),
  (20, "Bưởi da xanh_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Bưởi Năm Roi", 100, 2.2, "");
  insert into image(product_id, url) values (21, "Bưởi Năm Roi.jpg"),
  (21, "Bưởi Năm Roi_1.jpg"),
  (21, "Bưởi Năm Roi_2.jpg"),
  (21, "Bưởi Năm Roi_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Bưởi Phúc Trạch", 100, 2, "");
  insert into image(product_id, url) values (22, "Bưởi Phúc Trạch.jpg"),
  (22, "Bưởi Phúc Trạch_1.jpg"),
  (22, "Bưởi Phúc Trạch_2.jpg"),
  (22, "Bưởi Phúc Trạch_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Bưởi Đoan Hùng", 100, 2.8, "");
  insert into image(product_id, url) values (23, "Bưởi Đoan Hùng.jpg"),
  (23, "Bưởi Đoan Hùng_1.jpg"),
  (23, "Bưởi Đoan Hùng_2.jpg"),
  (23, "Bưởi Đoan Hùng_3.jpg");

-- papaya data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Đu đủ ruột đỏ", 100, 1, "");
  insert into image(product_id, url) values (24, "Đu đủ ruột đỏ.jpg"),
  (24, "Đu đủ ruột đỏ_1.jpg"),
  (24, "Đu đủ ruột đỏ_2.jpg"),
  (24, "Đu đủ ruột đỏ_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Đu đủ ruột vàng", 100, 1.5, "");
  insert into image(product_id, url) values (25, "Đu đủ ruột vàng.jpg"),
  (25, "Đu đủ ruột vàng_1.jpg"),
  (25, "Đu đủ ruột vàng_2.jpg"),
  (25, "Đu đủ ruột vàng_3.jpg");

-- guava data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Ổi nữ hoàng", 100, 1.5, "");
  insert into image(product_id, url) values (26, "Ổi nữ hoàng.jpg"),
  (26, "Ổi nữ hoàng_1.jpg"),
  (26, "Ổi nữ hoàng_2.jpg"),
  (26, "Ổi nữ hoàng_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Ổi lê", 100, 2.5, "");
  insert into image(product_id, url) values (27, "Ổi lê.jpg"),
  (27, "Ổi lê_1.jpg"),
  (27, "Ổi lê_2.jpg"),
  (27, "Ổi lê_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Ổi ruột hồng", 100, 2, "");
  insert into image(product_id, url) values (28, "Ổi ruột hồng.jpg"),
  (28, "Ổi ruột hồng_1.jpg"),
  (28, "Ổi ruột hồng_2.jpg"),
  (28, "Ổi ruột hồng_3.jpg");

-- orange daa
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Cam sành", 100, 2, "");
  insert into image(product_id, url) values (29, "Cam sành.jpg"),
  (29, "Cam sành_1.jpg"),
  (29, "Cam sành_2.jpg"),
  (29, "Cam sành_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Cam xoàn", 100, 2.2, "");
  insert into image(product_id, url) values (30, "Cam xoàn.jpg"),
  (30, "Cam xoàn_1.jpg"),
  (30, "Cam xoàn_2.jpg"),
  (30, "Cam xoàn_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Cam Vinh", 100, 2.6, "");
  insert into image(product_id, url) values (31, "Cam Vinh.jpg"),
  (31, "Cam Vinh_1.jpg"),
  (31, "Cam Vinh_2.jpg"),
  (31, "Cam Vinh_3.jpg");

-- mandarin data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Quýt đường", 100, 1.8, "");
  insert into image(product_id, url) values (32, "Quýt đường.jpg"),
  (32, "Quýt đường_1.jpg"),
  (32, "Quýt đường_2.jpg"),
  (32, "Quýt đường_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Quýt hồng Lai Vung", 100, 2, "");
  insert into image(product_id, url) values (33, "Quýt hồng Lai Vung.jpg"),
  (33, "Quýt hồng Lai Vung_1.jpg"),
  (33, "Quýt hồng Lai Vung_2.jpg"),
  (33, "Quýt hồng Lai Vung_3.jpg");

-- jackfruit data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Mít Thái siêu sớm", 100, 3.5, "");
  insert into image(product_id, url) values (34, "Mít Thái siêu sớm.jpg"),
  (34, "Mít Thái siêu sớm_1.jpg"),
  (34, "Mít Thái siêu sớm_2.jpg"),
  (34, "Mít Thái siêu sớm_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Mít nghệ", 100, 3, "");
  insert into image(product_id, url) values (35, "Mít nghệ.jpg"),
  (35, "Mít nghệ_1.jpg"),
  (35, "Mít nghệ_2.jpg"),
  (35, "Mít nghệ_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Mít tố nữ", 100, 2.5, "");
  insert into image(product_id, url) values (36, "Mít tố nữ.jpg"),
  (36, "Mít tố nữ_1.jpg"),
  (36, "Mít tố nữ_2.jpg"),
  (36, "Mít tố nữ_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Mít siêu sớm ruột đỏ", 100, 5.8, "");
  insert into image(product_id, url) values (37, "Mít siêu sớm ruột đỏ.jpg"),
  (37, "Mít siêu sớm ruột đỏ_1.jpg"),
  (37, "Mít siêu sớm ruột đỏ_2.jpg"),
  (37, "Mít siêu sớm ruột đỏ_3.jpg");

-- pomegranate data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Lựu đỏ Việt Nam", 100, 2.2, "");
  insert into image(product_id, url) values (38, "Lựu đỏ Việt Nam.jpg"),
  (38, "Lựu đỏ Việt Nam_1.jpg"),
  (38, "Lựu đỏ Việt Nam_2.jpg"),
  (38, "Lựu đỏ Việt Nam_3.jpg");

-- sapodilla data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Sapoche Mặc Bắc", 100, 2.5, "");
  insert into image(product_id, url) values (39, "Sapoche Mặc Bắc.jpg"),
  (39, "Sapoche Mặc Bắc_1.jpg"),
  (39, "Sapoche Mặc Bắc_2.jpg"),
  (39, "Sapoche Mặc Bắc_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Sapoche ruột đỏ", 100, 2.8, "");
  insert into image(product_id, url) values (40, "Sapoche ruột đỏ.jpg"),
  (40, "Sapoche ruột đỏ_1.jpg"),
  (40, "Sapoche ruột đỏ_2.jpg"),
  (40, "Sapoche ruột đỏ_3.jpg");

-- jujube data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Táo xanh", 100, 1.2, "");
  insert into image(product_id, url) values (41, "Táo xanh.jpg"),
  (41, "Táo xanh_1.jpg"),
  (41, "Táo xanh_2.jpg"),
  (41, "Táo xanh_3.jpg");

-- watermelon data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Dưa hấu ruột đỏ", 100, 2.5, "");
  insert into image(product_id, url) values (42, "Dưa hấu ruột đỏ.jpg"),
  (42, "Dưa hấu ruột đỏ_1.jpg"),
  (42, "Dưa hấu ruột đỏ_2.jpg"),
  (42, "Dưa hấu ruột đỏ_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Dưa hấu ruột vàng", 100, 2.8, "");
  insert into image(product_id, url) values (43, "Dưa hấu ruột vàng.jpg"),
  (43, "Dưa hấu ruột vàng_1.jpg"),
  (43, "Dưa hấu ruột vàng_2.jpg"),
  (43, "Dưa hấu ruột vàng_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Dưa hấu không hạt", 100, 3, "");
  insert into image(product_id, url) values (44, "Dưa hấu không hạt.jpg"),
  (44, "Dưa hấu không hạt_1.jpg"),
  (44, "Dưa hấu không hạt_2.jpg"),
  (44, "Dưa hấu không hạt_3.jpg");

-- stone fruits
-- plum data
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Mận hậu", 100, 2.5, "");
  insert into image(product_id, url) values (45, "Mận hậu.jpg"),
  (45, "Mận hậu_1.jpg"),
  (45, "Mận hậu_2.jpg"),
  (45, "Mận hậu_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Mận An Phước", 100, 2, "");
  insert into image(product_id, url) values (46, "Mận An Phước.jpg"),
  (46, "Mận An Phước_1.jpg"),
  (46, "Mận An Phước_2.jpg"),
  (46, "Mận An Phước_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Mận Tam Hoa", 100, 2.2, "");
  insert into image(product_id, url) values (47, "Mận Tam Hoa.jpg"),
  (47, "Mận Tam Hoa_1.jpg"),
  (47, "Mận Tam Hoa_2.jpg"),
  (47, "Mận Tam Hoa_3.jpg");

-- peach data
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Đào Sapa", 100, 3, "");
  insert into image(product_id, url) values (48, "Đào Sapa.jpg"),
  (48, "Đào Sapa_1.jpg"),
  (48, "Đào Sapa_2.jpg"),
  (48, "Đào Sapa_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Đào tiên", 100, 2.5, "");
  insert into image(product_id, url) values (49, "Đào tiên.jpg"),
  (49, "Đào tiên_1.jpg"),
  (49, "Đào tiên_2.jpg"),
  (49, "Đào tiên_3.jpg");

-- Apricot data
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Mơ Hương Tích", 100, 3.5, "");
  insert into image(product_id, url) values (50, "Mơ Hương Tích.jpg"),
  (50, "Mơ Hương Tích_1.jpg"),
  (50, "Mơ Hương Tích_2.jpg"),
  (50, "Mơ Hương Tích_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Mơ Bắc Kạn", 100, 1.5, "");
  insert into image(product_id, url) values (51, "Mơ Bắc Kạn.jpg"),
  (51, "Mơ Bắc Kạn_1.jpg"),
  (51, "Mơ Bắc Kạn_2.jpg"),
  (51, "Mơ Bắc Kạn_3.jpg");

-- lychee data
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Vải thiều Lục Ngạn", 100, 3.5, "");
  insert into image(product_id, url) values (52, "Vải thiều Lục Ngạn.jpg"),
  (52, "Vải thiều Lục Ngạn_1.jpg"),
  (52, "Vải thiều Lục Ngạn_2.jpg"),
  (52, "Vải thiều Lục Ngạn_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Vải thiều U Hồng", 100, 4.5, "");
  insert into image(product_id, url) values (53, "Vải thiều U Hồng.jpg"),
  (53, "Vải thiều U Hồng_1.jpg"),
  (53, "Vải thiều U Hồng_2.jpg"),
  (53, "Vải thiều U Hồng_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Vải thiều tu hú", 100, 3.5, "");
  insert into image(product_id, url) values (54, "Vải thiều tu hú.jpg"),
  (54, "Vải thiều tu hú_1.jpg"),
  (54, "Vải thiều tu hú_2.jpg"),
  (54, "Vải thiều tu hú_3.jpg");

-- longan data
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Nhãn lồng Hưng Yên", 100, 2.8, "");
  insert into image(product_id, url) values (55, "Nhãn lồng Hưng Yên.jpg"),
  (55, "Nhãn lồng Hưng Yên_1.jpg"),
  (55, "Nhãn lồng Hưng Yên_2.jpg"),
  (55, "Nhãn lồng Hưng Yên_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Nhãn xuồng cơm vàng", 100, 1.5, "");
  insert into image(product_id, url) values (56, "Nhãn xuồng cơm vàng.jpg"),
  (56, "Nhãn xuồng cơm vàng_1.jpg"),
  (56, "Nhãn xuồng cơm vàng_2.jpg"),
  (56, "Nhãn xuồng cơm vàng_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Nhãn tiêu da bò", 100, 2.8, "");
  insert into image(product_id, url) values (57, "Nhãn tiêu da bò.jpg"),
  (57, "Nhãn tiêu da bò_1.jpg"),
  (57, "Nhãn tiêu da bò_2.jpg"),
  (57, "Nhãn tiêu da bò_3.jpg");

-- mangosteen data
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Măng cụt Lái Thiêu", 100, 2.5, "");
  insert into image(product_id, url) values (58, "Măng cụt Lái Thiêu.jpg"),
  (58, "Măng cụt Lái Thiêu_1.jpg"),
  (58, "Măng cụt Lái Thiêu_2.jpg"),
  (58, "Măng cụt Lái Thiêu_3.jpg");

-- rambutan data
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Chôm chôm Java", 100, 2.5, "");
  insert into image(product_id, url) values (59, "Chôm chôm Java.jpg"),
  (59, "Chôm chôm Java_1.jpg"),
  (59, "Chôm chôm Java_2.jpg"),
  (59, "Chôm chôm Java_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Chôm chôm nhãn", 100, 3.5, "");
  insert into image(product_id, url) values (60, "Chôm chôm nhãn.jpg"),
  (60, "Chôm chôm nhãn_1.jpg"),
  (60, "Chôm chôm nhãn_2.jpg"),
  (60, "Chôm chôm nhãn_3.jpg");

-- Leafy Greens
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Cải bó xôi", 100, 1.2, "");
  insert into image(product_id, url) values (61, "Cải bó xôi.jpg"),
  (61, "Cải bó xôi_1.jpg"),
  (61, "Cải bó xôi_2.jpg"),
  (61, "Cải bó xôi_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Cải xoăn", 100, 1, "");
  insert into image(product_id, url) values (62, "Cải xoăn.jpg"),
  (62, "Cải xoăn_1.jpg"),
  (62, "Cải xoăn_2.jpg"),
  (62, "Cải xoăn_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Xà lách", 100, 0.8, "");
  insert into image(product_id, url) values (63, "Xà lách.jpg"),
  (63, "Xà lách_1.jpg"),
  (63, "Xà lách_2.jpg"),
  (63, "Xà lách_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Cải thìa", 100, 1, "");
  insert into image(product_id, url) values (64, "Cải thìa.jpg"),
  (64, "Cải thìa_1.jpg"),
  (64, "Cải thìa_2.jpg"),
  (64, "Cải thìa_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Rau muống", 100, 1.2, "");
  insert into image(product_id, url) values (65, "Rau muống.jpg"),
  (65, "Rau muống_1.jpg"),
  (65, "Rau muống_2.jpg"),
  (65, "Rau muống_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Cải bẹ xanh", 100, 0.6, "");
  insert into image(product_id, url) values (66, "Cải bẹ xanh.jpg"),
  (66, "Cải bẹ xanh_1.jpg"),
  (66, "Cải bẹ xanh_2.jpg"),
  (66, "Cải bẹ xanh_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Rau mồng tơi", 100, 1, "");
  insert into image(product_id, url) values (67, "Rau mồng tơi.jpg"),
  (67, "Rau mồng tơi_1.jpg"),
  (67, "Rau mồng tơi_2.jpg"),
  (67, "Rau mồng tơi_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Cải cúc", 100, 1.2, "");
  insert into image(product_id, url) values (68, "Cải cúc.jpg"),
  (68, "Cải cúc_1.jpg"),
  (68, "Cải cúc_2.jpg"),
  (68, "Cải cúc_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Bắp cải", 100, 0.6, "");
  insert into image(product_id, url) values (69, "Bắp cải.jpg"),
  (69, "Bắp cải_1.jpg"),
  (69, "Bắp cải_2.jpg"),
  (69, "Bắp cải_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Rau diếp cá", 100, 0.8, "");
  insert into image(product_id, url) values (70, "Rau diếp cá.jpg"),
  (70, "Rau diếp cá_1.jpg"),
  (70, "Rau diếp cá_2.jpg"),
  (70, "Rau diếp cá_3.jpg");

-- Root Vegetable
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Khoai tây", 100, 1.1, "");
  insert into image(product_id, url) values (71, "Khoai tây.jpg"),
  (71, "Khoai tây_1.jpg"),
  (71, "Khoai tây_2.jpg"),
  (71, "Khoai tây_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Khoai lang", 100, 1.5, "");
  insert into image(product_id, url) values (72, "Khoai lang.jpg"),
  (72, "Khoai lang_1.jpg"),
  (72, "Khoai lang_2.jpg"),
  (72, "Khoai lang_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Khoai môn", 100, 1.4, "");
  insert into image(product_id, url) values (73, "Khoai môn.jpg"),
  (73, "Khoai môn_1.jpg"),
  (73, "Khoai môn_2.jpg"),
  (73, "Khoai môn_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Củ sắn", 100, 1, "");
  insert into image(product_id, url) values (74, "Củ Sắn.jpg"),
  (74, "Củ Sắn_1.jpg"),
  (74, "Củ Sắn_2.jpg"),
  (74, "Củ Sắn_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Củ cải trắng", 100, 1.6, "");
  insert into image(product_id, url) values (75, "Củ cải trắng.jpg"),
  (75, "Củ cải trắng_1.jpg"),
  (75, "Củ cải trắng_2.jpg"),
  (75, "Củ cải trắng_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Củ cải đỏ", 100, 1.8, "");
  insert into image(product_id, url) values (76, "Củ cải đỏ.jpg"),
  (76, "Củ cải đỏ_1.jpg"),
  (76, "Củ cải đỏ_2.jpg"),
  (76, "Củ cải đỏ_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Củ cà rốt", 100, 1.4, "");
  insert into image(product_id, url) values (77, "Củ cà rốt.jpg"),
  (77, "Củ cà rốt_1.jpg"),
  (77, "Củ cà rốt_2.jpg"),
  (77, "Củ cà rốt_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Củ gừng", 100, 1, "");
  insert into image(product_id, url) values (78, "Củ gừng.jpg"),
  (78, "Củ gừng_1.jpg"),
  (78, "Củ gừng_2.jpg"),
  (78, "Củ gừng_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Củ nghệ", 100, 1.4, "");
  insert into image(product_id, url) values (79, "Củ nghệ.jpg"),
  (79, "Củ nghệ_1.jpg"),
  (79, "Củ nghệ_2.jpg"),
  (79, "Củ nghệ_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Hành tây", 100, 1.8, "");
  insert into image(product_id, url) values (80, "Hành tây.jpg"),
  (80, "Hành tây_1.jpg"),
  (80, "Hành tây_2.jpg"),
  (80, "Hành tây_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Tỏi", 100, 1, "");
  insert into image(product_id, url) values (81, "Tỏi.jpg"),
  (81, "Tỏi_1.jpg"),
  (81, "Tỏi_2.jpg"),
  (81, "Tỏi_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Tỏi Lý Sơn", 100, 2.5, "");
  
insert into image(product_id, url) values (82, "Tỏi Lý Sơn.jpg"),
(82, "Tỏi Lý Sơn_1.jpg"),
(82, "Tỏi Lý Sơn_2.jpg"),
(82, "Tỏi Lý Sơn_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Củ su hào", 100, 1.2, "");
insert into image(product_id, url) values (83, "Củ su hào.jpg"),
(83, "Củ su hào_1.jpg"),
(83, "Củ su hào_2.jpg"),
(83, "Củ su hào_3.jpg");

-- Herbs
insert into product(category_id, name, qty_in_stock, price, description) values(5, "Húng quế", 100, 1, "");
  
insert into image(product_id, url) values (84, "Húng quế.jpg"),
(84, "Húng quế_1.jpg"),
(84, "Húng quế_2.jpg"),
(84, "Húng quế_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) value(5, "Ngò rí", 100, 0.8, "");
  
insert into image(product_id, url) values (85, "Ngò rí.jpg"),
(85, "Ngò rí_1.jpg"),
(85, "Ngò rí_2.jpg"),
(85, "Ngò rí_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) value(5, "Hương thảo", 100, 1, "");
  
insert into image(product_id, url) values (86, "Hương thảo.jpg"),
(86, "Hương thảo_1.jpg"),
(86, "Hương thảo_2.jpg"),
(86, "Hương thảo_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(5, "Húng chanh", 100, 0.6, "");
  
insert into image(product_id, url) values (87, "Húng chanh.jpg"),
(87, "Húng chanh_1.jpg"),
(87, "Húng chanh_2.jpg"),
(87, "Húng chanh_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) value(5, "Thì là", 100, 1.2, "");
  
insert into image(product_id, url) values (88, "Thì là.jpg"),
(88, "Thì là_1.jpg"),
(88, "Thì là_2.jpg"),
(88, "Thì là_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) value(5, "Tía tô", 100, 1, "");
  
insert into image(product_id, url) values (89, "Tía tô.jpg"),
(89, "Tía tô_1.jpg"),
(89, "Tía tô_2.jpg"),
(89, "Tía tô_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) value(5, "Bạc hà", 100, 1.2, "");
  
insert into image(product_id, url) values (90, "Bạc hà.jpg"),
(90, "Bạc hà_1.jpg"),
(90, "Bạc hà_2.jpg"),
(90, "Bạc hà_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) value(5, "Sả", 100, 1.4, "");
  
insert into image(product_id, url) values (91, "Sả.jpg"),
(91, "Sả_1.jpg"),
(91, "Sả_2.jpg"),
(91, "Sả_3.jpg");

-- cart
insert into cart(user_id) values(4);
insert into cart_item(cart_id, product_id, qty) values 
(1, 1, 10),
(1, 2, 2),
(1, 3, 1);

-- review

insert into user_review (user_id, product_id, name, email, rating_value, comment) values
(null, 1, 'Nguyen Van A', 'nguyenvana@example.com', 5, 'Sản phẩm rất tuyệt vời, chất lượng tốt.'),
(null, 1, 'Tran Thi B', 'tranthib@example.com', 4, 'Sản phẩm dùng khá ổn, nhưng giao hàng hơi chậm.'),
(null, 1, 'Le Van C', 'levanc@example.com', 3, 'Chất lượng sản phẩm tạm được, giá hơi cao.'),
(null, 1, 'Pham Thi D', 'phamthid@example.com', 5, 'Rất hài lòng với sản phẩm, sẽ mua lại.'),
(null, 1, 'Hoang Van E', 'hoangvane@example.com', 4, 'Sản phẩm đúng mô tả, giá hợp lý.'),
(null, 1, 'Nguyen Thi F', 'nguyenthif@example.com', 2, 'Sản phẩm không như kỳ vọng, cần cải thiện.'),
(null, 1, 'Tran Van G', 'tranvang@example.com', 5, 'Dịch vụ và sản phẩm đều rất tốt.'),
(null, 1, 'Le Thi H', 'lethih@example.com', 3, 'Chưa thực sự ấn tượng, nhưng vẫn chấp nhận được.'),
(null, 1, 'Pham Van I', 'phamvani@example.com', 4, 'Giao hàng nhanh, sản phẩm chất lượng ổn.'),
(null, 1, 'Hoang Thi J', 'hoangthij@example.com', 1, 'Rất thất vọng, sản phẩm bị hỏng khi nhận.');

insert into user_review (user_id, product_id, name, email, rating_value, comment) values
(null, 2, 'Tran Van K', 'tranvank@example.com', 4, 'Sản phẩm đẹp, đúng mô tả, nhưng giao hàng hơi chậm.'),
(null, 2, 'Nguyen Thi L', 'nguyenthil@example.com', 5, 'Chất lượng vượt mong đợi, sẽ giới thiệu bạn bè.'),
(null, 2, 'Le Van M', 'levanm@example.com', 3, 'Tạm ổn, tuy nhiên cần cải thiện bao bì đóng gói.'),
(null, 2, 'Pham Thi N', 'phamthin@example.com', 2, 'Sản phẩm không đúng như quảng cáo, cần hỗ trợ.'),
(null, 2, 'Hoang Van O', 'hoangvano@example.com', 5, 'Giao hàng rất nhanh, sản phẩm tuyệt vời.'),
(null, 2, 'Nguyen Van P', 'nguyenvanp@example.com', 4, 'Sản phẩm đạt yêu cầu, giá cả hợp lý.'),
(null, 2, 'Tran Thi Q', 'tranthiq@example.com', 1, 'Rất không hài lòng, sản phẩm bị hư hỏng khi nhận.'),
(null, 2, 'Le Thi R', 'lethir@example.com', 5, 'Dịch vụ hỗ trợ khách hàng rất tốt, sản phẩm chất lượng.'),
(null, 2, 'Pham Van S', 'phamvans@example.com', 3, 'Sản phẩm trung bình, cần cải thiện về mặt thiết kế.'),
(null, 2, 'Hoang Thi T', 'hoangthit@example.com', 5, 'Rất hài lòng, sẽ tiếp tục mua hàng từ shop.');


use fruitables_shop_db;

select * from user;

select * from category;

select * from product;

select * from image;

select * from cart;

select * from cart_item;

select * from user_review;

