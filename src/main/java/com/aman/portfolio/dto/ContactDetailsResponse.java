
package com.aman.portfolio.dto;

import java.time.LocalDateTime;

public record ContactDetailsResponse(
        Long id,
        String fullName,
        String email,
        String subject,
        String message,
        String phone,
        LocalDateTime createdAt,
        boolean read
) {
}
