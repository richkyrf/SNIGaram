-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2018 at 05:55 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
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
-- Table structure for table `snitbevaluasipelatihan`
--

CREATE TABLE `snitbevaluasipelatihan` (
  `IdEvaluasiPelatihan` int(11) NOT NULL,
  `IdPelatihan` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `Instruktur` varchar(50) NOT NULL,
  `Kesimpulan` text NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbevaluasipelatihan`
--

INSERT INTO `snitbevaluasipelatihan` (`IdEvaluasiPelatihan`, `IdPelatihan`, `Tanggal`, `Instruktur`, `Kesimpulan`, `Keterangan`) VALUES
(1, 1, '2018-05-11', 'Arsad', 'Test Bae', ''),
(2, 3, '2018-05-12', 'Ntin', 'Coba Bae', '');

-- --------------------------------------------------------

--
-- Table structure for table `snitbevaluasipelatihandetail`
--

CREATE TABLE `snitbevaluasipelatihandetail` (
  `IdEvaluasiPelatihanDetail` int(11) NOT NULL,
  `IdEvaluasiPelatihan` int(11) NOT NULL,
  `IdPelatihanDetail` int(11) NOT NULL,
  `PenguasaanMateri` int(11) NOT NULL,
  `KemampuanBekerja` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbevaluasipelatihandetail`
--

INSERT INTO `snitbevaluasipelatihandetail` (`IdEvaluasiPelatihanDetail`, `IdEvaluasiPelatihan`, `IdPelatihanDetail`, `PenguasaanMateri`, `KemampuanBekerja`) VALUES
(1, 1, 1, 80, 90),
(2, 1, 2, 90, 99),
(5, 2, 3, 90, 90);

-- --------------------------------------------------------

--
-- Table structure for table `snitbkebutuhankaryawan`
--

CREATE TABLE `snitbkebutuhankaryawan` (
  `IdKebutuhanKaryawan` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `Bagian` varchar(50) NOT NULL,
  `Kualifikasi` text NOT NULL,
  `Jumlah` int(11) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbkebutuhankaryawan`
--

INSERT INTO `snitbkebutuhankaryawan` (`IdKebutuhanKaryawan`, `Tanggal`, `Bagian`, `Kualifikasi`, `Jumlah`, `Keterangan`) VALUES
(10, '2018-01-08', 'Packing Garam', 'Minimal SMP', 3, ''),
(11, '2018-02-08', 'Buruh Harian', 'Minimal SMP', 2, ''),
(12, '2018-04-18', 'Kepala Gudang', 'Minimal SMA', 1, ''),
(13, '2018-05-11', 'Cuci Garam', 'Minimal SMA', 8, ''),
(14, '2018-05-12', 'sdfsd', 'sdfdsf', 2, ''),
(16, '2018-05-12', 'Buruh Harian', 'Minimal SMP', 5, '');

-- --------------------------------------------------------

--
-- Table structure for table `snitbmasapercobaankaryawan`
--

CREATE TABLE `snitbmasapercobaankaryawan` (
  `IdMasaPercobaanKaryawan` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `Kesimpulan` text NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbmasapercobaankaryawan`
--

INSERT INTO `snitbmasapercobaankaryawan` (`IdMasaPercobaanKaryawan`, `Tanggal`, `Kesimpulan`, `Keterangan`) VALUES
(1, '2018-05-06', 'Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae Test Bae', ''),
(2, '2018-05-08', 'Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi Test Lagi ', '');

-- --------------------------------------------------------

--
-- Table structure for table `snitbmasapercobaankaryawandetail`
--

CREATE TABLE `snitbmasapercobaankaryawandetail` (
  `IdMasaPercobaanKaryawanDetail` int(11) NOT NULL,
  `IdMasaPercobaanKaryawan` int(11) NOT NULL,
  `IdKaryawan` int(11) NOT NULL,
  `PenguasaanMateri` int(11) NOT NULL,
  `KemampuanBekerja` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbmasapercobaankaryawandetail`
--

INSERT INTO `snitbmasapercobaankaryawandetail` (`IdMasaPercobaanKaryawanDetail`, `IdMasaPercobaanKaryawan`, `IdKaryawan`, `PenguasaanMateri`, `KemampuanBekerja`) VALUES
(1, 1, 1, 70, 80),
(2, 1, 8, 80, 85),
(3, 2, 22, 70, 95),
(4, 2, 3, 90, 99);

-- --------------------------------------------------------

--
-- Table structure for table `snitbpelatihan`
--

CREATE TABLE `snitbpelatihan` (
  `IdPelatihan` int(11) NOT NULL,
  `IdUsulPelatihan` int(11) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbpelatihan`
--

INSERT INTO `snitbpelatihan` (`IdPelatihan`, `IdUsulPelatihan`, `Keterangan`) VALUES
(1, 1, ''),
(3, 2, ''),
(5, 3, '');

-- --------------------------------------------------------

--
-- Table structure for table `snitbpelatihandetail`
--

CREATE TABLE `snitbpelatihandetail` (
  `IdPelatihanDetail` int(11) NOT NULL,
  `IdPelatihan` int(11) NOT NULL,
  `IdKaryawan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbpelatihandetail`
--

INSERT INTO `snitbpelatihandetail` (`IdPelatihanDetail`, `IdPelatihan`, `IdKaryawan`) VALUES
(1, 1, 22),
(2, 1, 37),
(3, 3, 20),
(4, 3, 3),
(5, 5, 28);

-- --------------------------------------------------------

--
-- Table structure for table `snitbriwayathidup`
--

CREATE TABLE `snitbriwayathidup` (
  `IdRiwayatHidup` int(11) NOT NULL,
  `IdKaryawan` int(11) NOT NULL,
  `TanggalBergabung` date NOT NULL,
  `PendidikanFormal` enum('-','SD','SMP','SMA','D1','D2','D3','D4','S1','S2','S3') NOT NULL,
  `Status` enum('Kawin','Belum Kawin') NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbriwayathidup`
--

INSERT INTO `snitbriwayathidup` (`IdRiwayatHidup`, `IdKaryawan`, `TanggalBergabung`, `PendidikanFormal`, `Status`, `Keterangan`) VALUES
(1, 29, '2018-05-01', 'SMP', 'Kawin', ''),
(4, 8, '2018-05-01', 'SD', 'Kawin', '');

-- --------------------------------------------------------

--
-- Table structure for table `snitbriwayathidupdetail`
--

CREATE TABLE `snitbriwayathidupdetail` (
  `IdRiwayatHidupDetail` int(11) NOT NULL,
  `IdRiwayatHidup` int(11) NOT NULL,
  `TanggalMulai` date NOT NULL,
  `TanggalSelesai` date NOT NULL,
  `Bagian` varchar(100) NOT NULL,
  `Keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbriwayathidupdetail`
--

INSERT INTO `snitbriwayathidupdetail` (`IdRiwayatHidupDetail`, `IdRiwayatHidup`, `TanggalMulai`, `TanggalSelesai`, `Bagian`, `Keterangan`) VALUES
(1, 1, '2018-04-01', '2018-04-30', 'Packing Garam', 'PT. KTN'),
(2, 1, '2018-05-01', '2018-05-04', 'Packing Gula', 'PT. Tebu Indonesia'),
(3, 4, '2018-05-01', '2018-05-10', 'asdf', 'asdfghjkl');

-- --------------------------------------------------------

--
-- Table structure for table `snitbusulpelatihan`
--

CREATE TABLE `snitbusulpelatihan` (
  `IdUsulPelatihan` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `JenisPelatihan` varchar(100) NOT NULL,
  `Tempat` varchar(50) NOT NULL,
  `Waktu` time NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbusulpelatihan`
--

INSERT INTO `snitbusulpelatihan` (`IdUsulPelatihan`, `Tanggal`, `JenisPelatihan`, `Tempat`, `Waktu`, `Keterangan`) VALUES
(1, '2018-08-01', 'Kebersihan Dalam Bekerja', 'Talang Duku', '09:05:00', ''),
(2, '2018-05-08', 'Dasar-Dasar Packing Garam Yang Berkualitas Dasar-Dasar Packing Garam Yang Berkualitas', 'Talang Duku', '15:00:00', ''),
(3, '2018-05-08', 'Dasar-Dasar Packing Garam Yang Berkualitas Dasar-Dasar Packing Garam Yang Berkualitas', 'Gudang Garam', '17:00:00', ''),
(4, '2018-05-01', '123', '456', '08:08:00', ''),
(5, '2018-05-01', 'sdfsdf', 'fsdf', '00:00:00', ''),
(6, '2018-05-12', '111', '222', '23:00:00', ''),
(7, '2018-05-12', '333', '333', '00:00:00', ''),
(8, '2018-05-12', '44', '444', '06:00:00', ''),
(9, '2018-05-12', 'Dasar - Dasar Packing', 'Talang Duku', '23:59:00', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `snitbevaluasipelatihan`
--
ALTER TABLE `snitbevaluasipelatihan`
  ADD PRIMARY KEY (`IdEvaluasiPelatihan`),
  ADD UNIQUE KEY `IdPelatihan` (`IdPelatihan`);

--
-- Indexes for table `snitbevaluasipelatihandetail`
--
ALTER TABLE `snitbevaluasipelatihandetail`
  ADD PRIMARY KEY (`IdEvaluasiPelatihanDetail`),
  ADD UNIQUE KEY `IdPelatihanDetail` (`IdPelatihanDetail`),
  ADD KEY `IdEvaluasiPelatihan` (`IdEvaluasiPelatihan`);

--
-- Indexes for table `snitbkebutuhankaryawan`
--
ALTER TABLE `snitbkebutuhankaryawan`
  ADD PRIMARY KEY (`IdKebutuhanKaryawan`),
  ADD UNIQUE KEY `Tanggal dan Bagian` (`Tanggal`,`Bagian`) USING BTREE;

--
-- Indexes for table `snitbmasapercobaankaryawan`
--
ALTER TABLE `snitbmasapercobaankaryawan`
  ADD PRIMARY KEY (`IdMasaPercobaanKaryawan`),
  ADD UNIQUE KEY `Tanggal` (`Tanggal`);

--
-- Indexes for table `snitbmasapercobaankaryawandetail`
--
ALTER TABLE `snitbmasapercobaankaryawandetail`
  ADD PRIMARY KEY (`IdMasaPercobaanKaryawanDetail`),
  ADD KEY `IdMasaPercobaanKaryawan` (`IdMasaPercobaanKaryawan`),
  ADD KEY `IdKaryawan` (`IdKaryawan`);

--
-- Indexes for table `snitbpelatihan`
--
ALTER TABLE `snitbpelatihan`
  ADD PRIMARY KEY (`IdPelatihan`),
  ADD UNIQUE KEY `IdUsulPelatihan` (`IdUsulPelatihan`);

--
-- Indexes for table `snitbpelatihandetail`
--
ALTER TABLE `snitbpelatihandetail`
  ADD PRIMARY KEY (`IdPelatihanDetail`),
  ADD KEY `IdPelatihan` (`IdPelatihan`),
  ADD KEY `IdKaryawan` (`IdKaryawan`);

--
-- Indexes for table `snitbriwayathidup`
--
ALTER TABLE `snitbriwayathidup`
  ADD PRIMARY KEY (`IdRiwayatHidup`),
  ADD UNIQUE KEY `IdKaryawan` (`IdKaryawan`);

--
-- Indexes for table `snitbriwayathidupdetail`
--
ALTER TABLE `snitbriwayathidupdetail`
  ADD PRIMARY KEY (`IdRiwayatHidupDetail`),
  ADD KEY `IdRiwayatHidup` (`IdRiwayatHidup`);

--
-- Indexes for table `snitbusulpelatihan`
--
ALTER TABLE `snitbusulpelatihan`
  ADD PRIMARY KEY (`IdUsulPelatihan`),
  ADD UNIQUE KEY `Tanggal` (`Tanggal`,`JenisPelatihan`,`Tempat`,`Waktu`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `snitbevaluasipelatihan`
--
ALTER TABLE `snitbevaluasipelatihan`
  MODIFY `IdEvaluasiPelatihan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `snitbevaluasipelatihandetail`
--
ALTER TABLE `snitbevaluasipelatihandetail`
  MODIFY `IdEvaluasiPelatihanDetail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `snitbkebutuhankaryawan`
--
ALTER TABLE `snitbkebutuhankaryawan`
  MODIFY `IdKebutuhanKaryawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `snitbmasapercobaankaryawan`
--
ALTER TABLE `snitbmasapercobaankaryawan`
  MODIFY `IdMasaPercobaanKaryawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `snitbmasapercobaankaryawandetail`
--
ALTER TABLE `snitbmasapercobaankaryawandetail`
  MODIFY `IdMasaPercobaanKaryawanDetail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `snitbpelatihan`
--
ALTER TABLE `snitbpelatihan`
  MODIFY `IdPelatihan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `snitbpelatihandetail`
--
ALTER TABLE `snitbpelatihandetail`
  MODIFY `IdPelatihanDetail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `snitbriwayathidup`
--
ALTER TABLE `snitbriwayathidup`
  MODIFY `IdRiwayatHidup` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `snitbriwayathidupdetail`
--
ALTER TABLE `snitbriwayathidupdetail`
  MODIFY `IdRiwayatHidupDetail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `snitbusulpelatihan`
--
ALTER TABLE `snitbusulpelatihan`
  MODIFY `IdUsulPelatihan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `snitbevaluasipelatihan`
--
ALTER TABLE `snitbevaluasipelatihan`
  ADD CONSTRAINT `snitbevaluasipelatihan_ibfk_1` FOREIGN KEY (`IdPelatihan`) REFERENCES `snitbpelatihan` (`IdPelatihan`) ON UPDATE CASCADE;

--
-- Constraints for table `snitbevaluasipelatihandetail`
--
ALTER TABLE `snitbevaluasipelatihandetail`
  ADD CONSTRAINT `snitbevaluasipelatihandetail_ibfk_1` FOREIGN KEY (`IdEvaluasiPelatihan`) REFERENCES `snitbevaluasipelatihan` (`IdEvaluasiPelatihan`) ON UPDATE CASCADE,
  ADD CONSTRAINT `snitbevaluasipelatihandetail_ibfk_2` FOREIGN KEY (`IdPelatihanDetail`) REFERENCES `snitbpelatihandetail` (`IdPelatihanDetail`) ON UPDATE CASCADE;

--
-- Constraints for table `snitbmasapercobaankaryawandetail`
--
ALTER TABLE `snitbmasapercobaankaryawandetail`
  ADD CONSTRAINT `snitbmasapercobaankaryawandetail_ibfk_1` FOREIGN KEY (`IdMasaPercobaanKaryawan`) REFERENCES `snitbmasapercobaankaryawan` (`IdMasaPercobaanKaryawan`) ON UPDATE CASCADE,
  ADD CONSTRAINT `snitbmasapercobaankaryawandetail_ibfk_2` FOREIGN KEY (`IdKaryawan`) REFERENCES `tbmkaryawan` (`IdKaryawan`) ON UPDATE CASCADE;

--
-- Constraints for table `snitbpelatihan`
--
ALTER TABLE `snitbpelatihan`
  ADD CONSTRAINT `snitbpelatihan_ibfk_1` FOREIGN KEY (`IdUsulPelatihan`) REFERENCES `snitbusulpelatihan` (`IdUsulPelatihan`) ON UPDATE CASCADE;

--
-- Constraints for table `snitbpelatihandetail`
--
ALTER TABLE `snitbpelatihandetail`
  ADD CONSTRAINT `snitbpelatihandetail_ibfk_1` FOREIGN KEY (`IdPelatihan`) REFERENCES `snitbpelatihan` (`IdPelatihan`) ON UPDATE CASCADE,
  ADD CONSTRAINT `snitbpelatihandetail_ibfk_2` FOREIGN KEY (`IdKaryawan`) REFERENCES `tbmkaryawan` (`IdKaryawan`) ON UPDATE CASCADE;

--
-- Constraints for table `snitbriwayathidup`
--
ALTER TABLE `snitbriwayathidup`
  ADD CONSTRAINT `snitbriwayathidup_ibfk_1` FOREIGN KEY (`IdKaryawan`) REFERENCES `tbmkaryawan` (`IdKaryawan`) ON UPDATE CASCADE;

--
-- Constraints for table `snitbriwayathidupdetail`
--
ALTER TABLE `snitbriwayathidupdetail`
  ADD CONSTRAINT `snitbriwayathidupdetail_ibfk_1` FOREIGN KEY (`IdRiwayatHidup`) REFERENCES `snitbriwayathidup` (`IdRiwayatHidup`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
