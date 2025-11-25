package br.com.sandes.application.ports.inbound;

import br.com.sandes.addapters.inbound.controllers.DTOs.CreateUserDTO;
import br.com.sandes.addapters.inbound.controllers.DTOs.CreatedUserResponse;
import br.com.sandes.domain.models.User;

import java.util.List;

public interface UserUseCases {
    List<User> findAllUsers();
    User findUserById(Long id);
    CreatedUserResponse create(CreateUserDTO userDTO);
}
