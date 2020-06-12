package com.jarvissoft.anti.cpu.app.utility.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class ForgotPasswordEmailUtility {

	public static String forgotPasswordLinkSendMail(String toEmail) {

		String flagMessage = null;

		final String username = "info.lightscoreindia@gmail.com";
		final String password = "pwydofssmktkiztx";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject("here's the link to reset your password");
			message.setText("Hello " + toEmail + "\n\n Reset your password, and we'll get you on your way."
					+ "\n\n To change your LIGHT'S SCORE INFOSERVICES PRIVATE LIMITED password, click or paste the following link into your browser:\n\n"
					+ "https://www.lightsscore.in/changeForgotPanel"
					+ "\n\n\n This link will expire in 24 hours, so be sure to use it right away.\n\nThank you for using LIGHT'S SCORE INFOSERVICES PRIVATE LIMITED!\n"
					+ "The LIGHT'S SCORE INFOSERVICES PRIVATE LIMITED Team");
			Transport.send(message);
			flagMessage = "Sent the Mail You Provided Mail id..Follow the Instruction in this mail..!!";
			System.out.println("Done");
			return flagMessage;
		} catch (MessagingException e) {
			flagMessage = "Something Went Wrong..Try Again..!!";
			e.printStackTrace();
			return flagMessage;
		}
	}

}
