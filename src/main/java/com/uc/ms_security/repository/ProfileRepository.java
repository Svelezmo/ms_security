package com.uc.ms_security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uc.ms_security.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    boolean existsByPhone(String phone);// existe un profile con ese phone? (para validar que no se pueda crear un profile con un phone que ya tiene otro profile)

    boolean existsByPhoneAndIdNot(String phone, Long id);// existe un profile con ese phone y que no sea el mismo profile que estoy editando? (para validar que no se pueda editar un profile y ponerle un phone que ya tiene otro profile)

    Optional<Profile> findByUserId(Long userId);// find es lo mismo que decir select * from profiles where user_id = ? (el ? es el parametro que le pasamos)

    boolean existsByUserId(Long userId);// existe un profile con ese userId? (para validar que no se pueda crear un profile para un user que ya tiene profile)
}
