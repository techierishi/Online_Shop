-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 27, 2017 at 03:26 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ecommdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `AdminId` int(11) NOT NULL AUTO_INCREMENT,
  `AdminName` varchar(45) NOT NULL,
  `AdminEmail` varchar(45) NOT NULL,
  `AdminPhone` varchar(45) NOT NULL,
  `AdminPassword` varchar(45) NOT NULL,
  PRIMARY KEY (`AdminId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AdminId`, `AdminName`, `AdminEmail`, `AdminPhone`, `AdminPassword`) VALUES
(1, 'rishikesh', 'rishikesh@gmail.com', '987654323', 'Password1');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE IF NOT EXISTS `cart` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pid` int(10) NOT NULL,
  `uid` int(10) NOT NULL,
  `quantity` int(10) NOT NULL,
  `productName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`id`, `pid`, `uid`, `quantity`, `productName`) VALUES
(5, 5, 1, 1, '0');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `categoryName` varchar(45) NOT NULL,
  `categoryDetails` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`categoryName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`categoryName`, `categoryDetails`) VALUES
('Bangles', 'Good bangles'),
('Necklace', 'Good necklaces'),
('Pendent', 'Pendent Category'),
('Ring', 'Awesome rings');

-- --------------------------------------------------------

--
-- Table structure for table `complaint`
--

CREATE TABLE IF NOT EXISTS `complaint` (
  `complaintId` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` varchar(45) NOT NULL,
  `complaintDetail` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`complaintId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(45) NOT NULL,
  `customerPhone` int(11) DEFAULT NULL,
  `customerEmail` varchar(45) NOT NULL,
  `customerAddress` varchar(45) NOT NULL,
  `customerState` varchar(45) DEFAULT NULL,
  `customerCity` varchar(45) NOT NULL,
  `customerZip` int(11) NOT NULL,
  `customerPassword` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customerId`),
  UNIQUE KEY `customerEmail_UNIQUE` (`customerEmail`),
  UNIQUE KEY `customerPhone_UNIQUE` (`customerPhone`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerId`, `customerName`, `customerPhone`, `customerEmail`, `customerAddress`, `customerState`, `customerCity`, `customerZip`, `customerPassword`) VALUES
(1, 'Rishi', 2147483647, 'techierishi@gmail.com', 'unm', 'wb', 'kol', 576876, 'password');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE IF NOT EXISTS `order` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `paymentId` int(11) NOT NULL,
  `customerId` int(11) NOT NULL,
  `orderStatus` varchar(45) NOT NULL,
  `shipmentId` int(11) NOT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE IF NOT EXISTS `payment` (
  `paymentId` int(11) NOT NULL AUTO_INCREMENT,
  `paymentDetail` varchar(45) NOT NULL,
  `customerId` int(11) NOT NULL,
  `paymentMode` varchar(45) NOT NULL,
  `cardType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`paymentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(45) NOT NULL,
  `categoryName` varchar(45) NOT NULL,
  `productAvailability` varchar(45) DEFAULT NULL,
  `productQuantity` int(11) DEFAULT '0',
  `productPrice` int(11) DEFAULT NULL,
  `supplierId` int(11) DEFAULT NULL,
  `productDetails` text NOT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productId`, `productName`, `categoryName`, `productAvailability`, `productQuantity`, `productPrice`, `supplierId`, `productDetails`) VALUES
(5, 'Rani Har', 'Necklace', 'Available', 40, 45000, 0, 'null'),
(6, 'China Har', 'Necklace', 'Available', 30, 60000, 0, 'null'),
(7, 'Rani Har2', 'Necklace', 'Available', 40, 45000, 0, 'null'),
(8, 'Kar Har', 'Necklace', 'Available', 40, 560000, 0, 'null');

-- --------------------------------------------------------

--
-- Table structure for table `product_image`
--

CREATE TABLE IF NOT EXISTS `product_image` (
  `imageId` int(11) NOT NULL AUTO_INCREMENT,
  `pId` int(11) NOT NULL,
  `imageName` varchar(255) NOT NULL,
  PRIMARY KEY (`imageId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `product_image`
--

INSERT INTO `product_image` (`imageId`, `pId`, `imageName`) VALUES
(7, 5, '6854ac9b-22b8-474e-bf8c-696a907594521.jpg'),
(8, 5, 'f481d7de-3289-45c1-b011-527d2e8a3d8e1-.jpg'),
(9, 6, '576acc80-19c6-445a-8afd-d1c3976677cf5-.jpg'),
(10, 6, 'e468550c-b91f-4116-b9d6-e53a33c5d1342.jpg'),
(11, 7, '1b3a57f1-70d4-4c7a-92ba-9d2cb42125e51.jpg'),
(12, 7, '6554ce43-1748-48fd-906c-555764043cb52-.jpg'),
(13, 7, '021ddfbc-58e2-4ad1-91a3-9e946dabbfb21.jpg'),
(14, 8, '48f3e225-637e-4f82-8980-b51a7fadf7963.jpg'),
(15, 8, '83f167f1-dc8f-4a9b-a7bd-dffbc2f337fe4.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `shipment`
--

CREATE TABLE IF NOT EXISTS `shipment` (
  `shipmentId` int(11) NOT NULL AUTO_INCREMENT,
  `shipmentAddress` varchar(45) NOT NULL,
  `shipmentType` varchar(45) NOT NULL,
  `shippedDate` datetime NOT NULL,
  PRIMARY KEY (`shipmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
  `supplierId` int(11) NOT NULL AUTO_INCREMENT,
  `supplierName` varchar(45) NOT NULL,
  `supplierAddress` varchar(45) NOT NULL,
  `supplierPhone` int(11) NOT NULL,
  `supplierEmail` varchar(45) NOT NULL,
  PRIMARY KEY (`supplierId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
