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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `position` */

insert  into `position`(`id`,`isUsing`,`isServing`,`start_time`,`type`,`toiletid`) values (1,1,0,'2018-12-15 13:15:20','squat',3),(2,0,0,'2018-12-15 13:15:37','seat',4),(3,0,0,'2018-12-15 13:15:46','squat',4),(4,1,0,'2018-12-15 13:16:58','squat',4),(5,0,0,'2018-12-15 13:15:51','squat',4),(6,0,0,'2018-12-15 13:15:55','squat',4),(7,1,0,'2018-11-01 13:17:09','squat',4),(8,0,0,'2018-12-15 13:16:45','squat',5),(9,0,0,'2018-12-15 13:16:47','squat',5),(10,0,0,'2018-12-15 13:16:49','squat',5),(11,0,0,'2018-12-15 13:16:53','squat',5);

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

insert  into `toilet`(`id`,`name`,`type`,`cleanerid`,`last_cleaned_time`,`next_clean_time`,`isService`,`floorid`) values (1,'茶水间厕所',2,4,'2018-12-15 13:27:02','2018-12-22 13:26:01',1,6),(2,'办公室厕所',2,3,'2018-12-15 13:27:04','2018-12-19 13:26:06',0,5),(3,'残疾人厕所',3,1,'2018-12-15 13:27:06','2018-12-26 13:26:09',1,4),(4,'好看的厕所',2,5,'2018-12-15 13:27:08','2018-12-21 13:26:12',1,3),(5,'B2厕所',2,6,'2018-12-15 13:27:12','2018-12-17 13:26:15',1,2),(6,'香香的厕所',2,7,'2018-12-15 13:27:15','2019-01-02 13:26:19',1,1),(7,'男生厕所',1,8,'2018-12-15 13:27:18','2019-02-01 13:26:23',1,1),(8,'女生厕所',0,9,'2018-12-15 13:27:24','2019-05-23 13:26:27',1,2);

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
