package com.ezequiel.preparacion_ssr.s1_streams_tenis;

import com.ezequiel.preparacion_ssr.s1_streams_tenis.enums.Country;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.model.Player;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final PlayerRepository playerRepository;

    @Override
    public void run(String... args) {
        if (playerRepository.count() > 0) {
            return;
        }

        playerRepository.saveAll(List.of(
                player("Novak Djokovic", Country.SERBIA, 9860L, LocalDate.of(1987, 5, 22), true,
                        "Australian Open", "Wimbledon", "Roland Garros", "US Open"),
                player("Carlos Alcaraz", Country.SPAIN, 8855L, LocalDate.of(2003, 5, 5), true,
                        "US Open", "Wimbledon", "Roland Garros"),
                player("Jannik Sinner", Country.ITALY, 8270L, LocalDate.of(2001, 8, 16), true,
                        "Australian Open", "US Open"),
                player("Daniil Medvedev", Country.RUSSIA, 6155L, LocalDate.of(1996, 2, 11), true,
                        "US Open"),
                // Sin títulos de Grand Slam: lista vacía a propósito (buen caso borde para flatMap).
                player("Alexander Zverev", Country.GERMANY, 5765L, LocalDate.of(1997, 4, 20), true),
                player("Andrey Rublev", Country.RUSSIA, 4805L, LocalDate.of(1997, 10, 20), true),
                player("Holger Rune", Country.DENMARK, 3760L, LocalDate.of(2003, 4, 29), true),
                player("Stefanos Tsitsipas", Country.GREECE, 3570L, LocalDate.of(1998, 8, 12), false),
                player("Rafael Nadal", Country.SPAIN, 100L, LocalDate.of(1986, 6, 3), false,
                        "Roland Garros", "US Open", "Wimbledon", "Australian Open"),
                player("Roger Federer", Country.SWITZERLAND, 0L, LocalDate.of(1981, 8, 8), false,
                        "Wimbledon", "Australian Open", "US Open", "Roland Garros")
        ));

        log.info("DataLoader: {} jugadores cargados.", playerRepository.count());
    }

    private Player player(String name, Country country, Long atpPoints,
                          LocalDate birthDate, boolean isActive, String... titles) {
        return Player.builder()
                .name(name)
                .country(country)
                .atpPoints(atpPoints)
                .birthDate(birthDate)
                .isActive(isActive)
                .titles(List.of(titles))
                .build();
    }
}
