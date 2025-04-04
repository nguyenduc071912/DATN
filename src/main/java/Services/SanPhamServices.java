/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;


import Mode.SanPham;
import static Services.KhoServices.connectionUrl;
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
public class SanPhamServices {
    static String connectionUrl = "jdbc:sqlserver://26.107.57.204:1433;databaseName=DATN_PRO230;user=datn;password=123;trustServerCertificate=true";
    
    public static List<SanPham> getAll(){
        String sql = "select MaSP,Kho.TenNL,TenSP,GiaTien,LoaiSP,MoTa from SanPham join Kho on SanPham.MaNL = Kho.MaNL";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            List<SanPham> spList = new ArrayList<>();
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setMaNL(rs.getString("TenNL"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setGiaTien(rs.getInt("GiaTien"));
                sp.setLoaiSP(rs.getString("LoaiSP"));
                sp.setMoTa(rs.getString("MoTa"));
                spList.add(sp);
            }
            return spList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static SanPham getByName(String MaSP){
        String sql = "select MaSP,MaNL,TenSP,GiaTien,LoaiSP,MoTa from SanPham where MaSP = ?";
        SanPham sp = new SanPham();
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1,MaSP);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                sp.setMaSP(rs.getString("MaSP"));
                sp.setMaNL(rs.getString("MaNL"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setGiaTien(rs.getInt("GiaTien"));
                sp.setLoaiSP(rs.getString("LoaiSP"));
                sp.setMoTa(rs.getString("MoTa"));
            }
            return sp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<SanPham> getById(String MaSP){
        String sql = "select MaSP,MaNL,TenSP,GiaTien,LoaiSP,MoTa from SanPham where MaSP = ?";
        SanPham sp = new SanPham();
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1,MaSP);
            List<SanPham> spList = new ArrayList<>();
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                sp.setMaSP(rs.getString("MaSP"));
                sp.setMaNL(rs.getString("MaNL"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setGiaTien(rs.getInt("GiaTien"));
                sp.setLoaiSP(rs.getString("LoaiSP"));
                sp.setMoTa(rs.getString("MoTa"));
                spList.add(sp);
            }
            return spList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean Create(SanPham sp){
        String sql = "insert into SanPham(MaSP,MaNL,TenSP,GiaTien,LoaiSP,MoTa)VALUES(?,?,?,?,?,?)";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1,sp.getMaSP());
            stm.setString(2,sp.getMaNL());
            stm.setString(3,sp.getTenSP());
            stm.setString(4,String.valueOf(sp.getGiaTien()));
            stm.setString(5,sp.getLoaiSP());
            stm.setString(6,sp.getMoTa());
            return stm.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean Update(SanPham sp){
        String sql = "update SanPham set MaNL = ?,TenSP = ?,GiaTien = ?,LoaiSP = ?,MoTa =?  WHERE MaSP = ?";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(6,sp.getMaSP());
            stm.setString(1,sp.getMaNL());
            stm.setString(2,sp.getTenSP());
            stm.setString(3,String.valueOf(sp.getGiaTien()));
            stm.setString(4,sp.getLoaiSP());
            stm.setString(5,sp.getMoTa());
            return stm.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean Delete(SanPham sp){
        String sql = "delete from SanPham where MaSP=?";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1,sp.getMaSP());
            return stm.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
