package com.ezequiel.preparacion_ssr.s1_streams_tenis.service;

import com.ezequiel.preparacion_ssr.s1_streams_tenis.dto.response.PlayerExtremesResponseDto;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.dto.response.PlayerResponseDto;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.enums.Country;

import java.util.List;
import java.util.LongSummaryStatistics;
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

    // 5. Buscar jugador por nombre — lanza ResourceNotFoundException (404) si no existe
    PlayerResponseDto getPlayerByName(String name);

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

    // 17. Devuelve los nombres de los jugadores activos, concatenados en un único String, separados por ", ", con corchetes al principio y al final.
    String getActivePlayerNamesAsString();

    // 18. Estadísticas (count, sum, min, max, average) de los puntos ATP de los jugadores activos, calculadas en una sola pasada con summarizingLong.
    LongSummaryStatistics getActivePlayersPointsStatistics();

    // 19. Particiona TODOS los jugadores en dos grupos según si superan o no un umbral de puntos: clave true = puntos > threshold, clave false = el resto. Usar partitioningBy con downstream para mapear a DTO.
    Map<Boolean, List<PlayerResponseDto>> partitionByPointsThreshold(Long threshold);

    // 20. Suma total de los puntos ATP de TODOS los jugadores, calculada con reduce (no usar sum() ni summarizing).
    Long getTotalPointsWithReduce();

    // 21. Lista de los países (sin repetidos) que tienen al menos un jugador. Usar map + distinct.
    List<Country> getDistinctCountries();

    // 22. Ranking de los top N jugadores por puntos, formateado como "1. Nombre - 9860 pts", "2. ...". Usar IntStream para numerar las posiciones.
    List<String> getRanking(int n);

    // 23. En UNA sola pasada del stream, devuelve el jugador con MÁS puntos y el de MENOS puntos (entre todos), usando Collectors.teeing.
    PlayerExtremesResponseDto getTopAndBottomScorer();

    // 24. Lista de todos los títulos ganados por los jugadores, sin repetir y ordenados alfabéticamente. Cada Player tiene una List<String> titles; hay que aplanar todas esas listas en un solo stream con flatMap.
    List<String> getAllDistinctTitlesSorted();
}
