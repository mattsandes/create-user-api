package br.com.sandes.application.services;

import br.com.sandes.addapters.inbound.controllers.DTOs.CreateUserDTO;
import br.com.sandes.addapters.inbound.controllers.DTOs.CreatedUserResponse;
import br.com.sandes.addapters.outbound.jpa.mappers.UserMapper;
import br.com.sandes.application.ports.inbound.UserUseCases;
import br.com.sandes.application.validators.UserValidator;
import br.com.sandes.domain.models.User;
import br.com.sandes.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class UserService implements UserUseCases {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public User findUserById(Long id) {
        User foundUser = userRepository.findUserById(id);

        if(foundUser == null) {
            throw new RuntimeException("Usuario não encontrado");
        }

        return foundUser;
    }

    @Override
    public CreatedUserResponse create(CreateUserDTO userDTO) {
        var validUser = UserValidator.isValid(userDTO);

        if(!validUser) {
            throw new RuntimeException("Usuario tem propriedades invalidas");
        }

        var mappedUser = UserMapper.dtoToDomain(userDTO);

        mappedUser.setCreatedAt(LocalDateTime.now());

        var createdUser = userRepository.create(mappedUser);

        return new CreatedUserResponse(
                createdUser.getName(),
                createdUser.getEmail(),
                createdUser.getCreatedAt()
        );
    }
}
