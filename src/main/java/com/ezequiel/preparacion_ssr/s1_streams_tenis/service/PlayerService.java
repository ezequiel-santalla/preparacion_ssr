package com.ezequiel.preparacion_ssr.s1_streams_tenis.service;

import com.ezequiel.preparacion_ssr.s1_streams_tenis.dto.response.PlayerResponseDto;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.enums.Country;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PlayerService {

    // 1. Todos los jugadores activos ordenados por puntos ATP de mayor a menor
    List<PlayerResponseDto> getActivePlayers();

    // 2. Jugadores filtrados por país
    List<PlayerResponseDto> getPlayersByCountry(Country country);

    // 3. Top N jugadores por puntos ATP
    List<PlayerResponseDto> getTopN(int n);

    // 4. Promedio de puntos ATP de los jugadores activos
    Double getAveragePoints();

    // 5. Buscar jugador por nombre — devuelve Optional
    Optional<PlayerResponseDto> getPlayerByName(String name);

    // 6. Jugadores agrupados por país
    Map<Country, List<PlayerResponseDto>> getPlayersGroupedByCountry();

    // 7. Jugador más joven activo
    Optional<PlayerResponseDto> getYoungestActivePlayer();

    // 8. Puntos totales por país
    Map<Country, Long> getTotalPointsByCountry();

    // 9. Devuelve true si todos los jugadores activos tienen más de 1000 puntos
    boolean allActivePlayersHaveMoreThan1000Points();

    // 10. Devuelve true si ningún jugador activo tiene 0 puntos
    boolean noActivePlayerHasZeroPoints();

    // 11. Devuelve el jugador con más puntos ATP (activo o no)
    Optional<PlayerResponseDto> getPlayerWithMostPoints();

    // 12. Devuelve los nombres de todos los jugadores activos en mayúsculas, ordenados
    List<String> getActivePlayerNamesSorted();

    // 13. Devuelve la cantidad de jugadores por país
    Map<Country, Long> getPlayerCountByCountry();

    // 14. Devuelve el jugador más viejo activo
    Optional<PlayerResponseDto> getOldestActivePlayer();

    // 15. Devuelve los países que tienen más de un jugador activo
    List<Country> getCountriesWithMoreThanOneActivePlayer();

    // 16. Dado un mínimo de puntos, devuelve los jugadores activos que lo superan ordenados por puntos y limitados a N resultados
    List<PlayerResponseDto> getActivePlayersAbovePointsLimit(Long minPoints, int limit);
}
