package br.com.sandes.addapters.outbound.jpa.mappers;

import br.com.sandes.addapters.inbound.controllers.DTOs.CreateUserDTO;
import br.com.sandes.addapters.outbound.jpa.entities.JpaUserEntity;
import br.com.sandes.domain.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static JpaUserEntity domainToEntity(User user) {
        return new JpaUserEntity(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }

    public static User entityToDomain(JpaUserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getCreatedAt()
        );
    }

    public static List<User> entityListToDomain(List<JpaUserEntity> entityList) {
        List<User> domainList = new ArrayList<>();

        for(JpaUserEntity entity : entityList) {
            var domainUser = entityToDomain(entity);

            domainList.add(domainUser);
        }

        return domainList;
    }

    public static List<JpaUserEntity> domainListToEntity(List<User> domainList) {
        List<JpaUserEntity> entityList = new ArrayList<>();

        for(User domain : domainList) {
            var entityUser = domainToEntity(domain);

            entityList.add(entityUser);
        }

        return entityList;
    }

    public static User dtoToDomain(CreateUserDTO dto) {
        return new User(
                dto.name(),
                dto.email()
        );
    }
}
