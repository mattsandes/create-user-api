package br.com.sandes.service;

import br.com.sandes.addapters.inbound.controllers.DTOs.CreateUserDTO;
import br.com.sandes.addapters.inbound.controllers.DTOs.CreatedUserResponse;
import br.com.sandes.application.services.UserService;
import br.com.sandes.domain.models.User;
import br.com.sandes.domain.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;
    private CreateUserDTO userDTO;

    @BeforeEach
    void setUp() {
        user = new User(
            1L,
            "Test User",
            "test.user@gmail.com",
            LocalDateTime.now()
        );

        userDTO = new CreateUserDTO(
                "Test User",
                "test.user@gmail.com"
        );
    }

    @Test
    @DisplayName("Validar que é possivel criar um novo usuario")
    void Create_Should_ReturnANewUser_When_AValidUserIsPassed() {

        when(userRepository.create(any(User.class))).thenReturn(user);

        var createUser = userService.create(userDTO);

        assertNotNull(createUser);
        verify(userRepository, times(1))
                .create(any(User.class));

        assertInstanceOf(CreatedUserResponse.class, createUser);
    }

}
