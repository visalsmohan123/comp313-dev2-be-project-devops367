package com.comp313.bloodlink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.comp313.bloodlink.model.ContactModel;
import com.comp313.bloodlink.repository.ContactRepository;


@RestController
@RequestMapping("contact")
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;
	
	@PostMapping
    public ContactModel createContactForm(@RequestBody ContactModel contactForm) {
        return contactRepository.save(contactForm);
    }
   
	@GetMapping("/{id}")
    public ContactModel getContactFormById(@PathVariable Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ContactForm not found with id " + id));
    }

    @GetMapping
    public List<ContactModel> getAllContactForms() {
        return contactRepository.findAll();
    }
}
