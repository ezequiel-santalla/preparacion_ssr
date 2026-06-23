package com.ezequiel.preparacion_ssr.s1_streams_tenis.mapper;

import com.ezequiel.preparacion_ssr.s1_streams_tenis.dto.response.PlayerResponseDto;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(target = "age", expression = "java(java.time.Period.between(player.getBirthDate(), java.time.LocalDate.now()).getYears())")
    PlayerResponseDto toResponseDTO(Player player);

    List<PlayerResponseDto> toResponseDTOList(List<Player> players);
}