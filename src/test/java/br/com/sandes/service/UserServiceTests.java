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
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user1;
    private User user2;
    private CreateUserDTO userDTO;

    @BeforeEach
    void setUp() {
        user1 = new User(
            1L,
            "Test User 1",
            "test.user1@gmail.com",
            LocalDateTime.now()
        );

        user2 = new User(
                2L,
                "Test User 2",
                "test.user2@gmail.com",
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

        when(userRepository.create(any(User.class))).thenReturn(user1);

        var createUser = userService.create(userDTO);

        assertNotNull(createUser);
        verify(userRepository, times(1))
                .create(any(User.class));

        assertInstanceOf(CreatedUserResponse.class, createUser);
    }

    @Test
    @DisplayName("Validar que e possivel recuperar usuários")
    void FindAll_Should_ReturnAUserList() {
        List<User> userList = new ArrayList<>();

        userList.add(user1);
        userList.add(user2);

        when(userRepository.findAllUsers()).thenReturn(userList);

        var users = userService.findAllUsers();

        assertNotNull(users);
        assertEquals(2, users.size());
    }

    @Test
    @DisplayName("Validar que e possivel recuperar um unico usuario pelo id")
    void FindById_Should_ReturnASingleUser() {

        when(userRepository.findUserById(user1.getId())).thenReturn(user1);

        var foundUser = userService.findUserById(1L);

        assertNotNull(foundUser);
    }

}
