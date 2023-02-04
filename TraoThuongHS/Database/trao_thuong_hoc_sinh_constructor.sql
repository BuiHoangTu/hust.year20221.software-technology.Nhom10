create database trao_thuong_hoc_sinh;
use trao_thuong_hoc_sinh;
create table `hoc_sinh`(
	`id` int primary key auto_increment,
	`ten` varchar(100) not null,
	`ngaySinh` date,
	`truongHoc` varchar(100),
	`lop` varchar(10),
	`maHoKhau` bigInt(12),
	`phuHuynh` varchar(100)
);

create table `phan_thuong`(
	`idHocSinh` int,
	constraint fk_lich_su_hoc_sinh
		foreign key (idHocSinh)
		references hoc_sinh(id)
		on delete cascade
		on update cascade,
	`ngayPhatThuong` date,
	`dotPhatThuong` varchar(100),
	`danhHieu` varchar(50),
	primary key (idHocSinh, dotPhatThuong)
);

create table `muc_trao_thuong` (
	`ngayApDung` date,
	`danhHieu` varchar(50),
	`soVo` int,
	primary key (ngayApDung, danhHieu)
);
create index `i_ngay_ap_dung_thuong` on muc_trao_thuong (ngayApDung DESC);

create table `gia_thuong` (
	`ngayApDung` date primary key,
	`giaTien` int
);

create TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `passwd` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
insert into users (userName, passwd) values ("admin", 1);