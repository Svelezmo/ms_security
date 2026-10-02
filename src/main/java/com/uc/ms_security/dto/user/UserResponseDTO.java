package com.uc.ms_security.dto.user;

import lombok.Value;

@Value
public class UserResponseDTO { // cuando devuelvo, devuelvo sin contraseña, por seguridad
    Long id;
    String name;
    String email;
}