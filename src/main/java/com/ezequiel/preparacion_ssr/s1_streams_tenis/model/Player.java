package com.ezequiel.preparacion_ssr.s1_streams_tenis.model;

import com.ezequiel.preparacion_ssr.s1_streams_tenis.enums.Country;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Country country;

    private Long atpPoints;

    private LocalDate birthDate;

    private Boolean isActive;

    @ElementCollection
    @CollectionTable(name = "player_titles", joinColumns = @JoinColumn(name = "player_id"))
    @Column(name = "title")
    private List<String> titles;
}
