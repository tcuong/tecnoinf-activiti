/**
 * 
 */
package edu.bedelias.entities.generics;

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
	private String uuid;
	
	@Column(nullable = false)
	private String name;

	public GenericEntityName() {
		super();
		this.uuid = UUID.randomUUID().toString();
	}
	
	// Getters && Setters
	
	public String getCode() {
		return uuid;
	}

	public void setCode(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
