-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 27, 2018 at 08:32 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbgaram`
--

-- --------------------------------------------------------

--
-- Table structure for table `snitbmbarangteknik`
--

CREATE TABLE `snitbmbarangteknik` (
  `IdBarangTeknik` int(11) NOT NULL,
  `NamaBarang` varchar(25) NOT NULL,
  `Merk` varchar(20) NOT NULL,
  `Jumlah` int(11) NOT NULL,
  `WaktuKalibrasi` date NOT NULL,
  `Keterangan` text NOT NULL,
  `Status` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbmbarangteknik`
--

INSERT INTO `snitbmbarangteknik` (`IdBarangTeknik`, `NamaBarang`, `Merk`, `Jumlah`, `WaktuKalibrasi`, `Keterangan`, `Status`) VALUES
(1, 'Timbangan Digital', 'Thang Long', 1, '2018-02-01', '', 1),
(2, 'Martono', 'Martono', 10, '2018-04-26', 'Martono', 1);

-- --------------------------------------------------------

--
-- Table structure for table `snitbpemeliharaan`
--

CREATE TABLE `snitbpemeliharaan` (
  `IdPemeliharaan` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `IdBarangTeknik` int(11) NOT NULL,
  `Deskripsi` varchar(50) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbpemeliharaan`
--

INSERT INTO `snitbpemeliharaan` (`IdPemeliharaan`, `Tanggal`, `IdBarangTeknik`, `Deskripsi`, `Keterangan`) VALUES
(1, '2018-02-14', 1, '', ''),
(2, '2018-04-18', 2, 'Martono', 'Martono');

-- --------------------------------------------------------

--
-- Table structure for table `snitbpengujianbahanbaku`
--

CREATE TABLE `snitbpengujianbahanbaku` (
  `IdPengujianBahanBaku` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `KadarAir` decimal(11,2) NOT NULL,
  `KadarNaCl` decimal(11,2) NOT NULL,
  `Warna` varchar(25) NOT NULL,
  `Penguji` varchar(25) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbpengujianbahanbaku`
--

INSERT INTO `snitbpengujianbahanbaku` (`IdPengujianBahanBaku`, `Tanggal`, `KadarAir`, `KadarNaCl`, `Warna`, `Penguji`, `Keterangan`) VALUES
(1, '2018-04-20', '0.05', '0.90', 'Putih', 'Citta', ''),
(2, '2018-04-21', '1.00', '1.00', 'Putih', 'Citta', ''),
(3, '2018-04-20', '0.50', '0.50', 'Putih', 'Citta', ''),
(4, '2018-04-21', '0.50', '0.50', 'Putih', 'Citta', '');

-- --------------------------------------------------------

--
-- Table structure for table `snitbpengujianprodukjadi`
--

CREATE TABLE `snitbpengujianprodukjadi` (
  `IdPengujianProdukJadi` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `KadarKIO3` decimal(11,2) NOT NULL,
  `KadarAir` decimal(11,2) NOT NULL,
  `KadarNaCl` decimal(11,2) NOT NULL,
  `Warna` varchar(25) NOT NULL,
  `Penguji` varchar(25) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbpengujianprodukjadi`
--

INSERT INTO `snitbpengujianprodukjadi` (`IdPengujianProdukJadi`, `Tanggal`, `KadarKIO3`, `KadarAir`, `KadarNaCl`, `Warna`, `Penguji`, `Keterangan`) VALUES
(1, '2018-04-20', '0.05', '0.05', '0.90', 'Putih', 'Citta', ''),
(2, '2018-04-21', '1.00', '1.00', '1.00', 'Putih', 'Citta', ''),
(3, '2018-04-20', '0.50', '0.50', '0.50', 'Putih', 'Citta', ''),
(4, '2018-04-21', '0.50', '0.50', '0.50', 'Putih', 'Citta', '');

-- --------------------------------------------------------

--
-- Table structure for table `snitbsurveykepuasanpelanggan`
--

CREATE TABLE `snitbsurveykepuasanpelanggan` (
  `IdSurveyKepuasanPelanggan` int(11) NOT NULL,
  `NamaPerusahaan` varchar(50) NOT NULL,
  `Alamat` varchar(50) NOT NULL,
  `Tanggal` date NOT NULL,
  `NamaPelanggan` varchar(50) NOT NULL,
  `Nilai` varchar(100) NOT NULL,
  `CatatanDariPelanggan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `snitbmbarangteknik`
--
ALTER TABLE `snitbmbarangteknik`
  ADD PRIMARY KEY (`IdBarangTeknik`);

--
-- Indexes for table `snitbpemeliharaan`
--
ALTER TABLE `snitbpemeliharaan`
  ADD PRIMARY KEY (`IdPemeliharaan`);

--
-- Indexes for table `snitbpengujianbahanbaku`
--
ALTER TABLE `snitbpengujianbahanbaku`
  ADD PRIMARY KEY (`IdPengujianBahanBaku`);

--
-- Indexes for table `snitbpengujianprodukjadi`
--
ALTER TABLE `snitbpengujianprodukjadi`
  ADD PRIMARY KEY (`IdPengujianProdukJadi`);

--
-- Indexes for table `snitbsurveykepuasanpelanggan`
--
ALTER TABLE `snitbsurveykepuasanpelanggan`
  ADD PRIMARY KEY (`IdSurveyKepuasanPelanggan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `snitbmbarangteknik`
--
ALTER TABLE `snitbmbarangteknik`
  MODIFY `IdBarangTeknik` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `snitbpemeliharaan`
--
ALTER TABLE `snitbpemeliharaan`
  MODIFY `IdPemeliharaan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `snitbpengujianbahanbaku`
--
ALTER TABLE `snitbpengujianbahanbaku`
  MODIFY `IdPengujianBahanBaku` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `snitbpengujianprodukjadi`
--
ALTER TABLE `snitbpengujianprodukjadi`
  MODIFY `IdPengujianProdukJadi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `snitbsurveykepuasanpelanggan`
--
ALTER TABLE `snitbsurveykepuasanpelanggan`
  MODIFY `IdSurveyKepuasanPelanggan` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
