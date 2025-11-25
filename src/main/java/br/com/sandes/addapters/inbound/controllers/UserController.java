package br.com.sandes.addapters.inbound.controllers;

import br.com.sandes.addapters.inbound.controllers.DTOs.CreateUserDTO;
import br.com.sandes.addapters.inbound.controllers.DTOs.CreatedUserResponse;
import br.com.sandes.application.ports.inbound.UserUseCases;
import br.com.sandes.domain.models.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User API", description = "Endpoints para gerenciamento de pessoas")
@RestController
@RequestMapping("user")
public class UserController {

    private final UserUseCases userUseCases;

    public UserController(UserUseCases userUseCases) {
        this.userUseCases = userUseCases;
    }

    @GetMapping(
            value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find all users", description = "Lista todos os usuarios cadastrados")
    public List<User> findAllUsers() {
        return userUseCases.findAllUsers();
    }

    @PostMapping(
            value = "/createUser",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create new user", description = "Cria novos usuarios")
    public CreatedUserResponse createUser(@RequestBody CreateUserDTO userDTO) {
        return userUseCases.create(userDTO);
    }
}
