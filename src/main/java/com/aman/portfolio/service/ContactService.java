package com.aman.portfolio.service;

import com.aman.portfolio.dto.ContactDetailsResponse;
import com.aman.portfolio.dto.ContactRequest;
import com.aman.portfolio.entity.Contact;
import com.aman.portfolio.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact saveContact(ContactRequest request) {

        Contact contact = new Contact();

        contact.setFullName(request.getFullName().trim());
        contact.setEmail(request.getEmail().trim());
        contact.setSubject(request.getSubject().trim());
        contact.setMessage(request.getMessage().trim());

        if (request.getPhone() != null
                && !request.getPhone().isBlank()) {
            contact.setPhone(request.getPhone().trim());
        }

        return contactRepository.save(contact);
    }

    public List<ContactDetailsResponse> getAllContacts() {

        return contactRepository
                .findAllByOrderByReadAscCreatedAtDesc()
                .stream()
                .map(this::toContactDetailsResponse)
                .collect(Collectors.toList());
    }

    public boolean markAsRead(Long id) {

        Optional<Contact> optionalContact =
                contactRepository.findById(id);

        if (optionalContact.isEmpty()) {
            return false;
        }

        Contact contact = optionalContact.get();

        if (!contact.isRead()) {
            contact.setRead(true);
            contactRepository.save(contact);
        }

        return true;
    }

    public long getUnreadCount() {
        return contactRepository.countByReadFalse();
    }

    public long getTotalCount() {
        return contactRepository.count();
    }

    public Optional<ContactDetailsResponse> getContactById(Long id) {

        return contactRepository.findById(id)
                .map(this::toContactDetailsResponse);
    }

    private ContactDetailsResponse toContactDetailsResponse(
            Contact contact) {

        return new ContactDetailsResponse(
                contact.getId(),
                contact.getFullName(),
                contact.getEmail(),
                contact.getSubject(),
                contact.getMessage(),
                contact.getPhone(),
                contact.getCreatedAt(),
                contact.isRead()
        );
    }
}