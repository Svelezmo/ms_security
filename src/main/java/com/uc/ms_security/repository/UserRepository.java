package com.uc.ms_security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uc.ms_security.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);// existe un user con ese email y que no sea el mismo user que estoy editando? (para validar que no se pueda editar un user y ponerle un email que ya tiene otro user)

    @EntityGraph(attributePaths = {"profile"})// indica que quiero que cuando busque un user, también busque su profile (hace el join con el profile)
    Optional<User> findWithProfileById(
            Long id
    );
}
