package yodes.spring.boot.example.server.client.tests;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import yodes.spring.boot.example.api.UserDto;
import yodes.spring.boot.example.client.UserClient;
import yodes.spring.boot.example.server.TestSetup;

/**
 * Test our client and service by starting up our service and using the client
 * to send HTTP requests at our controller
 * <p>
 * We want to make sure each test can run independently of the others are the
 * order is not guaranteed and each test should pass on its own (or a failure in
 * a previous one cause another test to fail). To do this you shouldn't rely on
 * any previous tests and try to avoid any duplicate calls
 */
public class UserClientTest extends TestSetup {

	/**
	 * Our user client user to test the service
	 */
	private UserClient userClient = new UserClient();

	/**
	 * Test that we can list our users and when we add a extra one our list is
	 * incremented and includes the new user
	 */
	@Test
	public void testList() {
		int userCount = userClient.list().size();
		UserDto myNewUser = userClient.create(createUserDto("Test List user"));
		List<UserDto> users = userClient.list();
		TestCase.assertEquals(userCount + 1, users.size());
		boolean userFound = false;
		for (UserDto user : users) {
			if (myNewUser.getId().equals(user.getId())) {
				userFound = true;
			}
		}
		if (!userFound) {
			TestCase.fail("Created user resource is not found in the list response");
		}
	}

	/**
	 * Test we can retrieve our user by ID
	 */
	@Test
	public void testFindById() {
		UserDto myNewUser = userClient
				.create(createUserDto("Test FindById user"));
		TestCase.assertNotNull(myNewUser.getId());
		UserDto retrievedUser = userClient.findById(myNewUser.getId());
		TestCase.assertNotNull(retrievedUser);
		TestCase.assertEquals("Test FindById user", retrievedUser.getName());
	}

	/**
	 * Test that we can create a new user and we get a user back with the ID set
	 */
	@Test
	public void testCreate() {
		UserDto myNewUser = userClient
				.create(createUserDto("Test Create user"));
		TestCase.assertNotNull(myNewUser);
		TestCase.assertNotNull(myNewUser.getId());
	}

	/**
	 * Test the update works and the returned DTO has the updated information
	 */
	@Test
	public void testUpdate() {
		UserDto myNewUser = userClient
				.create(createUserDto("Test Update user"));
		TestCase.assertNotNull(myNewUser);
		TestCase.assertNotNull(myNewUser.getId());
		myNewUser.setName("Test Updated name");
		UserDto updatedUser = userClient.update(myNewUser);
		TestCase.assertNotNull(updatedUser);
		TestCase.assertEquals(myNewUser.getId(), updatedUser.getId());
		TestCase.assertEquals("Test Updated name", myNewUser.getName());
	}

	/**
	 * Test we can delete a user by Id
	 */
	@Test
	public void testDelete() {
		UserDto myNewUser = userClient
				.create(createUserDto("Test Delete user"));
		TestCase.assertNotNull(myNewUser);
		TestCase.assertNotNull(myNewUser.getId());
		userClient.delete(myNewUser.getId());
		TestCase.assertNull(userClient.findById(myNewUser.getId()));
	}

	/**
	 * Create a user dto object with the name set but no ID. The server will set
	 * this for us
	 * 
	 * @param name
	 *            to set
	 * @return UserDto with name set
	 */
	private UserDto createUserDto(String name) {
		UserDto userDto = new UserDto();
		userDto.setName(name);
		return userDto;
	}

}
