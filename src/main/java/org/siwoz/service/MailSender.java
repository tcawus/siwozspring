package org.siwoz.service;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("mailSender")
@Transactional
public class MailSender extends JavaMailSenderImpl {

	public MailSender() {
		setHost("smtp.gmail.com");
		setPort(25);
		setUsername("siwoz2014@gmail.com");
		setPassword("siwoz20142014");

		Properties javaMailProperties = new Properties();
		javaMailProperties.setProperty("mail.transport.protocol", "smtp");
		javaMailProperties.setProperty("mail.smtp.auth", "true");
		javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
		setJavaMailProperties(javaMailProperties);
	}

	public void send(String to, String subject, String content) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("siwoz2014@gmail.com");
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(content);
		send(simpleMailMessage);
	}
}
