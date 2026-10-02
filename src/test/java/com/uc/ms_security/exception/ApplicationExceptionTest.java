package com.uc.ms_security.exception;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.uc.ms_security.mapper.UserMapper;
import com.uc.ms_security.repository.UserRepository;
import com.uc.ms_security.service.UserService;

@ExtendWith(MockitoExtension.class)
class ApplicationExceptionTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @Test
    void shouldThrowApplicationExceptionWhenUserIsNotFound() {
        UserService userService = new UserService(userRepository, userMapper);

        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        ApplicationException exception = assertThrows(
                ApplicationException.class,
                () -> userService.findById(99L)
        );

        assertEquals(ErrorCase.NOT_FOUND, exception.getErrorCase());
        assertTrue(exception.getMessage().contains("Usuario no encontrado"));
    }
}
