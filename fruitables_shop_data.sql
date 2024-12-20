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

-- Trái cây nhiệt đới (Tropical Fruits)
-- Mango
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Xoài cát Hòa Lộc", 100, 3.2, "");
insert into image(product_id, url) values (1, "Xoài cát Hòa Lộc.jpg");
insert into image(product_id, url) values (1, "Xoài cát Hòa Lộc_1.jpg");
insert into image(product_id, url) values (1, "Xoài cát Hòa Lộc_2.jpg");
insert into image(product_id, url) values (1, "Xoài cát Hòa Lộc_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Xoài cát chu xanh", 100, 2.5, "");
insert into image(product_id, url) values (2, "Xoài cát chu xanh.jpg");
insert into image(product_id, url) values (2, "Xoài cát chu xanh.jpg");
insert into image(product_id, url) values (2, "Xoài cát chu xanh.jpg");
insert into image(product_id, url) values (2, "Xoài cát chu xanh.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Xoài cát chu vàng", 100, 3.2, "");
insert into image(product_id, url) values (3, "Xoài cát chu vàng.jpg");
insert into image(product_id, url) values (3, "Xoài cát chu vàng_1.jpg");
insert into image(product_id, url) values (3, "Xoài cát chu vàng_2.jpg");
insert into image(product_id, url) values (3, "Xoài cát chu vàng_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Xoài tứ quý da xanh", 100, 1.2, "");
insert into image(product_id, url) values (4, "Xoài tứ quý da xanh.jpg");
insert into image(product_id, url) values (4, "Xoài tứ quý da xanh_1.jpg");
insert into image(product_id, url) values (4, "Xoài tứ quý da xanh_2.jpg");
insert into image(product_id, url) values (4, "Xoài tứ quý da xanh_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Xoài tứ quý da vàng", 100, 1.5, "");
insert into image(product_id, url) values (5, "Xoài tứ quý da vàng.jpg");
insert into image(product_id, url) values (5, "Xoài tứ quý da vàng_1.jpg");
insert into image(product_id, url) values (5, "Xoài tứ quý da vàng_2.jpg");
insert into image(product_id, url) values (5, "Xoài tứ quý da vàng_3.jpg");

-- pineapple data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Dứa queen", 100, 0.5, "");
insert into image(product_id, url) values (6, "Dứa queen.jpg");
insert into image(product_id, url) values (6, "Dứa queen_1.jpg");
insert into image(product_id, url) values (6, "Dứa queen_2.jpg");
insert into image(product_id, url) values (6, "Dứa queen_3.jpg");

-- banana data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Chuối tiêu", 100, 2.5, "");
insert into image(product_id, url) values (7, "Chuối tiêu.jpg");
insert into image(product_id, url) values (7, "Chuối tiêu_1.jpg");
insert into image(product_id, url) values (7, "Chuối tiêu_2.jpg");
insert into image(product_id, url) values (7, "Chuối tiêu_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Chuối sứ", 100, 2, "");
insert into image(product_id, url) values (8, "Chuối sứ.jpg");
insert into image(product_id, url) values (8, "Chuối sứ_1.jpg");
insert into image(product_id, url) values (8, "Chuối sứ_2.jpg");
insert into image(product_id, url) values (8, "Chuối sứ_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Chuối cau", 100, 2.5, "");
insert into image(product_id, url) values (9, "Chuối cau.jpg");
insert into image(product_id, url) values (9, "Chuối cau_1.jpg");
insert into image(product_id, url) values (9, "Chuối cau_2.jpg");
insert into image(product_id, url) values (9, "Chuối cau_3.jpg");

-- coconut data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Dừa xiêm xanh", 100, 1.4, "");
insert into image(product_id, url) values (10, "Dừa xiêm xanh.jpg");
insert into image(product_id, url) values (10, "Dừa xiêm xanh_1.jpg");
insert into image(product_id, url) values (10, "Dừa xiêm xanh_2.jpg");
insert into image(product_id, url) values (10, "Dừa xiêm xanh_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Dừa dứa", 100, 1.2, "");
insert into image(product_id, url) values (11, "Dừa dứa.jpg");
insert into image(product_id, url) values (11, "Dừa dứa_1.jpg");
insert into image(product_id, url) values (11, "Dừa dứa_2.jpg");
insert into image(product_id, url) values (11, "Dừa dứa_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Dừa sáp", 100, 2, "");
insert into image(product_id, url) values (12, "Dừa sáp.jpg");
insert into image(product_id, url) values (12, "Dừa sáp_1.jpg");
insert into image(product_id, url) values (12, "Dừa sáp_2.jpg");
insert into image(product_id, url) values (12, "Dừa sáp_3.jpg");

