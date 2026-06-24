package com.ezequiel.preparacion_ssr.s1_streams_tenis.service.impl;

import com.ezequiel.preparacion_ssr.s1_streams_tenis.dto.response.PlayerExtremesResponseDto;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.dto.response.PlayerResponseDto;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.enums.Country;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.exception.ResourceNotFoundException;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.mapper.PlayerMapper;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.model.Player;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.repository.PlayerRepository;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public List<PlayerResponseDto> getActivePlayers() {
        return playerRepository.findAll().stream()
                .filter(Player::getIsActive)
                .map(playerMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<PlayerResponseDto> getPlayersByCountry(Country country) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getCountry().equals(country))
                .map(playerMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<PlayerResponseDto> getTopN(int n) {
        return playerRepository.findAll().stream()
                .sorted(Comparator.comparingLong(Player::getAtpPoints).reversed())
                .limit(n)
                .map(playerMapper::toResponseDTO)
                .toList();
    }

    @Override
    public Double getAveragePoints() {
        return playerRepository.findAll().stream()
                .filter(Player::getIsActive)
                .mapToLong(Player::getAtpPoints)
                .average()
                .orElse(0.0);
    }

    @Override
    public PlayerResponseDto getPlayerByName(String name) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().equalsIgnoreCase(name))
                .findFirst()
                .map(playerMapper::toResponseDTO)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Jugador", name));
    }

    @Override
    public Map<Country, List<PlayerResponseDto>> getPlayersGroupedByCountry() {
        return playerRepository.findAll().stream()
                .collect(Collectors.groupingBy(Player::getCountry, Collectors.mapping(playerMapper::toResponseDTO, Collectors.toList())));
    }

    @Override
    public Optional<PlayerResponseDto> getYoungestActivePlayer() {
        return playerRepository.findAll().stream()
                .filter(Player::getIsActive)
                .max(Comparator.comparing(Player::getBirthDate))
                .map(playerMapper::toResponseDTO);
    }

    @Override
    public Map<Country, Long> getTotalPointsByCountry() {
        return playerRepository.findAll().stream()
                .collect(Collectors.groupingBy(Player::getCountry, Collectors.summingLong(Player::getAtpPoints)));
    }

    @Override
    public boolean allActivePlayersHaveMoreThan1000Points() {
        return playerRepository.findAll().stream()
                .filter(Player::getIsActive)
                .allMatch(player -> player.getAtpPoints() > 1000);
    }

    @Override
    public boolean noActivePlayerHasZeroPoints() {
        return playerRepository.findAll().stream()
                .filter(Player::getIsActive)
                .noneMatch(player -> player.getAtpPoints() == 0);
    }

    @Override
    public Optional<PlayerResponseDto> getPlayerWithMostPoints() {
        return playerRepository.findAll().stream()
                .max(Comparator.comparingLong(Player::getAtpPoints))
                .map(playerMapper::toResponseDTO);
    }

    @Override
    public List<String> getActivePlayerNamesSorted() {
        return playerRepository.findAll().stream()
                .filter(Player::getIsActive)
                .map(player -> player.getName().toUpperCase())
                .sorted()
                .toList();
    }

    @Override
    public Map<Country, Long> getPlayerCountByCountry() {
        return playerRepository.findAll().stream()
                .collect(Collectors.groupingBy(Player::getCountry, Collectors.counting()));
    }

    @Override
    public Optional<PlayerResponseDto> getOldestActivePlayer() {
        return playerRepository.findAll().stream()
                .filter(Player::getIsActive)
                .min(Comparator.comparing(Player::getBirthDate))
                .map(playerMapper::toResponseDTO);
    }

    @Override
    public List<Country> getCountriesWithMoreThanOneActivePlayer() {
        return playerRepository.findAll().stream()
                .filter(Player::getIsActive)
                .collect(Collectors.groupingBy(Player::getCountry, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }

    @Override
    public List<PlayerResponseDto> getActivePlayersAbovePointsLimit(Long minPoints, int limit) {
        return playerRepository.findAll().stream()
                .filter(Player::getIsActive)
                .filter(player -> player.getAtpPoints() > minPoints)
                .sorted(Comparator.comparing(Player::getAtpPoints).reversed())
                .limit(limit)
                .map(playerMapper::toResponseDTO)
                .toList();
    }

    @Override
    public String getActivePlayerNamesAsString() {
        return playerRepository.findAll().stream()
                .filter(Player::getIsActive)
                .map(Player::getName)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    @Override
    public LongSummaryStatistics getActivePlayersPointsStatistics() {
        return playerRepository.findAll().stream()
                .filter(Player::getIsActive)
                .collect(Collectors.summarizingLong(Player::getAtpPoints));
    }

    @Override
    public Map<Boolean, List<PlayerResponseDto>> partitionByPointsThreshold(Long threshold) {
        return playerRepository.findAll().stream()
                .map(playerMapper::toResponseDTO)
                .collect(Collectors.partitioningBy(player -> player.getAtpPoints() > threshold));
    }

    @Override
    public Long getTotalPointsWithReduce() {
        return playerRepository.findAll().stream()
                .mapToLong(Player::getAtpPoints)
                .reduce(0L, Long::sum);
    }

    @Override
    public List<Country> getDistinctCountries() {
        return playerRepository.findAll().stream()
                .map(Player::getCountry)
                .distinct()
                .toList();
    }

    @Override
    public List<String> getRanking(int n) {
        List<Player> top = playerRepository.findAll().stream()
                .sorted(Comparator.comparingLong(Player::getAtpPoints).reversed())
                .limit(n)
                .toList();

        return IntStream.range(0, top.size())
                .mapToObj(i -> "%d. %s - %d pts".formatted(i + 1, top.get(i).getName(), top.get(i).getAtpPoints()))
                .toList();
    }

    @Override
    public PlayerExtremesResponseDto getTopAndBottomScorer() {
        return playerRepository.findAll().stream()
                .collect(Collectors.teeing(
                        Collectors.maxBy(Comparator.comparingLong(Player::getAtpPoints)),
                        Collectors.minBy(Comparator.comparingLong(Player::getAtpPoints)),
                        (max, min) -> new PlayerExtremesResponseDto(
                                max.map(playerMapper::toResponseDTO).orElse(null),
                                min.map(playerMapper::toResponseDTO).orElse(null)
                        )));
    }

    @Override
    public List<String> getAllDistinctTitlesSorted() {
        return playerRepository.findAll().stream()
                .map(Player::getTitles)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .toList();
    }
}
