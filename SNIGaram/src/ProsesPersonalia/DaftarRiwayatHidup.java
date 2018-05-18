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
        JCNamaKaryawan.load("SELECT '-- Pilih Nama Karyawan --' UNION ALL (SELECT `NamaKaryawan` FROM `tbmkaryawan` AS A LEFT JOIN `snitbriwayathidup` AS B ON A.`IdKaryawan`=B.`IdKaryawan` WHERE (A.`Status`=1 AND B.`IdKaryawan` IS NULL GROUP) OR B.`IdKaryawan`=" + IdEdit + " BY `NamaKaryawan` ORDER BY `NamaKaryawan` ASC)");
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Eror Gagal Menampilkan Data Daftar Riwayat Hidup");
        dRunSelctOne.setQuery("SELECT `IdEvaluasiPelatihan`, CONCAT('(',A.`IdPelatihan`,') ',`JenisPelatihan`), DATE_FORMAT(A.`Tanggal`, '%d/%m/%Y'), `Instruktur`, `Kesimpulan`, A.`Keterangan` FROM `snitbevaluasipelatihan` AS A JOIN `snitbpelatihan` AS B ON A.`IdPelatihan`=B.`IdPelatihan` JOIN `snitbusulpelatihan` AS C ON B.`IdUsulPelatihan`=C.`IdUsulPelatihan` WHERE `IdEvaluasiPelatihan` = '" + IdEdit + "'");
        ArrayList<String> list = dRunSelctOne.excute();
        JCNamaKaryawan.setSelectedItem(list.get(1));
        JDTanggalBergabung.setDate(FDateF.strtodate(list.get(2), "dd-MM-yyyy"));
        JTInstruktur.setText(list.get(3));
        JTAKesimpulan.setText(list.get(4));
        JTAKeterangan.setText(list.get(5));
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
        model.getDataVector().removeAllElements();
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `IdEvaluasiPelatihanDetail`, `NamaKaryawan`, `PenguasaanMateri`, `KemampuanBekerja` FROM `snitbevaluasipelatihandetail` AS A JOIN `snitbevaluasipelatihan` AS B ON A.`IdEvaluasiPelatihan`=B.`IdEvaluasiPelatihan` JOIN `snitbpelatihandetail` AS C ON A.`IdPelatihanDetail`=C.`IdPelatihanDetail` JOIN `tbmkaryawan` AS D ON C.`IdKaryawan`=D.`IdKaryawan` WHERE A.`IdEvaluasiPelatihan` = '" + list.get(0) + "'");
        try {
            ResultSet rs = runSelct.excute();
            int row = 0;
            while (rs.next()) {
                model.addRow(new Object[]{"", "", "", ""});
                JTable.setValueAt((row + 1), row, 0);
                JTable.setValueAt(rs.getString(2), row, 1);
                JTable.setValueAt(rs.getString(3), row, 2);
                JTable.setValueAt(rs.getString(4), row, 3);
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
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Pelatihan");
            JCNamaKaryawan.requestFocus();
            return false;
        } else if (JDTanggalBergabung.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Tanggal Evaluasi Tidak Boleh Kosong");
            JDTanggalBergabung.requestFocus();
            return false;
        } else if (JTInstruktur.getText().replace(" ", "").isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama Instruktur Tidak Boleh Kosong");
            JTInstruktur.requestFocus();
            return false;
        } else if (action.equals("Tambah") && JTable.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Detail Evaluasi Tidak Boleh Kosong");
            JCNamaKaryawan.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    boolean checkTable() {
        if (JCNamaKaryawan.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Nama Karyawan");
            JCNamaKaryawan.requestFocus();
            return false;
        } else if (JTPenguasaanMateri.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nilai Penguasaan Materi Tidak Boleh Kosong");
            JTPenguasaanMateri.requestFocus();
            return false;
        } else if (JTKemampuanBekerja.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nilai Kemampuan Bekerja Tidak Boleh Kosong");
            JTKemampuanBekerja.requestFocus();
            return false;
        } else if (JTPenguasaanMateri.getInt() > 100) {
            JOptionPane.showMessageDialog(this, "Nilai Penguasaan Materi Tidak Boleh Lebih Besar Dari 100");
            JTPenguasaanMateri.requestFocus();
            return false;
        } else if (JTKemampuanBekerja.getInt() > 100) {
            JOptionPane.showMessageDialog(this, "Nilai Kemampuan Bekerja Tidak Boleh Lebih Besar Dari 100");
            JTKemampuanBekerja.requestFocus();
            return false;
        } else if (cekdoubleitem(JCNamaKaryawan.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(this, "Tidak Bisa Input Karyawan Yang Sama");
            JCNamaKaryawan.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    boolean checkTableUbah() {
        if (JCNamaKaryawan.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Nama Karyawan");
            JCNamaKaryawan.requestFocus();
            return false;
        } else if (JTPenguasaanMateri.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nilai Penguasaan Materi Tidak Boleh Kosong");
            JTPenguasaanMateri.requestFocus();
            return false;
        } else if (JTKemampuanBekerja.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nilai Kemampuan Bekerja Tidak Boleh Kosong");
            JTKemampuanBekerja.requestFocus();
            return false;
        } else if (JTPenguasaanMateri.getInt() > 100) {
            JOptionPane.showMessageDialog(this, "Nilai Penguasaan Materi Tidak Boleh Lebih Besar Dari 100");
            JTPenguasaanMateri.requestFocus();
            return false;
        } else if (JTKemampuanBekerja.getInt() > 100) {
            JOptionPane.showMessageDialog(this, "Nilai Kemampuan Bekerja Tidak Boleh Lebih Besar Dari 100");
            JTKemampuanBekerja.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    boolean cekdoubleitem(String item) {
        for (int i = 0; i < JTable.getRowCount(); i++) {
            if (item.equals(JTable.getValueAt(i, 1))) {
                return true;
            }
        }
        return false;
    }

    void RefreshTbl() {
        JCNamaKaryawan.load("SELECT '-- Pilih Nama Karyawan --' UNION ALL (SELECT `NamaKaryawan` FROM `snitbpelatihandetail` AS A JOIN `tbmkaryawan` AS B ON A.`IdKaryawan`=B.`IdKaryawan` WHERE `IdPelatihan`=" + JCNamaKaryawan.getSelectedItem().toString().split("\\(")[1].split("\\)")[0] + " GROUP BY `NamaKaryawan` ORDER BY `NamaKaryawan` ASC)");
        JCNamaKaryawan.setSelectedIndex(0);
        JTPenguasaanMateri.setText("");
        JTKemampuanBekerja.setText("");
        JTable.clearSelection();
        JBTambahUbahTable.setText("Tambah");
        JCNamaKaryawan.requestFocus();
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

        JCNamaKaryawan.load("SELECT '-- Pilih Nama Karyawan --' UNION ALL (SELECT `NamaKaryawan` FROM `tbmkaryawan` AS A LEFT JOIN `snitbriwayathidup` AS B ON A.`IdKaryawan`=B.`IdKaryawan` WHERE A.`Status`=1 AND B.`IdKaryawan` IS NULL GROUP BY `NamaKaryawan` ORDER BY `NamaKaryawan` ASC)");
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

        JLStatus.setText("Status");

        JLStatus2.setText(":");

        JCStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Status --", "Belum Kawin", "Kawin" }));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTBagianKeyTyped(evt);
            }
        });

        JTKeterangan.setPlaceHolder("Keterangan");
        JTKeterangan.addKeyListener(new java.awt.event.KeyAdapter() {
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
        }
        JTable.setrender(new int[]{2,3,4}, new String[]{"Number", "Number", "Number"});

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JSPTable, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JDTanggalMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(JLTanggalMasukKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(JDTanggalKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTBagian, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTKeterangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JBRefreshTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JBHapusTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JBTambahUbahTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                                .addComponent(JCNamaKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
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
            JTInstruktur.requestFocus();
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
        JCNamaKaryawan.requestFocus();
    }//GEN-LAST:event_JBHapusTableActionPerformed

    private void JBRefreshTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRefreshTableActionPerformed
        RefreshTbl();
    }//GEN-LAST:event_JBRefreshTableActionPerformed

    private void JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseClicked
        if (JTable.getSelectedRow() != -1) {
            JCNamaKaryawan.setSelectedItem(JTable.getValueAt(JTable.getSelectedRow(), 1).toString());
            JTPenguasaanMateri.setText(JTable.getValueAt(JTable.getSelectedRow(), 2).toString());
            JTKemampuanBekerja.setText(JTable.getValueAt(JTable.getSelectedRow(), 3).toString());
            JBTambahUbahTable.setText("Ubah");
        }
    }//GEN-LAST:event_JTableMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (IdEdit == null) {
            tambahEvaluasiPelatihan = null;
        } else {
            ubahEvaluasiPelatihan = null;
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
            JTInstruktur.requestFocus();
        }
    }//GEN-LAST:event_JCNamaKaryawanKeyPressed

    private void JDTanggalMasukKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDTanggalMasukKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JDTanggalMasukKeyPressed

    private void JDTanggalKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDTanggalKeluarKeyPressed
        // TODO add your handling code here:
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
        if (JBTambahUbahTable.getText().equals("Tambah")) {
            if (checkTable()) {
                DefaultTableModel model = (DefaultTableModel) JTable.getModel();
                model.addRow(new Object[]{JTable.getRowCount() + 1, JCNamaKaryawan.getSelectedItem(), JTPenguasaanMateri.getInt(), JTKemampuanBekerja.getInt()});
                JOptionPane.showMessageDialog(this, "Berhasil Tambah Data");
                RefreshTbl();
            }
        } else {
            if (checkTableUbah()) {
                JTable.setValueAt(JCNamaKaryawan.getSelectedItem(), JTable.getSelectedRow(), 1);
                JTable.setValueAt(JTPenguasaanMateri.getInt(), JTable.getSelectedRow(), 2);
                JTable.setValueAt(JTKemampuanBekerja.getInt(), JTable.getSelectedRow(), 3);
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
                    Berhasil = multiInsert.Excute("INSERT INTO `snitbevaluasipelatihan`(`IdPelatihan`, `Tanggal`, `Instruktur`, `Kesimpulan`, `Keterangan`) VALUES ('" + JCNamaKaryawan.getSelectedItem().toString().split("\\(")[1].split("\\)")[0] + "','" + FDateF.datetostr(JDTanggalBergabung.getDate(), "yyyy-MM-dd") + "','" + JTInstruktur.getText() + "','" + JTAKesimpulan.getText() + "','" + JTAKeterangan.getText() + "')", null);
                    if (Berhasil) {
                        for (int i = 0; i < JTable.getRowCount(); i++) {
                            Berhasil = multiInsert.Excute("INSERT INTO `snitbevaluasipelatihandetail`(`IdEvaluasiPelatihan`, `IdPelatihanDetail`, `PenguasaanMateri`, `KemampuanBekerja`) VALUES ((SELECT `IdEvaluasiPelatihan` FROM `snitbevaluasipelatihan` ORDER BY `IdEvaluasiPelatihan` DESC LIMIT 1),(SELECT `IdPelatihanDetail` FROM `snitbpelatihandetail` AS A JOIN `tbmkaryawan` AS B ON A.`IdKaryawan`=B.`IdKaryawan` WHERE `IdPelatihan` = '" + JCNamaKaryawan.getSelectedItem().toString().split("\\(")[1].split("\\)")[0] + "' AND `NamaKaryawan` = '" + JTable.getValueAt(i, 1) + "'),'" + JTable.getValueAt(i, 2) + "','" + JTable.getValueAt(i, 3) + "')", null);
                        }
                    }
                }
            }
            if (Berhasil == false) {
                multiInsert.rollback();
                multiInsert.closecon();
                JOptionPane.showMessageDialog(this, "Gagal Tambah Data Evaluasi Pelatihan");
            }
            if (Berhasil == true) {
                JOptionPane.showMessageDialog(this, "Berhasil Tambah Data Evaluasi Pelatihan");
                multiInsert.Commit();
                multiInsert.closecon();
                if (tutup) {
                    dispose();
                } else {
                    JTable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{},
                            new String[]{
                                "No", "Nama Karyawan", "Penguasaan Materi", "Kemampuan Bekerja"
                            }
                    ));
                    RefreshTbl();
                    JTable.getColumnModel().getColumn(0).setPreferredWidth(50);
                    JTable.getColumnModel().getColumn(1).setPreferredWidth(278);
                    JTable.getColumnModel().getColumn(2).setPreferredWidth(176);
                    JTable.getColumnModel().getColumn(3).setPreferredWidth(171);
                    JCNamaKaryawan.load("SELECT '-- Pilih Pelatihan --' UNION ALL (SELECT CONCAT('(',A.`IdPelatihan`,') ',`JenisPelatihan`) FROM `snitbpelatihan` AS A LEFT JOIN `snitbevaluasipelatihan` AS B ON A.`IdPelatihan`=B.`IdPelatihan` JOIN `snitbusulpelatihan` AS C ON A.`IdUsulPelatihan`=C.`IdUsulPelatihan` WHERE B.`IdPelatihan` IS NULL GROUP BY `JenisPelatihan`, C.`Tanggal`, `Tempat`, `Waktu` ORDER BY `JenisPelatihan` ASC)");
                    JTJenisPelatihan.setText("");
                    JTTanggalPelatihan.setText("");
                    JTTempatWaktuPelatihan.setText("");
                    JTInstruktur.setText("");
                    JCNamaKaryawan.load("SELECT '-- Pilih Nama Karyawan --'");
                    JTAKesimpulan.setText("");
                    JTAKeterangan.setText("");
                    JCNamaKaryawan.requestFocus();
                }
                if (GlobalVar.Var.listEvaluasiPelatihan != null) {
                    GlobalVar.Var.listEvaluasiPelatihan.load();
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
                    Berhasil = multiInsert.Excute("UPDATE `snitbevaluasipelatihan` SET `IdPelatihan`='" + JCNamaKaryawan.getSelectedItem().toString().split("\\(")[1].split("\\)")[0] + "',`Tanggal`='" + FDateF.datetostr(JDTanggalBergabung.getDate(), "yyyy-MM-dd") + "',`Instruktur`='" + JTInstruktur.getText() + "',`Kesimpulan`='" + JTAKesimpulan.getText() + "',`Keterangan`='" + JTAKeterangan.getText() + "' WHERE `IdEvaluasiPelatihan` = '" + IdEdit + "'", null);
                    if (Berhasil) {
                        if (CountTable != 0) {
                            Berhasil = multiInsert.Excute("DELETE FROM `snitbevaluasipelatihandetail` WHERE `IdEvaluasiPelatihan` = '" + IdEdit + "'", null);
                        }
                        if (Berhasil) {
                            for (int i = 0; i < JTable.getRowCount(); i++) {
                                Berhasil = multiInsert.Excute("INSERT INTO `snitbevaluasipelatihandetail`(`IdEvaluasiPelatihan`, `IdPelatihanDetail`, `PenguasaanMateri`, `KemampuanBekerja`) VALUES (" + IdEdit + ",(SELECT `IdPelatihanDetail` FROM `snitbpelatihandetail` AS A JOIN `tbmkaryawan` AS B ON A.`IdKaryawan`=B.`IdKaryawan` WHERE `IdPelatihan` = '" + JCNamaKaryawan.getSelectedItem().toString().split("\\(")[1].split("\\)")[0] + "' AND `NamaKaryawan` = '" + JTable.getValueAt(i, 1) + "'),'" + JTable.getValueAt(i, 2) + "','" + JTable.getValueAt(i, 3) + "')", null);
                            }
                        }
                    }
                }
                if (Berhasil == false) {
                    multiInsert.rollback();
                    multiInsert.closecon();
                    JOptionPane.showMessageDialog(this, "Gagal Ubah Data Evaluasi Pelatihan");
                }
                if (Berhasil == true) {
                    JOptionPane.showMessageDialog(this, "Berhasil Ubah Data Evaluasi Pelatihan");
                    multiInsert.Commit();
                    multiInsert.closecon();
                    dispose();
                    if (GlobalVar.Var.listEvaluasiPelatihan != null) {
                        GlobalVar.Var.listEvaluasiPelatihan.load();
                    }
                }
            }
        }
    }
}
