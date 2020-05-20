use DuAnMau
CREATE TABLE HocVien(
	Mahocvien int primary key identity(1,1) not null,
	MaKhoahoc int not null,
	MaNguoiHoc Nchar(27) not null,
	DiemTrungBinh float not null
)
CREATE TABLE NguoiHoc(
	MaNguoiHoc Nchar(27) primary key not null,
	HoTen Nvarchar (50),
	NgaySinh date not null,
	GioiTinh bit not null,
	DienThoai Nvarchar(50) not null,
	Email Nvarchar(50) not null,
	MaNhanVien Nvarchar(50) not null,
	NgayDangKi date not null
)
CREATE TABLE ChuyenDe(
	MaChuyenDe nchar(5) primary key not null,
	tenChuyenDe Nvarchar(50) not null,
	HocPhi Float not null,
	ThoiLuong int not null,
	Hinh Nvarchar(50) not null,
	Mota Nvarchar(255) not null
)
CREATE TABLE KhoaHoc(
	MaKhoaHoc int primary key IDENTITY(1,1) not null,
	MaChuyenDe Nchar(5) not null,
	HocPhi float not null,
	ThoiLuong int not null,
	NgayKhaiGiang date not null,
	Ghichu Nvarchar(50) not null
)
CREATE TABLE NhanVien(
	MaNhanVien Nvarchar(50) primary key not null,
	MatKhau Nvarchar(50) not null,
	Hoten Nvarchar(50) not null,
	VaiTro bit not null
)
--------------------------------------------------------------------------------

--Khóa ngoại liên kết khóa học và Chuyên đề
alter table KhoaHoc add constraint fk_KhoaHoc_MaChuyenDe
foreign key (MaChuyenDe) references ChuyenDe(MaChuyenDe) 
go
--Khóa ngoại liên kết Học Viên và khóa học
alter table HocVien add constraint fk_HocVien_Khoahoc
foreign key (MaKhoahoc) references KhoaHoc(MaKhoahoc) on update cascade
--Thêm cột mã nhân viên vào bảng khóa học
ALTER TABLE KhoaHoc
 ADD MaNhanVien Nvarchar(50);
-- Thêm cột ngày tạo trong bảng khóa học
ALTER TABLE KhoaHoc
ADD NgayTao date not null;
--Khóa ngoại liên kết Khóa Học Và Nhân Viên
alter table KhoaHoc add constraint fk_KhoaHoc_MaNhanVien
foreign key (MaNhanVien) references NhanVien(MaNhanVien)
--Khóa ngoại liên kết học viên và người học
alter table HocVien add constraint fk_HocVien_MaNguoiHoc
foreign key (MaNguoiHoc) references NguoiHoc(MaNguoiHoc) on update cascade
--khóa ngoại liên kết người học với Nhân viên
alter table NguoiHoc add constraint fk_NguoiHoc_NhanVien
foreign key (MaNhanVien) references NhanVien(MaNhanVien) on update cascade

alter table NhanVien add  VaiTro bit not null
--------------------------------------------------------------------------------------------

--[NHÂN VIÊN]
--truy vấn xem thêm xóa sửa cho bảng Nhân Viên

--Thêm nhân viên
insert into NhanVien(MaNhanVien, MatKhau, Hoten, VaiTro)
			values(N'NoPT',N'123456', N'Phạm Thị Nở', 0),
				  (N'KienPB',N'123456', N'Phạm Bá Kiến', 0),
				  (N'PheoPV',N'123456', N'Phạm Văn Phèo', 1);

--xóa theo mã
DELETE NhanVien where MaNhanVien = N'NoPT';
--cập nhật theo mã
UPDATE NhanVien set MatKhau = N'123456', Hoten = N'Phạm Văn Phèo', VaiTro = N'Nhân Viên' WHERE MaNhanVien = N'PheoPV';
--truy vấn tất cả và truy vấn theo mã 
select * from NhanVien
select * from NhanVien where MaNhanVien = 'KienPB'
--[NHÂN VIÊN]

