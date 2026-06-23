package com.ezequiel.preparacion_ssr.s1_streams_tenis.repository;

import com.ezequiel.preparacion_ssr.s1_streams_tenis.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
