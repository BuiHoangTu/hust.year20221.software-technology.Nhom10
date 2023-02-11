SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `quan_ly_nhan_khau` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `quan_ly_nhan_khau`;

DROP TABLE IF EXISTS `chung_minh_thu`;
CREATE TABLE `chung_minh_thu` (
  `soCMT` bigint(12) UNSIGNED ZEROFILL DEFAULT NULL,
  `ngayCap` date DEFAULT NULL,
  `noiCap` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `anhChanDung` mediumblob DEFAULT NULL,
  `maNhanKhau` bigint(12) UNSIGNED ZEROFILL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `chung_minh_thu` (`soCMT`, `ngayCap`, `noiCap`, `anhChanDung`, `maNhanKhau`) VALUES
(000000000001, '2005-07-12', NULL, NULL, 000000000001),
(000000000002, '2012-09-05', NULL, NULL, 000000000002),
(000000000003, '2010-07-09', NULL, NULL, 000000000003),
(000000000004, '1970-10-16', NULL, NULL, 000000000004),
(000000000005, '1985-11-12', NULL, NULL, 000000000005),
(000000000006, '2006-08-09', NULL, NULL, 000000000006),
(000000000007, '2012-06-30', NULL, NULL, 000000000007),
(000000000008, '1996-04-30', NULL, NULL, 000000000008),
(000000000009, '2001-07-10', NULL, NULL, 000000000009),
(000000000010, '1960-03-12', NULL, NULL, 000000000012),
(000000000011, '1963-02-10', NULL, NULL, 000000000013);

DROP TABLE IF EXISTS `dinh_chinh_ho_khau`;
CREATE TABLE `dinh_chinh_ho_khau` (
  `idHoKhau` bigint(12) UNSIGNED ZEROFILL NOT NULL,
  `thongTinThayDoi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `thayDoiTu` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `thayDoiThanh` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `thoiGianThayDoi` date NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `nguoiThayDoi` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `ho_khau`;
CREATE TABLE `ho_khau` (
  `maHoKhau` bigint(12) UNSIGNED ZEROFILL NOT NULL,
  `idChuHo` bigint(12) UNSIGNED ZEROFILL DEFAULT NULL,
  `maKhuVuc` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diaChi` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngayLap` date DEFAULT current_timestamp(),
  `nguoiThucHien` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `ho_khau` (`maHoKhau`, `idChuHo`, `maKhuVuc`, `diaChi`, `ngayLap`, `nguoiThucHien`) VALUES
(000000000001, 000000000004, 'HN03', 'Số 1 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '2019-12-08', NULL),
(000000000002, 000000000006, 'HN03', 'Số 2 Tạ Quang Bửu, quần Hai Bà Trưng, Hà Nội', '2019-12-08', NULL),
(000000000003, 000000000007, 'HN03', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '2019-12-08', NULL),
(000000000004, 000000000011, 'HN03', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '2019-12-08', NULL);

DROP TABLE IF EXISTS `khai_tu`;
CREATE TABLE `khai_tu` (
  `soGiayKhaiTu` bigint(12) UNSIGNED ZEROFILL NOT NULL,
  `idNguoiKhai` bigint(12) UNSIGNED ZEROFILL DEFAULT NULL,
  `idNguoiChet` bigint(12) UNSIGNED ZEROFILL DEFAULT NULL,
  `ngayKhai` date DEFAULT current_timestamp(),
  `ngayChet` date DEFAULT NULL,
  `lyDoChet` text COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `lam_viec`;
CREATE TABLE `lam_viec` (
  `idNhanKhau` bigint(12) UNSIGNED ZEROFILL NOT NULL,
  `tuNgay` date NOT NULL,
  `denNgay` date DEFAULT NULL,
  `diaChi` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngheNghiep` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `noiLamViec` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `lam_viec` (`idNhanKhau`, `tuNgay`, `denNgay`, `diaChi`, `ngheNghiep`, `noiLamViec`) VALUES
(000000000001, '2015-09-05', '2015-09-05', 'Số 45, ngõ 56, Nguyễn Khang, Cầu Giấy, Hà Nội', 'Sinh Viên', 'Đại học Thương mại'),
(000000000002, '2012-09-05', '2017-09-05', '556 La Thành, Hà Nội', 'Sinh Viên', 'Đại học Bách khoa Hà Nội'),
(000000000003, '1989-05-10', '2000-08-25', 'Số 5 Nguyễn Khuyến, Hà Nội', 'Quản lý nhận sự', 'Công ty BCC'),
(000000000004, '1987-05-23', '1997-03-01', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Nhân viên văn phòng', 'Công ty Zezs'),
(000000000005, '2008-09-05', '2013-09-05', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Sinh viên', 'Đại học Bách khoa Hà Nội'),
(000000000006, '2015-09-05', '2019-09-05', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Sinh viên', 'Đại học Luật Hà Nội'),
(000000000007, '1998-09-05', '2003-09-05', 'Số 66, ngõ 445 Nguyễn Khang, Cầu Giấy, Hà Nội', 'Sinh Vvên', 'Đại học Bách khoa Hà Nội'),
(000000000008, '2003-10-03', '2018-08-06', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Giảng viên', 'Đại học Công ngiệp Hà Nội'),
(000000000009, '2003-09-05', '2011-09-05', 'Số 8 Tôn Thất Tùng, Hà Nội', 'Sinh viên', 'Đại học Y Hà Nội'),
(000000000010, '2011-10-03', '2015-08-09', 'Số 8 Tôn Thất Tùng, Hà Nội', 'Bác sĩ nội trú', 'Bệnh viện Bạch Mai'),
(000000000011, '1961-01-01', '1963-01-01', 'Không rõ', 'Bộ đội', 'Hà Nội');

DROP TABLE IF EXISTS `nhan_khau`;
CREATE TABLE `nhan_khau` (
  `maNhanKhau` bigint(12) UNSIGNED ZEROFILL NOT NULL,
  `hoTen` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bietDanh` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `namSinh` date DEFAULT NULL,
  `gioiTinh` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `noiSinh` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nguyenQuan` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `danToc` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tonGiao` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `quocTich` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `soHoChieu` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `noiThuongTru` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diaChiHienNay` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `trinhDoHocVan` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TrinhDoChuyenMon` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bietTiengDanToc` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `trinhDoNgoaiNgu` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngheNghiep` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `noiLamViec` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tienAn` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngayChuyenDen` date DEFAULT NULL,
  `lyDoChuyenDen` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngayChuyenDi` date DEFAULT NULL,
  `lyDoChuyenDi` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `diaChiMoi` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngayTao` date DEFAULT NULL,
  `idNguoiTao` int(11) DEFAULT NULL,
  `ngayXoa` date DEFAULT NULL,
  `idNguoiXoa` int(11) DEFAULT NULL,
  `lyDoXoa` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ghiChu` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `nhan_khau` (`maNhanKhau`, `hoTen`, `bietDanh`, `namSinh`, `gioiTinh`, `noiSinh`, `nguyenQuan`, `danToc`, `tonGiao`, `quocTich`, `soHoChieu`, `noiThuongTru`, `diaChiHienNay`, `trinhDoHocVan`, `TrinhDoChuyenMon`, `bietTiengDanToc`, `trinhDoNgoaiNgu`, `ngheNghiep`, `noiLamViec`, `tienAn`, `ngayChuyenDen`, `lyDoChuyenDen`, `ngayChuyenDi`, `lyDoChuyenDi`, `diaChiMoi`, `ngayTao`, `idNguoiTao`, `ngayXoa`, `idNguoiXoa`, `lyDoXoa`, `ghiChu`) VALUES
(000000000001, 'Trinh Văn An', '', '1990-12-07', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 1 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội', 'Số 1 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'Không', 'Anh trình đọ B', 'Giáo Viên', 'Trường THCS Chu Văn An', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(000000000002, 'Trần Thanh Duyên', '', '1997-12-23', 'Nữ', NULL, 'Hải Phòng', 'Kinh', 'Không', 'Việt Nam', '', 'Số 3, đường Đình Đông, phường Đình Đông, quận Ngô Quyền, Hải Phòng', 'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'Không', 'Anh trình độ D', 'Nhân viên văn phòng', 'Công ty ABC', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(000000000003, 'Nguyễn Minh Quân', '', '1995-05-31', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'Không', 'Anh trình độ D', 'Kỹ sư', 'Viettel', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(000000000004, 'Nguyễn Tiến Dũng', '', '1964-06-03', 'Nam', NULL, 'Hải Dương', 'Kinh', 'Thiên chúa giáo', 'Việt Nam', '', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Kỹ sư', 'Không', 'Không', 'Phó giám đốc', 'Công ty EXE', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(000000000005, 'Vũ Mỹ Linh', '', '1965-12-06', 'Nữ', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12', 'Cử Nhân', 'Không', 'Không', 'Nội trợ', 'Tại nhà', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(000000000006, 'Nguyễn Tiến Đạt', '', '1990-09-09', 'Nam', NULL, 'Hải Dương', 'Kinh', 'Thiên chúa giáo', 'Việt Nam', '', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Kỹ sư', 'không', 'Anh trình độ C', 'Kỹ sư điện', 'Công ty điện EVN', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(000000000007, 'Nguyễn Trà My', '', '1997-12-12', 'Nữ', NULL, 'Hải Dương', 'Kinh', 'Thiên chúa giáo', 'Việt Nam', '', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'không', 'Anh trình đố D', 'Luật sư', 'Văn phòng luật sư 123', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(000000000008, 'Trần Văn Nam', '', '1980-07-09', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Tiến sĩ', 'Không', 'Anh trình độ D', 'Giảng viên đại học', 'Đại học Bách khoa Hà Nội', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(000000000009, 'Nguyễn Minh Tuyết', '', '1985-09-02', 'Nữ', NULL, 'Nam Định', 'Kinh', 'Không', 'Việt Nam', '', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '12/12 chính quy', 'Thạc sĩ', 'Không', 'Anh trình độ D', 'Bác sĩ', 'Bệnh viện quốc tế HJK', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(000000000010, 'Trần Trung Kiên', '', '2008-12-25', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '6/12 chính quy', 'Không', 'Không', 'Không', 'Học sinh', 'Trường THCS Chu Văn An', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(000000000011, 'Trần Thúy Ngọc', '', '2013-01-15', 'Nữ', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '1/12 chính quy', 'Không', 'Không', 'Không', 'Học sinh', 'Trường tiểu học Chu Văn An', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(000000000012, 'Lý Văn Công', '', '1945-06-04', 'Nam', NULL, 'Hà Nội', 'Kinh', 'Không', 'Việt Nam', '', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '10/12 chính quy', 'Không', 'Không', 'Không', 'Về hưu', 'Không', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL),
(000000000013, 'Bùi Thị Hà', '', '1948-02-03', 'Nữ', NULL, 'Hải Phòng', 'Kinh', 'Không', 'Việt Nam', '', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', 'Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội', '10/12', 'Không', 'Không', 'Không', 'Nội trợ', 'Tại nhà', NULL, NULL, NULL, NULL, NULL, NULL, '2019-12-08', 1, NULL, NULL, NULL, NULL);

DROP TABLE IF EXISTS `tam_tru_vang`;
CREATE TABLE `tam_tru_vang` (
  `idNhanKhau` bigint(12) UNSIGNED ZEROFILL DEFAULT NULL,
  `maGiayTamVang` bigint(12) UNSIGNED ZEROFILL NOT NULL,
  `noiTamtru` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tuNgay` date DEFAULT NULL,
  `denNgay` date DEFAULT NULL,
  `lyDo` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `noiTamVang` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `daXacNhanTamVangTru` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `thanh_vien_cua_ho`;
CREATE TABLE `thanh_vien_cua_ho` (
  `idNhanKhau` bigint(12) UNSIGNED ZEROFILL NOT NULL,
  `idHoKhau` bigint(12) UNSIGNED ZEROFILL NOT NULL,
  `quanHeVoiChuHo` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `thanh_vien_cua_ho` (`idNhanKhau`, `idHoKhau`, `quanHeVoiChuHo`) VALUES
(000000000004, 000000000001, 'Chủ hộ'),
(000000000002, 000000000001, 'Vợ'),
(000000000006, 000000000002, 'Chủ hộ'),
(000000000005, 000000000003, 'Vợ'),
(000000000003, 000000000003, 'Con trai'),
(000000000001, 000000000003, 'Con gái'),
(000000000007, 000000000003, 'Chủ hộ'),
(000000000009, 000000000004, 'Vợ'),
(000000000010, 000000000004, 'Con trai'),
(000000000011, 000000000004, 'Chủ hộ');

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `userName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `passwd` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `users` (`ID`, `userName`, `passwd`) VALUES
(1, 'admin', '1');


ALTER TABLE `chung_minh_thu`
  ADD UNIQUE KEY `chung_minh_thu_soCMT_IDX` (`soCMT`) USING BTREE,
  ADD KEY `chung_minh_thu_FK` (`maNhanKhau`);

ALTER TABLE `dinh_chinh_ho_khau`
  ADD PRIMARY KEY (`idHoKhau`,`thongTinThayDoi`,`thoiGianThayDoi`),
  ADD KEY `idHoKhau` (`idHoKhau`),
  ADD KEY `nguoiThayDoi` (`nguoiThayDoi`);

ALTER TABLE `ho_khau`
  ADD PRIMARY KEY (`maHoKhau`),
  ADD UNIQUE KEY `idChuHo` (`idChuHo`) USING BTREE,
  ADD KEY `ho_khau_FK` (`nguoiThucHien`);

ALTER TABLE `khai_tu`
  ADD PRIMARY KEY (`soGiayKhaiTu`),
  ADD KEY `idNguoiKhai` (`idNguoiKhai`),
  ADD KEY `idNguoiChet` (`idNguoiChet`);

ALTER TABLE `lam_viec`
  ADD PRIMARY KEY (`idNhanKhau`,`tuNgay`,`ngheNghiep`),
  ADD KEY `idNhanKhau` (`idNhanKhau`);

ALTER TABLE `nhan_khau`
  ADD PRIMARY KEY (`maNhanKhau`),
  ADD KEY `tao_nhan_khau_FK` (`idNguoiTao`),
  ADD KEY `xoa_nhan_khau_FK` (`idNguoiXoa`);
ALTER TABLE `nhan_khau` ADD FULLTEXT KEY `hoTen` (`hoTen`,`bietDanh`);

ALTER TABLE `tam_tru_vang`
  ADD PRIMARY KEY (`maGiayTamVang`),
  ADD KEY `nguoi_tam_tru_vang_FK` (`idNhanKhau`);

ALTER TABLE `thanh_vien_cua_ho`
  ADD PRIMARY KEY (`idNhanKhau`,`idHoKhau`),
  ADD UNIQUE KEY `idNhanKhau` (`idNhanKhau`),
  ADD KEY `idHoKhau` (`idHoKhau`);

ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);


ALTER TABLE `khai_tu`
  MODIFY `soGiayKhaiTu` bigint(12) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT;

ALTER TABLE `nhan_khau`
  MODIFY `maNhanKhau` bigint(12) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

ALTER TABLE `tam_tru_vang`
  MODIFY `maGiayTamVang` bigint(12) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT;

ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

alter table `ho_khau`
    MODIFY `maHoKhau` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

ALTER TABLE `chung_minh_thu`
  ADD CONSTRAINT `chung_minh_thu_FK` FOREIGN KEY (`maNhanKhau`) REFERENCES `nhan_khau` (`maNhanKhau`);

ALTER TABLE `dinh_chinh_ho_khau`
  ADD CONSTRAINT `dinh_chinh_ho_khau_ibfk_2` FOREIGN KEY (`nguoiThayDoi`) REFERENCES `users` (`ID`),
  ADD CONSTRAINT `ho_khau_thay_doi_FK` FOREIGN KEY (`idHoKhau`) REFERENCES `ho_khau` (`maHoKhau`);

ALTER TABLE `ho_khau`
  ADD CONSTRAINT `ho_khau_FK` FOREIGN KEY (`nguoiThucHien`) REFERENCES `users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `khai_tu`
  ADD CONSTRAINT `nguo_khai_tu_FK` FOREIGN KEY (`idNguoiKhai`) REFERENCES `nhan_khau` (`maNhanKhau`),
  ADD CONSTRAINT `nguoi_bi_khai_tu_FK` FOREIGN KEY (`idNguoiChet`) REFERENCES `nhan_khau` (`maNhanKhau`);

ALTER TABLE `nhan_khau`
  ADD CONSTRAINT `tao_nhan_khau_FK` FOREIGN KEY (`idNguoiTao`) REFERENCES `users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `xoa_nhan_khau_FK` FOREIGN KEY (`idNguoiXoa`) REFERENCES `users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `tam_tru_vang`
  ADD CONSTRAINT `nguoi_tam_tru_vang_FK` FOREIGN KEY (`idNhanKhau`) REFERENCES `nhan_khau` (`maNhanKhau`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

