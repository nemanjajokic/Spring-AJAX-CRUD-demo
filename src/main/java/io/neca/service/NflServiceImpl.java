package io.neca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.neca.dao.NflRepository;
import io.neca.domain.Player;

@Service
public class NflServiceImpl implements NflService {

	@Autowired
	NflRepository repo;

	@Override
	public List<Player> getPlayers() {
		return repo.findAll();
	}

	@Override
	public Optional<Player> getPlayerById(int id) {
		return repo.findById(id);
	}

	@Override
	public void addPlayer(Player player) {
		repo.save(player);
	}

	@Override
	public void updatePlayer(Player player, int id) {
		player.setNumber(id);
		repo.save(player);
	}

	@Override
	public void deletePlayer(int id) {
		repo.deleteById(id);
	}
	
	
	
}
