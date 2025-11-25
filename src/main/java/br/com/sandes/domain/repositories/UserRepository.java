package br.com.sandes.domain.repositories;

import br.com.sandes.domain.models.User;

import java.util.List;

public interface UserRepository {
    User create(User user);
    List<User> findAllUsers();
    User findUserById(Long id);
}