-- dragon fruit data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Thanh long ruột đỏ", 100, 2.2, "");
insert into image(product_id, url) values (13, "Thanh long ruột đỏ.jpg");
insert into image(product_id, url) values (13, "Thanh long ruột đỏ_1.jpg");
insert into image(product_id, url) values (13, "Thanh long ruột đỏ_2.jpg");
insert into image(product_id, url) values (13, "Thanh long ruột đỏ_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Thanh long ruột trắng", 100, 2.5, "");
insert into image(product_id, url) values (14, "Thanh long ruột trắng.jpg");
insert into image(product_id, url) values (14, "Thanh long ruột trắng_1.jpg");
insert into image(product_id, url) values (14, "Thanh long ruột trắng_2.jpg");
insert into image(product_id, url) values (14, "Thanh long ruột trắng_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Thanh long ruột vàng", 100, 3, "");
insert into image(product_id, url) values (15, "Thanh long ruột vàng.jpg");
insert into image(product_id, url) values (15, "Thanh long ruột vàng_1.jpg");
insert into image(product_id, url) values (15, "Thanh long ruột vàng_2.jpg");
insert into image(product_id, url) values (15, "Thanh long ruột vàng_3.jpg");

-- durian data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Sầu riêng Monthong (Thái)", 100, 5, "");
insert into image(product_id, url) values (16, "Sầu riêng Monthong (Thái).jpg");
insert into image(product_id, url) values (16, "Sầu riêng Monthong (Thái)_1.jpg");
insert into image(product_id, url) values (16, "Sầu riêng Monthong (Thái)_2.jpg");
insert into image(product_id, url) values (16, "Sầu riêng Monthong (Thái)_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Sầu riêng chuồng bò", 100, 4.5, "");
insert into image(product_id, url) values (17, "Sầu riêng chuồng bò.jpg");
insert into image(product_id, url) values (17, "Sầu riêng chuồng bò_1.jpg");
insert into image(product_id, url) values (17, "Sầu riêng chuồng bò_2.jpg");
insert into image(product_id, url) values (17, "Sầu riêng chuồng bò_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Sầu riêng Dona", 100, 5.2, "");
insert into image(product_id, url) values (18, "Sầu riêng Dona.jpg");
insert into image(product_id, url) values (18, "Sầu riêng Dona_1.jpg");
insert into image(product_id, url) values (18, "Sầu riêng Dona_2.jpg");
insert into image(product_id, url) values (18, "Sầu riêng Dona_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Sầu riêng Ri6", 100, 5.8, "");
insert into image(product_id, url) values (19, "Sầu riêng Ri6.jpg");
insert into image(product_id, url) values (19, "Sầu riêng Ri6_1.jpg");
insert into image(product_id, url) values (19, "Sầu riêng Ri6_2.jpg");
insert into image(product_id, url) values (19, "Sầu riêng Ri6_3.jpg");

-- pomelo data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Bưởi da xanh", 100, 2.5, "");
insert into image(product_id, url) values (20, "Bưởi da xanh.jpg");
insert into image(product_id, url) values (20, "Bưởi da xanh_1.jpg");
insert into image(product_id, url) values (20, "Bưởi da xanh_2.jpg");
insert into image(product_id, url) values (20, "Bưởi da xanh_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Bưởi Năm Roi", 100, 2.2, "");
insert into image(product_id, url) values (21, "Bưởi Năm Roi.jpg");
insert into image(product_id, url) values (21, "Bưởi Năm Roi_1.jpg");
insert into image(product_id, url) values (21, "Bưởi Năm Roi_2.jpg");
insert into image(product_id, url) values (21, "Bưởi Năm Roi_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Bưởi Phúc Trạch", 100, 2, "");
insert into image(product_id, url) values (22, "Bưởi Phúc Trạch.jpg");
insert into image(product_id, url) values (22, "Bưởi Phúc Trạch_1.jpg");
insert into image(product_id, url) values (22, "Bưởi Phúc Trạch_2.jpg");
insert into image(product_id, url) values (22, "Bưởi Phúc Trạch_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Bưởi Đoan Hùng", 100, 2.8, "");
insert into image(product_id, url) values (23, "Bưởi Đoan Hùng.jpg");
insert into image(product_id, url) values (23, "Bưởi Đoan Hùng_1.jpg");
insert into image(product_id, url) values (23, "Bưởi Đoan Hùng_2.jpg");
insert into image(product_id, url) values (23, "Bưởi Đoan Hùng_3.jpg");

