package t3h.springboot.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service("mailler")
public class Mailer {

    @Autowired JavaMailSender mailler;

    public void send(String from, String to, String subject, String body) {
        this.send(from, to,subject,body);
    }

    public void send(String to, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("c1909i2bkap@gmail.com");
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(body);
        mailler.send(msg);
    }

    public void send(String from, String to, String subject, String body, String cc, String bcc,
                     String attachment) throws RuntimeException{
        try {
            MimeMessage mail = mailler.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
//            helper.setCc(cc);
//            helper.setBcc(bcc);
            helper.setText(body, true);
            helper.setReplyTo(from, from);
            mailler.send(mail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
