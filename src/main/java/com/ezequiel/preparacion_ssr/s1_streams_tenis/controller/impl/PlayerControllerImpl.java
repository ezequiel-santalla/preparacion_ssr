package com.ezequiel.preparacion_ssr.s1_streams_tenis.controller.impl;

import com.ezequiel.preparacion_ssr.s1_streams_tenis.controller.PlayerController;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.dto.response.PlayerExtremesResponseDto;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.dto.response.PlayerResponseDto;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.enums.Country;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;

@RestController
@RequestMapping("/api/s1/players")
@RequiredArgsConstructor
public class PlayerControllerImpl implements PlayerController {

    private final PlayerService playerService;

    @Override
    @GetMapping
    public List<PlayerResponseDto> getActivePlayers() {
        return playerService.getActivePlayers();
    }

    @Override
    @GetMapping("/country/{country}")
    public List<PlayerResponseDto> getPlayersByCountry(@PathVariable Country country) {
        return playerService.getPlayersByCountry(country);
    }

    @Override
    @GetMapping("/top/{n}")
    public List<PlayerResponseDto> getTopN(@PathVariable int n) {
        return playerService.getTopN(n);
    }

    @Override
    @GetMapping("/average")
    public Double getAveragePoints() {
        return playerService.getAveragePoints();
    }

    @Override
    @GetMapping("/by-name/{name}")
    public ResponseEntity<PlayerResponseDto> getPlayerByName(@PathVariable String name) {
        return ResponseEntity.ok(playerService.getPlayerByName(name));
    }

    @Override
    @GetMapping("/grouped")
    public Map<Country, List<PlayerResponseDto>> getPlayersGroupedByCountry() {
        return playerService.getPlayersGroupedByCountry();
    }

    @Override
    @GetMapping("/youngest")
    public ResponseEntity<PlayerResponseDto> getYoungestActivePlayer() {
        return playerService.getYoungestActivePlayer()
                .map(ResponseEntity::ok)                                  // 200 con body
                .orElseGet(() -> ResponseEntity.noContent().build());     // 204 si vacío
    }

    @Override
    @GetMapping("/points-by-country")
    public Map<Country, Long> getTotalPointsByCountry() {
        return playerService.getTotalPointsByCountry();
    }

    @Override
    @GetMapping("/all-above-1000")
    public boolean allActivePlayersHaveMoreThan1000Points() {
        return playerService.allActivePlayersHaveMoreThan1000Points();
    }

    @Override
    @GetMapping("/none-zero-points")
    public boolean noActivePlayerHasZeroPoints() {
        return playerService.noActivePlayerHasZeroPoints();
    }

    @Override
    @GetMapping("/most-points")
    public ResponseEntity<PlayerResponseDto> getPlayerWithMostPoints() {
        return playerService.getPlayerWithMostPoints()
                .map(ResponseEntity::ok)                                  // 200 con body
                .orElseGet(() -> ResponseEntity.noContent().build());     // 204 si vacío
    }

    @Override
    @GetMapping("/names-sorted")
    public List<String> getActivePlayerNamesSorted() {
        return playerService.getActivePlayerNamesSorted();
    }

    @Override
    @GetMapping("/count-by-country")
    public Map<Country, Long> getPlayerCountByCountry() {
        return playerService.getPlayerCountByCountry();
    }

    @Override
    @GetMapping("/oldest")
    public ResponseEntity<PlayerResponseDto> getOldestActivePlayer() {
        return playerService.getOldestActivePlayer()
                .map(ResponseEntity::ok)                                  // 200 con body
                .orElseGet(() -> ResponseEntity.noContent().build());     // 204 si vacío
    }

    @Override
    @GetMapping("/countries-multiple-active")
    public List<Country> getCountriesWithMoreThanOneActivePlayer() {
        return playerService.getCountriesWithMoreThanOneActivePlayer();
    }

    @Override
    @GetMapping("/above-points")
    public List<PlayerResponseDto> getActivePlayersAbovePointsLimit(
            @RequestParam Long minPoints,
            @RequestParam int limit) {
        return playerService.getActivePlayersAbovePointsLimit(minPoints, limit);
    }

    @Override
    @GetMapping("/names-joined")
    public String getActivePlayerNamesAsString() {
        return playerService.getActivePlayerNamesAsString();
    }

    @Override
    @GetMapping("/points-stats")
    public LongSummaryStatistics getActivePlayersPointsStatistics() {
        return playerService.getActivePlayersPointsStatistics();
    }

    @Override
    @GetMapping("/partition-by-points")
    public Map<Boolean, List<PlayerResponseDto>> partitionByPointsThreshold(
            @RequestParam Long threshold) {
        return playerService.partitionByPointsThreshold(threshold);
    }

    @Override
    @GetMapping("/total-points")
    public Long getTotalPointsWithReduce() {
        return playerService.getTotalPointsWithReduce();
    }

    @Override
    @GetMapping("/countries")
    public List<Country> getDistinctCountries() {
        return playerService.getDistinctCountries();
    }

    @Override
    @GetMapping("/ranking/{n}")
    public List<String> getRanking(@PathVariable int n) {
        return playerService.getRanking(n);
    }

    @Override
    @GetMapping("/extremes")
    public PlayerExtremesResponseDto getTopAndBottomScorer() {
        return playerService.getTopAndBottomScorer();
    }

    @Override
    @GetMapping("/titles")
    public List<String> getAllDistinctTitlesSorted() {
        return playerService.getAllDistinctTitlesSorted();
    }
}
