package com.fross72.ecommerce.email;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {
    private final EmailRepository emailRepository;

    @Autowired
    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public List<Email> getEmails(){ return emailRepository.findAll();}

    public void addNewEmail(Email email) {
        Optional<Email> emailOptional = emailRepository.findIdByEmail(email.getEmail());
        if (emailOptional.isPresent()){
            throw new IllegalStateException("email already taken");
        }
        emailRepository.save(email);
    }

    public void deleteEmail(long emailID) {
        boolean exists = emailRepository.existsById(emailID);
        if (!exists){
            throw new IllegalStateException("Email does not exist");
        }
        emailRepository.deleteById(emailID);
    }
    @Transactional
    public void updateEmail(Email email) {
        boolean exists = emailRepository.existsById(email.getId());
        if (!exists){
            throw new IllegalStateException("No record with such id");
        }
        if (emailRepository.findIdByEmail(email.getEmail()).isPresent()){
            throw new IllegalStateException("This email is already taken");
        }
        emailRepository.findById(email.getId()).get().setEmail(email.getEmail());
    }
}
