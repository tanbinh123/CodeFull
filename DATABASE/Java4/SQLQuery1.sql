CREATE TABLE usertbl(
	id int primary key identity(1,1),
	username nvarchar(50) unique,
	password nvarchar(100),
	fullname nvarchar(50),
	phone nvarchar(10),
	email nvarchar(50) unique,
	role int default 0
);
