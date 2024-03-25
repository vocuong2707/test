package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.ChamCongCN;
import entity.ChamCongNV;
import entity.CongNhan;
import entity.NhanVien;
import entity.PhanCong;

public class DAO_ChamCongNV {
	public ArrayList<ChamCongNV> getAllDanhSachChamCong() {
		ArrayList<ChamCongNV> dsChamCongNV = new ArrayList<ChamCongNV>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT NV.tenNV, CC.coMat, CC.trangThai, CC.phep,CC.soGioTangCa ,CC.ghiChu "
					+ "FROM ChamCongNV CC JOIN NhanVien NV ON CC.nhanVien =NV.MaNV ";
			statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ChamCongNV chamCongNV = new ChamCongNV();
				NhanVien nV = new NhanVien();
				nV.setTenNhanVien(rs.getString("tenNV"));
				chamCongNV.setNhanVien(nV);
				chamCongNV.setCoMat(rs.getBoolean("coMat"));
				chamCongNV.setTrangThai(rs.getBoolean("trangThai"));
				chamCongNV.setPhep(rs.getBoolean("phep"));
				chamCongNV.setSoGioTangCa(rs.getInt("soGioTangCa"));
				chamCongNV.setGhiChu(rs.getString("ghiChu"));
				if (!dsChamCongNV.contains(chamCongNV)) {
					dsChamCongNV.add(chamCongNV);
				}
			}
			return dsChamCongNV;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public boolean update(ChamCongNV nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pre = null;
		int n = 0;
		try {
			pre = con.prepareStatement(
					"update ChamCongNV set coMat = ?, trangThai=? , phep=?, soGioTangCa= ? , ghiChu= ? where maChamCongNV= ?");
			pre.setBoolean(1, nv.isCoMat());
			pre.setBoolean(2, nv.isTrangThai());
			pre.setBoolean(3, nv.isPhep());
			pre.setInt(4, nv.getSoGioTangCa());
			pre.setString(5, nv.getMaChamCong());
			n = pre.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

	public ArrayList<ChamCongNV> timKiemDanhSachChamCongNVTheoTen(String tenNV) {
		ArrayList<ChamCongNV> dsChamCongNV = new ArrayList<ChamCongNV>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT NV.tenNV, CC.coMat, CC.trangThai, CC.phep,CC.soGioTangCa ,CC.ghiChu "
					+ "FROM ChamCongNV CC JOIN NhanVien NV ON CC.nhanVien =NV.MaNV " + "WHERE tenNV LIKE %"+ tenNV+"%";
			statement = con.prepareStatement(sql);
//			statement.setString(1, tenNV);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ChamCongNV chamCongNV = new ChamCongNV();
				NhanVien nV = new NhanVien();
				nV.setTenNhanVien(rs.getString("tenNV"));
				chamCongNV.setNhanVien(nV);
				chamCongNV.setCoMat(rs.getBoolean("coMat"));
				chamCongNV.setTrangThai(rs.getBoolean("trangThai"));
				chamCongNV.setPhep(rs.getBoolean("phep"));
				chamCongNV.setSoGioTangCa(rs.getInt("soGioTangCa"));
				chamCongNV.setGhiChu(rs.getString("ghiChu"));
				if (!dsChamCongNV.contains(chamCongNV)) {
					dsChamCongNV.add(chamCongNV);
				}
			}
			return dsChamCongNV;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<ChamCongNV> timKiemDanhSachChamCongNVTheoPB(String phongBan) {
		ArrayList<ChamCongNV> dsChamCongNV = new ArrayList<ChamCongNV>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT NV.tenNV, CC.coMat, CC.trangThai, CC.phep,CC.soGioTangCa ,CC.ghiChu "
					+ "FROM ChamCongNV CC JOIN NhanVien NV ON CC.nhanVien =NV.MaNV JOIN PhongBan PB ON PB.maPB = NV.phongBan "
					+ "WHERE tenPB LIKE ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, phongBan);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ChamCongNV chamCongNV = new ChamCongNV();
				NhanVien nV = new NhanVien();
				nV.setTenNhanVien(rs.getString("tenNV"));
				chamCongNV.setNhanVien(nV);
				chamCongNV.setCoMat(rs.getBoolean("coMat"));
				chamCongNV.setTrangThai(rs.getBoolean("trangThai"));
				chamCongNV.setPhep(rs.getBoolean("phep"));
				chamCongNV.setSoGioTangCa(rs.getInt("soGioTangCa"));
				chamCongNV.setGhiChu(rs.getString("ghiChu"));
				if (!dsChamCongNV.contains(chamCongNV)) {
					dsChamCongNV.add(chamCongNV);
				}
			}
			return dsChamCongNV;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
