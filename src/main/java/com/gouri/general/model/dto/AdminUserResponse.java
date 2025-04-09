package com.gouri.general.model.dto;

import java.time.LocalDateTime;

public record AdminUserResponse(Long id, String name, String c_no, String email, LocalDateTime created_at, LocalDateTime updated_at) {
    public AdminUserResponse {
        if (id == null || name == null || c_no == null || email == null || created_at == null || updated_at == null) {
            throw new IllegalArgumentException("All fields must be non-null");
        }
    }
}
