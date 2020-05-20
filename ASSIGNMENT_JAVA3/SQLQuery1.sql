USE ASSIGNMENT_JAVA

--Tạo bảng Student

CREATE TABLE STUDENT(
	MASV NVARCHAR(50) PRIMARY KEY NOT NULL,
	Hoten NVARCHAR(50) NULL,
	Email NVARCHAR(50) NULL,
	SoDT int NULL,
	Gioitinh bit null,
	Diachi NVARCHAR(50) NULL,
	Hinh NVARCHAR(50) NULL
);

--Tạo bảng GRADE

CREATE TABLE GRADE(
	ID INT PRIMARY KEY NOT NULL,
	MASV NVARCHAR(50) NULL,
	Tienganh float null,
	Tinhoc float null,
	GDTC float null 
);

ALTER TABLE GRADE 
ADD CONSTRAINT fk_MASV
	FOREIGN KEY (MASV) REFERENCES STUDENT(MASV)
--Tạo bảng USER

CREATE TABLE USERS(
	username NVARCHAR(50) PRIMARY KEY NOT NULL,
	pass NVARCHAR(50) NULL,
	role NVARCHAR(50)NULL
	)

--Thêm vào bảng STUDENT
select * from STUDENT 
INSERT INTO STUDENT(MASV, Hoten, Email, SoDT, Gioitinh, Diachi, Hinh)
	VALUES(N'001', N'Nguyễn Văn X', N'x@gmail.com',0123456789, 1, N'145 bàu cát 2', N'hoa.png')
INSERT INTO STUDENT(MASV, Hoten, Email, SoDT, Gioitinh, Diachi, Hinh)
	VALUES(N'002', N'Nguyễn Thị Y', N'Y@gmail.com',0798542169, 0, N'45b điện biên phủ', N'right.png')
INSERT INTO STUDENT(MASV, Hoten, Email, SoDT, Gioitinh, Diachi, Hinh)
	VALUES(N'003', N'Nguyễn Văn Z', N'Z@gmail.com',0798546549, 1, N'47b điện biên phủ', N'right.png')

--Thêm vào bảng GRADE
select * from GRADE
SET IDENTITY_INSERT GRADE ON
INSERT INTO GRADE(ID, MASV, Tienganh, Tinhoc, GDTC)
VALUES(3 , '003', 8, 8, 8)

--Thêm vào bảng USER
select * from USERS
INSERT INTO USERS(username, pass, role)
		VALUES(N'as', N'123', N'lec'),
			  (N'asa', N'321', N'staff')

