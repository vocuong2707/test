package boundary;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;

public class PnlPhanCong extends JPanel {
	private JTable tableDSCN;
	private JTextField txtTimKiemCN;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PnlPhanCong() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		setBorder(BorderFactory.createTitledBorder("Phân công"));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.CYAN));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 24, 337, 193);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Danh s\u00E1ch c\u00F4ng nh\u00E2n");
		lblTitle.setBounds(1, 1, 335, 17);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTitle);
		
		JScrollPane scrollPaneDSCN = new JScrollPane();
		scrollPaneDSCN.setBounds(11, 46, 316, 136);
		panel.add(scrollPaneDSCN);
		
		tableDSCN = new JTable();
		tableDSCN.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"STT", "H\u1ECD t\u00EAn"
			}
		));
		tableDSCN.getColumnModel().getColumn(0).setPreferredWidth(66);
		tableDSCN.getColumnModel().getColumn(1).setPreferredWidth(281);
		scrollPaneDSCN.setViewportView(tableDSCN);
		
		txtTimKiemCN = new JTextField();
		txtTimKiemCN.setBounds(116, 22, 182, 20);
		panel.add(txtTimKiemCN);
		txtTimKiemCN.setColumns(10);
		
		JButton btnTimKiemCN = new JButton("");
		btnTimKiemCN.setBounds(303, 22, 24, 20);
		panel.add(btnTimKiemCN);
		btnTimKiemCN.setBackground(Color.WHITE);
		btnTimKiemCN.setIcon(new ImageIcon(PnlPhanCong.class.getResource("/image/search-icon.png")));
		
		JLabel lblIconMuiTen = new JLabel("");
		lblIconMuiTen.setIcon(new ImageIcon(PnlPhanCong.class.getResource("/image/Icon_MuiTen.png")));
		lblIconMuiTen.setBounds(357, 104, 32, 32);
		add(lblIconMuiTen);
		
		JPanel pnlChiTietPC = new JPanel();
		pnlChiTietPC.setBorder(new LineBorder(Color.CYAN));
		pnlChiTietPC.setBackground(Color.WHITE);
		pnlChiTietPC.setBounds(401, 24, 514, 193);
		add(pnlChiTietPC);
		pnlChiTietPC.setLayout(null);
		
		JLabel lblTenCN = new JLabel("H\u1ECD t\u00EAn:");
		lblTenCN.setBounds(29, 11, 48, 17);
		pnlChiTietPC.add(lblTenCN);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(83, 9, 122, 20);
		pnlChiTietPC.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNgayPC = new JLabel("Ng\u00E0y ph\u00E2n c\u00F4ng: ");
		lblNgayPC.setBounds(238, 11, 109, 16);
		pnlChiTietPC.add(lblNgayPC);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(339, 8, 134, 20);
		pnlChiTietPC.add(dateChooser);
		
		JLabel lblCongDoan = new JLabel("C\u00F4ng \u0111o\u1EA1n:");
		lblCongDoan.setBounds(266, 59, 71, 17);
		pnlChiTietPC.add(lblCongDoan);
		
		JComboBox comboBoxCongDoan = new JComboBox();
		comboBoxCongDoan.setModel(new DefaultComboBoxModel(new String[] {"R\u1EADp m\u00E1y", "May v\u1EAFt s\u1ED5", "May m\u00F3c x\u00EDch k\u00E9p", "L\u00E0 \u1EE7i", "\u0110\u00F3ng g\u00F3i"}));
		comboBoxCongDoan.setBounds(339, 56, 165, 22);
		pnlChiTietPC.add(comboBoxCongDoan);
		
		JLabel lblSanPham = new JLabel("S\u1EA3n ph\u1EA9m:");
		lblSanPham.setBounds(12, 58, 65, 18);
		pnlChiTietPC.add(lblSanPham);
		
		JComboBox comboBoxSanPham = new JComboBox();
		comboBoxSanPham.setBounds(83, 56, 121, 22);
		pnlChiTietPC.add(comboBoxSanPham);
		
		JLabel lblSoLuongSP = new JLabel("S\u1ED1 l\u01B0\u1EE3ng: ");
		lblSoLuongSP.setBounds(20, 106, 67, 17);
		pnlChiTietPC.add(lblSoLuongSP);
		
		textField_2 = new JTextField();
		textField_2.setBounds(84, 104, 121, 20);
		pnlChiTietPC.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnXacNhan = new JButton("X\u00E1c nh\u1EADn");
		btnXacNhan.setBackground(Color.CYAN);
		btnXacNhan.setBounds(415, 159, 89, 23);
		pnlChiTietPC.add(btnXacNhan);
		
		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.setBackground(Color.CYAN);
		btnSua.setBounds(304, 159, 89, 23);
		pnlChiTietPC.add(btnSua);
		
		JButton btnHuy = new JButton("H\u1EE7y");
		btnHuy.setBackground(Color.CYAN);
		btnHuy.setBounds(76, 159, 89, 23);
		pnlChiTietPC.add(btnHuy);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.setBackground(Color.CYAN);
		btnXoa.setBounds(191, 159, 89, 23);
		pnlChiTietPC.add(btnXoa);
		
		JPanel panelDanhSachPC = new JPanel();
		panelDanhSachPC.setBorder(new LineBorder(Color.CYAN));
		panelDanhSachPC.setBackground(Color.WHITE);
		panelDanhSachPC.setBounds(10, 238, 908, 260);
		add(panelDanhSachPC);
		panelDanhSachPC.setLayout(null);
		
		JLabel lblDSPC = new JLabel("Danh s\u00E1ch ph\u00E2n c\u00F4ng ");
		lblDSPC.setHorizontalAlignment(SwingConstants.CENTER);
		lblDSPC.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblDSPC.setBounds(10, 0, 888, 21);
		panelDanhSachPC.add(lblDSPC);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 888, 200);
		panelDanhSachPC.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"STT", "H\u1ECD t\u00EAn", "Ng\u00E0y ph\u00E2n c\u00F4ng", "C\u00F4ng \u0111o\u1EA1n", "S\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(29);
		table.getColumnModel().getColumn(1).setPreferredWidth(170);
		table.getColumnModel().getColumn(2).setPreferredWidth(111);
		table.getColumnModel().getColumn(3).setPreferredWidth(136);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		scrollPane.setViewportView(table);
		
		JButton btnTimKiem = new JButton("");
		btnTimKiem.setSelectedIcon(new ImageIcon(PnlPhanCong.class.getResource("/image/search-icon.png")));
		btnTimKiem.setIcon(new ImageIcon(PnlPhanCong.class.getResource("/image/search-icon.png")));
		btnTimKiem.setBackground(Color.WHITE);
		btnTimKiem.setBounds(874, 23, 24, 20);
		panelDanhSachPC.add(btnTimKiem);
		
		JDateChooser dateChoosertTim = new JDateChooser();
		dateChoosertTim.setBounds(714, 23, 150, 20);
		panelDanhSachPC.add(dateChoosertTim);

	}
}
