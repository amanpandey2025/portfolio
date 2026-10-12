package com.aman.portfolio.controller;

import com.aman.portfolio.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminMessagesController {

    private final ContactService contactService;

    public AdminMessagesController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "admin-login";
    }

    @GetMapping("/messages")
    public String messagesPage(Model model) {

        model.addAttribute(
                "contacts",
                contactService.getAllContacts()
        );

        model.addAttribute(
                "totalCount",
                contactService.getTotalCount()
        );

        model.addAttribute(
                "unreadCount",
                contactService.getUnreadCount()
        );

        return "admin-messages";
    }

    @PostMapping("/messages/{id}/read")
    public String markAsRead(@PathVariable Long id) {

        boolean updated = contactService.markAsRead(id);

        if (!updated) {
            return "redirect:/admin/messages?notFound";
        }

        return "redirect:/admin/messages?updated";
    }
}