/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProsesTeknik;

import ProsesLab.*;
import KomponenGUI.FDateF;
import LSubProces.DRunSelctOne;
import LSubProces.Insert;
import LSubProces.Update;
import LSubProces.UpdateAll;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import static GlobalVar.Var.*;

/**
 *
 * @author Gudang Garam
 */
public class Pemeliharaan extends javax.swing.JFrame {

    /**
     * Creates new form PengujianBahanBaku
     */
    String IdEdit;

    public Pemeliharaan() {
        initComponents();
        setVisible(true);
        setTitle("Tambah Pemeliharaan");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jbuttonF3.setVisible(false);
    }

    public Pemeliharaan(Object idEdit) {
        IdEdit = idEdit.toString();
        initComponents();
        setVisible(true);
        setTitle("Ubah Pemeliharaan");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jbuttonF1.setVisible(false);
        jbuttonF2.setVisible(false);
        loadEditData();
    }

    void loadEditData() {
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.setQuery("SELECT `IdPemeliharaan` as 'ID', DATE_FORMAT(`Tanggal`,'%d-%m-%Y') as 'Tanggal', `NamaBarang` as 'Nama Barang', `Deskripsi`, a.`Keterangan` FROM `snitbpemeliharaan`a JOIN `snitbmbarangteknik`b ON a.`IdBarangTeknik`=b.`IdBarangTeknik` WHERE `IdPemeliharaan` = " + IdEdit);
        ArrayList<String> list = dRunSelctOne.excute();
        JDTanggal.setDate(FDateF.strtodate(list.get(1), "dd-MM-yyyy"));
        JCNamaBarang.setSelectedItem(list.get(2));
        JTDeskripsi.setText(list.get(3));
        JTAKeterangan.setText(list.get(4));
    }

