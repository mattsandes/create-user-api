package br.com.sandes.addapters.inbound.controllers.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record CreatedUserResponse(
        String username,
        String email,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime createdAt
) {
}
