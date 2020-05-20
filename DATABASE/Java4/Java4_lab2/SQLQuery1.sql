use QLDienThoai
create table CUSTOMER(
	id int primary key identity not null,
	TenThueBao Nvarchar(50) null,
	SoDT Nvarchar(50) null,
	DiaChi Nvarchar(50) null
)

insert CUSTOMER(TenThueBao, SoDT, DiaChi)
		values(N'Lê văn phụng', N'01683314129', N'311 nơ trang long'),
			  (N'Nguyễn Thị Tường Vy', N'0903936117', N'Ninh Thuận'),
			  (N'Lê Quang Trung', N'0903782999', N'Phan Rang'),
			  (N'Lê Thị Hồng Hạnh', N'0167788889', N'Quận 12')
select * from CUSTOMER