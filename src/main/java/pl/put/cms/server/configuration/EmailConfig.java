package pl.put.cms.server.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {

    @Bean("emailsender")
    public JavaMailSender getJavaMailSender(@Value("${spring.mail.host}") String host,
                                            @Value("${spring.mail.port}") int port) {
        System.out.printf("%s, %d", host, port);
        final JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setPort(port);
        return javaMailSender;
    }

}
