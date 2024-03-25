package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connect.ConnectDB;
import entity.TaiKhoan;

import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameChinh extends JFrame {

	private JPanel contentPane;
	private JPanel pnTemp;
	private JPanel pnChinh;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameChinh frame = new FrameChinh();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FrameChinh(TaiKhoan taiKhoan) {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		setFont(new Font("Times New Roman", Font.BOLD, 28));
		setTitle("PAYROLL");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameChinh.class.getResource("/image/Cash-icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 955, 587);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnTrangChu = new JMenu("Trang ch\u1EE7");
		mnTrangChu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnTrangChu.setIcon(new ImageIcon(FrameChinh.class.getResource("/image/Home-icon.png")));
		menuBar.add(mnTrangChu);

		JMenu mnDanhMuc = new JMenu("Danh m\u1EE5c");
		mnDanhMuc.setIcon(new ImageIcon(FrameChinh.class.getResource("/image/DanhMuc_icon.png")));
		mnDanhMuc.setFont(new Font("Times New Roman", Font.BOLD, 14));
		menuBar.add(mnDanhMuc);

		JMenuItem mntmNhanVien = new JMenuItem("Nh\u00E2n Vi\u00EAn");
		mntmNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPnl(new PnlDanhMucNhanVien());
			}
		});
		mntmNhanVien.setIcon(new ImageIcon(FrameChinh.class.getResource("/image/NhanVien-icon.png")));
		
		mnDanhMuc.add(mntmNhanVien);

		JMenuItem mntmCongNhan = new JMenuItem("C\u00F4ng nh\u00E2n");
		mntmCongNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPnl(new PnlDanhMucCongNhan());
			}
		});
		mntmCongNhan.setIcon(new ImageIcon(FrameChinh.class.getResource("/image/CongNhan-icon.png")));
		mntmCongNhan.setHorizontalAlignment(SwingConstants.TRAILING);
		mnDanhMuc.add(mntmCongNhan);

		JMenuItem mntmSanPham = new JMenuItem("S\u1EA3n ph\u1EA9m");
		mntmSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPnl(new PnlDanhMucSanPham());
			}
		});
		mntmSanPham.setIcon(new ImageIcon(FrameChinh.class.getResource("/image/icon_SanPham.png")));
		mnDanhMuc.add(mntmSanPham);

		JMenu mnXuLi = new JMenu("X\u1EED l\u00ED");
		mnXuLi.setIcon(new ImageIcon(FrameChinh.class.getResource("/image/XuLy-icon.png")));
		mnXuLi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		menuBar.add(mnXuLi);

		JMenu mnChamCong = new JMenu("Ch\u1EA5m c\u00F4ng");
		mnChamCong.setIcon(new ImageIcon(FrameChinh.class.getResource("/image/ChamCong-icon.png")));
		mnXuLi.add(mnChamCong);

		JMenuItem mntmChamCongCN = new JMenuItem("Ch\u1EA5m c\u00F4ng c\u00F4ng nh\u00E2n");
		mntmChamCongCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPnl(new PnlChamCongCN());
			}
		});
		mnChamCong.add(mntmChamCongCN);

		JMenuItem mntmChamCongNV = new JMenuItem("Ch\u1EA5m c\u00F4ng nh\u00E2n vi\u00EAn");
		mntmChamCongNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPnl(new PnlChamCongNV());
			}
		});
		mnChamCong.add(mntmChamCongNV);

		JMenuItem mntmTienLuong = new JMenuItem("Ti\u1EC1n l\u01B0\u01A1ng");
		mntmTienLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPnl(new PnlTienLuong());
			}
		});
		
		
		mntmTienLuong.setIcon(new ImageIcon(FrameChinh.class.getResource("/image/TienLuong_icon.png")));
		mnXuLi.add(mntmTienLuong);

		JMenuItem mntmPhanCong = new JMenuItem("Ph\u00E2n c\u00F4ng");
		mntmPhanCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPnl(new PnlPhanCong());
			}
		});
		mntmPhanCong.setIcon(new ImageIcon(FrameChinh.class.getResource("/image/PhanCong-icon.png")));
		mnXuLi.add(mntmPhanCong);

		JMenu mnThongKe = new JMenu("Th\u1ED1ng k\u00EA");
		mnThongKe.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnThongKe.setIcon(new ImageIcon(FrameChinh.class.getResource("/image/ThongKe-icon.png")));
		menuBar.add(mnThongKe);

		JMenuItem mntmThongKeLuong = new JMenuItem("Th\u1ED1ng k\u00EA l\u01B0\u01A1ng");
		mntmThongKeLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPnl(new PnlThongKeLuong());
			}
		});
		mnThongKe.add(mntmThongKeLuong);

		JMenuItem mntmThongKeChamCong = new JMenuItem("Th\u1ED1ng k\u00EA ch\u1EA5m c\u00F4ng");
		mnThongKe.add(mntmThongKeChamCong);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pnChinh = new JPanel();
		contentPane.add(pnChinh, BorderLayout.CENTER);
		pnChinh.setLayout(new BorderLayout(0, 0));
		JMenu mnCaNhan = new JMenu(taiKhoan.getTenTK());
		mnCaNhan.setIcon(new ImageIcon(FrameChinh.class.getResource("/image/mk.png")));
		menuBar.add(mnCaNhan);
		JMenuItem mntmThongTin = new JMenuItem("Thông Tin");
		mntmThongTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPnl(new pnlThongTin(taiKhoan));
			}
		});
		mnCaNhan.add(mntmThongTin);
		
		JMenuItem mntmDoiMK = new JMenuItem("Đổi Mật Khẩu");
		mntmDoiMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect.ConnectDB.getInstance().disconnect();
				showPnl(new NewPass(taiKhoan));
			}
		});
		mnCaNhan.add(mntmDoiMK);
		if(taiKhoan.getNhanVien().getChucVu().equalsIgnoreCase("Trưởng Phòng")) {
			mntmSanPham.setEnabled(false);
			mntmThongKeLuong.setEnabled(false);
			mntmTienLuong.setEnabled(false);
			mntmPhanCong.setEnabled(false);
		}else if(taiKhoan.getNhanVien().getChucVu().equalsIgnoreCase("Quản Lý Kho")) {
			
			mntmCongNhan.setEnabled(false);
			mntmNhanVien.setEnabled(false);
			mnXuLi.setEnabled(false);
			mnThongKe.setEnabled(false);

		}else {
			mnDanhMuc.setEnabled(false);
			mnChamCong.setEnabled(false);
			mntmPhanCong.setEnabled(false);
			mntmThongKeChamCong.setEnabled(false);
		}
		//pnChinh.add(new PnlChamCong(), BorderLayout.CENTER);
	}

	private void showPnl(JPanel panel) {
		//pnTemp = panel;
		pnChinh.removeAll();
		pnChinh.add(panel, BorderLayout.CENTER);
		pnChinh.validate();
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
