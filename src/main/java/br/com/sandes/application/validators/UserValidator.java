package br.com.sandes.application.validators;

import br.com.sandes.addapters.inbound.controllers.DTOs.CreateUserDTO;

public class UserValidator {

    public static boolean isValid(CreateUserDTO userDTO) {
        return !userDTO.name().isEmpty() &&
                !userDTO.email().isEmpty();
    }
}
