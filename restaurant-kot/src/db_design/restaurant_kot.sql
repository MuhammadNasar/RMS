-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 04, 2018 at 12:48 ش
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restaurant_kot`
--

DELIMITER $$
--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `getCurrentDate` () RETURNS CHAR(10) CHARSET utf8 RETURN DATE_FORMAT(getCurrentDateTime() , '%Y-%m-%d')$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getCurrentDateTime` () RETURNS CHAR(19) CHARSET utf8 RETURN DATE_FORMAT(CONVERT_TZ (NOW( ) , @@session.time_zone ,
'+05:00' ) , '%Y-%m-%d %k:%i:%s')$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getCurrentTime` () RETURNS CHAR(8) CHARSET utf8 RETURN DATE_FORMAT(getCurrentDateTime() , '%k:%i:%s')$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `menu_items`
--

CREATE TABLE `menu_items` (
  `id` int(11) NOT NULL,
  `item_name` varchar(100) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menu_items`
--

INSERT INTO `menu_items` (`id`, `item_name`, `price`) VALUES
(1, 'Alu Bhujia', 70),
(2, 'Chk Tikka', 130),
(3, 'Daal Mash', 80),
(4, 'Mix Vegetable', 90),
(5, 'Chicken Handi (Half)', 250),
(6, 'Chicken Handi (Full)', 500),
(7, 'Qeema Mattar', 120),
(8, 'Haleem', 100),
(9, 'Pepsi', 25),
(10, 'Pepsi (1.5L)', 90),
(11, 'Seven Up Regular', 25),
(12, 'Seven Up (1.5L)', 90),
(13, 'Gajar Halwa', 60),
(14, 'Soji Halwa', 60),
(15, 'Kheer', 50),
(16, 'Tea', 20),
(17, 'Green Tea', 15),
(18, 'Naan', 10),
(19, 'Chappati', 10);

-- --------------------------------------------------------

--
-- Table structure for table `payment_methods`
--

