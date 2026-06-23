package com.ezequiel.preparacion_ssr.s1_streams_tenis.controller;

import com.ezequiel.preparacion_ssr.s1_streams_tenis.dto.response.PlayerResponseDto;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.enums.Country;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PlayerController {

    List<PlayerResponseDto> getActivePlayers();
    List<PlayerResponseDto> getPlayersByCountry(Country country);
    List<PlayerResponseDto> getTopN(int n);
    Double getAveragePoints();
    Optional<PlayerResponseDto> getPlayerByName(String name);
    Map<Country, List<PlayerResponseDto>> getPlayersGroupedByCountry();
    Optional<PlayerResponseDto> getYoungestActivePlayer();
    Map<Country, Long> getTotalPointsByCountry();
    boolean allActivePlayersHaveMoreThan1000Points();
    boolean noActivePlayerHasZeroPoints();
    Optional<PlayerResponseDto> getPlayerWithMostPoints();
    List<String> getActivePlayerNamesSorted();
    Map<Country, Long> getPlayerCountByCountry();
    Optional<PlayerResponseDto> getOldestActivePlayer();
    List<Country> getCountriesWithMoreThanOneActivePlayer();
    List<PlayerResponseDto> getActivePlayersAbovePointsLimit(Long minPoints, int limit);
}
