package io.neca.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data // @Getter , @Setter , @ToString , @EqualsAndHashCode and @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Player {

	@Id
	private int number;
	@NotBlank(message = "first name is mandatory")
	private String firstName;
	@NotBlank(message = "last name is mandatory")
	private String lastName;
	@NotBlank(message = "team name is mandatory")
	private String team;

}
