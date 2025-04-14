/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GiaoDien;

import Mode.KhachHang;
import Services.KhachHangServices;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class QuanLyKhachHang extends javax.swing.JFrame {
    DefaultTableModel tableModel;
    static String connectionUrl = "jdbc:sqlserver://26.107.57.204:1433;databaseName=DATN_PRO230;user=datn;password=123;trustServerCertificate=true";
    /**
     * Creates new form QuanLyKhachHang
     */
    public QuanLyKhachHang() {
        initComponents();
        initTable();
        loadData();
    }
    public void initTable(){
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã khách hàng","Tên khách hàng","Tuổi","Giới tính","Số điện thoại"});
        tblKH.setModel(tableModel);
    }
    public void loadData(){
        List<KhachHang> khList = KhachHangServices.getAll();
        tableModel.setNumRows(0);
        for(KhachHang kh: khList){
            tableModel.addRow(new Object[]{kh.getMaKH(),kh.getTenKH(),kh.getTuoi(),kh.getGioiTinh() == 0 ? "Nam":"Nữ",String.valueOf(kh.getSDT())});
        }
    }
    public boolean SoDienThoai(String phoneNumber) {
        String regex = "0[0-9]{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKH = new javax.swing.JTable();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        cboTimKiem = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnTaoMa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 51));
        jLabel1.setText("Quản lý khách hàng");

        jLabel2.setText("Mã khách hàng");

        jLabel3.setText("Tên khách hàng");

        jLabel4.setText("Giới tính");

        jLabel5.setText("Tuổi");

        jLabel6.setText("Số điện thoại");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

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

        tblKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Tuổi", "Giới tính", "Số điện thoại"
            }
        ));
        tblKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKHMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKH);

        btnTim.setText("Tìm kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        cboTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã khách hàng", "Tên khách hàng" }));

        jLabel7.setText("Chọn tìm kiếm");

        btnTaoMa.setText("+");
        btnTaoMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(43, 43, 43)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTaoMa)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTimKiem, 0, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTim))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtSDT)
                                        .addGap(3, 3, 3)))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa)
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(357, 357, 357)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnTaoMa))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(txtMa.getText().isEmpty()){
            sb.append("Nhập mã khách hàng\n");
        }
        if(txtTen.getText().isEmpty()){
            sb.append("Nhập tên khách hàng\n");
        }
        if(txtTuoi.getText().isEmpty()){
            sb.append("Nhập tuổi khách hàng\n");
        }else{
            try {
                int namSinh = Integer.parseInt(txtTuoi.getText());
                if (namSinh >= 2022) {
                    sb.append("Chưa đủ 3 tuổi trở lên để mua hàng\n");
                }
            } catch (NumberFormatException e) {
                sb.append("Vui lòng nhập số hợp lệ cho tuổi\n");
            }
        }
        if(!rdoNam.isSelected() && !rdoNu.isSelected()){
            sb.append("Chọn giới tính khách hàng\n");
        }
        if(txtSDT.getText().isEmpty()){
            sb.append("Nhập số điện thoại khách hàng\n");
        }else{
            try {
                if(!SoDienThoai(txtSDT.getText())){
                    sb.append("Vui lòng nhập đúng định dạng số điện thoại Việt Nam\n");
                }
            } catch (Exception e) {
            }
        }
        if(sb.length()>0){
            JOptionPane.showMessageDialog(null, sb.toString(),"Thông báo",JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            KhachHang kh = new KhachHang();
            kh.setMaKH(txtMa.getText());
            kh.setTenKH(txtTen.getText());
            kh.setTuoi(Integer.parseInt(txtTuoi.getText()));
            if(rdoNam.isSelected()){
                kh.setGioiTinh(0);
            }else{
                kh.setGioiTinh(1);
            }
            kh.setSDT(txtSDT.getText());
            int chose = JOptionPane.showConfirmDialog(this,"Bạn có muốn thêm","Thông báo",JOptionPane.YES_NO_CANCEL_OPTION);
            if(chose == JOptionPane.YES_OPTION){
                if(KhachHangServices.Create(kh)){
                    JOptionPane.showMessageDialog(this,"Thêm thành công");
                    loadData();
                }else{
                    JOptionPane.showMessageDialog(this,"Thêm thất bại");
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(txtMa.getText().isEmpty()){
            sb.append("Nhập mã khách hàng\n");
        }
        if(txtTen.getText().isEmpty()){
            sb.append("Nhập tên khách hàng\n");
        }
        if(txtTuoi.getText().isEmpty()){
            sb.append("Nhập tuổi khách hàng\n");
        }else{
            try {
                int namSinh = Integer.parseInt(txtTuoi.getText());
                if (namSinh >= 2009) {
                    sb.append("Chưa đủ 16 tuổi để mua hàng\n");
                }
            } catch (NumberFormatException e) {
                sb.append("Vui lòng nhập số hợp lệ cho tuổi\n");
            }
        }
        if(!rdoNam.isSelected() && !rdoNu.isSelected()){
            sb.append("Chọn giới tính khách hàng\n");
        }
        if(txtSDT.getText().isEmpty()){
            sb.append("Nhập số điện thoại khách hàng\n");
        }else{
            try {
                if(!SoDienThoai(txtSDT.getText())){
                    sb.append("Vui lòng nhập đúng định dạng số điện thoại Việt Nam\n");
                }
            } catch (Exception e) {
            }
        }
        if(sb.length()>0){
            JOptionPane.showMessageDialog(null, sb.toString(),"Thông báo",JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            KhachHang kh = new KhachHang();
            kh.setMaKH(txtMa.getText());
            kh.setTenKH(txtTen.getText());
            kh.setTuoi(Integer.parseInt(txtTuoi.getText()));
            if(rdoNam.isSelected()){
                kh.setGioiTinh(0);
            }else{
                kh.setGioiTinh(1);
            }
            kh.setSDT(txtSDT.getText());
            int chose = JOptionPane.showConfirmDialog(this,"Bạn có muốn sửa","Thông báo",JOptionPane.YES_NO_CANCEL_OPTION);
            if(chose == JOptionPane.YES_OPTION){
                if(KhachHangServices.Update(kh)){
                    JOptionPane.showMessageDialog(this,"Sửa thành công");
                    loadData();
                }else{
                    JOptionPane.showMessageDialog(this,"Sửa thất bại");
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(txtMa.getText().isEmpty()){
            sb.append("Nhập mã khách hàng\n");
        }
        if(sb.length()>0){
            JOptionPane.showMessageDialog(null, sb.toString(),"Thông báo",JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            KhachHang kh = new KhachHang();
            kh.setMaKH(txtMa.getText());
            int chose = JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa","Thông báo",JOptionPane.YES_NO_CANCEL_OPTION);
            if(chose == JOptionPane.YES_OPTION){
                if(KhachHangServices.Delete(kh)){
                    JOptionPane.showMessageDialog(this,"Xóa thành công");
                    loadData();
                }else{
                    JOptionPane.showMessageDialog(this,"Xóa thất bại");
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String key = txtTim.getText();
        if(key.equals("")){
            JOptionPane.showMessageDialog(this,"Nhập keyword bạn cần");
            return;
        }
        String chon = cboTimKiem.getSelectedItem().toString();
        KhachHangServices kh = new KhachHangServices();
        ArrayList<KhachHang> qlkh = (ArrayList<KhachHang>) KhachHangServices.TimKiem(key, chon);
        tableModel.setNumRows(0);
        for (KhachHang KH : qlkh) {
            tableModel.addRow(new Object[]{KH.getMaKH(),KH.getTenKH(),KH.getTuoi(),KH.getGioiTinh() == 0 ? "Nam":"Nữ",String.valueOf(KH.getSDT())});
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void tblKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKHMouseClicked
        // TODO add your handling code here:
        int row = tblKH.getSelectedRow();
        if(row>-1){
            String ma = (String) tblKH.getValueAt(row, 0);
            KhachHang kh = KhachHangServices.getByName(ma);
            txtMa.setText(kh.getMaKH());
            txtTen.setText(kh.getTenKH());
            txtTuoi.setText(String.valueOf(kh.getTuoi()));
            if(kh.getGioiTinh()==0){
                rdoNam.setSelected(true);
            }else{
                rdoNu.setSelected(true);
            }
            txtSDT.setText(kh.getSDT());
        }
    }//GEN-LAST:event_tblKHMouseClicked

    private void btnTaoMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMaActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "SELECT MAX(MaKH) FROM KhachHang";
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            int soMoi = 1;
            if (rs.next() && rs.getString(1) != null) {
                String maCu = rs.getString(1); 
                String soStr = maCu.substring(2).trim();
                soMoi = Integer.parseInt(soStr) + 1;
                String maMoi = String.format("KH%02d", soMoi);
                txtMa.setText(maMoi);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi tạo mã khách hàng");
        }
    }//GEN-LAST:event_btnTaoMaActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaoMa;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblKH;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
