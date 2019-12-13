insert into level (lvname,discount,uplevel) 
values ("一般",1.0,0);

insert into level (lvname,discount,uplevel) 
values ("重要",0.8,5000);

insert into level (lvname,discount,uplevel) 
values ("钻石",0.5,20000);


insert into MyUsr (uAccount,password,uName,phoneNumber) 
values ("testUsr1","alice","张三","13507777777");

insert into MyUsr (uAccount,password,uName,phoneNumber) 
values ("testUsr2","alice","李四","13507777777");

insert into MyUsr (uAccount,password,uName,phoneNumber) 
values ("testUsr3","alice","王五","13507777777");

insert into MyUsr (uAccount,password,uName,phoneNumber,consumption,ulevel) 
values ("testUsr4","alice","赵六","13507777777",100000,3);


insert into adminUsr(uAccount,password)
	values ("admin1","root");
    
insert into adminUsr(uAccount,password)
	values ("admin2","root");

insert into SellGoods (belongUsr,goodType,goodName,minPrice,fixedPrice,goodDescription) 
	values(1,"电子类","一号电子商品",0,0,"一件可爱的商品");
insert into SellGoods (belongUsr,goodType,goodName,minPrice,fixedPrice,goodDescription) 
	values(1,"电子类","二号电子商品",1,0,"一件美丽的商品");
insert into SellGoods (belongUsr,goodType,goodName,minPrice,fixedPrice,goodDescription) 
	values(1,"日常用品类","一号日常用品",0,0,"一件精致的商品");