    Boolean checkInput() {
        if (JDTanggal.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Tanggal Tidak Boleh Kosong");
            return false;
        } else if (JCNamaBarang.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Nama Barang Terlebih Dahulu");
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

        jbuttonF1 = new KomponenGUI.JbuttonF();
        jbuttonF2 = new KomponenGUI.JbuttonF();
        jbuttonF4 = new KomponenGUI.JbuttonF();
        jbuttonF3 = new KomponenGUI.JbuttonF();
        JDTanggal = new KomponenGUI.JdateCF();
        jlableF23 = new KomponenGUI.JlableF();
        jlableF24 = new KomponenGUI.JlableF();
        jlableF3 = new KomponenGUI.JlableF();
        jlableF6 = new KomponenGUI.JlableF();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTAKeterangan = new KomponenGUI.JTextAreaF();
        jlableF9 = new KomponenGUI.JlableF();
        jlableF35 = new KomponenGUI.JlableF();
        jlableF10 = new KomponenGUI.JlableF();
        jlableF36 = new KomponenGUI.JlableF();
        JTDeskripsi = new KomponenGUI.JtextF();
        JCNamaBarang = new KomponenGUI.JcomboboxF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jbuttonF1.setText("Tambah");
        jbuttonF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF1ActionPerformed(evt);
            }
        });

        jbuttonF2.setText("Tambah & Tutup");
        jbuttonF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF2ActionPerformed(evt);
            }
        });

        jbuttonF4.setText("Kembali");
        jbuttonF4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF4ActionPerformed(evt);
            }
        });

        jbuttonF3.setText("Ubah");
        jbuttonF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonF3ActionPerformed(evt);
            }
        });

        JDTanggal.setDate(new Date());
        JDTanggal.setDateFormatString("dd-MM-yyyy");
        JDTanggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JDTanggalPropertyChange(evt);
            }
        });
        JDTanggal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JDTanggalKeyPressed(evt);
            }
        });

        jlableF23.setText("Tanggal");

        jlableF24.setText(":");

        jlableF3.setText("Keterangan");

        jlableF6.setText(":");

        jScrollPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyPressed(evt);
            }
        });

        JTAKeterangan.setColumns(20);
        JTAKeterangan.setRows(5);
        JTAKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTAKeteranganKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(JTAKeterangan);

        jlableF9.setText("Nama Barang");

        jlableF35.setText(":");

        jlableF10.setText("Deskripsi");

        jlableF36.setText(":");

        JTDeskripsi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTDeskripsiKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTDeskripsiKeyReleased(evt);
            }
        });

        JCNamaBarang.load("SELECT '--Pilih Nama Barang--' as 'NamaBarang' UNION ALL SELECT `NamaBarang` FROM `snitbmbarangteknik` ORDER BY `NamaBarang` ");
        JCNamaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCNamaBarangKeyPressed(evt);
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
                        .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlableF3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlableF10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlableF9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlableF23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlableF24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlableF35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JDTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JCNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlableF23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JDTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlableF35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlableF10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlableF36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlableF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlableF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuttonF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF1ActionPerformed
        tambahData(false);
    }//GEN-LAST:event_jbuttonF1ActionPerformed

    private void jbuttonF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF2ActionPerformed
        tambahData(true);
    }//GEN-LAST:event_jbuttonF2ActionPerformed

    private void jbuttonF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF4ActionPerformed
        dispose();
    }//GEN-LAST:event_jbuttonF4ActionPerformed

    private void jbuttonF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonF3ActionPerformed
        ubahData();
    }//GEN-LAST:event_jbuttonF3ActionPerformed

    private void JDTanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JDTanggalPropertyChange

    }//GEN-LAST:event_JDTanggalPropertyChange

    private void JDTanggalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDTanggalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCNamaBarang.requestFocus();
        }
    }//GEN-LAST:event_JDTanggalKeyPressed

    private void JTAKeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTAKeteranganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (IdEdit == null) {
                tambahData(false);
            } else {
                ubahData();
            }
        }
    }//GEN-LAST:event_JTAKeteranganKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (IdEdit == null) {
            tambahPemeliharaan = null;
        } else {
            tambahPemeliharaan = null;
        }
    }//GEN-LAST:event_formWindowClosed

    private void jScrollPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jbuttonF1.isVisible()) {
                tambahData(false);
            } else {
                ubahData();
            }
        }
    }//GEN-LAST:event_jScrollPane1KeyPressed

    private void JTDeskripsiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTDeskripsiKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTAKeterangan.requestFocus();
        }
    }//GEN-LAST:event_JTDeskripsiKeyPressed

    private void JTDeskripsiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTDeskripsiKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTDeskripsiKeyReleased

    private void JCNamaBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCNamaBarangKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTDeskripsi.requestFocus();
        }
    }//GEN-LAST:event_JCNamaBarangKeyPressed

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
            java.util.logging.Logger.getLogger(Pemeliharaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pemeliharaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pemeliharaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pemeliharaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pemeliharaan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JcomboboxF JCNamaBarang;
    private static KomponenGUI.JdateCF JDTanggal;
    private KomponenGUI.JTextAreaF JTAKeterangan;
    private KomponenGUI.JtextF JTDeskripsi;
    private javax.swing.JScrollPane jScrollPane1;
    private KomponenGUI.JbuttonF jbuttonF1;
    private KomponenGUI.JbuttonF jbuttonF2;
    private KomponenGUI.JbuttonF jbuttonF3;
    private KomponenGUI.JbuttonF jbuttonF4;
    private KomponenGUI.JlableF jlableF10;
    private KomponenGUI.JlableF jlableF23;
    private KomponenGUI.JlableF jlableF24;
    private KomponenGUI.JlableF jlableF3;
    private KomponenGUI.JlableF jlableF35;
    private KomponenGUI.JlableF jlableF36;
    private KomponenGUI.JlableF jlableF6;
    private KomponenGUI.JlableF jlableF9;
    // End of variables declaration//GEN-END:variables

    void tambahData(Boolean tutup) {
        if (checkInput()) {
            Insert insert = new Insert();
            Boolean berhasil = false;
            berhasil = insert.simpan("INSERT INTO `snitbpemeliharaan`(`Tanggal`, `IdBarangTeknik`, `Deskripsi`, `Keterangan`) VALUES ('" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',(SELECT `IdBarangTeknik` FROM `snitbmbarangteknik` WHERE `NamaBarang` = '" + JCNamaBarang.getSelectedItem() + "'),'" + JTDeskripsi.getText() + "','" + JTAKeterangan.getText() + "')", "Barang Teknik", this);
            if (berhasil) {
                if (listPemeliharaan != null) {
                    listPemeliharaan.load();
                }
                if (tutup) {
                    tambahPemeliharaan.dispose();
                    tambahPemeliharaan = null;
                } else {
                    JTDeskripsi.setText("");
                    JTAKeterangan.setText("");
                }
            }
        }
    }

    void ubahData() {
        if (checkInput()) {
            Update update = new Update();
            Boolean berhasil = false;
            berhasil = update.Ubah("UPDATE `snitbpemeliharaan` SET `Tanggal`='" + FDateF.datetostr(JDTanggal.getDate(), "yyyy-MM-dd") + "',`IdBarangTeknik`=(SELECT `IdBarangTeknik` FROM `snitbmbarangteknik` WHERE `NamaBarang` = '" + JCNamaBarang.getSelectedItem() + "'),`Deskripsi`='" + JTDeskripsi.getText() + "',`Keterangan`='" + JTAKeterangan.getText() + "' WHERE `IdPemeliharaan` = " + IdEdit, "Pemeliharaan", this);
            if (listPemeliharaan != null) {
                listPemeliharaan.load();
            }
            if (berhasil) {
                dispose();
            }
        }
    }

}