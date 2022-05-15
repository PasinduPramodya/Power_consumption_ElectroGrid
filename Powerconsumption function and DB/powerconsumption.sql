-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2022 at 09:29 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `powerconsumption`
--

-- --------------------------------------------------------

--
-- Table structure for table `powerconsumtion`
--

CREATE TABLE `powerconsumtion` (
  `id` int(11) NOT NULL,
  `unit` varchar(100) NOT NULL,
  `datefrom` varchar(100) NOT NULL,
  `dateto` varchar(120) NOT NULL,
  `cusid` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `powerconsumtion`
--

INSERT INTO `powerconsumtion` (`id`, `unit`, `datefrom`, `dateto`, `cusid`) VALUES
(15, '123', '12', '1', '2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `powerconsumtion`
--
ALTER TABLE `powerconsumtion`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `powerconsumtion`
--
ALTER TABLE `powerconsumtion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
