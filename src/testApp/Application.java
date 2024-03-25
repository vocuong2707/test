package testApp;

import boundary.FrameChinh;
import boundary.Login_Gui;
import entity.CongNhan;

public class Application {
	public static void main(String[] args) {
		try {
			Login_Gui frame = new Login_Gui();
			frame.setVisible(true);
			CongNhan cn = new CongNhan();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	