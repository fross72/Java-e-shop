package com.fross72.ecommerce.email;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/emails")
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public List<Email> getEmails(){ return emailService.getEmails();}

    @PostMapping
    public void registerNewEmail(@RequestBody Email email){ emailService.addNewEmail(email); }

    @DeleteMapping(path = "{emailId}")
    public void deleteEmail(@PathVariable("emailId") long emailID){
        if (emailID<1){
            throw new IllegalStateException("Illegal id");
        }
        emailService.deleteEmail(emailID);
    }

    @PatchMapping
    public void updateEmail(@RequestBody Email email){
        emailService.updateEmail(email);
    }
}
