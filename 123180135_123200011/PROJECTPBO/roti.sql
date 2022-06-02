-- phpMyAdmin SQL Dump
-- version 3.1.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 12, 2019 at 06:10 PM
-- Server version: 5.1.30
-- PHP Version: 5.2.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `roti`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_roti`
--

CREATE TABLE IF NOT EXISTS `tbl_roti` (
  `No` int(11) NOT NULL AUTO_INCREMENT,
  `nama_pembeli` varchar(50) NOT NULL,
  `jenis_barang` varchar(50) NOT NULL,
  `rasa` varchar(50) NOT NULL,
  `jumlah_order` varchar(50) NOT NULL,
  `harga` varchar(50) NOT NULL,
  PRIMARY KEY (`No`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `tbl_roti`
--

INSERT INTO `tbl_roti` (`No`, `nama_pembeli`, `jenis_barang`, `rasa`, `jumlah_order`, `harga`) VALUES
(3, 'Reny', '1. Roti', 'Vanilla', '3', '30000'),
(2, 'Lisna', '2. Brownies', 'Strawberry', '5', '125000'),
(1, 'Reza', '1. Roti', 'Coklat', '2', '20000');
