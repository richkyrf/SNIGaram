/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import static GlobalVar.Var.*;
import LaporanLab.LaporanLab;
import LaporanPemasaran.LaporanPemasaran;
import LaporanPersonalia.LaporanPersonalia;
import LaporanProduksi.LaporanProduksi;
import LaporanTeknik.LaporanTeknik;
import List.*;
import ProsesTeknik.BarangTeknik;
import ProsesLab.*;
import ProsesPemasran.PengaduanPelanggan;
import ProsesPemasran.SurveyKepuasanPelanggan;
import ProsesPersonalia.KebutuhanKaryawan;
import ProsesTeknik.Pemeliharaan;
import static java.awt.Frame.NORMAL;

/**
 *
 * @author richk
 */
public class MenuUtama extends javax.swing.JFrame {

    /**
     * Creates new form MenuUtama
     */
    public MenuUtama() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Menu Utama");
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JMenuBar = new javax.swing.JMenuBar();
        JMFile = new javax.swing.JMenu();
        JMITambahUser = new javax.swing.JMenuItem();
        JMIResetPasswordUser = new javax.swing.JMenuItem();
        SFile = new javax.swing.JPopupMenu.Separator();
        JMIGantiPassword = new javax.swing.JMenuItem();
        JMIExit = new javax.swing.JMenuItem();
        JMProses = new javax.swing.JMenu();
        JMProsesLab = new javax.swing.JMenu();
        JMIPengujianProdukJadi = new javax.swing.JMenuItem();
        JMIPengujianBahanBaku = new javax.swing.JMenuItem();
        JMProsesTeknik = new javax.swing.JMenu();
        JMIBarangTeknik = new javax.swing.JMenuItem();
        JMIPemeliharaan = new javax.swing.JMenuItem();
        JMProsesPemasaran = new javax.swing.JMenu();
        JMIPengaduanPelanggan = new javax.swing.JMenuItem();
        JMISurveyKepuasanPelanggan = new javax.swing.JMenuItem();
        JMIDataPenjualan = new javax.swing.JMenuItem();
        JMProsesPersonalia = new javax.swing.JMenu();
        JMIKebutuhanKaryawan = new javax.swing.JMenuItem();
        JMList = new javax.swing.JMenu();
        JMListLab = new javax.swing.JMenu();
        JMIListPengujianProdukJadi = new javax.swing.JMenuItem();
        JMIListPengujianBahanBaku = new javax.swing.JMenuItem();
        JMListTeknik = new javax.swing.JMenu();
        JMIListBarangTeknik = new javax.swing.JMenuItem();
        JMIListPemeliharaan = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        JMListPersonalia = new javax.swing.JMenu();
        JMIListKebutuhanKaryawan = new javax.swing.JMenuItem();
        JMLaporan = new javax.swing.JMenu();
        JMLaporanProduksi = new javax.swing.JMenu();
        JMILaporanBahanBakuBahanPenolong = new javax.swing.JMenuItem();
        JMILaporanPersediaanBarang = new javax.swing.JMenuItem();
        JMILaporanIdentifikasiProdukJadi = new javax.swing.JMenuItem();
        JMILaporanPenyerahanProdukJadi = new javax.swing.JMenuItem();
        JMILaporanOrderPesanan = new javax.swing.JMenuItem();
        JMILaporanDataProduksi = new javax.swing.JMenuItem();
        JMLaporanLab = new javax.swing.JMenu();
        JMILaporanPengujianProdukJadi = new javax.swing.JMenuItem();
        JMILaporanPengujianBahanBaku = new javax.swing.JMenuItem();
        JMLaporanTeknik = new javax.swing.JMenu();
        JMILaporanDaftarPeralatan = new javax.swing.JMenuItem();
        JMILaporanPemeliharaan = new javax.swing.JMenuItem();
        JMLaporanPemasaran = new javax.swing.JMenu();
        JMILaporanPengaduanPelanggan = new javax.swing.JMenuItem();
        JMILaporanSurveyKepuasanPelanggan = new javax.swing.JMenuItem();
        JMILaporanDataPenjualan = new javax.swing.JMenuItem();
        JMLaporanPersonalia = new javax.swing.JMenu();
        JMILaporanKebutuhanKaryawan = new javax.swing.JMenuItem();
        JMILaporanEvaluasiMasaPercobaanKaryawan = new javax.swing.JMenuItem();
        JMILaporanDaftarRiwayatHidup = new javax.swing.JMenuItem();
        JMILaporanUsulPelatihan = new javax.swing.JMenuItem();
        JMILaporanProgramPelatihan = new javax.swing.JMenuItem();
        JMILaporanCalonPesertaPelatihan = new javax.swing.JMenuItem();
        JMILaproanEvaluasiPelatihan = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        JMFile.setText("File");

