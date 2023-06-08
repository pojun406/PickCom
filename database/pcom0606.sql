/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `pcom` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci */;
USE `pcom`;

CREATE TABLE IF NOT EXISTS `address` (
  `address_num` int(10) NOT NULL AUTO_INCREMENT,
  `member_num` int(11) NOT NULL DEFAULT 0,
  `address_postalCode` varchar(20) NOT NULL DEFAULT '0',
  `address_basicAddress` varchar(50) NOT NULL DEFAULT '0',
  `address_detailedAddress` varchar(50) NOT NULL DEFAULT '0',
  `address_country` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`address_num`),
  KEY `user_id_address` (`member_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;


CREATE TABLE IF NOT EXISTS `board` (
  `board_num` int(11) NOT NULL AUTO_INCREMENT,
  `member_num` int(11) NOT NULL DEFAULT 0,
  `board_title` varchar(50) NOT NULL,
  `board_content` text DEFAULT NULL,
  `board_createdDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `board_updatedDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `board_type` varchar(10) NOT NULL,
  `board_class` varchar(20) NOT NULL,
  `board_stat` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`board_num`) USING BTREE,
  KEY `user_id_post` (`member_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;


CREATE TABLE IF NOT EXISTS `cart` (
  `cart_num` int(11) NOT NULL AUTO_INCREMENT,
  `member_num` varchar(16) NOT NULL,
  `product_num` int(11) NOT NULL,
  `cart_quantity` int(11) NOT NULL,
  `cart_regDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`cart_num`),
  KEY `product_num` (`product_num`),
  KEY `user_id_cart` (`member_num`) USING BTREE,
  CONSTRAINT `cart_product_num` FOREIGN KEY (`product_num`) REFERENCES `product` (`product_num`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;


CREATE TABLE IF NOT EXISTS `comment` (
  `comment_num` int(11) NOT NULL,
  `board_num` int(11) NOT NULL,
  `comment_content` text NOT NULL,
  `comment_regDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `comment_updatedDate` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`comment_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;


CREATE TABLE IF NOT EXISTS `like` (
  `like_num` int(11) NOT NULL,
  `board_num` int(11) NOT NULL,
  `like_createdDate` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`like_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;


CREATE TABLE IF NOT EXISTS `manufacturer` (
  `manufacturer_name` varchar(50) NOT NULL,
  `phoneNumber` varchar(15) NOT NULL,
  `location` varchar(50) NOT NULL,
  `manager` varchar(20) NOT NULL,
  PRIMARY KEY (`manufacturer_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;


CREATE TABLE IF NOT EXISTS `member` (
  `member_num` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` varchar(16) NOT NULL,
  `member_name` varchar(10) NOT NULL,
  `member_nickName` varchar(10) NOT NULL,
  `member_passwd` varchar(18) NOT NULL,
  `member_email` varchar(30) NOT NULL,
  `member_rank` varchar(10) NOT NULL,
  `member_regDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `member_lastDate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `member_stat` tinyint(4) NOT NULL DEFAULT 0,
  `member_visitCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`member_num`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

INSERT INTO `member` (`member_num`, `member_id`, `member_name`, `member_nickName`, `member_passwd`, `member_email`, `member_rank`, `member_regDate`, `member_lastDate`, `member_stat`, `member_visitCount`) VALUES
	(1, 'honggile', '홍길동', '', 'abcd1234', 'abcd1234@naver.com', '일반', '2023-03-30 15:00:00', '2023-05-12 02:11:18', 1, NULL);

CREATE TABLE IF NOT EXISTS `orders` (
  `order_num` int(10) NOT NULL AUTO_INCREMENT,
  `member_num` int(11) NOT NULL DEFAULT 0,
  `order_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `order_total_amount` int(11) NOT NULL DEFAULT 0,
  `order_phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`order_num`),
  KEY `user_id_order` (`member_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;


CREATE TABLE IF NOT EXISTS `order_list` (
  `list_num` int(11) NOT NULL AUTO_INCREMENT,
  `order_num` int(11) NOT NULL,
  `product_num` int(11) NOT NULL,
  `list_quantity` int(11) NOT NULL,
  `list_price` int(11) NOT NULL,
  PRIMARY KEY (`list_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;


CREATE TABLE IF NOT EXISTS `payment` (
  `cardNumber` int(11) NOT NULL,
  `member_num` int(11) NOT NULL DEFAULT 0,
  `payMethod` varchar(20) NOT NULL,
  `pay_phone` varchar(20) NOT NULL,
  `payStatus` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`cardNumber`),
  KEY `user_id_payment` (`member_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;


CREATE TABLE IF NOT EXISTS `product` (
  `product_num` int(10) NOT NULL AUTO_INCREMENT,
  `manufacturer_name` varchar(50) NOT NULL DEFAULT '',
  `seller_num` int(11) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `product_salePrice` int(11) NOT NULL DEFAULT 0,
  `product_originalPrice` int(11) NOT NULL DEFAULT 0,
  `product_shippingFee` int(11) NOT NULL DEFAULT 0,
  `product_quantity` int(11) NOT NULL DEFAULT 0,
  `product_category1` varchar(20) NOT NULL,
  `product_category2` varchar(20) NOT NULL,
  `product_description` text DEFAULT NULL,
  `product_img` varchar(50) DEFAULT NULL,
  `product_soldOut` tinyint(4) NOT NULL,
  `product_sales` int(11) NOT NULL,
  `product_regDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `product_visitCount` int(11) NOT NULL DEFAULT 0,
  `product_stat` tinyint(4) NOT NULL,
  PRIMARY KEY (`product_num`),
  KEY `manufacturer_name_product` (`manufacturer_name`),
  CONSTRAINT `manufacturer_name_product` FOREIGN KEY (`manufacturer_name`) REFERENCES `manufacturer` (`manufacturer_name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;


CREATE TABLE IF NOT EXISTS `product_grade` (
  `grade_num` int(11) NOT NULL AUTO_INCREMENT,
  `product_num` int(11) NOT NULL,
  `member_num` int(11) NOT NULL,
  `grade_score` int(11) NOT NULL,
  `grade_stat` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`grade_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;


CREATE TABLE IF NOT EXISTS `product_review` (
  `review_num` int(11) NOT NULL AUTO_INCREMENT,
  `member_num` int(11) NOT NULL DEFAULT 0,
  `product_num` int(10) NOT NULL,
  `review_score` int(11) NOT NULL,
  `review_content` varchar(50) NOT NULL,
  `review_regDate` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`review_num`),
  KEY `review_product_num` (`product_num`),
  KEY `review_member_id` (`member_num`) USING BTREE,
  CONSTRAINT `review_product_num` FOREIGN KEY (`product_num`) REFERENCES `product` (`product_num`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;


CREATE TABLE IF NOT EXISTS `seller` (
  `seller_num` int(11) NOT NULL AUTO_INCREMENT,
  `seller_name` varchar(14) NOT NULL DEFAULT '',
  `seller_rank` varchar(10) NOT NULL DEFAULT '',
  `seller_phone` varchar(20) NOT NULL,
  `seller_email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`seller_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;


SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE DEFINER=`root`@`localhost` TRIGGER `update_sold_out` BEFORE UPDATE ON `product` FOR EACH ROW BEGIN
	IF NEW.product_quantity = 0 THEN
        SET NEW.product_soldOut = TRUE;
    ELSE
        SET NEW.product_soldOut = FALSE;
    END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
