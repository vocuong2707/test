package boundary;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.jdi.connect.Transport;


public class Main {
		public static void sendMail(String recepient , String title) throws Exception {
			System.out.println("Preparing to send email");

			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
			
			String myAccountEmail = "cuongvo.26022020@gmail.com";
			String myAccountPass = "zfagqlakaogsffcs";
			
			Session session = Session.getInstance(properties,new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication(myAccountEmail, myAccountPass);
				}
			});
			
			Message message = prepareMessage(session , myAccountEmail,recepient,title);
			
			javax.mail.Transport.send(message);
			System.out.println("Message sent susscessfully");

		}
		private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String title) {
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(myAccountEmail));
				message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
				message.setSubject("My First Email From Java App");
				message.setText(title);
				return message;
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
			return null;
			
		}
}	