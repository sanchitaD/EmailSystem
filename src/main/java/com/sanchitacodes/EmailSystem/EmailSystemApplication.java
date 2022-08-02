package com.sanchitacodes.EmailSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class EmailSystemApplication {

	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(EmailSystemApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
//		service.sendEmail("emailsystem121@gmail.com", "This is the Email body...", "This is the Email subject");
		service.senEmailWithAttachment("emailsystem121@gmail.com", "This is the Email body with attachment",
				"This email has attachment", "C:\\Users\\Sanchitha\\Desktop\\AI_engg.png" );
	}
}