-- papaya data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Đu đủ ruột đỏ", 100, 1, "");
insert into image(product_id, url) values (24, "Đu đủ ruột đỏ.jpg");
insert into image(product_id, url) values (24, "Đu đủ ruột đỏ_1.jpg");
insert into image(product_id, url) values (24, "Đu đủ ruột đỏ_2.jpg");
insert into image(product_id, url) values (24, "Đu đủ ruột đỏ_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Đu đủ ruột vàng", 100, 1.5, "");
insert into image(product_id, url) values (25, "Đu đủ ruột vàng.jpg");
insert into image(product_id, url) values (25, "Đu đủ ruột vàng_1.jpg");
insert into image(product_id, url) values (25, "Đu đủ ruột vàng_2.jpg");
insert into image(product_id, url) values (25, "Đu đủ ruột vàng_3.jpg");

-- guava data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Ổi nữ hoàng", 100, 1.5, "");
insert into image(product_id, url) values (26, "Ổi nữ hoàng.jpg");
insert into image(product_id, url) values (26, "Ổi nữ hoàng_1.jpg");
insert into image(product_id, url) values (26, "Ổi nữ hoàng_2.jpg");
insert into image(product_id, url) values (26, "Ổi nữ hoàng_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Ổi lê", 100, 2.5, "");
insert into image(product_id, url) values (27, "Ổi lê.jpg");
insert into image(product_id, url) values (27, "Ổi lê_1.jpg");
insert into image(product_id, url) values (27, "Ổi lê_2.jpg");
insert into image(product_id, url) values (27, "Ổi lê_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Ổi ruột hồng", 100, 2, "");
insert into image(product_id, url) values (28, "Ổi ruột hồng.jpg");
insert into image(product_id, url) values (28, "Ổi ruột hồng_1.jpg");
insert into image(product_id, url) values (28, "Ổi ruột hồng_2.jpg");
insert into image(product_id, url) values (28, "Ổi ruột hồng_3.jpg");

-- orange daa
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Cam sành", 100, 2, "");
insert into image(product_id, url) values (29, "Cam sành.jpg");
insert into image(product_id, url) values (29, "Cam sành_1.jpg");
insert into image(product_id, url) values (29, "Cam sành_2.jpg");
insert into image(product_id, url) values (29, "Cam sành_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Cam xoàn", 100, 2.2, "");
insert into image(product_id, url) values (30, "Cam xoàn.jpg");
insert into image(product_id, url) values (30, "Cam xoàn_1.jpg");
insert into image(product_id, url) values (30, "Cam xoàn_2.jpg");
insert into image(product_id, url) values (30, "Cam xoàn_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Cam Vinh", 100, 2.6, "");
insert into image(product_id, url) values (31, "Cam Vinh.jpg");
insert into image(product_id, url) values (31, "Cam Vinh_1.jpg");
insert into image(product_id, url) values (31, "Cam Vinh_2.jpg");
insert into image(product_id, url) values (31, "Cam Vinh_3.jpg");

-- mandarin data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Quýt đường", 100, 1.8, "");
insert into image(product_id, url) values (32, "Quýt đường.jpg");
insert into image(product_id, url) values (32, "Quýt đường_1.jpg");
insert into image(product_id, url) values (32, "Quýt đường_2.jpg");
insert into image(product_id, url) values (32, "Quýt đường_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Quýt hồng Lai Vung", 100, 2, "");
insert into image(product_id, url) values (33, "Quýt hồng Lai Vung.jpg");
insert into image(product_id, url) values (33, "Quýt hồng Lai Vung_1.jpg");
insert into image(product_id, url) values (33, "Quýt hồng Lai Vung_2.jpg");
insert into image(product_id, url) values (33, "Quýt hồng Lai Vung_3.jpg");

