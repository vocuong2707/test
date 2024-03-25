package boundary;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class PnlChamCongNV extends JPanel {
	private JTable tableDSCCNV;
	private JTextField txtTimTheoTen;

	/**
	 * Create the panel.
	 */
	public PnlChamCongNV() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);

		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(Color.CYAN);
		pnTitle.setBounds(10, 11, 915, 36);
		add(pnTitle);
		pnTitle.setLayout(null);

		JLabel lblTitle = new JLabel("Ch\u1EA5m c\u00F4ng nh\u00E2n vi\u00EAn");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitle.setBounds(10, 0, 256, 36);
		pnTitle.add(lblTitle);

		JLabel lblNgayChamCong = new JLabel("Ng\u00E0y ch\u1EA5m c\u00F4ng: ");
		lblNgayChamCong.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNgayChamCong.setBounds(20, 65, 119, 22);
		add(lblNgayChamCong);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(123, 67, 129, 20);
		add(dateChooser);

		JComboBox comboBoxTimKiem = new JComboBox();
		comboBoxTimKiem.setBounds(762, 65, 139, 22);
		add(comboBoxTimKiem);

		JButton btnTimKiemTheoPB = new JButton("");
		btnTimKiemTheoPB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiemTheoPB.setBackground(Color.WHITE);
		btnTimKiemTheoPB.setIcon(new ImageIcon("T:\\HK5\\PTUD\\BTLonCK\\App_PayRoll\\src\\image\\search-icon.png"));
		btnTimKiemTheoPB.setSelectedIcon(new ImageIcon("T:\\HK5\\PTUD\\BTLonCK\\App_PayRoll\\src\\image\\search-icon.png"));
		btnTimKiemTheoPB.setBounds(901, 65, 24, 22);
		add(btnTimKiemTheoPB);

		JPanel pnlDSCCNV = new JPanel();
		pnlDSCCNV.setBorder(new LineBorder(Color.CYAN));
		pnlDSCCNV.setBounds(10, 98, 915, 397);
		add(pnlDSCCNV);
		pnlDSCCNV.setLayout(null);

		JLabel lblDSCCNV = new JLabel("Danh s\u00E1ch ch\u1EA5m c\u00F4ng nh\u00E2n vi\u00EAn");
		lblDSCCNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblDSCCNV.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblDSCCNV.setBounds(0, 0, 925, 34);
		pnlDSCCNV.add(lblDSCCNV);

		JScrollPane scrollPaneDSCCNV = new JScrollPane();
		scrollPaneDSCCNV.setBounds(10, 33, 895, 319);
		pnlDSCCNV.add(scrollPaneDSCCNV);

		tableDSCCNV = new JTable();
		tableDSCCNV.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, },
				new String[] { "STT", "H\u1ECD t\u00EAn ", "C\u00F3 m\u1EB7t/ V\u1EAFng", "Tr\u1EA1ng th\u00E1i",
						"Ph\u00E9p/ Kh\u00F4ng ph\u00E9p", "S\u1ED1 gi\u1EDD t\u0103ng ca", "Ghi ch\u00FA" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Boolean.class, Object.class, Boolean.class,
					Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		// Thêm JcomboBox trạng thái vào table
		JComboBox comTrangThai = new JComboBox();
		comTrangThai.addItem("Nguyên ngày");
		comTrangThai.addItem("Nửa buổi");
		DefaultCellEditor deTrangThai = new DefaultCellEditor(comTrangThai);
		// Thêm JcomboBox số giờ tăng ca vào table
		JComboBox comSoGioTangCa = new JComboBox();
		comSoGioTangCa.addItem("0");
		comSoGioTangCa.addItem("1");
		comSoGioTangCa.addItem("2");
		comSoGioTangCa.addItem("3");
		comSoGioTangCa.addItem("4");
		comSoGioTangCa.setSelectedIndex(0);
		DefaultCellEditor deSoGioTangCa = new DefaultCellEditor(comSoGioTangCa);
		
		tableDSCCNV.getColumnModel().getColumn(0).setPreferredWidth(37);
		tableDSCCNV.getColumnModel().getColumn(1).setPreferredWidth(160);
		tableDSCCNV.getColumnModel().getColumn(2).setPreferredWidth(39);
		tableDSCCNV.getColumnModel().getColumn(3).setCellEditor(deTrangThai);
		tableDSCCNV.getColumnModel().getColumn(4).setPreferredWidth(69);
		tableDSCCNV.getColumnModel().getColumn(5).setCellEditor(deSoGioTangCa);
		tableDSCCNV.getColumnModel().getColumn(6).setPreferredWidth(163);
		scrollPaneDSCCNV.setViewportView(tableDSCCNV);

		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSua.setBackground(Color.CYAN);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSua.setBounds(696, 363, 89, 23);
		pnlDSCCNV.add(btnSua);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLuu.setBackground(Color.CYAN);
		btnLuu.setBounds(816, 363, 89, 23);
		pnlDSCCNV.add(btnLuu);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBackground(Color.CYAN);
		btnHuy.setBounds(577, 363, 89, 23);
		pnlDSCCNV.add(btnHuy);
		
		txtTimTheoTen = new JTextField();
		txtTimTheoTen.setToolTipText("\r\n");
		txtTimTheoTen.setBounds(396, 67, 144, 20);
		add(txtTimTheoTen);
		txtTimTheoTen.setColumns(10);
		
		JLabel lblTimTheoTen = new JLabel("Tìm theo tên:");
		lblTimTheoTen.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTimTheoTen.setBounds(312, 70, 96, 17);
		add(lblTimTheoTen);
		
		JLabel lblTimTheoPB = new JLabel("Tìm theo phòng ban:");
		lblTimTheoPB.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTimTheoPB.setBounds(643, 68, 136, 17);
		add(lblTimTheoPB);
		
		JButton btnTimTheoTen = new JButton("");
		btnTimTheoTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimTheoTen.setBackground(Color.WHITE);
		btnTimTheoTen.setSelectedIcon(new ImageIcon(PnlChamCongNV.class.getResource("/image/search-icon.png")));
		btnTimTheoTen.setIcon(new ImageIcon(PnlChamCongNV.class.getResource("/image/search-icon.png")));
		btnTimTheoTen.setBounds(541, 65, 24, 23);
		add(btnTimTheoTen);

	}
}
