-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2018 at 03:58 AM
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
-- Table structure for table `snitbevaluasisupplier`
--

CREATE TABLE `snitbevaluasisupplier` (
  `IdEvaluasi` int(11) NOT NULL,
  `NamaPemasok` varchar(255) NOT NULL,
  `HasilEvaluasi` varchar(200) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbevaluasisupplier`
--

INSERT INTO `snitbevaluasisupplier` (`IdEvaluasi`, `NamaPemasok`, `HasilEvaluasi`, `Keterangan`) VALUES
(1, 'PT. Garindo', '75,80,85,90', '~~~');

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
(2, '2017-04-18', 2, 'Martono', 'Martono');

-- --------------------------------------------------------

--
-- Table structure for table `snitbpengaduanpelanggan`
--

CREATE TABLE `snitbpengaduanpelanggan` (
  `IdPengaduan` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `AsalInstitusi` varchar(255) NOT NULL,
  `YangMenerima` varchar(255) NOT NULL,
  `JenisPengaduan` varchar(255) NOT NULL,
  `BagianYangMenangani` varchar(255) NOT NULL,
  `RincianPengaduan` varchar(255) NOT NULL,
  `TindakLanjutPengaduan` varchar(255) NOT NULL,
  `TindakanPencegahan` varchar(255) NOT NULL,
  `TargetTanggalPenyelesaian` date NOT NULL,
  `VerifikasiPenyelesaian` varchar(255) NOT NULL,
  `Selesai` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbpengaduanpelanggan`
--

INSERT INTO `snitbpengaduanpelanggan` (`IdPengaduan`, `Tanggal`, `AsalInstitusi`, `YangMenerima`, `JenisPengaduan`, `BagianYangMenangani`, `RincianPengaduan`, `TindakLanjutPengaduan`, `TindakanPencegahan`, `TargetTanggalPenyelesaian`, `VerifikasiPenyelesaian`, `Selesai`) VALUES
(1, '2018-04-30', 'Martono', 'Martono', 'Biasa', 'Gudang', 'Martono', 'Martono', 'Martono', '2018-04-30', 'Martono', 0),
(2, '2018-04-30', 'Martonoo', 'Martonoo', 'Biasa', 'Gudang', 'Martonoo', 'Martonoo', 'Martonoo', '2018-04-30', 'Martonoo', 1),
(3, '2018-04-30', 'Martonooo', 'Martonooo', 'Biasa', 'Gudang', 'Marnoooo', 'Martonooo', 'Martonooo', '2018-04-30', 'Martonooo', 1),
(4, '2018-04-30', 'Marton', 'Marton', 'Biasa', 'Gudang', 'Marton', 'Marton', 'Marton', '2018-04-30', 'Marton', 1),
(5, '2018-04-30', 'Martonoooo', 'Martonoooo', 'Biasa', 'Gudang', 'Martonoooo', 'Martonoooo', 'Martonoooo', '2018-04-30', 'Martonoooo', 0),
(6, '2018-05-07', 'PT. MARTONO SEJAHTERA', 'MARTONO', 'Biasa', 'Gudang', 'MARTONOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO', 'MARTONNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO', 'MMMMMMMMMMMMMMMMMMMMMMMMMAAAAAAAAAAAAAARRRRRRRRRRRRRRRRRRTTTTTTTTTTTTTOOOOOOOOOOOOOOONNNNNNNNNNNNNNNNOOOOOOOOOOOOOOOOO', '2018-05-07', 'asdasd', 1);

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
-- Table structure for table `snitbsupplierterplilih`
--

CREATE TABLE `snitbsupplierterplilih` (
  `IdSupplierTerpilih` int(11) NOT NULL,
  `NamaPemasok` varchar(255) NOT NULL,
  `Produk` varchar(255) NOT NULL,
  `Spesifikasi` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbsupplierterplilih`
--

INSERT INTO `snitbsupplierterplilih` (`IdSupplierTerpilih`, `NamaPemasok`, `Produk`, `Spesifikasi`) VALUES
(1, 'PT. GARINDO', 'Garam Kasar & Halus', 'Putih'),
(2, 'PT. PERSERO', 'Garam Kasar', 'Putih'),
(3, 'Winindo Jaya', 'Plastik', 'Baru');

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
  `CatatanDariPelanggan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `snitbsurveykepuasanpelanggan`
--

INSERT INTO `snitbsurveykepuasanpelanggan` (`IdSurveyKepuasanPelanggan`, `NamaPerusahaan`, `Alamat`, `Tanggal`, `NamaPelanggan`, `Nilai`, `CatatanDariPelanggan`) VALUES
(1, 'PT. MARTONO', 'MARTONO', '2018-04-30', 'MARTONO', '10,20,30,40,50,60,70,80,90', ''),
(2, 'PT.MARTONOO', 'JL.MARTONOO', '2018-05-05', 'Bpk. Martono', '90,80,70,60,50,40,30,20,10', '--------------------------------');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `snitbevaluasisupplier`
--
ALTER TABLE `snitbevaluasisupplier`
  ADD PRIMARY KEY (`IdEvaluasi`);

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
-- Indexes for table `snitbpengaduanpelanggan`
--
ALTER TABLE `snitbpengaduanpelanggan`
  ADD PRIMARY KEY (`IdPengaduan`);

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
-- Indexes for table `snitbsupplierterplilih`
--
ALTER TABLE `snitbsupplierterplilih`
  ADD PRIMARY KEY (`IdSupplierTerpilih`);

--
-- Indexes for table `snitbsurveykepuasanpelanggan`
--
ALTER TABLE `snitbsurveykepuasanpelanggan`
  ADD PRIMARY KEY (`IdSurveyKepuasanPelanggan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `snitbevaluasisupplier`
--
ALTER TABLE `snitbevaluasisupplier`
  MODIFY `IdEvaluasi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
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
-- AUTO_INCREMENT for table `snitbpengaduanpelanggan`
--
ALTER TABLE `snitbpengaduanpelanggan`
  MODIFY `IdPengaduan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
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
-- AUTO_INCREMENT for table `snitbsupplierterplilih`
--
ALTER TABLE `snitbsupplierterplilih`
  MODIFY `IdSupplierTerpilih` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `snitbsurveykepuasanpelanggan`
--
ALTER TABLE `snitbsurveykepuasanpelanggan`
  MODIFY `IdSurveyKepuasanPelanggan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
