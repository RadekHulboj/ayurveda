package eu.hulboj.Ayurveda.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyVaultController {

    @Value("${ayurveda-email}")
    private String secretValue;

    @GetMapping("/secret")
    public String getSecretValue() {
        return secretValue;
    }
}
