-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 04, 2021 at 04:47 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mysecurity_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `zipcode` int(11) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`id`, `address`, `phonenumber`, `city`, `state`, `country`, `zipcode`, `address_id`) VALUES
(1, '15 West', '333-333-3345', 'Man-Hattan', 'NY', 'USA', 11204, 1),
(2, '7402 Bay Parkway', '6785557878', 'Quenns', 'Ny', 'USA', 11122, 2),
(3, 'be', '4534434', 'grofno', 'ny', 'belarus', 112014, 3),
(4, 'bb', 'vv', 'bb', 'PA', 'USA', 11345, 4),
(5, 'your street and apt', 'your phonenumber', 'your city', 'your state', 'your country', 11111, 5),
(6, 'your street and apt', 'your phonenumber', 'your city', 'your state', 'your country', 11111, 6),
(7, 'your street and apt', 'your phonenumber', 'your city', 'your state', 'your country', 11111, 7);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `persistent_logins`
--

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'ADMIN'),
(2, 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `dateof_birth` datetime DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `is_enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `dateof_birth`, `job`, `name`, `age`, `email`, `is_enabled`, `password`, `username`, `address_id`) VALUES
(1, NULL, NULL, 'dzen', 0, 'dzen@gmail.com', b'1', '$2a$10$BpnNIQkdAu4ChzBR55yLEOtxb7bRlHJ97niLxpiNwklM9Fq1cZwvu', NULL, NULL),
(2, NULL, NULL, 'sr', 0, 'sr@gmail.com', b'1', '$2a$10$VNyxxpJb27IA/vnQs515xeaHXFBIqGWUzamvjr6.2GE.Rt6/c9CNe', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 2),
(2, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `persistent_logins`
--
ALTER TABLE `persistent_logins`
  ADD PRIMARY KEY (`series`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `fk_address` (`address_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `user_role_key` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `role_userrole` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  ADD CONSTRAINT `user_userrole` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
