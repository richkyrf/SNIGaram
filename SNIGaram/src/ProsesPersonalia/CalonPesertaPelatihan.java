/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProsesPersonalia;

import LSubProces.DRunSelctOne;
import LSubProces.MultiInsert;
import LSubProces.RunSelct;
import java.awt.event.KeyEvent;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import static GlobalVar.Var.*;

/**
 *
 * @author richky
 */
public class CalonPesertaPelatihan extends javax.swing.JFrame {

    /**
     * Creates new form MasterPenjualan
     */
    String IdEdit;
    int CountTable;

    public CalonPesertaPelatihan() {
        initComponents();
        setVisible(true);
        setTitle("Tambah Calon Peserta Pelatihan");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JBUbah.setVisible(false);
        JCPelatihan.requestFocus();
    }

    public CalonPesertaPelatihan(Object idEdit) {
        IdEdit = idEdit.toString();
        initComponents();
        setVisible(true);
        setTitle("Ubah Calon Peserta Pelatihan");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JBTambah.setVisible(false);
        JBTambahTutup.setVisible(false);
        loadeditdata();
        JCPelatihan.requestFocus();
    }

    void loadeditdata() {
        JCPelatihan.load("SELECT '-- Pilih Pelatihan --' UNION ALL (SELECT CONCAT('(',A.`IdUsulPelatihan`,') ',`JenisPelatihan`) FROM `snitbusulpelatihan` AS A LEFT JOIN `snitbpelatihan` AS B ON A.`IdUsulPelatihan`=B.`IdUsulPelatihan` WHERE B.`IdUsulPelatihan` IS NULL OR `IdPelatihan`=" + IdEdit + " GROUP BY `JenisPelatihan`, `Tanggal`, `Tempat`, `Waktu` ORDER BY `JenisPelatihan` ASC)");
        DRunSelctOne dRunSelctOne = new DRunSelctOne();
        dRunSelctOne.seterorm("Eror Gagal Menampilkan Data Calon Peserta Pelatihan");
        dRunSelctOne.setQuery("SELECT `IdPelatihan`, CONCAT('(',A.`IdUsulPelatihan`,') ',`JenisPelatihan`), B.`Keterangan` FROM `snitbusulpelatihan` AS A JOIN `snitbpelatihan` AS B ON A.`IdUsulPelatihan`=B.`IdUsulPelatihan` WHERE `IdPelatihan` = '" + IdEdit + "'");
        ArrayList<String> list = dRunSelctOne.excute();
        JCPelatihan.setSelectedItem(list.get(1));
        JTAKeterangan.setText(list.get(2));
        DefaultTableModel model = (DefaultTableModel) JTable.getModel();
        model.getDataVector().removeAllElements();
        RunSelct runSelct = new RunSelct();
        runSelct.setQuery("SELECT `IdPelatihanDetail`, `NamaKaryawan` FROM `snitbpelatihandetail` AS A JOIN `snitbpelatihan` AS B ON A.`IdPelatihan`=B.`IdPelatihan` JOIN `tbmkaryawan` AS C ON A.`IdKaryawan`=C.`IdKaryawan` WHERE A.`IdPelatihan` = '" + list.get(0) + "'");
        try {
            ResultSet rs = runSelct.excute();
            int row = 0;
            while (rs.next()) {
                model.addRow(new Object[]{"", ""});
                JTable.setValueAt((row + 1), row, 0);
                JTable.setValueAt(rs.getString(2), row, 1);
                row++;
            }
            CountTable = JTable.getRowCount();
        } catch (SQLException e) {
            out.println("E6" + e);
            showMessageDialog(null, "Gagal Panggil Data Detail Calon Peserta Pelatihan");
        } finally {
            runSelct.closecon();
        }
    }