--------------------------------------------------------------------------------------------

--[CHUYÊN ĐỀ]
--Thêm Chuyên đề
insert into ChuyenDe(MaChuyenDe, tenChuyenDe, HocPhi, ThoiLuong, Hinh, Mota)
			values(N'JAVA1', N'Lập Trình java', 300, 90, N'GAME.png', N'Lập trình mạng với java'),
				  (N'JAVA2', N'Lập Trình java nâng cao', 300, 90, N'HTCS.jpg', N'Java 2 java nâng cao'),
				  (N'JAVA3', N'Lập Trình mạng với java', 200, 70, N'INMAjpg', N'Lập trình mạng với java')
--Xóa chuyên đề 
DELETE ChuyenDe WHERE MaChuyenDe= N'JAVA1';
--Cập nhật theo mã
UPDATE ChuyenDe set tenChuyenDe = N'JAVA7', tenChuyenDe = N'Lập trình java7', HocPhi = 250, ThoiLuong = 70, Hinh = N'GAME.PNG', Mota = N'Lập trình java servlet';
--truy vấn tất cả và truy vấn theo mã
select * from ChuyenDe
select * from ChuyenDe where MaChuyenDe = N'JAVA1';
--[CHUYÊN ĐỀ]

--------------------------------------------------------------------------------------------

--[NGƯỜI HỌC]
--Thêm người học 
insert into NguoiHoc(MaNguoiHoc, HoTen, NgaySinh, GioiTinh, DienThoai, Email, MaNhanVien, NgayDangKi)
			values(N'PS01638', N'Lữ Huy Cường', '1991/08/05', 1, N'0123456789', N'cuonglh@fpt.edu.vn', N'PheoPV', '2015/05/02'),
				  (N'PS02771', N'Nguyễn Tấn Hiếu', '1998/09/15', 1, N'01478523', N'hieunt@fpt.edu.vn', N'PheoPV', '2016/09/15'),
				  (N'PS02791', N'Đỗ Văn Minh', '1997/10/24', 1, N'054789261', N'minhdv@fpt.edu.vn',  N'PheoPV', '2015/07/17'),
				  (N'PS02867', N'Nguyễn Hữu Trí', '1997/10/27', 1, N'04578524', N'trinh@fpt.edu.vn',  N'KienPB', '2017/07/07')
--Xóa người học
DELETE NguoiHoc where MaNguoiHoc = N'PS01638'
--Cập nhật theo mã
UPDATE NguoiHoc set HoTen = N'Nguyễn Hữu Trí', NgaySinh = '1997/10/27', GioiTinh = 1, DienThoai = '2225557742',Email = N'cuonglh@fpt.edu.vn', MaNhanVien =  N'KienPB', NgayDangKi = '2015/05/02';
--truy vấn tất cả và truy vấn theo mã
select * from NguoiHoc
select * from NguoiHoc where MaNguoiHoc = N'PS01638'
--[NGƯỜI HỌC]

--------------------------------------------------------------------------------------------

--[KHÓA HỌC]
--Thêm khóa học
insert into KhoaHoc(MaChuyenDe, HocPhi, ThoiLuong, NgayKhaiGiang, Ghichu, MaNhanVien, NgayTao)
		values(N'JAVA1', 300, 90, '2018/01/10', N'Null', N'PheoPV', '2017/12/31'),
			  (N'JAVA2', 300, 90, '2018/01/12', N'Null', N'PheoPV', '2017/12/31'),
			  (N'JAVA3', 200, 70, '2018/01/10', N'Null', N'NoPT', '2017/12/31')
--Xóa khóa học
delete KhoaHoc where MaKhoahoc = 3;
--Cập nhật Khóa học 
UPDATE KhoaHoc SET  MaChuyenDe = N'JAVA1', HocPhi = 250, ThoiLuong = 80, NgayKhaiGiang = '2018/01/10', Ghichu = N'Null', MaNhanVien = 'NoPT', NgayTao = '2017/12/31';
--Truy vấn tất cả và truy vấn theo mã
select * from KhoaHoc;
select * from KhoaHoc where MaKhoahoc = 2
--[KHÓA HỌC]

