/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Mode.HoaDon;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admin
 */
public class HoaDonServices {
    static String connectionUrl = "jdbc:sqlserver://26.107.57.204:1433;databaseName=DATN_PRO230;user=datn;password=123;trustServerCertificate=true";
    public static List<HoaDon> getAll() {
        String sql = "select MaHD,HoTenNV,MaDH,NgayLapHD,GiaTien from HoaDon join NhanVien on NhanVien.MaNV = HoaDon.MaNV";
        try(Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement ps = conn.prepareStatement(sql);) {
            List<HoaDon> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setMaNV(rs.getString("HoTenNV"));
                hd.setMaDH(rs.getString("MaDH"));
                hd.setNgayLapHD(rs.getString("NgayLapHD"));
                hd.setGiaTien(rs.getInt("GiaTien"));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<HoaDon> getById(String MaHD) {
        String sql = "select * from HoaDon where MaHD = ?";
        HoaDon hd = new HoaDon();
        try(Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, MaHD);
            List<HoaDon> hdlist = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hd.setMaHD(rs.getString("MaHD"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setMaDH(rs.getString("MaDH"));
                hd.setNgayLapHD(rs.getString("NgayLapHD"));
                hd.setGiaTien(rs.getInt("GiaTien"));
                hdlist.add(hd);
            }
            return hdlist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
