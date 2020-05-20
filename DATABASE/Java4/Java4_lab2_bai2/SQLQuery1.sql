 Create table Products(
	Code varchar(50) primary key not null,
	Name varchar(100) null,
	Price float null
 );

 insert into Products(Code, Name, Price)
			values('SP001', 'Nokia110', 50),
				  ('SP002', 'SONY', 500),
				  ('SP003', 'IPHONE', 700)