-- jackfruit data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Mít Thái siêu sớm", 100, 3.5, "");
insert into image(product_id, url) values (34, "Mít Thái siêu sớm.jpg");
insert into image(product_id, url) values (34, "Mít Thái siêu sớm_1.jpg");
insert into image(product_id, url) values (34, "Mít Thái siêu sớm_2.jpg");
insert into image(product_id, url) values (34, "Mít Thái siêu sớm_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Mít nghệ", 100, 3, "");
insert into image(product_id, url) values (35, "Mít nghệ.jpg");
insert into image(product_id, url) values (35, "Mít nghệ_1.jpg");
insert into image(product_id, url) values (35, "Mít nghệ_2.jpg");
insert into image(product_id, url) values (35, "Mít nghệ_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Mít tố nữ", 100, 2.5, "");
insert into image(product_id, url) values (36, "Mít tố nữ.jpg");
insert into image(product_id, url) values (36, "Mít tố nữ_1.jpg");
insert into image(product_id, url) values (36, "Mít tố nữ_2.jpg");
insert into image(product_id, url) values (36, "Mít tố nữ_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Mít siêu sớm ruột đỏ", 100, 5.8, "");
insert into image(product_id, url) values (37, "Mít siêu sớm ruột đỏ.jpg");
insert into image(product_id, url) values (37, "Mít siêu sớm ruột đỏ_1.jpg");
insert into image(product_id, url) values (37, "Mít siêu sớm ruột đỏ_2.jpg");
insert into image(product_id, url) values (37, "Mít siêu sớm ruột đỏ_3.jpg");

-- pomegranate data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Lựu đỏ Việt Nam", 100, 2.2, "");
insert into image(product_id, url) values (38, "Lựu đỏ Việt Nam.jpg");
insert into image(product_id, url) values (38, "Lựu đỏ Việt Nam_1.jpg");
insert into image(product_id, url) values (38, "Lựu đỏ Việt Nam_2.jpg");
insert into image(product_id, url) values (38, "Lựu đỏ Việt Nam_3.jpg");

-- sapodilla data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Sapoche Mặc Bắc", 100, 2.5, "");
insert into image(product_id, url) values (39, "Sapoche Mặc Bắc.jpg");
insert into image(product_id, url) values (39, "Sapoche Mặc Bắc_1.jpg");
insert into image(product_id, url) values (39, "Sapoche Mặc Bắc_2.jpg");
insert into image(product_id, url) values (39, "Sapoche Mặc Bắc_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Sapoche ruột đỏ", 100, 2.8, "");
insert into image(product_id, url) values (40, "Sapoche ruột đỏ.jpg");
insert into image(product_id, url) values (40, "Sapoche ruột đỏ_1.jpg");
insert into image(product_id, url) values (40, "Sapoche ruột đỏ_2.jpg");
insert into image(product_id, url) values (40, "Sapoche ruột đỏ_3.jpg");

-- jujube data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Táo xanh", 100, 1.2, "");
insert into image(product_id, url) values (41, "Táo xanh.jpg");
insert into image(product_id, url) values (41, "Táo xanh_1.jpg");
insert into image(product_id, url) values (41, "Táo xanh_2.jpg");
insert into image(product_id, url) values (41, "Táo xanh_3.jpg");

