package yodes.spring.boot.example.server.services;

import java.util.List;

import yodes.spring.boot.example.api.UserDto;

/**
 * A user service that provides access to store and retrieve users
 */
public interface UserService {

	/**
	 * List all users
	 * 
	 * @return a list of all users
	 */
	List<UserDto> list();

	/**
	 * Find a user by ID
	 * 
	 * @param id
	 *            to filter on user
	 * @return user or null if not found
	 */
	UserDto findById(String id);

	/**
	 * Store a user information
	 * 
	 * @param userDto
	 *            to store
	 * @return created user with possibly additional information
	 */
	UserDto create(UserDto userDto);

	/**
	 * Update a users information
	 * 
	 * @param userDto
	 *            to replace
	 * @return updated user
	 */
	UserDto update(UserDto userDto);

	/**
	 * Delete a users information matching this ID
	 * 
	 * @param id
	 *            to search for user to delete
	 */
	void delete(String id);

}
