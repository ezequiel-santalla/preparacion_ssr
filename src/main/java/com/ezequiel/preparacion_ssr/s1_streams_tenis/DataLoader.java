package com.ezequiel.preparacion_ssr.s1_streams_tenis;

import com.ezequiel.preparacion_ssr.s1_streams_tenis.enums.Country;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.model.Player;
import com.ezequiel.preparacion_ssr.s1_streams_tenis.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final PlayerRepository playerRepository;

    @Override
    public void run(String... args) {
        playerRepository.saveAll(List.of(
                Player.builder().name("Novak Djokovic").country(Country.SERBIA).atpPoints(9860L).birthDate(LocalDate.of(1987, 5, 22)).isActive(true).build(),
                Player.builder().name("Carlos Alcaraz").country(Country.SPAIN).atpPoints(8855L).birthDate(LocalDate.of(2003, 5, 5)).isActive(true).build(),
                Player.builder().name("Jannik Sinner").country(Country.ITALY).atpPoints(8270L).birthDate(LocalDate.of(2001, 8, 16)).isActive(true).build(),
                Player.builder().name("Daniil Medvedev").country(Country.RUSSIA).atpPoints(6155L).birthDate(LocalDate.of(1996, 2, 11)).isActive(true).build(),
                Player.builder().name("Alexander Zverev").country(Country.GERMANY).atpPoints(5765L).birthDate(LocalDate.of(1997, 4, 20)).isActive(true).build(),
                Player.builder().name("Andrey Rublev").country(Country.RUSSIA).atpPoints(4805L).birthDate(LocalDate.of(1997, 10, 20)).isActive(true).build(),
                Player.builder().name("Holger Rune").country(Country.DENMARK).atpPoints(3760L).birthDate(LocalDate.of(2003, 4, 29)).isActive(true).build(),
                Player.builder().name("Stefanos Tsitsipas").country(Country.GREECE).atpPoints(3570L).birthDate(LocalDate.of(1998, 8, 12)).isActive(false).build(),
                Player.builder().name("Rafael Nadal").country(Country.SPAIN).atpPoints(100L).birthDate(LocalDate.of(1986, 6, 3)).isActive(false).build(),
                Player.builder().name("Roger Federer").country(Country.SWITZERLAND).atpPoints(0L).birthDate(LocalDate.of(1981, 8, 8)).isActive(false).build()
        ));
    }
}
