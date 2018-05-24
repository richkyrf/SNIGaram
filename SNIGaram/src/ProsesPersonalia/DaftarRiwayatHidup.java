/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProsesPersonalia;

import KomponenGUI.FDateF;
import LSubProces.DRunSelctOne;
import LSubProces.MultiInsert;
import LSubProces.RunSelct;
import java.awt.event.KeyEvent;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import static GlobalVar.Var.*;

/**
 *
 * @author richky
 */
public class DaftarRiwayatHidup extends javax.swing.JFrame {

    /**
     * Creates new form MasterPenjualan
     */
    String IdEdit;
    int CountTable;

    public DaftarRiwayatHidup() {
        initComponents();
        setVisible(true);
        setTitle("Tambah Daftar Riwayat Hidup");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JBUbah.setVisible(false);
        JCNamaKaryawan.requestFocus();
    }

    public DaftarRiwayatHidup(Object idEdit) {
        IdEdit = idEdit.toString();
        initComponents();
        setVisible(true);
        setTitle("Ubah Daftar Riwayat Hidup");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JBTambah.setVisible(false);
        JBTambahTutup.setVisible(false);
        loadeditdata();
        JCNamaKaryawan.requestFocus();
    }

    void loadeditdata() {
        JCNamaKaryawan.load("SELECT '-- Pilih Nama Karyawan --' UNION ALL (SELECT UCWORDS(`NamaKaryawan`) FROM `tbmkaryawan` AS A LEFT JOIN `snitbriwayathidup` AS B ON A.`IdKaryawan`=B.`IdKaryawan` WHERE (A.`Status`=1 AND B.`IdKaryawan` IS NULL) OR `IdRiwayatHidup`=" + IdEdit + " GROUP BY `NamaKaryawan` ORDER BY `NamaKaryawan` ASC)");
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Eror Gagal Menampilkan Data Daftar Riwayat Hidup");
        dRunSelctOne.setQuery("SELECT `IdRiwayatHidup`, UCWORDS(`NamaKaryawan`), DATE_FORMAT(`TanggalBergabung`, '%d-%m-%Y'), `PendidikanFormal`, A.`Status`, A.`Keterangan` FROM `snitbriwayathidup` AS A JOIN `tbmkaryawan` AS B ON A.`IdKaryawan`=B.`IdKaryawan` WHERE `IdRiwayatHidup` = '" + IdEdit + "'");
        ArrayList<String> list = dRunSelctOne.excute();
        JCNamaKaryawan.setSelectedItem(list.get(1));
        JDTanggalBergabung.setDate(FDateF.strtodate(list.get(2), "dd-MM-yyyy"));
        JCPendidikanFormal.setSelectedItem(list.get(3));
        JCStatus.setSelectedItem(list.get(4));
        JTAKeterangan.setText(list.get(5));
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
        model.getDataVector().removeAllElements();
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `IdRiwayatHidupDetail`, DATE_FORMAT(`TanggalMulai`,'%d-%m-%Y'), DATE_FORMAT(`TanggalSelesai`,'%d-%m-%Y'), `Bagian`, A.`Keterangan` FROM `snitbriwayathidupdetail` AS A JOIN `snitbriwayathidup` AS B ON A.`IdRiwayatHidup`=B.`IdRiwayatHidup` WHERE A.`IdRiwayatHidup` = '" + list.get(0) + "'");
        try {
            ResultSet rs = runSelct.excute();
            int row = 0;
            while (rs.next()) {
                model.addRow(new Object[]{"", "", "", "", ""});
                JTable.setValueAt((row + 1), row, 0);
                JTable.setValueAt(rs.getString(2), row, 1);
                JTable.setValueAt(rs.getString(3), row, 2);
                JTable.setValueAt(rs.getString(4), row, 3);
                JTable.setValueAt(rs.getString(5), row, 4);
                row++;
            }
            CountTable = JTable.getRowCount();
        } catch (SQLException e) {
            out.println("E6" + e);
            showMessageDialog(null, "Gagal Panggil Data Detail Daftar Riwayat Hidup");
        } finally {
            runSelct.closecon();
        }
    }

