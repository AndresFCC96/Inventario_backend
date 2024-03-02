package com.gestion.inventario.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilsTest {

    private SecretKey Key;

    @InjectMocks
    private JwtUtils jwtUtils;

    @Mock
    private UserDetails userDetails;

    @Disabled
    @Test
    @DisplayName("Must generate token")
    void debeGenerarElToken() {
        String token = jwtUtils.generateToken(userDetails);
        Assertions.assertThat(token.length()).isGreaterThan(20);
        Assertions.assertThat(token).isNotEmpty();
    }
}