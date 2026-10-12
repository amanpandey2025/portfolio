
package com.aman.portfolio.repository;

import com.aman.portfolio.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findAllByOrderByReadAscCreatedAtDesc();

    // Count unread messages.
    long countByReadFalse();
}
