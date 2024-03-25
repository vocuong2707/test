package boundary;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import dao.DAO_TaiKhoan;
import entity.TaiKhoan;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewPass extends JPanel {
	
	private JPasswordField txtNewPass;
	private JPasswordField txtRequirePass;
	private JPasswordField txtmatKhauCu;
	private JLabel lbErrorMKCu;
	private JLabel lbErrorStar1;
	private JLabel lbErrorNewPass;
	private JLabel lbErrorStar2;
	private JLabel lbErrorPassRequire;
	private JLabel lbErrorStar3;
	private DAO_TaiKhoan dao_TaiKhoan;
	/**
	 * Create the panel.
	 */
	public NewPass(TaiKhoan taiKhoan) {
		try {
			connect.ConnectDB.getInstance().connect();
			dao_TaiKhoan = new DAO_TaiKhoan();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			connect.ConnectDB.getInstance().disconnect();
		}
		setBackground(SystemColor.activeCaption);
		setForeground(SystemColor.activeCaption);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(203, 10, 122, 38);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110\u1ED5i M\u1EADt Kh\u1EA9u\r\n");
		lblNewLabel.setBackground(new Color(0, 206, 209));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 0, 98, 38);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập Mật Khẩu\r\n Cũ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(27, 82, 114, 28);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nh\u1EADp M\u1EADt Kh\u1EA9u M\u1EDBi\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(27, 167, 114, 28);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nh\u1EADp L\u1EA1i M\u1EADt Kh\u1EA9u\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(27, 251, 114, 28);
		add(lblNewLabel_3);
		
		txtNewPass = new JPasswordField() {
			   // Unleash Your Creativity with Swing and the Java 2D API!
			   // http://java.sun.com/products/jfc/tsc/articles/swing2d/index.html
			   // http://web.archive.org/web/20091205092230/http://java.sun.com/products/jfc/tsc/articles/swing2d/index.html
			   @Override protected void paintComponent(Graphics g) {
			     if (!isOpaque()) {
			       int w = getWidth() - 1;
			       int h = getHeight() - 1;
			       Graphics2D g2 = (Graphics2D) g.create();
			       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			       g2.setPaint(UIManager.getColor("TextField.background"));
			       g2.fillRoundRect(0, 0, w, h, h, h);
			       g2.setPaint(Color.GRAY);
			       g2.drawRoundRect(0, 0, w, h, h, h);
			       g2.dispose();
			     }
			     super.paintComponent(g);
			   }

			   @Override public void updateUI() {
			     super.updateUI();
			     setOpaque(false);
			     // setBackground(new Color(0x0, true));
			     setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
			   }
			 };
		txtNewPass.setBackground(Color.GRAY);
		txtNewPass.setBounds(172, 164, 234, 38);
		add(txtNewPass);
		
		txtRequirePass = new JPasswordField() {
			   // Unleash Your Creativity with Swing and the Java 2D API!
			   // http://java.sun.com/products/jfc/tsc/articles/swing2d/index.html
			   // http://web.archive.org/web/20091205092230/http://java.sun.com/products/jfc/tsc/articles/swing2d/index.html
			   @Override protected void paintComponent(Graphics g) {
			     if (!isOpaque()) {
			       int w = getWidth() - 1;
			       int h = getHeight() - 1;
			       Graphics2D g2 = (Graphics2D) g.create();
			       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			       g2.setPaint(UIManager.getColor("TextField.background"));
			       g2.fillRoundRect(0, 0, w, h, h, h);
			       g2.setPaint(Color.GRAY);
			       g2.drawRoundRect(0, 0, w, h, h, h);
			       g2.dispose();
			     }
			     super.paintComponent(g);
			   }

			   @Override public void updateUI() {
			     super.updateUI();
			     setOpaque(false);
			     // setBackground(new Color(0x0, true));
			     setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
			   }
			 };
		txtRequirePass.setBackground(Color.GRAY);
		txtRequirePass.setBounds(172, 248, 234, 38);
		add(txtRequirePass);
		
		JButton btnNewPass = new JButton("\u0110\u1ED5i M\u1EADt Kh\u1EA9u") {
			   // Unleash Your Creativity with Swing and the Java 2D API!
			   // http://java.sun.com/products/jfc/tsc/articles/swing2d/index.html
			   // http://web.archive.org/web/20091205092230/http://java.sun.com/products/jfc/tsc/articles/swing2d/index.html
			   @Override protected void paintComponent(Graphics g) {
			     if (!isOpaque()) {
			       int w = getWidth() - 1;
			       int h = getHeight() - 1;
			       Graphics2D g2 = (Graphics2D) g.create();
			       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			       g2.setPaint(UIManager.getColor("TextField.background"));
			       g2.fillRoundRect(0, 0, w, h, h, h);
			       g2.setPaint(Color.GRAY);
			       g2.drawRoundRect(0, 0, w, h, h, h);
			       g2.dispose();
			     }
			     super.paintComponent(g);
			   }

			   @Override public void updateUI() {
			     super.updateUI();
			     setOpaque(false);
			     // setBackground(new Color(0x0, true));
			     setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
			   }
			 };
		
		btnNewPass.setForeground(new Color(0, 206, 209));
		btnNewPass.setBackground(new Color(0, 206, 209));
		btnNewPass.setBounds(284, 327, 122, 45);
		add(btnNewPass);
		
		txtmatKhauCu = new JPasswordField() {
			   // Unleash Your Creativity with Swing and the Java 2D API!
			   // http://java.sun.com/products/jfc/tsc/articles/swing2d/index.html
			   // http://web.archive.org/web/20091205092230/http://java.sun.com/products/jfc/tsc/articles/swing2d/index.html
			   @Override protected void paintComponent(Graphics g) {
			     if (!isOpaque()) {
			       int w = getWidth() - 1;
			       int h = getHeight() - 1;
			       Graphics2D g2 = (Graphics2D) g.create();
			       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			       g2.setPaint(UIManager.getColor("TextField.background"));
			       g2.fillRoundRect(0, 0, w, h, h, h);
			       g2.setPaint(Color.GRAY);
			       g2.drawRoundRect(0, 0, w, h, h, h);
			       g2.dispose();
			     }
			     super.paintComponent(g);
			   }

			   @Override public void updateUI() {
			     super.updateUI();
			     setOpaque(false);
			     // setBackground(new Color(0x0, true));
			     setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
			   }
			 };
		txtmatKhauCu.setBackground(Color.GRAY);
		txtmatKhauCu.setBounds(172, 79, 234, 38);
		add(txtmatKhauCu);
		
		 lbErrorMKCu = new JLabel("");
		lbErrorMKCu.setForeground(Color.RED);
		lbErrorMKCu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbErrorMKCu.setBounds(182, 127, 224, 20);
		add(lbErrorMKCu);
		
		 lbErrorStar1 = new JLabel("");
		lbErrorStar1.setForeground(Color.RED);
		lbErrorStar1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbErrorStar1.setBounds(416, 82, 158, 28);
		add(lbErrorStar1);
		
		 lbErrorNewPass = new JLabel("");
		lbErrorNewPass.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbErrorNewPass.setForeground(Color.RED);
		lbErrorNewPass.setBounds(182, 212, 224, 20);
		add(lbErrorNewPass);
		
		 lbErrorPassRequire = new JLabel("");
		lbErrorPassRequire.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbErrorPassRequire.setForeground(Color.RED);
		lbErrorPassRequire.setBounds(182, 296, 224, 20);
		add(lbErrorPassRequire);
		
		 lbErrorStar3 = new JLabel("");
		lbErrorStar3.setForeground(Color.RED);
		lbErrorStar3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbErrorStar3.setBounds(416, 260, 158, 19);
		add(lbErrorStar3);
		
		 lbErrorStar2 = new JLabel("");
		lbErrorStar2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbErrorStar2.setForeground(Color.RED);
		lbErrorStar2.setBounds(416, 176, 158, 19);
		add(lbErrorStar2);
		btnNewPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkTxt() == true) {
					if(txtmatKhauCu.getText().equals(taiKhoan.getMatKhau())) {	
						if(!txtNewPass.getText().equals(txtRequirePass.getText())) {
							lbErrorNewPass.setText("Mật khẩu không giống nhau");
							lbErrorStar2.setText("*");
							lbErrorPassRequire.setText("Mật khẩu không giống nhau");
							lbErrorStar3.setText("*");
							lbErrorMKCu.setText("");
							lbErrorStar1.setText("");
						}else {
							if(dao_TaiKhoan.updateAccount(taiKhoan.getTenTK(), txtNewPass.getText()) == true) {
								JOptionPane.showMessageDialog(null, "Đổi Mật Khẩu Thành Công");
								xoaTrangTXT();
								xoaTrangLabel();
							}
						}
					}else {
						xoaTrangLabel();
						xoaTrangTXT();
						lbErrorMKCu.setText("Mật khẩu cũ không chính xác");
						lbErrorStar1.setText("*");
					}
				}
			}
		});

	}
	public void xoaTrangTXT() {
		txtmatKhauCu.setText("");
		txtNewPass.setText("");
		txtRequirePass.setText("");
	}
	public void xoaTrangLabel() {
		lbErrorMKCu.setText("");
		lbErrorStar1.setText("");
		lbErrorNewPass.setText("");
		lbErrorStar2.setText("");
		lbErrorPassRequire.setText("");
		lbErrorStar3.setText("");
	}
	public boolean checkTxt() {
		
		
		boolean check = true;
		if(txtmatKhauCu.getText().equalsIgnoreCase("") || txtNewPass.getText().equalsIgnoreCase("") || txtRequirePass.getText().equalsIgnoreCase("")) {
			xoaTrangTXT();
			xoaTrangLabel();
			JOptionPane.showMessageDialog(null, "Không được để trống");
			check = false;
			
		}
		
		
		return check;
	}
}
