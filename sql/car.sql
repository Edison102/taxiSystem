/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17-log : Database - car
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`car` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `car`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

/*Table structure for table `dispatch_info` */

DROP TABLE IF EXISTS `dispatch_info`;

CREATE TABLE `dispatch_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `origin` varchar(50) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_location` varchar(50) DEFAULT NULL,
  `num_peo` int(11) DEFAULT NULL,
  `max_peo` int(11) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `is_over` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `dispatch_info_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `owner` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `dispatch_info` */

insert  into `dispatch_info`(`id`,`uid`,`origin`,`start_time`,`end_location`,`num_peo`,`max_peo`,`total_price`,`is_over`) values (1,6,'立信','2019-06-29 15:13:24','二工大',2,4,100,1),(2,6,'上海南站','2019-07-10 00:00:00','上海立信',2,4,120,1),(3,6,'北京','2019-08-19 00:00:00','南宁',0,5,1000,0);

/*Table structure for table `evaluation` */

DROP TABLE IF EXISTS `evaluation`;

CREATE TABLE `evaluation` (
  `uid` int(11) NOT NULL,
  `num_peo` int(11) DEFAULT NULL COMMENT '已评价人数',
  `score` double DEFAULT NULL COMMENT '得分',
  PRIMARY KEY (`uid`),
  CONSTRAINT `evaluation_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `owner` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `evaluation` */

insert  into `evaluation`(`uid`,`num_peo`,`score`) values (6,4,8.181999999999999);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `origin` varchar(50) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_location` varchar(50) DEFAULT NULL,
  `payment` float DEFAULT NULL,
  `is_pay` tinyint(1) DEFAULT NULL,
  `dis_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `dis_id` (`dis_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`dis_id`) REFERENCES `dispatch_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`id`,`uid`,`origin`,`start_time`,`end_location`,`payment`,`is_pay`,`dis_id`) values (1,6,'立信','2019-06-30 11:53:13','二工大',50,1,1),(2,1,'立信','2019-06-29 15:13:24','二工大',50,1,1),(3,6,'上海南站','2019-07-10 00:00:00','上海立信',60,0,2),(4,6,'上海南站','2019-07-10 00:00:00','上海立信',60,1,2);

/*Table structure for table `owner` */

DROP TABLE IF EXISTS `owner`;

CREATE TABLE `owner` (
  `uid` int(11) NOT NULL,
  `id_num` varchar(50) DEFAULT NULL COMMENT '身份证号',
  `lic_num` varchar(50) DEFAULT NULL COMMENT '车牌号',
  `model` varchar(50) DEFAULT NULL COMMENT '车型',
  `is_audit` tinyint(1) DEFAULT NULL COMMENT '是否审核',
  `is_pass` tinyint(1) DEFAULT NULL COMMENT '是否通过',
  PRIMARY KEY (`uid`),
  CONSTRAINT `owner_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `owner` */

insert  into `owner`(`uid`,`id_num`,`lic_num`,`model`,`is_audit`,`is_pass`) values (1,'34343454354','B77777','奔驰',1,0),(6,'44560434234','A88888','奥迪',1,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `isAdmin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uid`,`name`,`password`,`phone`,`isAdmin`) values (1,'Edison','123456','1854345465',0),(6,'小明','123456','1846832682',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
