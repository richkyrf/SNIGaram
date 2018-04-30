/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProsesPersonalia;

import KomponenGUI.FDateF;
import LSubProces.DRunSelctOne;
import LSubProces.Insert;
import LSubProces.Update;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import static GlobalVar.Var.*;

/**
 *
 * @author Gudang Garam
 */
public class KebutuhanKaryawan extends javax.swing.JFrame {

    /**
     * Creates new form PengujianBahanBaku
     */
    String IdEdit;

    public KebutuhanKaryawan() {
        initComponents();
        setVisible(true);
        setTitle("Tambah Kebutuhan Karyawan");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JBUbah.setVisible(false);
    }

    public KebutuhanKaryawan(Object idEdit) {
        IdEdit = idEdit.toString();
        initComponents();
        setVisible(true);
        setTitle("Ubah Kebutuhan Karyawan");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JBTambah.setVisible(false);
        JBTambahTutup.setVisible(false);
        loadEditData();
    }

    void loadEditData() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.setQuery("SELECT `IdKebutuhanKaryawan` as 'ID', DATE_FORMAT(`Tanggal`,'%d-%m-%Y') as 'Tanggal', `Bagian`, `Kualifikasi`, `Jumlah`, `Keterangan` FROM `snitbkebutuhankaryawan` WHERE `IdKebutuhanKaryawan` = " + IdEdit);
        ArrayList<String> list = dRunSelctOne.excute();
        JDTanggal.setDate(FDateF.strtodate(list.get(1), "dd-MM-yyyy"));
        JTBagian.setText(list.get(2));
        JTAKualifikasi.setText(list.get(3));
        JTJumlah.setText(list.get(4));
        JTAKeterangan.setText(list.get(5));
    }

    Boolean checkInput() {
        if (JDTanggal.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Tanggal Tidak Boleh Kosong");
            JDTanggal.requestFocus();
            return false;
        } else if (JTBagian.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bagian Tidak Boleh Kosong");
            JTBagian.requestFocus();
            return false;
        } else if (JTAKualifikasi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kualifikasi Tidak Boleh Kosong");
            JTAKualifikasi.requestFocus();
            return false;
        } else if (JTJumlah.getInt() == 0) {
            JOptionPane.showMessageDialog(null, "Jumlah Tidak Boleh Kosong");
            JTJumlah.requestFocus();
            return false;
        } else {
            return true;
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

        JLTanggal = new KomponenGUI.JlableF();
        JLTanggal2 = new KomponenGUI.JlableF();
        JDTanggal = new KomponenGUI.JdateCF();
        JLBagian = new KomponenGUI.JlableF();
        JLBagian2 = new KomponenGUI.JlableF();
        JTBagian = new KomponenGUI.JtextF();
        JLKualifikasi = new KomponenGUI.JlableF();
        JLKualifikasi2 = new KomponenGUI.JlableF();
        JSPKualifikasi = new javax.swing.JScrollPane();
        JTAKualifikasi = new KomponenGUI.JTextAreaF();
        JLJumlah = new KomponenGUI.JlableF();
        JLJumlah2 = new KomponenGUI.JlableF();
        JTJumlah = new KomponenGUI.JRibuanTextField();
        JLJumlah3 = new KomponenGUI.JlableF();
        JLKeterangan = new KomponenGUI.JlableF();
        JLKeterangan2 = new KomponenGUI.JlableF();
        JSPKeterangan = new javax.swing.JScrollPane();
        JTAKeterangan = new KomponenGUI.JTextAreaF();
        JBTambah = new KomponenGUI.JbuttonF();
        JBTambahTutup = new KomponenGUI.JbuttonF();
        JBUbah = new KomponenGUI.JbuttonF();
        JBKembali = new KomponenGUI.JbuttonF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        JLTanggal.setText("Tanggal");

        JLTanggal2.setText(":");

        JDTanggal.setDate(new Date());
        JDTanggal.setDateFormatString("dd-MM-yyyy");

        JLBagian.setText("Bagian");

        JLBagian2.setText(":");

        JTBagian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTBagianKeyPressed(evt);
            }
        });

        JLKualifikasi.setText("Kualifikasi");

        JLKualifikasi2.setText(":");

        JTAKualifikasi.setColumns(20);
        JTAKualifikasi.setRows(5);
        JTAKualifikasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTAKualifikasiKeyPressed(evt);
            }
        });
        JSPKualifikasi.setViewportView(JTAKualifikasi);

        JLJumlah.setText("Jumlah");

        JLJumlah2.setText(":");

        JTJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTJumlahKeyPressed(evt);
            }
        });

        JLJumlah3.setText("Orang");

        JLKeterangan.setText("Keterangan");

        JLKeterangan2.setText(":");

        JTAKeterangan.setColumns(20);
        JTAKeterangan.setRows(5);
        JTAKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTAKeteranganKeyPressed(evt);
            }
        });
        JSPKeterangan.setViewportView(JTAKeterangan);

        JBTambah.setText("Tambah");
        JBTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTambahActionPerformed(evt);
            }
        });

        JBTambahTutup.setText("Tambah & Tutup");
        JBTambahTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTambahTutupActionPerformed(evt);
            }
        });

        JBUbah.setText("Ubah");
        JBUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUbahActionPerformed(evt);
            }
        });

        JBKembali.setText("Kembali");
        JBKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBKembaliActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLTanggal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JDTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JLJumlah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JLBagian, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JLKualifikasi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JLKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JLKeterangan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JSPKeterangan))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JLBagian2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTBagian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JLKualifikasi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JSPKualifikasi))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JLJumlah2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JLJumlah3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JBKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(JBUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBTambahTutup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JLTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLTanggal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JDTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLBagian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLBagian2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTBagian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLKualifikasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLKualifikasi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JSPKualifikasi, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLJumlah2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLJumlah3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JLKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLKeterangan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JSPKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBTambahTutup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTambahActionPerformed
        tambahData(false);
    }//GEN-LAST:event_JBTambahActionPerformed

    private void JBTambahTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTambahTutupActionPerformed
        tambahData(true);
    }//GEN-LAST:event_JBTambahTutupActionPerformed

    private void JBKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBKembaliActionPerformed
        dispose();
    }//GEN-LAST:event_JBKembaliActionPerformed

    private void JBUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUbahActionPerformed
        ubahData();
    }//GEN-LAST:event_JBUbahActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (IdEdit == null) {
            tambahKebutuhanKaryawan = null;
        } else {
            ubahKebutuhanKaryawan = null;
        }
    }//GEN-LAST:event_formWindowClosed

    private void JTBagianKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTBagianKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTAKualifikasi.requestFocus();
        }
    }//GEN-LAST:event_JTBagianKeyPressed

    private void JTJumlahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTJumlahKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTAKeterangan.requestFocus();
        }
    }//GEN-LAST:event_JTJumlahKeyPressed

    private void JTAKeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTAKeteranganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (IdEdit == null) {
                tambahData(false);
            } else {
                ubahData();
            }
        }
    }//GEN-LAST:event_JTAKeteranganKeyPressed

    private void JTAKualifikasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTAKualifikasiKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTJumlah.requestFocus();
        }
    }//GEN-LAST:event_JTAKualifikasiKeyPressed

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
            java.util.logging.Logger.getLogger(KebutuhanKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KebutuhanKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KebutuhanKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KebutuhanKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KebutuhanKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF JBKembali;
    private KomponenGUI.JbuttonF JBTambah;
    private KomponenGUI.JbuttonF JBTambahTutup;
    private KomponenGUI.JbuttonF JBUbah;
    private static KomponenGUI.JdateCF JDTanggal;
    private KomponenGUI.JlableF JLBagian;
    private KomponenGUI.JlableF JLBagian2;
    private KomponenGUI.JlableF JLJumlah;
    private KomponenGUI.JlableF JLJumlah2;
    private KomponenGUI.JlableF JLJumlah3;
    private KomponenGUI.JlableF JLKeterangan;
    private KomponenGUI.JlableF JLKeterangan2;
    private KomponenGUI.JlableF JLKualifikasi;
    private KomponenGUI.JlableF JLKualifikasi2;
    private KomponenGUI.JlableF JLTanggal;
    private KomponenGUI.JlableF JLTanggal2;
    private javax.swing.JScrollPane JSPKeterangan;
    private javax.swing.JScrollPane JSPKualifikasi;
    private KomponenGUI.JTextAreaF JTAKeterangan;
    private KomponenGUI.JTextAreaF JTAKualifikasi;
    private KomponenGUI.JtextF JTBagian;
    private KomponenGUI.JRibuanTextField JTJumlah;
    // End of variables declaration//GEN-END:variables

    void tambahData(Boolean tutup) {
        if (checkInput()) {
            Insert insert = new Insert();
            Boolean berhasil = false;
            berhasil = insert.simpan("INSERT INTO `snitbkebutuhankaryawan`(`Tanggal`, `Bagian`, `Kualifikasi`, `Jumlah`, `Keterangan`) VALUES('" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "','" + JTBagian.getText() + "','" + JTAKualifikasi.getText() + "','" + JTJumlah.getInt() + "','" + JTAKeterangan.getText() + "')", "Kebutuhan Karyawan", this);
            if (berhasil) {
                if (listKebutuhanKaryawan != null) {
                    listKebutuhanKaryawan.load();
                }
                if (tutup) {
                    tambahKebutuhanKaryawan.dispose();
                    tambahKebutuhanKaryawan = null;
                } else {
                    JTBagian.setText("");
                    JTAKualifikasi.setText("");
                    JTJumlah.setText("0");
                    JTAKeterangan.setText("");
                }
            }
        }
    }

    void ubahData() {
        if (checkInput()) {
            Update update = new Update();
            Boolean berhasil = false;
            berhasil = update.Ubah("UPDATE `snitbkebutuhankaryawan` SET `Tanggal`='" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',`Bagian`='" + JTBagian.getText() + "',`Kualifikasi`='" + JTAKualifikasi.getText() + "',`Jumlah`='" + JTJumlah.getInt() + "',`Keterangan`='" + JTAKeterangan.getText() + "' WHERE `IdKebutuhanKaryawan` = " + IdEdit, "Kebutuhan Karyawan", this);
            if (listKebutuhanKaryawan != null) {
                listKebutuhanKaryawan.load();
            }
            if (berhasil) {
                dispose();
            }
        }
    }
}
