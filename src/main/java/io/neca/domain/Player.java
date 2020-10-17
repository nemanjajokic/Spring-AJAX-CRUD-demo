package io.neca.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Player {

	@Id
	private int number;
	private String firstName;
	private String lastName;
	private String team;

	public Player() {
		super();
	}

}
