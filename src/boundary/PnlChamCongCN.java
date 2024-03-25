package boundary;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class PnlChamCongCN extends JPanel {
	private JTable tableDSCC;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PnlChamCongCN() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(Color.CYAN);
		pnTitle.setForeground(Color.WHITE);
		pnTitle.setBounds(10, 11, 908, 35);
		add(pnTitle);
		pnTitle.setLayout(null);
		
		JLabel lblTitle = new JLabel("Ch\u1EA5m c\u00F4ng c\u00F4ng nh\u00E2n");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitle.setBounds(10, 0, 239, 35);
		pnTitle.add(lblTitle);
		
		JDateChooser dateNgayChamCong = new JDateChooser();
		dateNgayChamCong.setBounds(37, 73, 118, 20);
		add(dateNgayChamCong);
		
		JLabel lblNgayCC = new JLabel("Ng\u00E0y ch\u1EA5m c\u00F4ng:");
		lblNgayCC.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNgayCC.setBounds(10, 47, 130, 30);
		add(lblNgayCC);
		
		JPanel pnDSCC = new JPanel();
		pnDSCC.setBorder(new LineBorder(Color.CYAN));
		pnDSCC.setBounds(10, 104, 908, 383);
		add(pnDSCC);
		pnDSCC.setLayout(null);
		
		JLabel lblDSCN = new JLabel("Danh s\u00E1ch ch\u1EA5m c\u00F4ng c\u00F4ng nh\u00E2n");
		lblDSCN.setBounds(0, 0, 908, 33);
		lblDSCN.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		pnDSCC.add(lblDSCN);
		lblDSCN.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPaneDSCC = new JScrollPane();
		scrollPaneDSCC.setBounds(10, 44, 888, 305);
		pnDSCC.add(scrollPaneDSCC);
		
		tableDSCC = new JTable();
		tableDSCC.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"STT", "H\u1ECD t\u00EAn", "C\u00F4ng \u0111o\u1EA1n", "S\u1ED1 l\u01B0\u1EE3ng", "S\u1ED1 gi\u1EDD t\u0103ng ca", "Ho\u00E0n th\u00E0nh/ Ko ho\u00E0n th\u00E0nh"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		//Thêm comboBox vào table (Số giờ tăng ca)
		JComboBox comSoGioTangCa = new JComboBox();
		comSoGioTangCa.addItem("0");
		comSoGioTangCa.addItem("1");
		comSoGioTangCa.addItem("2");
		comSoGioTangCa.addItem("3");
		comSoGioTangCa.addItem("4");
		comSoGioTangCa.setSelectedIndex(0);
		DefaultCellEditor deSoGioTangCa = new DefaultCellEditor(comSoGioTangCa);
		
		tableDSCC.getColumnModel().getColumn(0).setPreferredWidth(48);
		tableDSCC.getColumnModel().getColumn(1).setPreferredWidth(151);
		tableDSCC.getColumnModel().getColumn(2).setPreferredWidth(107);
		tableDSCC.getColumnModel().getColumn(3).setPreferredWidth(94);
		tableDSCC.getColumnModel().getColumn(4).setCellEditor(deSoGioTangCa);;
		tableDSCC.getColumnModel().getColumn(5).setPreferredWidth(181);
		scrollPaneDSCC.setViewportView(tableDSCC);
		
		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.setBackground(Color.CYAN);
		btnSua.setBounds(698, 353, 89, 23);
		pnDSCC.add(btnSua);
		
		JButton btnLuu = new JButton("L\u01B0u");
		btnLuu.setBackground(Color.CYAN);
		btnLuu.setBounds(811, 353, 89, 23);
		pnDSCC.add(btnLuu);
		
		JButton btnHuy = new JButton("H\u1EE7y");
		btnHuy.setBackground(Color.CYAN);
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHuy.setBounds(583, 353, 89, 23);
		pnDSCC.add(btnHuy);
		
		JLabel lblSanPham = new JLabel("S\u1EA3n ph\u1EA9m: ");
		lblSanPham.setBounds(245, 52, 73, 20);
		add(lblSanPham);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u00C1o s\u01A1 mi", "Qu\u1EA7n t\u00E2y"}));
		comboBox.setBounds(267, 71, 104, 22);
		add(comboBox);
		
		JComboBox comboBoxTimKiem = new JComboBox();
		comboBoxTimKiem.setModel(new DefaultComboBoxModel(new String[] {"Rập máy", "May vắt sổ", "May móc xích kép", "Là ủi", "Đóng gói"}));
		comboBoxTimKiem.setBounds(478, 73, 136, 22);
		add(comboBoxTimKiem);
		
		JLabel lblTimTheoCongDoan = new JLabel("Tìm theo công đoạn: ");
		lblTimTheoCongDoan.setBounds(445, 52, 130, 20);
		add(lblTimTheoCongDoan);
		
		textField = new JTextField();
		textField.setBounds(768, 73, 124, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblTimTheoTen = new JLabel("Tìm theo tên:");
		lblTimTheoTen.setBounds(728, 50, 146, 24);
		add(lblTimTheoTen);
		
		JButton btnTimTheoTen = new JButton("");
		btnTimTheoTen.setSelectedIcon(new ImageIcon(PnlChamCongCN.class.getResource("/image/search-icon.png")));
		btnTimTheoTen.setIcon(new ImageIcon(PnlChamCongCN.class.getResource("/image/search-icon.png")));
		btnTimTheoTen.setBackground(Color.WHITE);
		btnTimTheoTen.setBounds(894, 70, 24, 23);
		add(btnTimTheoTen);

	}
}
