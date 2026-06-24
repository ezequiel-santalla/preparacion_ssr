package com.ezequiel.preparacion_ssr.s1_streams_tenis.exception.dto;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path
) {}