CREATE TABLE `payment_methods` (
  `id` varchar(50) NOT NULL,
  `title` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payment_methods`
--

INSERT INTO `payment_methods` (`id`, `title`) VALUES
('CASH', 'Cash'),
('CHEQUE', 'Cheque'),
('CREDIT_CARD', 'Credit Card'),
('PENDING', 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_kot`
--

CREATE TABLE `restaurant_kot` (
  `id` int(11) NOT NULL,
  `table_id` int(11) NOT NULL,
  `total_amount_receivable` int(11) NOT NULL,
  `total_received_amount` int(11) NOT NULL,
  `discount_percentage` int(2) NOT NULL,
  `discount_amount` int(11) NOT NULL,
  `net_amount` int(11) NOT NULL,
  `is_transfered_to_pending_payments` int(1) NOT NULL DEFAULT '0',
  `is_pending_payment_closed` int(1) NOT NULL DEFAULT '0',
  `payment_method` varchar(50) NOT NULL,
  `bill_date_time` datetime DEFAULT NULL,
  `waiter_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restaurant_kot`
--

INSERT INTO `restaurant_kot` (`id`, `table_id`, `total_amount_receivable`, `total_received_amount`, `discount_percentage`, `discount_amount`, `net_amount`, `is_transfered_to_pending_payments`, `is_pending_payment_closed`, `payment_method`, `bill_date_time`, `waiter_id`) VALUES
(3, 5, 0, 0, 0, 0, 0, 0, 0, 'PENDING', NULL, 2),
(4, 8, 0, 0, 0, 0, 0, 0, 0, 'PENDING', NULL, 3);

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_kot_details`
--

CREATE TABLE `restaurant_kot_details` (
  `id` int(11) NOT NULL,
  `kot_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `rate` int(11) NOT NULL,
  `bulk_id` int(11) NOT NULL,
  `insertion_date_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restaurant_kot_details`
--

INSERT INTO `restaurant_kot_details` (`id`, `kot_id`, `item_id`, `quantity`, `rate`, `bulk_id`, `insertion_date_time`) VALUES
(1, 3, 2, 2, 130, 1, '2018-07-18 11:35:27'),
(2, 3, 18, 2, 10, 1, '2018-07-18 11:35:28'),
(3, 4, 4, 1, 90, 1, '2018-07-18 11:38:26'),
(4, 4, 18, 2, 10, 1, '2018-07-18 11:38:26'),
(5, 3, 11, 4, 25, 2, '2018-07-18 11:39:27'),
(6, 3, 14, 1, 60, 3, '2018-07-18 11:40:20'),
(7, 4, 16, 2, 20, 2, '2018-07-18 11:40:58'),
(8, 4, 17, 2, 15, 2, '2018-07-18 11:40:58');

-- --------------------------------------------------------

--
-- Table structure for table `tables`
--

CREATE TABLE `tables` (
  `id` int(11) NOT NULL,
  `table_number` varchar(20) NOT NULL,
  `is_available` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tables`
--

INSERT INTO `tables` (`id`, `table_number`, `is_available`) VALUES
(1, ' 1', 1),
(2, ' 2', 1),
(3, ' 3', 1),
(4, ' 4', 1),
(5, ' T-1', 1),
(6, ' T-2', 1),
(7, ' T-3', 1),
(8, ' T-4', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `display_name` varchar(70) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `password` char(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `display_name`, `user_name`, `password`) VALUES
(1, 'saif', 'saif', 'saif');

-- --------------------------------------------------------

--
-- Table structure for table `waiters`
--

CREATE TABLE `waiters` (
  `id` int(11) NOT NULL,
  `full_name` varchar(70) NOT NULL,
  `father_name` varchar(70) NOT NULL,
  `waiter_number` varchar(20) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `cnic` varchar(15) NOT NULL,
  `address` varchar(70) NOT NULL,
  `is_active` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `waiters`
--

INSERT INTO `waiters` (`id`, `full_name`, `father_name`, `waiter_number`, `phone_number`, `cnic`, `address`, `is_active`) VALUES
(1, 'janbaz', 'gul din', '12-1', '4545', '1212', 'peshawar', 1),
(2, 'Feroz', 'Jamal Shah', '12-4', '4545', '12124', 'peshawar', 1),
(3, 'jIBRAN', 'kAMRAN', '105', '3434', '5656', 'PESHAWAR', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `menu_items`
--
ALTER TABLE `menu_items`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `item_name` (`item_name`);

--
-- Indexes for table `payment_methods`
--
ALTER TABLE `payment_methods`
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `title` (`title`);

--
-- Indexes for table `restaurant_kot`
--
ALTER TABLE `restaurant_kot`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_restaurant_kot_table_id` (`table_id`),
  ADD KEY `fk_restaurant_kot_payment_method` (`payment_method`),
  ADD KEY `fk_restaurant_kot_waiter_id` (`waiter_id`);

--
-- Indexes for table `restaurant_kot_details`
--
ALTER TABLE `restaurant_kot_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_restaurant_kot_details_kot_id` (`kot_id`),
  ADD KEY `fk_restaurant_kot_details_item_id` (`item_id`);

--
-- Indexes for table `tables`
--
ALTER TABLE `tables`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `table_number` (`table_number`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user_name` (`user_name`);

--
-- Indexes for table `waiters`
--
ALTER TABLE `waiters`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `waiter_number` (`waiter_number`),
  ADD UNIQUE KEY `cnic` (`cnic`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `menu_items`
--
ALTER TABLE `menu_items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `restaurant_kot`
--
ALTER TABLE `restaurant_kot`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `restaurant_kot_details`
--
ALTER TABLE `restaurant_kot_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `tables`
--
ALTER TABLE `tables`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `waiters`
--
ALTER TABLE `waiters`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `restaurant_kot`
--
ALTER TABLE `restaurant_kot`
  ADD CONSTRAINT `fk_restaurant_kot_payment_method` FOREIGN KEY (`payment_method`) REFERENCES `payment_methods` (`id`),
  ADD CONSTRAINT `fk_restaurant_kot_table_id` FOREIGN KEY (`table_id`) REFERENCES `tables` (`id`),
  ADD CONSTRAINT `fk_restaurant_kot_waiter_id` FOREIGN KEY (`waiter_id`) REFERENCES `waiters` (`id`);

--
-- Constraints for table `restaurant_kot_details`
--
ALTER TABLE `restaurant_kot_details`
  ADD CONSTRAINT `fk_restaurant_kot_details_item_id` FOREIGN KEY (`item_id`) REFERENCES `menu_items` (`id`),
  ADD CONSTRAINT `fk_restaurant_kot_details_kot_id` FOREIGN KEY (`kot_id`) REFERENCES `restaurant_kot` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
