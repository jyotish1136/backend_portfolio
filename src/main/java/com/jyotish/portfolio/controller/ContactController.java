package com.jyotish.portfolio.controller;

import com.jyotish.portfolio.entities.Contact;
import com.jyotish.portfolio.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private MailService mailService;

    @PostMapping
    public ResponseEntity<?> postContact(@RequestBody Contact contact){
        if (contact!=null){
            String str = contact.getName()+"\n"+contact.getEmail()+"\n"+contact.getMessage();
            mailService.sendMail(str);
            return new ResponseEntity<>(contact, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
