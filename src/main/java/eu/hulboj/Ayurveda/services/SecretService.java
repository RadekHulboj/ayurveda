package eu.hulboj.Ayurveda.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Deprecated
@Service
public class SecretService {

    private String secretHolder;

    private final RestTemplate restTemplate;

    public SecretService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void fetchAndStoreSecret() {
        String url = "http://localhost:8080/secret";
        secretHolder = restTemplate.getForObject(url, String.class);
    }

    public String getSecretHolder() {
        return secretHolder;
    }
}