        if (!GlobalVar.VarL.level.equals("Administrator")) {
            JMITambahUser.setVisible(false);
        }
        JMITambahUser.setText("Tambah User");
        JMITambahUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMITambahUserActionPerformed(evt);
            }
        });
        JMFile.add(JMITambahUser);

        if (!GlobalVar.VarL.level.equals("Administrator")) {
            JMIResetPasswordUser.setVisible(false);
            SFile.setVisible(false);
        }
        JMIResetPasswordUser.setText("Reset Password User");
        JMIResetPasswordUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIResetPasswordUserActionPerformed(evt);
            }
        });
        JMFile.add(JMIResetPasswordUser);
        JMFile.add(SFile);

        JMIGantiPassword.setText("Ganti Password");
        JMIGantiPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIGantiPasswordActionPerformed(evt);
            }
        });
        JMFile.add(JMIGantiPassword);

        JMIExit.setText("Exit");
        JMIExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIExitActionPerformed(evt);
            }
        });
        JMFile.add(JMIExit);

        JMenuBar.add(JMFile);

        JMProses.setText("Proses");

        JMProsesLab.setText("Proses Lab");

        JMIPengujianProdukJadi.setText("Pengujian Produk Jadi");
        JMIPengujianProdukJadi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIPengujianProdukJadiActionPerformed(evt);
            }
        });
        JMProsesLab.add(JMIPengujianProdukJadi);

        JMIPengujianBahanBaku.setText("Pengujian Bahan Baku");
        JMIPengujianBahanBaku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIPengujianBahanBakuActionPerformed(evt);
            }
        });
        JMProsesLab.add(JMIPengujianBahanBaku);

        JMProses.add(JMProsesLab);

        JMProsesTeknik.setText("Proses Teknik");

        JMIBarangTeknik.setText("Barang Teknik");
        JMIBarangTeknik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIBarangTeknikActionPerformed(evt);
            }
        });
        JMProsesTeknik.add(JMIBarangTeknik);

        JMIPemeliharaan.setText("Pemeliharaan");
        JMIPemeliharaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIPemeliharaanActionPerformed(evt);
            }
        });
        JMProsesTeknik.add(JMIPemeliharaan);

        JMProses.add(JMProsesTeknik);

        JMProsesPemasaran.setText("Proses Pemasaran");

        JMIPengaduanPelanggan.setText("Pengaduan Pelanggan");
        JMIPengaduanPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIPengaduanPelangganActionPerformed(evt);
            }
        });
        JMProsesPemasaran.add(JMIPengaduanPelanggan);

        JMISurveyKepuasanPelanggan.setText("Survey Kepuasan Pelanggan");
        JMISurveyKepuasanPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMISurveyKepuasanPelangganActionPerformed(evt);
            }
        });
        JMProsesPemasaran.add(JMISurveyKepuasanPelanggan);

        JMIDataPenjualan.setText("Data Penjualan");
        JMIDataPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIDataPenjualanActionPerformed(evt);
            }
        });
        JMProsesPemasaran.add(JMIDataPenjualan);

        JMProses.add(JMProsesPemasaran);

        JMProsesPersonalia.setText("Proses Personalia");

        JMIKebutuhanKaryawan.setText("Kebutuhan Karyawan");
        JMIKebutuhanKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIKebutuhanKaryawanActionPerformed(evt);
            }
        });
        JMProsesPersonalia.add(JMIKebutuhanKaryawan);

        JMProses.add(JMProsesPersonalia);

        JMenuBar.add(JMProses);

        JMList.setText("List");

        JMListLab.setText("List Lab");

        JMIListPengujianProdukJadi.setText("Pengujian Produk Jadi");
        JMIListPengujianProdukJadi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIListPengujianProdukJadiActionPerformed(evt);
            }
        });
        JMListLab.add(JMIListPengujianProdukJadi);

        JMIListPengujianBahanBaku.setText("Pengujian Bahan Baku");
        JMIListPengujianBahanBaku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIListPengujianBahanBakuActionPerformed(evt);
            }
        });
        JMListLab.add(JMIListPengujianBahanBaku);

        JMList.add(JMListLab);

        JMListTeknik.setText("List Teknik");

        JMIListBarangTeknik.setText("Barang Teknik");
        JMIListBarangTeknik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIListBarangTeknikActionPerformed(evt);
            }
        });
        JMListTeknik.add(JMIListBarangTeknik);

        JMIListPemeliharaan.setText("Pemeliharaan");
        JMIListPemeliharaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIListPemeliharaanActionPerformed(evt);
            }
        });
        JMListTeknik.add(JMIListPemeliharaan);

        JMList.add(JMListTeknik);

        jMenu2.setText("List Pemasaran");

        jMenuItem4.setText("Pengaduan Pelanggan");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Survey Kepuasan Pelanggan");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Data Penjualan");
        jMenu2.add(jMenuItem6);

        JMList.add(jMenu2);

        JMListPersonalia.setText("List Personalia");

        JMIListKebutuhanKaryawan.setText("Kebutuhan Karyawan");
        JMIListKebutuhanKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIListKebutuhanKaryawanActionPerformed(evt);
            }
        });
        JMListPersonalia.add(JMIListKebutuhanKaryawan);

        JMList.add(JMListPersonalia);

        JMenuBar.add(JMList);

        JMLaporan.setText("Laporan");

        JMLaporanProduksi.setText("Laporan Produksi");

        JMILaporanBahanBakuBahanPenolong.setText("Laporan Bahan Baku / Bahan Penolong");
        JMILaporanBahanBakuBahanPenolong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMILaporanBahanBakuBahanPenolongActionPerformed(evt);
            }
        });
        JMLaporanProduksi.add(JMILaporanBahanBakuBahanPenolong);

        JMILaporanPersediaanBarang.setText("Laporan Persediaan Barang");
        JMILaporanPersediaanBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMILaporanPersediaanBarangActionPerformed(evt);
            }
        });
        JMLaporanProduksi.add(JMILaporanPersediaanBarang);

        JMILaporanIdentifikasiProdukJadi.setText("Laporan Indentifikasi Produk Jadi");
        JMILaporanIdentifikasiProdukJadi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMILaporanIdentifikasiProdukJadiActionPerformed(evt);
            }
        });
        JMLaporanProduksi.add(JMILaporanIdentifikasiProdukJadi);

        JMILaporanPenyerahanProdukJadi.setText("Laporan Penyerahan Produk Jadi");
        JMILaporanPenyerahanProdukJadi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMILaporanPenyerahanProdukJadiActionPerformed(evt);
            }
        });
        JMLaporanProduksi.add(JMILaporanPenyerahanProdukJadi);

        JMILaporanOrderPesanan.setText("Laporan Order Pesanan");
        JMILaporanOrderPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMILaporanOrderPesananActionPerformed(evt);
            }
        });
        JMLaporanProduksi.add(JMILaporanOrderPesanan);

        JMILaporanDataProduksi.setText("Laporan Data Produksi");
        JMILaporanDataProduksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMILaporanDataProduksiActionPerformed(evt);
            }
        });
        JMLaporanProduksi.add(JMILaporanDataProduksi);

        JMLaporan.add(JMLaporanProduksi);

        JMLaporanLab.setText("Laporan Laboratorium");

        JMILaporanPengujianProdukJadi.setText("Laporan Pengujian Produk Jadi");
        JMILaporanPengujianProdukJadi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMILaporanPengujianProdukJadiActionPerformed(evt);
            }
        });
        JMLaporanLab.add(JMILaporanPengujianProdukJadi);

        JMILaporanPengujianBahanBaku.setText("Laporan Pengujian Bahan Baku");
        JMILaporanPengujianBahanBaku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMILaporanPengujianBahanBakuActionPerformed(evt);
            }
        });
        JMLaporanLab.add(JMILaporanPengujianBahanBaku);

        JMLaporan.add(JMLaporanLab);

        JMLaporanTeknik.setText("Laporan Teknik");

        JMILaporanDaftarPeralatan.setText("Laporan Daftar Peralatan");
        JMILaporanDaftarPeralatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMILaporanDaftarPeralatanActionPerformed(evt);
            }
        });
        JMLaporanTeknik.add(JMILaporanDaftarPeralatan);

        JMILaporanPemeliharaan.setText("Laporan Pemeliharaan");
        JMILaporanPemeliharaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMILaporanPemeliharaanActionPerformed(evt);
            }
        });
        JMLaporanTeknik.add(JMILaporanPemeliharaan);

        JMLaporan.add(JMLaporanTeknik);

        JMLaporanPemasaran.setText("Laporan Pemasaran");

        JMILaporanPengaduanPelanggan.setText("Laporan Pengaduan Pelanggan");
        JMILaporanPengaduanPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMILaporanPengaduanPelangganActionPerformed(evt);
            }
        });
        JMLaporanPemasaran.add(JMILaporanPengaduanPelanggan);

        JMILaporanSurveyKepuasanPelanggan.setText("Laporan Survey Kepuasan Pelanggan");
        JMILaporanSurveyKepuasanPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMILaporanSurveyKepuasanPelangganActionPerformed(evt);
            }
        });
        JMLaporanPemasaran.add(JMILaporanSurveyKepuasanPelanggan);

        JMILaporanDataPenjualan.setText("Laporan Data Penjualan");
        JMLaporanPemasaran.add(JMILaporanDataPenjualan);

        JMLaporan.add(JMLaporanPemasaran);

        JMLaporanPersonalia.setText("Laporan Personalia");

        JMILaporanKebutuhanKaryawan.setText("Laporan Kebutuhan Karyawan");
        JMILaporanKebutuhanKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMILaporanKebutuhanKaryawanActionPerformed(evt);
            }
        });
        JMLaporanPersonalia.add(JMILaporanKebutuhanKaryawan);

        JMILaporanEvaluasiMasaPercobaanKaryawan.setText("Laporan Evaluasi Masa Percobaan Karyawan");
        JMLaporanPersonalia.add(JMILaporanEvaluasiMasaPercobaanKaryawan);

        JMILaporanDaftarRiwayatHidup.setText("Laporan Daftar Riwayat Hidup");
        JMLaporanPersonalia.add(JMILaporanDaftarRiwayatHidup);

        JMILaporanUsulPelatihan.setText("Laporan Usul Pelatihan");
        JMLaporanPersonalia.add(JMILaporanUsulPelatihan);

        JMILaporanProgramPelatihan.setText("Laporan Program Pelatihan");
        JMLaporanPersonalia.add(JMILaporanProgramPelatihan);

        JMILaporanCalonPesertaPelatihan.setText("Laporan Calon Peserta Pelatihan");
        JMLaporanPersonalia.add(JMILaporanCalonPesertaPelatihan);

        JMILaproanEvaluasiPelatihan.setText("Laporan Evaluasi Pelatihan");
        JMLaporanPersonalia.add(JMILaproanEvaluasiPelatihan);

        JMLaporan.add(JMLaporanPersonalia);

        JMenuBar.add(JMLaporan);

        setJMenuBar(JMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMITambahUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMITambahUserActionPerformed
        if (tambahUser == null) {
            tambahUser = new TambahUser();
        } else {
            tambahUser.setState(NORMAL);
            tambahUser.toFront();
        }
    }//GEN-LAST:event_JMITambahUserActionPerformed

    private void JMIGantiPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIGantiPasswordActionPerformed
        if (gantiPassword == null) {
            gantiPassword = new GantiPassword();
        } else {
            gantiPassword.setState(NORMAL);
            gantiPassword.toFront();
        }
    }//GEN-LAST:event_JMIGantiPasswordActionPerformed

    private void JMIExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_JMIExitActionPerformed

    private void JMIResetPasswordUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIResetPasswordUserActionPerformed
        if (resetPasswordUser == null) {
            resetPasswordUser = new ResetPasswordUser();
        } else {
            resetPasswordUser.setState(NORMAL);
            resetPasswordUser.toFront();
        }
    }//GEN-LAST:event_JMIResetPasswordUserActionPerformed

    private void JMIListPengujianProdukJadiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIListPengujianProdukJadiActionPerformed
        if (listPengujianProdukJadi == null) {
            listPengujianProdukJadi = new List(JMIListPengujianProdukJadi.getText());
        } else {
            listPengujianProdukJadi.setState(NORMAL);
            listPengujianProdukJadi.toFront();
        }
    }//GEN-LAST:event_JMIListPengujianProdukJadiActionPerformed

    private void JMIPengujianProdukJadiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIPengujianProdukJadiActionPerformed
        if (tambahPengujianProdukJadi == null) {
            tambahPengujianProdukJadi = new PengujianProdukJadi();
        } else {
            tambahPengujianProdukJadi.setState(NORMAL);
            tambahPengujianProdukJadi.toFront();
        }
    }//GEN-LAST:event_JMIPengujianProdukJadiActionPerformed

    private void JMIListPengujianBahanBakuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIListPengujianBahanBakuActionPerformed
        if (listPengujianBahanBaku == null) {
            listPengujianBahanBaku = new List(JMIListPengujianBahanBaku.getText());
        } else {
            listPengujianBahanBaku.setState(NORMAL);
            listPengujianBahanBaku.toFront();
        }
    }//GEN-LAST:event_JMIListPengujianBahanBakuActionPerformed

    private void JMIPengujianBahanBakuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIPengujianBahanBakuActionPerformed
        if (tambahPengujianBahanBaku == null) {
            tambahPengujianBahanBaku = new PengujianBahanBaku();
        } else {
            tambahPengujianBahanBaku.setState(NORMAL);
            tambahPengujianBahanBaku.toFront();
        }
    }//GEN-LAST:event_JMIPengujianBahanBakuActionPerformed

    private void JMILaporanPengujianProdukJadiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMILaporanPengujianProdukJadiActionPerformed
        if (laporanPengujianProdukJadi == null) {
            laporanPengujianProdukJadi = new LaporanLab(JMILaporanPengujianProdukJadi.getText());
        } else {
            laporanPengujianProdukJadi.setState(NORMAL);
            laporanPengujianProdukJadi.toFront();
        }
    }//GEN-LAST:event_JMILaporanPengujianProdukJadiActionPerformed

    private void JMILaporanPengujianBahanBakuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMILaporanPengujianBahanBakuActionPerformed
        if (laporanPengujianBahanBaku == null) {
            laporanPengujianBahanBaku = new LaporanLab(JMILaporanPengujianBahanBaku.getText());
        } else {
            laporanPengujianBahanBaku.setState(NORMAL);
            laporanPengujianBahanBaku.toFront();
        }
    }//GEN-LAST:event_JMILaporanPengujianBahanBakuActionPerformed

    private void JMIBarangTeknikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIBarangTeknikActionPerformed
        if (tambahBarangTeknik == null) {
            tambahBarangTeknik = new BarangTeknik();
        } else {
            tambahBarangTeknik.setState(NORMAL);
            tambahBarangTeknik.toFront();
        }
    }//GEN-LAST:event_JMIBarangTeknikActionPerformed

    private void JMIPemeliharaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIPemeliharaanActionPerformed
        if (tambahPemeliharaan == null) {
            tambahPemeliharaan = new Pemeliharaan();
        } else {
            tambahPemeliharaan.setState(NORMAL);
            tambahPemeliharaan.toFront();
        }
    }//GEN-LAST:event_JMIPemeliharaanActionPerformed

    private void JMIListBarangTeknikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIListBarangTeknikActionPerformed
        if (listBarangTeknik == null) {
            listBarangTeknik = new List(JMIBarangTeknik.getText());
        } else {
            listBarangTeknik.setState(NORMAL);
            listBarangTeknik.toFront();
        }
    }//GEN-LAST:event_JMIListBarangTeknikActionPerformed

    private void JMIListPemeliharaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIListPemeliharaanActionPerformed
        if (listPemeliharaan == null) {
            listPemeliharaan = new List(JMIListPemeliharaan.getText());
        } else {
            listPemeliharaan.setState(NORMAL);
            listPemeliharaan.toFront();
        }
    }//GEN-LAST:event_JMIListPemeliharaanActionPerformed

    private void JMILaporanDaftarPeralatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMILaporanDaftarPeralatanActionPerformed
        if (laporanDaftarPeralatan == null) {
            laporanDaftarPeralatan = new LaporanTeknik(JMILaporanDaftarPeralatan.getText());
        } else {
            laporanDaftarPeralatan.setState(NORMAL);
            laporanDaftarPeralatan.toFront();
        }
    }//GEN-LAST:event_JMILaporanDaftarPeralatanActionPerformed

    private void JMILaporanPemeliharaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMILaporanPemeliharaanActionPerformed
        if (laporanPemeliharaan == null) {
            laporanPemeliharaan = new LaporanTeknik(JMILaporanPemeliharaan.getText());
        } else {
            laporanPemeliharaan.setState(NORMAL);
            laporanPemeliharaan.toFront();
        }
    }//GEN-LAST:event_JMILaporanPemeliharaanActionPerformed

    private void JMILaporanIdentifikasiProdukJadiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMILaporanIdentifikasiProdukJadiActionPerformed
        if (laporanIndentifikasiProdukJadi == null) {
            laporanIndentifikasiProdukJadi = new LaporanProduksi(JMILaporanIdentifikasiProdukJadi.getText());
        } else {
            laporanIndentifikasiProdukJadi.setState(NORMAL);
            laporanIndentifikasiProdukJadi.toFront();
        }
    }//GEN-LAST:event_JMILaporanIdentifikasiProdukJadiActionPerformed

    private void JMILaporanPenyerahanProdukJadiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMILaporanPenyerahanProdukJadiActionPerformed
        if (laporanPenyerahanProdukJadi == null) {
            laporanPenyerahanProdukJadi = new LaporanProduksi(JMILaporanPenyerahanProdukJadi.getText());
        } else {
            laporanPenyerahanProdukJadi.setState(NORMAL);
            laporanPenyerahanProdukJadi.toFront();
        }
    }//GEN-LAST:event_JMILaporanPenyerahanProdukJadiActionPerformed

    private void JMILaporanDataProduksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMILaporanDataProduksiActionPerformed
        if (laporanDataProduksi == null) {
            laporanDataProduksi = new LaporanProduksi(JMILaporanDataProduksi.getText());
        } else {
            laporanDataProduksi.setState(NORMAL);
            laporanDataProduksi.toFront();
        }
    }//GEN-LAST:event_JMILaporanDataProduksiActionPerformed

    private void JMILaporanOrderPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMILaporanOrderPesananActionPerformed
        if (laporanOrderPesanan == null) {
            laporanOrderPesanan = new LaporanProduksi(JMILaporanOrderPesanan.getText());
        } else {
            laporanOrderPesanan.setState(NORMAL);
            laporanOrderPesanan.toFront();
        }
    }//GEN-LAST:event_JMILaporanOrderPesananActionPerformed

    private void JMILaporanPersediaanBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMILaporanPersediaanBarangActionPerformed
        if (laporanPersediaanBarang == null) {
            laporanPersediaanBarang = new LaporanProduksi(JMILaporanPersediaanBarang.getText());
        } else {
            laporanPersediaanBarang.setState(NORMAL);
            laporanPersediaanBarang.toFront();
        }
    }//GEN-LAST:event_JMILaporanPersediaanBarangActionPerformed

    private void JMISurveyKepuasanPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (tambahSurveyKepuasanPelanggan == null) {
            tambahSurveyKepuasanPelanggan = new SurveyKepuasanPelanggan();
        } else {
            tambahSurveyKepuasanPelanggan.setState(NORMAL);
            tambahSurveyKepuasanPelanggan.toFront();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if (listSurveyKepuasanPelanggan == null) {
            listSurveyKepuasanPelanggan = new List(jMenuItem5.getText());
        } else {
            listSurveyKepuasanPelanggan.setState(NORMAL);
            listSurveyKepuasanPelanggan.toFront();
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void JMIPengaduanPelangganActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        if (tambahPengaduanPelanggan == null) {
            tambahPengaduanPelanggan = new PengaduanPelanggan();
        } else {
            tambahPengaduanPelanggan.setState(NORMAL);
            tambahPengaduanPelanggan.toFront();
        }
    }                                                     

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (listPengaduanPelanggan == null) {
            listPengaduanPelanggan = new List(jMenuItem4.getText());
        } else {
            listPengaduanPelanggan.setState(NORMAL);
            listPengaduanPelanggan.toFront();
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed
	
    private void JMILaporanKebutuhanKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMILaporanKebutuhanKaryawanActionPerformed
        if (laporanKebutuhanKaryawan == null) {
            laporanKebutuhanKaryawan = new LaporanPersonalia(JMILaporanKebutuhanKaryawan.getText());
        } else {
            laporanKebutuhanKaryawan.setState(NORMAL);
            laporanKebutuhanKaryawan.toFront();
        }
    }//GEN-LAST:event_JMILaporanKebutuhanKaryawanActionPerformed

    private void JMIDataPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIDataPenjualanActionPerformed
        
    }//GEN-LAST:event_JMIDataPenjualanActionPerformed

    private void JMIKebutuhanKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIKebutuhanKaryawanActionPerformed
        if (tambahKebutuhanKaryawan == null) {
            tambahKebutuhanKaryawan = new KebutuhanKaryawan();
        } else {
            tambahKebutuhanKaryawan.setState(NORMAL);
            tambahKebutuhanKaryawan.toFront();
        }
    }//GEN-LAST:event_JMIKebutuhanKaryawanActionPerformed

    private void JMIListKebutuhanKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIListKebutuhanKaryawanActionPerformed
        if (listKebutuhanKaryawan == null) {
            listKebutuhanKaryawan = new List(JMIListKebutuhanKaryawan.getText());
        } else {
            listKebutuhanKaryawan.setState(NORMAL);
            listKebutuhanKaryawan.toFront();
        }
    }//GEN-LAST:event_JMIListKebutuhanKaryawanActionPerformed

    private void JMILaporanSurveyKepuasanPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMILaporanSurveyKepuasanPelangganActionPerformed
        if (laporanSurveyKepuasanPelanggan == null) {
            laporanSurveyKepuasanPelanggan = new LaporanPemasaran(JMILaporanSurveyKepuasanPelanggan.getText());
        }
    }//GEN-LAST:event_JMILaporanSurveyKepuasanPelangganActionPerformed

    private void JMILaporanPengaduanPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMILaporanPengaduanPelangganActionPerformed
        if (laporanPengaduanPelanggan == null) {
            laporanPengaduanPelanggan = new LaporanPemasaran(JMILaporanPengaduanPelanggan.getText());
        }
    }//GEN-LAST:event_JMILaporanPengaduanPelangganActionPerformed

    private void JMILaporanBahanBakuBahanPenolongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMILaporanBahanBakuBahanPenolongActionPerformed
        if (laporanBahanBakuBahanPenolong == null) {
            laporanBahanBakuBahanPenolong = new LaporanProduksi(JMILaporanBahanBakuBahanPenolong.getText());
        } else {
            laporanBahanBakuBahanPenolong.setState(NORMAL);
            laporanBahanBakuBahanPenolong.toFront();
        }
    }//GEN-LAST:event_JMILaporanBahanBakuBahanPenolongActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JMFile;
    private javax.swing.JMenuItem JMIBarangTeknik;
    private javax.swing.JMenuItem JMIDataPenjualan;
    private javax.swing.JMenuItem JMIExit;
    private javax.swing.JMenuItem JMIGantiPassword;
    private javax.swing.JMenuItem JMIKebutuhanKaryawan;
    private javax.swing.JMenuItem JMILaporanBahanBakuBahanPenolong;
    private javax.swing.JMenuItem JMILaporanCalonPesertaPelatihan;
    private javax.swing.JMenuItem JMILaporanDaftarPeralatan;
    private javax.swing.JMenuItem JMILaporanDaftarRiwayatHidup;
    private javax.swing.JMenuItem JMILaporanDataPenjualan;
    private javax.swing.JMenuItem JMILaporanDataProduksi;
    private javax.swing.JMenuItem JMILaporanEvaluasiMasaPercobaanKaryawan;
    private javax.swing.JMenuItem JMILaporanIdentifikasiProdukJadi;
    private javax.swing.JMenuItem JMILaporanKebutuhanKaryawan;
    private javax.swing.JMenuItem JMILaporanOrderPesanan;
    private javax.swing.JMenuItem JMILaporanPemeliharaan;
    private javax.swing.JMenuItem JMILaporanPengaduanPelanggan;
    private javax.swing.JMenuItem JMILaporanPengujianBahanBaku;
    private javax.swing.JMenuItem JMILaporanPengujianProdukJadi;
    private javax.swing.JMenuItem JMILaporanPenyerahanProdukJadi;
    private javax.swing.JMenuItem JMILaporanPersediaanBarang;
    private javax.swing.JMenuItem JMILaporanProgramPelatihan;
    private javax.swing.JMenuItem JMILaporanSurveyKepuasanPelanggan;
    private javax.swing.JMenuItem JMILaporanUsulPelatihan;
    private javax.swing.JMenuItem JMILaproanEvaluasiPelatihan;
    private javax.swing.JMenuItem JMIListBarangTeknik;
    private javax.swing.JMenuItem JMIListKebutuhanKaryawan;
    private javax.swing.JMenuItem JMIListPemeliharaan;
    private javax.swing.JMenuItem JMIListPengujianBahanBaku;
    private javax.swing.JMenuItem JMIListPengujianProdukJadi;
    private javax.swing.JMenuItem JMIPemeliharaan;
    private javax.swing.JMenuItem JMIPengaduanPelanggan;
    private javax.swing.JMenuItem JMIPengujianBahanBaku;
    private javax.swing.JMenuItem JMIPengujianProdukJadi;
    private javax.swing.JMenuItem JMIResetPasswordUser;
    private javax.swing.JMenuItem JMISurveyKepuasanPelanggan;
    private javax.swing.JMenuItem JMITambahUser;
    private javax.swing.JMenu JMLaporan;
    private javax.swing.JMenu JMLaporanLab;
    private javax.swing.JMenu JMLaporanPemasaran;
    private javax.swing.JMenu JMLaporanPersonalia;
    private javax.swing.JMenu JMLaporanProduksi;
    private javax.swing.JMenu JMLaporanTeknik;
    private javax.swing.JMenu JMList;
    private javax.swing.JMenu JMListLab;
    private javax.swing.JMenu JMListPersonalia;
    private javax.swing.JMenu JMListTeknik;
    private javax.swing.JMenu JMProses;
    private javax.swing.JMenu JMProsesLab;
    private javax.swing.JMenu JMProsesPemasaran;
    private javax.swing.JMenu JMProsesPersonalia;
    private javax.swing.JMenu JMProsesTeknik;
    private javax.swing.JMenuBar JMenuBar;
    private javax.swing.JPopupMenu.Separator SFile;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    // End of variables declaration//GEN-END:variables
}
