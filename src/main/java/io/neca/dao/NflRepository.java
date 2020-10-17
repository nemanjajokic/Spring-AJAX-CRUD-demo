package io.neca.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import io.neca.domain.Player;

public interface NflRepository extends JpaRepository<Player, Integer> {

}
