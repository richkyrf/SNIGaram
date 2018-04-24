/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import static GlobalVar.Var.*;
import LaporanLab.LaporanLab;
import LaporanProduksi.LaporanProduksi;
import LaporanTeknik.LaporanTeknik;
import List.*;
import ProsesTeknik.BarangTeknik;
import ProsesLab.*;
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
        jMenu2 = new javax.swing.JMenu();
        JMProsesLab = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        JMMaster = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        JMListLab = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        JMLaporanProduksi = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        JMLaporanLab = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();

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

        jMenu2.setText("Proses");

        JMProsesLab.setText("Proses Lab");

        jMenuItem2.setText("Pengujian Produk Jadi");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        JMProsesLab.add(jMenuItem2);

        jMenuItem4.setText("Pengujian Bahan Baku");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        JMProsesLab.add(jMenuItem4);

        jMenu2.add(JMProsesLab);

        JMMaster.setText("Proses Teknik");

        jMenuItem7.setText("Barang Teknik");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        JMMaster.add(jMenuItem7);

        jMenuItem11.setText("Pemeliharaan");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        JMMaster.add(jMenuItem11);

        jMenu2.add(JMMaster);

        JMenuBar.add(jMenu2);

        jMenu3.setText("List");

        JMListLab.setText("List Lab");

        jMenuItem1.setText("Pengujian Produk Jadi");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        JMListLab.add(jMenuItem1);

        jMenuItem3.setText("Pengujian Bahan Baku");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        JMListLab.add(jMenuItem3);

        jMenu3.add(JMListLab);

        jMenu1.setText("List Teknik");

        jMenuItem12.setText("Barang Teknik");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

        jMenuItem13.setText("Pemeliharaan");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);

        jMenu3.add(jMenu1);

        JMenuBar.add(jMenu3);

        jMenu4.setText("Laporan");

        JMLaporanProduksi.setText("Laporan Produksi");

        jMenuItem8.setText("Laporan Indentifikasi Produk Jadi");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        JMLaporanProduksi.add(jMenuItem8);

        jMenuItem9.setText("Laporan Penyerahan Produk Jadi");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        JMLaporanProduksi.add(jMenuItem9);

        jMenuItem10.setText("Laporan Data Produksi");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        JMLaporanProduksi.add(jMenuItem10);

        jMenu4.add(JMLaporanProduksi);

        JMLaporanLab.setText("Laporan Lab");

        jMenuItem5.setText("Laporan Pengujian Produk Jadi");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        JMLaporanLab.add(jMenuItem5);

        jMenuItem6.setText("Laporan Pengujian Bahan Baku");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        JMLaporanLab.add(jMenuItem6);

        jMenu4.add(JMLaporanLab);

        jMenu5.setText("Laporan Teknik");

        jMenuItem14.setText("Laporan Daftar Barang");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem14);

        jMenuItem15.setText("Laporan Pemeliharaan");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem15);

        jMenu4.add(jMenu5);

        JMenuBar.add(jMenu4);

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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (listPengujianProdukJadi == null) {
            listPengujianProdukJadi = new List(jMenuItem1.getText());
        } else {
            listPengujianProdukJadi.setState(NORMAL);
            listPengujianProdukJadi.toFront();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (tambahPengujianProdukJadi == null) {
            tambahPengujianProdukJadi = new PengujianProdukJadi();
        } else {
            tambahPengujianProdukJadi.setState(NORMAL);
            tambahPengujianProdukJadi.toFront();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (listPengujianBahanBaku == null) {
            listPengujianBahanBaku = new List(jMenuItem3.getText());
        } else {
            listPengujianBahanBaku.setState(NORMAL);
            listPengujianBahanBaku.toFront();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (tambahPengujianBahanBaku == null) {
            tambahPengujianBahanBaku = new PengujianBahanBaku();
        } else {
            tambahPengujianBahanBaku.setState(NORMAL);
            tambahPengujianBahanBaku.toFront();
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if (laporanPengujianProdukJadi == null) {
            laporanPengujianProdukJadi = new LaporanLab(jMenuItem5.getText());
        } else {
            laporanPengujianProdukJadi.setState(NORMAL);
            laporanPengujianProdukJadi.toFront();
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if (laporanPengujianBahanBaku == null) {
            laporanPengujianBahanBaku = new LaporanLab(jMenuItem6.getText());
        } else {
            laporanPengujianBahanBaku.setState(NORMAL);
            laporanPengujianBahanBaku.toFront();
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if (tambahBarangTeknik == null) {
            tambahBarangTeknik = new BarangTeknik();
        } else {
            tambahBarangTeknik.setState(NORMAL);
            tambahBarangTeknik.toFront();
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        if (tambahPemeliharaan == null) {
            tambahPemeliharaan = new Pemeliharaan();
        } else {
            tambahPemeliharaan.setState(NORMAL);
            tambahPemeliharaan.toFront();
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        if (listBarangTeknik == null) {
            listBarangTeknik = new List(jMenuItem7.getText());
        } else {
            listBarangTeknik.setState(NORMAL);
            listBarangTeknik.toFront();
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        if (listPemeliharaan == null) {
            listPemeliharaan = new List(jMenuItem13.getText());
        } else {
            listPemeliharaan.setState(NORMAL);
            listPemeliharaan.toFront();
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        if (laporanDaftarBarang == null) {
            laporanDaftarBarang = new LaporanTeknik(jMenuItem14.getText());
        } else {
            laporanDaftarBarang.setState(NORMAL);
            laporanDaftarBarang.toFront();
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        if (laporanPemeliharaan == null) {
            laporanPemeliharaan = new LaporanTeknik(jMenuItem15.getText());
        } else {
            laporanPemeliharaan.setState(NORMAL);
            laporanPemeliharaan.toFront();
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {
        if (laporanIndentifikasiProdukJadi == null) {
            laporanIndentifikasiProdukJadi = new LaporanProduksi(jMenuItem8.getText());
        } else {
            laporanIndentifikasiProdukJadi.setState(NORMAL);
            laporanIndentifikasiProdukJadi.toFront();
        }
    }

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {
        if (laporanPenyerahanProdukJadi == null) {
            laporanPenyerahanProdukJadi = new LaporanProduksi(jMenuItem9.getText());
        } else {
            laporanPenyerahanProdukJadi.setState(NORMAL);
            laporanPenyerahanProdukJadi.toFront();
        }
    }

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {
        if (laporanDataProduksi == null) {
            laporanDataProduksi = new LaporanProduksi(jMenuItem10.getText());
        } else {
            laporanDataProduksi.setState(NORMAL);
            laporanDataProduksi.toFront();
        }
    }

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
    private javax.swing.JMenuItem JMIExit;
    private javax.swing.JMenuItem JMIGantiPassword;
    private javax.swing.JMenuItem JMIResetPasswordUser;
    private javax.swing.JMenuItem JMITambahUser;
    private javax.swing.JMenu JMLaporanLab;
    private javax.swing.JMenu JMLaporanProduksi;
    private javax.swing.JMenu JMListLab;
    private javax.swing.JMenu JMMaster;
    private javax.swing.JMenu JMProsesLab;
    private javax.swing.JMenuBar JMenuBar;
    private javax.swing.JPopupMenu.Separator SFile;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