--------------------------------------------------------------------------------------------

--[HỌC VIÊN]
--Thêm học viên
insert into HocVien(MaKhoahoc, MaNguoiHoc, DiemTrungBinh)
			values(1, N'PS01638', 9),
				  (2, N'PS02791', 8.5),
				  (3, N'PS02867', 9)
--Xóa học viên
delete HocVien where Mahocvien = 7;
--Cập nhật học viên
UPDATE HocVien set MaKhoahoc = 1, MaNguoiHoc = N'PS01638',DiemTrungBinh = 8.5;
--Truy vấn tất cả và truy vấn theo mã
select * from HocVien;
select * from HocVien where Mahocvien = 9;
--[HỌC VIÊN]

--------------------------------------------------------------------------------------------

--Thủ tục lưu tổng hợp thống kê

--Số người học theo từng năm
GO
CREATE PROC sp_ThongKeNguoiHoc
AS BEGIN
	SELECT 
		YEAR(NgayDangKi) Nam,
		COUNT(*) SoLuong,
		MIN(NgayDangKi) DauTien,
		MAX(NgayDangKi) CuoiCung
		FROM NguoiHoc
		GROUP BY YEAR(NgayDangKi)
END

--Doanh thu theo chuyên đề
GO
CREATE PROC sp_ThongKeDoanhThu(@year int)
AS BEGIN
	SELECT 
		tenChuyenDe ChuyenDe,
		COUNT(DISTINCT kh.MaKhoaHoc) SoKH,
		COUNT(hv.Mahocvien) SoHV,
		SUM(KH.HocPhi) DoanhThu,
		MIN(kh.HocPhi) ThapNhat,
		MAX(KH.HocPhi) CaoNhat,
		AVG(KH.HocPhi) TrungBinh
	FROM KhoaHoc kh
		JOIN HocVien hv ON kh.MaKhoahoc=hv.MaKhoahoc
		JOIN ChuyenDe cd ON cd.MaChuyenDe = kh.MaChuyenDe
	WHERE YEAR(NgayKhaiGiang) = @year
	GROUP BY tenChuyenDe
END

--Bảng điểm
GO
CREATE PROC sp_BangDiem(@MaKH int)
AS BEGIN
	SELECT
		nh.MaNguoiHoc,
		nh.HoTen,
		hv.DiemTrungBinh
	FROM HocVien HV
		JOIN NguoiHoc NH ON nh.MaNguoiHoc = hv.MaNguoiHoc
		Where hv.MaKhoahoc = @MaKH
		ORDER BY hv.DiemTrungBinh DESC
END

--THỦ TỤC
--GO
--create proc sp_themChuyenDe
--(
--	@MaChuyenDe nchar(5) NULL,
--	@tenChuyenDe nvarchar(50) NULL,
--	@HocPhi float NULL,
--	@ThoiLuong int NULL,
--	@Hinh nvarchar(50) NULL,
--	@Mota nvarchar(225) NULL
--)
--as	
--	BEGIN TRY
--		IF(@MaChuyenDe IS NULL OR @tenChuyenDe IS NULL OR @HocPhi IS NULL OR @ThoiLuong IS NULL OR @Hinh IS NULL OR @Mota IS NULL)
--			GOTO KETTHUC;
--		ELSE
--		BEGIN TRAN
--			INSERT INTO ChuyenDe(MaChuyenDe, tenChuyenDe, HocPhi, ThoiLuong, Hinh, Mota)
--			VALUES(@MaChuyenDe, @tenChuyenDe, @HocPhi, @ThoiLuong, @Hinh, @Mota);
--		COMMIT TRAN;
--			KETTHUC:
--	END TRY
--	BEGIN CATCH
--	ROLLBACK
--	TRAN
--	END CATCH
SELECT * FROM NhanVien