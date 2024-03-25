package boundary;

import javax.swing.JPanel;

import entity.TaiKhoan;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

public class pnlThongTin extends JPanel {

	/**
	 * Create the panel.
	 */
	public pnlThongTin(TaiKhoan taiKhoan) {
		setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(35, 10, 712, 44);
		add(panel_1_1);
		panel_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblThngTinC_1 = new JLabel("Thông Tin Cá Nhân");
		lblThngTinC_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel_1_1.add(lblThngTinC_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(35, 67, 712, 360);
		add(panel_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Nhân Viên: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(80, 32, 104, 25);
		panel_2_1.add(lblNewLabel_1);
		
		JLabel lblSinThoi_1 = new JLabel("Chứng Minh Nhân Dân");
		lblSinThoi_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSinThoi_1.setBounds(80, 160, 147, 25);
		panel_2_1.add(lblSinThoi_1);
		
		JLabel lblChcV_1 = new JLabel("Chức Vụ: ");
		lblChcV_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblChcV_1.setBounds(80, 96, 104, 25);
		panel_2_1.add(lblChcV_1);
		
		JLabel lblTenNV_1 = new JLabel(taiKhoan.getNhanVien().getTenNhanVien());
		lblTenNV_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTenNV_1.setBounds(297, 32, 398, 25);
		panel_2_1.add(lblTenNV_1);
		
		JLabel lblChucVu_1 = new JLabel(taiKhoan.getNhanVien().getChucVu());
		lblChucVu_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblChucVu_1.setBounds(297, 93, 360, 30);
		panel_2_1.add(lblChucVu_1);
		
		JLabel lblSDT_1 = new JLabel(taiKhoan.getNhanVien().getCMND());
		lblSDT_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSDT_1.setBounds(297, 160, 300, 25);
		panel_2_1.add(lblSDT_1);

	}
}
