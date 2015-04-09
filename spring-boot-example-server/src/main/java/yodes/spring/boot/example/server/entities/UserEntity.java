package yodes.spring.boot.example.server.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The entity that contains the database mappings
 */
@Entity
public class UserEntity {

	/**
	 * Unique user ID
	 */
	@Id
	private String id;

	/**
	 * Name of your user
	 */
	private String name;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
