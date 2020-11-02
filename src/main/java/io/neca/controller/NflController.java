package io.neca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.neca.domain.Player;
import io.neca.dto.ServiceResponse;
import io.neca.service.NflService;

@RestController
public class NflController {

	@Autowired
	NflService service;

	@GetMapping("/players")
	public ResponseEntity<Object> getAll() {
		List<Player> players = service.getPlayers();
		ServiceResponse<List<Player>> response = new ServiceResponse<>("success", players);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@GetMapping("/player/{id}")
	public ResponseEntity<Object> getOne(@PathVariable int id) {
		Player player = service.getPlayerById(id).orElse(new Player());	// ADD SMTH TO FIX THIS
		ServiceResponse<Player> response = new ServiceResponse<Player>("success", player);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@PostMapping("/player")
	public ResponseEntity<Object> addPlayer(@RequestBody Player player) {
		service.addPlayer(player);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}

	@PutMapping("/player/{id}")
	public ResponseEntity<Object> updatePlayer(@RequestBody Player player, @PathVariable int id) {
		service.updatePlayer(player, id);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@DeleteMapping("/player/{id}")
	public ResponseEntity<Object> removePlayer(@PathVariable int id) {
		service.deletePlayer(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
