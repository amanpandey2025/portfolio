
package com.aman.portfolio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    @Size(max = 150)
    @Column(nullable = false, length = 150)
    private String email;

    @NotBlank(message = "Subject is required")
    @Size(max = 150)
    @Column(nullable = false, length = 150)
    private String subject;

    @NotBlank(message = "Message is required")
    @Size(max = 3000)
    @Column(nullable = false, length = 3000)
    private String message;

    @Size(max = 20)
    @Column(length = 20)
    private String phone;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(
            name = "is_read",
            nullable = false,
            columnDefinition = "BOOLEAN DEFAULT FALSE"
    )
    private boolean read = false;

    public Contact() {
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
