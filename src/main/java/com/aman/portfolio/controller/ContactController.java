
package com.aman.portfolio.controller;

import com.aman.portfolio.dto.ContactRequest;
import com.aman.portfolio.dto.ContactResponse;
import com.aman.portfolio.dto.ContactDetailsResponse;
import com.aman.portfolio.entity.Contact;
import com.aman.portfolio.service.ContactService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // POST: Save a new contact
    @PostMapping
    public ResponseEntity<ContactResponse> createContact(
            @Valid @RequestBody ContactRequest request) {

        Contact savedContact = contactService.saveContact(request);

        ContactResponse response = new ContactResponse(
                savedContact.getId(),
                "Your message has been submitted successfully!",
                savedContact.getCreatedAt()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // GET: Retrieve all contacts
    @GetMapping
    public ResponseEntity<List<ContactDetailsResponse>> getAllContacts() {

        List<ContactDetailsResponse> contacts =
                contactService.getAllContacts();

        return ResponseEntity.ok(contacts);
    }

    // GET: Retrieve one contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<ContactDetailsResponse> getContactById(
            @PathVariable Long id) {

        return contactService.getContactById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
