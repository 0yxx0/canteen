create database canteen default character set utf8 collate utf8_bin;

#餐桌信息
DROP TABLE IF EXISTS `tableinfo`;
CREATE TABLE `tableinfo` (
  `tano` varchar(100) COLLATE utf8_bin NOT NULL,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  `size` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`tano`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

#购物车信息
DROP TABLE IF EXISTS `cartinfo`;
CREATE TABLE `cartinfo` (
  `cno` varchar(100) COLLATE utf8_bin NOT NULL,
  `mno` int(11) DEFAULT NULL,
  `fno` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`cno`),
  KEY `FK_cartInfo_mno` (`mno`),
  KEY `FK_cartInfo_fno` (`fno`),
  CONSTRAINT `FK_cartInfo_fno` FOREIGN KEY (`fno`) REFERENCES `foodsinfo` (`fno`),
  CONSTRAINT `FK_cartInfo_mno` FOREIGN KEY (`mno`) REFERENCES `memberinfo` (`mno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

#食品信息
DROP TABLE IF EXISTS `foodsinfo`;
CREATE TABLE `foodsinfo` (
  `fno` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) COLLATE utf8_bin NOT NULL,
  `tno` varchar(100) DEFAULT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  `intro` varchar(400) COLLATE utf8_bin DEFAULT NULL,
  `pics` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`fno`),
  KEY `FK_foodsInfo_tno` (`tno`),
  CONSTRAINT `FK_foodsInfo_tno` FOREIGN KEY (`tno`) REFERENCES `foodstype` (`tno`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

//食品类型
DROP TABLE IF EXISTS `foodstype`;
CREATE TABLE `foodstype` (
  `tno` varchar(100) NOT NULL,
  `tname` varchar(100) COLLATE utf8_bin NOT NULL,
  `pic` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

#管理员信息
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(100) COLLATE utf8_bin NOT NULL,
  `pwd` varchar(100) COLLATE utf8_bin NOT NULL,
  `tel` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`aid`),
  UNIQUE KEY `aname` (`aname`),
  UNIQUE KEY `tel` (`tel`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

#会员信息
DROP TABLE IF EXISTS `memberinfo`;
CREATE TABLE `memberinfo` (
  `mno` int(11) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(100) COLLATE utf8_bin NOT NULL,
  `realName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `pwd` varchar(100) COLLATE utf8_bin NOT NULL,
  `tel` varchar(15) COLLATE utf8_bin NOT NULL,
  `regDate` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`mno`),
  UNIQUE KEY `nickName` (`nickName`),
  UNIQUE KEY `tel` (`tel`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


#订单信息
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `ono` varchar(100) COLLATE utf8_bin NOT NULL,
  `odate` datetime DEFAULT NULL,  #开单时间
  `pdate` datetime DEFAULT NULL,  #付款时间
  `status` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `tano` varchar(100) COLLATE utf8_bin NOT NULL,
  `mno` int(11) NOT NULL,
  PRIMARY KEY (`ono`),
  KEY `FK_orderInfo_tano` (`tano`),
  CONSTRAINT `FK_orderInfo_tano` FOREIGN KEY (`tano`) REFERENCES `tableinfo` (`tano`),
  CONSTRAINT `FK_orderInfo_mno` FOREIGN KEY (`mno`) REFERENCES `memberinfo` (`mno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

#订单详情表
DROP TABLE IF EXISTS `orderiteminfo`;
CREATE TABLE `orderiteminfo` (
  `ino` int(11) NOT NULL AUTO_INCREMENT,
  `ono` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `fno` int(11) DEFAULT NULL,
  `nums` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `sales` int(11) DEFAULT NULL,
  PRIMARY KEY (`ino`),
  KEY `FK_orderItemInfo_fno` (`fno`),
  KEY `FK_orderItemInfo_ono` (`ono`),
  CONSTRAINT `FK_orderItemInfo_fno` FOREIGN KEY (`fno`) REFERENCES `foodsinfo` (`fno`),
  CONSTRAINT `FK_orderItemInfo_ono` FOREIGN KEY (`ono`) REFERENCES `orderinfo` (`ono`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;