    Boolean checkInput(String action) {
        if (JCNamaKaryawan.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Nama Karyawan");
            JCNamaKaryawan.requestFocus();
            return false;
        } else if (JDTanggalBergabung.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Tanggal Bergabung Tidak Boleh Kosong");
            JDTanggalBergabung.requestFocus();
            return false;
        } else if (JCPendidikanFormal.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Pendidikan Formal");
            JCPendidikanFormal.requestFocus();
            return false;
        } else if (JCStatus.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Status");
            JCStatus.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    boolean checkTable() {
        if (JDTanggalMasuk.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Tanggal Masuk Tidak Boleh Kosong");
            JDTanggalMasuk.requestFocus();
            return false;
        } else if (JDTanggalKeluar.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Tanggal Keluar Tidak Boleh Kosong");
            JDTanggalKeluar.requestFocus();
            return false;
        } else if (JTBagian.getText().replace(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama Bagian Tidak Boleh Kosong");
            JTBagian.requestFocus();
            return false;
        } else if (JTKeterangan.getText().replace(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Keterangan Tidak Boleh Kosong");
            JTKeterangan.requestFocus();
            return false;
        } else if (JDTanggalKeluar.getDate().compareTo(JDTanggalMasuk.getDate()) < 0) {
            JOptionPane.showMessageDialog(this, "Tanggal Masuk Tidak Boleh Lebih Besar Dari Tanggal Keluar");
            JDTanggalMasuk.requestFocus();
            return false;
        } else if (cekdoubleitem(FDateF.datetostr(JDTanggalMasuk.getDate(), "dd-MM-yyyy"), FDateF.datetostr(JDTanggalKeluar.getDate(), "dd-MM-yyyy"), JTBagian.getText(), JTKeterangan.getText())) {
            JOptionPane.showMessageDialog(this, "Tidak Bisa Input Data Yang Sama");
            JTBagian.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    boolean cekdoubleitem(String item1, String item2, String item3, String item4) {
        for (int i = 0; i < JTable.getRowCount(); i++) {
            if (item1.equals(JTable.getValueAt(i, 1)) && item2.equals(JTable.getValueAt(i, 2)) && item3.equals(JTable.getValueAt(i, 3)) && item4.equals(JTable.getValueAt(i, 4)) && i != JTable.getSelectedRow()) {
                return true;
            }
        }
        return false;
    }

    void RefreshTbl() {
        JDTanggalMasuk.setDate(new Date());
        JDTanggalKeluar.setDate(new Date());
        JTBagian.setText("");
        JTKeterangan.setText("");
        JTable.clearSelection();
        JBTambahUbahTable.setText("Tambah");
        JTBagian.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        JLNamaKaryawan = new KomponenGUI.JlableF();
        JLNamaKaryawan2 = new KomponenGUI.JlableF();
        JCNamaKaryawan = new KomponenGUI.JcomboboxF();
        JLTanggalBergabung = new KomponenGUI.JlableF();
        JLTanggalBergabung2 = new KomponenGUI.JlableF();
        JDTanggalBergabung = new KomponenGUI.JdateCF();
        JLPendidikanFormal = new KomponenGUI.JlableF();
        JLPendidikanFormal2 = new KomponenGUI.JlableF();
        JCPendidikanFormal = new KomponenGUI.JcomboboxF();
        JLStatus = new KomponenGUI.JlableF();
        JLStatus2 = new KomponenGUI.JlableF();
        JCStatus = new KomponenGUI.JcomboboxF();
        JSeparator1 = new javax.swing.JSeparator();
        JLDetailDaftarRiwayatHidup = new KomponenGUI.JlableF();
        JDTanggalMasuk = new KomponenGUI.JdateCF();
        JLTanggalMasukKeluar = new KomponenGUI.JlableF();
        JDTanggalKeluar = new KomponenGUI.JdateCF();
        JTBagian = new KomponenGUI.JPlaceHolder();
        JTKeterangan = new KomponenGUI.JPlaceHolder();
        JSPTable = new javax.swing.JScrollPane();
        JTable = new KomponenGUI.JtableF();
        JBTambahUbahTable = new KomponenGUI.JbuttonF();
        JBHapusTable = new KomponenGUI.JbuttonF();
        JBRefreshTable = new KomponenGUI.JbuttonF();
        JSeparator2 = new javax.swing.JSeparator();
        JLKeterangan = new KomponenGUI.JlableF();
        JLKeterangan2 = new KomponenGUI.JlableF();
        JSPKeterangan = new javax.swing.JScrollPane();
        JTAKeterangan = new KomponenGUI.JTextAreaF();
        JBKembali = new KomponenGUI.JbuttonF();
        JBUbah = new KomponenGUI.JbuttonF();
        JBTambahTutup = new KomponenGUI.JbuttonF();
        JBTambah = new KomponenGUI.JbuttonF();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        JLNamaKaryawan.setText("Nama Karyawan");

        JLNamaKaryawan2.setText(":");

        JCNamaKaryawan.load("SELECT '-- Pilih Nama Karyawan --' UNION ALL (SELECT UCWORDS(`NamaKaryawan`) FROM `tbmkaryawan` AS A LEFT JOIN `snitbriwayathidup` AS B ON A.`IdKaryawan`=B.`IdKaryawan` WHERE A.`Status`=1 AND B.`IdKaryawan` IS NULL GROUP BY `NamaKaryawan` ORDER BY `NamaKaryawan` ASC)");
        JCNamaKaryawan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCNamaKaryawanKeyPressed(evt);
            }
        });

        JLTanggalBergabung.setText("Tanggal Bergabung");

        JLTanggalBergabung2.setText(":");

        JDTanggalBergabung.setDate(new Date());
        JDTanggalBergabung.setDateFormatString("dd-MM-yyyy");
        JDTanggalBergabung.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JDTanggalBergabungKeyPressed(evt);
            }
        });

        JLPendidikanFormal.setText("Pendidikan Formal");

        JLPendidikanFormal2.setText(":");

        JCPendidikanFormal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Pendidikan Formal --", "-", "SD", "SMP", "SMA", "D1", "D2", "D3", "D4", "S1", "S2", "S3" }));
        JCPendidikanFormal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCPendidikanFormalKeyPressed(evt);
            }
        });

        JLStatus.setText("Status");

        JLStatus2.setText(":");

        JCStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Status --", "Belum Kawin", "Kawin" }));
        JCStatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCStatusKeyPressed(evt);
            }
        });

        JLDetailDaftarRiwayatHidup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLDetailDaftarRiwayatHidup.setText("-- Detail Daftar Riwayat Hidup --");

        JDTanggalMasuk.setDate(new Date());
        JDTanggalMasuk.setDateFormatString("dd-MM-yyyy");
        JDTanggalMasuk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JDTanggalMasukKeyPressed(evt);
            }
        });

        JLTanggalMasukKeluar.setText("s/d");

        JDTanggalKeluar.setDate(new Date());
        JDTanggalKeluar.setDateFormatString("dd-MM-yyyy");
        JDTanggalKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JDTanggalKeluarKeyPressed(evt);
            }
        });

        JTBagian.setPlaceHolder("Bagian");
        JTBagian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTBagianKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTBagianKeyTyped(evt);
            }
        });

        JTKeterangan.setPlaceHolder("Keterangan");
        JTKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTKeteranganKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTKeteranganKeyTyped(evt);
            }
        });

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Tanggal Masuk", "Tanggal Keluar", "Bagian", "Keterangan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableMouseClicked(evt);
            }
        });
        JSPTable.setViewportView(JTable);
        if (JTable.getColumnModel().getColumnCount() > 0) {
            JTable.getColumnModel().getColumn(0).setMinWidth(50);
            JTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            JTable.getColumnModel().getColumn(0).setMaxWidth(50);
            JTable.getColumnModel().getColumn(1).setMinWidth(110);
            JTable.getColumnModel().getColumn(1).setPreferredWidth(110);
            JTable.getColumnModel().getColumn(1).setMaxWidth(110);
            JTable.getColumnModel().getColumn(2).setMinWidth(110);
            JTable.getColumnModel().getColumn(2).setPreferredWidth(110);
            JTable.getColumnModel().getColumn(2).setMaxWidth(110);
            JTable.getColumnModel().getColumn(3).setMinWidth(250);
            JTable.getColumnModel().getColumn(3).setPreferredWidth(250);
            JTable.getColumnModel().getColumn(3).setMaxWidth(250);
            JTable.getColumnModel().getColumn(4).setMinWidth(364);
            JTable.getColumnModel().getColumn(4).setPreferredWidth(364);
            JTable.getColumnModel().getColumn(4).setMaxWidth(364);
        }

        JBTambahUbahTable.setText("Tambah");
        JBTambahUbahTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTambahUbahTableActionPerformed(evt);
            }
        });

        JBHapusTable.setText("Hapus");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), JBHapusTable, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        JBHapusTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBHapusTableActionPerformed(evt);
            }
        });

        JBRefreshTable.setText("Refresh");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, JTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), JBRefreshTable, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        JBRefreshTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRefreshTableActionPerformed(evt);
            }
        });

        JLKeterangan.setText("Keterangan");

        JLKeterangan2.setText(":");

        JTAKeterangan.setColumns(20);
        JTAKeterangan.setRows(4);
        JTAKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTAKeteranganKeyPressed(evt);
            }
        });
        JSPKeterangan.setViewportView(JTAKeterangan);

        JBKembali.setText("Kembali");
        JBKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBKembaliActionPerformed(evt);
            }
        });

        JBUbah.setText("Ubah");
        JBUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUbahActionPerformed(evt);
            }
        });

        JBTambahTutup.setText("Tambah & Tutup");
        JBTambahTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTambahTutupActionPerformed(evt);
            }
        });

        JBTambah.setText("Tambah");
        JBTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTambahActionPerformed(evt);
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
                            .addComponent(JSeparator2)
                            .addComponent(JSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(JBKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JBUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JBTambahTutup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JBTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JDTanggalMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(JLTanggalMasukKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(JDTanggalKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTBagian, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                                    .addComponent(JSPTable))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JBHapusTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JBTambahUbahTable, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JBRefreshTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JLNamaKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLTanggalBergabung, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLPendidikanFormal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLTanggalBergabung2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JDTanggalBergabung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLNamaKaryawan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCNamaKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLPendidikanFormal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCPendidikanFormal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLStatus2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLKeterangan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSPKeterangan)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JLDetailDaftarRiwayatHidup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLNamaKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLNamaKaryawan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCNamaKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JLTanggalBergabung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLTanggalBergabung2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JDTanggalBergabung, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLPendidikanFormal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLPendidikanFormal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCPendidikanFormal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLStatus2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(JLDetailDaftarRiwayatHidup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JBTambahUbahTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTBagian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JLTanggalMasukKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JDTanggalMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JDTanggalKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBHapusTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBRefreshTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JSPTable, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JLKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLKeterangan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JSPKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBTambahTutup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTambahActionPerformed
        tambahData(false);
    }//GEN-LAST:event_JBTambahActionPerformed

    private void JBTambahTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTambahTutupActionPerformed
        tambahData(true);
    }//GEN-LAST:event_JBTambahTutupActionPerformed

    private void JBUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUbahActionPerformed
        ubahData();
    }//GEN-LAST:event_JBUbahActionPerformed

    private void JBKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBKembaliActionPerformed
        dispose();
    }//GEN-LAST:event_JBKembaliActionPerformed

    private void JDTanggalBergabungKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDTanggalBergabungKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCPendidikanFormal.requestFocus();
        }
    }//GEN-LAST:event_JDTanggalBergabungKeyPressed

    private void JBTambahUbahTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTambahUbahTableActionPerformed
        TambahUbahTabel();
    }//GEN-LAST:event_JBTambahUbahTableActionPerformed

    private void JBHapusTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBHapusTableActionPerformed
        if (JTable.getSelectedRow() != -1) {
            ((DefaultTableModel) JTable.getModel()).removeRow(JTable.getSelectedRow());
            for (int a = 0; a < JTable.getRowCount(); a++) {
                JTable.setValueAt(a + 1, a, 0);
            }
            JOptionPane.showMessageDialog(this, "Berhasil Hapus Data");
            RefreshTbl();
        }
        JTBagian.requestFocus();
    }//GEN-LAST:event_JBHapusTableActionPerformed

    private void JBRefreshTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRefreshTableActionPerformed
        RefreshTbl();
    }//GEN-LAST:event_JBRefreshTableActionPerformed

    private void JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseClicked
        if (JTable.getSelectedRow() != -1) {
            JDTanggalMasuk.setDate(FDateF.strtodate(JTable.getValueAt(JTable.getSelectedRow(), 1).toString(), "dd-MM-yyyy"));
            JDTanggalKeluar.setDate(FDateF.strtodate(JTable.getValueAt(JTable.getSelectedRow(), 2).toString(), "dd-MM-yyyy"));
            JTBagian.setText(JTable.getValueAt(JTable.getSelectedRow(), 3).toString());
            JTKeterangan.setText(JTable.getValueAt(JTable.getSelectedRow(), 4).toString());
            JBTambahUbahTable.setText("Ubah");
            JTBagian.requestFocus();
        }
    }//GEN-LAST:event_JTableMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (IdEdit == null) {
            tambahDaftarRiwayatHidup = null;
        } else {
            ubahDaftarRiwayatHidup = null;
        }
    }//GEN-LAST:event_formWindowClosed

    private void JTAKeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTAKeteranganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (IdEdit == null) {
                tambahData(false);
            } else {
                ubahData();
            }
        }
    }//GEN-LAST:event_JTAKeteranganKeyPressed

    private void JCNamaKaryawanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCNamaKaryawanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCPendidikanFormal.requestFocus();
        }
    }//GEN-LAST:event_JCNamaKaryawanKeyPressed

    private void JDTanggalMasukKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDTanggalMasukKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JDTanggalKeluar.requestFocus();
        }
    }//GEN-LAST:event_JDTanggalMasukKeyPressed

    private void JDTanggalKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDTanggalKeluarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTBagian.requestFocus();
        }
    }//GEN-LAST:event_JDTanggalKeluarKeyPressed

    private void JTBagianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTBagianKeyTyped
        if (JTBagian.getText().length() >= 100) {
            this.getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_JTBagianKeyTyped

    private void JTKeteranganKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKeteranganKeyTyped
        if (JTKeterangan.getText().length() >= 100) {
            this.getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_JTKeteranganKeyTyped

    private void JCPendidikanFormalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCPendidikanFormalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCStatus.requestFocus();
        }
    }//GEN-LAST:event_JCPendidikanFormalKeyPressed

    private void JCStatusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCStatusKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTBagian.requestFocus();
        }
    }//GEN-LAST:event_JCStatusKeyPressed

    private void JTBagianKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTBagianKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JTKeterangan.requestFocus();
        }
    }//GEN-LAST:event_JTBagianKeyPressed

    private void JTKeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTKeteranganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            TambahUbahTabel();
        }
    }//GEN-LAST:event_JTKeteranganKeyPressed

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
            java.util.logging.Logger.getLogger(DaftarRiwayatHidup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarRiwayatHidup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarRiwayatHidup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarRiwayatHidup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DaftarRiwayatHidup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private KomponenGUI.JbuttonF JBHapusTable;
    private KomponenGUI.JbuttonF JBKembali;
    private KomponenGUI.JbuttonF JBRefreshTable;
    private KomponenGUI.JbuttonF JBTambah;
    private KomponenGUI.JbuttonF JBTambahTutup;
    private KomponenGUI.JbuttonF JBTambahUbahTable;
    private KomponenGUI.JbuttonF JBUbah;
    private KomponenGUI.JcomboboxF JCNamaKaryawan;
    private KomponenGUI.JcomboboxF JCPendidikanFormal;
    private KomponenGUI.JcomboboxF JCStatus;
    private KomponenGUI.JdateCF JDTanggalBergabung;
    private KomponenGUI.JdateCF JDTanggalKeluar;
    private KomponenGUI.JdateCF JDTanggalMasuk;
    private KomponenGUI.JlableF JLDetailDaftarRiwayatHidup;
    private KomponenGUI.JlableF JLKeterangan;
    private KomponenGUI.JlableF JLKeterangan2;
    private KomponenGUI.JlableF JLNamaKaryawan;
    private KomponenGUI.JlableF JLNamaKaryawan2;
    private KomponenGUI.JlableF JLPendidikanFormal;
    private KomponenGUI.JlableF JLPendidikanFormal2;
    private KomponenGUI.JlableF JLStatus;
    private KomponenGUI.JlableF JLStatus2;
    private KomponenGUI.JlableF JLTanggalBergabung;
    private KomponenGUI.JlableF JLTanggalBergabung2;
    private KomponenGUI.JlableF JLTanggalMasukKeluar;
    private javax.swing.JScrollPane JSPKeterangan;
    private javax.swing.JScrollPane JSPTable;
    private javax.swing.JSeparator JSeparator1;
    private javax.swing.JSeparator JSeparator2;
    private KomponenGUI.JTextAreaF JTAKeterangan;
    private KomponenGUI.JPlaceHolder JTBagian;
    private KomponenGUI.JPlaceHolder JTKeterangan;
    private KomponenGUI.JtableF JTable;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    void TambahUbahTabel() {
        if (checkTable()) {
            if (JBTambahUbahTable.getText().equals("Tambah")) {

                DefaultTableModel model = (DefaultTableModel) JTable.getModel();
                model.addRow(new Object[]{JTable.getRowCount() + 1, FDateF.datetostr(JDTanggalMasuk.getDate(), "dd-MM-yyyy"), FDateF.datetostr(JDTanggalKeluar.getDate(), "dd-MM-yyyy"), JTBagian.getText(), JTKeterangan.getText()});
                JOptionPane.showMessageDialog(this, "Berhasil Tambah Data");
                RefreshTbl();
            } else {
                JTable.setValueAt(FDateF.datetostr(JDTanggalMasuk.getDate(), "dd-MM-yyyy"), JTable.getSelectedRow(), 1);
                JTable.setValueAt(FDateF.datetostr(JDTanggalKeluar.getDate(), "dd-MM-yyyy"), JTable.getSelectedRow(), 2);
                JTable.setValueAt(JTBagian.getText(), JTable.getSelectedRow(), 3);
                JTable.setValueAt(JTKeterangan.getText(), JTable.getSelectedRow(), 4);
                JOptionPane.showMessageDialog(this, "Berhasil Ubah Data");
                RefreshTbl();
            }
        }
    }

    void tambahData(Boolean tutup) {
        if (checkInput("Tambah")) {
            boolean Berhasil;
            MultiInsert multiInsert = new MultiInsert();
            Berhasil = multiInsert.OpenConnection();
            if (Berhasil) {
                Berhasil = multiInsert.setautocomit(false);
                if (Berhasil) {
                    Berhasil = multiInsert.Excute("INSERT INTO `snitbriwayathidup`(`IdKaryawan`, `TanggalBergabung`, `PendidikanFormal`, `Status`, `Keterangan`) VALUES ((SELECT `IdKaryawan` FROM `tbmkaryawan` WHERE `NamaKaryawan` = '" + JCNamaKaryawan.getSelectedItem() + "'),'" + FDateF.datetostr(JDTanggalBergabung.getDate(), "yyyy-MM-dd") + "','" + JCPendidikanFormal.getSelectedItem() + "','" + JCStatus.getSelectedItem() + "','" + JTAKeterangan.getText() + "')", null);
                    if (Berhasil) {
                        for (int i = 0; i < JTable.getRowCount(); i++) {
                            Berhasil = multiInsert.Excute("INSERT INTO `snitbriwayathidupdetail`(`IdRiwayatHidup`, `TanggalMulai`, `TanggalSelesai`, `Bagian`, `Keterangan`) VALUES ((SELECT `IdRiwayatHidup` FROM `snitbriwayathidup` ORDER BY `IdRiwayatHidup` DESC LIMIT 1),'" + FDateF.datetostr(FDateF.strtodate(JTable.getValueAt(i, 1).toString(), "dd-MM-yyyy"), "yyyy-MM-dd") + "','" + FDateF.datetostr(FDateF.strtodate(JTable.getValueAt(i, 2).toString(), "dd-MM-yyyy"), "yyyy-MM-dd") + "','" + JTable.getValueAt(i, 3) + "','" + JTable.getValueAt(i, 4) + "')", null);
                        }
                    }
                }
            }
            if (Berhasil == false) {
                multiInsert.rollback();
                multiInsert.closecon();
                JOptionPane.showMessageDialog(this, "Gagal Tambah Data Daftar Riwayat Hidup");
            }
            if (Berhasil == true) {
                JOptionPane.showMessageDialog(this, "Berhasil Tambah Data Daftar Riwayat Hidup");
                multiInsert.Commit();
                multiInsert.closecon();
                if (tutup) {
                    dispose();
                } else {
                    JTable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{},
                            new String[]{
                                "No", "Tanggal Masuk", "Tanggal Keluar", "Bagian", "Keterangan"
                            }
                    ));
                    RefreshTbl();
                    JTable.getColumnModel().getColumn(0).setPreferredWidth(50);
                    JTable.getColumnModel().getColumn(1).setPreferredWidth(110);
                    JTable.getColumnModel().getColumn(2).setPreferredWidth(110);
                    JTable.getColumnModel().getColumn(3).setPreferredWidth(250);
                    JTable.getColumnModel().getColumn(4).setPreferredWidth(364);
                    JCNamaKaryawan.load("SELECT '-- Pilih Nama Karyawan --' UNION ALL (SELECT UCWORDS(`NamaKaryawan`) FROM `tbmkaryawan` AS A LEFT JOIN `snitbriwayathidup` AS B ON A.`IdKaryawan`=B.`IdKaryawan` WHERE A.`Status`=1 AND B.`IdKaryawan` IS NULL GROUP BY `NamaKaryawan` ORDER BY `NamaKaryawan` ASC)");
                    JDTanggalBergabung.setDate(new Date());
                    JCPendidikanFormal.setSelectedIndex(0);
                    JCStatus.setSelectedIndex(0);
                    JTAKeterangan.setText("");
                    JCNamaKaryawan.requestFocus();
                }
                if (GlobalVar.Var.listDaftarRiwayatHidup != null) {
                    GlobalVar.Var.listDaftarRiwayatHidup.load();
                }
            }
        }
    }

    void ubahData() {
        if (checkInput("Ubah")) {
            boolean Berhasil;
            MultiInsert multiInsert = new MultiInsert();
            Berhasil = multiInsert.OpenConnection();
            if (Berhasil) {
                Berhasil = multiInsert.setautocomit(false);
                if (Berhasil) {
                    Berhasil = multiInsert.Excute("UPDATE `snitbriwayathidup` SET `IdKaryawan`=(SELECT `IdKaryawan` FROM `tbmkaryawan` WHERE `NamaKaryawan` = '" + JCNamaKaryawan.getSelectedItem() + "'),`TanggalBergabung`='" + FDateF.datetostr(JDTanggalBergabung.getDate(), "yyyy-MM-dd") + "',`PendidikanFormal`='" + JCPendidikanFormal.getSelectedItem() + "',`Status`='" + JCStatus.getSelectedItem() + "',`Keterangan`='" + JTAKeterangan.getText() + "' WHERE `IdRiwayatHidup` = '" + IdEdit + "'", null);
                    if (Berhasil) {
                        if (CountTable != 0) {
                            Berhasil = multiInsert.Excute("DELETE FROM `snitbriwayathidupdetail` WHERE `IdRiwayatHidup` = '" + IdEdit + "'", null);
                        }
                        if (Berhasil) {
                            for (int i = 0; i < JTable.getRowCount(); i++) {
                                Berhasil = multiInsert.Excute("INSERT INTO `snitbriwayathidupdetail`(`IdRiwayatHidup`, `TanggalMulai`, `TanggalSelesai`, `Bagian`, `Keterangan`) VALUES (" + IdEdit + ",'" + FDateF.datetostr(FDateF.strtodate(JTable.getValueAt(i, 1).toString(), "dd-MM-yyyy"), "yyyy-MM-dd") + "','" + FDateF.datetostr(FDateF.strtodate(JTable.getValueAt(i, 2).toString(), "dd-MM-yyyy"), "yyyy-MM-dd") + "','" + JTable.getValueAt(i, 3) + "','" + JTable.getValueAt(i, 4) + "')", null);
                            }
                        }
                    }
                }
                if (Berhasil == false) {
                    multiInsert.rollback();
                    multiInsert.closecon();
                    JOptionPane.showMessageDialog(this, "Gagal Ubah Data Daftar Riwayat Hidup");
                }
                if (Berhasil == true) {
                    JOptionPane.showMessageDialog(this, "Berhasil Ubah Data Daftar Riwayat Hidup");
                    multiInsert.Commit();
                    multiInsert.closecon();
                    dispose();
                    if (GlobalVar.Var.listDaftarRiwayatHidup != null) {
                        GlobalVar.Var.listDaftarRiwayatHidup.load();
                    }
                }
            }
        }
    }
}
