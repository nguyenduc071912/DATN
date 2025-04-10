/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GiaoDien;

import Mode.Kho;
import Services.KhoServices;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class QuanLyKho extends javax.swing.JFrame {

    private Timer timer;

    DefaultTableModel tableModel;

    /**
     * Creates new form QuanLyKho
     */
    public QuanLyKho() {
        initComponents();
        initTable();
        loadData();
        startAutoRefresh();
    }

    public void initTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã nguyên liệu", "Tên nguyên liệu", "Số lượng", "Đơn vị"});
        tblKho.setModel(tableModel);
    }

    public void loadData() {
        List<Kho> kList = KhoServices.getAll();
        tableModel.setNumRows(0);
        for (Kho k : kList) {
            tableModel.addRow(new Object[]{k.getMaNL(), k.getTenNL(), Integer.valueOf((int) k.getSoLuong()), k.getDonVi()});
        }
    }

    public void startAutoRefresh() {
        timer = new Timer(2000, new ActionListener() {
            // 2000ms = 2 giây
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData(); // Gọi phương thức cập nhật bảng
            }
        });
        timer.start(); // Chạy Timer
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKho = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSoluong = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cboDonVi = new javax.swing.JComboBox<>();
        cboTimKiem = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 51));
        jLabel1.setText("Quản lý kho");

        tblKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã nguyên liệu", "Tên nguyên liệu", "Số lượng", "Đơn vị"
            }
        ));
        tblKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKho);

        jLabel2.setText("Mã nguyên liệu");

        jLabel3.setText("Tên nguyên liệu");

        jLabel4.setText("Số lượng");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTim.setText("Tìm kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel5.setText("Đơn vị");

        cboDonVi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gói", "Quả" }));

        cboTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã nguyên liệu", "Tên nguyên liệu" }));

        jLabel6.setText("Chọn tìm kiếm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(21, 21, 21))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(59, 59, 59)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(72, 72, 72)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoluong, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                            .addComponent(txtMa)
                            .addComponent(txtTen)
                            .addComponent(cboDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTimKiem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(423, 423, 423)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTim)
                            .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cboDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String key = txtTim.getText();
        if(key.equals("")){
            JOptionPane.showMessageDialog(this,"Nhập keyword bạn cần");
            return;
        }
        String chon = cboTimKiem.getSelectedItem().toString();
        KhoServices k = new KhoServices();
        ArrayList<Kho> qlk = (ArrayList<Kho>) KhoServices.TimKiem(key, chon);
        tableModel.setNumRows(0);
        for (Kho K : qlk) {
            tableModel.addRow(new Object[]{K.getMaNL(), K.getTenNL(), Integer.valueOf((int) K.getSoLuong()), K.getDonVi()});
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (txtMa.getText().isEmpty()) {
            sb.append("Nhập mã nguyên liệu\n");
        }
        if (txtTen.getText().isEmpty()) {
            sb.append("Nhập tên nguyên liệu\n");
        }
        if (txtSoluong.getText().isEmpty()) {
            sb.append("Nhập số lượng\n");
        } else {
            try {
                int soLuong = Integer.parseInt(txtSoluong.getText());
                if (soLuong <= 0) {
                    sb.append("Số lượng phải lớn hơn 0");
                }
            } catch (NumberFormatException e) {
                sb.append("Nhập đúng định dạng số lượng\n");
            }
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(null, sb.toString(), "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Kho k = new Kho();
            k.setMaNL(txtMa.getText());
            k.setTenNL(txtTen.getText());
            k.setSoLuong(Integer.parseInt(txtSoluong.getText()));
            k.setDonVi(cboDonVi.getSelectedItem().toString());
            int chose = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION);
            if (chose == JOptionPane.YES_OPTION) {
                if (KhoServices.Create(k)) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (txtMa.getText().isEmpty()) {
            sb.append("Nhập mã nguyên liệu\n");
        }
        if (txtTen.getText().isEmpty()) {
            sb.append("Nhập tên nguyên liệu\n");
        }
        if (txtSoluong.getText().isEmpty()) {
            sb.append("Nhập số lượng\n");
        } else {
            try {
                int soLuong = Integer.parseInt(txtSoluong.getText());
                if (soLuong <= 0) {
                    sb.append("Số lượng phải lớn hơn 0");
                }
            } catch (NumberFormatException e) {
                sb.append("Nhập đúng định dạng số lượng\n");
            }
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(null, sb.toString(), "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Kho k = new Kho();
            k.setMaNL(txtMa.getText());
            k.setTenNL(txtTen.getText());
            k.setSoLuong(Integer.parseInt(txtSoluong.getText()));
            k.setDonVi(cboDonVi.getSelectedItem().toString());
            int chose = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION);
            if (chose == JOptionPane.YES_OPTION) {
                if (KhoServices.Update(k)) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (txtMa.getText().isEmpty()) {
            sb.append("Nhập mã nguyên liệu\n");
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(null, sb.toString(), "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Kho k = new Kho();
            k.setMaNL(txtMa.getText());
            int chose = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION);
            if (chose == JOptionPane.YES_OPTION) {
                if (KhoServices.Delete(k)) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhoMouseClicked
        // TODO add your handling code here:
        int row = tblKho.getSelectedRow();
        if (row > -1) {
            String ma = (String) tblKho.getValueAt(row, 0);
            Kho k = KhoServices.getByName(ma);
            txtMa.setText(k.getMaNL());
            txtTen.setText(k.getTenNL());
            txtSoluong.setText(String.valueOf((int) k.getSoLuong()));
            cboDonVi.setSelectedItem(k.getDonVi());
        }
    }//GEN-LAST:event_tblKhoMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLyKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKho().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboDonVi;
    private javax.swing.JComboBox<String> cboTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblKho;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
