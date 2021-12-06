package com.appeals.appeals.service.mail;

import com.appeals.appeals.configuration.InitMailSender;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailSenderService implements EmailSender {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailSenderService.class);
    private final InitMailSender mailSender;

    @Override
    @Async
    public void send(String to, String email) {
        try{
            MimeMessage mimeMessage = mailSender.getJavaMailSender().createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirm your email");
            helper.setFrom("taraspih@gmail.com");
            mailSender.getJavaMailSender().send(mimeMessage);
        }catch (MessagingException e) {
            LOGGER.error("failed to send email: " + e);
            throw new IllegalStateException("failde to send email");
        }

    }
}
