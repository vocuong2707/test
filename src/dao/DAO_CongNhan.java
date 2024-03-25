package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Stack;

import connect.ConnectDB;
import entity.CongNhan;
import entity.Kho;
import entity.NhanVien;
import entity.PhanCong;
import entity.PhongBan;


public class DAO_CongNhan {
	public ArrayList<CongNhan> getAllCongNhan() {
		ArrayList<CongNhan> list = new ArrayList<CongNhan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
//		maCN,tenCN,gioiTinh,ngaySinh,CMND,diaChi,phuCap\r\n
		try {
			String sql = "SELECT *" + "FROM CongNhan";
			statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				CongNhan cN = new CongNhan();
				cN.setMaCN(rs.getString("maCN"));
				cN.setTenCN(rs.getString("tenCN"));
				cN.setGioiTinh(rs.getBoolean("gioiTinh"));
				cN.setNgaySinh(rs.getDate("ngaySinh"));
				cN.setCMND(rs.getString("CMND"));
				cN.setDiaChi(rs.getString("diaChi"));
				cN.setPhuCap(rs.getDouble("phuCap"));
				cN.setAnh(rs.getString("anh"));
				NhanVien nv = new NhanVien();
				nv.setMaNhanVien(rs.getString("nhanVien"));
				PhanCong pc = new PhanCong();
				pc.setMaPC(rs.getString("phanCong"));
				cN.setNhanVien(nv);
				cN.setPhanCong(pc);
				list.add(cN);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean themCongNhan(CongNhan cn) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement;
		try {
			String sql = "insert into CongNhan\r\n" + "values(?,?,?,?,?,?,?,?,?,?)";

			statement = con.prepareStatement(sql);
			statement.setString(1, cn.getMaCN());
			statement.setString(2, cn.getTenCN());
			statement.setBoolean(3, cn.isGioiTinh());
			statement.setDate(4, (Date) cn.getNgaySinh());
			statement.setString(5, cn.getDiaChi());
			statement.setString(6, cn.getCMND());
			statement.setDouble(7, cn.getPhuCap());
			statement.setString(8, cn.getAnh());
			statement.setString(9, cn.getNhanVien().getMaNhanVien());
			statement.setString(10, cn.getPhanCong().getMaPC());
			int kq = statement.executeUpdate();
			statement.close();
			if (kq == 1) {
				return true;
			} else {
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}

	public boolean xoaCongNhan(String maCN) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "delete from CongNhan where maCN=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maCN);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean capNhatThongTinNhanVien(CongNhan cn) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			//
			String sql = "update CongNhan set tenCN=?,gioiTinh=?,ngaySinh=?,diaChi=?,CMND=?,phuCap=?,anh=?,nhanVien=?,phanCong=?  where maCN=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, cn.getTenCN());
			statement.setBoolean(2, cn.isGioiTinh());
			statement.setDate(3, (Date) cn.getNgaySinh());
			statement.setString(4, cn.getDiaChi());
			statement.setString(5, cn.getCMND());
			statement.setDouble(6, cn.getPhuCap());
			statement.setString(7, cn.getAnh());
			statement.setString(8, cn.getNhanVien().getMaNhanVien());
			statement.setString(9, cn.getPhanCong().getMaPC());
			statement.setString(10, cn.getMaCN());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			return false;
		}
		return n > 0;
	}

	public NhanVien getNhanVienTheoMaNV(String ma) {
		NhanVien nv = new NhanVien();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm;
			String sql = "select *from NhanVien where maNV='" + ma + "'";
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getNString(2);
				boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				String diaChi = rs.getNString(5);
				String CMND = rs.getNString(6);
				String chucVu = rs.getNString(7);
				String trinhDoHocVan = rs.getNString(8);
				String kinhNghiem = rs.getNString(9);
				Double heSoLuong = rs.getDouble(10);
				Double phuCap = rs.getDouble(11);
				String anh = rs.getNString(12);
				String phongBan = rs.getNString(13);
				String maKho = rs.getNString(14);
				PhongBan pb = new DAO_PhongBan().timPhongBan(phongBan);
				Kho kho = new DAO_Kho().timKho(maKho);
				nv = new NhanVien(maNV, tenNV, gioiTinh,ngaySinh, diaChi, CMND, chucVu, trinhDoHocVan, kinhNghiem,
						heSoLuong, phuCap,anh, pb, kho);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nv;
	}

	public NhanVien getNhanVienTheoTen(String ten) {
		NhanVien nv = new NhanVien();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm;
			String sql = "select *from NhanVien where tenNV='" + ten + "'";
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getNString(2);
				boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				String diaChi = rs.getNString(5);
				String CMND = rs.getNString(6);
				String chucVu = rs.getNString(7);
				String trinhDoHocVan = rs.getNString(8);
				String kinhNghiem = rs.getNString(9);
				Double heSoLuong = rs.getDouble(10);
				Double phuCap = rs.getDouble(11);
				String anh = rs.getNString(12);
				String phongBan = rs.getNString(13);
				String maKho = rs.getNString(14);
				PhongBan pb = new DAO_PhongBan().timPhongBan(phongBan);
				Kho kho = new DAO_Kho().timKho(maKho);
				nv = new NhanVien(maNV, tenNV, gioiTinh,ngaySinh, diaChi, CMND, chucVu, trinhDoHocVan, kinhNghiem,
						heSoLuong, phuCap,anh, pb, kho);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nv;
	}

	public CongNhan getCongNhanTheoMaCN(String ma) {
		CongNhan cN = new CongNhan();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm;
			String sql = "select *from CongNhan where maCN='" + ma + "'";
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				cN.setMaCN(rs.getString("maCN"));
				cN.setTenCN(rs.getString("tenCN"));
				cN.setGioiTinh(rs.getBoolean("gioiTinh"));
				cN.setNgaySinh(rs.getDate("ngaySinh"));
				cN.setCMND(rs.getString("CMND"));
				cN.setDiaChi(rs.getString("diaChi"));
				cN.setPhuCap(rs.getDouble("phuCap"));
				cN.setAnh(rs.getString("anh"));
				NhanVien nv = new NhanVien();
				nv.setMaNhanVien(rs.getString("nhanVien"));
				PhanCong pc = new PhanCong();
				pc.setMaPC(rs.getString("phanCong"));
				cN.setNhanVien(nv);
				cN.setPhanCong(pc);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cN;
	}

	public ArrayList<CongNhan> getCongNhanTheoTen(String tenCN) {
		ArrayList<CongNhan> dsCN = new ArrayList<CongNhan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm;
			String sql = "select *from CongNhan where tenCN like N'%" + tenCN + "%'";
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maCN = rs.getString(1);
				String ten = rs.getNString(2);
				boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				String diaChi = rs.getNString(5);
				String CMND = rs.getNString(6);
				Double phuCap = rs.getDouble(7);
				String anh = rs.getNString(8);
				String nhanVien = rs.getString(9);
				String phanCong = rs.getString(10);
				NhanVien nv = new DAO_NhanVien().timNV(nhanVien);
				PhanCong pc = new PhanCong(phanCong);
				CongNhan cn = new CongNhan(maCN, ten, gioiTinh, ngaySinh, CMND, diaChi, phuCap, anh, nv, pc);
				dsCN.add(cn);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsCN;
	}

	public ArrayList<CongNhan> getCongNhanTheoNVQL(String tenNV) {
		ArrayList<CongNhan> dsCN = new ArrayList<CongNhan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm;
			String sql = "select * from CongNhan cn Join NhanVien nv on cn.nhanVien= nv.maNV\r\n"
					+ "where tenNV like N'" + tenNV + "%'";
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maCN = rs.getString(1);
				String ten = rs.getNString(2);
				boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				String diaChi = rs.getNString(5);
				String CMND = rs.getNString(6);
				Double phuCap = rs.getDouble(7);
				String anh = rs.getNString(8);
				String nhanVien = rs.getString(9);
				String phanCong = rs.getString(10);
				NhanVien nv = new DAO_NhanVien().timNV(nhanVien);
				PhanCong pc = new PhanCong(phanCong);
				CongNhan cn = new CongNhan(maCN, ten, gioiTinh, ngaySinh, CMND, diaChi, phuCap, anh, nv, pc);
				dsCN.add(cn);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsCN;
	}

	public ArrayList<CongNhan> getCongNhanTheoCongDoan(String congDoan) {
		ArrayList<CongNhan> dsCN = new ArrayList<CongNhan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {

			String sql = "select *from CongNhan where congDoan=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, congDoan);
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maCN = rs.getString(1);
				String ten = rs.getNString(2);
				boolean gioiTinh = rs.getBoolean(3);
				Date ngaySinh = rs.getDate(4);
				String diaChi = rs.getNString(5);
				String CMND = rs.getNString(6);
				Double phuCap = rs.getDouble(7);
				String anh = rs.getNString(8);
				String nhanVien = rs.getString(9);
				String phanCong = rs.getString(10);
				NhanVien nv = new DAO_NhanVien().timNV(nhanVien);
				PhanCong pc = new PhanCong(phanCong);
				CongNhan cn = new CongNhan(maCN, ten, gioiTinh, ngaySinh, CMND, diaChi, phuCap, anh, nv, pc);
				dsCN.add(cn);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsCN;
	}

	public String getAutoMaCN() {
		int soLuong = 0;
		String so = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm;
			String sql = "SELECT count(1) FROM CongNhan";
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				so = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		soLuong = Integer.parseInt(so);
		soLuong++;
		
		DAO_CongNhan dao = new DAO_CongNhan();
		Stack<String> ma = new Stack<>();
		for (CongNhan congNhan : dao.getAllCongNhan()) {
			ma.push(congNhan.getMaCN());
		}
		try {
			for (CongNhan congNhan : dao.getAllCongNhan()) {
				if (soLuong < 10) {
					so = "CN0" + soLuong;
				} else {
					so = "CN" + soLuong;
				}
				String lay= ma.peek(); 
				if (lay.equalsIgnoreCase(so)) {
					soLuong--;			
				}
				ma.pop();		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (soLuong < 10) {
			so = "CN0" + soLuong;
		} else {
			so = "CN" + soLuong;
		}
		return so;
	}	
}
