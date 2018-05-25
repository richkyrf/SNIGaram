DELIMITER $$
--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `UCWORDS` (`STR` TEXT) RETURNS TEXT CHARSET latin1 BEGIN
  DECLARE C CHAR(1);
  DECLARE S TEXT;
  DECLARE I INT DEFAULT 1;
  DECLARE BOOL INT DEFAULT 1;
  DECLARE PUNCT CHAR(27) DEFAULT ' ()[]{},.-_!@;:?/1234567890';
  SET S = LCASE(STR);
  WHILE I <= LENGTH(STR) DO
    BEGIN
	  SET C = SUBSTRING(S, I, 1);
      IF LOCATE(C, PUNCT) > 0 THEN
	    SET BOOL = 1;
      ELSEIF BOOL = 1 THEN
	    BEGIN
	      IF C >= 'a' AND C <= 'z' THEN
		    BEGIN
		      SET S = CONCAT(LEFT(S, I-1), UCASE(C), SUBSTRING(S, I+1));
              SET BOOL = 0;
            END;
          ELSEIF C >= '0' AND C <= '9' THEN
		    SET BOOL = 0;
          END IF;
        END;
      END IF;
      SET I = I+1;
    END;
  END WHILE;
  RETURN S;
END$$

DELIMITER ;

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

-- --------------------------------------------------------

--
-- Table structure for table `snitbpelatihan`
--

CREATE TABLE `snitbpelatihan` (
  `IdPelatihan` int(11) NOT NULL,
  `IdUsulPelatihan` int(11) NOT NULL,
  `Keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `snitbpelatihandetail`
--

CREATE TABLE `snitbpelatihandetail` (
  `IdPelatihanDetail` int(11) NOT NULL,
  `IdPelatihan` int(11) NOT NULL,
  `IdKaryawan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

-- --------------------------------------------------------

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
-- Indexes for table `snitbevaluasisupplier`
--
ALTER TABLE `snitbevaluasisupplier`
  ADD PRIMARY KEY (`IdEvaluasi`);

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
-- Indexes for table `snitbmbarangteknik`
--
ALTER TABLE `snitbmbarangteknik`
  ADD PRIMARY KEY (`IdBarangTeknik`);

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
-- Indexes for table `snitbpemeliharaan`
--
ALTER TABLE `snitbpemeliharaan`
  ADD PRIMARY KEY (`IdPemeliharaan`),
  ADD KEY `IdBarangTeknik` (`IdBarangTeknik`);

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
  MODIFY `IdEvaluasiPelatihan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `snitbevaluasipelatihandetail`
--
ALTER TABLE `snitbevaluasipelatihandetail`
  MODIFY `IdEvaluasiPelatihanDetail` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `snitbevaluasisupplier`
--
ALTER TABLE `snitbevaluasisupplier`
  MODIFY `IdEvaluasi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `snitbkebutuhankaryawan`
--
ALTER TABLE `snitbkebutuhankaryawan`
  MODIFY `IdKebutuhanKaryawan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `snitbmasapercobaankaryawan`
--
ALTER TABLE `snitbmasapercobaankaryawan`
  MODIFY `IdMasaPercobaanKaryawan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `snitbmasapercobaankaryawandetail`
--
ALTER TABLE `snitbmasapercobaankaryawandetail`
  MODIFY `IdMasaPercobaanKaryawanDetail` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `snitbmbarangteknik`
--
ALTER TABLE `snitbmbarangteknik`
  MODIFY `IdBarangTeknik` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `snitbpelatihan`
--
ALTER TABLE `snitbpelatihan`
  MODIFY `IdPelatihan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `snitbpelatihandetail`
--
ALTER TABLE `snitbpelatihandetail`
  MODIFY `IdPelatihanDetail` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `snitbpemeliharaan`
--
ALTER TABLE `snitbpemeliharaan`
  MODIFY `IdPemeliharaan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `snitbpengaduanpelanggan`
--
ALTER TABLE `snitbpengaduanpelanggan`
  MODIFY `IdPengaduan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `snitbpengujianbahanbaku`
--
ALTER TABLE `snitbpengujianbahanbaku`
  MODIFY `IdPengujianBahanBaku` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `snitbpengujianprodukjadi`
--
ALTER TABLE `snitbpengujianprodukjadi`
  MODIFY `IdPengujianProdukJadi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `snitbriwayathidup`
--
ALTER TABLE `snitbriwayathidup`
  MODIFY `IdRiwayatHidup` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `snitbriwayathidupdetail`
--
ALTER TABLE `snitbriwayathidupdetail`
  MODIFY `IdRiwayatHidupDetail` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `snitbsupplierterplilih`
--
ALTER TABLE `snitbsupplierterplilih`
  MODIFY `IdSupplierTerpilih` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `snitbsurveykepuasanpelanggan`
--
ALTER TABLE `snitbsurveykepuasanpelanggan`
  MODIFY `IdSurveyKepuasanPelanggan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `snitbusulpelatihan`
--
ALTER TABLE `snitbusulpelatihan`
  MODIFY `IdUsulPelatihan` int(11) NOT NULL AUTO_INCREMENT;

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
-- Constraints for table `snitbpemeliharaan`
--
ALTER TABLE `snitbpemeliharaan`
  ADD CONSTRAINT `snitbpemeliharaan_ibfk_1` FOREIGN KEY (`IdBarangTeknik`) REFERENCES `snitbmbarangteknik` (`IdBarangTeknik`) ON UPDATE CASCADE;

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