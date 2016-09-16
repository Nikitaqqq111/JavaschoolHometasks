package ru.sbt.javaschool.refactoring.reportnotifier;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Никита on 16.09.2016.
 */
public class Sender {

    public static void send(String host, String subject, String text, String recipients) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(recipients);
            helper.setText(text, true);
            helper.setSubject(subject);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("MessagingException from Sender", e);
        }
    }

}
