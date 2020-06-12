package com.jarvissoft.anti.cpu.app.utility.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;

import com.jarvissoft.anti.cpu.app.utility.constants.RoleConstants;

import javax.mail.internet.MimeBodyPart;
import javax.mail.Multipart;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

public class RegistrationEmailUtility {

	public static String loginUserNameAndPasswordSendMail(String toEmail, String userPassword, String role,
			HttpServletRequest request) {

		String flagMessage = null;

		final String username = "info.lightscoreindia@gmail.com";
		final String password = "pwydofssmktkiztx";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			if (role.equals(RoleConstants.SOCIETY) || role.equals(RoleConstants.SOCIETY_BRANCH)) {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
				message.setSubject("Credentials for your Lights Account");

				String imagePath = "resources/assets/documents/societies/MUTUAL-NON-DISCLOSURE-AGREEMENT-LIGHTSSCORE.pdf";

				// Create the message part
				BodyPart messageBodyPart = new MimeBodyPart();

				// Now set the actual message
				messageBodyPart.setText("Hello " + toEmail + "\n\n Reset your password, and we'll get you on your way."
						+ "\n\n Your Login Credentials as below Please change your password after login for security purpose:\n\n\n\n"
						+ "User Name :" + toEmail + "\n\n Password :" + userPassword
						+ "\n\n                 Please find the Attachement of the Agreement.\n\nInstruction : \n    Take the hard copy of the agreement, Sign the copy and again scan the agreement and upload it on the link given below.");

				// Create a multipar message
				Multipart multipart = new MimeMultipart();

				// Set text message part
				multipart.addBodyPart(messageBodyPart);
				// Part two is attachment
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(request.getRealPath("") + imagePath);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName("MUTUAL-NON-DISCLOSURE-AGREEMENT-LIGHTSSCORE.pdf");
				multipart.addBodyPart(messageBodyPart);

				// Send the complete message parts
				message.setContent(multipart);

				Transport.send(message);
				flagMessage = "Sent the Mail You Provided Mail id..Follow the Instruction in this mail..!!";
				System.out.println("Done");
				return flagMessage;
			} else if (role.equals(RoleConstants.SUB_ADMIN)) {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
				message.setSubject("Credentials for your Lights Account");

				// Now set the actual message
				message.setText("Hello " + toEmail + "\n\n Reset your password, and we'll get you on your way."
						+ "\n\n Your Login Credentials as below Please change your password after login for security purpose:\n\n\n\n"
						+ "User Name :" + toEmail + "\n\n Password :" + userPassword);

				Transport.send(message);
				flagMessage = "Sent the Mail You Provided Mail id..Follow the Instruction in this mail..!!";
				System.out.println("Done");
				return flagMessage;
			}

		} catch (MessagingException e) {
			flagMessage = "Something Went Wrong..Try Again..!!";
			e.printStackTrace();
			return flagMessage;
		}
		return flagMessage;
	}

}
