package eu.hulboj.Ayurveda.controllers;

import com.azure.security.keyvault.secrets.SecretClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyVaultController {

    private final SecretClient secretClient;

    public  KeyVaultController(SecretClient secretClient) {
        this.secretClient = secretClient;
    }

    @Value("${ayurveda.azure.keyvault.email.password}")
    private String secretName;

    @GetMapping("/secret")
    public String getSecretValue() {
        return secretClient.getSecret(secretName).getValue();
    }
}
