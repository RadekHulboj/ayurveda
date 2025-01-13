package eu.hulboj.Ayurveda.configuration;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecretClientConfiguration {

    @Bean
    public SecretClient createSecretClient(@Value("${azure.keyvault.uri}")  String uri) {
        return new SecretClientBuilder()
                .vaultUrl(uri)
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();
    }

}