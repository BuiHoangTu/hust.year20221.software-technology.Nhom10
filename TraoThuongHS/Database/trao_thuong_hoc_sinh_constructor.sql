create database trao_thuong_hoc_sinh;
use trao_thuong_hoc_sinh;
create table `hoc_sinh`(
	`id` int primary key auto_increment,
	`ten` varchar(100) not null,
	`ngaySinh` date,
	`truongHoc` varchar(100),
	`maHoKhau` bigInt(12),
	`phuHuynh` varchar(100)
);
INSERT INTO `hoc_sinh`(`id`, `ten`, `ngaySinh`, `truongHoc`, `maHoKhau`, `phuHuynh`) VALUES 
('1','Lê Ngọc Đăng Khoa','2002-09-30','Đại học Bách Khoa Hà Nội','000000000001','Đỗ Thị Lệ Thúy'),
('2','Bùi Hoàng Tú','2002-08-15','Đại học Bách Khoa Hà Nội','000000000002','Trần Nguyên Ngọc'),
('3','Nguyễn Hoàng Hiệp','2002-11-12','Đại học Bách Khoa Hà Nội','000000000003','Nguyễn Bá Ngọc'),
('4','Mai Nguyễn Ngọc Huy','2002-11-20','Đại học Bách Khoa Hà Nội','000000000004','Nguyễn Thị Thanh Nga'),
('5','Lê Hải Quang','2004-11-30','Đại học Bách Khoa Hà Nội','000000000005','Đỗ Thanh Hoàng'),
('6','Trần Nam Dương','2003-11-26','Đại học Bách Khoa Hà Nội','000000000006','Trịnh Tuấn Đạt'),
('7','Nguyễn Hoàng Long','2002-07-02','Đại học Bách Khoa Hà Nội','000000000007','Ban Hà Bằng'),
('8','Nguyễn Nam Khánh','2004-12-19','Cao đẳng Công nghệ Bách Khoa','000000000008','Nguyễn Văn Hiên'),
('9','Lê Khánh Linh','2003-08-18','Đại học Kiến Trúc','000000000009','Phan Y Lan');

create table `phan_thuong`(
	`idHocSinh` int,
	constraint fk_lich_su_hoc_sinh
		foreign key (idHocSinh)
		references hoc_sinh(id)
		on delete cascade
		on update cascade,
	`lop` varchar(12),
	`ngayPhatThuong` date,
	`dotPhatThuong` varchar(100),
	`danhHieu` varchar(50),
	primary key (idHocSinh, dotPhatThuong)
);
INSERT INTO `phan_thuong`(`idHocSinh`, `ngayPhatThuong`, `lop`, `dotPhatThuong`, `danhHieu`) VALUES 
('1','2022-09-10','Việt Pháp 01-K65','Trung thu 2022','Tiên tiến'),
('2','2022-09-10','Việt Pháp 01-K65','Trung Thu 2022','Xuất sắc'),
('3','2022-12-25','Việt Pháp 01-K65','Noel 2022','Giỏi'),
('4','2022-12-25','Việt Pháp 01-K65','Noel 2022','Tiên tiến'),
('5','2022-12-25','Toán Tin 03-K67','Noel 2022','Xuất sắc'),
('6','2023-01-13','ICT 04-K66','Tết Nguyên Đán Quý Mão 2023','Giỏi'),
('7','2023-01-13','Việt Nhật 02-K65','Tết Nguyên Đán Quý Mão 2023','Xuất sắc');

create table `muc_trao_thuong` (
	`ngayApDung` date,
	`danhHieu` varchar(50),
	`soVo` int,
	primary key (ngayApDung, danhHieu)
);
INSERT INTO `muc_trao_thuong`(`ngayApDung`, `danhHieu`, `soVo`) VALUES
('2022-06-01','Tiên tiến','2'),
('2022-06-01','Giỏi','4'),
('2022-06-01','Xuất sắc','7'),
('2022-09-10','Tiên tiến','3'),
('2022-09-10','Giỏi','5'),
('2022-09-10','Xuất sắc','8'),
('2022-12-25','Tiên tiến','5'),
('2022-12-25','Giỏi','8'),
('2022-12-25','Xuất sắc','10'),
('2023-01-13','Giỏi','10'),
('2023-01-13','Xuất sắc','15');

create index `i_ngay_ap_dung_thuong` on muc_trao_thuong (ngayApDung DESC);

create table `gia_thuong` (
	`ngayApDung` date primary key,
	`giaTien` int
);
INSERT INTO `gia_thuong`(`ngayApDung`, `giaTien`) VALUES 
('2022-06-01','5000'),
('2022-09-10','7000'),
('2022-12-25',10000),
('2023-01-13','9000');

create TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `passwd` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
insert into users (userName, passwd) values ("admin", 1);