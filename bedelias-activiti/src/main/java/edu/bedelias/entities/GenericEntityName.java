/**
 * 
 */
package edu.bedelias.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Administrador
 *
 */
@MappedSuperclass
public class GenericEntityName extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(unique = true, nullable=false)
	private UUID code;
	
	@Column(nullable = false)
	private String name;

	public GenericEntityName() {
		super();
	}
	
	// Getters && Setters
	
	public UUID getCode() {
		return code;
	}

	public void setCode(UUID code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
