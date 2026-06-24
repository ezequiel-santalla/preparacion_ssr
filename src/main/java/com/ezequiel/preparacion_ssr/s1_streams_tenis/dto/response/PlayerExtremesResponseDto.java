package com.ezequiel.preparacion_ssr.s1_streams_tenis.dto.response;

public record PlayerExtremesResponseDto(
        PlayerResponseDto topScorer,
        PlayerResponseDto bottomScorer
) {}
