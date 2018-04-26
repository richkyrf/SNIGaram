/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import LSubProces.Delete;
import javax.swing.JOptionPane;
import KomponenGUI.FDateF;
import LSubProces.Insert;
import java.util.Date;
import static GlobalVar.Var.*;
import ProsesTeknik.BarangTeknik;
import ProsesLab.*;
import ProsesPemasran.SurveyKepuasanPelanggan;
import ProsesTeknik.Pemeliharaan;

/**
 *
 * @author richky
 */
public class List extends javax.swing.JFrame {

    /**
     * Creates new form ListKaryawan
     */

    public List(String type) {
        initComponents();
        setVisible(true);
        setTitle("List " + type);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        refreshAll();
        if (!GlobalVar.VarL.level.equals("Administrator")) {
            jbuttonF2.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbuttonF1 = new KomponenGUI.JbuttonF();
        jbuttonF2 = new KomponenGUI.JbuttonF();
        jbuttonF3 = new KomponenGUI.JbuttonF();
        jbuttonF4 = new KomponenGUI.JbuttonF();
        jcomCari1 = new KomponenGUI.JcomCari();
        jbuttonF5 = new KomponenGUI.JbuttonF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jbuttonF1.setText("Ubah");
        jbuttonF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF1ActionPerformed(evt);
            }
        });

        jbuttonF2.setText("Hapus");
        jbuttonF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF2ActionPerformed(evt);
            }
        });

        jbuttonF3.setText("Refresh");
        jbuttonF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF3ActionPerformed(evt);
            }
        });

        jbuttonF4.setText("Kembali");
        jbuttonF4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF4ActionPerformed(evt);
            }
        });

        jbuttonF5.setText("Tambah");
        jbuttonF5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcomCari1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbuttonF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcomCari1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuttonF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF1ActionPerformed
        ubah();
    }//GEN-LAST:event_jbuttonF1ActionPerformed

    private void jbuttonF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF4ActionPerformed
        dispose();
    }//GEN-LAST:event_jbuttonF4ActionPerformed

    private void jbuttonF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF2ActionPerformed
        hapus();
    }//GEN-LAST:event_jbuttonF2ActionPerformed

    private void jbuttonF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF3ActionPerformed
        refreshAll();
    }//GEN-LAST:event_jbuttonF3ActionPerformed

    private void jbuttonF5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF5ActionPerformed
        tambah();
    }//GEN-LAST:event_jbuttonF5ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        switch (getTitle()) {
            case "List Pengujian Produk Jadi":
                listPengujianProdukJadi = null;
                break;
            case "List Pengujian Bahan Baku":
                listPengujianBahanBaku = null;
                break;
            case "List Barang Teknik":
                listBarangTeknik = null;
                break;
            case "List Pemeliharaan":
                listPemeliharaan = null;
                break;
            case "List Pengaduan Pelanggan":
                listPengaduanPelanggan = null;
                break;
            case "List Survey Kepuasan Pelanggan":
                listSurveyKepuasanPelanggan = null;
                break;
            case "List Data Penjualan":
                listDataPenjualan = null;
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new List("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF jbuttonF1;
    private KomponenGUI.JbuttonF jbuttonF2;
    private KomponenGUI.JbuttonF jbuttonF3;
    private KomponenGUI.JbuttonF jbuttonF4;
    private KomponenGUI.JbuttonF jbuttonF5;
    private KomponenGUI.JcomCari jcomCari1;
    // End of variables declaration//GEN-END:variables

    void refreshAll() {
        jcomCari1.refresh();
        load();
    }

    void tambah() {
        switch (getTitle()) {
            case "List Pengujian Produk Jadi":
                if (tambahPengujianProdukJadi == null) {
                    tambahPengujianProdukJadi = new PengujianProdukJadi();
                } else {
                    tambahPengujianProdukJadi.setState(NORMAL);
                    tambahPengujianProdukJadi.toFront();
                }
                break;
            case "List Pengujian Bahan Baku":
                if (tambahPengujianBahanBaku == null) {
                    tambahPengujianBahanBaku = new PengujianBahanBaku();
                } else {
                    tambahPengujianBahanBaku.setState(NORMAL);
                    tambahPengujianBahanBaku.toFront();
                }
                break;
            case "List Barang Teknik":
                if (tambahBarangTeknik == null) {
                    tambahBarangTeknik = new BarangTeknik();
                } else {
                    tambahBarangTeknik.setState(NORMAL);
                    tambahBarangTeknik.toFront();
                }
                break;
            case "List Pemeliharaan":
                if (tambahPemeliharaan == null) {
                    tambahPemeliharaan = new Pemeliharaan();
                } else {
                    tambahPemeliharaan.setState(NORMAL);
                    tambahPemeliharaan.toFront();
                }
                break;
            case "List Pengaduan Pelanggan":
//                if (tambahPengaduanPelanggan == null) {
//                    tambahPengaduanPelanggan = new PengaduanPelanggan();
//                } else {
//                    tambahPengaduanPelanggan.setState(NORMAL);
//                    tambahPengaduanPelanggan.toFront();
//                }
                break;
            case "List Survey Kepuasan Pelanggan":
                if (tambahSurveyKepuasanPelanggan == null) {
                    tambahSurveyKepuasanPelanggan = new SurveyKepuasanPelanggan();
                } else {
                    tambahSurveyKepuasanPelanggan.setState(NORMAL);
                    tambahSurveyKepuasanPelanggan.toFront();
                }
                break;
            case "List Data Penjualan":
//                if (tambahDataPenjualan == null) {
//                    tambahDataPenjualan = new DataPenjualan();
//                } else {
//                    tambahDataPenjualan.setState(NORMAL);
//                    tambahDataPenjualan.toFront();
//                }
                break;
            default:
                throw new AssertionError();
        }

    }

    void hapus() {
        if (jcomCari1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Terlebih Dahulu", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Delete delete = new Delete();
            Boolean berhasil = false;
            switch (getTitle()) {
                case "List Pengujian Produk Jadi":
                    berhasil = delete.Hapus(jcomCari1.GetIDTable(), "DELETE FROM `snitbpengujianprodukjadi` WHERE `IdPengujianProdukJadi` = " + jcomCari1.GetIDTable(), getTitle(), this);
                    break;
                case "List Pengujian Bahan Baku":
                    berhasil = delete.Hapus(jcomCari1.GetIDTable(), "DELETE FROM `snitbpengujianbahanbaku` WHERE `IdPengujianBahanBaku` = " + jcomCari1.GetIDTable(), getTitle(), this);
                    break;
                case "List Barang Teknik":
                    berhasil = delete.Hapus(jcomCari1.GetIDTable(), "DELETE FROM `snitbmbarangteknik` WHERE `IdBarangTeknik` = " + jcomCari1.GetIDTable(), getTitle(), this);
                    break;
                case "List Pemeliharaan":
                    berhasil = delete.Hapus(jcomCari1.GetIDTable(), "DELETE FROM `snitbpemeliharaan` WHERE `IdPemeliharaan` = " + jcomCari1.GetIDTable(), getTitle(), this);
                    break;
                case "List Pengaduan Pelanggan":
                    berhasil = delete.Hapus(jcomCari1.GetIDTable(), "DELETE FROM `snitbpengaduanpelanggan` WHERE `IdPengaduanPelanggan` = " + jcomCari1.GetIDTable(), getTitle(), this);
                    break;
                case "List Survey Kepuasan Pelanggan":
                    berhasil = delete.Hapus(jcomCari1.GetIDTable(), "DELETE FROM `snitbsurveykepuasanpelanggan` WHERE `IdSurveyKepuasanPelanggan` = " + jcomCari1.GetIDTable(), getTitle(), this);
                    break;
                case "List Data Penjualan":
                    berhasil = delete.Hapus(jcomCari1.GetIDTable(), "DELETE FROM `snitbdatapenjualan` WHERE `IdDataPenjualan` = " + jcomCari1.GetIDTable(), getTitle(), this);
                    break;
                default:
                    throw new AssertionError();
            }
            if (berhasil) {
                refreshAll();
            }
        }
    }

    void ubah() {
        if (jcomCari1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Data Terlebih Dahulu", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            switch (getTitle()) {
                case "List Pengujian Produk Jadi":
                    if (ubahPengujianProdukJadi == null) {
                        ubahPengujianProdukJadi = new PengujianProdukJadi(jcomCari1.GetIDTable());
                    } else {
                        ubahPengujianProdukJadi.setState(NORMAL);
                        ubahPengujianProdukJadi.toFront();
                    }
                    break;
                case "List Pengujian Bahan Baku":
                    if (ubahPengujianBahanBaku == null) {
                        ubahPengujianBahanBaku = new PengujianBahanBaku(jcomCari1.GetIDTable());
                    } else {
                        ubahPengujianBahanBaku.setState(NORMAL);
                        ubahPengujianBahanBaku.toFront();
                    }
                    break;
                case "List Barang Teknik":
                    if (ubahBarangTeknik == null) {
                        ubahBarangTeknik = new BarangTeknik(jcomCari1.GetIDTable());
                    } else {
                        ubahBarangTeknik.setState(NORMAL);
                        ubahBarangTeknik.toFront();
                    }
                    break;
                case "List Pemeliharaan":
                    if (ubahPemeliharaan == null) {
                        ubahPemeliharaan = new Pemeliharaan(jcomCari1.GetIDTable());
                    } else {
                        ubahPemeliharaan.setState(NORMAL);
                        ubahPemeliharaan.toFront();
                    }
                    break;
                case "List Pengaduan Pelanggan":
//                    if (ubahPengaduanPelanggan == null) {
//                        ubahPengaduanPelanggan = new PengaduanPelanggan(jcomCari1.GetIDTable());
//                    } else {
//                        ubahPengaduanPelanggan.setState(NORMAL);
//                        ubahPengaduanPelanggan.toFront();
//                    }
                    break;
                case "List Survey Kepuasan Pelanggan":
                    if (ubahSurveyKepuasanPelanggan == null) {
                        ubahSurveyKepuasanPelanggan = new SurveyKepuasanPelanggan(jcomCari1.GetIDTable());
                    } else {
                        ubahSurveyKepuasanPelanggan.setState(NORMAL);
                        ubahSurveyKepuasanPelanggan.toFront();
                    }
                    break;
                case "List Data Penjualan":
//                    if (ubahDataPenjualan == null) {
//                        ubahDataPenjualan = new DataPenjualan(jcomCari1.GetIDTable());
//                    } else {
//                        ubahDataPenjualan.setState(NORMAL);
//                        ubahDataPenjualan.toFront();
//                    }
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    public void load() {
        switch (getTitle()) {
            case "List Pengujian Produk Jadi":
                jcomCari1.setQuery("SELECT `IdPengujianProdukJadi` as 'ID', DATE_FORMAT(`Tanggal`,'%d-%m-%Y') as 'Tanggal',REPLACE(`KadarKIO3`,'.',',') as 'Kadar KIO3', REPLACE(`KadarAir`,'.',',') as 'Kadar Air', REPLACE(`KadarNaCl`,'.',',') as 'Kadar NaCl', `Warna`, `Penguji`, `Keterangan` FROM `snitbpengujianprodukjadi` WHERE 1");
                jcomCari1.setRender(new int[]{2, 3, 4}, new String[]{"Decimal", "Decimal", "Decimal"});
                jcomCari1.setOrder(" ORDER BY `Tanggal` ");
                break;
            case "List Pengujian Bahan Baku":
                jcomCari1.setQuery("SELECT `IdPengujianBahanBaku` as 'ID', DATE_FORMAT(`Tanggal`,'%d-%m-%Y') as 'Tanggal', REPLACE(`KadarAir`,'.',',') as 'Kadar Air', REPLACE(`KadarNaCl`,'.',',') as 'Kadar NaCl', `Warna`, `Penguji`, `Keterangan` FROM `snitbpengujianbahanbaku` WHERE 1");
                jcomCari1.setRender(new int[]{3, 4}, new String[]{"Decimal", "Decimal"});
                jcomCari1.setOrder(" ORDER BY `Tanggal` ");
                break;
            case "List Barang Teknik":
                jcomCari1.setQuery("SELECT `IdBarangTeknik` as 'ID', `NamaBarang` as 'Nama Barang', `Merk`, `Jumlah`, DATE_FORMAT(`WaktuKalibrasi`,'%d-%m-%Y') as 'Waktu Kalibrasi', `Keterangan`, IF(`Status`=1,'Aktif','Tidak Aktif') as 'Status' FROM `snitbmbarangteknik` WHERE 1");
                jcomCari1.setRender(new int[]{3}, new String[]{"Number"});
                jcomCari1.setOrder(" ORDER BY `NamaBarang` ");
                break;
            case "List Pemeliharaan":
                jcomCari1.setQuery("SELECT `IdPemeliharaan` as 'ID', DATE_FORMAT(`Tanggal`,'%d-%m-%Y') as 'Tanggal', `NamaBarang` as 'Nama Barang', `Deskripsi`, a.`Keterangan` FROM `snitbpemeliharaan`a JOIN `snitbmbarangteknik`b ON a.`IdBarangTeknik`=b.`IdBarangTeknik` WHERE 1");
                jcomCari1.setOrder(" ORDER BY `Tanggal` DESC ");
                break;
            case "List Pengaduan Pelanggan":
                jcomCari1.setQuery("SELECT `IdPemeliharaan` as 'ID', DATE_FORMAT(`Tanggal`,'%d-%m-%Y') as 'Tanggal', `NamaBarang` as 'Nama Barang', `Deskripsi`, a.`Keterangan` FROM `snitbpemeliharaan`a JOIN `snitbmbarangteknik`b ON a.`IdBarangTeknik`=b.`IdBarangTeknik` WHERE 1");
                jcomCari1.setOrder(" ORDER BY `Tanggal` DESC ");
                break;
            case "List Survey Kepuasan Pelanggan":
                jcomCari1.setQuery("SELECT `IdSurveyKepuasanPelanggan` as 'ID', `NamaPerusahaan` as 'Nama Perusahaan', `Alamat`, DATE_FORMAT(`Tanggal`,'%d-%m-%Y') as 'Tanggal', `NamaPelanggan` as 'Nama Pelanggan', `Nilai`, `CatatanDariPelanggan` as 'Catatan Dari Pelanggan' FROM `snitbsurveykepuasanpelanggan` WHERE 1");
                jcomCari1.setOrder(" ORDER BY `Tanggal` DESC ");
                break;
            case "List Data Penjualan":
                jcomCari1.setQuery("SELECT `IdPemeliharaan` as 'ID', DATE_FORMAT(`Tanggal`,'%d-%m-%Y') as 'Tanggal', `NamaBarang` as 'Nama Barang', `Deskripsi`, a.`Keterangan` FROM `snitbpemeliharaan`a JOIN `snitbmbarangteknik`b ON a.`IdBarangTeknik`=b.`IdBarangTeknik` WHERE 1");
                jcomCari1.setOrder(" ORDER BY `Tanggal` DESC ");
                break;
            default:
                throw new AssertionError();
        }
        jcomCari1.tampilkan();
    }

}
