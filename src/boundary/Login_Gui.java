package boundary;
import java.awt.event.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;


import dao.DAO_TaiKhoan;
import entity.TaiKhoan;

import java.awt.BorderLayout;

public class Login_Gui extends JFrame{

	
	private JTextField textField;
	private JPasswordField passwordField;
	private DAO_TaiKhoan dao_TaiKhoan;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login_Gui window = new Login_Gui();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Login_Gui() {
		try {
			connect.ConnectDB.getInstance().connect();
			
			dao_TaiKhoan = new DAO_TaiKhoan();
			new JFrame();
			getContentPane().setForeground(Color.LIGHT_GRAY);
			getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
			setBackground(Color.WHITE);
			getContentPane().setBackground(new Color(135, 206, 235));
			setBounds(100, 100, 674, 387);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			
			JLabel label = new JLabel("");
			
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					
				}
			});
			label.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent arg0) {
					
				}
			});
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.CYAN);
			panel.setBounds(0, 0, 660, 350);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(232, 105, 30, 29);
			panel.add(lblNewLabel_1);
			lblNewLabel_1.setIcon(new ImageIcon(Login_Gui.class.getResource("/image/mk.png")));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			
			JLabel lblNewLabel = new JLabel("\r\n");
			lblNewLabel.setIcon(new ImageIcon(Login_Gui.class.getResource("/image/User-Interface-Password-icon.png")));
			lblNewLabel.setBounds(232, 151, 25, 41);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(Login_Gui.class.getResource("/image/16-icon.png")));
			lblNewLabel_2.setBounds(53, 0, 174, 300);
			panel.add(lblNewLabel_2);
			
//			JButton btnNewButton_1 = new JButton("qu\u00EAn m\u1EADt kh\u1EA9u\r\n");
			JButton btnQuenMK = new JButton("Quên Mật Khẩu") {
				   @Override protected void paintComponent(Graphics g) {
				     if (!isOpaque()) {
				       int w = getWidth() - 1;
				       int h = getHeight() - 1;
				       Graphics2D g2 = (Graphics2D) g.create();
				       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				       g2.setPaint(UIManager.getColor("TextField.background"));
				       g2.fillRoundRect(0, 0, w, h, h, h);
				       g2.setPaint(new Color(176, 224, 230));
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
			btnQuenMK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						connect.ConnectDB.getInstance().disconnect();
						dispose();
						new QuenMk_Gui().setVisible(true);
						
				}
			});
			btnQuenMK.setBackground(new Color(176, 224, 230));
			btnQuenMK.setForeground(Color.BLACK);
			btnQuenMK.setBounds(488, 292, 141, 29);
			panel.add(btnQuenMK);
			
			textField = new JTextField();
			JTextField txtTaiKhoan = new JTextField(20) {
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
			txtTaiKhoan.setBackground(Color.GRAY);
			txtTaiKhoan.setBounds(285, 100, 248, 41);
			panel.add(txtTaiKhoan);
			txtTaiKhoan.setColumns(10);
			
			passwordField = new JPasswordField();
			JPasswordField txtPassWord = new JPasswordField(20) {
				  
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
				     setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
				   }
				 };
			txtPassWord.setBackground(Color.GRAY);
			txtPassWord.setBounds(285, 151, 248, 41);
			
			panel.add(txtPassWord);
			//		
			//		JButton JButton = new JButton("Login");
					JButton btnDangNhap = new JButton("Đăng Nhập\r\n") {
						   @Override protected void paintComponent(Graphics g) {
						     if (!isOpaque()) {
						       int w = getWidth() - 1;
						       int h = getHeight() - 1;
						       Graphics2D g2 = (Graphics2D) g.create();
						       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
						       g2.setPaint(UIManager.getColor("TextField.background"));
						       g2.fillRoundRect(0, 0, w, h, h, h);
						       g2.setPaint(new Color(176, 224, 230));
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
					btnDangNhap.setForeground(SystemColor.activeCaption);
					btnDangNhap.setBounds(433, 237, 196, 45);
					panel.add(btnDangNhap);
					btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
					btnDangNhap.setBackground(new Color(176, 224, 230));
					
					JPanel panel_1 = new JPanel();
					
					panel_1.setBorder(new EmptyBorder(0, 6, 0, 0));
					panel_1.setBackground(new Color(176, 224, 230));
					panel_1.setBounds(347, 26, 141, 41);
					panel.add(panel_1);
					panel_1.setLayout(new BorderLayout(0, 0));
					
					JLabel lblNewLabel_3 = new JLabel("APP_PAYROLL\r\n\r\n");
					lblNewLabel_3.setIcon(new ImageIcon(Login_Gui.class.getResource("/image/Cash-icon.png")));
					panel_1.add(lblNewLabel_3, BorderLayout.CENTER);
					lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
					
					JLabel lbError = new JLabel("");
					lbError.setForeground(Color.RED);
					lbError.setBounds(268, 202, 265, 13);
					panel.add(lbError);
					ArrayList<TaiKhoan> accountList = null;
					txtTaiKhoan.setText("nguyenvanloc");
					txtPassWord.setText("12345");
					
					
			btnDangNhap.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String taiKhoan = txtTaiKhoan.getText();
						String passWord = txtPassWord.getText();
						TaiKhoan taiKhoanObj = dao_TaiKhoan.taiKhoan(taiKhoan.toUpperCase());
						if(taiKhoanObj != null && passWord.equals(taiKhoanObj.getMatKhau())) {
							
							connect.ConnectDB.getInstance().disconnect();
							dispose();
							new FrameChinh(taiKhoanObj).setVisible(true);
						}else {
							lbError.setText("Tài khoản hoặc mật khẩu không chính xác");
							txtTaiKhoan.setText("");
							txtPassWord.setText("");
							
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}
				
			});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			connect.ConnectDB.getInstance().disconnect();
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
}
