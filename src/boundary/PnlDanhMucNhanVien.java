package boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import dao.DAO_Kho;
import dao.DAO_NhanVien;
import dao.DAO_PhongBan;
import entity.Kho;
import entity.NhanVien;
import entity.PhongBan;
import entity.SanPham;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class PnlDanhMucNhanVien extends JPanel implements ActionListener,MouseListener{
	
	private JTextField txtTimTen;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtDiaChi;
	private JTextField txtCMND;
	private JTable tableNV;
	private JRadioButton rdbtnNam;
	private DefaultTableModel model;
	
	private DAO_NhanVien dao_nv;
	private DAO_Kho dao_kho;
	private DAO_PhongBan dao_pb;
	
	String[] headers= {"STT","Mã nhân viên","Tên nhân viên","Giới tính","Chức vụ","Phòng ban","Kho","Hệ số lương","Phụ cấp"};
	private JComboBox cbKho;
	private JComboBox cbPhongBan;
	private JDateChooser dateChooser;
	private JComboBox cbChucVu;
	private JComboBox cbTrinhDo;
	private JComboBox cbKinhNghiem;
	private JComboBox cbHeSoLuong;
	private JComboBox cbPhuCap;
	private JLabel lblAvt;
	private JButton btnThemAvt;
	private JComboBox cbTimPhong;
	private JButton btnLuu;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnTimKiem;
	private JPanel pnDanhSach;
	private JScrollPane scrollPaneDSNV;
	private String linkImage="/image/rsz_ngankute.png";
	protected int save;
	private JButton btnReload;

	/**
	 * Create the panel.
	 */
	public PnlDanhMucNhanVien() {
		try {
			ConnectDB.getInstance().connect();
		}catch (SQLException e) {
			// TODO: handle exception
		}

		setLayout(null);
		dao_nv=new DAO_NhanVien();
		
		JPanel pnTitle = new JPanel();
		pnTitle.setBorder(new LineBorder(Color.CYAN));
		pnTitle.setBackground(Color.CYAN);
		pnTitle.setForeground(Color.WHITE);
		pnTitle.setBounds(10, 0, 920, 35);
		add(pnTitle);
		pnTitle.setLayout(null);
		
		JLabel lblTitle = new JLabel("Nhân viên");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitle.setBounds(10, 0, 115, 35);
		pnTitle.add(lblTitle);
		
		JPanel pnThongTin = new JPanel();
		pnThongTin.setBorder(new LineBorder(Color.CYAN));
		pnThongTin.setBounds(150, 46, 780, 152);
		add(pnThongTin);
		pnThongTin.setLayout(null);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setBounds(5, 9, 83, 13);
		pnThongTin.add(lblMaNV);
		
		txtMaNV = new JTextField();
		txtMaNV.setBounds(98, 6, 120, 19);
		pnThongTin.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		JLabel lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setBounds(251, 9, 90, 13);
		pnThongTin.add(lblTenNV);
		
		txtTenNV = new JTextField();
		txtTenNV.setBounds(371, 5, 120, 19);
		pnThongTin.add(txtTenNV);
		txtTenNV.setColumns(10);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setBounds(543, 7, 75, 16);
		pnThongTin.add(lblGioiTinh);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setBounds(5, 38, 50, 13);
		pnThongTin.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(98, 35, 120, 19);
		pnThongTin.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblCMND = new JLabel("CMND/CCCD:");
		lblCMND.setBounds(5, 68, 83, 13);
		pnThongTin.add(lblCMND);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(98, 65, 120, 19);
		pnThongTin.add(txtCMND);
		txtCMND.setColumns(10);
		
		cbChucVu = new JComboBox();
		cbChucVu.setBounds(644, 64, 120, 21);
		cbChucVu.setModel(new DefaultComboBoxModel(new String[] {"Nhân viên", "Trưởng phòng nhân sự", "Kế toán", "Quản lí kho"}));
		pnThongTin.add(cbChucVu);
		
		
		JLabel lblTrinhDo = new JLabel("Trình độ:");
		lblTrinhDo.setBounds(544, 38, 102, 13);
		pnThongTin.add(lblTrinhDo);
		
		cbTrinhDo =    new JComboBox();
		cbTrinhDo.setModel(new DefaultComboBoxModel(new String[] {"12/12", "Đại học", "Cao đẳng"}));
		cbTrinhDo.setBounds(644, 34, 120, 21);
		pnThongTin.add(cbTrinhDo);
		
		JLabel lblKinhNghiem = new JLabel("Kinh nghiệm:");
		lblKinhNghiem.setBounds(251, 66, 102, 16);
		pnThongTin.add(lblKinhNghiem);
		
		cbKinhNghiem = new JComboBox();
		cbKinhNghiem.setModel(new DefaultComboBoxModel(new String[] {"1 năm", "2 năm", "3 năm", "4 năm", "5 năm", "6 năm", "7 năm", "8 năm", "9 năm", "10 năm", "Trên 10 năm", "Chưa có kinh nghiệm"}));
		cbKinhNghiem.setBounds(371, 64, 120, 21);
		pnThongTin.add(cbKinhNghiem);
		
		JLabel lblHeSoLuong = new JLabel("Hệ số lương:");
		lblHeSoLuong.setBounds(5, 130, 90, 17);
		pnThongTin.add(lblHeSoLuong);
		
		cbHeSoLuong = new JComboBox();
		cbHeSoLuong.setBounds(98, 128, 120, 21);
		pnThongTin.add(cbHeSoLuong);
		
		JLabel lblPhuCap = new JLabel("Phụ cấp:");
		lblPhuCap.setBounds(5, 102, 60, 13);
		pnThongTin.add(lblPhuCap);
		
		JLabel lblTenKho = new JLabel("Kho:");
		lblTenKho.setBounds(543, 102, 45, 13);
		pnThongTin.add(lblTenKho);
		
		JLabel lblTenPhong = new JLabel("Phòng ban: ");
		lblTenPhong.setBounds(251, 100, 90, 17);
		pnThongTin.add(lblTenPhong);
		
		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBounds(644, 5, 54, 21);
		pnThongTin.add(rdbtnNam);
		
		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setBounds(545, 68, 54, 13);
		pnThongTin.add(lblChucVu);
		
		cbPhuCap = new JComboBox();
		cbPhuCap.setModel(new DefaultComboBoxModel(new String[] {"500.0", "700.0", "1000.0","0.0"}));
		cbPhuCap.setBounds(98, 98, 120, 21);
		pnThongTin.add(cbPhuCap);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setBounds(251, 36, 75, 16);
		pnThongTin.add(lblNgaySinh);
		
		cbPhongBan = new JComboBox();
		cbPhongBan.setBounds(371, 98, 120, 21);
		pnThongTin.add(cbPhongBan);
		
		cbKho = new JComboBox();
		cbKho.setBounds(643, 98, 120, 21);
		pnThongTin.add(cbKho);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(371, 32, 120, 19);
		pnThongTin.add(dateChooser);
		
		JPanel pnAnh = new JPanel();
		pnAnh.setBackground(SystemColor.control);
		pnAnh.setBorder(new LineBorder(Color.CYAN));
		pnAnh.setBounds(10, 46, 128, 152);
		add(pnAnh);
		pnAnh.setLayout(null);
		
		lblAvt = new JLabel("");
		lblAvt.setBackground(Color.WHITE);
		lblAvt.setIcon(new ImageIcon(PnlDanhMucNhanVien.class.getResource(linkImage)));
		lblAvt.setBounds(10,11,108,109);
		pnAnh.add(lblAvt);
		
		btnThemAvt = new JButton("Tải ảnh");
		btnThemAvt.setBounds(20,122,87,19);
		btnThemAvt.setFont(new Font("Tahoma", Font.PLAIN, 9));
		pnAnh.add(btnThemAvt);
		
		JPanel pnChucNang = new JPanel();
		pnChucNang.setBorder(new LineBorder(Color.CYAN));
		pnChucNang.setBounds(10, 203, 920, 59);
		add(pnChucNang);
		pnChucNang.setLayout(null);
		
		cbTimPhong = new JComboBox();
		cbTimPhong.setBounds(216, 24, 119, 21);
		pnChucNang.add(cbTimPhong);
		cbTimPhong.setModel(new DefaultComboBoxModel(new String[] {"NHÂN SỰ", "KẾ TOÁN", "THIẾT KẾ"}));
		cbTimPhong.addActionListener(this);
		
		JLabel lblTimTen = new JLabel("Tìm kiếm theo tên:");
		lblTimTen.setBounds(20, 0, 119, 23);
		pnChucNang.add(lblTimTen);
		
		JLabel lblTimPhong = new JLabel("Tìm kiếm theo phòng ban:");
		lblTimPhong.setBounds(193, 0, 194, 23);
		pnChucNang.add(lblTimPhong);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setBackground(Color.CYAN);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLuu.setIcon(new ImageIcon(PnlDanhMucNhanVien.class.getResource("/image/paste-icon.png")));
		btnLuu.setBounds(520, 12, 90, 35);
		pnChucNang.add(btnLuu);
		
		btnThem = new JButton("Thêm");
		btnThem.setBackground(Color.CYAN);
		btnThem.setIcon(new ImageIcon(PnlDanhMucNhanVien.class.getResource("/image/add.png")));
		btnThem.setBounds(620, 12, 90, 35);
		pnChucNang.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBackground(Color.CYAN);
		btnXoa.setIcon(new ImageIcon(PnlDanhMucNhanVien.class.getResource("/image/trash.png")));
		btnXoa.setBounds(720, 12, 90, 35);
		pnChucNang.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		btnSua.setBackground(Color.CYAN);
		btnSua.setIcon(new ImageIcon(PnlDanhMucNhanVien.class.getResource("/image/settings.png")));
		btnSua.setBounds(820, 12, 90, 35);
		pnChucNang.add(btnSua);
		
		txtTimTen = new JTextField();
		txtTimTen.setBounds(19, 24, 120, 21);
		pnChucNang.add(txtTimTen);
		txtTimTen.setColumns(10);
		
		btnTimKiem = new JButton("");
		btnTimKiem.setBounds(137, 24, 31, 21);
		pnChucNang.add(btnTimKiem);
		btnTimKiem.setIcon(new ImageIcon(PnlDanhMucNhanVien.class.getResource("/image/search.png")));
		
		btnReload = new JButton("");
		btnReload.setIcon(new ImageIcon(PnlDanhMucNhanVien.class.getResource("/image/return.png")));
		btnReload.setBackground(Color.CYAN);
		btnReload.setBounds(357, 15, 45, 30);
		pnChucNang.add(btnReload);
		
		pnDanhSach = new JPanel();
		pnDanhSach.setBorder(new LineBorder(Color.CYAN));
		pnDanhSach.setBounds(10, 265, 920, 239);
		add(pnDanhSach);
		pnDanhSach.setLayout(null);
		
		scrollPaneDSNV = new JScrollPane();
		scrollPaneDSNV.setBounds(10, 10, 919, 197);
		pnDanhSach.add(scrollPaneDSNV);
		
		tableNV=new JTable();
		model =new DefaultTableModel(headers,0);
		tableNV=new JTable(model);
		tableNV.getColumnModel().getColumn(0).setPreferredWidth(10);
		tableNV.getColumnModel().getColumn(1).setPreferredWidth(40);
		tableNV.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableNV.getColumnModel().getColumn(3).setPreferredWidth(30);
		tableNV.getColumnModel().getColumn(4).setPreferredWidth(80);
		tableNV.getColumnModel().getColumn(5).setPreferredWidth(30);
		tableNV.getColumnModel().getColumn(6).setPreferredWidth(30);
		tableNV.getColumnModel().getColumn(7).setPreferredWidth(30);
		tableNV.getColumnModel().getColumn(8).setPreferredWidth(30);
		scrollPaneDSNV.setViewportView(tableNV);
		
		doDuLieuTuCollection();
		showComboboxData();
		txtMaNV.setEditable(false);
		btnLuu.setEnabled(false);
		btnThemAvt.setEnabled(false);
		
//		su kien
//		cbChucVu.addActionListener(this);
		btnReload.addActionListener(this);
		btnThemAvt.addActionListener(this);
		btnLuu.addActionListener(this);
		btnThem.addActionListener(this); 
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTimKiem.addActionListener(this);
		tableNV.addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row =tableNV.getSelectedRow();
		if(row>=0) {
			String id=(String) model.getValueAt(row, 1);
			NhanVien nv=dao_nv.getNhanVienTheoMa(id);
			if(nv!=null) {
			//	txtMaNV.setText(nv.getMaNhanVien());
				txtCMND.setText(nv.getCMND());
				txtDiaChi.setText(nv.getDiaChi());
				dateChooser.setDate(nv.getNgaySinh());
				lblAvt.setIcon(new ImageIcon(nv.getAnh()));
				linkImage=nv.getAnh();
				try {
					if(nv.getAnh()!=null)
						lblAvt.setIcon(ResizeImage(String.valueOf(linkImage)));
				} catch (Exception e2) {
					// TODO: handle exception
				};
				cbKinhNghiem.setSelectedItem(nv.getKinhNghiem());
				cbTrinhDo.setSelectedItem(nv.getTrinhDoHocVan());
			}
			txtMaNV.setText(model.getValueAt(row, 1).toString());
			txtTenNV.setText(model.getValueAt(row, 2).toString());
			rdbtnNam.setSelected(model.getValueAt(row, 3).toString()=="Nam"?true:false);
			cbHeSoLuong.addItem(model.getValueAt(row, 7));
			cbHeSoLuong.setSelectedItem(model.getValueAt(row, 7));
			cbChucVu.setSelectedItem(model.getValueAt(row, 4).toString());
			if(model.getValueAt(row, 5)==null)
				cbPhongBan.removeAllItems();
			else {
				String mapb=model.getValueAt(row, 5).toString();
				if(mapb.equalsIgnoreCase("PB01")) {
					cbPhongBan.removeAllItems();
					cbPhongBan.addItem("KẾ TOÁN");
				}else if(mapb.equalsIgnoreCase("PB02")) {
					cbPhongBan.removeAllItems();
					cbPhongBan.addItem("THIẾT KẾ");
				}else if(mapb.equalsIgnoreCase("PB03")) {
					cbPhongBan.removeAllItems();
					cbPhongBan.addItem("NHÂN SỰ");
				}
			}
			String makho;
			if(model.getValueAt(row, 6)==null)
				cbKho.removeAllItems();
			else {
				makho=model.getValueAt(row, 6).toString();
				if(makho.equalsIgnoreCase("K1")) {
					cbKho.removeAllItems();
					cbKho.addItem("GÒ VẤP");
				}else if(makho.equalsIgnoreCase("K2")) {
					cbKho.removeAllItems();
					cbKho.addItem("Bình Thạnh");
				}
					
			}
			
			cbHeSoLuong.setSelectedItem(model.getValueAt(row, 7).toString());
			cbPhuCap.setSelectedItem(model.getValueAt(row, 8).toString());
			for (NhanVien nv1 : dao_nv.getAllNhanVien()) {
				if(txtMaNV.getText().equalsIgnoreCase(nv1.getMaNhanVien())) {
					linkImage = nv1.getAnh();
					try {
						if(nv1.getAnh() != null) {
							lblAvt.setIcon(ResizeImage(String.valueOf(linkImage)));
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
		}
	}}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(cbChucVu)) {
			showHeSoLuongTheoChucVu();
		}else if(o.equals(btnThemAvt)) {
			addAvt();
		}else if(o.equals(btnThem)) {
			themNhanVien();
		}else if(o.equals(btnXoa)) {
			int row=tableNV.getSelectedRow();
			if(row!=-1) {
				int n = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không?");
				if(n==0) {
					boolean isDel=dao_nv.xoaNhanVien(tableNV.getValueAt(row, 1).toString());
					if(isDel) {
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						xoaHetDuLieuTrenModel();
						doDuLieuTuCollection();
						xoaTrangTxt();
					}else {
						JOptionPane.showMessageDialog(null, "Xóa thất bại");
					}
				}}else {
					JOptionPane.showMessageDialog(null, "Bạn phải chọn vào dòng cần xóa");
				}
			
		}else if(o.equals(btnSua)) {
			suaNhanVien();
		}else if(o.equals(btnLuu)) {
			luuNhanVien();
		}else if(o.equals(btnTimKiem)) {
			timKiemTheoTen();
		}else if(o.equals(cbTimPhong)) {
			int stt = 1;
			String tenPB = cbTimPhong.getSelectedItem().toString().trim();		
			ArrayList<NhanVien> dsNV = dao_nv.getNhanVienTheoPhongBan(tenPB);
			if(dsNV.size()==0)
				JOptionPane.showMessageDialog(null, "Không có nhân viên nào thuộc phòng ban này");
			else {
				xoaHetDuLieuTrenModel();
				for (NhanVien dto_nv : dsNV) {
					model.addRow(new Object[] {stt,dto_nv.getMaNhanVien(),dto_nv.getTenNhanVien(),dto_nv.isGioiTinh()==true?"Nam":"Nữ",dto_nv.getChucVu(),dto_nv.getPhongBan().getMaPB(),"f",dto_nv.getHeSoLuong(),dto_nv.getPhuCap()});
					stt++;
				}
			}
		}else if(o.equals(btnReload)) {
			xoaHetDuLieuTrenModel();
			doDuLieuTuCollection();
		}
	}
	
	private void showComboboxData() {
		ArrayList<String> dataKho=new ArrayList<String>();
		ArrayList<String> dataPB=new ArrayList<String>();
		dataKho=new DAO_Kho().getTenKho();
		dataPB=new DAO_PhongBan().getTenPB();
		for(String s: dataKho) {
			cbKho.addItem(s);
		}
		for(String s:dataPB) {
			cbPhongBan.addItem(s);
		}
	}
	private void showHeSoLuongTheoChucVu() {
		String chucVu=cbChucVu.getSelectedItem().toString();
		if(chucVu.equals("Nhân viên")) {
			cbHeSoLuong.removeAllItems();
			cbPhongBan.setEnabled(true);
			cbKho.setEnabled(false);
			double heSo=1.92;
			while(heSo<=2.94) {		
				cbHeSoLuong.addItem(Math.floor(heSo*100)/100);
				heSo+=0.01;
			}
		}else if(chucVu.equals("Kế toán")) {
			cbHeSoLuong.removeAllItems();
			cbPhongBan.setEnabled(true);
			cbKho.setEnabled(false);
			double heSo=2.10;
			while(heSo<=3.66) {
				cbHeSoLuong.addItem(Math.floor(heSo*100)/100);
				heSo+=0.01;
			}
		}else if(chucVu.equals("Trưởng phòng nhân sự")){
			cbHeSoLuong.removeAllItems();
			cbPhongBan.setEnabled(true);
			cbKho.setEnabled(false);
			double heSo=2.68;
			while(heSo<=4.12) {
				cbHeSoLuong.addItem(Math.floor(heSo*100)/100);
				heSo+=0.01;
			}
		}
		else if(chucVu.equals("Quản lí kho")){
			cbHeSoLuong.removeAllItems();
			cbKho.setEnabled(true);
			cbPhongBan.setEnabled(false);
			double heSo=2.68;
			while(heSo<=4.12) {
				cbHeSoLuong.addItem(Math.floor(heSo*100)/100);
				heSo+=0.01;
			}
		}
	}
	private void timKiemTheoTen() {
		ArrayList<NhanVien> dsNV=dao_nv.getNhanVienTheoTen(txtTimTen.getText());
		if(dsNV.size()==0)
			JOptionPane.showMessageDialog(null, "Không tồn tại nhân viên này trong danh sách");
		else {
			xoaHetDuLieuTrenModel();
			int stt=1;
			for (NhanVien dto_nv : dsNV) {
				if(dto_nv.getKho()==null) {
					model.addRow(new Object[] {stt,dto_nv.getMaNhanVien(),dto_nv.getTenNhanVien(),dto_nv.isGioiTinh()==true?"Nam":"Nữ",dto_nv.getChucVu(),dto_nv.getPhongBan().getMaPB(),null,dto_nv.getHeSoLuong(),dto_nv.getPhuCap()});
					stt++;
				}else if(dto_nv.getPhongBan()==null) {
					model.addRow(new Object[] {stt,dto_nv.getMaNhanVien(),dto_nv.getTenNhanVien(),dto_nv.isGioiTinh()==true?"Nam":"Nữ",dto_nv.getChucVu(),null,dto_nv.getKho().getMaKho(),dto_nv.getHeSoLuong(),dto_nv.getPhuCap()});
					stt++;
				}
			}
		}
	}
	private void luuNhanVien() {
		try {	
			if(save == 1) {
				them();
			}
			if(save == 2) {
				capNhat();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	private void capNhat() {
		int r=tableNV.getSelectedRow();
		if(valid()) {
		String maNV=txtMaNV.getText();
		String tenNV=txtTenNV.getText();
		boolean gioiTinh=rdbtnNam.isSelected()?true:false;
		java.util.Date ngaySinh=new java.util.Date();
		ngaySinh= dateChooser.getDate();
		long javaTime=ngaySinh.getTime();
		java.sql.Date sqlDate=new java.sql.Date(javaTime);
		String diaChi=txtDiaChi.getText();
		String cmnd=txtCMND.getText();
		String chucVu=cbChucVu.getSelectedItem().toString();
		String trinhDoHocVan=cbTrinhDo.getSelectedItem().toString();
		String kinhNghiem=cbKinhNghiem.getSelectedItem().toString();
		String anh=linkImage;
		double heSoLuong=Double.parseDouble(cbHeSoLuong.getSelectedItem().toString());
		double phuCap=Double.parseDouble(cbPhuCap.getSelectedItem().toString());
		String maPB,maKho;
		if(chucVu.equalsIgnoreCase("Quản lí kho")) {
			maPB=null;
			String tenKho=cbKho.getSelectedItem().toString();
			if(tenKho.equalsIgnoreCase("GÒ VẤP")) {
				maKho="K1";
			}else
				maKho="K2";
		}else {
			maKho=null;
			String tenPB=cbPhongBan.getSelectedItem().toString();
			if(tenPB.equalsIgnoreCase("KẾ TOÁN")) {
				maPB="PB01";
			}else if(tenPB.equalsIgnoreCase("THIẾT KẾ")) {
				maPB="PB02";
			}else
				maPB="PB03";
		}	
		if(new DAO_NhanVien().capNhatThongTinNhanVien(maNV, tenNV, gioiTinh, sqlDate, diaChi, cmnd, chucVu, trinhDoHocVan, kinhNghiem, anh, heSoLuong, phuCap, maPB, maKho)) {
			JOptionPane.showMessageDialog(null, "Sửa thành công");
			xoaHetDuLieuTrenModel();
			doDuLieuTuCollection();
			btnLuu.setEnabled(false);
			save=0;
			btnSua.setText("Sửa");
			btnThem.setEnabled(true);
			btnXoa.setEnabled(true);
			xoaTrangTxt();
		}}
		else {
			JOptionPane.showMessageDialog(null, "Sửa thất bại");
		}
	
	}

	private void them() {
		if(valid()) {
		String maKho,maPB;
		String maNV=txtMaNV.getText();
		String tenNV=txtTenNV.getText();
		boolean gioiTinh = rdbtnNam.isSelected(); 
		java.util.Date ngaySinh=new java.util.Date();
		ngaySinh= dateChooser.getDate();
		long javaTime=ngaySinh.getTime();
		java.sql.Date sqlDate=new java.sql.Date(javaTime);
		String diaChi=txtDiaChi.getText();
		String cmnd=txtCMND.getText();
		String chucVu=cbChucVu.getSelectedItem().toString();
		String trinhDoHocVan=cbTrinhDo.getSelectedItem().toString();
		String kinhNghiem=cbKinhNghiem.getSelectedItem().toString();
		double heSoLuong=Double.parseDouble(cbHeSoLuong.getSelectedItem().toString());
		double phuCap=Double.parseDouble(cbPhuCap.getSelectedItem().toString());
		String anh = linkImage;
		if(chucVu.equalsIgnoreCase("Quản lí kho")) {
			maPB=null;
			String tenKho=cbKho.getSelectedItem().toString();
			if(tenKho.equalsIgnoreCase("GÒ VẤP")) {
				maKho="K1";
			}else
				maKho="K2";
		}else {
			maKho=null;
			String tenPB=cbPhongBan.getSelectedItem().toString();
			if(tenPB.equalsIgnoreCase("KẾ TOÁN")) {
				maPB="PB01";
			}else if(tenPB.equalsIgnoreCase("THIẾT KẾ")) {
				maPB="PB02";
			}else
				maPB="PB03";
		}	
		PhongBan phongBan=new PhongBan(maPB);
		Kho kho=new Kho(maKho);
		NhanVien nv=new NhanVien(maNV, tenNV, gioiTinh, sqlDate, diaChi, cmnd, chucVu, trinhDoHocVan, kinhNghiem, heSoLuong, phuCap, anh, phongBan, kho);
		DAO_NhanVien dao_nv=new DAO_NhanVien();
		if(dao_nv.themNhanVien(nv)) {
			JOptionPane.showMessageDialog(null, "Thêm thành công");
			xoaHetDuLieuTrenModel();
			doDuLieuTuCollection();
			btnLuu.setEnabled(false);
			btnSua.setEnabled(true);
			btnXoa.setEnabled(true);
			save=0;
			btnThem.setText("Thêm");
			xoaTrangTxt();
		}}
		else
			JOptionPane.showMessageDialog(null, "Thêm thất bại");	
	}
	private void suaNhanVien() {
		int row=tableNV.getSelectedRow();
		if(row==-1) {
			JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Nhân Viên Cần Sửa");
		}else {
			if (btnSua.getText().equalsIgnoreCase("Sửa")) {
				btnSua.setText("Hủy");
				btnLuu.setEnabled(true);;
				save = 2;
				btnThem.setEnabled(false);
				btnXoa.setEnabled(false);
				cbKho.setEnabled(false);
				cbPhongBan.removeAllItems();
				cbKho.removeAllItems();
				btnThemAvt.setEnabled(true);
				showComboboxData();
				cbChucVu.addActionListener(this);
			} else {
				btnSua.setText("Sửa");
				btnLuu.setEnabled(false);
				xoaTrangTxt();
				save = 0;
				btnThem.setEnabled(true);
				btnXoa.setEnabled(true);
				cbPhongBan.removeAllItems();
				cbKho.removeAllItems();
				btnThemAvt.setEnabled(false);
				cbKho.setEnabled(true);
				showComboboxData();
				cbChucVu.removeActionListener(this);
			}
		}
		
	}
	private void themNhanVien() {
		if (btnThem.getText().equalsIgnoreCase("Thêm")) {
			btnThem.setText("Hủy");
			xoaTrangTxt();
			loadMaNV();
			btnLuu.setEnabled(true);
			btnSua.setEnabled(false);
			btnXoa.setEnabled(false);
			btnThemAvt.setEnabled(true);
			save = 1;
			cbKho.setEnabled(false);
			cbPhongBan.removeAllItems();
			cbKho.removeAllItems();
			showComboboxData();
			cbChucVu.addActionListener(this);
			lblAvt.setIcon(new ImageIcon(PnlDanhMucNhanVien.class.getResource(linkImage)));
		} else {
			btnThem.setText("Thêm");
			xoaTrangTxt();
			save = 0;
			btnLuu.setEnabled(false);
			btnSua.setEnabled(true);
			btnXoa.setEnabled(true);
			btnThemAvt.setEnabled(false);
			cbKho.setEnabled(true);
			cbPhongBan.removeAllItems();
			cbKho.removeAllItems();
			showComboboxData();
			cbChucVu.removeActionListener(this);
		}
		
	}

	private void loadMaNV() {
		String maNV=null;
		maNV = dao_nv.getMaNV();
		txtMaNV.setText(maNV);
	}
	public ImageIcon ResizeImage(String linkImage) {
		  ImageIcon myImage = new ImageIcon(linkImage);
		  Image img = myImage.getImage();
		  Image newImage = img.getScaledInstance(lblAvt.getWidth(), lblAvt.getHeight(), Image.SCALE_SMOOTH);
		  ImageIcon image = new ImageIcon(newImage);
		  return image;
	  }
	private void addAvt() {
		try {
			JFileChooser f=new JFileChooser("D:\\Anh");
			f.setDialogTitle("Open File");
			f.showOpenDialog(null);
			File fNameImage=f.getSelectedFile();
			linkImage=fNameImage.getAbsolutePath();
			if(linkImage!=null) {
				lblAvt.setIcon(ResizeImage(String.valueOf(linkImage)));
				System.out.println(linkImage);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Chưa có ảnh được chọn");
		}		
	}
	
	//Lay du lieu tu dbs vao table
	private void doDuLieuTuCollection() {
		int stt=1;
		for (NhanVien dto_nv : dao_nv.getAllNhanVien()) {
			if(dto_nv.getKho()==null) {
				model.addRow(new Object[] {stt,dto_nv.getMaNhanVien(),dto_nv.getTenNhanVien(),dto_nv.isGioiTinh()==true?"Nam":"Nữ",dto_nv.getChucVu(),dto_nv.getPhongBan().getMaPB(),null,dto_nv.getHeSoLuong(),dto_nv.getPhuCap()});
				stt++;
			}else if(dto_nv.getPhongBan()==null) {
				model.addRow(new Object[] {stt,dto_nv.getMaNhanVien(),dto_nv.getTenNhanVien(),dto_nv.isGioiTinh()==true?"Nam":"Nữ",dto_nv.getChucVu(),null,dto_nv.getKho().getMaKho(),dto_nv.getHeSoLuong(),dto_nv.getPhuCap()});
				stt++;
			}
		}
	}
	//xoa du lieu tren tableModel
	private void xoaHetDuLieuTrenModel() {
		DefaultTableModel dm = (DefaultTableModel) tableNV.getModel();
		dm.getDataVector().removeAllElements();
	}
	private void xoaTrangTxt() {
		txtCMND.setText("");
		txtDiaChi.setText("");
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtTimTen.setText("");
		rdbtnNam.setSelected(false);
		cbChucVu.setSelectedIndex(0);
//		cbHeSoLuong.setSelectedIndex(0);
		cbKinhNghiem.setSelectedIndex(0);
//		cbKho.setSelectedIndex(0);
//		cbPhongBan.setSelectedIndex(0);
		cbPhuCap.setSelectedIndex(0);
//		cbTimPhong.setSelectedIndex(0);
		cbTrinhDo.setSelectedIndex(0);
		dateChooser.setDate(null);
	}
	private boolean valid() {
		String ten = txtTenNV.getText();
		if (ten.isEmpty() || ten.matches("[\\d]*")){
			JOptionPane.showMessageDialog(null, "Họ tên không hợp lệ");
			return false;
		}
		String cmnd= txtCMND.getText();
		if (cmnd.isEmpty() || !cmnd.matches("[\\d]{9}||[\\d]{12}") ) {
			JOptionPane.showMessageDialog(null, "CMND/CCCD không hợp lệ");
			return false;
		}
		if (txtDiaChi.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống!");
			return false;
		}
		if (cbHeSoLuong.getSelectedItem()==null) {
			JOptionPane.showMessageDialog(null, "Hệ số lương bắt buộc chọn");
			return false;
		}
		LocalDate localDate = LocalDate.now();
		LocalDate ngayNhap = new java.sql.Date(dateChooser.getDate().getTime()).toLocalDate();
		if (Period.between(ngayNhap, localDate).getYears() < 18) {
			JOptionPane.showMessageDialog(null, "Chưa đủ tuổi!");
			return false;
		}
		return true;
	}
}
