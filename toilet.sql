/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.5.28 : Database - toilet
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`toilet` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `toilet`;

/*Table structure for table `cleaner` */

DROP TABLE IF EXISTS `cleaner`;

CREATE TABLE `cleaner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `company` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `cleaner` */

insert  into `cleaner`(`id`,`name`,`phone`,`company`) values (1,'喜羊羊','0000011','保洁公司1号'),(2,'美羊羊','0000022','保洁公司1号'),(3,'慢羊羊','00001233','保洁公司33号'),(4,'沸羊羊','0045441','保洁公司5号'),(5,'猪羊羊','007842','保洁公司7号'),(6,'懒羊羊','0078452','保洁公司8号'),(7,'灰太狼','0487421','保洁公司10号'),(8,'小灰灰','4548411','保洁公司85号'),(9,'测试清洁员','123456','未知保洁公司');

/*Table structure for table `floor` */

DROP TABLE IF EXISTS `floor`;

CREATE TABLE `floor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT '未知楼层',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `floor` */

insert  into `floor`(`id`,`name`) values (1,'2B楼3层'),(2,'3C楼7层'),(3,'7D楼22层'),(4,'T楼5层'),(5,'T楼6层'),(6,'T楼7层');

/*Table structure for table `position` */

DROP TABLE IF EXISTS `position`;

CREATE TABLE `position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isUsing` tinyint(1) NOT NULL DEFAULT '0',
  `isServing` tinyint(1) DEFAULT '0',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `type` varchar(20) DEFAULT 'squat' COMMENT 'seat/squat',
  `toiletid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `position` */

insert  into `position`(`id`,`isUsing`,`isServing`,`start_time`,`type`,`toiletid`) values (1,1,1,'2018-12-29 18:01:46','squat',3),(2,1,1,'2018-12-29 18:05:49','seat',3),(3,1,1,'2018-12-29 14:09:05','squat',3),(4,1,1,'2018-12-29 16:27:35','squat',4),(5,0,1,'2018-12-26 08:27:32','squat',4),(6,0,1,'2018-12-26 08:27:38','squat',4),(7,1,1,'2018-12-29 08:27:40','squat',4),(8,0,1,'2018-12-25 10:45:04','squat',6),(9,0,0,'2018-12-25 10:44:20','squat',6),(10,0,1,'2018-12-26 10:33:07','squat',3),(11,0,0,'2018-12-25 10:44:25','squat',6),(12,0,1,'2018-12-25 23:48:31','squat',1),(13,0,1,'2018-12-29 17:58:34','squat',1),(14,1,1,'2018-12-29 18:08:26','squat',1),(15,0,1,'2018-12-25 23:48:41','squat',1),(16,0,1,'2018-12-26 08:56:10','squat',3),(17,0,1,'2018-12-26 10:27:56','squat',3),(18,0,1,'2018-12-26 08:27:25','squat',7),(19,0,1,'2018-12-26 08:56:18','squat',7),(20,0,0,'2018-12-25 10:44:42','squat',7),(21,0,1,'2018-12-26 08:27:22','squat',1),(22,0,1,'2018-12-26 08:27:18','squat',1),(23,1,1,'2018-12-29 10:44:22','squat',3);

/*Table structure for table `toilet` */

DROP TABLE IF EXISTS `toilet`;

CREATE TABLE `toilet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT '未知厕所',
  `type` int(1) DEFAULT '2',
  `cleanerid` int(11) DEFAULT NULL,
  `last_cleaned_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `next_clean_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `isService` tinyint(1) DEFAULT '1',
  `floorid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `toilet` */

insert  into `toilet`(`id`,`name`,`type`,`cleanerid`,`last_cleaned_time`,`next_clean_time`,`isService`,`floorid`) values (1,'茶水间厕所',2,4,'2018-12-25 10:36:39','2018-12-22 13:26:01',1,1),(2,'办公室厕所',2,3,'2018-12-25 10:36:26','2018-12-19 13:26:06',0,2),(3,'办公室B厕所',3,1,'2018-12-26 08:28:41','2018-12-26 13:26:09',1,1),(4,'好看的厕所',2,5,'2018-12-25 10:36:18','2018-12-21 13:26:12',1,1),(5,'B2厕所',2,6,'2018-12-15 13:27:12','2018-12-17 13:26:15',1,2),(6,'香香的厕所',2,7,'2018-12-15 13:27:15','2019-01-02 13:26:19',1,1),(7,'男生厕所',1,8,'2018-12-25 20:23:51','2019-02-01 13:26:23',1,2),(8,'女生厕所',0,9,'2018-12-15 13:27:24','2019-05-23 13:26:27',1,2);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '未知用户',
  `phone` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `avatar` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`phone`,`password`,`avatar`) values (1,' 司马懿','111','111',NULL),(2,'孙权','222','222',NULL),(3,'刘勋','333','333',NULL),(4,'周瑜','444','444',NULL),(5,'庞统','555','555',NULL),(6,'夏侯尚','666','666',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
