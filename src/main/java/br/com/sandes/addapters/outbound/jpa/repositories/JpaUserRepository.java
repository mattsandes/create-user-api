package br.com.sandes.addapters.outbound.jpa.repositories;

import br.com.sandes.addapters.outbound.jpa.entities.JpaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<JpaUserEntity, Long> { }
