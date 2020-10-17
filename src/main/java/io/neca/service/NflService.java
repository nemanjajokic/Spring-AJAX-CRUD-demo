package io.neca.service;

import java.util.List;
import java.util.Optional;

import io.neca.domain.Player;

public interface NflService {

	List<Player> getPlayers();
	Optional<Player> getPlayerById(int id);
	void addPlayer(Player player);
	void updatePlayer(Player player, int id);
	void deletePlayer(int id);
	
}
