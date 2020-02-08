package org.weida.toko.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.weida.toko.exception.AccountEmailException;

@Service
public class AccountEmailServiceImpl implements AccountEmail {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;


    @Override
    public void sendEmail(String to, String subject, String text) throws AccountEmailException {
        SimpleMailMessage message =  new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        try{
            mailSender.send(message);
            logger.info( "简单邮件已经发送。" );
        } catch(Exception e){
            logger.error("发送简单邮件时发生异常！",e);
        }

    }
}
