package com.ezequiel.preparacion_ssr.s1_streams_tenis.controller;

import com.ezequiel.preparacion_ssr.s1_streams_tenis.dto.response.PlayerExtremesResponseDto;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.dto.response.PlayerResponseDto;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.enums.Country;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;

public interface PlayerController {

    List<PlayerResponseDto> getActivePlayers();
    List<PlayerResponseDto> getPlayersByCountry(Country country);
    List<PlayerResponseDto> getTopN(int n);
    Double getAveragePoints();
    ResponseEntity<PlayerResponseDto> getPlayerByName(String name);
    Map<Country, List<PlayerResponseDto>> getPlayersGroupedByCountry();
    ResponseEntity<PlayerResponseDto> getYoungestActivePlayer();
    Map<Country, Long> getTotalPointsByCountry();
    boolean allActivePlayersHaveMoreThan1000Points();
    boolean noActivePlayerHasZeroPoints();
    ResponseEntity<PlayerResponseDto> getPlayerWithMostPoints();
    List<String> getActivePlayerNamesSorted();
    Map<Country, Long> getPlayerCountByCountry();
    ResponseEntity<PlayerResponseDto> getOldestActivePlayer();
    List<Country> getCountriesWithMoreThanOneActivePlayer();
    List<PlayerResponseDto> getActivePlayersAbovePointsLimit(Long minPoints, int limit);
    String getActivePlayerNamesAsString();
    LongSummaryStatistics getActivePlayersPointsStatistics();
    Map<Boolean, List<PlayerResponseDto>> partitionByPointsThreshold(Long threshold);
    Long getTotalPointsWithReduce();
    List<Country> getDistinctCountries();
    List<String> getRanking(int n);
    PlayerExtremesResponseDto getTopAndBottomScorer();
    List<String> getAllDistinctTitlesSorted();
}
