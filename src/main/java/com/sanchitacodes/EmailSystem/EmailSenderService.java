package com.sanchitacodes.EmailSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String emailTo, String msgBody, String subject ){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("emailsystem121@gmail.com");
        message.setTo(emailTo);
        message.setText(msgBody);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail send!!");
    }

    public void senEmailWithAttachment(String emailTo, String msgBody,
                                       String subject, String attachment) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("emailsystem121@gmail.com");
        mimeMessageHelper.setTo(emailTo);
        mimeMessageHelper.setText(msgBody);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
        mailSender.send(mimeMessage);
        System.out.println("Mail Send!!");

    }
}
