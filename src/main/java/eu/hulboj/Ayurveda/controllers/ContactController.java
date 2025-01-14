package eu.hulboj.Ayurveda.controllers;

import eu.hulboj.Ayurveda.dto.ContactRequest;
import eu.hulboj.Ayurveda.services.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public Mono<ResponseEntity<String>> handleContactForm(@RequestBody ContactRequest requestMono) {
        return Mono.just(requestMono)
                .doOnNext(r -> {
                    logger.info("Received contact request from: {} {}", r.getFirstName(), r.getLastName());
                    logger.info("Email: {}", r.getEmail());
                    logger.info("Message: {}", r.getMessage());
                    emailService.sendSimpleMessage(requestMono.getEmail(),
                            "Ayurveda web portal:" + requestMono.getFirstName() + "-" +requestMono.getLastName(),
                            requestMono.getMessage());
                })
                .map(r -> ResponseEntity.ok().body("{\"message\": \"Contact request received successfully.\"}"));
    }
}