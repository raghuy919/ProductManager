package com.codejava.ProductManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
@Service
@Async
public class MailServiceImpl implements MailService {

	@Autowired
    private JavaMailSender javaMailSender;
	
	@Override
	public void sendMail(String to, String subject, String message) {
		SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(message);
        javaMailSender.send(msg);
	}

}
