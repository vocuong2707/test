package boundary;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JMenu;
import javax.swing.JLabel;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PnlTienLuong extends JPanel {
	private JTable tableLuong;

	/**
	 * Create the panel.
	 */
	public PnlTienLuong() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBorder(BorderFactory.createTitledBorder("Tiền lương"));
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 21, 148, 22);
		add(menuBar);
		
		JMenu mnCongNhan = new JMenu("C\u00F4ng nh\u00E2n");
		menuBar.add(mnCongNhan);
		
		JMenu mnNhanVien = new JMenu("Nhân viên");
		menuBar.add(mnNhanVien);
		
		JPanel pnlBangLuong = new JPanel();
		pnlBangLuong.setBorder(new LineBorder(Color.CYAN));
		pnlBangLuong.setBackground(Color.WHITE);
		pnlBangLuong.setBounds(10, 107, 902, 387);
		add(pnlBangLuong);
		pnlBangLuong.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPanelLuong = new JScrollPane();
		pnlBangLuong.add(scrollPanelLuong, BorderLayout.CENTER);
		
		tableLuong = new JTable();
		tableLuong.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"STT", "H\u1ECD t\u00EAn", "Ph\u1EE5 c\u1EA5p", "Ti\u1EC1n l\u01B0\u01A1ng", "Ti\u1EC1n th\u01B0\u1EDFng", "Ti\u1EC1n ph\u1EA1t", "T\u1ED5ng ti\u1EC1n l\u01B0\u01A1ng"
			}
		));
		scrollPanelLuong.setViewportView(tableLuong);
		
		JLabel lblThang = new JLabel("Tháng: ");
		lblThang.setBounds(10, 61, 57, 22);
		add(lblThang);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(58, 60, 119, 23);
		add(monthChooser);
		
		JLabel lblNam = new JLabel("Năm: ");
		lblNam.setBounds(216, 65, 57, 18);
		add(lblNam);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(259, 61, 67, 22);
		add(yearChooser);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(702, 61, 183, 22);
		add(comboBox);
		
		JButton btnTimKiem = new JButton("");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem.setBackground(Color.WHITE);
		btnTimKiem.setSelectedIcon(new ImageIcon(PnlTienLuong.class.getResource("/image/search-icon.png")));
		btnTimKiem.setIcon(new ImageIcon(PnlTienLuong.class.getResource("/image/search-icon.png")));
		btnTimKiem.setBounds(890, 60, 22, 23);
		add(btnTimKiem);

	}
}
