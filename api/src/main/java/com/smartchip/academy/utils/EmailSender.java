package com.smartchip.academy.utils;

import java.io.File;

import jakarta.mail.*;

import jakarta.mail.internet.*;
import jakarta.activation.*;

import java.util.Properties;

public class EmailSender {

    public static void sendEmail(String host, String port, final String username, final String password,
                                 String toAddress, String subject, String message, File attachmentFile) throws MessagingException {

        // Set up mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // For TLS

        // Create a session with authenticator
        // Create a session with authenticator

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
        Session session = Session.getInstance(properties, auth);

        // Create a new email message
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(username));
        InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new java.util.Date());
        // Create the message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(message);

        // Create a multipart message for attachments
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // Second part is the attachment
        if (attachmentFile != null && attachmentFile.exists()) {
            MimeBodyPart attachmentPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachmentFile);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName(attachmentFile.getName());
            multipart.addBodyPart(attachmentPart);
        }

        msg.setContent(multipart);

        // Send the email
        Transport.send(msg);
    }

    /** public static void main(String[] args) {
     // SMTP server information
     String host = "smtp.example.com";
     String port = "587";
     String username = "your-email@example.com";
     String password = "your-email-password";

     // Outgoing email information
     String toAddress = "recipient@example.com";
     String subject = "Test Email";
     String message = "Hello, this is a test email from Jakarta Mail!";

     try {
     sendEmail(host, port, username, password, toAddress, subject, message);
     System.out.println("Email sent successfully!");
     } catch (MessagingException e) {
     e.printStackTrace();
     }
     } */
}

