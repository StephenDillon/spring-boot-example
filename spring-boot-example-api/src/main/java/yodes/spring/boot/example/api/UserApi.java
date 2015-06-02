package yodes.spring.boot.example.api;

import java.util.List;

/**
 * The API for user operations
 */
public interface UserApi {

	/**
	 * Lists all users
	 * 
	 * @return List of users as DTO's
	 */
	List<UserDto> list();

	/**
	 * Find a user by ID
	 * 
	 * @param id
	 *            to find
	 * @return Single user resource
	 */
	UserDto findById(String id);

	/**
	 * Create a new user
	 * 
	 * @param userDto
	 *            to create
	 * @return created resource with any new fields set ie. id
	 */
	UserDto create(UserDto userDto);

	/**
	 * Update a user
	 * 
	 * @param userDto
	 *            user dto resource to update
	 * @return UserDto as updated
	 */
	UserDto update(UserDto userDto);

	/**
	 * Delete the user by ID
	 * 
	 * @param id
	 *            to delete
	 */
	void delete(String id);

}
