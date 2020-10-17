package io.neca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.neca.domain.Player;
import io.neca.service.NflService;

@RestController
public class NflController {

	@Autowired
	NflService service;

	@GetMapping("/players")
	public List<Player> getAll() {
		return service.getPlayers();
	}

	@GetMapping("/player/{id}")
	public Optional<Player> getOne(@PathVariable int id) {
		return service.getPlayerById(id);
	}

	@PostMapping("/player")
	public void addPlayer(@RequestBody Player player) {
		service.addPlayer(player);
	}

	@PutMapping("/player/{id}")
	public void updatePlayer(@RequestBody Player player, @PathVariable int id) {
		service.updatePlayer(player, id);
	}

	@DeleteMapping("/player/{id}")
	public void removePlayer(@PathVariable int id) {
		service.deletePlayer(id);
	}

}
