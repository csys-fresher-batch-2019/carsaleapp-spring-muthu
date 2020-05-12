package com.chainsys.carsaleapp.util;

import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {
	public static void send(final String from, final String password, String to, String sub, String msg)
			throws IOException {
		System.out.println(System.getProperty("java.ext.dirs"));
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.ssl.enable","true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		//props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.ssl.checkserveridentity", true);
		System.out.println("to:" + to);
		System.out.println("from"+from);
		System.out.println("pass"+password);
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);

			}
		});
		session.setDebug(true);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom();
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			Multipart multipart = messageBody(msg);
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	private static Multipart messageBody(String msg) throws MessagingException {
		{
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("WELLCOME TO BUYSELL\n");
			BodyPart messageBodyPart2 = new MimeBodyPart();
			messageBodyPart2.setText(msg);

			/*
			 * String filename = "SendAttachment.java"; FileDataSource source = new
			 * FileDataSource("./src/test/java/com/chainsys/PayrollApp/SendMailSSL.java");
			 * messageBodyPart2.setDataHandler(new DataHandler(source));
			 * messageBodyPart2.setFileName(filename);
			 */

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);
			return multipart;

		}
	}
}