    Boolean checkInput(String action) {
        if (JCPelatihan.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Silahkan Pilih Pelatihan");
            JCPelatihan.requestFocus();
            return false;
        } else if (action.equals("Tambah") && JTable.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Detail Calon Peserta Tidak Boleh Kosong");
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
        } else if (cekdoubleitem(JCNamaKaryawan.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(this, "Tidak Bisa Input Karyawan Yang Sama");
            JCNamaKaryawan.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    boolean cekdoubleitem(String item) {
        for (int i = 0; i < JTable.getRowCount(); i++) {
            if (item.equals(JTable.getValueAt(i, 1)) && i != JTable.getSelectedRow()) {
                return true;
            }
        }
        return false;
    }

    void RefreshTbl() {
        JCNamaKaryawan.load("SELECT '-- Pilih Nama Karyawan --' UNION ALL (SELECT `NamaKaryawan` FROM `tbmkaryawan` WHERE `Status`=1 GROUP BY `NamaKaryawan` ORDER BY `NamaKaryawan` ASC)");
        JCNamaKaryawan.setSelectedIndex(0);
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

        JLPelatihan = new KomponenGUI.JlableF();
        JLPelatihan2 = new KomponenGUI.JlableF();
        JCPelatihan = new KomponenGUI.JcomboboxF();
        JLJenisPelatihan = new KomponenGUI.JlableF();
        JLJenisPelatihan2 = new KomponenGUI.JlableF();
        JTJenisPelatihan = new KomponenGUI.JtextF();
        JLTanggalPelatihan = new KomponenGUI.JlableF();
        JLTanggalPelatihan2 = new KomponenGUI.JlableF();
        JTTanggalPelatihan = new KomponenGUI.JtextF();
        JLTempatWaktuPelatihan = new KomponenGUI.JlableF();
        JLTempatWaktuPelatihan2 = new KomponenGUI.JlableF();
        JTTempatWaktuPelatihan = new KomponenGUI.JtextF();
        JSeparator1 = new javax.swing.JSeparator();
        JLDetailCalonPesertaPelatihan = new KomponenGUI.JlableF();
        JCNamaKaryawan = new KomponenGUI.JcomboboxF();
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

        JLPelatihan.setText("Pelatihan");

        JLPelatihan2.setText(":");

        JCPelatihan.load("SELECT '-- Pilih Pelatihan --' UNION ALL (SELECT CONCAT('(',A.`IdUsulPelatihan`,') ',`JenisPelatihan`) FROM `snitbusulpelatihan` AS A LEFT JOIN `snitbpelatihan` AS B ON A.`IdUsulPelatihan`=B.`IdUsulPelatihan` WHERE B.`IdUsulPelatihan` IS NULL GROUP BY `JenisPelatihan`, `Tanggal`, `Tempat`, `Waktu` ORDER BY `JenisPelatihan` ASC)");
        JCPelatihan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCPelatihanItemStateChanged(evt);
            }
        });
        JCPelatihan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCPelatihanKeyPressed(evt);
            }
        });

        JLJenisPelatihan.setText("Jenis Pelatihan");

        JLJenisPelatihan2.setText(":");

        JTJenisPelatihan.setEnabled(false);

        JLTanggalPelatihan.setText("Tanggal Pelatihan");

        JLTanggalPelatihan2.setText(":");

        JTTanggalPelatihan.setEnabled(false);

        JLTempatWaktuPelatihan.setText("Tempat dan Waktu Pelatihan");

        JLTempatWaktuPelatihan2.setText(":");

        JTTempatWaktuPelatihan.setEnabled(false);

        JLDetailCalonPesertaPelatihan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLDetailCalonPesertaPelatihan.setText("-- Detail Calon Peserta Pelatihan --");

        JCNamaKaryawan.load("SELECT '-- Pilih Nama Karyawan --' UNION ALL (SELECT `NamaKaryawan` FROM `tbmkaryawan` WHERE `Status`=1 GROUP BY `NamaKaryawan` ORDER BY `NamaKaryawan` ASC)");
        JCNamaKaryawan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JCNamaKaryawanKeyPressed(evt);
            }
        });

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nama Karyawan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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
            JTable.getColumnModel().getColumn(1).setMinWidth(625);
            JTable.getColumnModel().getColumn(1).setPreferredWidth(625);
            JTable.getColumnModel().getColumn(1).setMaxWidth(625);
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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JLKeterangan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JSPKeterangan))
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
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(JSPTable, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                                            .addComponent(JCNamaKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JBTambahUbahTable, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JBHapusTable, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JBRefreshTable, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(JLPelatihan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(JLTempatWaktuPelatihan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(JLTempatWaktuPelatihan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JTTempatWaktuPelatihan, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(JLPelatihan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JCPelatihan, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JLTanggalPelatihan, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JLTanggalPelatihan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTTanggalPelatihan, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JLJenisPelatihan, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JLJenisPelatihan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTJenisPelatihan, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JLDetailCalonPesertaPelatihan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLPelatihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLPelatihan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCPelatihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLJenisPelatihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLJenisPelatihan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTJenisPelatihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLTanggalPelatihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLTanggalPelatihan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTTanggalPelatihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLTempatWaktuPelatihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLTempatWaktuPelatihan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTTempatWaktuPelatihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(JLDetailCalonPesertaPelatihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTambahUbahTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCNamaKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBHapusTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBRefreshTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JSPTable, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void JCNamaKaryawanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCNamaKaryawanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            TambahUbahTabel();
        }
    }//GEN-LAST:event_JCNamaKaryawanKeyPressed

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
            JCNamaKaryawan.load("SELECT '-- Pilih Nama Karyawan --' UNION ALL (SELECT `NamaKaryawan` FROM `tbmkaryawan` WHERE `Status`=1 OR `NamaKaryawan`='" + JTable.getValueAt(JTable.getSelectedRow(), 1).toString() + "' GROUP BY `NamaKaryawan` ORDER BY `NamaKaryawan` ASC)");
            JCNamaKaryawan.setSelectedItem(JTable.getValueAt(JTable.getSelectedRow(), 1).toString());
            JBTambahUbahTable.setText("Ubah");
            JCNamaKaryawan.requestFocus();
        }
    }//GEN-LAST:event_JTableMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (IdEdit == null) {
            tambahCalonPesertaPelatihan = null;
        } else {
            ubahCalonPesertaPelatihan = null;
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

    private void JCPelatihanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCPelatihanItemStateChanged
        if (JCPelatihan.getSelectedIndex() != 0) {
            DRunSelctOne dRunSelctOne = new DRunSelctOne();
            dRunSelctOne.seterorm("Gagal Load Data Pelatihan");
            dRunSelctOne.setQuery("SELECT `JenisPelatihan`, DATE_FORMAT(`Tanggal`, '%d/%m/%Y'), CONCAT(`Tempat`,' : ',REPLACE(SUBSTRING(`Waktu`,1,5),':','.')) FROM `snitbusulpelatihan` WHERE `IdUsulPelatihan`= '" + JCPelatihan.getSelectedItem().toString().split("\\(")[1].split("\\)")[0] + "'");
            ArrayList<String> list = dRunSelctOne.excute();
            JTJenisPelatihan.setText(list.get(0));
            JTTanggalPelatihan.setText(list.get(1));
            JTTempatWaktuPelatihan.setText(list.get(2));
        } else {
            JTJenisPelatihan.setText("");
            JTTanggalPelatihan.setText("");
            JTTempatWaktuPelatihan.setText("");
        }
    }//GEN-LAST:event_JCPelatihanItemStateChanged

    private void JCPelatihanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCPelatihanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            JCNamaKaryawan.requestFocus();
        }
    }//GEN-LAST:event_JCPelatihanKeyPressed

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
            java.util.logging.Logger.getLogger(CalonPesertaPelatihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalonPesertaPelatihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalonPesertaPelatihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalonPesertaPelatihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalonPesertaPelatihan().setVisible(true);
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
    private KomponenGUI.JcomboboxF JCPelatihan;
    private KomponenGUI.JlableF JLDetailCalonPesertaPelatihan;
    private KomponenGUI.JlableF JLJenisPelatihan;
    private KomponenGUI.JlableF JLJenisPelatihan2;
    private KomponenGUI.JlableF JLKeterangan;
    private KomponenGUI.JlableF JLKeterangan2;
    private KomponenGUI.JlableF JLPelatihan;
    private KomponenGUI.JlableF JLPelatihan2;
    private KomponenGUI.JlableF JLTanggalPelatihan;
    private KomponenGUI.JlableF JLTanggalPelatihan2;
    private KomponenGUI.JlableF JLTempatWaktuPelatihan;
    private KomponenGUI.JlableF JLTempatWaktuPelatihan2;
    private javax.swing.JScrollPane JSPKeterangan;
    private javax.swing.JScrollPane JSPTable;
    private javax.swing.JSeparator JSeparator1;
    private javax.swing.JSeparator JSeparator2;
    private KomponenGUI.JTextAreaF JTAKeterangan;
    private KomponenGUI.JtextF JTJenisPelatihan;
    private KomponenGUI.JtextF JTTanggalPelatihan;
    private KomponenGUI.JtextF JTTempatWaktuPelatihan;
    private KomponenGUI.JtableF JTable;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    void TambahUbahTabel() {
        JCNamaKaryawan.hidePopup();
        if (checkTable()) {
            if (JBTambahUbahTable.getText().equals("Tambah")) {
                DefaultTableModel model = (DefaultTableModel) JTable.getModel();
                model.addRow(new Object[]{JTable.getRowCount() + 1, JCNamaKaryawan.getSelectedItem()});
                JOptionPane.showMessageDialog(this, "Berhasil Tambah Data");
                RefreshTbl();
            } else {
                JTable.setValueAt(JCNamaKaryawan.getSelectedItem(), JTable.getSelectedRow(), 1);
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
                    Berhasil = multiInsert.Excute("INSERT INTO `snitbpelatihan`(`IdUsulPelatihan`, `Keterangan`) VALUES ('" + JCPelatihan.getSelectedItem().toString().split("\\(")[1].split("\\)")[0] + "','" + JTAKeterangan.getText() + "')", null);
                    if (Berhasil) {
                        for (int i = 0; i < JTable.getRowCount(); i++) {
                            Berhasil = multiInsert.Excute("INSERT INTO `snitbpelatihandetail`(`IdPelatihan`, `IdKaryawan`) VALUES ((SELECT `IdPelatihan` FROM `snitbpelatihan` ORDER BY `IdPelatihan` DESC LIMIT 1),(SELECT `IdKaryawan` FROM `tbmkaryawan` WHERE `NamaKaryawan` = '" + JTable.getValueAt(i, 1) + "'))", null);
                        }
                    }
                }
            }
            if (Berhasil == false) {
                multiInsert.rollback();
                multiInsert.closecon();
                JOptionPane.showMessageDialog(this, "Gagal Tambah Data Calon Peserta Pelatihan");
            }
            if (Berhasil == true) {
                JOptionPane.showMessageDialog(this, "Berhasil Tambah Data Calon Peserta Pelatihan");
                multiInsert.Commit();
                multiInsert.closecon();
                if (tutup) {
                    dispose();
                } else {
                    JTable.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{},
                            new String[]{
                                "No", "Nama Karyawan"
                            }
                    ));
                    RefreshTbl();
                    JTable.getColumnModel().getColumn(0).setPreferredWidth(50);
                    JTable.getColumnModel().getColumn(1).setPreferredWidth(625);
                    JCPelatihan.load("SELECT '-- Pilih Pelatihan --' UNION ALL (SELECT CONCAT('(',A.`IdUsulPelatihan`,') ',`JenisPelatihan`) FROM `snitbusulpelatihan` AS A LEFT JOIN `snitbpelatihan` AS B ON A.`IdUsulPelatihan`=B.`IdUsulPelatihan` WHERE B.`IdUsulPelatihan` IS NULL GROUP BY `JenisPelatihan`, `Tanggal`, `Tempat`, `Waktu` ORDER BY `JenisPelatihan` ASC)");
                    JTJenisPelatihan.setText("");
                    JTTanggalPelatihan.setText("");
                    JTTempatWaktuPelatihan.setText("");
                    JTAKeterangan.setText("");
                    JCPelatihan.requestFocus();
                }
                if (GlobalVar.Var.listCalonPesertaPelatihan != null) {
                    GlobalVar.Var.listCalonPesertaPelatihan.load();
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
                    Berhasil = multiInsert.Excute("UPDATE `snitbpelatihan` SET `IdUsulPelatihan`='" + JCPelatihan.getSelectedItem().toString().split("\\(")[1].split("\\)")[0] + "',`Keterangan`='" + JTAKeterangan.getText() + "' WHERE `IdPelatihan` = '" + IdEdit + "'", null);
                    if (Berhasil) {
                        if (CountTable != 0) {
                            Berhasil = multiInsert.Excute("DELETE FROM `snitbpelatihandetail` WHERE `IdPelatihan` = '" + IdEdit + "'", null);
                        }
                        if (Berhasil) {
                            for (int i = 0; i < JTable.getRowCount(); i++) {
                                Berhasil = multiInsert.Excute("INSERT INTO `snitbpelatihandetail`(`IdPelatihan`, `IdKaryawan`) VALUES (" + IdEdit + ",(SELECT `IdKaryawan` FROM `tbmkaryawan` WHERE `NamaKaryawan` = '" + JTable.getValueAt(i, 1) + "'))", null);
                            }
                        }
                    }
                }
                if (Berhasil == false) {
                    multiInsert.rollback();
                    multiInsert.closecon();
                    JOptionPane.showMessageDialog(this, "Gagal Ubah Data Calon Peserta Pelatihan");
                }
                if (Berhasil == true) {
                    JOptionPane.showMessageDialog(this, "Berhasil Ubah Data Calon Peserta Pelatihan");
                    multiInsert.Commit();
                    multiInsert.closecon();
                    dispose();
                    if (GlobalVar.Var.listCalonPesertaPelatihan != null) {
                        GlobalVar.Var.listCalonPesertaPelatihan.load();
                    }
                }
            }
        }
    }
}
