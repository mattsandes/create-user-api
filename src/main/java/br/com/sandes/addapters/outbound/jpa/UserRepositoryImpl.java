package br.com.sandes.addapters.outbound.jpa;

import br.com.sandes.addapters.outbound.jpa.entities.JpaUserEntity;
import br.com.sandes.addapters.outbound.jpa.mappers.UserMapper;
import br.com.sandes.addapters.outbound.jpa.repositories.JpaUserRepository;
import br.com.sandes.domain.models.User;
import br.com.sandes.domain.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository userRepository;

    public UserRepositoryImpl(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        JpaUserEntity entity = UserMapper.domainToEntity(user);

        var createdUser = userRepository.save(entity);

        return UserMapper.entityToDomain(createdUser);
    }

    @Override
    public List<User> findAllUsers() {
        List<JpaUserEntity> entityList = userRepository.findAll();

        return UserMapper.entityListToDomain(entityList);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository
                .findById(id)
                .map(UserMapper::entityToDomain)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
