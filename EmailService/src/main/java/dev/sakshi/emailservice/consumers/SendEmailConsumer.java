package dev.sakshi.emailservice.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.sakshi.emailservice.dtos.SendEmailMessageDto;
import dev.sakshi.emailservice.utilities.EmailUtil;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Service
public class SendEmailConsumer {
    private ObjectMapper objectMapper;
    private EmailUtil emailUtil;

    public SendEmailConsumer(ObjectMapper objectMapper,
                             EmailUtil emailUtil) {
        this.objectMapper = objectMapper;
        this.emailUtil = emailUtil;
    }

    //subscribe to event sendEmail of userservice
    //using group id, kafka will know that all consumers are instances of same Consumer group(emailservice)
    //so if there are many servers who are of group id emailservice, only one of them will receive send email event
    @KafkaListener(topics = "sendEmail", groupId = "emailService")
    public void handleSendEmail(String message) throws JsonProcessingException {
        SendEmailMessageDto emailMessage = objectMapper.readValue(message, SendEmailMessageDto.class); //convert msg to obj

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        //mail from where msg will get send to users
        //in password we have to give app password which we can get in "sender Google account setting"
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sakshijinnewar@gmail.com", "");
            }
        };
        Session session = Session.getInstance(props, auth);

        emailUtil.sendEmail(
                session,
                emailMessage.getTo(),
                emailMessage.getSubject(),
                emailMessage.getBody()
        );
    }
}
