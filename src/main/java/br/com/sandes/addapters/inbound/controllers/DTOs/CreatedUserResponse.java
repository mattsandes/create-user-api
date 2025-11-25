package br.com.sandes.addapters.inbound.controllers.DTOs;

import java.time.LocalDateTime;

public record CreatedUserResponse(
        String username,
        String email,
        LocalDateTime createdAt
) {
}
