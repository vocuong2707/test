package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.ChamCongCN;
import entity.CongNhan;
import entity.PhanCong;

public class DAO_ChamCongCN {	
	public ArrayList<ChamCongCN> getAllDanhSachChamCong() {
		ArrayList<ChamCongCN> dsChamCongCN = new ArrayList<ChamCongCN>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT CN.tenCN, PC.congDoan,CC.soSPHoanThanh,CC.soGioTangCa, CC.trangThai"
					+ "FROM ChamCongCN CC JOIN CongNhan CN ON CC.congNhan =CN.maCN  JOIN PhanCong PC ON PC.maPC= CN.phanCong";
			statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ChamCongCN chamCongCN = new ChamCongCN();
				CongNhan cN = new CongNhan();
				PhanCong phanCong = new PhanCong();
				cN.setTenCN(rs.getString("tenCN"));
				phanCong.setCongDoanSX(rs.getString("congDoan"));
				cN.setPhanCong(phanCong);
				chamCongCN.setCongNhan(cN);
				chamCongCN.setSoSPhoanThanh(rs.getInt("soSPHoanThanh"));
				chamCongCN.setSoGioTangCa(rs.getInt("soGioTangCa"));
				chamCongCN.setTrangThai(rs.getBoolean("trangThai"));
				dsChamCongCN.add(chamCongCN);
			}
			return dsChamCongCN;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean update(ChamCongCN cn) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pre = null;
		int n = 0;
		try {
			pre = con.prepareStatement(
					"update ChamCongCN set soSPHoanThanh = ?, soGioTangCa=? , trangThai=? where maChamCongCN= ?");
			pre.setInt(1, cn.getSoSPHoanThanh());
			pre.setInt(2, cn.getSoGioTangCa());
			pre.setBoolean(3, cn.isTrangThai());
			pre.setString(5, cn.getMaChamCong());
			n = pre.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}

	public ArrayList<ChamCongCN> timKiemDanhSachChamCongTheoTen(String tenCN) {
		ArrayList<ChamCongCN> dsChamCongCN = new ArrayList<ChamCongCN>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT CN.tenCN, P.congDoan, CC.soSPhoanthanh, CC.soGioTangCa, "
					+ "CC.trangThai FROM ChamCongCN CC JOIN CongNhan CN ON CC.congNhan =CN.maCN "
					+ "JOIN PhanCong P ON P.maPC= CN.phanCong WHERE tenCN LIKE %" + tenCN+"%";
			statement = con.prepareStatement(sql);
//			statement.setString(1, tenCN);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ChamCongCN chamCongCN = new ChamCongCN();
				CongNhan cN = new CongNhan();
				PhanCong phanCong = new PhanCong();
				cN.setTenCN(rs.getString("tenCN"));
				phanCong.setCongDoanSX(rs.getString("congDoan"));
				cN.setPhanCong(phanCong);
				chamCongCN.setCongNhan(cN);
				chamCongCN.setSoSPhoanThanh(rs.getInt("soSPhoanthanh"));
				chamCongCN.setSoGioTangCa(rs.getInt("soGioTangCa"));
				chamCongCN.setTrangThai(rs.getBoolean("trangThai"));
				if (!dsChamCongCN.contains(chamCongCN)) {
					dsChamCongCN.add(chamCongCN);
				}
			}
			return dsChamCongCN;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<ChamCongCN> timKiemDanhSachChamCongTheoCongDoan(String congDoan) {
		ArrayList<ChamCongCN> dsChamCongCN = new ArrayList<ChamCongCN>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT CN.tenCN, P.congDoan, CC.soSPhoanthanh, CC.soGioTangCa, "
					+ "CC.trangThai FROM ChamCongCN CC JOIN CongNhan CN ON CC.congNhan =CN.maCN "
					+ "JOIN PhanCong P ON P.maPC= CN.phanCong WHERE congDoan LIKE ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, congDoan);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ChamCongCN chamCongCN = new ChamCongCN();
				CongNhan cN = new CongNhan();
				PhanCong phanCong = new PhanCong();
				cN.setTenCN(rs.getString("tenCN"));
				phanCong.setCongDoanSX(rs.getString("congDoan"));
				cN.setPhanCong(phanCong);
				chamCongCN.setCongNhan(cN);
				chamCongCN.setSoSPhoanThanh(rs.getInt("soSPhoanthanh"));
				chamCongCN.setSoGioTangCa(rs.getInt("soGioTangCa"));
				chamCongCN.setTrangThai(rs.getBoolean("trangThai"));
				if (!dsChamCongCN.contains(chamCongCN)) {
					dsChamCongCN.add(chamCongCN);
				}
			}
			return dsChamCongCN;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
