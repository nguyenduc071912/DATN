/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GiaoDien;
import Mode.DoanhThu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Administrator
 */
public class ThongKe extends javax.swing.JFrame {
    private Timer timer;
    static String connectionUrl = "jdbc:sqlserver://26.107.57.204:1433;databaseName=DATN_PRO230;user=datn;password=123;trustServerCertificate=true";
    DefaultTableModel tblModel;
    /**
     * Creates new form ThongKe
     */
    public ThongKe() {
        initComponents();
        initTable();
        LoadData();
        
    }
    
    public List<DoanhThu> getAll(int nam) {
        String sql = "EXEC ThongKeDoanhThuTheoNam @Nam = ?";
        try(Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, nam);
            List<DoanhThu> dtlist = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                DoanhThu dt = new DoanhThu();
                dt.setThang(rs.getString("Thang"));
                dt.setSanPham(rs.getString("TenSanPham"));
                dt.setSoLuong(rs.getInt("SoLuongDonHang"));
                dt.setTongTien(rs.getString("TongTienBanRa"));
                dtlist.add(dt);
            }
            return dtlist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void cboNam(int nam){
        List<DoanhThu> dtlist = getAll(nam);
        tblModel.setNumRows(0);
        for (DoanhThu dt : dtlist) {
            tblModel.addRow(new Object[]{dt.getThang(),dt.getSanPham(),dt.getSoLuong(),dt.getTongTien()});
        }
    }
    
    public List<DoanhThu> getAll2025() {
        String sql = "EXEC ThongKeDoanhThuTheoNam @Nam = 2025";
        try(Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement ps = conn.prepareStatement(sql);) {
            List<DoanhThu> dtlist = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                DoanhThu dt = new DoanhThu();
                dt.setThang(rs.getString("Thang"));
                dt.setSanPham(rs.getString("TenSanPham"));
                dt.setSoLuong(rs.getInt("SoLuongDonHang"));
                dt.setTongTien(rs.getString("TongTienBanRa"));
                dtlist.add(dt);
            }
            return dtlist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void initTable(){
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"Tháng","Tên sản phẩm","Số lượng đơn","Tổng tiền bán ra"});
        tblThongKeDoanhThu.setModel(tblModel);
    }
    
    public void LoadData(){
        List<DoanhThu> dtlist = getAll2025();
        tblModel.setNumRows(0);
        for (DoanhThu dt : dtlist) {
            tblModel.addRow(new Object[]{dt.getThang(),dt.getSanPham(),dt.getSoLuong(),dt.getTongTien()});
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblThongKeDoanhThu = new javax.swing.JTable();
        cboNam = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 51));
        jLabel1.setText("Thống kê doanh thu");

        tblThongKeDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tháng", "Tên sản phẩm", "Số lượng đơn hàng", "Tổng tiền bán ra"
            }
        ));
        jScrollPane5.setViewportView(tblThongKeDoanhThu);

        cboNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2025", "2026" }));
        cboNam.setSelectedIndex(1);
        cboNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(383, 383, 383)
                .addComponent(jLabel1)
                .addContainerGap(388, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboNam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamActionPerformed
        // TODO add your handling code here:
        String namStr = (String) cboNam.getSelectedItem();
        int nam = Integer.parseInt(namStr);
        cboNam(nam);
    }//GEN-LAST:event_cboNamActionPerformed

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
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblThongKeDoanhThu;
    // End of variables declaration//GEN-END:variables
}
