package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connect.ConnectDB;
import entity.PhanCong;

public class DAO_PhanCong {
	public boolean update(PhanCong phanCong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pre = null;
		int n = 0;
		try {
			pre = con.prepareStatement(
					"UPDATE PhanCong SET ngayPC = ?, soLuong=? , congDoan=? WHERE maPC= ?");
			pre.setDate(1,(java.sql.Date) phanCong.getNgayPC());
			pre.setInt(2, phanCong.getSoLuong());
			pre.setString(3, phanCong.getCongDoanSX());
			pre.setString(4, phanCong.getMaPC());
			n = pre.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean delete(String idPC) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pre = null;
		int n = 0;
		try {
			pre = con.prepareStatement("delete from PhanCong where maPC=?");
			pre.setString(1, idPC);
			n = pre.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
}
