package com.ezequiel.preparacion_ssr.s1_streams_tenis.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerResponseDto {

    private String name;
    private String country;
    private Long atpPoints;
    private Integer age;
    private Boolean isActive;
}
