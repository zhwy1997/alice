/*
Source Host           : localhost:3306
Source Database       : second-hand_platform
*/
/*
DROP secondhand_platform IF EXISTS secondhand_platform
CREATE DATABASE second-hand_platform
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_chinese_ci;
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `level`
-- ----------------------------

DROP TABLE IF EXISTS `level`;
CREATE TABLE level (
	id int not null AUTO_INCREMENT,
    lvname varchar(50),
    discount double,
    uplevel int,
    PRIMARY KEY (id)
  ) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
  
  -- ----------------------------
-- Table structure for `MyUsr`
-- ----------------------------
DROP TABLE IF EXISTS `MyUsr`;
CREATE TABLE MyUsr (
  uid int not null AUTO_INCREMENT,
  uAccount varchar(50) UNIQUE,
  password varchar(100),
 -- uType ENUM('系统管理员','普通用户') default '普通用户',-- 默认为普通用户
  uName varchar(10),
  consumption double default 0, -- 消费总额
  balance     double default 0,  -- 账户余额
  phoneNumber varchar(20),
  ulevel int default 1, -- 默认一般
  city varchar(10),
  regTime datetime,
  modifyTime datetime default NULL,
  PRIMARY KEY (uid),
  constraint lv foreign key (ulevel) references level(id) on delete cascade
  ) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 触发器锁定时间设置修改时间
CREATE TRIGGER modifyTimeOfUsrChanged before update ON MyUsr
FOR EACH Row  set new.modifyTime=now(),new.regTime=old.regTime;

-- 触发器设置创建时间
CREATE TRIGGER regTimeOfUsr before insert ON MyUsr
FOR EACH Row set new.regTime=now(),new.modifyTime=now();

-- ----------------------------
-- Table structure for `adminUsr`
-- ----------------------------
DROP TABLE IF EXISTS `adminUsr`;
CREATE TABLE adminUsr (
  uid int not null AUTO_INCREMENT,
  uAccount varchar(50) UNIQUE,
  password varchar(100),
  PRIMARY KEY (uid)
  ) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- ----------------------------
-- Table structure for `SellGoods`
-- ----------------------------
DROP TABLE IF EXISTS `SellGoods`;

CREATE TABLE SellGoods (
  gid int not null auto_increment,
  belongUsr int,
  buyUsr int, -- 当前在竞拍或购买此商品的用户
  goodType enum('电子类','日常用品类','书籍类') default null,
  goodName varchar(30),
  minPrice double default 0,
  fixedPrice int default 0 , -- 是否一口价
  endAuctionTime DATETIME, 
  goodDescription varchar(400),
  goodIMG varchar(100) default 'default.jpg',
  createTime datetime,
  modifyTime datetime,
  sellState enum('已售','待售','竞价中') default '待售',
   PRIMARY KEY (gid),
   constraint sellBelong foreign key (belongUsr) references MyUsr(uid) on delete cascade,
   constraint buyUsrBelong foreign key (belongUsr) references MyUsr(uid) on delete cascade
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 触发器锁定注册时间并设置修改时间
CREATE TRIGGER modifyTimeNoChangedofSellGoods before update ON SellGoods
FOR EACH Row  set new.createTime=old.createTime,new.modifyTime=now();

  -- 触发器设置创建时间
CREATE TRIGGER createTimeOfSellGoods before insert ON SellGoods
FOR EACH Row set new.createTime=now(),new.modifyTime=now();

-- ----------------------------
-- Table structure for `BuyGoods`
-- ----------------------------
DROP TABLE IF EXISTS `BuyGoods`;
CREATE TABLE BuyGoods (
  gid int,
  belongUsr int,
  goodType enum('电子类','日常用品类','书籍类') default null,
  goodName varchar(30),
  minPrice double default 0,
  maxPrice double default 0,
  goodDescription varchar(400),
  goodIMG varchar(100) default 'default.jpg',
  createTime datetime,
  modifyTime datetime,
  sellState enum('已购','待购'),
   PRIMARY KEY (gid),
   constraint BuyBelong foreign key (belongUsr) references MyUsr(uid) on delete cascade
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
 
 -- 触发器锁定注册时间并设置修改时间
CREATE TRIGGER modifyTimeNoChangedofBuyGoods before update ON BuyGoods
FOR EACH Row set new.createTime=old.createTime,new.modifyTime=now();

  -- 触发器设置创建时间
CREATE TRIGGER createTimeOfBuyGoods before insert ON BuyGoods
FOR EACH Row set new.createTime=now(),new.modifyTime=now();

-- ----------------------------
-- Table structure for `DealTable`
-- ----------------------------
DROP TABLE IF EXISTS `DealTable`;
create table DealTable (
	gid int not null,
	sellUsr int not null,
	buyUsr  int not null,
	dealTime datetime,
	dealPrice double,
	buyAgencyFee double,
	sellAgencyFee double,
    primary key (gid),
    constraint sellBelongInDeal foreign key (sellUsr) references MyUsr(uid) on delete cascade,
    constraint buyBelongInDeal  foreign key (buyUsr) references MyUsr(uid) on delete cascade,
    constraint gidBelongInDeal  foreign key (gid) references sellgoods(gid) on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
-- 触发器计算中介费且设置创建时间
CREATE TRIGGER agencyFee before INSERT ON DealTable 
FOR EACH Row 
set new.buyAgencyFee=new.dealPrice*0.02*(select discount from myusr,level where id=ulevel and uid=new.buyUsr),
new.sellAgencyFee=new.dealPrice*0.01*(select discount from myusr,level where id=ulevel and uid=new.sellUsr),
new.dealTime=now();
-- 触发器锁定时间
CREATE TRIGGER dealTimeNoChanged before update ON DealTable 
FOR EACH Row set new.dealTime=old.dealtime;

-- ----------------------------
-- Table structure for `agencyTable`
-- ----------------------------
DROP TABLE IF EXISTS `agencyTable`;
create table agencyTable (
	dealDay date,
	city varchar(50),
	goodType enum('电子类','日常用品类','书籍类') default null,
	amount int default 1,
	income double default 0,
    primary key (dealDay,city,goodType)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


/*

	insert test records

*/
-- ----------------------------
-- Records of myusr
-- ----------------------------

