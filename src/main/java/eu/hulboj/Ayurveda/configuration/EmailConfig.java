package eu.hulboj.Ayurveda.configuration;

import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Optional;
import java.util.Properties;
import java.util.function.Predicate;

@Configuration
public class EmailConfig {
    private static final String KEY_VAULT_NAME = "GoogleAppPassword";

    @Value("${ayurveda.azure.keyvault.email.password}")
    private String secretName;

    @Bean
    public JavaMailSender getJavaMailSender(SecretClient secretClient, @Value("${ayurveda.azure.email.password}") String emailSecret) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("radekhulboj@gmail.com");
        mailSender.setPassword(getMailPassword(emailSecret, secretClient));
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    private String getMailPassword(String emailSecret, SecretClient secretClient) {
        return Optional.ofNullable(emailSecret)
                .filter(isNotEmpty())
                .orElseGet(() -> getFromKeyVault(secretClient));
    }

    private String getFromKeyVault(SecretClient secretClient) {
        KeyVaultSecret retrievedSecret = secretClient.getSecret(secretName);
        return retrievedSecret.getValue();
    }

    private Predicate<String> isNotEmpty() {
        return s -> !s.isEmpty();
    }
}

