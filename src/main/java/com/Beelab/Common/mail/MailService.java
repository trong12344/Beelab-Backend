package com.Beelab.Common.mail;

import jakarta.mail.MessagingException;

public interface MailService {
    void sendEmail( String to, String subject, String content) throws MessagingException;

}
