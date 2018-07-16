package com.inturn.biz.users.dao;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inturn.biz.users.vo.MailVO;

@Repository("MailDAO")
public class MailDAOImpl implements MailDAO{
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	@Override
	public MailVO init(int port) {
		return mybatis.selectOne("MailMapper.Mail_Info",port);
	}

	@Override
	public boolean sendEmail(String subject, String contents, String to, MailVO vo) {
		 // Create a Properties object to contain connection configuration information.
    	Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtps");
    	props.put("mail.smtp.port", vo.getPort()); 
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.ssl.enable", "true"); 

        // Create a Session object to represent a mail session with the specified properties. 
    	Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information. 
        MimeMessage msg = new MimeMessage(session);
			try {
				msg.setFrom(new InternetAddress(vo.getFrom_addr(),vo.getFromname()));
				msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
				msg.setSubject(subject);
				msg.setContent(contents,"text/html; charset=UTF-8");
			} catch (UnsupportedEncodingException | MessagingException e) {
				System.out.println(e.getMessage());
			}

        
        // Add a configuration set header. Comment or delete the 
        // next line if you are not using a configuration set
        //msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);
            
        // Create a transport.
        Transport transport = null;
		try {
			transport = session.getTransport();
		} catch (NoSuchProviderException e) {
			System.out.println(e.getMessage());
		}
        
        boolean flag = true;
                    
        // Send the message.
        try
        {
            System.out.println("Sending...");
            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(vo.getHost(), vo.getSmtp_username(), vo.getSmtp_userpassword());
        	
            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
            flag=true;
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
            flag=false;
        }
        finally
        {
            // Close and terminate the connection.
            try {
				transport.close();
			} catch (MessagingException e) {
				System.out.println(e.getMessage());
			}
        }
        return flag;
	}
	

       

}
