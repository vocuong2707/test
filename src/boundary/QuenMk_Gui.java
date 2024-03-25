package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import dao.DAO_TaiKhoan;
import entity.TaiKhoan;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuenMk_Gui extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private DAO_TaiKhoan dao_TaiKhoan;
	TaiKhoan taiKhoan = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuenMk_Gui mk = new QuenMk_Gui();
					mk.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuenMk_Gui(){
		
		try {
			connect.ConnectDB.getInstance().connect();
			dao_TaiKhoan = new DAO_TaiKhoan();
		} catch (Exception e) {
			// TODO: handle exception
			connect.ConnectDB.getInstance().disconnect();
			e.printStackTrace();
			
		}
		
		setBackground(SystemColor.activeCaption);
		setBounds(100, 100, 507, 317);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new CompoundBorder());
		panel.setBounds(0, 0, 493, 280);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp t\u00EAn \u0111\u0103ng nh\u1EADp");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(225, 55, 130, 29);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		JTextField txtTenTK = new JTextField(20) {
			   @Override protected void paintComponent(Graphics g) {
			     if (!isOpaque()) {
			       int w = getWidth() - 1;
			       int h = getHeight() - 1;
			       Graphics2D g2 = (Graphics2D) g.create();
			       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			       g2.setPaint(UIManager.getColor("TextField.background"));
			       g2.fillRoundRect(0, 0, w, h, h, h);
			       g2.setPaint(Color.gray);
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
		txtTenTK.setBackground(Color.GRAY);
		txtTenTK.setBounds(225, 94, 239, 35);
		panel.add(txtTenTK);
		txtTenTK.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nh\u1EADp Gmail");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(225, 139, 83, 29);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		JTextField txtGmail = new JTextField(20) {
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
		txtGmail.setBackground(Color.GRAY);
		txtGmail.setBounds(225, 178, 239, 35);
		panel.add(txtGmail);
		txtGmail.setColumns(10);
		
//		JButton btnNewButton = new JButton("G\u1EEDi X\u00E1c Nh\u1EADn\r\n");
		JButton btnNewButton = new JButton("G\u1EEDi X\u00E1c Nh\u1EADn\r\n") {
			   @Override protected void paintComponent(Graphics g) {
			     if (!isOpaque()) {
			       int w = getWidth() - 1;
			       int h = getHeight() - 1;
			       Graphics2D g2 = (Graphics2D) g.create();
			       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			       g2.setPaint(UIManager.getColor("TextField.background"));
			       g2.fillRoundRect(0, 0, w, h, h, h);
			       g2.setPaint(new Color(135, 206, 250));
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taiKhoan = new TaiKhoan();
				Main main = new Main();
				String tenTK = txtTenTK.getText();
				taiKhoan = dao_TaiKhoan.getTaiKhoan(tenTK);

				if(dao_TaiKhoan.getTaiKhoan(tenTK) != null) {
					connect.ConnectDB.getInstance().disconnect();
					
					System.out.println(taiKhoan.getEmail());
					 new JavaMail(taiKhoan);
					 dispose();
					
				}else {
					System.out.println("Tai Khoan Khong Ton Tai");
				}
			}
		});
		btnNewButton.setForeground(SystemColor.activeCaption);
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setBounds(270, 230, 130, 35);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(QuenMk_Gui.class.getResource("/image/16-icon.png")));
		lblNewLabel_3.setBounds(41, -21, 149, 306);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(277, 10, 115, 35);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Qu\u00EAn M\u1EADt Kh\u1EA9u");
		panel_1.add(lblNewLabel_2, BorderLayout.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	}

}