-- watermelon data
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Dưa hấu ruột đỏ", 100, 2.5, "");
insert into image(product_id, url) values (42, "Dưa hấu ruột đỏ.jpg");
insert into image(product_id, url) values (42, "Dưa hấu ruột đỏ_1.jpg");
insert into image(product_id, url) values (42, "Dưa hấu ruột đỏ_2.jpg");
insert into image(product_id, url) values (42, "Dưa hấu ruột đỏ_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Dưa hấu ruột vàng", 100, 2.8, "");
insert into image(product_id, url) values (43, "Dưa hấu ruột vàng.jpg");
insert into image(product_id, url) values (43, "Dưa hấu ruột vàng_1.jpg");
insert into image(product_id, url) values (43, "Dưa hấu ruột vàng_2.jpg");
insert into image(product_id, url) values (43, "Dưa hấu ruột vàng_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(1, "Dưa hấu không hạt", 100, 3, "");
insert into image(product_id, url) values (44, "Dưa hấu không hạt.jpg");
insert into image(product_id, url) values (44, "Dưa hấu không hạt_1.jpg");
insert into image(product_id, url) values (44, "Dưa hấu không hạt_2.jpg");
insert into image(product_id, url) values (44, "Dưa hấu không hạt_3.jpg");

-- stone fruits
-- plum data
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Mận hậu", 100, 2.5, "");
insert into image(product_id, url) values (45, "Mận hậu.jpg");
insert into image(product_id, url) values (45, "Mận hậu_1.jpg");
insert into image(product_id, url) values (45, "Mận hậu_2.jpg");
insert into image(product_id, url) values (45, "Mận hậu_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Mận An Phước", 100, 2, "");
insert into image(product_id, url) values (46, "Mận An Phước.jpg");
insert into image(product_id, url) values (46, "Mận An Phước_1.jpg");
insert into image(product_id, url) values (46, "Mận An Phước_2.jpg");
insert into image(product_id, url) values (46, "Mận An Phước_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Mận Tam Hoa", 100, 2.2, "");
insert into image(product_id, url) values (47, "Mận Tam Hoa.jpg");
insert into image(product_id, url) values (47, "Mận Tam Hoa_1.jpg");
insert into image(product_id, url) values (47, "Mận Tam Hoa_2.jpg");
insert into image(product_id, url) values (47, "Mận Tam Hoa_3.jpg");

-- peach data
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Đào Sapa", 100, 3, "");
insert into image(product_id, url) values (48, "Đào Sapa.jpg");
insert into image(product_id, url) values (48, "Đào Sapa_1.jpg");
insert into image(product_id, url) values (48, "Đào Sapa_2.jpg");
insert into image(product_id, url) values (48, "Đào Sapa_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Đào tiên", 100, 2.5, "");
insert into image(product_id, url) values (49, "Đào tiên.jpg");
insert into image(product_id, url) values (49, "Đào tiên_1.jpg");
insert into image(product_id, url) values (49, "Đào tiên_2.jpg");
insert into image(product_id, url) values (49, "Đào tiên_3.jpg");

-- Apricot data
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Mơ Hương Tích", 100, 3.5, "");
insert into image(product_id, url) values (50, "Mơ Hương Tích.jpg");
insert into image(product_id, url) values (50, "Mơ Hương Tích_1.jpg");
insert into image(product_id, url) values (50, "Mơ Hương Tích_2.jpg");
insert into image(product_id, url) values (50, "Mơ Hương Tích_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Mơ Bắc Kạn", 100, 1.5, "");
insert into image(product_id, url) values (51, "Mơ Bắc Kạn.jpg");
insert into image(product_id, url) values (51, "Mơ Bắc Kạn_1.jpg");
insert into image(product_id, url) values (51, "Mơ Bắc Kạn_2.jpg");
insert into image(product_id, url) values (51, "Mơ Bắc Kạn_3.jpg");

-- lychee data
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Vải thiều Lục Ngạn", 100, 3.5, "");
insert into image(product_id, url) values (52, "Vải thiều Lục Ngạn.jpg");
insert into image(product_id, url) values (52, "Vải thiều Lục Ngạn_1.jpg");
insert into image(product_id, url) values (52, "Vải thiều Lục Ngạn_2.jpg");
insert into image(product_id, url) values (52, "Vải thiều Lục Ngạn_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Vải thiều U Hồng", 100, 4.5, "");
insert into image(product_id, url) values (53, "Vải thiều U Hồng.jpg");
insert into image(product_id, url) values (53, "Vải thiều U Hồng_1.jpg");
insert into image(product_id, url) values (53, "Vải thiều U Hồng_2.jpg");
insert into image(product_id, url) values (53, "Vải thiều U Hồng_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Vải thiều tu hú", 100, 3.5, "");
insert into image(product_id, url) values (54, "Vải thiều tu hú.jpg");
insert into image(product_id, url) values (54, "Vải thiều tu hú_1.jpg");
insert into image(product_id, url) values (54, "Vải thiều tu hú_2.jpg");
insert into image(product_id, url) values (54, "Vải thiều tu hú_3.jpg");

-- longan data
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Nhãn lồng Hưng Yên", 100, 2.8, "");
insert into image(product_id, url) values (55, "Nhãn lồng Hưng Yên.jpg");
insert into image(product_id, url) values (55, "Nhãn lồng Hưng Yên_1.jpg");
insert into image(product_id, url) values (55, "Nhãn lồng Hưng Yên_2.jpg");
insert into image(product_id, url) values (55, "Nhãn lồng Hưng Yên_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Nhãn xuồng cơm vàng", 100, 1.5, "");
insert into image(product_id, url) values (56, "Nhãn xuồng cơm vàng.jpg");
insert into image(product_id, url) values (56, "Nhãn xuồng cơm vàng_1.jpg");
insert into image(product_id, url) values (56, "Nhãn xuồng cơm vàng_2.jpg");
insert into image(product_id, url) values (56, "Nhãn xuồng cơm vàng_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Nhãn tiêu da bò", 100, 2.8, "");
insert into image(product_id, url) values (57, "Nhãn tiêu da bò.jpg");
insert into image(product_id, url) values (57, "Nhãn tiêu da bò_1.jpg");
insert into image(product_id, url) values (57, "Nhãn tiêu da bò_2.jpg");
insert into image(product_id, url) values (57, "Nhãn tiêu da bò_3.jpg");

-- mangosteen data
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Măng cụt Lái Thiêu", 100, 2.5, "");
insert into image(product_id, url) values (58, "Măng cụt Lái Thiêu.jpg");
insert into image(product_id, url) values (58, "Măng cụt Lái Thiêu_1.jpg");
insert into image(product_id, url) values (58, "Măng cụt Lái Thiêu_2.jpg");
insert into image(product_id, url) values (58, "Măng cụt Lái Thiêu_3.jpg");

-- rambutan data
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Chôm chôm Java", 100, 2.5, "");
insert into image(product_id, url) values (59, "Chôm chôm Java.jpg");
insert into image(product_id, url) values (59, "Chôm chôm Java_1.jpg");
insert into image(product_id, url) values (59, "Chôm chôm Java_2.jpg");
insert into image(product_id, url) values (59, "Chôm chôm Java_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(2, "Chôm chôm nhãn", 100, 3.5, "");
insert into image(product_id, url) values (60, "Chôm chôm nhãn.jpg");
insert into image(product_id, url) values (60, "Chôm chôm nhãn_1.jpg");
insert into image(product_id, url) values (60, "Chôm chôm nhãn_2.jpg");
insert into image(product_id, url) values (60, "Chôm chôm nhãn_3.jpg");

-- Leafy Greens
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Cải bó xôi", 100, 1.2, "");
insert into image(product_id, url) values (61, "Cải bó xôi.jpg");
insert into image(product_id, url) values (61, "Cải bó xôi_1.jpg");
insert into image(product_id, url) values (61, "Cải bó xôi_2.jpg");
insert into image(product_id, url) values (61, "Cải bó xôi_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Cải xoăn", 100, 1, "");
insert into image(product_id, url) values (62, "Cải xoăn.jpg");
insert into image(product_id, url) values (62, "Cải xoăn_1.jpg");
insert into image(product_id, url) values (62, "Cải xoăn_2.jpg");
insert into image(product_id, url) values (62, "Cải xoăn_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Xà lách", 100, 0.8, "");
insert into image(product_id, url) values (63, "Xà lách.jpg");
insert into image(product_id, url) values (63, "Xà lách_1.jpg");
insert into image(product_id, url) values (63, "Xà lách_2.jpg");
insert into image(product_id, url) values (63, "Xà lách_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Cải thìa", 100, 1, "");
insert into image(product_id, url) values (64, "Cải thìa.jpg");
insert into image(product_id, url) values (64, "Cải thìa_1.jpg");
insert into image(product_id, url) values (64, "Cải thìa_2.jpg");
insert into image(product_id, url) values (64, "Cải thìa_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Rau muống", 100, 1.2, "");
insert into image(product_id, url) values (65, "Rau muống.jpg");
insert into image(product_id, url) values (65, "Rau muống_1.jpg");
insert into image(product_id, url) values (65, "Rau muống_2.jpg");
insert into image(product_id, url) values (65, "Rau muống_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Cải bẹ xanh", 100, 0.6, "");
insert into image(product_id, url) values (66, "Cải bẹ xanh.jpg");
insert into image(product_id, url) values (66, "Cải bẹ xanh_1.jpg");
insert into image(product_id, url) values (66, "Cải bẹ xanh_2.jpg");
insert into image(product_id, url) values (66, "Cải bẹ xanh_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Rau mồng tơi", 100, 1, "");
insert into image(product_id, url) values (67, "Rau mồng tơi.jpg");
insert into image(product_id, url) values (67, "Rau mồng tơi_1.jpg");
insert into image(product_id, url) values (67, "Rau mồng tơi_2.jpg");
insert into image(product_id, url) values (67, "Rau mồng tơi_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Cải cúc", 100, 1.2, "");
insert into image(product_id, url) values (68, "Cải cúc.jpg");
insert into image(product_id, url) values (68, "Cải cúc_1.jpg");
insert into image(product_id, url) values (68, "Cải cúc_2.jpg");
insert into image(product_id, url) values (68, "Cải cúc_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Bắp cải", 100, 0.6, "");
insert into image(product_id, url) values (69, "Bắp cải.jpg");
insert into image(product_id, url) values (69, "Bắp cải_1.jpg");
insert into image(product_id, url) values (69, "Bắp cải_2.jpg");
insert into image(product_id, url) values (69, "Bắp cải_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(3, "Rau diếp cá", 100, 0.8, "");
insert into image(product_id, url) values (70, "Rau diếp cá.jpg");
insert into image(product_id, url) values (70, "Rau diếp cá_1.jpg");
insert into image(product_id, url) values (70, "Rau diếp cá_2.jpg");
insert into image(product_id, url) values (70, "Rau diếp cá_3.jpg");

-- Root Vegetable
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Khoai tây", 100, 1.1, "");
insert into image(product_id, url) values (71, "Khoai tây.jpg");
insert into image(product_id, url) values (71, "Khoai tây_1.jpg");
insert into image(product_id, url) values (71, "Khoai tây_2.jpg");
insert into image(product_id, url) values (71, "Khoai tây_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Khoai lang", 100, 1.5, "");
insert into image(product_id, url) values (72, "Khoai lang.jpg");
insert into image(product_id, url) values (72, "Khoai lang_1.jpg");
insert into image(product_id, url) values (72, "Khoai lang_2.jpg");
insert into image(product_id, url) values (72, "Khoai lang_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Khoai môn", 100, 1.4, "");
insert into image(product_id, url) values (73, "Khoai môn.jpg");
insert into image(product_id, url) values (73, "Khoai môn_1.jpg");
insert into image(product_id, url) values (73, "Khoai môn_2.jpg");
insert into image(product_id, url) values (73, "Khoai môn_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Củ sắn", 100, 1, "");
insert into image(product_id, url) values (74, "Củ Sắn.jpg");
insert into image(product_id, url) values (74, "Củ Sắn_1.jpg");
insert into image(product_id, url) values (74, "Củ Sắn_2.jpg");
insert into image(product_id, url) values (74, "Củ Sắn_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Củ cải trắng", 100, 1.6, "");
insert into image(product_id, url) values (75, "Củ cải trắng.jpg");
insert into image(product_id, url) values (75, "Củ cải trắng_1.jpg");
insert into image(product_id, url) values (75, "Củ cải trắng_2.jpg");
insert into image(product_id, url) values (75, "Củ cải trắng_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Củ cải đỏ", 100, 1.8, "");
insert into image(product_id, url) values (76, "Củ cải đỏ.jpg");
insert into image(product_id, url) values (76, "Củ cải đỏ_1.jpg");
insert into image(product_id, url) values (76, "Củ cải đỏ_2.jpg");
insert into image(product_id, url) values (76, "Củ cải đỏ_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Củ cà rốt", 100, 1.4, "");
insert into image(product_id, url) values (77, "Củ cà rốt.jpg");
insert into image(product_id, url) values (77, "Củ cà rốt_1.jpg");
insert into image(product_id, url) values (77, "Củ cà rốt_2.jpg");
insert into image(product_id, url) values (77, "Củ cà rốt_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Củ gừng", 100, 1, "");
insert into image(product_id, url) values (78, "Củ gừng.jpg");
insert into image(product_id, url) values (78, "Củ gừng_1.jpg");
insert into image(product_id, url) values (78, "Củ gừng_2.jpg");
insert into image(product_id, url) values (78, "Củ gừng_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Củ nghệ", 100, 1.4, "");
insert into image(product_id, url) values (79, "Củ nghệ.jpg");
insert into image(product_id, url) values (79, "Củ nghệ_1.jpg");
insert into image(product_id, url) values (79, "Củ nghệ_2.jpg");
insert into image(product_id, url) values (79, "Củ nghệ_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Hành tây", 100, 1.8, "");
insert into image(product_id, url) values (80, "Hành tây.jpg");
insert into image(product_id, url) values (80, "Hành tây_1.jpg");
insert into image(product_id, url) values (80, "Hành tây_2.jpg");
insert into image(product_id, url) values (80, "Hành tây_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Tỏi", 100, 1, "");
insert into image(product_id, url) values (81, "Tỏi.jpg");
insert into image(product_id, url) values (81, "Tỏi_1.jpg");
insert into image(product_id, url) values (81, "Tỏi_2.jpg");
insert into image(product_id, url) values (81, "Tỏi_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Tỏi Lý Sơn", 100, 2.5, "");
insert into image(product_id, url) values (82, "Tỏi Lý Sơn.jpg");
insert into image(product_id, url) values (82, "Tỏi Lý Sơn_1.jpg");
insert into image(product_id, url) values (82, "Tỏi Lý Sơn_2.jpg");
insert into image(product_id, url) values (82, "Tỏi Lý Sơn_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(4, "Củ su hào", 100, 1.2, "");
insert into image(product_id, url) values (83, "Củ su hào.jpg");
insert into image(product_id, url) values (83, "Củ su hào_1.jpg");
insert into image(product_id, url) values (83, "Củ su hào_2.jpg");
insert into image(product_id, url) values (83, "Củ su hào_3.jpg");

-- Herbs
insert into product(category_id, name, qty_in_stock, price, description) values(5, "Húng quế", 100, 1, "");
insert into image(product_id, url) values (84, "Húng quế.jpg");
insert into image(product_id, url) values (84, "Húng quế_1.jpg");
insert into image(product_id, url) values (84, "Húng quế_2.jpg");
insert into image(product_id, url) values (84, "Húng quế_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(5, "Ngò rí", 100, 0.8, "");
insert into image(product_id, url) values (85, "Ngò rí.jpg");
insert into image(product_id, url) values (85, "Ngò rí_1.jpg");
insert into image(product_id, url) values (85, "Ngò rí_2.jpg");
insert into image(product_id, url) values (85, "Ngò rí_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(5, "Hương thảo", 100, 1, "");
insert into image(product_id, url) values (86, "Hương thảo.jpg");
insert into image(product_id, url) values (86, "Hương thảo_1.jpg");
insert into image(product_id, url) values (86, "Hương thảo_2.jpg");
insert into image(product_id, url) values (86, "Hương thảo_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(5, "Húng chanh", 100, 0.6, "");
insert into image(product_id, url) values (87, "Húng chanh.jpg");
insert into image(product_id, url) values (87, "Húng chanh_1.jpg");
insert into image(product_id, url) values (87, "Húng chanh_2.jpg");
insert into image(product_id, url) values (87, "Húng chanh_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(5, "Thì là", 100, 1.2, "");
insert into image(product_id, url) values (88, "Thì là.jpg");
insert into image(product_id, url) values (88, "Thì là_1.jpg");
insert into image(product_id, url) values (88, "Thì là_2.jpg");
insert into image(product_id, url) values (88, "Thì là_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(5, "Tía tô", 100, 1, "");
insert into image(product_id, url) values (89, "Tía tô.jpg");
insert into image(product_id, url) values (89, "Tía tô_1.jpg");
insert into image(product_id, url) values (89, "Tía tô_2.jpg");
insert into image(product_id, url) values (89, "Tía tô_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(5, "Bạc hà", 100, 1.2, "");
insert into image(product_id, url) values (90, "Bạc hà.jpg");
insert into image(product_id, url) values (90, "Bạc hà_1.jpg");
insert into image(product_id, url) values (90, "Bạc hà_2.jpg");
insert into image(product_id, url) values (90, "Bạc hà_3.jpg");
insert into product(category_id, name, qty_in_stock, price, description) values(5, "Sả", 100, 1.4, "");
insert into image(product_id, url) values (91, "Sả.jpg");
insert into image(product_id, url) values (91, "Sả_1.jpg");
insert into image(product_id, url) values (91, "Sả_2.jpg");
insert into image(product_id, url) values (91, "Sả_3.jpg");
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

